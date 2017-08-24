package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gui.ServerGUI;

public class ServerBackground {
	// 1. properties
	private ServerSocket serverSocket;
	private Socket socket; // �޾ƿ� ��Ĺ
	private String msg;

	// 2. ����� ���� �����
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	// ==============METHODS==============
	// 1. setting
	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // �ؽ����� ��Ƽ�����忡 ���������� �����.
			serverSocket = new ServerSocket(9999);
			
			//������Ŀ
			while (true) {
				// �湮�ڸ� ��� �޾Ƽ� ������ ���ù��� ��� �����Ѵ�.
				System.out.println("�����...");
				socket = serverSocket.accept();// Ŭ���̾�Ʈ�� ����.
				System.out.println(socket.getInetAddress() + "���� ������.");

				// ���ο� ����� ������ Ŭ�󽺸� �����ؼ� ���� ������ �ִ´�.
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
		} catch (Exception e) {
		}
	}

	// ====methods=========
	// 1. MAIN
	public static void main(String[] args) {

	}

	// 2. ADD CLIENT
	public void addClient(String nick, DataOutputStream out) throws IOException {
		String message = nick + "���� �����ϼ̽��ϴ�. \n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.put(nick, out);
	}

	// 3. REMOVE CLIENT
	public void removeClient(String nick) {
		String message = nick + "���� �����̽��ϴ�. \n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.remove(nick); // �ش� ����� ����
		
	}

	// 4. SEND MESSAGE
	public void sendMessage(String msg) {
		Iterator<String> iterator = clientMap.keySet().iterator();
		String key = "";
		while (iterator.hasNext()) {
			key = iterator.next(); // Ű�� �����´�. ������� nickname�� key�ν� �����´�.
			try {
				clientMap.get(key).writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// =================== receiver Inner class =====================
	class Receiver extends Thread {
		// ���ù� ���� (��Ŀ ������)
		private DataInputStream in; // data input ��Ʈ��
		private DataOutputStream out; // data output ��Ʈ��
		private String nick;

		// constructor
		public Receiver(Socket socket) {
			try {
				this.out = new DataOutputStream(socket.getOutputStream());
				this.in = new DataInputStream(socket.getInputStream());
				this.nick = in.readUTF();

				// client �߰�
				addClient(this.nick, out);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (in != null) {
					msg = in.readUTF(); // utf�� �д´�.
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (Exception e) {
				// ��� ���� ����� ���� �߻�
				removeClient(this.nick);
			}
		}
	}
	
	private ServerGUI gui;
	public void setGui(ServerGUI serverGUI) {
		this.gui = serverGUI;
	}

}