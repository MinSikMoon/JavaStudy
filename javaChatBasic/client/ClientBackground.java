package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import gui.ClientGUI;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGUI gui;
	private String msg;
	private String nickName;

	// METHODS
	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();

	}

	public void connect() {
		try {
			socket = new Socket("[서버ip]", 9999);
			System.out.println("서버에 연결됨");
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// 접속하자마자 닉네임 전송 : 사용자 등록
			out.writeUTF(nickName);
			System.out.println("클라이언트 : 닉네임 전송완료");
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(String msg) {
		try {
			out.writeUTF(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}

}
