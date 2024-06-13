package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Logger {
    private final String name;

    public Logger(String name) {
        this.name = name;
    }
    private void out(PrintStream stream, String[] text, String rf) {
        StringBuilder textBuilder = new StringBuilder();
        for (String s : text) {
            textBuilder.append(s).append(" ");
        }
        stream.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date())+"] ["+this.name+"/"+rf+"] "+ textBuilder);
    }
    public void info(String... msg) {
        out(System.out, msg, "INFO");
    }
    public void warn(String... msg) {
        out(System.out, msg, "WARN");
    }
    public void error(String... msg) {
        out(System.err, msg, "ERROR");
    }
}
