package chat;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserHandle extends JPanel{
	
	final int WIDTH = 350;
	final int HEIGHT = 81;
	
	private ImageIcon imageIcon;
	private JLabel textLabel;
	 
	String name; 
	
	SelectedUser selectedUser;
	 
	
	UserHandle(String textLabel, SelectedUser selectedUser){
		
		this.selectedUser = selectedUser;
		this.name = textLabel;
		
		this.setLayout(null);
		this.setBackground(Panel.lightGreen);
		
		int positonToBeAssigned = 0;
		
		for(UserHandle e : UsersList.usersHandles) {
			if(e == null) {
				UsersList.usersHandles[positonToBeAssigned] = this;
				break;
			} else {
				positonToBeAssigned++;
			}
		}
		
		int postionY = positonToBeAssigned * HEIGHT;
		
		this.setBounds(0, postionY + 1, WIDTH - 1, HEIGHT);
		
		initializeTextLabel(textLabel);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectedUser.selectUser(name);				
			}
			
			public void mouseEntered(MouseEvent e) {
                // Change the background color when the mouse hovers over
                setBackground(Panel.blueGreenish);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore the original background color when the mouse exits
                setBackground(Panel.lightGreen);
            }
			
		});
	}
	
	
	

	private void initializeTextLabel(String text) {
		
		textLabel = new JLabel(text);
		textLabel.setForeground(Panel.darkBlue);
		textLabel.setBounds(70, 20, 150, 20);
		
		this.add(textLabel);
	}

}
