/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.test.testmedev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        


    }
    
    public static void readPGM(String path){
        try {
            FileInputStream f = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
