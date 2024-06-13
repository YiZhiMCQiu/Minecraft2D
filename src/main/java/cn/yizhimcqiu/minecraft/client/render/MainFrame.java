package cn.yizhimcqiu.minecraft.client.render;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.utils.ImageUtil;
import cn.yizhimcqiu.minecraft.utils.TexturePath;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public JPanel gamePanel;
    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Minecraft");
        setIconImage(new ImageIcon(TexturePath.WINDOW_ICON.getURL()).getImage());
        gamePanel = new JPanel() {
            Image iBuffer = null;
            Graphics gBuffer = null;
            @Override
            public void update(Graphics g) {
                if (iBuffer == null) {
                    iBuffer = createImage(MainFrame.WIDTH, MainFrame.HEIGHT);
                    Graphics gOff = iBuffer.getGraphics();
                    paint(gOff);
                    g.drawImage(iBuffer, 0, 0, null);
                }
            }

            @Override
            public void paint(Graphics graphics) {
                if (iBuffer == null) {
                    iBuffer = createImage(MainFrame.WIDTH, MainFrame.HEIGHT);
                    gBuffer = iBuffer.getGraphics();
                }
                // 设置Graphics初始值
                graphics.setFont(new Font("隶书", Font.PLAIN, 20));
                graphics.setColor(Color.black);
                gBuffer.setColor(Colors.SKY_COLOR);
                // 使用双缓冲绘制背景
                gBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
                // 使用黑色绘制FPS
                gBuffer.setColor(Color.black);
                gBuffer.drawString(String.valueOf(Minecraft.getInstance().getFps()), 100, 100);
                gBuffer.drawImage(ImageUtil.read(TexturePath.STONE_BLOCK), 100, 200, null);
                graphics.drawImage(iBuffer, 0, 0, this);
                update(graphics);
            }
        };
        this.add(gamePanel);
        setVisible(true);
        Minecraft.LOGGER.info("Window created");
    }
    public void render() {
        gamePanel.paint(this.getGraphics());
        this.getGraphics().fillRect(0, 0, 100, 100);
    }
}
