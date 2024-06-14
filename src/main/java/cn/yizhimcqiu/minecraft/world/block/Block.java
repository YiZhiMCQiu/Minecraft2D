package cn.yizhimcqiu.minecraft.world.block;

import cn.yizhimcqiu.minecraft.registries.RegisterAble;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;
import cn.yizhimcqiu.minecraft.utils.TexturePath;

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
    public BlockState defaultBlockState() {
        return new BlockState(this);
    }

    public static class Properties {
        private String id;
        private TexturePath texture;

        public Properties(String id, TexturePath texture) {
            this.id = id;
            this.texture = texture;
        }

        public static Properties of(ResourceLocation location) {
            return new Properties(location.toString(), TexturePath.STONE_BLOCK);
        }

        public String getId() {
            return id;
        }

        public TexturePath getTexture() {
            return texture;
        }
    }
}
