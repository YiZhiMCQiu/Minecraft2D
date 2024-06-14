package cn.yizhimcqiu.minecraft.world;

import cn.yizhimcqiu.minecraft.world.block.BlockState;
import cn.yizhimcqiu.minecraft.world.pos.BlockPos;

public interface World {
    BlockState getBlockState(BlockPos pos);
    BlockState getBlockState(int x, int y);
}
