/*
 * fuzuli : A general purpose interpreter
 * Copyright (C) 2013 Mehmet Hakan Satman <mhsatman@yahoo.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package Interpreter;


public class IdentifierExpression extends Expression {

    public String iden;
    
    public IdentifierExpression(String iden){
        this.iden = iden;
    }
    
    @Override
    public Object eval(Environment e) {  
        Environment val = e.findEnvironmentOfVariable(iden);
        if(val == null){
            throw new RuntimeException("Variable '"+iden+"' is NULL : Environment:\n"+e.toString());
        }
        return(val.getVariableInThisEnvironment(iden));
    }
    
    public String toString(){
        return ("ID("+this.iden+")");
    }
    
}
