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

package jfuzuli.main;

import Editor.MainFrame;
import Interpreter.Environment;
import Interpreter.Expression;
import Interpreter.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author Mehmet Hakan Satman
 */
public class JFuzuli {

    public static void runSingleFile(String[] args){
        Environment globalEnvironment = new Environment(null);
            globalEnvironment.setVariable("argc", args.length);
            globalEnvironment.setVariable("argv", args);
            Parser parser = new Parser(new File(args[0]));
            Expression e = null;
            while (true) {
                try {
                    e = parser.getNextExpression();
                } catch (Exception exc) {
                    System.out.println("Parsing Error: " + exc.getMessage());
                    exc.printStackTrace();
                    System.exit(-1);
                }

                if (e == null) {
                    break;
                }

                Object o = null;
                try {
                    o = e.eval(globalEnvironment);
                } catch (Exception exc) {
                    System.out.println("Runtime Error: " + exc.toString());
                    exc.printStackTrace();
                    System.exit(-1);
                } 
            }
    }
    
    public static void repl(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = new Parser("(+ 2 2)\n");
        Environment topEnvironment = new Environment(null);
        String input;
        while(true){
            try{
                System.out.print("F: ");
                input = reader.readLine();
                parser.setSourceCode(input);
                parser.resetParser();
                Expression expr = parser.getNextExpression();
                Object result = expr.eval(topEnvironment);
                System.out.println(result);
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
    public static void main(String[] args) {
        if (args.length == 1) {
            if(args[0].equals("--repl")){
                repl(args);
            }else if(args[0].equals("--editor")){
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
            }else{
                runSingleFile(args);
            }
        }else{
            System.out.println("Usage:");
            System.out.println("java -jar JFuzuli.jar fzlfile");
            System.out.println("java -jar JFuzuli.jar --repl");
            System.out.println("java -jar JFuzuli.jar --editor");
        }
    }
}
