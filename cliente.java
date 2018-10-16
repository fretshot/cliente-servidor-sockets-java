package com.sdyp;

import java.io.*;
import java.net.Socket;

public class cliente {
    public static void main(String [] args) throws Exception {

        System.out.println("Iniciando Cliente");
        Socket s;
        PrintWriter pw;

            try {
                s = new Socket("192.168.1.73",1234);
                pw = new PrintWriter(s.getOutputStream());
                pw.write("5,8");
                pw.flush();
                s.close();
                System.out.println("Mensaje enviado...\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
