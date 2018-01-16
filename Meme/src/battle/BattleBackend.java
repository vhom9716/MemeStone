package battle;

import java.util.ArrayList;

import cards.Card;

public class BattleBackend {
	public boolean running;
	
	public Player player;
	public AI cpu;
	
	public Card selectedCard;
	public Card opponentCard;
	
	public ArrayList<Card> playerBoard;
	public ArrayList<Card> computerBoard;
	
	public int playerBoardNum;
	public int cpuBoardNum;
	public int playerCrystal;
	public int cpuCrystal;
	
	public BattleBackend() {
		running = true;
		
		player = new Player();
		cpu = new AI();
		
		selectedCard = null;
		opponentCard = null;
		
		playerBoard = new ArrayList<Card>();
		computerBoard = new ArrayList<Card>();
		
		playerBoardNum= 0;
		cpuBoardNum = 0;
		playerCrystal = 0;
		cpuCrystal = 0;
	}
	
	public void run() {
		while(running) {
			addMana();
			player.drawCard();
			cpu.drawCard();
			playerTurn();
			cpuTurn();
			checkStatus();
		}//
	
	}
	
}
