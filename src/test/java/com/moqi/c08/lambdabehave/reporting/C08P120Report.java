package com.moqi.c08.lambdabehave.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class C08P120Report {

    private final List<C08P120SuiteReport> suites;

    private C08P120SuiteReport currentSuite;

    public C08P120Report() {
        suites = new ArrayList<>();
    }

    private void newSuite(String name) {
        currentSuite = new C08P120SuiteReport(name);
        suites.add(currentSuite);
    }

    public void newSpecification(String suiteName, C08P120SpecificationReport report) {
        if (noSuite() || seenNewSuite(suiteName)) {
            newSuite(suiteName);
        }
        currentSuite.add(report);
    }

    private boolean seenNewSuite(String suite) {
        return !currentSuite.getName().equals(suite);
    }

    private boolean noSuite() {
        return currentSuite == null;
    }

    public Stream<C08P120SuiteReport> suites() {
        return suites.stream();
    }

}
