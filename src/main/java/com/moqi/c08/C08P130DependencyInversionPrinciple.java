package com.moqi.c08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class C08P130DependencyInversionPrinciple {

    public interface HeadingFinder {
        List<String> findHeadings(Reader reader);
    }

    /**
     * 解析文件中的标题
     */
    public static class NoDIP implements HeadingFinder {
        // BEGIN nodip_headings
        public List<String> findHeadings(Reader input) {
            try (BufferedReader reader = new BufferedReader(input)) {
                return reader.lines()
                        .filter(line -> line.endsWith(":"))
                        .map(line -> line.substring(0, line.length() - 1))
                        .collect(toList());
            } catch (IOException e) {
                throw new C08P130HeadingLookupException(e);
            }
        }
        // END nodip_headings
    }

    /**
     * 剥离了文件处理功能后的业务逻辑
     */
    public static class ExtractedDIP implements HeadingFinder {
        // BEGIN refactored_headings
        public List<String> findHeadings(Reader input) {
            return withLinesOf(input,
                    lines -> lines.filter(line -> line.endsWith(":"))
                            .map(line -> line.substring(0, line.length() - 1))
                            .collect(toList()),
                    C08P130HeadingLookupException::new);
        }
        // END refactored_headings

        /**
         * 定义 withLinesOf 方法
         */
        // BEGIN with_lines_Of
        private <T> T withLinesOf(Reader input,
                                  Function<Stream<String>, T> handler,
                                  Function<IOException, RuntimeException> error) {

            try (BufferedReader reader = new BufferedReader(input)) {
                return handler.apply(reader.lines());
            } catch (IOException e) {
                throw error.apply(e);
            }
        }
        // END with_lines_Of
    }

}
