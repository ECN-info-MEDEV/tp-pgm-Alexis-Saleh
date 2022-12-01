/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.test.testmedev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TestMedev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World");
        System.out.println("Hello again !!");
        System.out.println("Hello again  again !!");
        readPGM("ressources/brain.pgm");
        


    }
    
    public static void readPGM(String path){
        try {
            FileInputStream f = new FileInputStream(path);
            boolean wasComment = false;
        byte b;
        while ((b = (byte) f.read()) != -1) {
             if (b == '\n') {
                System.out.println("");
                wasComment = false;
                continue;
            }
             else{
                  System.out.print(b);

             }
            
            
        }
           
//            if (b == '#') {
//                System.out.println("#");
//                wasComment = true;
//                continue;
//            }
//            if (wasComment) {
//                continue;
//            }
//            if (Character.isWhitespace(b)) {
//                System.out.print("<Whitespace>");
//                continue;
//            }
//            System.out.print(b + " ");
//        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
