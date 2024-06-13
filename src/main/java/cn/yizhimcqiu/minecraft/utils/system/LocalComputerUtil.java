package cn.yizhimcqiu.minecraft.utils.system;

import java.awt.*;

public class LocalComputerUtil {
    public static int getMaxFPS() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    }
}
