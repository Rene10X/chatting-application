package chat;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class UserChat extends JPanel{
	
	final int WIDTH = 850;
	final int HEIGHT = 730;
	
	ChatBubble chatBubble;
	TextInput textInput;
	
	UserChat(){		
		this.setLayout(null);
		this.setBorder(new LineBorder(Panel.beige, 1));
		
		this.setBounds(350, 70, WIDTH, HEIGHT);
		this.setBackground(Panel.lightGreen);
		
		textInput = new TextInput();
		this.add(textInput);
		
		chatBubble = new ChatBubble("testing");
		this.add(chatBubble);
	}

}
