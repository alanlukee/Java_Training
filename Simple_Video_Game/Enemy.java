package Simple_Video_Game;

public class Enemy extends Character{
	private int experienceReward;

	Enemy(String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
		
		this.experienceReward = experienceReward;
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isAlive() {
		
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
		
		System.out.println(this.getName()+" attacked back "+target.getName());
		target.defend(this.getAttack());
		
		//target.attack(this);
	}

	@Override
	
	public void defend(int damage) {  //when lukz attacks enemy
		// TODO Auto-generated method stub
		
		int damageReceived = damage - this.getDefense();
		if(damageReceived>0) {
			this.setHealth(this.getHealth()-damageReceived);
			if(this.getHealth()<=0) {
				System.out.println(this.getName()+" has been defeated.");
				
			}
			else if(this.getHealth()>0) {
				System.out.println(this.getName()+" took "+damageReceived+" damage."+this.getName()+" health: "+this.getHealth());

			}
		}
		
		else {
			System.out.println("Attack blocked by enemy. No damage.");
		}
		
		
	}
	
	

}
