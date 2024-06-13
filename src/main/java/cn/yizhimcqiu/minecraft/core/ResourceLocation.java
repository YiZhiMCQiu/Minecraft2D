package cn.yizhimcqiu.minecraft.core;

import java.util.Objects;

public class ResourceLocation {
    private final String parent;
    private final String path;
    public ResourceLocation(String path) {
        this("minecraft", path);
    }
    public ResourceLocation(String parent, String path) {
        this.parent = parent;
        this.path = path;
    }

    public String getParent() {
        return parent;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return parent + ":" + path;
    }
    public static ResourceLocation parse(String s) {
        return new ResourceLocation(s.split(":")[0], s.split(":")[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceLocation that)) return false;
        return Objects.equals(parent, that.parent) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, path);
    }
}
