package battle;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Deck;
import cards.Monster;
import cards.MonsterCard;

import cards.SpellCard;


public class AI implements Character{
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<MonsterCard> board;
	public int health;
	public int currentMana;
	public int maxMana = 0;
	
	public AI() {
		currentMana = 0;
		maxMana = 0;
		health = 30;
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		board = new ArrayList<MonsterCard>();
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
		deck.add(Deck.DragonBalls);
		deck.add(Deck.WTF);
		deck.add(Deck.WTF);
		
		Collections.shuffle(deck);
		
		hand.add(deck.get(0));
		hand.add(deck.get(1));
		hand.add(deck.get(2));
		hand.add(deck.get(3));
	}
	
	public ArrayList<MonsterCard> getBoard() {
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
		currentMana -= m.getCost();
	}

	/**
	 * plays a card, if the board is less than 5, (max size) it can play a monster
	 * @param card 
	 */
	public void playCard(Card selCard) {
		if(board.size() < 5 && selCard instanceof MonsterCard) {
			playMonster((MonsterCard)selCard);
		}
		if(selCard instanceof SpellCard) {
			playSpell((SpellCard) selCard);
		}
	}
	
	public void executeTurn() {
		drawCard(1);
		if(maxMana < 10) {
			maxMana += 1;
		}
		currentMana = maxMana;
		checkTurnDone(); 
		System.out.println("CPU turn over");
		Menu.screen3.update();
//		BattleScreen.backend.playerTurn = !BattleScreen.backend.playerTurn;
//		BattleScreen.backend.cpuTurn = !BattleScreen.backend.cpuTurn;
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
				System.out.println(c.getCost());
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
			for(int i = 0; i < hand.size(); i++) {
				System.out.println(currentMana);
				if(currentMana >= hand.get(i).getCost()) {
					playCard(hand.get(i));
					System.out.println(hand.get(i).getName() + " " + currentMana);
				}
			}
			
			//updateHand
			//updateField
		}
//		while(availableAttacksOnBoard()) {
//			declareAttack(0);
//		}
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
		for(MonsterCard m: board) {
			if(m.canAttack) {
				return true;
			}
		} 
		return false;
	}

	public int returnmana() {
		return currentMana;
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

	public int returnHp() {
		return health;
	}
	
	public void playSpell(SpellCard card) {
		card.a.act(BattleScreen.backend.player, BattleScreen.backend.cpu, "cpu", card, BattleScreen.backend);
		currentMana -= card.getCost();
	}
}
 