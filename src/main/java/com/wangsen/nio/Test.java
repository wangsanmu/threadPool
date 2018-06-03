package com.wangsen.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangsen
 * @data 2018/4/18 15:46
 * @des
 */
public class Test {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            String string = "java nio";
            byteBuffer.put(string.getBytes());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            fileChannel.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
