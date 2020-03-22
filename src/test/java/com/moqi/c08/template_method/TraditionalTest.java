package com.moqi.c08.template_method;

import com.moqi.c08.template_method.traditional.CompanyLoanApplication;
import com.moqi.c08.template_method.traditional.EmployeeLoanApplication;
import com.moqi.c08.template_method.traditional.PersonalLoanApplication;
import org.junit.Test;

public class TraditionalTest {

    @Test
    public void fitsTogether() throws ApplicationDenied {
        new CompanyLoanApplication().checkLoanApplication();
        new PersonalLoanApplication().checkLoanApplication();
        new EmployeeLoanApplication().checkLoanApplication();
    }

}