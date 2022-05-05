/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaciondefensiva;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author amand
 */
public class Ejercicio2 {
    public static void juego()
    {
        String[] palabras = {"Mapache","Oso","Caballo","Perro","Gato","Serpiente"};
        final int INTENTOS_PERMITIDOS= 9;
        int intentosRealizados = 0;
        int aciertos = 0;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        char respuesta;
        Random rnd = new Random();
        
        do
        {
            int numPalabras = rnd.nextInt(6);
            char[] letras = letras(palabras[numPalabras].toLowerCase());
            char[] letras2 = letras(palabras[numPalabras].toLowerCase());
            char[] tusRespuestas = new char[letras2.length];
            for(int i = 0; i < tusRespuestas.length;i++)
            {
                tusRespuestas[i] = '-';
            }
            
            System.out.println("Adivina la palabra");
            boolean ganado = false;
            while(INTENTOS_PERMITIDOS > intentosRealizados && !ganado)
            {
                imprimeOculta(tusRespuestas);
                System.out.println("\nIntroduce una letra");
                respuesta = scanner.next().toLowerCase().charAt(0);
                for(int i=0;i<letras.length;i++)
                {
                    if(letras[i]==respuesta)
                    {
                        tusRespuestas[i] = letras[i];
                        letras[i] =' ';
                        aciertos++;
                    }
                }
                intentosRealizados++;
                ganado = (aciertos == tusRespuestas.length);
            }
            if(ganado)
            {
                System.out.println("\nFelicidades... Ganaste");
                imprimeOculta(tusRespuestas);
            }else
            {
                System.out.println("\nFracasaste... Te he vencido");
                System.out.println("");
                imprimeOculta(letras2);
            }
            intentosRealizados=0;
            aciertos=0;
            respuesta = pregunta("\n\nQuieres volver a jugar?", scanner);
        }while(respuesta !='n');
    }
    
    private static char[] letras(String palabra)
    {
        char[] letras;
        letras = new char[palabra.length()];
        for(int i =0; i<palabra.length();i++) 
        {
            letras[i] = palabra.charAt(i);
        }
        return letras;
    }
    
    private static void imprimeOculta(char[] tr)
    {
        for(int i = 0; i<tr.length;i++)
        {
            System.out.print(tr[i]+" ");
        }
    }
    
    public static char pregunta(String m, Scanner teclado)
    {
        char resp;
        System.out.println(m + "(s/n)");
        resp = teclado.next().toLowerCase().charAt(0);
        while(resp != 's' && resp != 'n')
        {
            System.out.println(m + "(s/n)");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    }
}
