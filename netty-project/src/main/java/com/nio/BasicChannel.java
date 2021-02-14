package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * @author pengwei
 * @date 2020/12/22
 */
public class BasicChannel {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("c.txt");
            FileInputStream  fileInputStream= new FileInputStream("b.txt");
            FileChannel inputStreamChannel = fileInputStream.getChannel();

            FileChannel outputChannel = outputStream.getChannel();


            //拷贝
             outputChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
