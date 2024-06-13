package cn.yizhimcqiu.minecraft.world;

import cn.yizhimcqiu.minecraft.registries.RegisterAble;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;

public class Block implements RegisterAble<Block> {
    private Properties properties;
    public Block(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public Block onRegister(ResourceLocation resourceLocation) {
        return this;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public static class Properties {
        private String id;

        public Properties(String id) {
            this.id = id;
        }

        public static Properties of(ResourceLocation location) {
            return new Properties(location.toString());
        }

        public String getId() {
            return id;
        }
    }
}
