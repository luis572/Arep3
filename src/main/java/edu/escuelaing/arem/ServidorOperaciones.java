/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2137497
 */
public class ServidorOperaciones {
    public static void main(String[] args) throws IOException {
       ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8182);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String operacion="cos";
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            try{
                 outputLine = "Respuesta: ";
                 if(inputLine.contains("sen")){
                     operacion="sen";
                }
                 else if(inputLine.contains("cos")){
                     operacion="cos";
                 }
                 else if(inputLine.contains("tan")){
                     operacion="tan";
                 }
                 else{
                    double  numero=Double.parseDouble(inputLine);
                    numero= Math.toRadians(numero);
                     switch (operacion) {
                         case "sen":
                             outputLine = outputLine +  Math.sin(numero);
                             break;
                         case "cos":
                             outputLine = outputLine +  Math.cos(numero) ;
                             break;
                         case "tan":
                             outputLine = outputLine +  Math.tan(numero) ;
                             break;
                         default:
                             break;
                     }
                   
                 }
                 System.out.println("Dijite Datos V");
                 out.println(outputLine);
                 if (outputLine.equals("Respuestas: Bye."))
                        break;
            }catch(NumberFormatException e){
                System.out.println("Dijite Datos Validos");
            }
           
            
            
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
