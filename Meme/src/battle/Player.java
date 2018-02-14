package battle;

import java.util.ArrayList;

import cards.Card;
import cards.MonsterCard;

public class Player implements Character{
	
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<Card> board;
	public boolean[] playable; 
	private String name;
	public int health;
	public static int currentmana =10;
	public int gold=0;
	public int maxmana;
	public int manaslot;

	public Player(String name,int gold,int health,int maxmana,int mana,ArrayList<Card> deck, ArrayList<Card> hand) {
		this.name=name;
		this.health=health;
		this.deck=deck;
		//this.hand=hand;
		this.hand = new ArrayList<Card>();
		this.board = new ArrayList<Card>();
		this.currentmana=mana;
		this.maxmana=maxmana;
		this.gold=gold;
		//sendinfortofront();
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public Player() {
		maxmana = 10;
		health = 30;
		//currentmana = 0;
		manaslot = 0;
		//sendinfortofront();

	}
	boolean[] sendinfortofront() {
		playable=new boolean[hand.size()];
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getCost()>currentmana) {
				playable[i]=false;
			}else {
				playable[i]=true;
			}
		}
		return playable;
		

	}
	public void updategold(int x) {
		gold+=x;
	}
	public void drawcard(int amount) {
		if(decksize()==0) {
			System.out.println("out of cards");
			health--;
		}else {
			while(amount>0) {
				System.out.println(deck.size());
				Card x = deck.get(0);
			
				deck.remove(0);
				hand.add(x);
				checkhand();
				amount--;
				//menu.Menu.screen3.drawACard(x.getImage());
			}
			
		}
		
		

	} 
	public int decksize() {
		return deck.size();
	}
	private void checkhand() {
		if(hand.size()>4) {
			hand.remove(3);
		}
		
	}
	public void givemanaslot() {
		if(manaslot<maxmana) {
			manaslot++;
		}
	}
	public void refillMana() {
		currentmana=manaslot;
	}
	public void heal(int heal) {
		if(health+heal>30) {
			health=30;
		}else {
			health+=heal;
		}
		
	}
	public void takedamage(int damage) {
		health-=damage;
	}
	public boolean canplaycard() {
		return hand.stream().filter(card->card.getCost()<=currentmana).count() >0;
	}
	public int returnhp() {
		return health;
	}
	public int returnGold() {
		return gold;
	}
	public static int returnmana() {
		return currentmana;
	}
	public String returnmanastring() {
		return Integer.toString(currentmana);
	}
	
	public void declareAttack(Card attacker,Card victim) {
		
	}

	@Override
	public Card getFromHand(int pos) {
		return hand.get(pos);
	}

	@Override
	public void addToBoard(MonsterCard c) {
		board.add(c);
	}

	@Override
	public void removeFromHand(int pos) {
		hand.remove(pos);
	}

	@Override
	public int getHandSize() {
		return hand.size();
	}
	
 
}
