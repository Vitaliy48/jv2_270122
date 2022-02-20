package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();

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
                    System.out.println("Client: " + str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}