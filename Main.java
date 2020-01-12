import java.util.Scanner;
/*
	@author: Alfredo Flores
	@email: alfredojose20001@outlook.es
	@twitter: ajfvdev

	RPG Batlle simulator of pokemon, made for me when i was learning JAVA
*/
public class Main{
	public static void main(String[] arg){
		Scanner scan = new Scanner(System.in);
		Player p1 = new	Player();
		Battle myBattle = new Battle();
		int op, c, round=0;
		Pikachu target;
		System.out.print("Welcome, enter your name sir?: ");
		p1.setName(scan.nextLine());
		do{
			do{
				System.out.println(p1.getName()+", Choose your path");
				System.out.println("1: Start battle");
				System.out.println("2: Exit");
				op = scan.nextInt();
			}while(op < 1 || op > 2);
			switch(op) {
			case 1:
			do{
				do{
				p1.showBag();
				c = scan.nextInt();
				}while(c >= p1.getSize());
				target = p1.select(c);
			}while(target.getLife() < 1);
			    p1.setCapture(false);
				myBattle.begin(p1.select(c), p1);
				break;
			default:
				break;
			}
			p1.check();
			round++;
			if (p1.getAlive() == false){
				op = 2;
				System.out.println("Lose. check round's survive: "+round);
			}
		}while(op != 2);
		scan.close();
	}
}