package cn.yizhimcqiu.minecraft.registries;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.world.Block;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;

public class Blocks {
    public static final Block AIR = register("air", new Block(Block.Properties.of(new ResourceLocation("air"))));
    public static final Block STONE = register("stone", new Block(Block.Properties.of(new ResourceLocation("stone"))));
    private static Block register(String id, Block block) {
        ResourceLocation resourceLocation = new ResourceLocation(id);
        Minecraft.getInstance().register(Registries.Type.BLOCK, new DoubleLR(resourceLocation, block));
        return block.onRegister(resourceLocation);
    }
    public static void initialize() {}
}
