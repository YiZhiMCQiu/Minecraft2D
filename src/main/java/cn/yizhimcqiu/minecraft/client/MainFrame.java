package cn.yizhimcqiu.minecraft.client;

import cn.yizhimcqiu.minecraft.Minecraft;
import cn.yizhimcqiu.minecraft.client.render.Colors;
import cn.yizhimcqiu.minecraft.client.render.RenderThread;
import cn.yizhimcqiu.minecraft.core.GameState;
import cn.yizhimcqiu.minecraft.registries.Blocks;
import cn.yizhimcqiu.minecraft.utils.ImageUtil;
import cn.yizhimcqiu.minecraft.utils.SoundPath;
import cn.yizhimcqiu.minecraft.utils.TexturePath;
import cn.yizhimcqiu.minecraft.utils.system.LocalComputerUtil;
import cn.yizhimcqiu.minecraft.world.block.BlockState;
import cn.yizhimcqiu.minecraft.world.entity.PlayerEntity;
import cn.yizhimcqiu.minecraft.world.pos.BlockPos;
import cn.yizhimcqiu.minecraft.world.pos.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class MainFrame extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int FONT_HEIGHT = 13;
    public static final int BLOCK_LENGTH = 64;
    public static final int MAX_RENDER_BLOCK = 0;
    public JPanel gamePanel;
    public MainFrame() {
        PlayerEntity player = Minecraft.getInstance().player;
        setUndecorated(true);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Minecraft.getInstance().getWindowTitle());
        setIconImage(new ImageIcon(TexturePath.WINDOW_ICON.getURL()).getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'd') {
                    player.setPosition(new Pos(player.getX() + 0.1, player.getY()));
                } else if (e.getKeyChar() == 'a') {
                    player.setPosition(new Pos(player.getX() - 0.1, player.getY()));
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BlockState block;
                if (e.getButton() == MouseEvent.BUTTON1) {
                    block = Blocks.AIR.defaultBlockState();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    block = Blocks.STONE.defaultBlockState();
                } else {
                    block = Blocks.GRASS_BLOCK.defaultBlockState();
                }
                int x = (e.getXOnScreen() - getX()) / 64;
                int y = (LocalComputerUtil.getHeight() / 2 - (e.getYOnScreen() - getY())) / 64;
                Minecraft.getInstance().world.setBlock(new BlockPos(x, y), block);
            }
        });
        gamePanel = new JPanel() {
            Image iBuffer = null;
            Graphics2D gBuffer = null;
            int fps = RenderThread.FPS;
            long lastUpdateFps = 0;
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
                setOpaque(false);
                if (System.currentTimeMillis() - lastUpdateFps >= 1000 && Minecraft.getInstance().state == GameState.READY) {
                    fps = Minecraft.getInstance().getFps();
                    lastUpdateFps = System.currentTimeMillis();
                }
                iBuffer = createImage(this.getWidth(), this.getHeight());
                gBuffer = (Graphics2D) iBuffer.getGraphics();

                gBuffer.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                gBuffer.setColor(Colors.SKY_COLOR);
                gBuffer.setComposite(AlphaComposite.SrcOver);

                gBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());

                gBuffer.setColor(Color.DARK_GRAY);
                try {
                    Minecraft.getInstance().world.blocks.forEach((pos, block) -> {
                        gBuffer.drawImage(block.getBlock().getProperties().getTexture().getImage(), pos.x * BLOCK_LENGTH, getHeight() - (pos.y + 1) * BLOCK_LENGTH, null);
                    });
                } catch (ConcurrentModificationException e) {
                    Minecraft.LOGGER.warn("ConcurrentModificationException at painting!");
                }
                gBuffer.drawImage(ImageUtil.resize(ImageUtil.read(TexturePath.PLAYER), 64, 128), (int) (player.getX()*64), (int) (getHeight() - player.getY()*64-128), null);

                gBuffer.drawString("Minecraft 2D Indev", 0, 15 + 0 * FONT_HEIGHT);
                gBuffer.drawString("FPS: "+fps, 0, 15 + 1 * FONT_HEIGHT);
                gBuffer.drawString(String.valueOf(new Random().nextInt()), 0, 15 + 2 * FONT_HEIGHT);

                graphics.drawImage(iBuffer, 0, 0, this);
                SoundPath.OTHERSIDE.play();
                update(graphics);
            }
        };
        this.add(gamePanel);
        setVisible(true);
        Minecraft.LOGGER.info("Window created");
    }
    public void render() {
        gamePanel.paint(this.getGraphics());
    }
}
