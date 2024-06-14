package cn.yizhimcqiu.minecraft.utils;

import cn.yizhimcqiu.minecraft.Minecraft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    public static Image resize(Image originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_AREA_AVERAGING);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }
}
