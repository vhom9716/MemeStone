package battle;

import java.util.ArrayList;

import cards.Card;
import cards.MonsterCard;
import cards.SpellCard;

public class Player implements Character{
	
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<MonsterCard> board;
	public boolean[] playable; 
	private String name;
	public int health;
	public int currentmana;
	public int gold=0;
	public int maxmana;
	public int manaslot;

	public Player(String name,int gold,int health,int maxmana,int mana,ArrayList<Card> deck, ArrayList<Card> hand) {
		this.name=name;
		this.health=health;
		this.deck=deck;
		//this.hand=hand;
		this.hand = new ArrayList<Card>();
		this.board = new ArrayList<MonsterCard>();
		this.currentmana=1;
		this.maxmana=1;
		this.gold=gold;
		//sendinfortofront();//
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

	public void updategold(int x) {
		gold+=x;
	}
	public void drawcard(int amount) {
		if(deckSize()==0) {
			System.out.println("out of cards");
			health--;
		}else {
			while(amount>0) {
				Card x = deck.get(0);
			
				deck.remove(0);
				hand.add(x);
				checkHand();
				amount--;
			}
			
		}
		
		

	} 
	public int deckSize() {
		return deck.size();
	}
	private void checkHand() {
		if(hand.size()>4) {
			hand.remove(4);
			System.out.println("removedCard");
		}
		
	}
	public void giveManaSlot() {
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
	public void takeDamage(int damage) {
		health-=damage;
	}
	public boolean canPlayCard() {
		return hand.stream().filter(card->card.getCost()<=currentmana).count() >0;
	}
	public int returnHp() {
		return health;
	}
	public int returnGold() {
		return gold;
	}
	public int returnMana() {
		return currentmana;
	}
	public String returnManaString() {
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
		currentmana -= c.getCost();
	}

	@Override
	public void removeFromHand(int pos) {
		hand.remove(pos);
	}

	@Override
	public int getHandSize() {
		return hand.size();
	}

	@Override
	public void playSpell(SpellCard card) {
		currentmana -= card.getCost();
	}

	@Override
	public Card getFromBoard(int i) {
		return board.get(i);
	}

	@Override
	public int getBoardSize() {
		return board.size();
	}
}
