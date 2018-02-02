package battle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import cards.Card;
import cards.Deck;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import menu.Menu;
	
	public class BattleScreen extends FullFunctionScreen {
	ArrayList<Clip> allSounds;
	BattleBackend backend;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new BattleBackend();
	}

	public void initAllObjects(List<Visible> viewObjects) {
	/*	try {
	         // Open an audio input stream.           
	          File soundFile = new File("resources/boomm.wav"); //you could also get the sound file with an URL
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	         clip.stop();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	*/
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
		viewObjects.add(new Graphic(1200,70, 90, 80, "resources/quitButton.png"));
		viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
		viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png"));
		ClickableGraphic a = new ClickableGraphic(50, 650, 200, 100, "resources/dog.png"); 
		a.setAction(new Action() {
			public void act() {
				backend.playCard(Deck.deck.get(0));
			}
			
		});
		viewObjects.add(a);
		viewObjects.add(new TextLabel(660, 760, 50, 50, Integer.toString(Player.returnmana())));
		viewObjects.add(new Button(1200,65, 80, 70, "", new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		}));
		viewObjects.add(new Graphic(30,614,150,200, "resources/dog.png"));
		viewObjects.add(new Button(30,614,150,200,"", new Action() {

			@Override
			public void act() {
				backend.playCard(Deck.deck.get(1));
				
			}
			
		}));
		viewObjects.add(new Graphic(180,614,150,200, "resources/dog.png"));
		viewObjects.add(new Graphic(330,614,150,200, "resources/dog.png"));
		viewObjects.add(new Graphic(480,614,150,200, "resources/dog.png"));
	}
}
  
