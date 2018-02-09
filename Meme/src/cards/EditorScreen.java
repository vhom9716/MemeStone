package cards;

import java.awt.Color;
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

	//private DeckPane pane;
	private TextArea deckCapacity;
	private TextArea pageNumberArea;
	private ClickableGraphicEditor picture1;
	private ClickableGraphicEditor picture2;
	private ClickableGraphicEditor picture3;
	private ClickableGraphicEditor picture4;
	private Graphic background;
	private TextArea picture1amt;
	private TextArea picture2amt;
	private TextArea picture3amt;
	private TextArea picture4amt;
	
	private Button pageLeft;
	private Button pageRight;
	private Button emptyButton;
	
	public TextArea currentDeckTest;
	
	public static Card[] page1 = {Deck.IQ, Deck.DewYuKnoDeWae, Deck.Doge, Deck.OmaeWaMouShindeiru,
								  Deck.Pikachu, Deck.PotOfGreed, Deck.RainbowDash, Deck.SaltBae,
								  Deck.ScrewTheRulesIHaveMoney, Deck.DragonBalls, Deck.Shenron,Deck.TheExcutiveProducer,
								  Deck.UltraMegaChicken, Deck.UWot, Deck.WTF, null};
	
	private Card card1 = page1[0];
	private Card card2 = page1[1];
	private Card card3 = page1[2];
	private Card card4 = page1[3];
	
	private int pageNumber = 1;
	private int deckSize;
	private int currentY = 100;
	private int currentButtonCount = 0;
	private Button cardButton;
	

	private Button[] cardsChosen;
	/*= 
	*/
	
	//each button will be 40 pixels high and 100 wide
	
	static ArrayList<Card> playerDeck;

	
	public EditorScreen(int width, int height) {
		super(width, height);
	
		// TODO Auto-generated constructor stub
	}

	
	private Action removeCard(int index) {
		cardsChosen[index].setText("");
		return null;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		cardsChosen = new Button[16];
		playerDeck = new ArrayList<Card>();
		background = new Graphic(0, 0, 1440, 824, "resources/CardBackgroundFinal.png");
		String amt1 = Integer.toString(page1[0].getAmt());
		String amt2 = Integer.toString(page1[1].getAmt());
		String amt3 = Integer.toString(page1[2].getAmt());
		String amt4 = Integer.toString(page1[3].getAmt());
		//pane = new DeckPane(this, 1200, 100,150,600);
		//pane.update();
		deckCapacity = new TextArea(1200,700,150,40,deckSize+"/15");
		
		picture1 = new ClickableGraphicEditor(300,20, 250, 350, "resources/200iq.png",0);
		picture2 = new ClickableGraphicEditor(700,20, 250, 350, "resources/dewyuknodewae.png",1);
		picture3 = new ClickableGraphicEditor(300,400, 250, 350, "resources/dog.png",2);
		picture4 = new ClickableGraphicEditor(700,400, 250, 350, "resources/omaewa.png",3);
		
		picture1amt = new TextArea(330,360,200,150,amt1);
		picture2amt = new TextArea(730,360,200,150,amt2);
		picture3amt = new TextArea(330,740,200,150,amt3);
		picture4amt = new TextArea(730,740,200,150,amt4);
		
		currentDeckTest = new TextArea(1000,100,300,600,"");
		currentDeckTest.setCustomTextColor(Color.WHITE);
		currentDeckTest.setSize(16);
		
		pageLeft = new Button(500,750,100,75," ",new Action() {
			@Override
			public void act() {
				if(pageNumber != 1) {
					pageNumber--;
					updateCards();
					updateCardAmts();
				}
			}
		});
		pageRight = new Button(650,750,100,75," ",new Action() {
			@Override
			public void act() {
				if(pageNumber != 4) {
					pageNumber++;
					updateCards();
					updateCardAmts();
				}
			}
		});
		emptyButton = new Button(50,200,200,100,"Clear Deck", new Action() {
			public void act() {
				System.out.println("shak");
				playerDeck.clear();
				String s = "Cleared";
				for(Card c: playerDeck) {
					s+=c;
				}
				currentDeckTest.setText("");
				System.out.println("sdhak");
			}
		});
		int counter = 140;
		for(int i = 0; i < 16; i++) {
			Button a = new Button(1000,counter,100,40,"hi", null);
			//a.setVisible(false);
			viewObjects.add(a);
			System.out.println(a.getText());
			cardsChosen[i] = a;
			a.setAction(removeCard(i));
			counter += 40;
		}
		
		
		viewObjects.add(background);
		//viewObjects.add(pane);
		viewObjects.add(deckCapacity);
		viewObjects.add(picture1);
		viewObjects.add(picture2);
		viewObjects.add(picture3);
		viewObjects.add(picture4);
		viewObjects.add(picture1amt);
		viewObjects.add(picture2amt);
		viewObjects.add(picture3amt);
		viewObjects.add(picture4amt);
		Button menu = new Button(30, 50, 300,80," ",new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen1);
					
			}
		});
		viewObjects.add(menu);
		viewObjects.add(pageLeft);
		viewObjects.add(pageRight);
		viewObjects.add(currentDeckTest);
		viewObjects.add(emptyButton);
	}

	public void changeText() {
		cardsChosen[1].setText("LOL");
		cardsChosen[1].setVisible(true);
	}

	public void updateCards() {
		card1 = page1[4*(pageNumber-1)];
		picture1.setGraphic(card1.getImage(), (4*(pageNumber-1)), 250, 350);
		
		card2 = page1[(4*(pageNumber-1))+1];
		picture2.setGraphic(card2.getImage(), (4*(pageNumber-1))+1, 250, 350);
		
		card3 = page1[(4*(pageNumber-1))+2];
		picture3.setGraphic(card3.getImage(), (4*(pageNumber-1))+2, 250, 350);
		
		if(pageNumber != 4) {
			card4 = page1[(4*(pageNumber-1))+3];
			picture4.setGraphic(card4.getImage(), (4*(pageNumber-1))+3, 250, 350);
		} else {
			picture4.setGraphic("resources/placeholder.png", (4*(pageNumber-1))+3, 2, 2);
			//card4 = null;
		}
	}

	public void updateDeck() {
		if(playerDeck.size() < 16) {
			int counter = 1;
			String s = "Deck: \n";
		
			for(Card c: playerDeck) {
				s += counter +". " + c+"\n";
				counter++;
			}
			currentDeckTest.setText(s);
		}
	}
	
	public Action addACard(Card card) {
		playerDeck.add(card);
		updateDeck();
		return null;
	}

	private void updateCardAmts() {
		picture1amt.setText(Integer.toString(card1.getAmt()));
		picture2amt.setText(Integer.toString(card2.getAmt()));
		picture3amt.setText(Integer.toString(card3.getAmt()));
		if(pageNumber == 4) {
			picture4amt.setText("");
		} else {
			picture4amt.setText(Integer.toString(card4.getAmt()));
		}
	}

	public void createButton() {
		currentY = 100;
		for(Card c: playerDeck) {
			cardButton= new Button(1000, currentY, 150,40,c.getName(), Color.white, new Action() {
				
				@Override
				public void act() {
					playerDeck.remove(c);
				}
			});
			currentY += 40;
		}
	}
}
