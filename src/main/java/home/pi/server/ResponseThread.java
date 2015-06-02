package home.pi.server;

import com.fedomn.ResponseMaker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by fedomn on 2015/6/2.
 */
public class ResponseThread extends Thread {

    private Socket socket;

    private static Logger logger = Logger.getLogger(ResponseThread.class.getClass());

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }


    public ResponseThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            logger.info("Receive a connection : " + socket.getInetAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String line = in.readLine();
            while (line != null && line.length() > 0) {
                logger.info("Receive control : " + line);
                ResponseMaker.translate(line);
                line = in.readLine();
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
