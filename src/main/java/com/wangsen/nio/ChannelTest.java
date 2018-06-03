package com.wangsen.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangsen
 * @data 2018/4/18 9:52
 * @des NIO 的练习
 */
public class ChannelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("D:虚拟机环境说明-201409.txt","rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRed = fileChannel.read(byteBuffer);
            System.out.println("Read "+ bytesRed);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRed = fileChannel.read(byteBuffer);
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
