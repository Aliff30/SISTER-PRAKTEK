/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alif270923;

import java.net.*;
import java.io.*;

/**
 *
 * @author LENOVO
 */

public class EchoingServer {
    public static void main (String [] args){
        ServerSocket server = null;
        Socket client;
        String coba;
        
        try {
            server = new ServerSocket(1235);
        } catch (IOException ie) {
            System.out.println("Cannot open socket.");
            System.exit(1);
        }
        while(true) { 
            try {
                System.out.println("Listening......");
                client = server.accept();
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                coba = br.readLine();
                System.out.println(coba);
                pw.println(coba);
            } catch (IOException ie) { 
        } 
    }
  }
}
