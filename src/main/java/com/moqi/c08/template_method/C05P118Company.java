package com.moqi.c08.template_method;

public interface C05P118Company {

    // BEGIN checkSignatures
    public void checkIdentity() throws C05P118ApplicationDenied;

    public void checkProfitAndLoss() throws C05P118ApplicationDenied;

    public void checkHistoricalDebt() throws C05P118ApplicationDenied;
    // END checkSignatures

}
