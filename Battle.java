import java.util.Scanner;
import java.util.Random;
public class Battle {
	private Pikachu mine;
	private Pikachu enemy;
	private Player p1;
	private boolean capture = false;
	private Scanner scan = new Scanner(System.in);
	private Random rand = new Random(System.nanoTime());
	public void begin(Pikachu mine, Player p1){
		this.mine = mine;
		enemy = new Pikachu();
		this.p1 = p1;
		if(mine.getSpeed() > enemy.getSpeed()){
		fight1();
		}
		else{
			fight2();
		}
	}
	public void fight1(){
		int op, opAI;
		do{
			System.out.println("Your pokemon life:"+mine.getLife()+" Level:"+mine.getLevel()+" mp1, mp2:"+mine.getMp1()+","+mine.getMp2());
			System.out.println("Enemy life:"+enemy.getLife()+" Level:"+enemy.getLevel()+" mp1, mp2:"+enemy.getMp1()+","+enemy.getMp2());
			do{
			System.out.println("1: Normal Attack, 2: Thunder Attack 3: Catch (If enemy has less than 40 hp)");
			op = scan.nextInt();
			}while(op < 1 || op > 3);
			switch(op){
			case 1:
				enemy.setLife(mine.normalAttack());
				break;
			case 2:
				enemy.setLife(mine.thunderAttack());
				break;
			case 3:
				p1.catched(enemy);
				if(p1.getCapture()){
					capture = true;
				}
				break;
			}
			if(enemy.getLife() > 0 && capture == false){
			opAI = rand.nextInt(1000);
			opAI = rand.nextInt(2);
			opAI += 1;
			switch(opAI){
			case 1:
				mine.setLife(enemy.normalAttack());
				break;
			case 2:
				mine.setLife(enemy.thunderAttack());
				break;
			}
		}
		}while(mine.getLife() > 0 && enemy.getLife() > 0 && capture == false);
	}
	public void fight2(){
		int op, opAI;
		do{
			System.out.println("Your pokemon: Life:"+mine.getLife()+" Level:"+mine.getLevel()+" mp1, mp2:"+mine.getMp1()+","+mine.getMp2());
			System.out.println("Enemy: Life:"+enemy.getLife()+" Level:"+enemy.getLevel()+" mp1, mp2:"+enemy.getMp1()+","+enemy.getMp2());
			opAI = rand.nextInt(1000);
			opAI = rand.nextInt(2);
			opAI += 1;
			switch(opAI){
			case 1:
				mine.setLife(enemy.normalAttack());
				break;
			case 2:
				mine.setLife(enemy.thunderAttack());
				break;
			}
			if(mine.getLife() > 0){
			do{
				System.out.println("1: Normal Attack, 2: Thunder Attack 3: Catch (If enemy has less than 40 hp)");
				op = scan.nextInt();
				}while(op < 1 || op > 3);
				switch(op){
				case 1:
					enemy.setLife(mine.normalAttack());
					break;
				case 2:
					enemy.setLife(mine.thunderAttack());
					break;
				case 3:
					p1.catched(enemy);
					if(p1.getCapture()){
						capture = true;
					}
					break;
				}
			}
			else{
				System.out.println("You lose kiddo! xd");
			}
		}while(mine.getLife() > 0 && enemy.getLife() > 0 && capture == false);
	}
}