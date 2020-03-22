package com.moqi.c08.template_method;

import com.moqi.c08.template_method.traditional.C08P118CompanyLoanApplication;
import com.moqi.c08.template_method.traditional.C08P118EmployeeLoanApplication;
import com.moqi.c08.template_method.traditional.C08P118PersonalLoanApplication;
import org.junit.Test;

public class TraditionalTest {

    @Test
    public void fitsTogether() throws C08P118ApplicationDenied {
        new C08P118CompanyLoanApplication().checkLoanApplication();
        new C08P118PersonalLoanApplication().checkLoanApplication();
        new C08P118EmployeeLoanApplication().checkLoanApplication();
    }

}