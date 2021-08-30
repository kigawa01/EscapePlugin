package net.kigawa.escapeplugin.util.plugin.all.world;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerRegion {
    int sX;
    int sY;
    int sZ;
    int eX;
    int eY;
    int eZ;
    double cX;
    double cY;
    double cZ;
    double width;
    double height;
    double length;
    String world;

    public PlayerRegion(String world, double centerX, double centerY, double centerZ, double width, double height, double length) {
        this.world = world;
        this.cX = centerX;
        this.cY = centerY;
        this.cZ = centerZ;
        this.width = width;
        this.height = height;
        this.length = length;
        organizeEnds();
    }

    public PlayerRegion(com.sk89q.worldedit.regions.Region region) {
        world = region.getWorld().getName();
        cX = region.getCenter().getX();
        cY = region.getCenter().getY();
        cZ = region.getCenter().getZ();
        width = region.getWidth();
        height = region.getHeight();
        length = region.getLength();
        organizeEnds();
    }

    public void organizeEnds() {
        sX = (int) ((cX) - (width / 2));
        sY = (int) ((cY) - (height / 2));
        sZ = (int) ((cZ) - (length / 2));
        eX = (int) ((cX) + (width / 2));
        eY = (int) ((cY) + (height / 2));
        eZ = (int) ((cZ) + (length / 2));
        if (sX < 0) sX--;
        if (sY < 0) sY--;
        if (sZ < 0) sZ--;
        if (eX >= 0) eX++;
        if (eY >= 0) eY++;
        if (eZ >= 0) eZ++;
    }

    public int[] getCoordinate() {
        return new int[]{sX, sY, sZ, eX, eY, eZ};
    }

    public String getWorld() {
        return world;
    }

    public boolean contain(Player player) {
        Location loc = player.getLocation();
        if (sX <= loc.getX() && loc.getX() <= eX) {
            if (sY <= loc.getY() && loc.getY() <= eY) {
                if (sZ <= loc.getZ() && loc.getZ() <= eZ) {
                    return true;
                }
            }
        }
        return false;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getcZ() {
        return cZ;
    }

    public double getcY() {
        return cY;
    }

    public double getcX() {
        return cX;
    }

    public int getsZ() {
        return sZ;
    }

    public int getsY() {
        return sY;
    }

    public int getsX() {
        return sX;
    }

    public int geteZ() {
        return eZ;
    }

    public int geteY() {
        return eY;
    }

    public int geteX() {
        return eX;
    }
}