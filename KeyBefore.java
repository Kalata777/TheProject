  
package paket2;
import java.io.File;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;    
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;

import java.io.IOException; 
import java.util.Scanner;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
public class Klavish extends JPanel {
Long currentFrame; 
 Clip clip; 
 AudioInputStream audioInputStream; 
boolean willplay;
String str;
File soundFile;
int size1=20;
int size2=40;

JCheckBox checkBox = new JCheckBox(""); 




public Klavish( String str,int i,int j){
this.checkBox.setBounds(i*this.size1, j*this.size2, size1, size2);
	this.willplay=willplay;
	this.str=str;

	try {
		//soundFile= new File(this.str);
		audioInputStream =    AudioSystem.getAudioInputStream(Klavish.class.getResource(this.str));
	
		try {
			clip = AudioSystem.getClip();
			System.out.println("puska se");
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	} catch (UnsupportedAudioFileException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
LineUnavailableException  
{  //it is used for restarting a sound once it has been opened
audioInputStream =  AudioSystem.getAudioInputStream(Klavish.class.getResource(this.File)); 
clip = AudioSystem.getClip();
clip.open(audioInputStream); 
 
} 
public void play() {
	if(this.checkBox.isSelected()) {
    try {
    
    	clip.open(audioInputStream);
      resetAudioStream()
        clip.start();
    	System.out.println("puska se"+clip.isActive()+clip.isOpen());
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
}

}
