package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public enum SoundPath {
    PIGSTEP("pigstep.wav"),
    OTHERSIDE("otherside.wav")
    ;
    public static String requireNonNull(String s) {
        if (Minecraft.class.getClassLoader().getResource(s) == null) {
            Minecraft.LOGGER.error("Resource", s, "is null");
        }
        return s;
    }
    private final String path;
    private AudioInputStream ais = null;
    boolean isPlaying = false;
    SoundPath(String path) {
        this.path = "assets\\minecraft\\sounds\\"+path;
        try {
            this.ais = AudioSystem.getAudioInputStream(Minecraft.class.getClassLoader().getResource(this.path));
        } catch (UnsupportedAudioFileException e) {
            Minecraft.LOGGER.error("File", path, "is unsupported!");
        } catch (IOException e) {
            Minecraft.LOGGER.error("Cannot find", path+"!");
        }
    }

    public String getPath() {
        return this.path;
    }
    public URL getURL() {
        return Minecraft.class.getClassLoader().getResource(requireNonNull(this.getPath()));
    }
    public void play() {
        SoundUtil.play(this);
    }
    public AudioInputStream getAudioStream() {
        return this.ais;
    }
}
