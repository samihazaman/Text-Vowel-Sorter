import java.util.regex.*;

public class Word implements Comparable<Word> {
	
	public String word;
  
  	//Constructor with string parameter 
  	public Word(String w) { 
  		  
  		//a regular expression that checks if the words matches the a-z or A-Z pattern
  		if ((!w.matches("[a-zA-Z]+"))) {
  			
  			throw new IllegalWordException("Invalid word: " + w); 	
  		 }
  			word = w;  
  	}
  		

	//set method which sets word as a string
  	public void setWord(String s) {
  		word = s; 
  		}
  
  	//get method that returns word
  	public String getWord() { 
  		return word; 
  	}
  	
  	//equals method that checks if the two objects are equal. It will return true if all conditions are met   	
  	public boolean equals(Object other) {
  		return (other != null && getClass() == other.getClass() && word.equals(((Word) other).word));
  	}
  	
  	//A toString method that returns the object as string 
  	public String toString() { 
  		return word; 
  	}
  	
   //compareTo method that compares a string to another string 
  	public int compareTo(Word other) { 
  		return this.word.compareTo(other.word); 
  	}
  
  }
 

	