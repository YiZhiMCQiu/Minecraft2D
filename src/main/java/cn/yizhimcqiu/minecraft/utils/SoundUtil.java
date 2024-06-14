package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundUtil {

    public static void play(SoundPath path) {
        if (!path.isPlaying) {
            new Thread(() -> {
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(path.getAudioStream());
                    path.isPlaying = true;
                    clip.start();
                    ThreadUtil.sleep(clip.getMicrosecondLength() / 1000);
                    clip.close();
                } catch (Exception e) {
                    Minecraft.LOGGER.error("Has something wrong in playing sound!", path.getPath());
                }
            }).start();
        }
    }
}
