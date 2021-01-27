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
//Graphics canvas=null;
//Graphics2D canvas2 = (Graphics2D) canvas;
JButton playButton=new JButton("Play");  
playButton.setBounds(400,300,95,30);  
			    frame.add(playButton);
		 Key keys[][]=new Key[broi[0]][broi[1]];
			for(int i=0;i<broi[0];i++) {
				for(int j=0;j<broi[1];j++) {
					keys[i][j]=new Key(j+1+".wav",i,j);//creates a Key
					frame.add(keys[i][j].checkBox);// adds the checkboxes for every key for every second
				}
			}
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==playButton) { // checks if the button is clicked
		if(sequence) {
			sequence=false;
			playButton.setText("play");
		}else {
			sequence=true;
			playButton.setText("stop");
		}
					}
				}
				});
				
		
			for(int k=0;k<broi[1];k++) {
				keyText[k]=new JLabel();
				keyText[k].setText("key"+(k+1));
				keyText[k].setBounds(0, keys[0][0].size2*k,100, 40);
				frame.getContentPane().add(keyText[k]);
			}
			frame.setVisible(true);
			while(playing) {   
				if( sequence) {
		callPlay(keys,broi[1],position);
		position++;
		playingPosition.setBounds(85+keys[0][0].size1*(position), keys[0][0].size2*broi[1], 40, 40);//changing x and y of the sign $
		if(position==broi[0]) {
			position=0;		
		}
				}
				 Thread.sleep(1000);//stopping the operations in the while for a second(1000 ms)
	}   
		}
	static void callPlay(Key a[][],int m, int k) throws UnsupportedAudioFileException {
		   for(int j=0;j<m;j++) {
			a[k][j].play();//calls the play function of the class Key
		   }  
	}
}
