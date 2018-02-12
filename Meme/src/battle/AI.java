package battle;

import java.util.ArrayList;

import cards.Card;
import cards.Monster;
import cards.MonsterCard;
import cards.SpellCard;

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
	
	//ensure that taunts are accounted for
	public void declareAttack(int sel) {
		
		for(Monster m: Player.board) {
			if(m.hasTaunt) {
				tauntPresent = true;
			}
		}
		if(board.get(sel).canAttack) { 
			
		}
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

	public void drawCard(int i) {
		// TODO Auto-generated method stub
		
	}
}
 