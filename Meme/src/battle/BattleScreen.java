

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
	

	

/////////////////////////////

	public class BattleScreen extends FullFunctionScreen {
	ArrayList<Clip> allSounds;
	
	//slot arrayLists have the CardSlots while image arrayLists have the images that will be loaded onto the slots
	ArrayList<CardButton> handSlots;
	ArrayList<String> currentHandImages;
	ArrayList<CardButton> fieldSlots; 
	ArrayList<String> currentFieldImages;
	ArrayList<Graphic> currentFieldHp;
	
	private ArrayList<Card> cardsInHand; 
	private ArrayList<MonsterCard> cardsOnField;
	
	ArrayList<CardButton> AIhandSlots;
	ArrayList<String> AIcurrentHandImages;
	ArrayList<CardButton> AIfieldSlots;
	ArrayList<String> AIcurrentFieldImages;

	private ArrayList<Card> AIcardsInHand;
	private ArrayList<MonsterCard> AIcardsOnField;
	
	
	BattleBackend backend;
	
	TextLabel manaslot;
	TextLabel healthslot;
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
	
	boolean friendlySelected;
	boolean enemySelected;
	
	MonsterCard friendlyFighter;
	MonsterCard enemyFighter;

	private ArrayList<Graphic> currentHpPos;
	
	TextLabel aimanaslot;
	TextLabel aihealthslot;


	public BattleScreen(int width, int height) {
		super(width, height);
		friendlySelected = false;
		enemySelected = false;
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		backend = new BattleBackend();
		backend.player.drawcard(4);
		cardsInHand = new ArrayList<Card>();
		cardsOnField = new ArrayList<MonsterCard>();
		handSlots = new ArrayList<CardButton>();
		fieldSlots = new ArrayList<CardButton>();
		currentHandImages = new ArrayList<String>();
		currentFieldImages = new ArrayList<String>();
		currentHpPos = new ArrayList<Graphic>();
		
		TextLabel.setTextColor(Color.PINK);
		healthslot = new TextLabel(650,765,50,50, Integer.toString(backend.player.returnHp()));
		aihealthslot = new TextLabel(785, 165 ,50,50, Integer.toString(backend.cpu.returnHp()));
		TextLabel.setTextColor(new Color(60,100,200));
		manaslot = new TextLabel(850, 763, 50, 50, Integer.toString(backend.player.returnMana())+"/"+"10");
		aimanaslot = new TextLabel(850, 165, 50, 50, Integer.toString(backend.cpu.returnmana())+"/"+"10");
		TextLabel.setTextColor(Color.BLACK);
		Graphic aimanapic = new Graphic(800, 163, 60, 60, "resources/mana.png");

		
		backend.cpu.drawCard(4);


		AIcardsInHand = new ArrayList<Card>();
		AIcardsOnField = new ArrayList<MonsterCard>();
		AIhandSlots = new ArrayList<CardButton>();
		AIfieldSlots = new ArrayList<CardButton>();
		AIcurrentHandImages = new ArrayList<String>(); 
		AIcurrentFieldImages = new ArrayList<String>();
		
		AImanaslot = new TextLabel(850, 763, 50, 50, Integer.toString(backend.cpu.returnmana())+"/"+"10");
		

		//Temp. For testing
		//Stuff will be changed in backend
		for(int i = 0; i < 4; i++) {
			System.out.println("Player card" + backend.player.hand.get(i).getImage());
			currentHandImages.add(backend.player.hand.get(i).getImage());
			
			System.out.println("AI card" + backend.cpu.hand.get(i).getImage());
			AIcurrentHandImages.add(backend.cpu.hand.get(i).getImage());
		}
		
//		for(int i = 0; i < 4; i++) {
//			System.out.println(backend.player.hand.get(i).getImage());
//			currentHandImages.add(backend.player.hand.get(i).getImage());
//		}				
				
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

//		}
		
		
		
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
		viewObjects.add(manaslot);
		viewObjects.add(AImanaslot);
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
		

		quit.setVisible(false);
		viewObjects.add(quit);

		
		generateHandSlots(614, handSlots, currentHandImages, fieldSlots, currentFieldImages, backend.player); 	
		for(int i = 0; i < handSlots.size(); i++) { 
			viewObjects.add(handSlots.get(i));
		}
		
		generateHandSlots(40, AIhandSlots, AIcurrentHandImages, AIfieldSlots, AIcurrentFieldImages, backend.cpu); 	
		for(int i = 0; i < AIhandSlots.size(); i++) { 
			viewObjects.add(AIhandSlots.get(i));
		}
		
		//do stuff to generate things for the AI
		
		
		generateFieldSlots(460, fieldSlots);
		for(int i = 0; i < fieldSlots.size(); i++) { 
			viewObjects.add(fieldSlots.get(i));
		}
		
		generateFieldSlots(260, AIfieldSlots);
		for(int i = 0; i < AIfieldSlots.size(); i++) {
			viewObjects.add(AIfieldSlots.get(i));
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
		viewObjects.add(aihealthslot);
		viewObjects.add(aimanaslot);
		viewObjects.add(aimanapic);
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
		quit.setVisible(false);
		viewObjects.add(quit);
		
	}

	public void activateCardSpell(Card card) {
		card.a.act(backend.player, backend.cpu, "player", null, backend);
	}
	
	public void drawACard(Card card, ArrayList<String> selImageList) {
		currentHandImages.add(card.getImage());
		cardsInHand.add(card);
		updateHand(AIfieldSlots, selImageList, backend.player);
	}
	
	public void generateHandSlots(int yPos, ArrayList<CardButton> selSlotHandList, ArrayList<String> selHandStringList, ArrayList<CardButton> selSlotFieldList, ArrayList<String> selFieldStringList, Character chara) {
		int counter = 30;
		for(int i = 0; i < 4; i++) {
			CardButton handCardSlot = new CardButton(counter, yPos, 150, 200, "resources/placeholder.png", null);
			int pos = i;
			if(chara instanceof Player) {
				handCardSlot.setAction(new Action() {
					public void act() {
						//this fails if the number of cards in cardsInHand is not at max. 
						//So we set a temp hand at creation, then we can update with the real hand.
						//if(backend.player.hand.get(pos).getCost()<backend.player.returnMana()) {
							System.out.println(backend.player.returnMana());
							if(chara.getFromHand(pos) instanceof MonsterCard) {
								activateCardMon(chara.getFromHand(pos), pos, selFieldStringList, selSlotFieldList);
								chara.addToBoard((MonsterCard) chara.getFromHand(pos));
							}else {
								activateCardSpell(chara.getFromHand(pos));
							}
							selHandStringList.remove(pos);
							chara.removeFromHand(pos);
							updateHand(selSlotHandList, selHandStringList, chara);
							updateMana();
							updateHp();
						//}
						//test
						//else {
						//	System.out.println("OOM");
						//}
					}
				});
			}
			
			selSlotHandList.add(handCardSlot);
			counter += 150;
		}
		updateHand(selSlotHandList, selHandStringList, chara);
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
	
	public void activateCardMon(Card card, int pos, ArrayList<String> selStringList, ArrayList<CardButton> selButtonList) {
		selStringList.add(card.getImage());
		updateField(pos, selStringList, selButtonList);
	}
	
	private void generateFieldSlots(int yPos, ArrayList<CardButton> selSlotList) {
		int counter = 300;
		for(int i = 0; i < 5; i++) {
			int temp = i;
			CardButton fieldCardSlot = new CardButton(counter, yPos, 120, 160, "resources/placeholder.png", null);
			fieldCardSlot.changeCardImage("resources/placeholder.png", 2, 2);
			fieldCardSlot.setAction(new Action() {
				public void act() {
					fighting(temp, selSlotList);
				}
			});
			selSlotList.add(fieldCardSlot);
			counter += 100;
		}  
	}
	
	public void updateField(int pos, ArrayList<String> selStringList, ArrayList<CardButton> selButtonList) {
		for(int i = 0; i < selButtonList.size(); i++) {
			//System.out.println(i + "size:" + selStringList.size()+  selStringList.get(i));
			if(selStringList.size() > i && selStringList.get(i) != null) {
				if (selButtonList.get(i).getHasCard() == false) {
					
					//not working with ai
					fieldSlots.get(i).moveCard(pos);
					selButtonList.get(i).setHasCard(true);
				}
				selButtonList.get(i).changeCardImage(selStringList.get(i), 120, 160);
			}else {
				selButtonList.get(i).changeCardImage("resources/placeholder.png", 2, 2);
			}
		}
	}
	public void updateHp() {
		System.out.println("df");
		healthslot.setText(Integer.toString(backend.player.returnHp()));
	}
	public void updateMana() {
		System.out.println("mana");
		manaslot.setText(Integer.toString(backend.player.returnMana())+"/"+"10");
	}
	public void updateHpField() {
		
	}
	public void fighting(int pos, ArrayList<CardButton> field ) {
		if (field == fieldSlots) {
			friendlySelected = true;
			friendlyFighter = backend.playerBoard.get(pos);
		}
		if (field == AIfieldSlots) { 
			enemySelected = true;
			enemyFighter = backend.computerBoard.get(pos);
		}
		if (friendlySelected==true && enemySelected==true) {
			backend.attack(friendlyFighter, enemyFighter);
			updateHpField();
		}
	}
}

