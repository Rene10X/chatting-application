package chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	final int SCREEN_WIDTH = 1200;
	final int SCREEN_HEIGHT = 800;
	
	SearchBar searchBar;
	SelectedUser selectedUser;
	UserChat userChat;
	UsersList usersList;
	
	public static Color darkBlue = new Color(0x05396B);
	public static Color blueGreenish = new Color(0x389583);
	public static Color green = new Color(0x5CDB94);
	public static Color lightGreen = new Color(0x8DE4AF);
	public static Color beige = new Color(0xEDF4E0);
	
	
	Panel(){	
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setLayout(null);
		
		searchBar = new SearchBar();
		this.add(searchBar);		
		
		selectedUser = new SelectedUser();
		this.add(selectedUser);
		
		usersList = new UsersList(selectedUser);
		this.add(usersList);
		
		userChat = new UserChat();
		this.add(userChat);
		
		new Client(userChat);
	}
	


}
