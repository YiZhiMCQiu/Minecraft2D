package cn.yizhimcqiu.minecraft.registries;

import cn.yizhimcqiu.minecraft.Minecraft;

import java.util.ArrayList;

public class Registries {
    public static void init() {
        Minecraft.getInstance().registered.put(Type.BLOCK, new ArrayList<>());
        Blocks.initialize();
    }
    public enum Type {
        BLOCK, ITEM, ENTITY, CREATIVE_MODE_TAB, GAME_MODE, JSON_READER
    }
}
