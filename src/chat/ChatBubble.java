package chat;

import javax.swing.JLabel;

public class ChatBubble extends JLabel {
	
	final int WIDTH = 300;
	final int HEIGHT = 50;

	ChatBubble(String text, int position){
		this.setBounds(10, position * 60 + 10, WIDTH, HEIGHT);
		this.setBackground(Panel.darkBlue);
		this.setForeground(Panel.beige);
		this.setOpaque(true);
		this.setText(text);
	}

}
