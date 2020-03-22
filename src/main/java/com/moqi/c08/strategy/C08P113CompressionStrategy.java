package com.moqi.c08.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 定义压缩数据的策略接口
 */
// BEGIN C08P113CompressionStrategy
public interface C08P113CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

}
// END C08P113CompressionStrategy
