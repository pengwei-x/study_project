package com.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 可以让文件直接在内存（堆外内存）修改，操作系统不需要拷贝一次
 * @author pengwei
 * @date 2020/12/22
 */
public class MappedByteBuffer {
    public static void main(String[] args) {


        try {
//            FileInputStream fileInputStream = new FileInputStream("b.txt");
//            FileChannel inputStreamChannel = fileInputStream.getChannel();

            RandomAccessFile randomAccessFile = new RandomAccessFile("b.txt", "rw");
            FileChannel channel = randomAccessFile.getChannel();
            java.nio.MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
            mappedByteBuffer.put(1, (byte) 'P');
            randomAccessFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
