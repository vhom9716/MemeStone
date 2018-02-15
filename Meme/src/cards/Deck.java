package cards;

import java.util.*;

import battle.AI;
import battle.BattleBackend;
import battle.Player;
/**
 * Made act(Player player, AI cpu, String turn, Card card, BattleBackend backend) that changes the player's property
 */
public class Deck{
	//25
	 static public Card IQ = new SpellCard("200 IQ",2,"Draw a minion from deck", 2, new Action() {
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend){
			if(turn.equals("player")) {
				for(int i =0;i<player.deck.size()-1;i++) {
					if(player.deck.get(i) instanceof MonsterCard) {
						player.hand.add(player.deck.get(i));
						player.deck.remove(i);
						player.currentmana -= 2;
						return;
					}
				}
			}
			else {
				for(int i =0;i<cpu.deck.size()-1;i++) {
					if(cpu.deck.get(i) instanceof MonsterCard) {
						cpu.hand.add(player.deck.get(i));
						cpu.deck.remove(i);
						cpu.currentMana -= 2;
						return;
					}
				}
			}
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		
	}, "resources/200iq.png");
	static public Card Doge = new MonsterCard("Doge",6,"Taunt",null, 1, 6, 6, false, new Action() {

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	},"resources/dog.png" );
	
	static public Card UltraMegaChicken = new MonsterCard("UltraMegaChicken",2,"",null, 3, 3, 3, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	},"resources/UltraMegaChicken.png");
	static public Card OmaeWaMouShindeiru = new SpellCard("Omae wa mou Shindeiru",7, "Damage the hero 15 health", 1, new Action() {
		
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				player.takeDamage(15);
			}else {
				cpu.changeHealth(-15);
			}
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/omaewa.png");
	static public Card Pikachu = new MonsterCard("Pikachu",4,"Battlecry",null, 1, 7, 7, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/pika.png");
	static public Card PotOfGreed = new SpellCard("Pot of Greed",1,"Draw 2 cards",2, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				for(int i =0;i<2;i++) {
						player.hand.add(player.deck.get(0));
						player.deck.remove(0);
					}
			}
			else {
				for(int i =0;i<2;i++) {
						cpu.hand.add(player.deck.get(i));
						cpu.deck.remove(i);
					}
				}
			}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
		
	}, "resources/pog.png");
	static public Card TheExcutiveProducer = new MonsterCard("The Excutive Producer",3,"",null, 3, 4, 2, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/theexecutiveproducter.png");
	static public Card RainbowDash = new MonsterCard("Rainbow Dash!",3,"Charge",null, 2,5,1, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			card.summon = true;
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/rd.png");
	static public Card SaltBae = new SpellCard("Salt Bae",5,"Heals hero for 10",2, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")){
				player.heal(10);
			}else {
				cpu.changeHealth(10);
			}
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/saltbae.png");
	static public Card ScrewTheRulesIHaveMoney = new SpellCard("Screw The Rules, I Have Money",5,"Gain max empty mana crystals",3, new Action() {
		public void act() {
			
		}
 
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				player.currentmana=10;
			}else {
				cpu.currentMana=10;
			}
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/screwingtherules.png");
	static public Card Shenron = new MonsterCard("Shenron",50,"Charge","Taunt",0,99,99, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			card.setCanAttack(true);
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/shenrun.png");
	static public Card DewYuKnoDeWae = new MonsterCard("Dew yu kno de wae", 4, null, null, 1, 5, 4, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/dewyuknodewae.png");
	static public Card UWot = new MonsterCard("u wot", 1, null, null, 3,1,1, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/wotm8.png");
	static public Card WTF = new SpellCard("WTF?!?", 3, "Deals 3 damage to a random player",2, new Action() {

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(Math.random() > 0.5) {
				cpu.health -= 3;
			}else {
				player.health -= 3;
			}
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/wtfs.png");
	static public Card DragonBalls = new SpellCard("Seven Dragon Balls", 10, "Summon Shenron",0, new Action() {
		public void act() {
			 
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				for(int i=0;i<backend.player.hand.size()-1;i++) {
					if(backend.player.hand.get(i).getName().equals("Shenron"))  {
						System.out.println("true");
						backend.playerBoard.add((MonsterCard) Shenron);
						backend.player.hand.remove((MonsterCard) Shenron);
						break;
					}else {
						System.out.println("hehe");
					}
				}
				for(int x=0;x<backend.player.deck.size()-1;x++) {
					if(backend.player.deck.get(x).getName().equals("Shenron"))  {
						backend.playerBoard.add((MonsterCard) Shenron);
						backend.player.deck.remove((MonsterCard) Shenron);
						System.out.println("true");
						break;
					}
					System.out.println("haha");
				}
			
			
			}
		}

		@Override
		public void act(Player player, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/sevendragonballs.png");
	
	public static ArrayList<Card> collection;
	public ArrayList<Card> deck= new ArrayList<Card>();
	public ArrayList<Card> playDeck = new ArrayList<Card>();
	public Deck() {


		collection = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		collection.add(IQ);
		collection.add(Doge);
		collection.add(UltraMegaChicken);
		collection.add(OmaeWaMouShindeiru);
		collection.add(Pikachu);
		collection.add(PotOfGreed);
		collection.add(TheExcutiveProducer);
		collection.add(RainbowDash);
		collection.add(SaltBae);
		collection.add(ScrewTheRulesIHaveMoney);
		collection.add(DewYuKnoDeWae);
		collection.add(UWot);
		collection.add(WTF);
		
		
		for(int i = 0; i<10; i++) {
			int r =  (int) Math.floor(Math.random() * 12);
			deck.add(collection.get(r));
		}

	}
	
	public void addCard(Card card) {
		if(deck.size() < 16 && card.getAmt() > 1) {
			deck.add(card);
			card.setAmt(card.getAmt()-1);
		}
	}
	
	public void deleteCard(Card c) {
		deck.remove(c);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
}
