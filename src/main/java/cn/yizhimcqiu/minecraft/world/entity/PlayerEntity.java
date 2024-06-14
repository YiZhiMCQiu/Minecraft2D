package cn.yizhimcqiu.minecraft.world.entity;

import cn.yizhimcqiu.minecraft.registries.Blocks;
import cn.yizhimcqiu.minecraft.world.ServerWorld;
import cn.yizhimcqiu.minecraft.world.pos.Pos;

public final class PlayerEntity extends Entity {
    private GameMode gameMode;
    public PlayerEntity(ServerWorld world, Pos position) {
        super(world, position, 20, "Player");
    }

    @Override
    public EntityType getType() {
        return new EntityType(getClass());
    }

    @Override
    public void setPosition(Pos position) {
        super.setPosition(position);
    }

    @Override
    public void tick() {
        if (this.gameMode == GameMode.SURVIVAL && this.world.getBlockState(this.position.blockPos().down()).getBlock() == Blocks.AIR) {
            this.position.x -= 0.1;
        }
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public enum GameMode {
        CREATIVE, SURVIVAL
    }
}
