package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import java.awt.*;
import java.net.URL;

public enum TexturePath {

    WINDOW_ICON("misc\\icon.png"),
    STONE_BLOCK("block\\stone.png", true),
    GRASS_BLOCK("block\\grass.png", true),
    AIR("block\\air.png", true),
    PLAYER("entity\\player\\player_default.png")
    ;
    public static String requireNonNull(String s) {
        if (Minecraft.class.getClassLoader().getResource(s) == null) {
            Minecraft.LOGGER.error("Resource", s, "is null");
        }
        return s;
    }
    private final String path;
    private final Image image;
    TexturePath(String path) {
        this(path, false);
    }
    TexturePath(String path, boolean scaleTo64x) {
        Image image1;
        this.path = "assets\\minecraft\\textures\\"+path;
        image1 = ImageUtil.read(this);
        if (scaleTo64x) {
            image1 = ImageUtil.resize(image1, 64, 64);
            Minecraft.LOGGER.info("Resize image", this.path, "to 64x");
        }
        this.image = image1;
    }

    public String getPath() {
        return this.path;
    }
    public URL getURL() {
        return Minecraft.class.getClassLoader().getResource(requireNonNull(this.getPath()));
    }
    public Image getImage() {
        return this.image;
    }
}
