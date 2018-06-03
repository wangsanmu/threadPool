package com.wangsen.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * @author wangsen
 * @data 2018/4/19 9:59
 * @des
 */


public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(12);
        buf.put("hello".getBytes());
        System.out.println("write after : " + buf);
        System.out.println("invoke remaining return value = " + buf.remaining());


        // java.nio.HeapByteBuffer
        ByteBuffer buf1 = null;
        try {
            buf1 = ByteBuffer.wrap("春风十里不如你".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(buf1.toString());
    }
}
