package com.moqi.c08.template_method.traditional;

import com.moqi.c08.template_method.C05P118ApplicationDenied;

/**
 * 使用模板方法模式描述申请贷款过程
 */
// BEGIN C05P118LoanApplication
public abstract class C05P118LoanApplication {

    public void checkLoanApplication() throws C05P118ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws C05P118ApplicationDenied;

    protected abstract void checkIncomeHistory() throws C05P118ApplicationDenied;

    protected abstract void checkCreditHistory() throws C05P118ApplicationDenied;

    private void reportFindings() {

    }


}
// END C05P118LoanApplication
