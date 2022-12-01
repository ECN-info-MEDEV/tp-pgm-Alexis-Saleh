/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.test.testmedev;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
            FileOutputStream outRaw = new FileOutputStream("ressources/test.txt");
            FileInputStream inRaw = new FileInputStream("ressources/brain.pgm");
            DataInputStream dis = new DataInputStream(inRaw);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage bfimg;
        FileInputStream in = new FileInputStream("ressources/medevtp.jpg");
        BufferedImage bfimg1 = ImageIO.read(in);
        bfimg = convertToBufferdImg("ressources/brain.pgm");
        if(bfimg!=null){
            Histogramme hist = new Histogramme(bfimg);
        }else{
            System.out.println("---------------dessin--------------");
            Histogramme hist = new Histogramme(bfimg1);
            hist.paintComponent(hist.getDessin());
        }
        
        
        
       

    }

    public static void readPGM(String path) {
        System.out.println("lancement de readPGM");
        try {
            HashMap hash = new HashMap<Integer, Integer>();
            FileInputStream f = new FileInputStream(path);
            boolean wasComment = false;
            int lineNumber = 1;
            byte b;
            System.out.println("P2");
            System.out.println("#");
            while ((b = (byte) f.read()) != -1) {
                if (b == '\n') {
                    //System.out.println("");
                    wasComment = false;
                    continue;
                } else {

                    //System.out.print(b+" ");
                    lineNumber = lineNumber + 1;
                    if (lineNumber > 3) {
                        if (hash.containsKey((int) b)) {
                            hash.put((int) b, (int) hash.get((int) b) + 1);
                        } else {
                            hash.put((int) b, 1);

                        }
                    }

                }

            }

            System.out.println(hash);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestMedev.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static BufferedImage convertToBufferdImg(String path) throws FileNotFoundException, IOException {
        FileInputStream in;
        in = new FileInputStream(path);
        BufferedImage inputImage = ImageIO.read(in);
        return inputImage;
    }
}
