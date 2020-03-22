package com.moqi.c08.template_method.lambdas;

import com.moqi.c08.template_method.ApplicationDenied;

// BEGIN Criteria
public interface Criteria {

    public void check() throws ApplicationDenied;

}
// END Criteria
