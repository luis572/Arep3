/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

/**
 *
 * @author Luis
 */
import java.net.*;
import java.io.*;
public class EchoServer {
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
        
        while ((inputLine = in.readLine()) != null) {
            
            System.out.println("Mensaje: " + inputLine);
            int numero=Integer.parseInt(inputLine);
            outputLine = "Respuesta: " + numero*numero ;
            out.println(outputLine);
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
 
}

