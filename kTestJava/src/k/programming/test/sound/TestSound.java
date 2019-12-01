package k.programming.test.sound;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;

public class TestSound {

	public static void main(String[] args) {
		try {
			System.out.println("k>TestSound.main - :1111" );	//t+++
			//playSound("sounds/chime1.wav");
			playSound();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	static void playSound() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
	    File f = new File("./" + "sounds/chime1.wav");
	    //File f = new File("./" + "sounds/dingdong.wav");
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);
	    clip.start(); 
	    AudioPlayer.player.start(audioIn);  
	    
	    try {
			Thread.sleep(clip.getMicrosecondLength()/1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("k>TestSound.main - :2222" );	//t+++
	}	
}
