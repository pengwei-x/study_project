package com.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * @author pengwei
 * @date 2020/12/21
 */
public class BaiscBuffer {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(5);
        ShortBuffer shortBuffer= ShortBuffer.allocate(5);
        for (int i = 0; i <5 ; i++) {
            buffer.put(i);
        }
        //
        //buffer反转，读写切换
        buffer.flip();
        for (int i = 0; i <5 ; i++) {
            System.out.println(buffer.get(i));
        }

        IntBuffer intBuffer = buffer.asReadOnlyBuffer();
        intBuffer.put(111);
        ByteBuffer byteBuffer=ByteBuffer.allocate(5);
        byteBuffer.put("aaa".getBytes());
        String s = new String("周杰");
        System.out.println(s);

    }
}
