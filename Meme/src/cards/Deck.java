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
	 static public SpellCard IQ = new SpellCard("200 IQ",2,"Draw a minion from deck", 2, new Action() {
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend){
			if(turn.equals("player")) {
				for(int i =0;i<player.deck.size()-1;i++) {
					if(player.deck.get(i) instanceof MonsterCard) {
						player.hand.add(player.deck.get(i));
						player.deck.remove(i);
						return;
					}
				}
			}
			else {
				for(int i =0;i<cpu.deck.size()-1;i++) {
					if(cpu.deck.get(i) instanceof MonsterCard) {
						cpu.hand.add(player.deck.get(i));
						cpu.deck.remove(i);
						return;
					}
				}
			}
		}
		
	}, "resources/200iq.png");
	static public MonsterCard Doge = new MonsterCard("Doge",6,"Taunt",null, 1, 6, 6, false, new Action() {

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			
			
		}
	},"resources/dog.png" );
	
	static public MonsterCard UltraMegaChicken = new MonsterCard("UltraMegaChicken",2,"",null, 3, 3, 3, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	},"resources/UltraMegaChicken.png");
	static public SpellCard OmaeWaMouShindeiru = new SpellCard("Omae wa mou Shindeiru",7, "Damage the hero 15 health", 1, new Action() {
		
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				cpu.changeHealth(-15);
			}else {
				player.takeDamage(15);
			}
			
		}
	}, "resources/omaewa.png");
	static public MonsterCard Pikachu = new MonsterCard("Pikachu",4,"Battlecry",null, 1, 7, 7, false, new Action() {
		public void act() {
			
		}

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/pika.png");
	static public SpellCard PotOfGreed = new SpellCard("Pot of Greed",1,"Draw 2 cards",2, new Action() {

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				for(int i =0;i<2;i++) {
					if(player.deck.size() > 0) {
		
						player.hand.add(player.deck.get(0));
					}
					player.deck.remove(0);
				}	
			}
			else {
				for(int i =0;i<2;i++) {
					if(cpu.deck.size() > 0) {
						if(player.hand.size() < 4) {
							cpu.hand.add(player.deck.get(i));
						}
						cpu.deck.remove(i);
					}	
					}
				}
			}
	}, "resources/pog.png");
	static public MonsterCard TheExcutiveProducer = new MonsterCard("The Excutive Producer",3,"",null, 3, 4, 2, false, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/theexecutiveproducter.png");
	static public MonsterCard RainbowDash = new MonsterCard("Rainbow Dash!",3,"Charge",null, 2,5,1, false, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			card.setCanAttack(true);
		}

	}, "resources/rd.png");
	static public SpellCard SaltBae = new SpellCard("Salt Bae",5,"Heals hero for 10",2, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")){
				player.heal(10);
			}else {
				cpu.changeHealth(10);
			}
			
		}
	}, "resources/saltbae.png");
	static public SpellCard ScrewTheRulesIHaveMoney = new SpellCard("Screw The Rules, I Have Money",5,"Gain max mana crystals",3, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				player.currentmana=10;
			}else {
				cpu.currentMana=10;
			}
			
		}
	}, "resources/screwingtherules.png");
	static public MonsterCard Shenron = new MonsterCard("Shenron",50,"Charge","Taunt",0,99,99, false, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			card.setCanAttack(true);
		}
	}, "resources/shenrun.png");
	static public MonsterCard DewYuKnoDeWae = new MonsterCard("Dew yu kno de wae", 4, null, null, 1, 5, 4, false, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}

	}, "resources/dewyuknodewae.png");
	static public Card UWot = new MonsterCard("u wot", 1, null, null, 3,1,1, false, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			// TODO Auto-generated method stub
			
		}
	}, "resources/wotm8.png");
	static public Card WTF = new SpellCard("WTF?!?", 3, "Deals 3 damage to a random player",2, new Action() {

		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(Math.random() > 0.5) {
				cpu.changeHealth(-3);
			}else {
				player.takeDamage(3);
			}
		}

	}, "resources/wtfs.png");
	static public Card DragonBalls = new SpellCard("Seven Dragon Balls", 10, "Summon Shenron",0, new Action() {
		@Override
		public void act(Player player, AI cpu, String turn, Card card, BattleBackend backend) {
			if(turn.equals("player")) {
				for(int i=0;i<backend.player.hand.size()-1;i++) {
					if(backend.player.hand.get(i).getName().equals("Shenron"))  {
						System.out.println("true");
						backend.playerBoard.add((MonsterCard) Shenron);
						backend.player.hand.remove((MonsterCard) Shenron);
						break;
					}
				}
				for(int x=0;x<backend.player.deck.size()-1;x++) {
					if(backend.player.deck.get(x).getName().equals("Shenron"))  {
						backend.playerBoard.add((MonsterCard) Shenron);
						backend.player.deck.remove((MonsterCard) Shenron);
						System.out.println("true");
						break;
					}
				}	
			}else {
				for(int i=0;i<backend.cpu.hand.size()-1;i++) {
					if(backend.cpu.hand.get(i).getName().equals("Shenron"))  {
						System.out.println("true");
						backend.computerBoard.add((MonsterCard) Shenron);
						backend.cpu.hand.remove((MonsterCard) Shenron);
						break;
					}
				}
				for(int x=0;x<backend.cpu.deck.size()-1;x++) {
					if(backend.cpu.deck.get(x).getName().equals("Shenron"))  {
						backend.computerBoard.add((MonsterCard) Shenron);
						backend.cpu.deck.remove((MonsterCard) Shenron);
						System.out.println("true");
						break;
					}
				}	
			}
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
		
		
		for(int i = 0; i < 20; i++) {
			int r =  (int) Math.floor(Math.random() * 12);
			if(collection.get(r) instanceof MonsterCard) {
				deck.add(createMonsterCardInstance((MonsterCard)collection.get(r)));
			}else {
				deck.add(createSpellCardInstance((SpellCard)collection.get(r)));
			}
			
		}

	}
	
	public void addCard(Card card) {
		if(deck.size() < 16 && card.getAmt() > 1) {
			deck.add(card);
			card.setAmt(card.getAmt()-1);
		}
	}
	
	public void deleteCard(int i) {
		deck.remove(i);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public static MonsterCard createMonsterCardInstance(MonsterCard c) {
		return new MonsterCard(c.getName(), c.getCost(), c.getEffect(), c.getEffectTwo(), c.getAmt(), c.getAttack(), c.getHealth(), c.getTaunt(), c.a, c.getImage());
	}
	
	public static SpellCard createSpellCardInstance(SpellCard c) {
		return new SpellCard(c.getName(), c.getCost(), c.getEffect(), c.getAmt(), c.a, c.getImage());
	}
}
