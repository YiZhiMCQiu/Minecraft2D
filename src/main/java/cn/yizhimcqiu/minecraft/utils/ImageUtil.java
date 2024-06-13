package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageUtil {
    public static Image read(TexturePath path) {
        try {
            return ImageIO.read(Minecraft.class.getClassLoader().getResource(path.getPath()));
        } catch (IOException e) {
            Minecraft.LOGGER.error(e.getMessage());
        } catch (IllegalArgumentException iae) {
            Minecraft.LOGGER.error("Cannot find", path.getPath()+"!");
        }
        return null;
    }
    public static Image drawTexture(TexturePath path) {
        return null;
    }
}
