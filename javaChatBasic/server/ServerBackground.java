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
	private Socket socket; // 받아올 소캣
	private String msg;

	// 2. 사용자 정보 저장맵
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	// ==============METHODS==============
	// 1. setting
	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // 해쉬맵을 멀티스레드에 안전해지게 만든다.
			serverSocket = new ServerSocket(9999);
			
			//보스워커
			while (true) {
				// 방문자를 계속 받아서 스레드 리시버를 계속 생성한다.
				System.out.println("대기중...");
				socket = serverSocket.accept();// 클라이언트를 받음.
				System.out.println(socket.getInetAddress() + "에서 접속함.");

				// 새로운 사용자 스레드 클라스를 생성해서 소켓 정보를 넣는다.
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
		String message = nick + "님이 접속하셨습니다. \n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.put(nick, out);
	}

	// 3. REMOVE CLIENT
	public void removeClient(String nick) {
		String message = nick + "님이 나가셨습니다. \n";
		sendMessage(message);
		gui.appendMsg(message);
		clientMap.remove(nick); // 해당 사용자 제거
		
	}

	// 4. SEND MESSAGE
	public void sendMessage(String msg) {
		Iterator<String> iterator = clientMap.keySet().iterator();
		String key = "";
		while (iterator.hasNext()) {
			key = iterator.next(); // 키를 가져온다. 사용자의 nickname을 key로써 가져온다.
			try {
				clientMap.get(key).writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// =================== receiver Inner class =====================
	class Receiver extends Thread {
		// 리시버 할일 (워커 스레드)
		private DataInputStream in; // data input 스트림
		private DataOutputStream out; // data output 스트림
		private String nick;

		// constructor
		public Receiver(Socket socket) {
			try {
				this.out = new DataOutputStream(socket.getOutputStream());
				this.in = new DataInputStream(socket.getInputStream());
				this.nick = in.readUTF();

				// client 추가
				addClient(this.nick, out);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (in != null) {
					msg = in.readUTF(); // utf로 읽는다.
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (Exception e) {
				// 사용 접속 종료시 에러 발생
				removeClient(this.nick);
			}
		}
	}
	
	private ServerGUI gui;
	public void setGui(ServerGUI serverGUI) {
		this.gui = serverGUI;
	}

}