package com.mobin.thread.Example;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Mobin on 2017/8/5.
 */
public class Storage implements Closeable, AutoCloseable{
    private final RandomAccessFile storeFile;
    private final FileChannel storeChannel;
    protected final AtomicLong totalWrites = new AtomicLong(0);

    public Storage(long fileSize,String fileShortName) throws FileNotFoundException {
        String fullFileName = "F:" + "/" + fileShortName;
        String localFileName = createStoreFile(fileSize, fullFileName);
        storeFile = new RandomAccessFile(localFileName, "rw");
        storeChannel = storeFile.getChannel();
    }

    public int store(long offset, ByteBuffer bytebuffer) throws IOException {
        int length;
        storeChannel.write(bytebuffer, offset);
        length = bytebuffer.limit();
        totalWrites.addAndGet(length);
        return length;
    }

    public long getTotalWrites(){
        return totalWrites.get();
    }

    private String createStoreFile(long fileSize, String fullFileName) throws FileNotFoundException {
        File file = new File(fullFileName);
        System.out.println("Create local file: %s" + fullFileName);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        try {
            raf.setLength(fileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                raf.close();
            } catch (IOException e) {
            }
        }
        return fullFileName;
    }

    @Override
    public void close() {
        if (storeChannel.isOpen()) {
            try {
                storeChannel.close();
                storeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
