package home.pi.server;

import com.fedomn.ResponseMaker;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fedomn on 2015/6/1.
 */
public class server implements Runnable{


    private Socket clientSocket;

    public server(Socket socket) throws AWTException {
        this.clientSocket = socket;
    }

    public static void main(String[] args) throws IOException, AWTException {
        ServerSocket myService = null;
        boolean running = true;
        System.out.println("--- OMXRemote - Server ---");
        myService = new ServerSocket(8000);
        System.out.println("Listening...");

        while (running) {
            Socket sock = myService.accept();
            System.out.println("Connected to : " + sock.getInetAddress());
            new Thread(new server(sock)).start();
        }
        myService.close();
    }

    @Override
    public void run() {
        BufferedReader input = null;
        DataOutputStream output = null;
        String request;

        try {
            input = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            output = new DataOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while(true)
            {
                request = input != null ? input.readLine() : "";
                System.out.println("RecvData   "+request);
                ResponseMaker.translate(request);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            input.close();
            output.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
