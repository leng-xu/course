package com.king.server.util;

import java.util.UUID;

public class UUIDUtil {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 获取短 UUID
     * 短UUID是根据将32位ID，转为62进制8位ID，减少存储空间。
     * 原理是将UUID转为10进制，再对62取余；也可以添加两个符号，转成64进制。
     */
    public static String getShortUUID() {
        StringBuilder stringBuilder = new StringBuilder();
        String uuid = UUIDUtil.getUUID();
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            stringBuilder.append(chars[x % 0x3E]); // 对62取余
        }
        return stringBuilder.toString();
    }

    /**
     * 获取32位的UUID
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
