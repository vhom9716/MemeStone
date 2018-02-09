package battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
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
import cards.MonsterCard;
import cards.SpellCard;
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
	
	//slot arrayLists have the CardSlots while image arrayLists have the images that will be loaded onto the slots
	ArrayList<CardButton> handSlots;
	ArrayList<String> currentHandImages;
	ArrayList<CardButton> fieldSlots;
	ArrayList<String> currentFieldImages;

	private ArrayList<Card> cardsInHand;
	private ArrayList<Card> cardsOnField;
	
	
	BattleBackend backend;
	TextLabel manaslot;
	//od stuff
//	ClickableGraphic a;
//	ClickableGraphic b;
//	ClickableGraphic c;
//	ClickableGraphic d; 
//	Graphic f1;
//	Graphic f2;
//	Graphic f3;
//	Graphic f4;

	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new BattleBackend();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		BattleBackend.player.drawcard(4);
		cardsInHand = new ArrayList<Card>();
		cardsOnField = new ArrayList<Card>();
		handSlots = new ArrayList<CardButton>();
		fieldSlots = new ArrayList<CardButton>();
		currentHandImages = new ArrayList<String>();
		currentFieldImages = new ArrayList<String>();
		
		manaslot = new TextLabel(850, 763, 50, 50, Integer.toString(Player.returnmana())+"/"+"10");
		
		//Temp. For testing
		//Stuff will be changed in backend
		for(int i = 0; i < 4; i++) {
			System.out.println(BattleBackend.player.hand.get(i).getImage());
			currentHandImages.add(BattleBackend.player.hand.get(i).getImage());
		}
		//cardsInHand = backend.player.getHand();
		
		viewObjects.add(manaslot);
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(800,760,60,60, "resources/mana.png"));
		viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
		viewObjects.add(new Graphic(1200,70, 90, 80, "resources/quitButton.png"));
		viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
		viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png")); 

		
		generateHandSlots(); 	
		for(int i = 0; i < handSlots.size(); i++) { 
			viewObjects.add(handSlots.get(i));
		}
		
		generateFieldSlots();
		for(int i = 0; i < fieldSlots.size(); i++) {
			viewObjects.add(fieldSlots.get(i));
		}
		
		//Former Code at the Bottom

		
//		viewObjects.add(new Button(1200,65, 80, 70, "", new Action() {
//			@Override
//			public void act() {
//				Menu.menu.setScreen(Menu.screen1);
//				drawACard("resources/saltbae.png"); 
//				viewObjects.add(currentHand.get(currentHand.size()-1));
//				System.out.println("dfsdf");
//			}
//		}));

		viewObjects.add(new Button(1200,65, 80, 70, "", new Action() {
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
				System.out.println("dfsdf");
			}
		}));
		Graphic deck = new Graphic(1200, 600, 100, 200, "resources/cardBack.png");
		viewObjects.add(deck);
		
		ClickableGraphic end = new ClickableGraphic(1300, 400, 100, 60, "resources/endturn.png");
		end.setAction(new Action() {
			public void act() {
				System.out.println("heh");
				ArrayList<Card> hand = BattleBackend.player.hand;
				ArrayList<Card> deck = BattleBackend.player.deck;
				if(deck.size() > 0) {
					BattleBackend.player.drawcard(1); 
					currentHandImages.add(hand.get(hand.size() - 1).getImage());
					updateHand();
				}
			}
		}); 
		viewObjects.add(end);

		
	//	ClickableGraphic test = new ClickableGraphic(300,460,120,160, "resources/dog.png");
	//	viewObjects.add(test);
	}

	public void activateCardSpell(Card card) {
		
	}
	
	public void drawACard(Card card) {
		currentHandImages.add(card.getImage());
		cardsInHand.add(card);
		updateHand();
	}
	
	public void generateHandSlots() {
		int counter = 30;
		for(int i = 0; i < 4; i++) {
			CardButton handCardSlot = new CardButton(counter, 614, 150, 200, "resources/placeholder.png", null);
			int pos = i;
			handCardSlot.setAction(new Action() {
				public void act() {
					//this fails if the number of cards in cardsInHand is not at max. 
					//So we set a temp hand at creation, then we can update with the real hand.
					if(BattleBackend.player.hand.get(pos) instanceof MonsterCard) {
						activateCardMon(BattleBackend.player.hand.get(pos));
						backend.playerBoard.add((MonsterCard) BattleBackend.player.hand.get(pos));
						System.out.println(BattleBackend.player.deck.size());
					}else {
						activateCardSpell(BattleBackend.player.hand.get(pos));
					}
					currentHandImages.remove(pos);
					BattleBackend.player.hand.remove(pos);
					updateHand();
					//System.out.println(pos + currentHandImages.get(pos));
				}
			});
			handSlots.add(handCardSlot);
			counter += 150;
		}
		updateHand();
		update();
	}
	
	public void updateHand() {
		for(int i = 0; i < handSlots.size(); i++) {
			if(currentHandImages.size() > i && currentHandImages.get(i) != null) {
				handSlots.get(i).changeCardImage(currentHandImages.get(i), 150, 200);
			}else {
				handSlots.get(i).changeCardImage("resources/placeholder.png", 2, 2);
			}
		}
	}
	
	public void activateCardMon(Card card) {
		currentFieldImages.add(card.getImage());
		cardsOnField.add(card);
		updateField();
	}
	
	private void generateFieldSlots() {
		int counter = 300;
		for(int i = 0; i < 5; i++) {
			CardButton fieldCardSlot = new CardButton(counter, 460, 120, 160, "resources/placeholder.png", null);
			fieldCardSlot.changeCardImage("resources/placeholder.png", 2, 2);
			fieldCardSlot.setAction(new Action() {
				public void act() {
					//Add later
					//For attacking/defending
				}
			});
			fieldSlots.add(fieldCardSlot);
			counter += 100;
		}
	}

	
	public void updateField() {
		for(int i = 0; i < fieldSlots.size(); i++) {
			System.out.println(i + "size:" + currentFieldImages.size());
			if(currentFieldImages.size() > i && currentFieldImages.get(i) != null) {
				fieldSlots.get(i).changeCardImage(currentFieldImages.get(i), 120, 160);
			}else {
				fieldSlots.get(i).changeCardImage("resources/placeholder.png", 2, 2);
			}
			
		}
	}

//			if (cardsOnBoard.size() < 0) {
//				currentField.add(new ClickableGraphic(counter, 460, 120, 160, "resources/dog.png"));
//			counter= counter+ 100;
//			}
//			else {
//				for(int i =0; i<currentField.size();i++) {
//					counter= counter+100;
//				}
//				currentField.add(new Graphic(counter, 460, 120, 160, "resources/dog.png"));
//			}
	
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

//a = new ClickableGraphic(30,614,150,200, "resources/dog.png");
//b = new ClickableGraphic(180,614,150,200, "resources/pog.png");
//c = new ClickableGraphic(330,614,150,200, "resources/pika.png");
//d = new ClickableGraphic(480,614,150,200, "resources/shenrun.png");
//
//currentHand.add(a);
//currentHand.add(b);
//currentHand.add(c);
//currentHand.add(d); 
//
//
//viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
//viewObjects.add(new Graphic(800,760,60,60, "resources/mana.png"));
//viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
//viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
//viewObjects.add(new Graphic(1200,70, 90, 80, "resources/quitButton.png"));
//viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
//viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png")); 
//a.setAction(new Action() {
//	public void act() {
//	//	backend.playCard(backend.player.hand.get(0), 0);
//		activateCardMon();
//		for(int i = 0;i<currentField.size();i++) {
//			viewObjects.add(currentField.get(i));
//		}
//	}
//	
//});
//b.setAction(new Action() {
//	public void act() {
//	//	backend.playCard(backend.player.hand.get(1), 1);
//		activateCardMon(b);
//		for(int i = 0;i<currentField.size();i++) {
//			viewObjects.add(currentField.get(i));
//		}
//	}
//	
//}); 
//c.setAction(new Action() {
//	public void act() {
//	//	backend.playCard(backend.player.hand.get(2), 2);
//		activateCardMon(c);
//		for(int i = 0;i<currentField.size();i++) {
//			viewObjects.add(currentField.get(i));
//		}
//	}
//	
//}); 
//d.setAction(new Action() {
//	public void act() {
//	//	backend.playCard(backend.player.hand.get(3), 3);
//		activateCardMon(d);
//		for(int i = 0;i<currentField.size();i++) {
//			viewObjects.add(currentField.get(i));
//		}
//	}
//	
//});
//viewObjects.add(a);
//viewObjects.add(b);
//viewObjects.add(c);
//viewObjects.add(d);
}