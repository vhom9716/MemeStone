package cards;

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

	private Deck currentDeck;
	private DeckPane pane;
	private TextArea deckName;
	private int deckSize;
	private String name = "LOL";
	private TextArea deckCapacity;
	private TextArea pageNumberArea;
	private Button pageLeft;
	private Button pageRight;
	private Graphic picture1;
	private Graphic picture2;
	private Graphic picture3;
	private Graphic picture4;
	private TextArea picture1amt;
	private TextArea picture2amt;
	private TextArea picture3amt;
	private TextArea picture4amt;
	
	Card[] page1 = {Deck.IQ, Deck.DewYuKnoDeWae, Deck.Doge, Deck.OmaeWaMouShindeiru};
	Card[] page2 = {Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.SaltBae};
	Card[] page3 = {Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.Shenron,Deck.TheExcutiveProducer,};
	Card[] page4 = {Deck.UltraMegaChicken,Deck.UWot, Deck.WTF};
	
	private int pageNumber = 1;
	
	public EditorScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//String amt1 = Integer.toString(page1[0].getAmt());
		//String amt2 = Integer.toString(page1[1].getAmt());
		//String amt3 = Integer.toString(page1[2].getAmt());
		//String amt4 = Integer.toString(page1[3].getAmt());
		//pane = new DeckPane(this, 1000, 100,150,600);
		//pane.update();
		deckName = new TextArea(1000, 40, 150, 40, "LOL");
		deckCapacity = new TextArea(1000,700,150,40,deckSize+"/15");
		picture1 = new Graphic(200,100,200,300,"resources/200iq.png");
		picture2 = new Graphic(600,100,200,300,"resources/dewyuknodewae.png");
		picture3 = new Graphic(200,450,200,300,"resources/dog.png");
		picture4 = new Graphic(600,450,200,300,"resources/omaewa.png");
		//if(pageNumber == 1) {
		//	picture1amt = new TextArea(200,400,200,150,amt1);
		//	picture2amt = new TextArea(600,400,200,150,amt2);
		//	picture3amt = new TextArea(200,750,200,150,amt3);
		//	picture4amt = new TextArea(200,750,200,150,amt4);
			//picture1amt.setText(Integer.toString(page1[1].getAmt()));
			//picture2amt.setText(Integer.toString(page1[2].getAmt()));
			//picture3amt.setText(Integer.toString(page1[3].getAmt()));
			//picture4amt.setText(Integer.toString(page1[4].getAmt()));
		//}
		//viewObjects.add(pane);
		viewObjects.add(deckName);
		viewObjects.add(deckCapacity);
		viewObjects.add(picture1);
		viewObjects.add(picture2);
		viewObjects.add(picture3);
		viewObjects.add(picture4);
		//viewObjects.add(picture1amt);
		//viewObjects.add(picture2amt);
		//viewObjects.add(picture3amt);
		//viewObjects.add(picture4amt);
		Button menu = new Button(400, 400,100,30,"Back to Menu",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
					
			}
		});
		viewObjects.add(menu);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void loadCardsForPage(int page) {
	

	}
}