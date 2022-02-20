package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;
    private static final int PORT = 8189;
    private static final String ADDRES = "localhost";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            socket = new Socket(ADDRES,PORT);
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread read = new Thread(()->{
                try{
                    while (true){
                        out.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            read.setDaemon(true);
            read.start();

            while (true) {
                String str = in.readUTF();

                if (str.equals("/end")) {
                    out.writeUTF("/end");
                    break;
                }else{
                    System.out.println("Server: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
