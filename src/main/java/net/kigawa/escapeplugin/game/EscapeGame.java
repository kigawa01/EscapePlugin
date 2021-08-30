package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.message.sender.InfoSender;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class EscapeGame {
    public static final String ESCAPE = "escape";
    private static String[] keysStr = new String[]{
            "", "", ""
    };
    int count;
    private List<ItemStack> keys = new ArrayList<>();
    private EscapeData data;
    private List<Player> join;
    private EscapePlugin plugin;
    private GateManager gateManager;
    private boolean isStart;

    public EscapeGame(EscapePlugin escapePlugin, EscapeData escapeData, GateManager gateManager) {
        data = escapeData;
        this.plugin = escapePlugin;
        this.gateManager = gateManager;

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
                            sendMessage("ある日突然、クラスメイトである小川から連絡が来た。");
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
                            sendMessage("小川は、「存在をバレてから、犯人に見つからないようにヒントを残してきた。」とも言っていた。まずはヒントを探すところから始めよう。");
                    }
                }
            }.runTaskTimer(plugin, 10, 50);

            return "";
        }
        return "game can't start";
    }

    public String end() {
        gateManager.resetAllowed();
        isStart = false;
        join.clear();
        keys.clear();
        return "";
    }

    public void sendMessage(String message) {
        new InfoSender(message, join);
    }

    public void save() {
        plugin.getRecorder().save(data, ESCAPE);
    }

    public void inventoryEvent(Inventory inventory) {
        if (inventory.getHolder() instanceof Hopper) {
            Hopper hopper = (Hopper) inventory.getHolder();
            Block block = hopper.getBlock();
            if (block.getX() == data.getHopper()[0] && block.getY() == data.getHopper()[1] && block.getZ() == data.getHopper()[2]) {
                for (ItemStack itemStack : keys) {
                    if (!inventory.contains(itemStack, 1)) {
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

    }

    public String setCommandDoor(int[] door){
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
