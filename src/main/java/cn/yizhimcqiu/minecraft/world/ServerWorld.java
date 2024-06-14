package cn.yizhimcqiu.minecraft.world;

import cn.yizhimcqiu.minecraft.registries.Blocks;
import cn.yizhimcqiu.minecraft.utils.SoundPath;
import cn.yizhimcqiu.minecraft.world.block.BlockState;
import cn.yizhimcqiu.minecraft.world.pos.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class ServerWorld implements World {
    public final Map<BlockPos, BlockState> blocks = new HashMap<>();
    public ServerWorld() {
        for (int i = 0;i < 20;i++) {
            blocks.put(new BlockPos(i, 2), Blocks.AIR.defaultBlockState());
            blocks.put(new BlockPos(i, 1), Blocks.GRASS_BLOCK.defaultBlockState());
            blocks.put(new BlockPos(i, 0), Blocks.STONE.defaultBlockState());
        }
    }

    @Override
    public BlockState getBlockState(BlockPos pos) {
        return blocks.get(pos);
    }

    @Override
    public BlockState getBlockState(int x, int y) {
        return blocks.get(new BlockPos(x, y));
    }
    public void setBlock(BlockPos pos, BlockState state) {
        if (this.blocks.containsKey(pos)) {
            this.blocks.replace(pos, state);
        } else {
            this.blocks.put(pos, state);
        }
    }
    public SoundPath getSound(Dimension dimension) {
        return switch (dimension) {
            case OVERWORLD -> SoundPath.OTHERSIDE;
            case LEVEL_1 -> SoundPath.PIGSTEP;
            default -> SoundPath.OTHERSIDE;
        };
    }
}
