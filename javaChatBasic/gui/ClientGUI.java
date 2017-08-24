package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.ClientBackground;

public class ClientGUI extends JFrame implements ActionListener {

	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private ClientBackground client = new ClientBackground();
	private static String nickname;

	// CONSTRUCTOR
	public ClientGUI() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle("클라이언트");

		client.setGui(this);
		client.setNickname(nickname);
		client.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = nickname + " : " + jtf.getText() + "\n";
		client.sendMessage(msg);
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("닉네임을 설정하세요 : ");
		nickname = scanner.nextLine();
		scanner.close();
		new ClientGUI();
	}

}
