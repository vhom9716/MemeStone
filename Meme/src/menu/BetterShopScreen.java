package menu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import battle.Player;
import cards.Card;
import cards.Deck;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BetterShopScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	
	public TextArea tempCardDis;
	protected TextLabel displayGold;
	public static Card[] commonCards = {Deck.Doge, Deck.DewYuKnoDeWae, Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.UWot };
	public static Card[] rareCards = {Deck.IQ, Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.WTF };
	public static Card[] epicCards = {Deck.OmaeWaMouShindeiru, Deck.SaltBae };
	public static Card[] legendaryCards = {Deck.Shenron, Deck.TheExcutiveProducer, Deck.UltraMegaChicken };
	public Graphic[] cardDisplays;
	public AnimatedComponent[] animatedDisplays;
	public ArrayList<String> cardDisList;
	
	
	public BetterShopScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		cardDisplays = new Graphic[5];
		animatedDisplays = new AnimatedComponent[5];
		cardDisList = new ArrayList<String>();
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/BetterCardsShop.png"));
		tempCardDis = new TextArea(500, 500, 400, 200, "");
		tempCardDis.setCustomTextColor(Color.WHITE);
		tempCardDis.setSize(29);
		viewObjects.add(tempCardDis);
		displayGold = new TextLabel(350, 13,200,200,Integer.toString(ShopScreen.gold));
		displayGold.setCustomTextColor(Color.WHITE);
		displayGold.setSize(29);
		displayGold.setText(Integer.toString(ShopScreen.gold));
		viewObjects.add(displayGold);
		
		Button open = new Button((getWidth()-1500)/2,getHeight()-40,400,55," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		});
		viewObjects.add(open);
		
		Button shop1 = new Button(55, 133, 45, 30," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen2);
				Menu.screen2.displayGold.setText(Integer.toString(ShopScreen.gold));
				for(int i = 0; i < 5; i++) {
					Menu.screen2.cardDisplays[i].setVisible(true);
					Menu.screen2.cardDisplays[i].loadImages("resources/placeholder.png", 2, 2);
				}
			}
		});
		viewObjects.add(shop1);

		Graphic a = new Graphic(800, 60, 152, 270, "resources/cardback.png");
		Graphic b = new Graphic(1030, 192, 152, 270, "resources/cardback.png");
		Graphic c = new Graphic(940, 490, 152, 270, "resources/cardback.png");
		Graphic d = new Graphic(660, 490, 152, 270, "resources/cardback.png");
		Graphic e = new Graphic(570, 192, 152, 270, "resources/cardback.png");
		
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
				if (ShopScreen.gold >= 175) {
					ShopScreen.gold -= 175;
					displayGold.setText(Integer.toString(ShopScreen.gold));
					int randomInt = 0;
					
					for(int i = 0; i < 5; i++) {
						randomInt = (int) ((Math.random()*100));
						if(randomInt > 90){
							int randomCard = (int)(Math.random()*legendaryCards.length);
							cardDisList.add(legendaryCards[randomCard].getImage());	
							for(int i1 = 0; i1 < Deck.collection.size(); i1++) {
								if(Deck.collection.get(i1) == legendaryCards[randomCard]) {
									Deck.collection.get(i1).setAmt(Deck.collection.get(i1).getAmt()+1);
								}
							}
						}
						if(randomInt > 60 && randomInt <= 90) {
							int randomCard = (int)(Math.random()*epicCards.length);
							cardDisList.add(epicCards[randomCard].getImage());
							for(int i2 = 0; i2 < Deck.collection.size(); i2++) {
								if(Deck.collection.get(i2) == epicCards[randomCard]) {
									Deck.collection.get(i2).setAmt(Deck.collection.get(i2).getAmt()+1);
								}
							}
						}
						if(randomInt > 25 && randomInt <= 60) {
							int randomCard = (int)(Math.random()*rareCards.length);
							cardDisList.add(rareCards[randomCard].getImage());	
							for(int i3 = 0; i3 < Deck.collection.size(); i3++) {
								if(Deck.collection.get(i3) == rareCards[randomCard]) {
									Deck.collection.get(i3).setAmt(Deck.collection.get(i3).getAmt()+1);
								}
							}
						}
						if(randomInt <= 25) {
							int randomCard = (int)(Math.random()*commonCards.length);
							cardDisList.add(commonCards[randomCard].getImage());	
							for(int i4 = 0; i4 < Deck.collection.size(); i4++) {
								if(Deck.collection.get(i4) == commonCards[randomCard]) {
									Deck.collection.get(i4).setAmt(Deck.collection.get(i4).getAmt()+1);
								}
							}
						}
					}
					for(int i = 0; i < 5; i++) {
						cardDisplays[i].setVisible(true);
						cardDisplays[i].loadImages(cardDisList.get(i), 220, 270);
					}
				}
					 
				
			}
		});
		viewObjects.add(buyPack);
	}
}
