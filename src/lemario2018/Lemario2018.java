/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemario2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xp
 */
public class Lemario2018 {
    public void cargaFicheroLemario(){
        File fichero = new File("src/lemario2018/lemario-20101017.txt");
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null){
                //System.out.println(linea);
                cont++;
            }
            System.out.println(cont);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lemario2018.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lemario2018.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Lemario2018().cargaFicheroLemario();
    }
    
}
