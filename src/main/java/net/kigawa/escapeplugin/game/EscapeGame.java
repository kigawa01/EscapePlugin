package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.all.message.sender.InfoSender;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class EscapeGame {
    public static final String ESCAPE = "escape";
    private static String[] keysStr = new String[]{
            "謎のカギ", "迷路のカギ", "アスレのカギ"
    };
    int count;
    int count1;
    private List<ItemStack> keys = new ArrayList<>();
    private EscapeData data;
    private List<Player> join;
    private EscapePlugin plugin;
    private GateManager gateManager;
    private boolean isStart;
    private boolean isSend;
    private final String name;

    public EscapeGame(EscapePlugin escapePlugin, EscapeData escapeData, GateManager gateManager) {
        data = escapeData;
        this.plugin = escapePlugin;
        this.gateManager = gateManager;
        name=plugin.getConfig().getString("name");

        for (String key : keysStr) {
            ItemStack itemStack = new ItemStack(Material.TRIPWIRE_HOOK);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(key);
            itemStack.setItemMeta(itemMeta);
            keys.add(itemStack);
        }

        save();
    }

    public String start() {
        if (!isStart) {
            isStart = true;
            join = plugin.getServer().getWorld(data.getWorld()).getPlayers();

            count = 0;
            new BukkitRunnable() {
                @Override
                public void run() {
                    count++;
                    switch (count) {
                        case 1:
                            sendMessage("ある日突然、クラスメイトである"+name+"から連絡が来た。");
                            break;
                        case 2:
                            sendMessage("話によると、何者かにマイクラサーバーを乗っ取られてしまったらしい。");
                            break;
                        case 3:
                            sendMessage("抵抗を試みたが、犯人に存在をバレてしまい、BANされてしまったようだ。");
                            break;
                        case 4:
                            sendMessage("代わりにこんなことをした犯人をBANして欲しいとのこと。");
                            break;
                        case 5:
                            sendMessage(name+"は、「存在をバレてから、犯人に見つからないようにヒントを残してきた。」とも言っていた。まずはヒントを探すところから始めよう。");
                            cancel();
                    }
                }
            }.runTaskTimer(plugin, 10, 50);

            return "";
        }
        return "game can't start";
    }

    public String end() {
        Location spawn=plugin.getServer().getWorld(data.getWorld()).getSpawnLocation();
        for (Player player : join) {
            player.teleport(spawn);
        }

        Location door = new Location(plugin.getServer().getWorld(data.getWorld()), data.getCommandDoor()[0], data.getCommandDoor()[1], data.getCommandDoor()[2]);
        Block block = door.getBlock();
        block.setType(Material.SMOOTH_STONE);
        block.getRelative(BlockFace.UP).setType(Material.SMOOTH_STONE);

        Block block1 = new Location(plugin.getServer().getWorld(data.getWorld()), data.getHopper()[0], data.getHopper()[1], data.getHopper()[2]).getBlock();
        if (block1.getState() instanceof Hopper) {
            Hopper hopper = (Hopper) block1.getState();
            hopper.getInventory().clear();
        }

        gateManager.resetAllowed();
        isStart = false;
        join.clear();
        keys.clear();
        isSend=false;
        return "";
    }

    public void sendMessage(String message) {
        new InfoSender("",join);
        new InfoSender(message, join);
    }

    public void save() {
        plugin.getRecorder().save(data, ESCAPE);
    }

    public void interactEvent(PlayerInteractEvent event) {
        plugin.logger("interact event");
        if (event.getClickedBlock() != null && event.getClickedBlock().getType().equals(Material.COMMAND_BLOCK)) {
            plugin.logger("if (event.getClickedBlock() instanceof CommandBlock) ");
            if (isStart&&!isSend) {
                count1 = 0;
                isSend=true;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        count1++;
                        switch (count1) {
                            case 1:
                                sendMessage("犯人を捕まえBANする為に、僕達は犯人の仕掛けた謎をクリアしてきた。");
                                break;
                            case 2:
                                sendMessage("やっとの思いで見つけ出したコマンドブロックに触れようとしたその時、誰かの声が聞こえてくる。");
                                break;
                            case 3:
                                sendMessage("この声は、僕達に犯人のBANを依頼し、サポートしてくれた彼—— ——"+name+"の声だった。");
                                break;
                            case 4:
                                sendMessage("『BANされたんじゃないの？』 『なんでここに？』 と、色々な考えが湧いてくる。");
                                break;
                            case 5:
                                sendMessage("僕達が困惑していると、向こうから話しかけてきた。");
                                break;
                            case 6:
                                sendMessage(ChatColor.BLUE + "「ここは僕が作ったみんなにゲームをしてもらう為のサーバだよ」");
                                break;
                            case 7:
                                sendMessage("理解が追いつかない。");
                                break;
                            case 8:
                                sendMessage("しかし、こちらの事など意にも介さず、"+name+"は話を続ける。");
                                break;
                            case 9:
                                sendMessage(ChatColor.BLUE + "「寂しかったからノリで作ってたら途中から熱が入って....」");
                                break;
                            case 10:
                                sendMessage(ChatColor.BLUE + "「そこそこのボリュームになったから折角だし、みんなに遊んで貰おうかなって思って」");
                                break;
                            case 11:
                                sendMessage(ChatColor.GOLD + "「……ってことは、今までのことは全部、嘘？」");
                                break;
                            case 12:
                                sendMessage(ChatColor.BLUE + "「そうなるね」");
                                break;
                            case 13:
                                sendMessage(ChatColor.BLUE + "「みんなクラスサーバーに全然来てくれないから、何かきっかけがあればいいかなって」");
                                break;
                            case 14:
                                sendMessage(".......");
                                break;
                            case 15:
                                sendMessage("....");
                                break;
                            case 16:
                                sendMessage("..");
                                end();
                                cancel();
                        }
                    }
                }.runTaskTimer(plugin, 10, 50);

            }
        }
    }

    public void inventoryEvent(Inventory inventory) {
        plugin.logger("inventory event");
        if (inventory.getHolder() instanceof Hopper && isStart) {
            plugin.logger("if (inventory.getHolder() instanceof Hopper)");
            Hopper hopper = (Hopper) inventory.getHolder();
            Block block = hopper.getBlock();
            if (block.getX() == data.getHopper()[0] && block.getY() == data.getHopper()[1] && block.getZ() == data.getHopper()[2]) {
                plugin.logger("if (block.getX() == data.getHopper()[0] && block.getY() == data.getHopper()[1] && block.getZ() == data.getHopper()[2]) {");
                for (String name : keysStr) {
                    plugin.logger(name);
                    if (!PluginUtil.containInInventory(inventory, name, Material.TRIPWIRE_HOOK)) {
                        plugin.logger("if (!inventory.contains(itemStack, 1)) {");
                        return;
                    }
                }
                openCommandRoom();
            }
        }
    }

    public void closeEvent(InventoryCloseEvent event) {
        inventoryEvent(event.getInventory());
    }

    public void pickupEvent(InventoryPickupItemEvent event) {
        inventoryEvent(event.getInventory());
    }

    public void openCommandRoom() {
        Location door = new Location(plugin.getServer().getWorld(data.getWorld()), data.getCommandDoor()[0], data.getCommandDoor()[1], data.getCommandDoor()[2]);
        Block block = door.getBlock();
        block.setType(Material.AIR);
        block.getRelative(BlockFace.UP).setType(Material.AIR);
        PluginUtil.playSound(join, Sound.BLOCK_PISTON_EXTEND,10,1);

    }

    public String setCommandDoor(int[] door) {
        data.setCommandDoor(door);
        save();
        return "set door";
    }

    public String setWorld(String world) {
        data.setWorld(world);
        save();
        return "set world";
    }

    public String setHopper(int[] loc) {
        data.setHopper(loc);
        save();
        return "set hopper loc";
    }

    public String getName() {
        return data.getName();
    }

    public EscapePlugin getPlugin() {
        return plugin;
    }
}
