package cn.yizhimcqiu.minecraft.utils.codec.block;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.registries.Registries;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;
import cn.yizhimcqiu.minecraft.world.block.Block;
import cn.yizhimcqiu.minecraft.world.block.BlockState;

public class BlockStateCodec {
    public static String encode(BlockState state) {
        String id = state.getBlock().getProperties().getId();
        String nbt = "";
        return id+"~"+nbt;
    }
    public static BlockState decode(String s) {
        ResourceLocation location = ResourceLocation.parse(s.split("~")[0]);
        // System.out.println(Minecraft.getInstance().getRegistered(Registries.Type.BLOCK, location).getClass().getSimpleName());
        if (Minecraft.getInstance().getRegistered(Registries.Type.BLOCK, location) instanceof Block block) {
            return new BlockState(block);
        } else {
            Minecraft.LOGGER.warn("BlockStateCodec find no Block "+location+"!");
            return BlockState.empty();
        }
    }
}
