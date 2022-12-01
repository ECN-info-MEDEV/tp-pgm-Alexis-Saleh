/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.test.testmedev;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
        
        try {
        readPGM("ressources/brain.pgm");
        FileOutputStream outRaw= new FileOutputStream("ressources/test.txt");
        FileInputStream inRaw = new FileInputStream("ressources/brain.pgm");
        DataInputStream dis = new DataInputStream(inRaw);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        


    }
    
    public static void readPGM(String path) throws FileNotFoundException, IOException{
        System.out.println("lancement de readPGM avec le chemin " +path);
        byte[] arrayOfBytes;
        try {
            HashMap hash=new HashMap<Integer,Integer>();
            FileInputStream f = new FileInputStream(path);
            boolean wasComment = false;
            int lineNumber=1;
        byte b;
        arrayOfBytes=f.readAllBytes();

            
       
            
            
        

            String asciiByteArray=new String(arrayOfBytes, "UTF-8");
            System.out.println(asciiByteArray);
            
            StringTokenizer st = new StringTokenizer(asciiByteArray, " ");
            while (st.hasMoreTokens()) {
                String currenToken=st.nextToken();
                //System.out.println(currenToken);

                if(hash.containsKey(currenToken)){
                          hash.put(currenToken, (int)hash.get((currenToken)) + 1);
                      }
                      else{
                           hash.put(currenToken,  1);

                      }
                
                
                
        }

            System.out.println("the instrogram is the following : " +hash);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
        
    
    

