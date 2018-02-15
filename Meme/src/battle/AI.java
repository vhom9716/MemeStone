package battle;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import cards.Monster;
import cards.MonsterCard;

import cards.SpellCard;


public class AI implements Character{
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<Card> board;
	public int health;
	public int maxMana;
	public int currentMana;
	
	public AI() {
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		board = new ArrayList<Card>();
		deck.add(Deck.Doge);
		deck.add(Deck.PotOfGreed);
		deck.add(Deck.OmaeWaMouShindeiru);
		deck.add(Deck.RainbowDash);
		deck.add(Deck.Pikachu);
		deck.add(Deck.ScrewTheRulesIHaveMoney);
		deck.add(Deck.SaltBae);
		deck.add(Deck.DewYuKnoDeWae);
		deck.add(Deck.UWot);
		deck.add(Deck.UltraMegaChicken);
		deck.add(Deck.Shenron);
		deck.add(Deck.WTF);
		
		hand.add(deck.get(0));
		hand.add(deck.get(1));
		hand.add(deck.get(2));
		hand.add(deck.get(3));
	}
	
	public ArrayList<Card> getBoard() {
		return board;
	}
	
	public void changeHealth(int change) {
		health += change;
	}
	
	public void drawCard(int num) {
		while(num > 0 && deck.size() == 0) {
			System.out.println(num + deck.get(0).getImage());
			hand.add(deck.get(0));
			deck.remove(0);
			num--;	
		}
	}
	//ensure that taunts are accounted for
	public void declareAttack(int sel) {
		
		if(board.get(sel).canAttack) { 
			
		}
		board.get(sel).setCanAttack(false);
	}
	
	public void playMonster(MonsterCard m) {
		board.add(m);
		hand.remove(m);
		//updateHand
		//updateField
	}
	
	public void playSpell(Card selCard) {
		hand.get(selCard).act();
	}
	public void playSpell(int cardPos) {
		hand.get(cardPos);
	}
	
	/**
	 * plays a card, if the board is less than 5, (max size) it can play a monster
	 */
	public void playCard() {
		int a = 1;
		Card selCard = hand.get(a);
		if(board.size() < 5 && selCard instanceof MonsterCard) {
			playMonster((MonsterCard)selCard);
		}
		if(selCard instanceof SpellCard) {
			playSpell(selCard);
		}
	}
	
	public void executeTurn() {
		drawCard();
		maxMana++;
		currentMana = maxMana;
		checkTurnDone(); 
	}
	 
	//checking turn completion can go into battle class 
	
	
	/**
	 * checks AI's hand to see if there are any playable cards left.
	 * first checks if there are cards in hand,
	 * if there are it checks the mana costs of each card
	 * @return
	 */
	private boolean checkManaCostsInHand() {
		if(hand.size() == 0) {
			return false;
		}
		for(Card c: hand) {
			if(c.getCost() < currentMana) {
				 return true;
			}
		}
		return false;
	}
	
	/**
	 * checks various things to see if turn is done
	 * first if there are playable cards in hand,
	 * then if there are available monsterAttacks.
	 * @return 
	 */
	public void checkTurnDone() {
		while(checkManaCostsInHand()) {
			playCard();
			//updateHand
			//updateField
		}
		while(availableAttacksOnBoard()) {
			declareAttack(0);
		}
	}
	/**
	 * checks if there are available attacks on the player's board
	 * first checks if there are cards on board,
	 * then if there are any monsters on board that can attack.
	 * @return
	 */
	private boolean availableAttacksOnBoard() {
		if(board.size() == 0) {
			return false;
		}
		for(Monster m: board) {
			if(m.canAttack) {
				return true;
			}
		} 
		return false;
	}

	public int returnmana() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Card getFromHand(int pos) {
		return hand.get(pos);
	}

	@Override
	public void addToBoard(MonsterCard c) {
		board.add(c);
	}


	public void removeFromHand(int pos) {
		hand.remove(pos);
	}

	@Override
	public int getHandSize() {
		return hand.size();

	}
}
 