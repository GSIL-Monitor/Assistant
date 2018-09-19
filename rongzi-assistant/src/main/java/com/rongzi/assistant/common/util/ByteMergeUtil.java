package com.rongzi.assistant.common.util;

public class ByteMergeUtil {

    public static byte[] byteMergerAll(byte[]... values) {
        int lengthByte = 0;
        for (int i = 0; i < values.length; i++) {
            lengthByte += values[i].length;
        }
        byte[] allByte = new byte[lengthByte];
        int countLength = 0;
        for (int i = 0; i < values.length; i++) {
            byte[] b = values[i];
            System.arraycopy(b, 0, allByte, countLength, b.length);
            countLength += b.length;
        }
        return allByte;
    }

}
