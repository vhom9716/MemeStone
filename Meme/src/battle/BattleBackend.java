package battle;

import java.util.ArrayList;

import cards.*;
import menu.Menu;

public class BattleBackend {
	public boolean running;
	public boolean playerTurn;
	public boolean cpuTurn;
	
	public static AI cpu;
	
	public Card selectedCard;
	public Card opponentCard;  
	
	public ArrayList<MonsterCard> playerBoard;
	public ArrayList<MonsterCard> computerBoard;
	
	public int playerBoardNum;
	public int cpuBoardNum;
	
	public String move;

	public static Deck craftDeck = new Deck();
	public Deck newDeck;

	public Player player = new Player("Bob", 100, 30, 10, 0, newDeck.deck, new ArrayList<Card>());
	
	public BattleBackend() {
		running = true;
		playerTurn = true;
		cpuTurn = false;
		
		//player = new Player("Bob", 100, 30, 10, 0, newDeck.deck,null);
		cpu = new AI();
		
		selectedCard = null;
		opponentCard = null;
		
		playerBoard = new ArrayList<MonsterCard>();
		computerBoard = new ArrayList<MonsterCard>();
		
		playerBoardNum= 0;
		cpuBoardNum = 0;
		
		move = "";
		
		for(int i=0; i < craftDeck.deck.size();i++) {
			newDeck.addCard(craftDeck.deck.get(i));
		}
	//	player.drawcard(4);
	//	newDeck.deck.get(0).a.act();
		
		//player.drawcard(4);
	}
	
	/**
	 * Runs the game 
	 * Running variable determines if the game is still running
	 */
	public void run() {
		while(running) {
			addMana();
			refreshMana();
			player.drawcard(1);
			cpu.drawCard(1);
			playerTurn= true;
			//playerTurn();
			while(playerTurn) {
				
			}
			cpuTurn();
			checkStatus();
		}
	
	}
	
	private void refreshMana() {
		player.currentmana = player.maxmana;
		cpu.currentMana = cpu.maxMana;
	}

	private void addMana() {
		if(player.maxmana <10) {
			player.maxmana++;
			cpu.maxMana++;
		}
	}

	private void checkStatus() {
		// TODO Auto-generated method stub
		
	}

	/*public void playerTurn() {
		while(playerTurn) {
			if (move.equals("attack")) {
				attack(selectedCard, opponentCard);
			}
			else if(move.equals("singlespell")) {
				selectedCard.playEffect();
			}
			
		}
	}*/
	
	public void cpuTurn() {
		cpu.executeTurn();
	}
	/**
	 * Monster card attacks another monster card
	 * @param attacker
	 * @param reciever
	 */
	public void attack(MonsterCard attacker, MonsterCard reciever) {
		attacker.setHealth(attacker.getHealth()- reciever.getAttack());
		reciever.setHealth(reciever.getHealth()- attacker.getAttack());
		updateBoard();
	}
	
	public void updateBoard() {
		
	}
	/**
	 * Checks to see if there is at least one taunt on CPU's board
	 * @param cpuBoard
	 * @return
	 */
	public boolean oneTaunt(ArrayList<MonsterCard> cpuBoard) {
		for(int i=0; i < cpuBoard.size(); i++) {
			if (cpuBoard.get(i).getTaunt()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks to see if the attack is a valid move
	 * @param card
	 * @return
	 */
	public boolean validAttack(MonsterCard card) {
		return (oneTaunt(computerBoard) == true && card.getTaunt() == true) || (oneTaunt(computerBoard) == false); 
	}
	

/*	public void playCard(Card card, int pos) {
		if(card instanceof MonsterCard && validSummon(card)) {
			card.act();
			playerBoard.add((MonsterCard) card);
			player.hand.remove(card);
			player.currentmana -= card.getCost();
			Menu.screen3.activateCardMon(pos);
		}else if(card instanceof SpellCard && validSpell(card)) {
			card.act();
			player.hand.remove(card);
			player.currentmana -= card.getCost();
			Menu.screen3.activateCardSpell(pos);
		}
		

	
	} */
	/**
	 * Checks to see if the spell is a valid move
	 * @param card
	 * @return
	 */
	private boolean validSpell(Card card) {
		return player.currentmana >= card.getCost();
	}
	/**
	 * Checks to see if the summon is a valid move
	 * @param card
	 * @return
	 */
	private boolean validSummon(Card card) {
		return (player.currentmana >= card.getCost()) && playerBoardNum <5;
	}
	/**
	 * Returns an int that determines who won
	 * @return
	 */
	public int returnWinNumber() {
		if (player.returnHp() <= 0) {
			return 0;
		}
		else if (cpu.health <= 0) {
			return 1;
		}
		else {
			return 2;
		}
	}
}
  