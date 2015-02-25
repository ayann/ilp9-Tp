package com.paracamplus.ilp9.interpreter.interfaces;

import com.paracamplus.ilp9.interfaces.IASTvariable;
import com.paracamplus.ilp9.interfaces.IEnvironment;

public interface ILexicalEnvironment 
extends IEnvironment<IASTvariable, Object, EvaluationException> {
    ILexicalEnvironment extend(ISuperCallInformation isci);
    ISuperCallInformation getSuperCallInformation() 
            throws EvaluationException;
    // A touch of covariance:
    ILexicalEnvironment extend(IASTvariable variable, Object value);
    ILexicalEnvironment getNext() throws EvaluationException;
}
