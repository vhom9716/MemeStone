package battle;

import java.util.ArrayList;

import cards.*;
import menu.Menu;

public class BattleBackend {
	public boolean running;
	public boolean playerTurn;
	public boolean cpuTurn;
	
	public AI cpu;
	
	public Card selectedCard;
	public Card opponentCard;  
	
	public ArrayList<MonsterCard> playerBoard;
	public ArrayList<MonsterCard> computerBoard;
	
	public int playerBoardNum;
	public int cpuBoardNum;
	
	public String move;

	public static Deck craftDeck = new Deck();
	public Deck newDeck;

	public Player player;
	
	public BattleBackend() {
		running = true;
		playerTurn = true;
		cpuTurn = false;
		newDeck = new Deck();
		newDeck.deck.clear();
		for(int i=0; i < craftDeck.deck.size();i++) {
			newDeck.deck.add((craftDeck.deck.get(i)));
		}
		
		player = new Player("Bob", 100, 30, 10, 1, newDeck.deck, null);
		cpu = new AI();
		
		selectedCard = null;
		opponentCard = null;
		
		playerBoard = player.board;
		computerBoard = cpu.board;
		
		playerBoardNum= 0;
		cpuBoardNum = 0;
		
		move = "";
	}
	
	/**
	 * Runs the game 
	 * Running variable determines if the game is still running
	 */
	public void run() {
		while(running) {
			addMana(); 
			refreshMana();
			if(playerTurn) {
				player.drawcard(1);
				System.out.print("The current turn is player");
			}
			checkStatus();
		}
	
	}
	
	public void startPlayerTurn() {
		addMana(); 
		refreshMana();
		player.drawcard(1);
		System.out.print("The current turn is player");
	}
	
	void refreshMana() {
		player.currentmana = player.maxmana;
		cpu.currentMana = cpu.maxMana;
	}

	void addMana() {
		if(player.maxmana <10) {
			player.currentmana++;
			player.maxmana++;
		}
	}

	public String checkStatus() {
		if (player.health <=0) {
			return "CPU";
		}
		return "Player";
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
		for(int i=0; i < playerBoard.size();i++) {
			if(player.board.get(i).getHealth() <= 0) {
				player.board.remove(i);
				i--;
			}
		}
		for(int i=0; i<computerBoard.size();i++) {
			if(cpu.board.get(i).getHealth() <= 0) {
				cpu.board.remove(i);
				i--;
			}
		}
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
	boolean validSpell(Card card) {
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
	
	
	public void attackFace(MonsterCard card) {
		if(card.canAttack) {
			cpu.health -= card.getAttack();
			card.setCanAttack(false);
		}
	}}

  