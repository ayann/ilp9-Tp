/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.ast;

import com.paracamplus.ilp9.interfaces.IASTblock;
import com.paracamplus.ilp9.interfaces.IASTcase;
import com.paracamplus.ilp9.interfaces.IASTcase.IASTswitch;
import com.paracamplus.ilp9.interfaces.IASTexpression;
import com.paracamplus.ilp9.interfaces.IASTvariable;
import com.paracamplus.ilp9.interfaces.IASTvisitor;

public class ASTcase extends ASTexpression implements IASTcase {
    
    public static class ASTswitch extends AST implements IASTswitch {
    	
    	 private final IASTexpression condition;
         private final IASTexpression consequence;
         private final IASTvariable variable;
    	
    	public ASTswitch (IASTexpression condition, IASTexpression consequence, IASTvariable variable) {
            this.condition = condition;
            this.consequence = consequence;
            this.variable = variable;
        }
       
		@Override
		public IASTexpression getCondition() {
			return this.condition;
		}

		@Override
		public IASTexpression getConsequence() {
			return this.consequence;
		}

		@Override
		public IASTvariable getVariable() {
			return this.variable;
		}

		
    }
    
    
    private final IASTswitch[] switchs;
    private final IASTexpression alternant;
    
    public ASTcase (IASTswitch[] switchs,
                     IASTexpression alternant ) {
        this.switchs = switchs;
        this.alternant = alternant;
    }
    
    @Override
    public IASTswitch[] getSwitchs() {
        return switchs;
    }
    
    @Override
    public IASTexpression getAlternant() {
        return alternant;
    }
    
    @Override
    public boolean isTernary() {
        return this.alternant != null;
    }

    public <Result, Data, Anomaly extends Throwable> 
    Result accept(IASTvisitor<Result, Data, Anomaly> visitor, Data data)
            throws Anomaly {
        return visitor.visit(this, data);
    }

	

}
