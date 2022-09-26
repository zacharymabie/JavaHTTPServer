import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.Date;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;

public class HTTPServer{
    public static void main(String[] args) throws IOException{
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080...");
        while(true){
            // //blocking method, blocks until a client connects to server
            // Socket clientSocket = server.accept();
            // //InputStream will read content of request
            // InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            // //better to use BufferedReader because browser will send multiple lines
            // BufferedReader reader = new BufferedReader(isr);
            // String line = reader.readLine();
            // while (!line.isEmpty()){
            //     System.out.println(line);
            //     line = reader.readLine();
            // }

            //using try block, socket will automatically be closed once response is sent
            try (Socket socket = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                //returns an output stream for writing bytes to this socket,
                //throws IO exception if socket is not connected. 
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));

            }
        }
    }
}
