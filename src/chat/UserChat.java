package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class UserChat extends JPanel implements MessageReceivedListener{
	
	final int WIDTH = 850;
	final int HEIGHT = 730;
	
	ChatBubble chatBubble;
	TextInput textInput;
	
	Timer timer;
	
	UserChat(){		
		this.setLayout(null);
		this.setBorder(new LineBorder(Panel.beige, 1));
		
		this.setBounds(350, 70, WIDTH, HEIGHT);
		this.setBackground(Panel.lightGreen);
		
		textInput = new TextInput(this);
		this.add(textInput);
		
	}
	
	public void createChatBubble(String text, int position) {	
		System.out.println("creating chat bubble");
		chatBubble = new ChatBubble(text, position);
		this.add(chatBubble);
		repaint();
	}

	@Override
	public void onMessageReceived(String message, int position) {
		createChatBubble(message, position);
		
	}



}
