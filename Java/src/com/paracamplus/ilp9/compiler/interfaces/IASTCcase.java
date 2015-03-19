/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.compiler.interfaces;

import com.paracamplus.ilp9.interfaces.IASTblock;
import com.paracamplus.ilp9.interfaces.IASTcase;

public interface IASTCcase extends IASTcase {

    interface IASTCswitch extends IASTcase.IASTswitch {
        // Covariance
        IASTClocalVariable getVariable();
    }

    IASTCswitch[] getSwitchs();
}
