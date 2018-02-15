package menu;

import java.awt.Color;
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
	public TextArea tempCardDis;
	public static Card[] commonCards = {Deck.Doge, Deck.DewYuKnoDeWae, Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.UWot };
	public static Card[] rareCards = {Deck.IQ, Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.WTF };
	public static Card[] epicCards = {Deck.OmaeWaMouShindeiru, Deck.SaltBae };
	public static Card[] legendaryCards = {Deck.Shenron, Deck.TheExcutiveProducer, Deck.UltraMegaChicken };
	public TextLabel displayGold;
	public Graphic[] cardDisplay;
	
	public ShopScreen(int width, int height) {
		super(width, height);
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		gold = 400;
		cardDisplay = new Graphic[5];
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/ShopFinal4.png"));
		tempCardDis = new TextArea(500, 500, 400, 200, "");
		tempCardDis.setCustomTextColor(Color.WHITE);
		tempCardDis.setSize(29);
		viewObjects.add(tempCardDis);
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



		Button buyPack = new Button(90, 660,310,100," ",new Action() {
			
			@Override
			public void act() {
				
				int randomInt;
//				randomInt = (int) ((Math.random()*100)+1);
//				if(randomInt > 95){
//				 	int randomCard = (int)(Math.random()*legendaryCards[].length);
//				 	Graphic card1= new Graphic(x,y,width,height,legendaryCards[randomCard].getImage());
				 
				
//				String s = "You have obtained:";
//				if (gold >= 100) {
//					gold -= 100;
//					tempCardDis.setText("");
//					int getCard = (int) (Math.random()*15);
//					for(int i = 0; i < 5; i++) {
//						Card c = Deck.collection.get(getCard);
//						s += c.getName() + ", ";
//						c.setAmt(c.getAmt()+1);
//						getCard = (int) (Math.random()*15);
//					}
//					displayGold.setText(Integer.toString(gold));
//					tempCardDis.setText(s);
//				}else {
//					tempCardDis.setText("You do not have enough gold");
//				}
				
				//Move function---> 5 face-down cards move towards the right.
				//the cards all go through some animation and will be face-up.
			}
		});
		viewObjects.add(buyPack);
		
	//	for(int i = 0; i )
		
	}
	
}
