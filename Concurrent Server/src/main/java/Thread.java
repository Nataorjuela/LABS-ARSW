


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Thread implements Runnable {
    Socket clientSocket = null;

    public Thread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Corriendo");
        try {

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            outputLine = createResponse();

            out.println(outputLine);

            out.close();

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Cerrado");
        }
    }

    public String createResponse() {
        return "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n" + "<!DOCTYPE html>" + "<html>" + "<head>"
                + "<meta charset=\"UTF-8\">" + "<title>Concurrent Server</title>\n" + "</head>" + "<body>"
                + "Concurrent Server"
                + "<img src='https://yt3.ggpht.com/ytc/AKedOLQQOBfPPzh-vTH-tz76NykBAc2aU9r4z4UkeJog=s900-c-k-c0x00ffffff-no-rj'"
                + "</body>" + "</html>";
    }
}