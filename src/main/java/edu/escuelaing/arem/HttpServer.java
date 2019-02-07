/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author 2137497
 */
public class HttpServer {
    public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(new Integer(System.getenv("PORT")));
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35000.");
			System.exit(1);
		}
		Socket clientSocket = null;
		for (;;) {
			try {
				System.out.println("Listo para recibir ...");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
                        String[] get = null;
			while ((inputLine = in.readLine()) != null) {
				
				if (!in.ready()) {
					break;
				}
                                if (inputLine.contains("GET")) {
                                    get = inputLine.split(" ");
                                    
				
                            }
			}
                        outputLine="";
                        if(get[1].equals("/") ||get[1].equals("/index.html")){
                            
                            BufferedReader bf = new BufferedReader(new FileReader("resourses/index.html"));
                            String sCadena="";
                                while ((sCadena = bf.readLine())!=null) {
                                    System.out.println(sCadena);
                                        outputLine+=sCadena;
                                     }

                            //out.close();
                            //in.close();
                            
                        }
                         
                        else if(get[1].equals("/html2.html")){
                            BufferedReader bf = new BufferedReader(new FileReader("resourses/html2.html"));
                            String sCadena="";
                                while ((sCadena = bf.readLine())!=null) {
                                    System.out.println(sCadena);
                                        outputLine+=sCadena;
                                     }
                        } 
                        else if(get[1].equals("/imagen.png")){
                            BufferedReader bf = new BufferedReader(new FileReader("resourses/Imagen.html"));
                            String sCadena="";
                                while ((sCadena = bf.readLine())!=null) {
                                    System.out.println(sCadena);
                                        outputLine+=sCadena;
                                     }
                        }
                        out.println("HTTP/1.1 200 OK");
                        out.println("Content-Type: text/html" + "\r\n");
                        out.println(outputLine);
                        
                        out.flush();
                        clientSocket.close();
                        //serverSocket.close();
                        
                    /**byte[] imageAr = new byte[62100];
                    InputStream inputStream = clientSocket.getInputStream();
                    inputStream.read(imageAr);
                    
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

                    System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
                    ImageIO.write(image, "jpg", new File("C:\\Users\\juan\\Desktop\\recono\\coche2.png"));*/
		}
               
                
	}
    	public static String getPageRequest(InputStream is) throws IOException {
		is.mark(0);
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String inputLine = null;
		while ((inputLine = in.readLine()) != null) {
			if (!in.ready())
				break;
			if (inputLine.contains("GET")) {
				String[] get = inputLine.split(" ");
				return get[1];
			}
			break;
		}
		return "path";
	}

    
    
 }

