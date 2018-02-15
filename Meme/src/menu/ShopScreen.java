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
	public ArrayList<String> cardDisList;
	
	public ShopScreen(int width, int height) {
		super(width, height);
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		gold = 400;
		cardDisplays = new Graphic[5];
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
			}
		});
		viewObjects.add(shop2);

		Graphic a = new Graphic(800, 60, 160, 260, "resources/cardback.png");
		Graphic b = new Graphic(1030, 192, 160, 260, "resources/cardback.png");
		Graphic c = new Graphic(940, 490, 160, 260, "resources/cardback.png");
		Graphic d = new Graphic(660, 490, 160, 260, "resources/cardback.png");
		Graphic e = new Graphic(570, 192, 160, 260, "resources/cardback.png");
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
				if (gold >= 100) {
					gold -= 100;
					displayGold.setText(Integer.toString(gold));
					int randomInt;
					randomInt = (int) ((Math.random()*100)+1);
					if(randomInt > 95){
						int randomCard = (int)(Math.random()*legendaryCards.length);
						cardDisList.add(legendaryCards[randomCard].getImage());		
					}
					if(randomInt > 75 && randomInt < 95) {
						int randomCard = (int)(Math.random()*epicCards.length);
						cardDisList.add(epicCards[randomCard].getImage());	
					}
					if(randomInt > 45 && randomInt < 75) {
						int randomCard = (int)(Math.random()*rareCards.length);
						cardDisList.add(rareCards[randomCard].getImage());	
					}
					if(randomInt < 45) {
						int randomCard = (int)(Math.random()*commonCards.length);
						cardDisList.add(commonCards[randomCard].getImage());	
					}
				}
					 
				displayCards();
			}
		});
		viewObjects.add(buyPack);
		
	}
	
	public void displayCards() {
		for(int i = 0; i < 5; i++) {
			cardDisplays[i].setVisible(true);
		}
		Thread g = new Thread();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 5; i++) {
			cardDisplays[i].setVisible(true);
			cardDisplays[i].loadImages(cardDisList.get(i), 160, 260);
		}
	}
	
}
