package com.moqi.c08.template_method.lambdas;

/**
 * CompanyLoanApplication 类声明了对应的检查方法
 */
// BEGIN C05P118CompanyLoanApplication
public class C05P118CompanyLoanApplication extends C05P118LoanApplication {

    public C05P118CompanyLoanApplication(C05P118Company company) {
        super(company::checkIdentity,
              company::checkHistoricalDebt,
              company::checkProfitAndLoss);
    }

}
// END C05P118CompanyLoanApplication
