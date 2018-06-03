
package com.wangsen.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chengsh05
 *
 */
public class TcpServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            startServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startServer(int port) throws IOException{
        /*
         *开启一个服务channel，
         *A selectable channel for stream-oriented listening sockets.
         */
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.bind(new InetSocketAddress(port));

        /*
         * 创建一个selector
         */
        Selector selector = Selector.open();
        /*
         * 将创建的serverChannel注册到selector选择器上，指定这个channel只关心OP_ACCEPT事件
         */
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            /*
             * select()操作，默认是阻塞模式的，即，当没有accept或者read时间到来时，将一直阻塞不往下面继续执行。
             */
            int readyChannels = selector.select();
            if (readyChannels <= 0) {
                continue;
            }

            /*
             * 从selector上获取到了IO事件，可能是accept，也有可能是read
             */
            Set<SelectionKey> SelectonKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = SelectonKeySet.iterator();

            /*
             * 循环遍历SelectionKeySet中的所有的SelectionKey
             */
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) { //处理OP_ACCEPT事件
                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) { //处理OP_READ事件
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    StringBuilder sb = new StringBuilder();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int readBytes = 0;
                    int ret = 0;
                    /*
                     * 注意读数据的时候，ByteBuffer的操作，需要flip,clear进行指针位置的调整
                     */
                    while ((ret = socketChannel.read(byteBuffer)) > 0) {
                        readBytes += ret;
                        byteBuffer.flip();
                        sb.append(Charset.forName("UTF-8").decode(byteBuffer).toString());
                        byteBuffer.clear();
                    }

                    if (readBytes == 0) {
                        System.err.println("handle opposite close Exception");
                        socketChannel.close();
                    }

                    String message = sb.toString();
                    System.out.println("Message from client: " + message);
                    if ("#ClientClose".equalsIgnoreCase(message.toString().trim())) {
                        System.out.println("Client is going to shutdown!");
                        socketChannel.close();
                    } else if ("#ServerClose".equalsIgnoreCase(message.trim())) {
                        System.out.println("Server is going to shutdown!");
                        socketChannel.close();
                        serverChannel.close();
                        selector.close();
                        System.exit(0);
                    } else {
                        String outMessage = "Server response：" + message;
                        socketChannel.write(Charset.forName("UTF-8").encode(outMessage));
                    }
                }
                /*
                 * 将selector上当前已经监听到的且已经处理了的事件标记清除掉。
                 */
                iterator.remove();
            }
        }
    }
}