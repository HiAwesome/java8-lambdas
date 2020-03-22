package com.moqi.c08.lambdabehave.reporting;

import java.io.PrintStream;

public class C08P120ConsoleFormatter implements C08P120ReportFormatter {

    @Override
    public void format(C08P120Report report) {
        report.suites().forEach(suite -> {
            System.out.print(suite.getName());
            System.out.println();
            suite.specifications().forEach(this::printSpecification);
        });
    }

    private void printSpecification(C08P120SpecificationReport specification) {
        boolean isSuccess = specification.getResult() == C08P120Result.SUCCESS;
        PrintStream out = isSuccess ? System.out : System.err;

        out.print("\tshould ");
        out.print(specification.getDescription());
        if (!isSuccess) {
            out.print("[");
            out.print(specification.getMessage());
            out.print("]");
        }
        out.println();
    }

}
