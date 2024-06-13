package cn.yizhimcqiu.minecraft.registries;

import cn.yizhimcqiu.minecraft.core.ResourceLocation;

import java.util.List;

public class DoubleLR {
    public ResourceLocation location;
    public RegisterAble<?> registerAble;

    public DoubleLR(ResourceLocation location, RegisterAble<?> registerAble) {
        this.location = location;
        this.registerAble = registerAble;
    }

    public static RegisterAble<?> get(List<DoubleLR> list, ResourceLocation location) {
        for (DoubleLR lr : list) {
            System.out.println(lr);
            if (lr.location.equals(location)) {
                return lr.registerAble;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return location.toString();
    }
}
