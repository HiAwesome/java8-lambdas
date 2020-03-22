package com.moqi.c08.lambdabehave;

import com.moqi.c08.lambdabehave.example.C08P120StackSpec;
import com.moqi.c08.lambdabehave.reporting.*;

public enum C08P120Runner {

    current;

    private final Report report;

    private C08P120Runner() {
        report = new Report();
    }

    public static void main(String[] args) {
        current.run();
        current.printReport();
    }

    void recordSuccess(String suite, String specification) {
        report.newSpecification(suite, new SpecificationReport(specification));
    }

    void recordFailure(String suite, String specification, AssertionError cause) {
        SpecificationReport specificationReport = new SpecificationReport(specification, Result.FAILURE, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    void recordError(String suite, String specification, Throwable cause) {
        cause.printStackTrace();
        SpecificationReport specificationReport = new SpecificationReport(specification, Result.ERROR, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    private void printReport() {
        ReportFormatter formatter = new ConsoleFormatter();
        formatter.format(report);
    }

    private void run() {
        try {
            C08P120StackSpec.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
