package paket2;
import javax.swing.*;



import java.awt.*;
import java.util.*;
import java.util.Timer;

import java.math.*;
import java.io.File; 
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
public class Gui extends Frame {
	 static boolean sequence=false;//if the memorised sequence is being playing
	
	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException {

		 JFrame frame = new JFrame("Frame");	//creates a JFrame
			 frame.setSize(1000, 800);
			  frame.setLayout(null);  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

int broi[]= {10,20}; // broi[0]-number of seconds for memorising sequences; broi[1] - number of keys

 boolean playing=true ;//boolean for whether the app is running
int position=0;//the second that is played at the moment

		 Key keys[][]=new Key[broi[0]][broi[1]];
			for(int i=0;i<broi[0];i++) {
				for(int j=0;j<broi[1];j++) {
					keys[i][j]=new Key(j+1+".wav",i,j);//creates a Key
					frame.add(keys[i][j].checkBox);// adds the checkboxes for every key for every second
				}
			}
			
			frame.setVisible(true);
			while(playing) {   
				if( sequence) {
		position++;

		if(position==broi[0]) {
			position=0;		
		}
				}
				 Thread.sleep(1000);//stopping the operations in the while for a second(1000 ms)
	}   
		}

}
