package cn.yizhimcqiu.minecraft.world.entity;

import cn.yizhimcqiu.minecraft.utils.TickAble;
import cn.yizhimcqiu.minecraft.world.ServerWorld;
import cn.yizhimcqiu.minecraft.world.pos.Pos;

import java.util.UUID;

public abstract class Entity implements TickAble {
    protected final UUID uuid;
    protected double maxHealth;
    protected double health;
    protected Pos position;
    protected String displayName;
    protected ServerWorld world;

    public Entity(ServerWorld world, Pos position, double maxHealth, String displayName) {
        this.uuid = UUID.randomUUID();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.position = position;
        this.displayName = displayName;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Pos getPosition() {
        return position;
    }

    public void setPosition(Pos position) {
        this.position = position;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public abstract EntityType getType();
    public double getX() {
        return this.getPosition().x;
    }
    public double getY() {
        return this.getPosition().y;
    }
}
