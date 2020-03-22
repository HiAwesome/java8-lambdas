package com.moqi.c08.template_method.traditional;

/**
 * 员工申请贷款是个人申请的一种特殊情况
 */
// BEGIN C05P118EmployeeLoanApplication
public class C05P118EmployeeLoanApplication extends C05P118PersonalLoanApplication {

    @Override
    protected void checkIncomeHistory() {
        // They work for us!
    }

}
// END C05P118EmployeeLoanApplication
