/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ismae
 */
public class Puzzle_ {
    
    public static void main(String [] argumentos)throws Exception{
        FileReader archivo;
        BufferedReader lector;
        int numero1 = 0, numero2 = 0, total = 0;
        String numero;
        
        archivo = new FileReader("cod.txt");
        if(archivo.ready()){
            lector = new BufferedReader(archivo);
            String cadena;
            while((cadena = lector.readLine()) != null){
                for(int i = 0; i < cadena.length(); i++){
                    if((int)cadena.charAt(i) >= (int)'1' && (int)cadena.charAt(i)<= (int)'9'){
                        if(numero1 == 0){
                            numero1 = cadena.charAt(i);
                        }else{
                            numero2 = cadena.charAt(i);
                        }
                    }
                }
                if(numero1 != 0 && numero2 == 0){
                    numero2 = numero1;
                }
                numero = (char)numero1+""+(char)numero2;
                total = total + Integer.parseInt(numero);
                System.out.println(cadena+"------->"+(char)numero1+""+(char)numero2+" --------------> total: "+total);
                numero1 = 0;
                numero2 = 0;
            }
        }
    }
}
