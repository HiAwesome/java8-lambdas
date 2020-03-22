package com.moqi.c08;

import java.util.stream.IntStream;

public class C08P124SingleResponsibilityPrinciple {

    public interface PrimeCounter {
        long countPrimes(int upTo);
    }

    /**
     * 计算质数个数，一个方法里塞进了多重职责
     */
    public static class ImperativeSingleMethodPrimeCounter implements PrimeCounter {
        @Override
        // BEGIN imperative_single_method
        public long countPrimes(int upTo) {
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    tally++;
                }
            }
            return tally;
        }
        // END imperative_single_method
    }

    public static class ImperativeRefactoredPrimeCounter implements PrimeCounter {
        @Override
        // BEGIN imperative_refactored
        public long countPrimes(int upTo) {
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                if (isPrime(i)) {
                    tally++;
                }
            }
            return tally;
        }

        private boolean isPrime(int number) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
        // END imperative_refactored
    }

    /**
     * 将 isPrime 重构成另外一个方法后，计算质数个数的方法
     */
    public static class FunctionalPrimeCounter implements PrimeCounter {

        @Override
        // BEGIN functional
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo)
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number)
                    .allMatch(x -> (number % x) != 0);
        }
        // END functional
    }

    /**
     * 使用集合流重构质数计数程序
     */
    public static class ParallelFunctionalPrimeCounter implements PrimeCounter {
        @Override
        // BEGIN parallel_functional
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo)
                    .parallel()
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number)
                    .allMatch(x -> (number % x) != 0);
        }
        // END parallel_functional
    }

}
