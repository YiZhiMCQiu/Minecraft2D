package cn.yizhimcqiu.minecraft.world.block;

import cn.yizhimcqiu.minecraft.nbt.CompoundTag;
import cn.yizhimcqiu.minecraft.registries.Blocks;

public class BlockState {
    private Block block;
    private CompoundTag data;
    public BlockState(Block block) {
        this(block, new CompoundTag());
    }
    public BlockState(Block block, CompoundTag data) {
        this.block = block;
        this.data = data;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public CompoundTag getData() {
        return data;
    }

    public void setData(CompoundTag data) {
        this.data = data;
    }
    public static BlockState empty() {
        return new BlockState(Blocks.AIR);
    }

    @Override
    public String toString() {
        return this.getBlock().getProperties().getId();
    }
}
