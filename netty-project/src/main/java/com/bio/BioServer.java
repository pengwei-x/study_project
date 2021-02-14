package com.bio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Bio 服务器端
 *
 * @author pengwei
 * @date 2020/12/21
 */
public class BioServer {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        try {
            //telnet 127.0.0.1 6000
            ServerSocket serverSocket=new ServerSocket(6000);
            System.out.println("服务器端口"+serverSocket.getLocalPort()+"启动");

            while (true){
                //监听，等地啊
                Socket socket= serverSocket.accept();
                //创建线程与之通信
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        byte[] bytes = new byte[1024];
                        try {
                             OutputStream fileOutputStream = new FileOutputStream("b.txt");
                            while (true){
                                InputStream inputStream = socket.getInputStream();
                                int read = inputStream.read(bytes);
                                if (read==-1){ break;}
                                fileOutputStream.write(bytes,0,read);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
