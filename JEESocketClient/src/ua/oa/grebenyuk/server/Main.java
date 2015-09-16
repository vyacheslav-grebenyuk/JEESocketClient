package ua.oa.grebenyuk.server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(4040);
        while (true) {
            Socket clientSocket = server.accept();
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));

            PrintStream writer = new PrintStream(os, true);

            while (true) {
                String input = reader.readLine();

                System.out.println("input " + input);

                if("exit".equals(input)){
                    break;
                }

                System.out.println("send " + input);

                writer.println(input);
            }
        }
    }
}
