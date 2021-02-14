package com.bio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pengwei
 * @date 2020/12/21
 */
public class BioClient {
    public static void main(String[] args) {
        try {
            //请求和服务器建立连接 三次握手的起点
            Socket socket = new Socket("127.0.0.1", 6000);
            //发送信息
            OutputStream outputStream = socket.getOutputStream();


            //接收信息
            //InputStream inputStream = socket.getInputStream();


            InputStream inputStream = new FileInputStream("/Users/pengwei/local/code/online_education/netty-project/a.txt");
            while (true) {
                if (!socket.isClosed()) {
//                    Scanner scanner = new Scanner(System.in);
//                    String s1 = scanner.nextLine();
//                    outputStream.write(s1.getBytes());
//                    outputStream.flush();
                    byte[] bytes = new byte[1024];

                    int read = inputStream.read(bytes);
                    if (read==-1){
                        System.out.println("客户端结束");
                        break;
                    }
                    outputStream.write(bytes,0,read);
                    outputStream.flush();
                } else {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
