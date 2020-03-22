package com.moqi.c08.template_method;

public interface C08P118Company {

    // BEGIN checkSignatures
    public void checkIdentity() throws C08P118ApplicationDenied;

    public void checkProfitAndLoss() throws C08P118ApplicationDenied;

    public void checkHistoricalDebt() throws C08P118ApplicationDenied;
    // END checkSignatures

}
