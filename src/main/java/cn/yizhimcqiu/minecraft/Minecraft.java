package cn.yizhimcqiu.minecraft;

import cn.yizhimcqiu.minecraft.client.MainFrame;
import cn.yizhimcqiu.minecraft.client.render.RenderThread;
import cn.yizhimcqiu.minecraft.core.GameProfile;
import cn.yizhimcqiu.minecraft.core.GameState;
import cn.yizhimcqiu.minecraft.core.ResourceLocation;
import cn.yizhimcqiu.minecraft.core.event.EventBus;
import cn.yizhimcqiu.minecraft.core.event.RegisterEvent;
import cn.yizhimcqiu.minecraft.registries.Blocks;
import cn.yizhimcqiu.minecraft.registries.DoubleLR;
import cn.yizhimcqiu.minecraft.registries.RegisterAble;
import cn.yizhimcqiu.minecraft.registries.Registries;
import cn.yizhimcqiu.minecraft.utils.*;
import cn.yizhimcqiu.minecraft.world.ServerWorld;
import cn.yizhimcqiu.minecraft.world.entity.PlayerEntity;
import cn.yizhimcqiu.minecraft.world.pos.Pos;

import java.util.*;

public class Minecraft {
    public static final Logger LOGGER = new Logger("Minecraft");
    public final MainFrame frame;
    public final EventBus eventBus;
    public GameState state;
    private static Minecraft instance = null;
    public Map<Registries.Type, List<DoubleLR>> registered = new HashMap<>();
    public GameProfile profile;
    public long tick = 0;
    public final List<TickAble> tickAbles = new ArrayList<>();
    public boolean isRunning = true;
    public RenderThread renderThread;
    public PlayerEntity player;
    public static Minecraft getInstance() {
        return instance;
    }
    public ServerWorld world;
    public Minecraft(GameProfile profile) throws Exception {
        if (instance != null) {
            LOGGER.warn("A second Minecraft object was created");
        }
        this.state = GameState.LAUNCHING;
        this.profile = profile;
        this.eventBus = new EventBus();
        this.launch();
        instance = this;
        this.state = GameState.REGISTERING;
        LOGGER.info("Registering");
        Registries.init();
        this.eventBus.post(new RegisterEvent());
        this.world = new ServerWorld();
        LOGGER.info("Register successfully");
        this.player = new PlayerEntity(world, new Pos(0, 2));
        this.frame = new MainFrame();
        this.renderThread = new RenderThread();
        this.renderThread.start();
        this.state = GameState.READY;
    }
    public void register(Registries.Type type, DoubleLR lr) {
        if (this.state != GameState.REGISTERING) return;
        Minecraft.LOGGER.info("[RegisterThread #"+type+"]", "Registered Block: "+lr.location);
        registered.get(type).add(lr);
    }
    public RegisterAble<?> getRegistered(Registries.Type type, ResourceLocation location) {
        RegisterAble<?> result = DoubleLR.get(registered.get(type), location);
        if (result == null) {
            LOGGER.warn("Find not registered ResourceLocation", location+"!");
            return RegisterAble.defaultValue();
        }
        return result;
    }
    public void tick() {
        if (this.state == GameState.CRASHED) isRunning = false;
        tick++;
        tickAbles.forEach((TickAble::tick));
    }
    public void launch() {
        registerEventListeners();
    }
    public void registerEventListeners() {

    }
    public int getFps() {
        return this.renderThread.fps;
    }
    public String getWindowTitle() {
        return this.profile.windowTitle;
    }
}
