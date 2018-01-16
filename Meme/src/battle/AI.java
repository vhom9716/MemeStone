package battle;

import java.util.ArrayList;

import cards.Card;
import cards.Monster;

public class AI {
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<Card> board;
	public int health;
	public int maxMana;
	public int currentMana;
	
	
	public ArrayList<Card> getBoard() {
		return board;
	}
	
	public void changeHealth(int change) {
		health += change;
	}
	
	public void draw() {
		if(deck.size() == 0) {
			lose(); //handled by backend
		}else {
			hand.add(deck.get(0));
			deck.remove(0);
		}
	}

	public void declareAttack() {
		
	}
	
	public void playMonster(int cardPos) {
		
	}
	
	public void playSpell(int cardPos) {
		
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
		draw();
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
	private boolean checkTurnDone() {
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
}
