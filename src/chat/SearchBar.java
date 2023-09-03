package chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SearchBar extends JPanel{
	
	final int WIDTH = 350;
	final int HEIGHT = 70;
	
	JTextField searchInput;
	JButton searchButton;
		
	SearchBar(){
		
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setBackground(Panel.lightGreen);
		this.setLayout(null);
		
		this.setBorder(new LineBorder(Panel.beige, 1));

		
		initializeSearchInput();
		initializeSearchButton();
	}

	

		
	

	private void initializeSearchButton() {
		final int SEARCH_BUTTON_WIDTH = 75;
		final int SEARCH_BUTTON_HEIGHT = 25;
		
		
		searchButton = new JButton("search");
		//searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		searchButton.setForeground(Panel.darkBlue);
		searchButton.setBackground(Panel.green);
		
		searchButton.setBounds(250, 20, SEARCH_BUTTON_WIDTH, SEARCH_BUTTON_HEIGHT);
		
		this.add(searchButton);
		
	}

	private void initializeSearchInput() {
		final int SEARCH_INPUT_WIDTH = 200;
		final int SEARCH_INPUT_HEIGHT = 25;		
		
		searchInput = new JTextField();
		searchInput.setBackground(Panel.green);
		searchInput.setForeground(Panel.darkBlue);
		
		searchInput.setBounds(20, 20, SEARCH_INPUT_WIDTH, SEARCH_INPUT_HEIGHT);
		
		this.add(searchInput);
	}

	
}
