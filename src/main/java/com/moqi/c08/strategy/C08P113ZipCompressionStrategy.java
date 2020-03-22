package com.moqi.c08.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 使用 zip 算法压缩数据
 */
// BEGIN C08P113ZipCompressionStrategy
public class C08P113ZipCompressionStrategy implements C08P113CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new ZipOutputStream(data);
    }

}
// END C08P113ZipCompressionStrategy
