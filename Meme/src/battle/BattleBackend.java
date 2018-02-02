package battle;

import java.util.ArrayList;

import cards.*;

public class BattleBackend {
	public boolean running;
	public boolean playerTurn;
	public boolean cpuTurn;
	
	public Player player;
	public AI cpu;
	
	public Card selectedCard;
	public Card opponentCard; 
	
	public ArrayList<MonsterCard> playerBoard;
	public ArrayList<MonsterCard> computerBoard;
	
	public int playerBoardNum;
	public int cpuBoardNum;
	
	public String move;
	
	
	public BattleBackend() {
		running = true;
		playerTurn = true;
		cpuTurn = false;
		
		player = new Player();
		cpu = new AI();
		
		selectedCard = null;
		opponentCard = null;
		
		playerBoard = new ArrayList<MonsterCard>();
		computerBoard = new ArrayList<MonsterCard>();
		
		playerBoardNum= 0;
		cpuBoardNum = 0;
		
		move = "";
	}
	
	public void run() {
		while(running) {
			addMana();
			refreshMana();
			player.drawcard();
			cpu.drawCard();
			playerTurn();
			cpuTurn();
			checkStatus();
		}
	
	}
	// call to refresh mana
	private void refreshMana() {
		player.currentmana = player.maxmana;
		cpu.currentMana = cpu.maxMana;
	}
	
	//increments max mana by 1
	private void addMana() {
		if(player.maxmana <10) {
			player.maxmana++;
			cpu.maxMana++;
		}
	}

	private void checkStatus() {
		// TODO Auto-generated method stub
		
	}

	public void playerTurn() {
		/*while(playerTurn) {
			if (move.equals("attack")) {
				attack(selectedCard, opponentCard);
			}
			else if(move.equals("singlespell")) {
				selectedCard.playEffect();
			}
			
		}*/
	}
	
	public void cpuTurn() {
		
	}
	
	// player's monster attacks cpu's monster
	public void attack(Card attacker, Card reciever) {
		attacker.health -= reciever.attack;
		reciever.health -= attacker.attack;
		updateBoard();
	}
	
	public void updateBoard() {
		
	}
	// checks to see if cpu has a taunt on the board
	public boolean oneTaunt(ArrayList<MonsterCard> cpuBoard) {
		for(int i=0; i < cpuBoard.size(); i++) {
			if (cpuBoard.get(i).getTaunt()) {
				return true;
			}
		}
		return false;
	}

	public boolean validAttack(MonsterCard card) {
		return (oneTaunt(computerBoard) == true && card.getTaunt() == true) || (oneTaunt(computerBoard) == false); 
	}
	
	public void playCard(Card card) {
		if(card instanceof MonsterCard && validSummon((MonsterCard)card)) {
			playerBoard.add((MonsterCard) card);
			player.hand.remove(card);
			player.currentmana -= card.getCost();
		}else if(card instanceof SpellCard && validSpell((SpellCard)card)) {
			card.act();
			player.hand.remove(card);
			player.currentmana -= card.getCost();
		}
	}

	private boolean validSpell(SpellCard card) {
		return player.currentmana >= card.getCost();
	}

	private boolean validSummon(MonsterCard card) {
		return (player.currentmana >= card.getCost()) && playerBoardNum < 5;
	}
	
}
