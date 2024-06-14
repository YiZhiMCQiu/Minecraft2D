package cn.yizhimcqiu.minecraft.core;

public class GameProfile {
    public String name;
    public String windowTitle;
    public boolean demo;
    public long version;
    public GameProfile(String name, String windowTitle, boolean demo, long version) {
        this.name = name;
        this.windowTitle = windowTitle;
        this.demo = demo;
        this.version = version;
    }

    @Override
    public String toString() {
        return "GameProfile{" +
                "name='" + name + '\'' +
                ", windowTitle='" + windowTitle + '\'' +
                ", demo=" + demo +
                ", version=" + version +
                '}';
    }
}
