package com.moqi.c08.template_method.lambdas;

import com.moqi.c08.template_method.C05P118ApplicationDenied;

/**
 * 员工申请贷款的例子
 */
// BEGIN C05P118LoanApplication
public class C05P118LoanApplication {

    private final C05P118Criteria identity;
    private final C05P118Criteria creditHistory;
    private final C05P118Criteria incomeHistory;

    public C05P118LoanApplication(C05P118Criteria identity,
                                  C05P118Criteria creditHistory,
                                  C05P118Criteria incomeHistory) {

        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checkLoanApplication() throws C05P118ApplicationDenied {
        identity.check();
        creditHistory.check();
        incomeHistory.check();
        reportFindings();
    }

    private void reportFindings() {

    }

}
// END C05P118LoanApplication
