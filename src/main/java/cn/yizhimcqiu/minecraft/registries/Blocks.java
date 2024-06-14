package cn.yizhimcqiu.minecraft.registries;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.utils.TexturePath;
import cn.yizhimcqiu.minecraft.world.block.Block;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;

public class Blocks {
    public static final Block AIR = register("air", new Block(new Block.Properties("minecraft:air", TexturePath.AIR)));
    public static final Block STONE = register("stone", new Block(new Block.Properties("minecraft:stone", TexturePath.STONE_BLOCK)));
    public static final Block GRASS_BLOCK = register("grass_block", new Block(new Block.Properties("minecraft:grass_block", TexturePath.GRASS_BLOCK)));
    private static Block register(String id, Block block) {
        ResourceLocation resourceLocation = new ResourceLocation(id);
        Minecraft.getInstance().register(Registries.Type.BLOCK, new DoubleLR(resourceLocation, block));
        return block.onRegister(resourceLocation);
    }
    public static void initialize() {}
}
