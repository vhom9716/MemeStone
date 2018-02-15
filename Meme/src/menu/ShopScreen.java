package menu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import battle.Player;
import cards.Card;
import cards.Deck;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ShopScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	
	public static int gold;
	public int passingGold;
	public static Card[] commonCards = {Deck.Doge, Deck.DewYuKnoDeWae, Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.UWot };
	public static Card[] rareCards = {Deck.IQ, Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.WTF };
	public static Card[] epicCards = {Deck.OmaeWaMouShindeiru, Deck.SaltBae };
	public static Card[] legendaryCards = {Deck.Shenron, Deck.TheExcutiveProducer, Deck.UltraMegaChicken };
	public TextLabel displayGold;
	public Graphic[] cardDisplays;
	public AnimatedComponent[] animatedDisplays;
	public ArrayList<String> cardDisList;
	
	public ShopScreen(int width, int height) {
		super(width, height);
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		gold = 400;
		cardDisplays = new Graphic[5];
		animatedDisplays = new AnimatedComponent[5];
		cardDisList = new ArrayList<String>();
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/ShopFinal4.png"));
		displayGold = new TextLabel(350, 13,200,200,Integer.toString(gold));
		displayGold.setCustomTextColor(Color.WHITE);
		displayGold.setSize(29);
		displayGold.setText(Integer.toString(gold));
		viewObjects.add(displayGold);
		
		Button open = new Button((getWidth()-1500)/2,getHeight()-40,400,55," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		});
		viewObjects.add(open);
		
		Button shop2 = new Button(385, 133, 45, 30," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen5);
				Menu.screen5.displayGold.setText(Integer.toString(ShopScreen.gold));
				for(int i = 0; i < 5; i++) {
					Menu.screen5.cardDisplays[i].setVisible(true);
					Menu.screen5.cardDisplays[i].loadImages("resources/placeholder.png", 2, 2);
				}
			}
		});
		viewObjects.add(shop2);

		Graphic a = new Graphic(800, 60, 152, 270, "resources/cardback.png");
		Graphic b = new Graphic(1030, 192, 152, 270, "resources/cardback.png");
		Graphic c = new Graphic(940, 490, 152, 270, "resources/cardback.png");
		Graphic d = new Graphic(660, 490, 152, 270, "resources/cardback.png");
		Graphic e = new Graphic(570, 192, 152, 270, "resources/cardback.png");
		
		
//		AnimatedComponent aA = new AnimatedComponent(840, 60, 152, 243);
//		aA.addSequence("resources/CardSpriteSheetWithoutLines.png", 150, 0, 0, 167, 288, 8);
//		viewObjects.add(aA);
//		animatedDisplays[0] = aA;
//		AnimatedComponent bA = new AnimatedComponent(1070, 192, 152, 243);
//		aA.addSequence("resources/CardSpriteSheetWithoutLines.png", 150, 0, 0, 167, 288, 8);
//		viewObjects.add(bA);
//		animatedDisplays[1] = bA;
//		AnimatedComponent cA = new AnimatedComponent(980, 490, 152, 243);
//		cA.addSequence("resources/CardSpriteSheetWithoutLines.png", 150, 0, 0, 167, 288, 8);
//		viewObjects.add(cA);
//		animatedDisplays[2] = cA;
//		AnimatedComponent dA = new AnimatedComponent(700, 490, 152, 243);
//		dA.addSequence("resources/CardSpriteSheetWithoutLines.png", 150, 0, 0, 167, 288, 8);
//		viewObjects.add(dA);
//		animatedDisplays[3] = dA;
//		AnimatedComponent eA = new AnimatedComponent(610, 192, 152, 243);
//		eA.addSequence("resources/CardSpriteSheetWithoutLines.png", 150, 0, 0, 167, 288, 8);
//		viewObjects.add(eA);
//		animatedDisplays[4] = eA;
	
		cardDisplays[0] = a;
		cardDisplays[1] = b;
		cardDisplays[2] = c;
		cardDisplays[3] = d;
		cardDisplays[4] = e;
		for(int i = 0; i < 5; i++) {
			viewObjects.add(cardDisplays[i]);
			cardDisplays[i].setVisible(false);
		}

		Button buyPack = new Button(90, 660,310,100," ",new Action() {
			
			@Override
			public void act() {
				displayGold.setText(Integer.toString(ShopScreen.gold));
				cardDisList.clear();
				if (gold >= 100) {
					gold -= 100;
					displayGold.setText(Integer.toString(gold));
					int randomInt = 0;
					
					for(int i = 0; i < 5; i++) {
						randomInt = (int) ((Math.random()*100));
						if(randomInt > 95){
							int randomCard = (int)(Math.random()*legendaryCards.length);
							cardDisList.add(legendaryCards[randomCard].getImage());	
							for(int i1 = 0; i1 < Deck.collection.size(); i1++) {
								if(Deck.collection.get(i1) == legendaryCards[randomCard]) {
									Deck.collection.get(i1).setAmt(Deck.collection.get(i1).getAmt()+1);
								}
							}
						}
						if(randomInt > 75 && randomInt <= 95) {
							int randomCard = (int)(Math.random()*epicCards.length);
							cardDisList.add(epicCards[randomCard].getImage());
							for(int i2 = 0; i2 < Deck.collection.size(); i2++) {
								if(Deck.collection.get(i2) == epicCards[randomCard]) {
									Deck.collection.get(i2).setAmt(Deck.collection.get(i2).getAmt()+1);
								}
							}
						}
						if(randomInt > 45 && randomInt <= 75) {
							int randomCard = (int)(Math.random()*rareCards.length);
							cardDisList.add(rareCards[randomCard].getImage());	
							for(int i3 = 0; i3 < Deck.collection.size(); i3++) {
								if(Deck.collection.get(i3) == rareCards[randomCard]) {
									Deck.collection.get(i3).setAmt(Deck.collection.get(i3).getAmt()+1);
								}
							}
						}
						if(randomInt <= 45) {
							int randomCard = (int)(Math.random()*commonCards.length);
							cardDisList.add(commonCards[randomCard].getImage());	
							for(int i4 = 0; i4 < Deck.collection.size(); i4++) {
								if(Deck.collection.get(i4) == commonCards[randomCard]) {
									Deck.collection.get(i4).setAmt(Deck.collection.get(i4).getAmt()+1);
								}
							}
						}
					}
					
					//displayCards();
					for(int i = 0; i < 5; i++) {
						cardDisplays[i].setVisible(true);
						cardDisplays[i].loadImages(cardDisList.get(i), 220, 270);
					}
				}
					 
				
			}
		});
		viewObjects.add(buyPack);
		
	}
	
//	public void displayCards() {
//		Thread run1 = new Thread(animatedDisplays[0]);
//		run1.start();
//		Thread run2 = new Thread(animatedDisplays[1]);
//		run2.start();
//		Thread run3 = new Thread(animatedDisplays[2]);
//		run3.start();
//		Thread run4 = new Thread(animatedDisplays[3]);
//		run4.start();
//		Thread run5 = new Thread(animatedDisplays[4]);
//		run5.start();
//		update();
//		Thread a = new Thread();
//		try {
//			a.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
