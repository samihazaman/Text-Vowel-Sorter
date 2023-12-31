import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;



//implements ActionListener to handle action events when an user clicks on a menu item
public class FileMenuHandler implements ActionListener {
	
   WordGUI WordGUI;
   TextArea a, e, i, o, u, other;
   Container cPane;


   //passes the WordGUI as parameter
   public FileMenuHandler (WordGUI wg) {
	   WordGUI = wg;
   }
   
   //A method that sets up menu items for Open and Quit
   public void actionPerformed(ActionEvent event) {
	   
      String  menuName;
      menuName = event.getActionCommand();
      
      if (menuName.equals("Open"))
         openFile( ); 
      
      else if (menuName.equals("Quit"))
         System.exit(0);
      
   } //actionPerformed

   
   //A method that allows the user to choose a file
    private void openFile( ) {
    	
       JFileChooser chooser;
       int status;
       
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       
       if (status == JFileChooser.APPROVE_OPTION) 
    	   
          readSource(chooser.getSelectedFile());
       
       else 
    	   
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    
    
    //A method that reads in the chosen file, opens the file and displays it to the six cells of the grid layout
    private void readSource(File chosenFile) {
    	//Creates a tree map to sort the words
        TreeMap<Word, Word> treeMap = new TreeMap<Word, Word>();

    	//gets the name of the chosen file
       String chosenFileName = chosenFile.getPath();
       TextFileInput inFile = new TextFileInput(chosenFileName);
       
	   String word;

	   //reads in a word 
       word = inFile.readLine();
       
	   /*Looks for words starting with a specific letter using the charAt method
	   and appends it into the respective row and column
	   */
       while (word != null) {
    	   try {
           Word w = new Word(word);
           treeMap.put(w, null); 
    	   }
    	   catch(IllegalWordException iwe) {
               System.out.println("Invalid word: "+word);
           }
           word = inFile.readLine();
       }

           //Print the map iteratively
           Set set = treeMap.entrySet();
           Iterator it = set.iterator();
           Map.Entry<Word,Word> me;
           while (it.hasNext()) {
               me = (Map.Entry) it.next();
               
               WordGUI.distributeToCells(me.getKey().getWord());
               //System.out.println(me.getValue());
       
           }
}
    
}