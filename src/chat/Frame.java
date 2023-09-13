package chat;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	Panel panel;
	Client client;
	
	Frame(){
		panel = new Panel();
		
		this.setTitle("vestlemis rakendus");
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
