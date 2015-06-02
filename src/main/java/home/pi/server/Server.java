package home.pi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fedomn on 2015/6/2.
 */
public class Server extends Thread{

    private ServerSocket serverSocket;
    private Integer port;
    private Boolean running = false;

    public Server(Integer port) {
        this.port = port;
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopServer() {
        running = false;
        this.interrupt();
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                System.out.println("Listening for a connection");
                Socket socket = serverSocket.accept();
                ResponseThread responseThread = new ResponseThread(socket);
                responseThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("--- OMXRemote - Server ---");
        Server server = new Server(8000);
        server.startServer();
    }
}
