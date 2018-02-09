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
	
	public int gold;
	private Card[] cardsChosen;
	private Deck[] cardsOwned;
	
	public ShopScreen(int width, int height) {
		super(width, height);
		gold = 0;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/ShopFinal2.png"));
		Button open = new Button((getWidth()-1500)/2,getHeight()-40,400,55," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
			}
		});
		viewObjects.add(open);
		Button buyPack = new Button(90, 660,310,100," ",new Action() {
			
			@Override
			public void act() {
				int getCards;
				if (gold >= 100) {
					int getCard = (int) (Math.random()*100);
					if(getCard > 94) {
					//	Player.Deck.addCard(null);
					}
				}
				//Do stuff so you get 5 cards.
				//Animate the cards so they all are revealed at the same time.
			}
		});
		viewObjects.add(buyPack);
		TextLabel displayGold = new TextLabel(383, 15,200,200,Integer.toString(gold));
		displayGold.setCustomTextColor(Color.WHITE);
		displayGold.setSize(29
				);
		displayGold.setText(Integer.toString(gold));
		viewObjects.add(displayGold);
	}
	
}
