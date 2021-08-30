package net.kigawa.escapeplugin.util.plugin.all.world;

import org.bukkit.entity.Player;

public class BlockRegion extends Region {
    private int sX;
    private int sY;
    private int sZ;
    private int eX;
    private int eY;
    private int eZ;

    public BlockRegion(String world, double centerX, double centerY, double centerZ, double width, double height, double length) {
        super(world, centerX, centerY, centerZ, width, height, length);
    }

    public BlockRegion(com.sk89q.worldedit.regions.Region region) {
        super(region);
    }

    public BlockRegion(Player player) {
        super(player);
    }

    @Override
    public void organizeEnds() {
        sX = (int) ((getcX()) - (getWidth() / 2));
        sY = (int) ((getcY()) - (getHeight() / 2));
        sZ = (int) ((getcZ()) - (getLength() / 2));
        eX = (int) ((getcX()) + (getWidth() / 2));
        eY = (int) ((getcY()) + (getHeight() / 2));
        eZ = (int) ((getcZ()) + (getLength() / 2));
    }

    public int[] getCoordinates(){
        return new int[]{
                sX,sY,sZ,eX,eY,eZ
        };
    }
}
