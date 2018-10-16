package com.sdyp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando Servidor...");
        InputStreamReader isr;
        BufferedReader bufferedReader;
        String message;
        Socket s = null;
        ServerSocket ss;

        try {
            ss = new ServerSocket(1234);
            while(true){
                s = ss.accept();
                System.out.println("Conección Exitosa!\n>> IP: "+s.getInetAddress() +"\n>> Puerto: "+s.getLocalPort());
                isr = new InputStreamReader(s.getInputStream());
                bufferedReader = new BufferedReader(isr);
                message = bufferedReader.readLine();
                String[] msg = message.split(",");
                int num1 = Integer.parseInt(msg[0]);
                int num2 = Integer.parseInt(msg[1]);
                int res = num1*num2;
                System.out.println("Datos enviados: "+message+"\nMultiplicando datos: "+res+"\n\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
