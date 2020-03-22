package com.moqi.c08.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 在构造类时提供压缩策略
 */
// BEGIN C08P113Compressor
public class C08P113Compressor {

    private final C08P113CompressionStrategy strategy;

    public C08P113Compressor(C08P113CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 使用具体的策略类初始化 Compressor
     */
    public static void classBasedExample(Path inFile, File outFile) throws IOException {
        // BEGIN classBasedExample
        C08P113Compressor gzipCompressor = new C08P113Compressor(new C08P113GzipCompressionStrategy());
        gzipCompressor.compress(inFile, outFile);

        C08P113Compressor zipCompressor = new C08P113Compressor(new C08P113ZipCompressionStrategy());
        zipCompressor.compress(inFile, outFile);
        // END classBasedExample
    }
        // END C08P113Compressor

    /**
     * 使用方法引用初始化 Compressor
     */
    public static void lambdaBasedExample(Path inFile, File outFile) throws IOException {
        // BEGIN lambdaBasedExample
        C08P113Compressor gzipCompressor = new C08P113Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(inFile, outFile);

        C08P113Compressor zipCompressor = new C08P113Compressor(ZipOutputStream::new);
        zipCompressor.compress(inFile, outFile);
        // END lambdaBasedExample
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }

}
