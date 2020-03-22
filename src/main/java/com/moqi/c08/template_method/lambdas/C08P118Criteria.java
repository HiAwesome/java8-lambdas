package com.moqi.c08.template_method.lambdas;

import com.moqi.c08.template_method.C08P118ApplicationDenied;

/**
 * 如果申请失败，函数接口 Criteria 抛出异常
 */
// BEGIN C08P118Criteria
public interface C08P118Criteria {

    public void check() throws C08P118ApplicationDenied;

}
// END C08P118Criteria
