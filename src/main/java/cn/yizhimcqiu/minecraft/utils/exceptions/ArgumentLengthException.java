package cn.yizhimcqiu.minecraft.utils.exceptions;

public class ArgumentLengthException extends RuntimeException {
    public ArgumentLengthException() {
        super("invalid argument count");
    }
}
