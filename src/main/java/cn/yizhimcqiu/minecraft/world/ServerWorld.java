package cn.yizhimcqiu.minecraft.world;

import cn.yizhimcqiu.minecraft.world.pos.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class ServerWorld implements World {
    public final Map<BlockPos, BlockState> blocks = new HashMap<>();
    @Override
    public BlockState getBlockState(BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getBlockState(int x, int y, int z) {
        return null;
    }
}
