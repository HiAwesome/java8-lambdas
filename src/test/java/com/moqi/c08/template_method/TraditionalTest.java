package com.moqi.c08.template_method;

import com.moqi.c08.template_method.traditional.C05P118CompanyLoanApplication;
import com.moqi.c08.template_method.traditional.C05P118EmployeeLoanApplication;
import com.moqi.c08.template_method.traditional.C05P118PersonalLoanApplication;
import org.junit.Test;

public class TraditionalTest {

    @Test
    public void fitsTogether() throws C05P118ApplicationDenied {
        new C05P118CompanyLoanApplication().checkLoanApplication();
        new C05P118PersonalLoanApplication().checkLoanApplication();
        new C05P118EmployeeLoanApplication().checkLoanApplication();
    }

}