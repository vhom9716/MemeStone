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
	
	ArrayList<CardButton> AIhandSlots;
	ArrayList<String> AIcurrentHandImages;
	ArrayList<CardButton> AIfieldSlots;
	ArrayList<String> AIcurrentFieldImages;

	private ArrayList<Card> AIcardsInHand;
	private ArrayList<Card> AIcardsOnField;
	
	
	BattleBackend backend;
	AI computer;
	
	TextLabel manaslot;
	TextLabel healthslot;
	//od stuff
//	ClickableGraphic a;
//	ClickableGraphic b;
//	ClickableGraphic c;
//	ClickableGraphic d; 
//	Graphic f1;
//	Graphic f2;
//	Graphic f3;
//	Graphic f4;
	TextLabel AImanaslot;
	Graphic settings;
	Button quit;
	Button concede;
	Button resume;
	Graphic healthpos1;
	Graphic healthpos2;
	Graphic healthpos3;
	Graphic healthpos4;
	Graphic healthpos5;

	public BattleScreen(int width, int height) {
		super(width, height);
		backend = new BattleBackend();
		computer = new AI();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		BattleBackend.player.drawcard(4);
		cardsInHand = new ArrayList<Card>();
		cardsOnField = new ArrayList<Card>();
		handSlots = new ArrayList<CardButton>();
		fieldSlots = new ArrayList<CardButton>();
		currentHandImages = new ArrayList<String>();
		currentFieldImages = new ArrayList<String>();
		
		TextLabel.setTextColor(Color.PINK);
		healthslot = new TextLabel(650,765,50,50, Integer.toString(Player.returnhp()));
		TextLabel.setTextColor(new Color(60,100,200));
		manaslot = new TextLabel(850, 763, 50, 50, Integer.toString(Player.returnmana())+"/"+"10");

		TextLabel.setTextColor(Color.BLACK);

		healthpos1 = new Graphic (380, 570, 40, 40, "resources/1.png");
		quit = new Button(545,310, 347, 76, "", new Action() {
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
				System.out.println("dfsdf");
			}
		});
		resume = new Button(545, 455, 347, 76, "", new Action() {
			
			@Override
			public void act() {
				settings.setVisible(!settings.isVisible());
				quit.setVisible(!quit.isVisible());
				concede.setVisible(!concede.isVisible());
				resume.setVisible(!resume.isVisible());	
			}
		});
		concede = new Button(545, 200, 347, 76, "", new Action() {
			
			@Override
			public void act() {
				//basically end game?
				
			}
		});
	/*	computer.drawCard(4);
		AIcardsInHand = new ArrayList<Card>();
		AIcardsOnField = new ArrayList<Card>();
		AIhandSlots = new ArrayList<CardButton>(); 
		AIfieldSlots = new ArrayList<CardButton>();
		AIcurrentHandImages = new ArrayList<String>();
		AIcurrentFieldImages = new ArrayList<String>();
		
		AImanaslot = new TextLabel(850, 763, 50, 50, Integer.toString(computer.returnmana())+"/"+"10");
		*/

		//Temp. For testing
		//Stuff will be changed in backend
		for(int i = 0; i < 4; i++) {
			System.out.println(BattleBackend.player.hand.get(i).getImage());
			currentHandImages.add(BattleBackend.player.hand.get(i).getImage());
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.println(BattleBackend.player.hand.get(i).getImage());
			currentHandImages.add(BattleBackend.player.hand.get(i).getImage());
		}
		

		viewObjects.add(manaslot);
	//	viewObjects.add(AImanaslot);
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(800,760,60,60, "resources/mana.png"));
		viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
		viewObjects.add(new Graphic(1250,25, 150, 150, "resources/setbutton1.png"));
		viewObjects.add(new Button(1300,75,60,50, "", new Action() {
			
			@Override
			public void act() {
				settings.setVisible(!settings.isVisible());
				quit.setVisible(!quit.isVisible());
				concede.setVisible(!concede.isVisible());
				resume.setVisible(!resume.isVisible());
			}
		}));
		viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
		viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png")); 

		
		generateHandSlots(); 	
		for(int i = 0; i < handSlots.size(); i++) { 
			viewObjects.add(handSlots.get(i));
		}
		
		//do stuff to generate things for the AI
		
		
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

		quit.setVisible(false);
		viewObjects.add(quit);
		
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
		System.out.println(healthslot.getTextColor());
		viewObjects.add(manaslot);
		viewObjects.add(healthslot);
		settings = new Graphic(450, 100, 500, 600, "resources/menu.png");
		settings.setVisible(false);
		viewObjects.add(settings);
		concede.setVisible(false);
		viewObjects.add(concede);
		resume.setVisible(false);
		viewObjects.add(resume);
		
		viewObjects.add(healthpos1);
		

		
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
						activateCardMon(BattleBackend.player.hand.get(pos), pos);
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
	
	public void activateCardMon(Card card, int pos) {
		currentFieldImages.add(card.getImage());
		cardsOnField.add(card);
		updateField(pos);
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

	
	public void updateField(int pos) {
		for(int i = 0; i < fieldSlots.size(); i++) {
			System.out.println(i + "size:" + currentFieldImages.size());
			if(currentFieldImages.size() > i && currentFieldImages.get(i) != null) {
				if (fieldSlots.get(i).getHasCard() == false) {
					fieldSlots.get(i).moveCard(pos);
					fieldSlots.get(i).setHasCard(true);
				}
				fieldSlots.get(i).changeCardImage(currentFieldImages.get(i), 120, 160);
			}else {
				fieldSlots.get(i).changeCardImage("resources/placeholder.png", 2, 2);
			}
			
		}
	}
}