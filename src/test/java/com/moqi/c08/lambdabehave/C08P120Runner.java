package com.moqi.c08.lambdabehave;

import com.moqi.c08.lambdabehave.example.C08P120StackSpec;
import com.moqi.c08.lambdabehave.reporting.*;

public enum C08P120Runner {

    current;

    private final C08P120Report report;

    private C08P120Runner() {
        report = new C08P120Report();
    }

    public static void main(String[] args) {
        current.run();
        current.printReport();
    }

    void recordSuccess(String suite, String specification) {
        report.newSpecification(suite, new C08P120SpecificationReport(specification));
    }

    void recordFailure(String suite, String specification, AssertionError cause) {
        C08P120SpecificationReport specificationReport = new C08P120SpecificationReport(specification, C08P120Result.FAILURE, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    void recordError(String suite, String specification, Throwable cause) {
        cause.printStackTrace();
        C08P120SpecificationReport specificationReport = new C08P120SpecificationReport(specification, C08P120Result.ERROR, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    private void printReport() {
        C08P120ReportFormatter formatter = new C08P120ConsoleFormatter();
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
