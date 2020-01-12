import java.util.Random;
public class Pikachu{
	private static String name="Pikachu";
	private int life, mp1, mp2, speed, level;
	public Pikachu(){ 
		Random myrandom = new Random(System.nanoTime());
		int rand = myrandom.nextInt(3); // level max 4. xd
		rand = myrandom.nextInt(3);
		rand += 1; // 0 + 1;
		level = rand;
		life = 50*level;
		mp1 = 20;
		mp2 = 10;
		speed = 1*level; // pokemon 1 speed > pokemon 2 speed = pokemon 1 attack first
	}
	public Pikachu(Pikachu copy){ 
	  level = copy.level;
	  life = 50*level;
	  mp1 = 20;
	  mp2 = 10;
	  speed = 1*level; 	 
	} 
	public int getLife(){
		return life;
	}
	public void setLife(int dmg){ 
		life -= dmg;
	}
	public int getMp1(){
		return mp1;
	}
	public int getMp2(){
		return mp2;
	}
	public int getSpeed(){
		return speed;
	}
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public int normalAttack(){
		if(mp1 > 0){
			mp1 -= 1; // so many mistakes, i'm sorry : (
			return 10;
		}
		else {
			return 0;
		}
	}
	public int thunderAttack(){
		if(mp2 > 0){
			mp2 -= 1;
			return 20;
		}
		else {
			return 0;
		}
	}
}