package com.moqi.c08.lambdabehave;

import com.moqi.c08.lambdabehave.example.StackSpec;
import com.moqi.c08.lambdabehave.reporting.*;

public enum Runner {

    current;

    private final Report report;

    private Runner() {
        report = new Report();
    }

    public static void main(String[] args) {
        current.run(StackSpec.class);
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

    private void run(Class<StackSpec> stackSpecClass) {
        try {
            stackSpecClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
