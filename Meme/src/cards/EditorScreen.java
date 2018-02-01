package cards;

import java.util.ArrayList;
import java.util.List;
import guiPlayer.CustomPane;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import menu.Menu;

public class EditorScreen extends FullFunctionScreen {

	private DeckPane pane;
	private int deckSize = Deck.userDeck.size();
	private TextArea deckCapacity;
	private TextArea pageNumberArea;
	private Button pageLeft;
	private Button pageRight;
	private Graphic picture1;
	private Graphic picture2;
	private Graphic picture3;
	private Graphic picture4;
	private Graphic background;
	private TextArea picture1amt;
	private TextArea picture2amt;
	private TextArea picture3amt;
	private TextArea picture4amt;
	
	private Button addFirst;
	private Button addSecond;
	private Button addThird;
	private Button addFourth;
	
	public TextArea currentDeckTest;
	
	public static Card[] page1 = {Deck.IQ, Deck.DewYuKnoDeWae, Deck.Doge, Deck.OmaeWaMouShindeiru,
								  Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.SaltBae,
								  Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.Shenron,Deck.TheExcutiveProducer,
								  Deck.UltraMegaChicken, Deck.UWot, Deck.WTF};
	
	private Card card1 = page1[0];
	private Card card2 = page1[1];
	private Card card3 = page1[2];
	private Card card4 = page1[3];
	
	//Card[] page2 = {Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.SaltBae};
	//Card[] page3 = {Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.Shenron,Deck.TheExcutiveProducer,};
	//Card[] page4 = {Deck.UltraMegaChicken,Deck.UWot, Deck.WTF};
	
	private int pageNumber = 1;
	
	public EditorScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, 1440, 824, "resources/CardBackgroundFinal.png");
		String amt1 = Integer.toString(page1[0].getAmt());
		String amt2 = Integer.toString(page1[1].getAmt());
		String amt3 = Integer.toString(page1[2].getAmt());
		String amt4 = Integer.toString(page1[3].getAmt());
		pane = new DeckPane(this, 1200, 100,150,600);
		pane.update();
		deckCapacity = new TextArea(1200,700,150,40,deckSize+"/15");
		
		picture1 = new Graphic(300,20,250,350,"resources/200iq.png");
		picture2 = new Graphic(700,20,250,350,"resources/dewyuknodewae.png");
		picture3 = new Graphic(300,400,250,350,"resources/dog.png");
		picture4 = new Graphic(700,400,250,350,"resources/omaewa.png");
		
		picture1amt = new TextArea(330,360,200,150,amt1);
		picture2amt = new TextArea(730,360,200,150,amt2);
		picture3amt = new TextArea(330,740,200,150,amt3);
		picture4amt = new TextArea(730,740,200,150,amt4);
		
		currentDeckTest = new TextArea(200,30,300,300,"");
		
		pageLeft = new Button(460,700,200,200,"<-",null/**move("left")*/);
		pageRight = new Button(600,700,200,200,"->",null/**move("right")*/);
		addFirst = new Button(330,300,200,150,"Add1", addACard(card1));
		addSecond = new Button(730,300,200,150,"Add2", addACard(card2));
		addThird = new Button(330,680,200,150,"Add3", addACard(card3));
		addFourth = new Button(730,680,200,150,"Add4", addACard(card4));
		
	
		
		viewObjects.add(background);
		viewObjects.add(pane);
		viewObjects.add(deckCapacity);
		viewObjects.add(picture1);
		viewObjects.add(picture2);
		viewObjects.add(picture3);
		viewObjects.add(picture4);
		viewObjects.add(picture1amt);
		viewObjects.add(picture2amt);
		viewObjects.add(picture3amt);
		viewObjects.add(picture4amt);
		Button menu = new Button(20, 30,100,30,"Back to Menu",new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
					
			}
		});
		viewObjects.add(menu);
		viewObjects.add(pageLeft);
		viewObjects.add(pageRight);
		viewObjects.add(addFirst);
		viewObjects.add(addSecond);
		viewObjects.add(addThird);
		viewObjects.add(addFourth);
		viewObjects.add(currentDeckTest);
	}

	/**private Action move(String string) {
		if(string.equals("left")) {
			if(pageNumber != 1) {
				pageNumber--;
				changeCards();
			}
		} 
		if(string.equals("right")) {
			if(pageNumber != 4) {
				pageNumber++;
				changeCards();
			}
		}
		return null;
	}*/

	/**private void changeCards() {
		if(pageNumber == 1) {
			picture1amt.setText(Integer.toString(page1[0].getAmt()));
			picture2amt.setText(Integer.toString(page1[1].getAmt()));
			picture3amt.setText(Integer.toString(page1[2].getAmt()));
			picture4amt.setText(Integer.toString(page1[3].getAmt()));
		}
		if(pageNumber == 2) {
			picture1amt.setText(Integer.toString(page1[4].getAmt()));
			picture2amt.setText(Integer.toString(page1[5].getAmt()));
			picture3amt.setText(Integer.toString(page1[6].getAmt()));
			picture4amt.setText(Integer.toString(page1[7].getAmt()));
		}
		if(pageNumber == 3) {
			picture1amt.setText(Integer.toString(page1[8].getAmt()));
			picture2amt.setText(Integer.toString(page1[9].getAmt()));
			picture3amt.setText(Integer.toString(page1[10].getAmt()));
			picture4amt.setText(Integer.toString(page1[11].getAmt()));
		}
		if(pageNumber == 4) {
			picture1amt.setText(Integer.toString(page1[12].getAmt()));
			picture2amt.setText(Integer.toString(page1[13].getAmt()));
			picture3amt.setText(Integer.toString(page1[14].getAmt()));
			picture4amt.setText("");
		}
		picture1amt.update();
		picture2amt.update();
		picture3amt.update();
		picture4amt.update();
	}*/

	public void updateDeck() {
		String s = "xd";
		for(Card c: Deck.userDeck) {
			s += c;
		}
		currentDeckTest.setText(s);
	}
	
	public Action addACard(Card card) {
		Deck.userDeck.add(card);
		updateDeck();
		return null;
	}
	
	public void emptyDeck() {
		for(int i = 0; i < Deck.userDeck.size(); i++) {
			Deck.userDeck.clear();
		}
	}
}
