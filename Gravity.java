import java.util.Scanner;
import java.lang.Thread;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.JFrame;
class Gravity{
	
	public static char typed = '\0';

	public static void main(String[] args){

		Space space = new Space(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 1, 1);
		UserInput us = new UserInput(space);

		space.display();

		JFrame game = new JFrame("Gravity");
		game.setBounds(10,10,10,10);
		game.addKeyListener(us);
		game.setVisible(true);


		while(true){
			if(us.getKey() != '\0'){
				System.out.println(us.getKey() + " EE");
				typed = us.getKey();
				us.readKey();
			}

			

			space.updatePlayerInfo(0, typed);
			space.display();
			typed = '\0';

			try{
				Thread.sleep(100);
			}catch (Exception e){

			}
			
		}
	}




}