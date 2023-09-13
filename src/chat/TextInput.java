package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextInput extends JPanel implements ActionListener{
	
	final int WIDTH = 850;
	final int HEIGHT = 70;
	
	int position = 0;
	
	JTextField textField;
	JButton sendButton;
	UserChat userChat;
	
	
	TextInput(UserChat userChat){
		this.setBackground(Panel.green);
		this.setBounds(0, 660, WIDTH, HEIGHT);
		this.setLayout(null);
		
		this.userChat = userChat;
				
		initializeTextField();
		initializeSendButton();
	}

	private void initializeSendButton() {
		
		sendButton = new JButton("send");
		this.add(sendButton);
		
		sendButton.addActionListener(this);
		sendButton.setBounds(750, 20, 70, 30);		
	}

	private void initializeTextField() {
		
		textField = new JTextField();
		this.add(textField);
		
		textField.setBounds(20, 20, 700, 30);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		//userChat.createChatBubble(textField.getText(), position);
		try {
			Client.sendMessage(textField.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		textField.setText("");
		position++;		
	}

}
