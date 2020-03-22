package com.moqi.c08.template_method.lambdas;

import com.moqi.c08.template_method.C08P118ApplicationDenied;

/**
 * 员工申请贷款的例子
 */
// BEGIN C08P118LoanApplication
public class C08P118LoanApplication {

    private final C08P118Criteria identity;
    private final C08P118Criteria creditHistory;
    private final C08P118Criteria incomeHistory;

    public C08P118LoanApplication(C08P118Criteria identity,
                                  C08P118Criteria creditHistory,
                                  C08P118Criteria incomeHistory) {

        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checkLoanApplication() throws C08P118ApplicationDenied {
        identity.check();
        creditHistory.check();
        incomeHistory.check();
        reportFindings();
    }

    private void reportFindings() {

    }

}
// END C08P118LoanApplication
