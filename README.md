# Minecraft 2D
**!!!此项目未经Mojang许可，与Mojang无任何关联!!!**
**!!!This project is not endorsed by Mojang and is not affiliated with Mojang in any way!!!**
***
Languarge: Java<br>
Author: YiZhiMCQiu<br>
一个~~作者闲的没事写着玩的~~2D游戏，与Minecraft相似，目前是测试版 ~~(某些狗别喷)~~<br>
<br>
事件监听器(EventListener)用法:<br>Minecraft.java

```java
import cn.yizhimcqiu.minecraft.core.event.EventListener;

class Minecraft {
    // ...
    public void registerEventListeners() {
        this.eventBus.register(new EventListener() {
            // 判断是否为指定类型的事件
            @Override
            public boolean isCurrent(Event event) {
                return event instanceof 指定事件;
            }
            // 当事件被发布时
            @Override
            public void onPost(Event evt) {
                指定事件 event = (指定事件) evt;
                // ...
            }
        });
    }
}
```
