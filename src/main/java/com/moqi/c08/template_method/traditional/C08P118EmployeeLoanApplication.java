package com.moqi.c08.template_method.traditional;

/**
 * 员工申请贷款是个人申请的一种特殊情况
 */
// BEGIN C08P118EmployeeLoanApplication
public class C08P118EmployeeLoanApplication extends C08P118PersonalLoanApplication {

    @Override
    protected void checkIncomeHistory() {
        // They work for us!
    }

}
// END C08P118EmployeeLoanApplication
