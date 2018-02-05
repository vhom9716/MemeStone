package battle;

import java.util.ArrayList;

import cards.*;
import menu.Menu;

public class BattleBackend {
	public boolean running;
	public boolean playerTurn;
	public boolean cpuTurn;
	
	public static Player player;
	public AI cpu;
	
	public Card selectedCard;
	public Card opponentCard;  
	
	public ArrayList<MonsterCard> playerBoard;
	public ArrayList<MonsterCard> computerBoard;
	
	public int playerBoardNum;
	public int cpuBoardNum;
	
	public String move;
	public Deck newDeck;

	
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
		newDeck = new Deck();
		newDeck.deck.get(0).a.act();
	}
	
	public void run() {
		while(running) {
			addMana();
			refreshMana();
			player.drawcard(1);
			cpu.draw();
			playerTurn();
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
	
	public void attack(MonsterCard attacker, MonsterCard reciever) {
		attacker.setHealth(attacker.getHealth()- reciever.getAttack());
		reciever.setHealth(reciever.getHealth()- attacker.getAttack());
		updateBoard();
	}
	
	public void updateBoard() {
		
	}
	
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
	

	public void playCard(Card card, int pos) {
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
		

	
	}

	private boolean validSpell(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validSummon(Card card) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int returnWinNumber() {
		if (player.returnhp() <= 0) {
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
  