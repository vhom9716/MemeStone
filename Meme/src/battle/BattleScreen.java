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
	
	TextLabel manaslot;

	TextLabel healthslot;

	TextLabel AImanaslot;



	public BattleScreen(int width, int height) {
		super(width, height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		backend = new BattleBackend();
		backend.player.drawcard(4);
		cardsInHand = new ArrayList<Card>();
		cardsOnField = new ArrayList<Card>();
		handSlots = new ArrayList<CardButton>();
		fieldSlots = new ArrayList<CardButton>();
		currentHandImages = new ArrayList<String>();
		currentFieldImages = new ArrayList<String>();
		
		TextLabel.setTextColor(Color.PINK);
		healthslot = new TextLabel(650,765,50,50, Integer.toString(backend.player.returnhp()));
		TextLabel.setTextColor(new Color(60,100,200));
		manaslot = new TextLabel(850, 763, 50, 50, Integer.toString(Player.returnmana())+"/"+"10");

		TextLabel.setTextColor(Color.BLACK);

		
		BattleBackend.cpu.drawCard(4);
		AIcardsInHand = new ArrayList<Card>();
		AIcardsOnField = new ArrayList<Card>();
		AIhandSlots = new ArrayList<CardButton>();
		AIfieldSlots = new ArrayList<CardButton>();
		AIcurrentHandImages = new ArrayList<String>(); 
		AIcurrentFieldImages = new ArrayList<String>();
		
		AImanaslot = new TextLabel(850, 763, 50, 50, Integer.toString(BattleBackend.cpu.returnmana())+"/"+"10");
		

		//Temp. For testing
		//Stuff will be changed in backend
		for(int i = 0; i < 4; i++) {
			System.out.println("Player card" + backend.player.hand.get(i).getImage());
			currentHandImages.add(backend.player.hand.get(i).getImage());
			
//			System.out.println("AI card" + BattleBackend.cpu.hand.get(i).getImage());
//			AIcurrentHandImages.add(BattleBackend.cpu.hand.get(i).getImage());
		}
		
//		for(int i = 0; i < 4; i++) {
//			System.out.println(BattleBackend.player.hand.get(i).getImage());
//			currentHandImages.add(BattleBackend.player.hand.get(i).getImage());
//		}
		

		viewObjects.add(manaslot);
		viewObjects.add(AImanaslot);
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(800,760,60,60, "resources/mana.png"));
		viewObjects.add(new Graphic(630,614,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(630, 25, 350,250, "resources/cpu.png"));
		//viewObjects.add(new Graphic(1250,25, 150, 150, "resources/setbutton1.png"));
		viewObjects.add(new Graphic(750,130, 120, 80, "resources/hp.png"));
		viewObjects.add(new Graphic(620,730, 120, 80, "resources/hp.png")); 

		
		generateHandSlots(614, handSlots, currentHandImages, backend.player); 	
		for(int i = 0; i < handSlots.size(); i++) { 
			viewObjects.add(handSlots.get(i));
		}
		
//		generateHandSlots(300, AIhandSlots, AIcurrentHandImages, BattleBackend.cpu); 	
//		for(int i = 0; i < AIhandSlots.size(); i++) { 
//			viewObjects.add(AIhandSlots.get(i));
//		}
		
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
				ArrayList<Card> hand = backend.player.hand;
				ArrayList<Card> deck = backend.player.deck;
				if(deck.size() > 0) {
					backend.player.drawcard(1); 
					currentHandImages.add(hand.get(hand.size() - 1).getImage());
					updateHand(handSlots, currentHandImages, backend.player);
				}
			}
		}); 
		viewObjects.add(end);
		System.out.println(healthslot.getTextColor());
		viewObjects.add(manaslot);
		viewObjects.add(healthslot);
	//	Graphic settings = new Graphic(450, 100, 500, 600, "resources/menu.png");
	//	viewObjects.add(settings);

		
	//	ClickableGraphic test = new ClickableGraphic(300,460,120,160, "resources/dog.png");
	//	viewObjects.add(test);
	}

	public void activateCardSpell(Card card) {

		card.a.act(backend.player, backend.cpu, "player", null, backend);

	}
	
	public void drawACard(Card card, ArrayList<String> selImageList) {
		currentHandImages.add(card.getImage());
		cardsInHand.add(card);
		updateHand(AIfieldSlots, selImageList, backend.player);
	}
	
	public void generateHandSlots(int yPos, ArrayList<CardButton> selSlotList, ArrayList<String> selStringList, Character chara) {
		int counter = 30;
		for(int i = 0; i < 4; i++) {
			CardButton handCardSlot = new CardButton(counter, 614, 150, 200, "resources/placeholder.png", null);
			int pos = i;
			handCardSlot.setAction(new Action() {
				public void act() {
					//this fails if the number of cards in cardsInHand is not at max. 
					//So we set a temp hand at creation, then we can update with the real hand.

//					if(BattleBackend.player.hand.get(pos) instanceof MonsterCard) {
//						activateCardMon(BattleBackend.player.hand.get(pos), pos);
//						backend.player.board.add((MonsterCard) BattleBackend.player.hand.get(pos));
//						System.out.println(BattleBackend.player.deck.size());
//					}else {
//						activateCardSpell(BattleBackend.player.hand.get(pos));
//					}
//					currentHandImages.remove(pos);
//					BattleBackend.player.hand.remove(pos);
					
					if(chara.getFromHand(pos) instanceof MonsterCard) {
						activateCardMon(chara.getFromHand(pos), pos);
						chara.addToBoard((MonsterCard) chara.getFromHand(pos));
						//System.out.println(BattleBackend.player.deck.size());

//					if(backend.player.hand.get(pos) instanceof MonsterCard) {
//						activateCardMon(backend.player.hand.get(pos));
//						backend.playerBoard.add((MonsterCard) backend.player.hand.get(pos));
//						System.out.println(backend.player.deck.size());

					}else {

						activateCardSpell(chara.getFromHand(pos));

//						activateCardSpell(backend.player.hand.get(pos));
					}

					selStringList.remove(pos);
					chara.removeFromHand(pos);
					updateHand(selSlotList, selStringList, chara);


//					currentHandImages.remove(pos);
//					backend.player.hand.remove(pos);
//					System.out.println("the real remove" + backend.player.hand.size());
//					updateHand();

					//System.out.println(pos + currentHandImages.get(pos));
				}
			});
			selSlotList.add(handCardSlot);
			counter += 150;
		}
		updateHand(selSlotList, selStringList, chara);
		update();
	}
	

	public void updateHand(ArrayList<CardButton> selSlotList, ArrayList<String> selStringList, Character chara) {
		selStringList.clear();
		for(int i = 0; i < chara.getHandSize(); i++) {
			System.out.println(chara.getFromHand(i).getImage());
			selStringList.add(chara.getFromHand(i).getImage());
		}

		for(int i = 0; i < selSlotList.size(); i++) {
			if(selStringList.size() > i && selStringList.get(i) != null) {
				selSlotList.get(i).changeCardImage(selStringList.get(i), 150, 200);
			}else {
				selSlotList.get(i).changeCardImage("resources/placeholder.png", 2, 2);
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
					//fieldSlots.get(i).moveCard(pos);
					fieldSlots.get(i).setHasCard(true);
				}
				fieldSlots.get(i).changeCardImage(currentFieldImages.get(i), 120, 160);
			}else {
				fieldSlots.get(i).changeCardImage("resources/placeholder.png", 2, 2);
			}
			
		}
	}
}