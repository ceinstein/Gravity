import java.util.Scanner;
import java.lang.Thread;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class UserInput implements KeyListener{
	
	public char key = '\0';
	public Space s;
	public boolean released = false;

	public UserInput(Space _s){
		this.key = '\0';
		this.s = _s;
	}

	public void keyTyped(KeyEvent e){
		System.out.println(e.getKeyChar());
		//System.out.println("Typed!");
		//this.key = e.getKeyChar();
		this.released = true;
		this.key = e.getKeyChar();
		//this.s.display();
		//System.out.println(this.key);
		try{
			Thread.sleep(20);
		}catch (Exception event){

		}
	}

	public void keyPressed(KeyEvent e){
		
	}

	public void keyReleased(KeyEvent e){
		
		
	}

	public char getKey(){
		return this.key;
	}

	public void readKey(){
		this.key = '\0';
	}

}


	

	

