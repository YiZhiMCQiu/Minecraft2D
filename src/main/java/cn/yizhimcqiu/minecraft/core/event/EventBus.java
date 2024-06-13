package cn.yizhimcqiu.minecraft.core.event;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    public List<EventListener> listeners = new ArrayList<>();
    public void register(EventListener listener) {
        listeners.add(listener);
    }
    public void post(Event event) {
        listeners.forEach((listener) -> {
            if (listener.isCurrent(event)) {
                listener.onPost(event);
            }
        });
    }
}
