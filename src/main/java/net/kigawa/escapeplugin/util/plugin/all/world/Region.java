package net.kigawa.escapeplugin.util.plugin.all.world;

public class Region {
    int sX;
    int sY;
    int sZ;
    int eX;
    int eY;
    int eZ;
    String world;

    public Region(com.sk89q.worldedit.regions.Region region) {
        world = region.getWorld().getName();
        sX = ((int) region.getCenter().getX()) - (region.getWidth() / 2);
        sY = ((int) region.getCenter().getY()) - (region.getHeight() / 2);
        sZ = ((int) region.getCenter().getZ()) - (region.getLength() / 2);
        eX = ((int) region.getCenter().getX()) + (region.getWidth() / 2);
        eY = ((int) region.getCenter().getY()) + (region.getHeight() / 2);
        eZ = ((int) region.getCenter().getZ()) + (region.getLength() / 2);
        sX++;sY++;sZ++;
        eX++;eY++;eZ++;
    }
    public int[] getCoordinate(){
        return new int[]{sX,sY,sZ,eX,eY,eZ};
    }
    public String getWorld(){
        return world;
    }
}