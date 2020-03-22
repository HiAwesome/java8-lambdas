package com.moqi.c08.template_method.lambdas;

import com.moqi.c08.template_method.C05P118ApplicationDenied;

/**
 * 如果申请失败，函数接口 Criteria 抛出异常
 */
// BEGIN C05P118Criteria
public interface C05P118Criteria {

    public void check() throws C05P118ApplicationDenied;

}
// END C05P118Criteria
