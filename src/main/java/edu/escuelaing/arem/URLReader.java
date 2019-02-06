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
public class URLReader {
    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/html1.html");
        System.out.println("URL: "+google);
        System.out.println("Authority: "+getAuthority(google));
        System.out.println("Protocol: "+getProtocol(google));
        System.out.println("Path: "+getPath(google));
        System.out.println("Host: "+getHost(google));
        System.out.println("Port: "+getPort(google));
        System.out.println("Query: "+getQuery(google));
        System.out.println("File: "+getFile(google));
        System.out.println("Ref: "+getRef(google));
    }
    public static String getProtocol(URL domain){
        String protocol = domain.getProtocol();
        return protocol;
    }
    
    public static String getAuthority(URL domain){
        String authority = domain.getAuthority();
        return authority;
    }
    
    public static String getHost(URL domain){
        String host = domain.getHost();
        return host;
    }
    
    public static int getPort(URL domain){
        int port = domain.getPort();
        return port;
    }
    
    public static String getPath(URL domain){
        String path = domain.getPath();
        return path;
    }
    
    public static String getQuery(URL domain){
        String query = domain.getQuery();
        return query;
    }
    
    public static String getFile(URL domain){
        String file = domain.getFile();
        return file;
    }
    
    public static String getRef(URL domain){
        String ref = domain.getRef();
        return ref;
    }
    
}
