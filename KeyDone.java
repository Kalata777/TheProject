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
public class Key extends JPanel {
Clip clip; //controls the .wav file
 AudioInputStream audioInputStream; //the clip is getting the .wav through it
boolean willPlay;//if the key is supposed to play its sound
String File;//the path of the file of the sound
static int size1=20;//size for x for the checkbox
static int size2=30;//size for y for the checkbox

JCheckBox checkBox = new JCheckBox(""); 

public Key( String str,int i,int j){
this.checkBox.setBounds(i*this.size1+100, j*this.size2, size1, size2);
	this.willPlay=willPlay;
	this.File=str;//name of the file
//the try and catches are for checking if there's a problem with getting the .wav files 
	try {
		audioInputStream =    AudioSystem.getAudioInputStream(Klavish.class.getResource(this.File));
	//getting the file through audioInputStream
		try {
			clip = AudioSystem.getClip();
	//the clip getting the audioInputStream in order to be able to do different operations with it
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
public void play() throws UnsupportedAudioFileException { //plays the sound of the key
	if(this.checkBox.isSelected()) {
    try {
    if(clip.isOpen()) {
    	//if the sound has already been played
    	clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        clip.start();
   
    }else {
    	//if the sound hasn't been played
    	clip.open(audioInputStream);
        clip.start();
    }
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

