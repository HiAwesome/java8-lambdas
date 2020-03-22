package com.moqi.c08.template_method.lambdas;

// BEGIN CompanyLoanApplication
public class CompanyLoanApplication extends LoanApplication {

    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
              company::checkHistoricalDebt,
              company::checkProfitAndLoss);
    }

}
// END CompanyLoanApplication