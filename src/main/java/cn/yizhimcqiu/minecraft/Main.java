package cn.yizhimcqiu.minecraft;

import cn.yizhimcqiu.minecraft.client.render.MainFrame;
import cn.yizhimcqiu.minecraft.client.render.RenderThread;
import cn.yizhimcqiu.minecraft.core.GameProfile;
import cn.yizhimcqiu.minecraft.core.GameState;

public class Main {
    public static final GameProfile TEST_PROFILE = new GameProfile("YiZhiMCQiu", "awa", false, 0x0);
    public static void main(String[] args) throws Exception {
        new Minecraft(TEST_PROFILE);
        try {
            while (Minecraft.getInstance().isRunning) {
                Minecraft.getInstance().tick();
            }
            Minecraft.LOGGER.info("Stopping!");
        } catch (Exception e) {
            e.printStackTrace();
            Minecraft.getInstance().state = GameState.CRASHED;
        }
    }
}