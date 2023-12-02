/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ismae
 */
public class Puzzle2_2 {
    
    public static void main(String [] argumentos)throws Exception{
        FileReader archivo;
        BufferedReader lector;
        //Here we put the cubes that we take out
        int red = 0, green = 0, blue = 0, total = 0;
        int maxRed = 0, maxGreen = 0, maxBlue = 0;
        String cadena, numero = "", color, aux;
        
        
        archivo = new FileReader("cod.txt");
        if(archivo.ready()){
            lector = new BufferedReader(archivo);
            while((cadena = lector.readLine()) != null){
                cadena = skipGame(cadena);
                cadena = cadena.substring(1,skipGame(cadena).length() + 1);
                while(!cadena.isEmpty()){
                    aux = nextHand(cadena);
                    cadena = cadena.substring(aux.length());
                    if(!cadena.isEmpty()){
                        cadena = cadena.substring(2);
                    }
                    while(!aux.isEmpty()){
                        numero += numColor(aux);
                        aux = aux.substring(numero.length() + 1);
                        color = nameColor(aux);
                        switch(color){
                            case "green":
                                green += Integer.parseInt(numero);
                                break;
                            case "blue":
                                blue += Integer.parseInt(numero);
                                break;
                            case "red":
                                red += Integer.parseInt(numero);
                                break;
                        }
                        aux = aux.substring(cutString(aux));
                        if(!aux.isEmpty()){
                            aux = aux.substring(2);
                        }
                        numero = "";
                    }
                    if(green >= maxGreen){
                        maxGreen = green;
                    }
                    if(red >= maxRed){
                        maxRed = red;
                    }
                    if(blue >= maxBlue){
                        maxBlue = blue;
                    }
                    green = 0;
                    blue = 0;
                    red = 0;
                }
                total += (maxRed * maxBlue * maxGreen);
                maxRed = 0;
                maxBlue = 0;
                maxGreen = 0;
            }
        }
        System.out.println("Total --> "+total);
    }
    
    private static String skipGame(String cadena){
        int inicio = 0;
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) == ':'){
                inicio = i;
            }
        }
                
        return cadena.substring(inicio + 1);
    }
    
    private static String nextHand(String cadena){
        int fin = 0;
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) != ';'){
                fin++;
            }else{
                i = cadena.length();
            }
        }
        
        return cadena.substring(0,fin);
    }
    
    private static int cutString(String cadena){
        int n = 0;
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) != ',' && cadena.charAt(i) != ';'){
                n++;
            }else{
                i = cadena.length();
            }
        }
        
        return n;
    }
    
    private static String nameColor(String cadena){
        String color = "";
        
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) != ';' && cadena.charAt(i) != ',' && !cadena.isEmpty()){
                color += cadena.charAt(i);
            }else{
                i = cadena.length();
            }
        }
        
        return color;
    }
    
    private static String numColor(String cadena){
        int fin = 0;
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) != ' '){
                fin ++;
            }else{
                i = cadena.length();
            }
        }
        
        return cadena.substring(0,fin);
    }
}
