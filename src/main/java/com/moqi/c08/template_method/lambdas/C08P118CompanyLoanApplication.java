package com.moqi.c08.template_method.lambdas;

/**
 * CompanyLoanApplication 类声明了对应的检查方法
 */
// BEGIN C08P118CompanyLoanApplication
public class C08P118CompanyLoanApplication extends C08P118LoanApplication {

    public C08P118CompanyLoanApplication(C08P118Company company) {
        super(company::checkIdentity,
              company::checkHistoricalDebt,
              company::checkProfitAndLoss);
    }

}
// END C08P118CompanyLoanApplication
