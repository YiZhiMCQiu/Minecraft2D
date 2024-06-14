package cn.yizhimcqiu.minecraft.world.pos;

public class BlockPos {
    public int x;
    public int y;

    public BlockPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pos pos() {
        return new Pos(x, y);
    }
    public BlockPos down() {
        if (this.y == 0) {
            return this;
        }
        return new BlockPos(x, y-1);
    }

    @Override
    public String toString() {
        return "BlockPos{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
