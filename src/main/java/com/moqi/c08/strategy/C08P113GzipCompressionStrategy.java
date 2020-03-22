package com.moqi.c08.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 使用 gzip 算法压缩数据
 */
// BEGIN C08P113GzipCompressionStrategy
public class C08P113GzipCompressionStrategy implements C08P113CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }

}
// END C08P113GzipCompressionStrategy
