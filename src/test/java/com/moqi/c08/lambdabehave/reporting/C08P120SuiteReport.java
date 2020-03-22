package com.moqi.c08.lambdabehave.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class C08P120SuiteReport {

    private final String name;
    private final List<C08P120SpecificationReport> specifications;

    public C08P120SuiteReport(String name) {
        this.name = name;
        specifications = new ArrayList<>();
    }

    public void add(C08P120SpecificationReport specification) {
        specifications.add(specification);
    }

    public Stream<C08P120SpecificationReport> specifications() {
        return specifications.stream();
    }

    public String getName() {
        return name;
    }

}
