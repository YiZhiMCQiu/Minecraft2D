package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import java.net.URL;

public enum TexturePath {

    WINDOW_ICON("misc\\icon.jpg"),
    STONE_BLOCK("block\\stone.png"),

    ;
    public static String requireNonNull(String s) {
        if (Minecraft.class.getClassLoader().getResource(s) == null) {
            Minecraft.LOGGER.error("Resource", s, "is null");
        }
        return s;
    }
    private final String path;
    TexturePath(String path) {
        this.path = "assets\\minecraft\\textures\\"+path;
    }

    public String getPath() {
        return this.path;
    }
    public URL getURL() {
        return Minecraft.class.getClassLoader().getResource(requireNonNull(this.getPath()));
    }
}
