import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

//A GUI that extends the JFrame
public class WordGUI extends JFrame {
	static Container cPane;
	static int[] counter = new int[6];
	//Creates six text areas and assigns a letter and other words to a specific row and column

	static TextArea a = new TextArea(0,0);
	static TextArea e = new TextArea(0,1);
	static TextArea i = new TextArea(0, 2);
	static TextArea o = new TextArea(1,0);
	static TextArea u = new TextArea(1,1);
	static TextArea other = new TextArea(1,2); 
   	
	//Sets up the GUI object with title, size, location, grid, etc.
	public WordGUI() {
		setTitle("Project 3");
		setSize(500,500);
		setLocation(200,200);
		setLayout(new GridLayout(2,3));
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	    setVisible(true);
	    
	    //WordGUI = new WordGUI();
		
		cPane = getContentPane();
	       
	    //Adds six text areas to the content pane

		cPane.add(a);
		cPane.add(e);
		cPane.add(i);
		cPane.add(o);
		cPane.add(u);
		cPane.add(other);
		
		
	    for(int i=0; i<6; i++) {
	       counter[i] = 0;
	          
	    }
	}

	//creates a menu
	//clicking on open or on quit will call the actionPerformed method of the FileMenuHandler class
	 private void createMenu( ) {
	      JMenuItem item;
	      JMenuBar menuBar  = new JMenuBar();
	      JMenu fileMenu = new JMenu("File");
	      FileMenuHandler fmh  = new FileMenuHandler(this);

	      item = new JMenuItem("Open");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      fileMenu.addSeparator();           //add a horizontal separator line
	    
	      item = new JMenuItem("Quit");       //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	    
	   } //createMenu

	 public void distributeToCells (String word) {
		 //Find words starting with a or A
    	 if (word.charAt(0) == 'a' || word.charAt(0) == 'A') {
    		 a.append(++counter[0]+": "+word + "\n"); 
    	 }
    	 
    	 //Find words starting with e or E
    	 else if (word.charAt(0) == 'e' || word.charAt(0) == 'E') {
    		 e.append(++counter[1]+": "+word  + "\n"); 
    	 }
    	 
    	//Find words starting with i or I
    	 else if (word.charAt(0) == 'i' || word.charAt(0) == 'I') {
    		 i.append(++counter[2]+": "+word  + "\n"); 
    	 }
    	 
    	//Find words starting with o or O
    	 else if (word.charAt(0) == 'o' || word.charAt(0) == 'O') {
    		 o.append(++counter[3]+": "+word  + "\n"); 
    	 }
    	 
    	//Find words starting with u or U
    	 else if (word.charAt(0) == 'u' || word.charAt(0) == 'U') {
    		 u.append(++counter[4]+": "+word + "\n"); 

    	 }
    	 
    	 //Adds the rest of the words if none of the words starts with the previous letters
    	 else {
    		 other.append(++counter[5]+": "+word + "\n"); 

    	 } 
		 
	 }
}

