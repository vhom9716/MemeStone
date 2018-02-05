package battle;

import java.awt.Color;
import java.awt.Font;
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
	ArrayList<ClickableGraphic> currentHand;
	ArrayList<Graphic> currentField;
	BattleBackend backend;
	TextLabel manaslot;
	ClickableGraphic a;
	ClickableGraphic b;
	ClickableGraphic c;
	ClickableGraphic d; 
	Graphic f1;
	Graphic f2;
	Graphic f3;
	Graphic f4;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new BattleBackend();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		currentHand = new ArrayList<ClickableGraphic>();
		manaslot = new TextLabel(850, 763, 50, 50, Integer.toString(Player.returnmana())+"/"+"10");
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
		 a = new ClickableGraphic(30,614,150,200, "resources/dog.png");
		 b = new ClickableGraphic(180,614,150,200, "resources/dog.png");
		 c = new ClickableGraphic(330,614,150,200, "resources/dog.png");
		 d = new ClickableGraphic(480,614,150,200, "resources/dog.png");
		currentHand.add(a);
		currentHand.add(b);
		currentHand.add(c);
		currentHand.add(d); 
		
		
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(800,760,60,60, "resources/mana.png"));
		viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
		viewObjects.add(new Graphic(1200,70, 90, 80, "resources/quitButton.png"));
		viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
		viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png")); 
		a.setAction(new Action() {
			public void act() {
				backend.playCard(backend.player.hand.get(0), 0);
			}
			
		});
		b.setAction(new Action() {
			public void act() {
				backend.playCard(backend.player.hand.get(1), 1);
			}
			
		}); 
		c.setAction(new Action() {
			public void act() {
				backend.playCard(backend.player.hand.get(2), 2);
			}
			
		}); 
		d.setAction(new Action() {
			public void act() {
				backend.playCard(backend.player.hand.get(3), 3);
			}
			
		});
		viewObjects.add(a);
		viewObjects.add(b);
		viewObjects.add(c);
		viewObjects.add(d);
		manaslot.setBorderColor(Color.RED);
		viewObjects.add(manaslot);
		
		viewObjects.add(new Button(1200,65, 80, 70, "", new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		}));
		
		ClickableGraphic test = new ClickableGraphic(660,460,120,160, "resources/dog.png");
		viewObjects.add(test);
	}
	public void activateCardMon(int pos) {
		if (pos == 0) {
			currentHand.remove(0);
			updateHand();
			update();
		}
		if (pos == 1) {
			currentHand.remove(1);
			updateHand();
			update();
		}
		if (pos == 2) {
			currentHand.remove(2);
			updateHand();
			update();
		}
		if (pos == 3) {
			currentHand.remove(3);
			updateHand();
			update();
		}
	}
	public void activateCardSpell(int pos) {
		
	}
	public void updateHand() {
		int counter = 30;
		for(int i = 0; i<currentHand.size();i++) {
			currentHand.get(i).setX(counter);
			counter=counter+150;
		}
	}
	public void updateField() {
		
	}
}