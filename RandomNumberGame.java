import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//In this game the user enters a number between 1 and 20. This number gets compared to a random picked number.
//If entered number is equal to random number then the user won, otherwise the user lost.

public class RandomNumberGame extends JFrame {
	int randomNumber, guess;
	private JButton button;
	private JTextField textfield;
	//create three labels - 1. enter a number between 1 and 10 - 2. win/loss - 3. says what the number was
	private JLabel enterNumLabel;
	private JLabel resultLabel;
	private JLabel randomLabel;
	
	//Constructor
	public RandomNumberGame() {
		setLayout(new FlowLayout()); //makes everything appear in window
		
		enterNumLabel = new JLabel("Enter a random number 1 - 20: ");
		add(enterNumLabel);//add first label to window
		
		textfield = new JTextField(5); //length of textfield
		add(textfield); //add textfield to window
		
		button = new JButton("Guess the number!");
		add(button); //add button to window
		
		resultLabel = new JLabel("");
		add(resultLabel);
		
		randomLabel = new JLabel("");
		add(randomLabel);
		
		event e = new event();
		button.addActionListener(e);
	}
	
	public class event implements ActionListener { //set what should happen when button is clicked
		public void actionPerformed(ActionEvent e) {
			randomNumber = (int)(Math.random() * 20 + 1); //Math.random is a double so we need to type cast to "int"
														//"+1", weil es sonst bei "0" anfangen würde --> jetzt 1-20
			//add catchblock to prevent errors e.g. so typed in a symbol or a letter instead of a number
			try {
				guess = (int) (Double.parseDouble(textfield.getText()));//scans textfield for text & turns text into int
				
				if(guess == randomNumber) { //compares guess with random picked number
					resultLabel.setText("Congrats! You won!");
				} else if(guess != randomNumber) {
					resultLabel.setText("Sorry! You lost!");
				}
				randomLabel.setText("The correct number was " + randomNumber+"."); //displays correct number
				
			} catch (Exception ex) {
				randomLabel.setText("Please enter numbers only!"); //if symbols or letters were entered, display this
			}
		}
	}
	
	public static void main(String[] args) {
		RandomNumberGame frame = new RandomNumberGame(); //create frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close program when click on exit
		frame.setVisible(true); //window is visible
		frame.setSize(400, 200); //size of window
		frame.setTitle("Number Guessing Game"); //Title of program	
	}
}
