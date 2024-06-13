package cn.yizhimcqiu.minecraft.nbt;

import java.util.HashMap;
import java.util.Map;

public class CompoundTag {
    public final Map<String, Object> tags;

    public CompoundTag(Map<String, Object> tags) {
        this.tags = tags;
    }
    public CompoundTag() {
        this(new HashMap<>());
    }
}
