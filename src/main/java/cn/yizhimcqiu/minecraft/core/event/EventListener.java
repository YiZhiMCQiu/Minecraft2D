package cn.yizhimcqiu.minecraft.core.event;

public interface EventListener {
    boolean isCurrent(Event event);
    void onPost(Event event);
}
