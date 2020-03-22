package com.moqi.c08.template_method.traditional;

import com.moqi.c08.template_method.C08P118ApplicationDenied;

/**
 * 使用模板方法模式描述申请贷款过程
 */
// BEGIN C08P118LoanApplication
public abstract class C08P118LoanApplication {

    public void checkLoanApplication() throws C08P118ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws C08P118ApplicationDenied;

    protected abstract void checkIncomeHistory() throws C08P118ApplicationDenied;

    protected abstract void checkCreditHistory() throws C08P118ApplicationDenied;

    private void reportFindings() {

    }


}
// END C08P118LoanApplication
