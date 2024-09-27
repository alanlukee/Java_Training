package Simple_Video_Game;

public class Player extends Character {

	Player(String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		if(this.getHealth()>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public void attack(Character target) {
		
		// TODO Auto-generated method stub
		System.out.println(this.getName()+" attacked "+target.getName());
		target.defend(this.getAttack());
		//target.attack(this);

		
	}

	@Override
	public void defend(int damage) {
		// TODO Auto-generated method stub
		int damageReceived = damage - this.getDefense();
		if(damageReceived>0) {
			this.setHealth(this.getHealth()-damageReceived);
			if(this.getHealth()>0) {
				System.out.println("You took "+damageReceived+" damage.Your health now is: "+this.getHealth());

			}
			else if(this.getHealth()<=0) {
				System.out.println(getName()+" has been defeated.");
			}
		}
		else {
			System.out.println("Attack blocked by "+this.getName()+". No damage.");
		}
		
		
	}
	
	public void equipitem() {
		System.out.println("Item equiped");
	}
	
	public void unequipItem() {
		System.out.println("Item unequiped");
	}
	public void useItem() {
		System.out.println("Item used. Health restored.");
	}
	
	

}
