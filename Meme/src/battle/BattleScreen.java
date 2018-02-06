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
	ArrayList<ClickableGraphic> currentField;
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
	private ArrayList<Card> cardsInHand;
	
	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new BattleBackend();
		currentField = new ArrayList<ClickableGraphic>();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		cardsInHand = new ArrayList<Card>();
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
		b = new ClickableGraphic(180,614,150,200, "resources/pog.png");
		c = new ClickableGraphic(330,614,150,200, "resources/pika.png");
		d = new ClickableGraphic(480,614,150,200, "resources/shenrun.png");
		
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
			//	backend.playCard(backend.player.hand.get(0), 0);
				activateCardMon();
				for(int i = 0;i<currentField.size();i++) {
					viewObjects.add(currentField.get(i));
				}
			}
			
		});
		b.setAction(new Action() {
			public void act() {
			//	backend.playCard(backend.player.hand.get(1), 1);
				activateCardMon(b);
				for(int i = 0;i<currentField.size();i++) {
					viewObjects.add(currentField.get(i));
				}
			}
			
		}); 
		c.setAction(new Action() {
			public void act() {
			//	backend.playCard(backend.player.hand.get(2), 2);
				activateCardMon(c);
				for(int i = 0;i<currentField.size();i++) {
					viewObjects.add(currentField.get(i));
				}
			}
			
		}); 
		d.setAction(new Action() {
			public void act() {
			//	backend.playCard(backend.player.hand.get(3), 3);
				activateCardMon(d);
				for(int i = 0;i<currentField.size();i++) {
					viewObjects.add(currentField.get(i));
				}
			}
			
		});
		viewObjects.add(a);
		viewObjects.add(b);
		viewObjects.add(c);
		viewObjects.add(d);

		viewObjects.add(manaslot);
		
		viewObjects.add(new Button(1200,65, 80, 70, "", new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
				drawACard("resources/saltbae.png"); 
				viewObjects.add(currentHand.get(currentHand.size()-1));
				System.out.println("dfsdf");
			}
		}));
		
	//	ClickableGraphic test = new ClickableGraphic(300,460,120,160, "resources/dog.png");
	//	viewObjects.add(test);
	}
	public void activateCardMon(ClickableGraphic card) {
		currentHand.remove(card);
		updateHand();
		updateField();
		update();
	}
	public void activateCardSpell(int pos) {
		
	}
	public void drawACard(String imageLoc) {
		int counter = 30;
		for (int i = 0; i<currentHand.size(); i++) {
			counter= counter+ 150;
		}
		currentHand.add(new ClickableGraphic(counter, 614, 150, 200, imageLoc));
	}
	public void updateHand() {
		int counter = 30;
		for(int i = 0; i<currentHand.size();i++) {
			currentHand.get(i).setX(counter);
			counter=counter+150;
		}
	}
	public void updateField() {
		int counter = 300;
			if (currentField.size()<=0) {
			currentField.add(new Graphic(counter, 460, 120, 160, "resources/dog.png"));
			counter= counter+ 100;
			}
			else {
				for(int i =0; i<currentField.size();i++) {
					counter= counter+100;
				}
				currentField.add(new Graphic(counter, 460, 120, 160, "resources/dog.png"));
			}
	}
}