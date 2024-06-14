package cn.yizhimcqiu.minecraft.world.pos;

public class Pos {
    public double x;
    public double y;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public BlockPos blockPos() {
        return new BlockPos((int) x, (int) y);
    }
}
