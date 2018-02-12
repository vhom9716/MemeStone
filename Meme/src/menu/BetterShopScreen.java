package menu;

import java.awt.Color;
import java.util.List;

import battle.Player;
import cards.Card;
import cards.Deck;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BetterShopScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	
	public int gold;
	private Card[] cardsChosen;
	private Deck[] cardsOwned;
	public TextArea tempCardDis;
	
	public BetterShopScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		gold = 400;
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/BetterCardsShop.png"));
		tempCardDis = new TextArea(500, 500, 400, 200, "");
		tempCardDis.setCustomTextColor(Color.WHITE);
		tempCardDis.setSize(29);
		viewObjects.add(tempCardDis);
		TextLabel displayGold = new TextLabel(350, 13,200,200,Integer.toString(gold));
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
		
		Button shop2 = new Button((getWidth()-1500)/2,getHeight()-40,400,55," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		});


		Button buyPack = new Button(90, 660,310,100," ",new Action() {
			
			@Override
			public void act() {
				String s = "You have obtained:";
				if (gold >= 100) {
					gold -= 100;
					tempCardDis.setText("");
					int getCard = (int) (Math.random()*15);
					for(int i = 0; i < 5; i++) {
						Card c = Deck.collection.get(getCard);
						s += c.getName() + ", ";
						c.setAmt(c.getAmt()+1);
						getCard = (int) (Math.random()*15);
					}
					displayGold.setText(Integer.toString(gold));
					tempCardDis.setText(s);
				}else {
					tempCardDis.setText("You do not have enough gold");
				}
				
				//Do stuff so you get 5 cards.
				//Animate the cards so they all are revealed at the same time.
			}
		});
		viewObjects.add(buyPack);
		
	}
	
}
