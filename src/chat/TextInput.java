package chat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextInput extends JPanel{
	
	final int WIDTH = 850;
	final int HEIGHT = 70;
	
	JTextField textField;
	JButton sendButton;
	
	TextInput(){
		this.setBackground(Panel.green);
		this.setBounds(0, 660, WIDTH, HEIGHT);
		this.setLayout(null);
				
		initializeTextField();
		initializeSendButton();
	}

	private void initializeSendButton() {
		
		sendButton = new JButton("send");
		this.add(sendButton);
		
		// lisa action listener nii et kui seda nuppu vajutatakse siis see nupp votab textfieldilt texti ja viib selle chatbubblesse
		sendButton.setBounds(750, 20, 70, 30);		
	}

	private void initializeTextField() {
		
		textField = new JTextField();
		this.add(textField);
		
		textField.setBounds(20, 20, 700, 30);		
		
	}

}
