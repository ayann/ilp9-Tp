package com.paracamplus.ilp9.interfaces;

import com.paracamplus.ilp9.annotation.OrNull;

public interface IASTcase extends IASTexpression {
	
	public interface IASTswitch extends IAST {
		IASTexpression getCondition();
		IASTexpression getConsequence();
		IASTvariable getVariable();
    }
	
	IASTswitch[] getSwitchs();
	@OrNull IASTexpression getAlternant();
	boolean isTernary();
}
