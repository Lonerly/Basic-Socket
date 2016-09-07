import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) throws Exception {

		SocketClient client = new SocketClient();
		client.run();

	}

	public void run() throws Exception {

		Socket socket = new Socket("localhost", 5555);
		PrintStream print = new PrintStream(socket.getOutputStream());
		print.println("Hello to SERVER from CLIENT!");

		InputStreamReader input = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer = new BufferedReader(input);

		String message = buffer.readLine();
		System.out.println(message);
	}

}
