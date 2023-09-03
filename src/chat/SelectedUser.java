package chat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SelectedUser extends JPanel{
	
	final int WIDTH = 850;
	final int HEIGHT = 70;
	
	boolean userSelected = false;
	
	JLabel selectedUserName;
	
	SelectedUser(){
		
		this.setBorder(new LineBorder(Panel.beige, 1));
		this.setLayout(null);
		

		
		this.setBounds(350, 0, WIDTH, HEIGHT);
		this.setBackground(Panel.lightGreen);
		
		
	}
	
	public void selectUser(String userName) {
		if(!userSelected) {
			selectedUserName = new JLabel(userName);
			
			selectedUserName.setBounds(60, 20, 100, 30);
			this.add(selectedUserName);
			userSelected = true;
		} else {
			selectedUserName.setText(userName);
		}		
		selectedUserName.setForeground(Panel.darkBlue);
		
		repaint();
	}
}
