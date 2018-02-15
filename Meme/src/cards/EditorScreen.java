package cards;

import java.awt.Color;
import java.lang.reflect.Array;
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

	private TextArea deckCapacity;
	private ClickableGraphicEditor picture1;
	private ClickableGraphicEditor picture2;
	private ClickableGraphicEditor picture3;
	private ClickableGraphicEditor picture4;
	private Graphic background;
	private TextArea picture1amt;
	private TextArea picture2amt;
	private TextArea picture3amt;
	private TextArea picture4amt;
	private TextArea incompleteOrDone;
	
	private Button pageLeft;
	private Button pageRight;
	private Button emptyButton;
	private Button saveButton;
	
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
	private int deckSize = 0;

	private TextArea[] panel;
	private Button[] removers;
	
	//each button will be 40 pixels high and 100 wide
	
	static ArrayList<Card> playerDeck;

	
	public EditorScreen(int width, int height) {
		super(width, height);
	
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects) {
		playerDeck = new ArrayList<Card>();
		panel = new TextArea[15];
		removers = new Button[15];
		background = new Graphic(0, 0, 1440, 824, "resources/CardBackgroundFinal.png");
		card1= page1[0];
		card2= page1[1];
		card3= page1[2];
		card4= page1[3];
		String amt1 = Integer.toString(card1.getAmt() - card1.getAmtUsed());
		String amt2 = Integer.toString(card2.getAmt() - card2.getAmtUsed());
		String amt3 = Integer.toString(card3.getAmt() - card3.getAmtUsed());
		String amt4 = Integer.toString(card4.getAmt() - card4.getAmtUsed());
		deckCapacity = new TextArea(1200,700,150,40,deckSize+"/15");
		
		incompleteOrDone = new TextArea(980,40,430,200," ");
		incompleteOrDone.setCustomTextColor(Color.WHITE);
		incompleteOrDone.setSize(22);
		
		picture1 = new ClickableGraphicEditor(300,20, 250, 350, "resources/200iq.png",0);
		picture2 = new ClickableGraphicEditor(700,20, 250, 350, "resources/dewyuknodewae.png",1);
		picture3 = new ClickableGraphicEditor(300,400, 250, 350, "resources/dog.png",2);
		picture4 = new ClickableGraphicEditor(700,400, 250, 350, "resources/omaewa.png",3);
		
		picture1amt = new TextArea(395,360,200,150,"Amt: " + amt1);
		picture2amt = new TextArea(795,360,200,150,"Amt: " + amt2);
		picture3amt = new TextArea(395,740,200,150,"Amt: " + amt3);
		picture4amt = new TextArea(795,740,200,150,"Amt: " + amt4);
		
		currentDeckTest = new TextArea(1000,100,300,600,"");
		currentDeckTest.setCustomTextColor(Color.WHITE);
		currentDeckTest.setSize(16);
		
		saveButton = new Button(200,300,100,100,"Save", new Action() {
			
			@Override
			public void act() {
				saveCards();
			}
		});
		
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
				clearPanel();
				deckSize = 0;
				deckCapacity.setText(deckSize + "/15");
				for(int i = 0; i < page1.length -1; i++) {
					page1[i].resetAmts();
					System.out.println("Amt reset");
				}
				updateCardAmts();
			}
		});

		viewObjects.add(background);
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
		
		int counter = 100;
		for(int i = 0; i < 15; i++) {
			int index = i;
			TextArea card = new TextArea(1100,counter,280,40,"");
			Button button = new Button(1050,counter,40,40,"X",new Action() {
				public void act() {
					if(index < playerDeck.size()) {
						playerDeck.get(index).removedOneFromDeck();
						playerDeck.remove(index);
						clearPanel();
						for(int i = 0; i < playerDeck.size(); i++) {
							panel[i].setText(playerDeck.get(i).getName());
						}
						deckSize--;
						deckCapacity.setText(deckSize+"/15");
						updateCardAmts();
					}
				}
			});
			counter += 40;
			card.setCustomTextColor(Color.WHITE);
			card.setSize(18);
			button.setCustomTextColor(Color.WHITE);
			button.setSize(18);
			viewObjects.add(card);
			viewObjects.add(button);
			panel[i] = card;
			removers[i] = button;
		}
		viewObjects.add(saveButton);
		viewObjects.add(incompleteOrDone);
		deckCapacity.setCustomTextColor(Color.WHITE);
		deckCapacity.setSize(18);
		picture1amt.setCustomTextColor(Color.WHITE);
		picture1amt.setSize(16);
		picture2amt.setCustomTextColor(Color.WHITE);
		picture2amt.setSize(16);
		picture3amt.setCustomTextColor(Color.WHITE);
		picture3amt.setSize(16);
		picture4amt.setCustomTextColor(Color.WHITE);
		picture4amt.setSize(16);
		saveButton.setCustomTextColor(Color.WHITE);
		saveButton.setSize(16);
		emptyButton.setCustomTextColor(Color.WHITE);
		emptyButton.setSize(16);
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
		
		updateCardAmts();
	}

	public void updateDeck() {
		if(playerDeck.size() < 16) {
			for(int i = 0; i < playerDeck.size(); i++) {
				panel[i].setText(playerDeck.get(i).getName());
			}
		}
		if(deckSize < 15) {
			deckSize++;
			deckCapacity.setText(deckSize + "/15");
		}
	}

	void updateCardAmts() {
		picture1amt.setText("Amt: " + Integer.toString(card1.getAmt() - card1.getAmtUsed()));
		picture2amt.setText("Amt: " + Integer.toString(card2.getAmt() - card2.getAmtUsed()));
		picture3amt.setText("Amt: " + Integer.toString(card3.getAmt() - card3.getAmtUsed()));
		if(pageNumber == 4) {
			picture4amt.setText("");
		} else {
			picture4amt.setText("Amt: " + Integer.toString(card4.getAmt() - card4.getAmtUsed()));
		}
	}
	
	public void saveCards() {
		if(playerDeck.size() == 15) {
			Deck.deck.clear();
			for(Card c: playerDeck) {
				Deck.deck.add(c);
			}
			incompleteOrDone.setText("Saved! You can now use your deck to battle.");
		} else {
			incompleteOrDone.setText("You must have 15 cards in your deck!");
		}
	}

	private void clearPanel() {
		for(TextArea t: panel) {
			t.setText(" ");
		}
	}
}
