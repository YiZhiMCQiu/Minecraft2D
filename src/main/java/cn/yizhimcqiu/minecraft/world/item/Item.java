package cn.yizhimcqiu.minecraft.world.item;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.registries.RegisterAble;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;

public class Item implements RegisterAble<Item> {
    private Properties properties;

    public Item(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Item onRegister(ResourceLocation resourceLocation) {
        Minecraft.LOGGER.info("[RegisterThread #Item]", "Registered Item: "+resourceLocation);
        return this;
    }
    public static class Properties {
        public static Item.Properties of() {
            return new Item.Properties();
        }
    }
}
