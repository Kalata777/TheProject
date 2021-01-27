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
	 static boolean sequence=false;
	
	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException {

		 JFrame frame = new JFrame("Frame");
			 frame.setSize(1000, 800);
			  frame.setLayout(null);  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

int broi[]= {10,20};

 boolean playing=true ;
int position=0;
Graphics canvas=null;
Graphics2D canvas2 = (Graphics2D) canvas;
JButton b=new JButton("Play");  
playButton.setBounds(400,300,95,30);  
			    frame.add(b);
		 Klavish klavishi[][]=new Klavish[broi[0]][broi[1]];
			for(int i=0;i<broi[0];i++) {
				for(int j=0;j<broi[1];j++) {
					keys[i][j]=new Key(j+1+".wav",i,j);
					frame.add(keys[i][j].checkBox);
				}
			}
			b.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {}
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==b) { 
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
				
			JLabel Text[] = new JLabel[broi[1]];
			JLabel	playingPosition=new JLabel();
			playingPosition.setText("$");
			playingPosition.setBounds(100+keys[0][0].size1*position, keys[0][0].size2*broi[1], 40, 40);
			frame.getContentPane().add(playingPosition);
			for(int k=0;k<broi[1];k++) {
				Text[k]=new JLabel();
				Text[k].setText("key"+(k+1));
				Text[k].setBounds(0, keys[0][0].size2*k,100, 40);
				frame.getContentPane().add(Text[k]);
			}
			frame.setVisible(true);
			while(playing) {   
				if( sequence) {
	kalata(keys,broi[1],position);
		position++;
		playingPosition.setBounds(85+keys[0][0].size1*(position), keys[0][0].size2*broi[1], 40, 40);
		if(position==broi[0]) {
			position=0;		
		}
				}
				 Thread.sleep(1000);
	}   
		}
	static void kalata(Key a[][],int m, int k) throws UnsupportedAudioFileException {
		   for(int j=0;j<m;j++) {
			a[k][j].play();
		   }  
	}
}
