package battle;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import cards.Monster;

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
	
	public void playMonster(int cardPos) {
		board.add(hand.get(cardPos));
		hand.remove(cardPos);
	}
	
	public void playSpell(int cardPos) {
		hand.get(cardPos);
	}
	
	/**
	 * plays a card, if the board is less than 5, (max size) it can play a monster
	 */
	public void playCard() {
		int selCard = 1;
		playSpell(selCard);
		if(board.size() < 5) {
			playMonster(selCard);
		}
	}
	
	public void executeTurn() {
		drawCard();
		maxMana++;
		currentMana = maxMana;
		while(!checkTurnDone()) {
			playCard();
			declareAttack();
		}
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
			if(c.cost < currentMana) {
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
	public boolean checkTurnDone() {
		if(checkManaCostsInHand()) {
			return true;
		}else {
			if(availableAttacksOnBoard()) {
				return true;
			}
		}
		return false;
		
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
		return currentMana;
	}
}
 