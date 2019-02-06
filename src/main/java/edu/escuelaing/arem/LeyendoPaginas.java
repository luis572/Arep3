/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;
import java.io.*;
import java.net.*;
/**
 *
 * @author Luis
 */
public class LeyendoPaginas {
    public static void main(String[] args) throws Exception {
        String html = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese porfavor el URL:http://");
        String pagina=in.readLine();
        URL google = new URL("http://"+pagina);
        try (BufferedReader reader
            = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                 html += inputLine + "\n";
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        File archivo = new File("resultado.html");
        if(archivo.exists()){
            archivo.delete();
        }
        archivo.createNewFile();
        FileWriter escribir=new FileWriter(archivo.getAbsoluteFile(), true);
        BufferedWriter b=new BufferedWriter(escribir);
        b.write(html);
        b.close();
        escribir.close();
        
    }

}
