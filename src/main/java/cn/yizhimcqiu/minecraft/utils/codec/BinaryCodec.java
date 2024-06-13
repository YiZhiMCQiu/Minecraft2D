package cn.yizhimcqiu.minecraft.utils.codec;

public class BinaryCodec {
    public static String encode(String str) {
        char[] strChar = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : strChar) {
            result.append(Integer.toBinaryString(c)).append(" ");
        }
        return result.toString();
    }
    public static String decode(String str) {
        String[] tempStr = str.split(" ");
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = binStringToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }
    private static int[] binStringToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i] - 48;
        }
        return result;
    }
    private static char binStringToChar(String binStr) {
        int[] temp = binStringToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[temp.length-1-i] << i;
        }
        return (char) sum;
    }
}
