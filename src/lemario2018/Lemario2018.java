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
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xp
 */
public class Lemario2018 {
    ArrayList<String> lemario = new ArrayList();
    public void cargaFicheroLemario(){
        File fichero = new File("src/ejerciciolemario/lemario-20101017.txt");
        //Array[] arrayFichero = new Array[1];
        try 
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null)
            {
                linea = limpiarAcentos(linea);
                lemario.add(linea);
            } 
            
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Lemario2018.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Lemario2018.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean buscar(String palabra)
    {
        if(lemario.contains(palabra))
        {
            return true;
        }
        return false;
    }
    
    public boolean escaleraDePalabras(ArrayList<String> escalera)//Codigo cogido de un ejercicio muy antiguo que hice hace la hostia, 
                                                                 //con cambios minimos para que realize correctamente el lemario 
     {
        boolean aux1 = true;
	boolean aux2 = true;
        int sida;
	for (int i = 0; i < escalera.size() - 1 && aux2; i++) 
        {	
            aux1 = buscar(escalera.get(i));
            if(!aux1)
            {
                return false;
            }
            sida = 0;//Se establece aqui a 0 para que cada vez que entre al for se ponga a 0 otra vez
	    if (escalera.get(i + 1).length() == escalera.get(i).length()) 
            {		
		for (int j = 0; j < escalera.get(i).length(); j++) 
                {
                    if(escalera.get(i).charAt(j) != escalera.get(i + 1).charAt(j))
                    {
                        sida++;
                    }
                    if(sida > 1)//El fallo que tenia era (aparte de ser subnormal)era que tenia que si sida era mayor que 0 de
                                //false, sin embargo como debe ser 1 ya que tiene que ser una letra diferente
                    {
                        aux2 = false;
                    }
                    if(!aux1)
                    {
                        aux2 = false;
                    }
		}
	    } 
	}
	return aux2;
    }
    public static String limpiarAcentos(String cadena)//Viva StackOverFlow
    {
        String limpio = null;
        if (cadena != null) 
        {
            String valor = cadena;
            valor = valor.toUpperCase();
            
            // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            // Quitar caracteres no ASCII excepto la enie, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio;
    }
    public static void main(String[] args) {
        //new Lemario2018().cargaFicheroLemario();
         ArrayList<String> listaPalabras = new ArrayList();
        Lemario2018 ejercicio = new Lemario2018();
        ejercicio.cargaFicheroLemario();
        
        listaPalabras.add("PATO");
        listaPalabras.add("GATO");
        listaPalabras.add("MATO");
        listaPalabras.add("MAJO");
        listaPalabras.add("MAGO");
        listaPalabras.add("MAJO");
        
        System.out.println(ejercicio.escaleraDePalabras(listaPalabras));
    }
    
}
