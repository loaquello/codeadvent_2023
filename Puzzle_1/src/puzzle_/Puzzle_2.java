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
public class Puzzle2 {
    
    public static void main(String [] argumentos)throws Exception{
        FileReader archivo;
        BufferedReader lector;
        int numero1 = 0, numero2 = 0, total = 0;
        String numero="", cadena;
        
        archivo = new FileReader("cod.txt");
        lector = new BufferedReader(archivo);
        
        while(lector.ready()){
            if((cadena = lector.readLine()) != null){
                for(int i = 0; i < cadena.length(); i++){
                    if((int)cadena.charAt(i) >= (int)'1' && (int)cadena.charAt(i)<= (int)'9'){
                        if(numero1 == 0){
                            numero1 = cadena.charAt(i);
                        }else{
                            numero2 = cadena.charAt(i);
                        }
                        numero = "";
                    }else{
                        numero = numero + "" + cadena.charAt(i);
                            if(numero.contains("one")){
                                if(numero1 == 0){
                                    numero1 = (int)'1';
                                    numero = "";
                                }else{
                                    numero2 = (int)'1';
                                    numero = "";
                                }
                            }else if(numero.contains("two")){
                                if(numero1 == 0){
                                    numero1 = (int)'2';
                                    numero = "";
                                }else{
                                    numero2 = (int)'2';
                                    numero = "";
                                }
                            }else if(numero.contains("three")){
                                if(numero1 == 0){
                                    numero1 = (int)'3';
                                    numero = "";
                                }else{
                                    numero2 = (int) '3';
                                    numero = "";
                                }
                            }else if(numero.contains("four")){
                                if(numero1 == 0){
                                    numero1 = (int)'4';
                                    numero = "";
                                }else{
                                    numero2 = (int) '4';
                                    numero = "";
                                }
                            }else if(numero.contains("five")){
                                if(numero1 == 0){
                                    numero1 = (int) '5';
                                    numero = "";
                                }else{
                                    numero2 = (int) '5';
                                    numero = "";
                                }
                            }else if(numero.contains("six")){
                                if(numero1 == 0){
                                    numero1 = (int) '6';
                                    numero = "";
                                }else{
                                    numero2 = (int) '6';
                                    numero = "";
                                }
                            }else if(numero.contains("seven")){
                                if(numero1 == 0){
                                    numero1 = (int) '7';
                                    numero = "";
                                }else{
                                    numero2 = (int) '7';
                                    numero = "";
                                }
                            }else if(numero.contains("eight")){
                                if(numero1 == 0){
                                    numero1 = (int) '8';
                                    numero = "";
                                }else{
                                    numero2 = (int) '8';
                                    numero = "";
                                }
                            }else if(numero.contains("nine")){
                                if(numero1 == 0){
                                    numero1 = (int) '9';
                                    numero = "";
                                }else{
                                    numero2 = (int) '9';
                                    numero = "";
                                }
                            }
                    }
                }
                if(numero1 != 0 && numero2 == 0){
                    numero2 = numero1;
                }
                numero = (char)numero1+""+(char)numero2;;
                total = total + Integer.parseInt(numero);
                System.out.println(cadena+"------->"+(char)numero1+""+(char)numero2+" --------------> total: "+total);
                numero1 = 0;
                numero2 = 0;
                numero = "";
            }
        }
    }
    
}
