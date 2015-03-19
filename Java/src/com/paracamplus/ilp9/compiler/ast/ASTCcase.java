/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.compiler.ast;

import com.paracamplus.ilp9.ast.ASTblock;
import com.paracamplus.ilp9.ast.ASTcase;
import com.paracamplus.ilp9.compiler.interfaces.IASTCblock;
import com.paracamplus.ilp9.compiler.interfaces.IASTCcase;
import com.paracamplus.ilp9.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp9.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp9.interfaces.IASTexpression;
import com.paracamplus.ilp9.interfaces.IASTvariable;

public class ASTCcase extends ASTcase implements IASTCcase {

    public static class ASTCswitch extends ASTcase.ASTswitch
    implements IASTCswitch {
        public ASTCswitch (IASTexpression condition, IASTexpression consequence, IASTvariable variable) {
            super(condition, consequence, variable);
        }
        public IASTClocalVariable getVariable () {
            return (IASTClocalVariable) super.getVariable();
        }
    }
   
    public ASTCcase (IASTCswitch[] switchs,
                      IASTexpression alternant ) {
        super(switchs, alternant);
    }

    @Override
    public IASTCswitch[] getSwitchs() {
        return (IASTCswitch[]) super.getSwitchs();
    }
    
    public <Result, Data, Anomaly extends Throwable> Result accept(
            IASTCvisitor<Result, Data, Anomaly> visitor, Data data)
            throws Anomaly {
        return visitor.visit(this, data);
    }
}
