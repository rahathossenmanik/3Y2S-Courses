import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MailSending {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException {
		Socket socket = new Socket("localhost", 25);
		PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		pr.println("HELO " + "localhost");
		System.out.println("Response1: " + br.readLine());

		pr.println("MAIL FROM:" + "manikrahathossen@manikarea.com");
		System.out.println("Response2: " + br.readLine());

		pr.println("RCPT TO:" + "rahathossenmanik@manikarea.com");
		System.out.println("Response3: " + br.readLine());

		pr.println("DATA");
		System.out.println("Response4: " + br.readLine());

		pr.println("Subject: SMTP Test Mail");
		pr.println("I am Manik");

		pr.println(".");
		System.out.println("Response5: " + br.readLine());
	}
}
