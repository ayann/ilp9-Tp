/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.interpreter.primitive;

import com.paracamplus.ilp9.interpreter.interfaces.IPrimitive;


public abstract class Primitive implements IPrimitive {

    public Primitive (String name) {
        this.name = name;
    }
    private final String name;
    
    public String getName() {
        return name;
    }
}
