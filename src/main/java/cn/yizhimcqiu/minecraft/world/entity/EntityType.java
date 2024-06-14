package cn.yizhimcqiu.minecraft.world.entity;

public class EntityType {
    private final Class<? extends Entity> type;
    protected EntityType(Class<? extends Entity> clazz) {
        this.type = clazz;
    }
    public boolean isInstanceof(Entity entity) {
        return entity.getClass() == type;
    }
}
