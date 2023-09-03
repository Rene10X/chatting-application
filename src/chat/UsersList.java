package chat;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class UsersList extends JPanel{
	
	UserHandle userHandle;
	
	static UserHandle[] usersHandles = new UserHandle[10];
	
	final int WIDTH = 350;
	final int HEIGHT = 730;
	
	UsersList(SelectedUser selectedUser){
		
		this.setLayout(null);		
		this.setBorder(new LineBorder(Panel.beige, 1));
		
		
		
		for(int i = 0; i <= 8; i++) {
			userHandle = new UserHandle("testing testing " + i, selectedUser);
			this.add(userHandle);
		}
		
				
		this.setBounds(0, 70, WIDTH, HEIGHT);
		this.setBackground(Panel.lightGreen);
	}

}
