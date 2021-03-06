

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class ConcurrentServer {
    private static ConcurrentServer _instance = new ConcurrentServer();

    private ConcurrentServer() {
    }

    private static ConcurrentServer getInstance() {
        return _instance;
    }

    public static void main(String[] args) throws IOException{
        ConcurrentServer.getInstance().iniciarServidor(args);
    }

    static boolean ejecutando = true;

    public void iniciarServidor(String[] args) throws IOException {

        ExecutorService hilos = Executors.newFixedThreadPool(10);

        Socket clientSocket = null;

        while(ejecutando)
        {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            hilos.execute(new Thread(serverSocket.accept()));
            serverSocket.close();
        }

    }

    public String createResponse() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Server Concurrent</title>\n" + "</head>"
                + "<body>"
                + "Server concurrent"
                +"<img src='https://www.motofichas.com/images/phocagallery/Kawasaki/ninja-zx-6r-2020/01-kawasaki-ninja-zx-6r-2020-estudio-verde.jpg'"
                + "</body>"
                + "</html>" ;
    }
}