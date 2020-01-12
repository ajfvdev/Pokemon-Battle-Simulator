import java.util.Vector;
public class Player{
	private String name;
	private Vector<Pikachu> bag = new Vector<Pikachu>(1,1); // temporal, maybe will be an vector.
	private boolean alive = true, capture;
	private int size=1;
	public Player(){
		bag.add(new Pikachu()); // first pokemon. :)
	}
	public void showBag(){
		for(int i=0; i < size; i++){
		System.out.println("["+i+"] "+"Name:"+bag.elementAt(i).getName()+" Life:"+bag.elementAt(i).getLife()+" Level:"+bag.elementAt(i).getLevel()+" mp1, mp2:"+bag.elementAt(i).getMp1()+","+bag.elementAt(i).getMp2());
		}
	}
	public Pikachu select(int i){
		return bag.elementAt(i);
	}
	public void check(){
		int x = 0;
		for(int i=0; i < size; i++){
			if(bag.elementAt(i).getLife() > 0){
				x++;
			}
		}
		if (x == 0){
			alive = false;
		}
	}
	public void catched(Pikachu enemy){
		if(enemy.getLife() <= 40){
			if (size == 3){
				System.out.println("Bag full.");
			}
			else{
			System.out.println("Captured!");
			bag.add(new Pikachu(enemy));
			size++;
			capture = true;
			}
		}
		else{
			System.out.println("The pokemon has escape!");
		}
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public boolean getAlive(){
		return alive;
	}
	public int getSize(){
		return size;
	}
	public boolean getCapture(){
		return capture;
	}
	public void setCapture(boolean bool){
		capture = bool;
	}
}