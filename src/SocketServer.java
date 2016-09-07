import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws Exception {

		SocketServer server = new SocketServer();
		server.run();

	}

	public void run() throws Exception {

		ServerSocket SrvSocket = new ServerSocket(5555);
		Socket socket = SrvSocket.accept();
		InputStreamReader stream = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer = new BufferedReader(stream);

		String message = buffer.readLine();
		System.out.println(message);

		PrintStream print = new PrintStream(socket.getOutputStream());

		if (message != null) {

			print.println("Message received!");
			SrvSocket.close();

		}

	}

}
