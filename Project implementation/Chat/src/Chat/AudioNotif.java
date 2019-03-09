package Chat;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioNotif {
	
	private static Clip incommingClip;
	private static Clip outgoingClip;
	private static Clip systemClip;
	
	public static void playIncomming() {
		incommingClip.setFramePosition(0);
		incommingClip.start();
	}
	
	public static void playOutgoing() {
		outgoingClip.setFramePosition(0);
		outgoingClip.start();
	}
	
	public static void playSystem() {
		systemClip.setFramePosition(0);
		systemClip.start();
	}
	
	public static void loadAudioClips() {
		AudioInputStream incomming = null;
		AudioInputStream outgoing = null;
		AudioInputStream systemSound = null;
		try {
			incomming = AudioSystem.getAudioInputStream(Main.class.getResource("/sounds/incoming_message.wav"));
			incommingClip = AudioSystem.getClip();
			incommingClip.open(incomming);
			
			outgoing = AudioSystem.getAudioInputStream(Main.class.getResource("/sounds/outgoing_message.wav"));
			outgoingClip = AudioSystem.getClip();
			outgoingClip.open(outgoing);
			
			systemSound = AudioSystem.getAudioInputStream(Main.class.getResource("/sounds/system_message.wav"));
			systemClip = AudioSystem.getClip();
			systemClip.open(systemSound);
		} catch (UnsupportedAudioFileException aE) {
			if (aE.getMessage() != null) {
				System.out.println("Unable to play sound clip:" + System.getProperty("line.separator") + aE.getMessage());
			}
		} catch (IOException ioE) {
			if (ioE.getMessage() != null) {
				System.out.println("Unable to play sound clip:" + System.getProperty("line.separator") + ioE.getMessage());
			}
		} catch (LineUnavailableException lineE) {
			if (lineE.getMessage() != null) {
				System.out.println("Unable to play sound clip:" + System.getProperty("line.separator") + lineE.getMessage());
			}
		} finally {
			if (incomming != null) {
				try {
					incomming.close();
				} catch (IOException e) {
					
				}
			}
			
			if (outgoing != null) {
				try {
					outgoing.close();
				} catch (IOException e) {
					
				}
			}
			
			if (systemSound != null) {
				try {
					systemSound.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
	
	public static void closeClips() {
		if (outgoingClip != null) {
			outgoingClip.close();
		}
		if (incommingClip != null) {
			incommingClip.close();
		}
		if (systemClip != null) {
			systemClip.close();
		}
	}
}
