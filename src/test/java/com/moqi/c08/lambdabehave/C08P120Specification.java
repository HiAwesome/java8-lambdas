package com.moqi.c08.lambdabehave;

import com.moqi.c08.lambdabehave.expectations.C08P120Expect;

/**
 * 每条规则都是一个实现该接口的 Lambda 表达式
 */
// BEGIN C08P120Specification
public interface C08P120Specification {

    public void specifyBehaviour(C08P120Expect expect);

}
// END C08P120Specification
