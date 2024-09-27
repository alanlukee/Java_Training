package Simple_Video_Game;

//oMethods: attack(), defend(), getHealth(), isAlive()

public abstract class Character {
	
	private String name;
	private int health;
	private int attack;
	private int defense;
	
	Character(String name, int health, int attack, int defense){
		
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public abstract void attack(Character target);
	public abstract void defend(int f);
	public abstract boolean isAlive();
	
	
	
	

}
