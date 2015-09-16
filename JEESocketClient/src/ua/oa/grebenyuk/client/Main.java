package ua.oa.grebenyuk.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 4040);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        PrintStream writer = new PrintStream(os, true);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));

        BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true){
            String input = consoleReader.readLine();

            System.out.println("input message " + input);
            writer.println(input);

            if("exit".equals(input)){
                break;
            }

            String output = reader.readLine();
            System.out.println("output message " + output);
        }
        socket.close();
    }
}
