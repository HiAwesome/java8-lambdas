package com.moqi.c08.lambdabehave.reporting;

public final class C08P120SpecificationReport {

    private final String description;
    private final C08P120Result result;
    private final String message;

    public C08P120SpecificationReport(String description, C08P120Result result, String message) {
        this.description = description;
        this.result = result;
        this.message = message;
    }

    public C08P120SpecificationReport(String specification) {
        this(specification, C08P120Result.SUCCESS, null);
    }

    public String getDescription() {
        return description;
    }

    public C08P120Result getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
