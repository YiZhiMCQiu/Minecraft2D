package cn.yizhimcqiu.minecraft.registries;

import cn.yizhimcqiu.minecraft.core.ResourceLocation;

public interface RegisterAble<T> {
    T onRegister(ResourceLocation resourceLocation);
    static RegisterAble<Void> defaultValue() {
        return resourceLocation -> null;
    }
}
