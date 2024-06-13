package cn.yizhimcqiu.minecraft.utils;

public class ThreadUtil {
    public static void sleep(long millis) {
        if (millis <= 0) return;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }
}
