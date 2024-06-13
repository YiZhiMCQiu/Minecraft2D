package cn.yizhimcqiu.minecraft.client.render;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.utils.ThreadUtil;
import cn.yizhimcqiu.minecraft.utils.system.LocalComputerUtil;

import java.awt.*;

public class RenderThread extends Thread {
    public static final int FPS = LocalComputerUtil.getMaxFPS();
    private static final double DELAY = ((1.0 / FPS) * 1000); // 毫秒延迟
    private static int count = 0;
    public int fps = 0;
    private int computeFps(long begin, long now) {
        int useTime = (int) (now - begin);
        if (DELAY - (now - begin) <= 0) { // 判断实际耗时是否大于最大耗时
            return (int) Math.ceil(DELAY / useTime * FPS);
        } else return FPS; // 小于则返回最大FPS
    }
    @Override
    public void run() {
        MainFrame frame = Minecraft.getInstance().frame;
        Minecraft.LOGGER.info("[RenderThread#"+count+"]", "Render Thread started");
        count++;
        while (Minecraft.getInstance().isRunning) {
            long begin = System.currentTimeMillis();
            frame.render();
            ThreadUtil.sleep((long) (DELAY-(System.currentTimeMillis() - begin)));
            fps = computeFps(begin, System.currentTimeMillis());
        }
    }
}
