package skyrimdnd;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SkyrimDnD 
{
	public static void main(String[] args) throws FileNotFoundException 
	{	
		@SuppressWarnings("resource")//removes warning for sc 
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you need? 1 for Damage Calculation, 2 for getting block rating or 3 for enemy npcs spwan");
		int Responce= sc.nextInt();
		switch (Responce) 
		{
		case 1: 
			Input.damageInput();
			 break;
		case 2: 
			Input.blockInput();
			 break;
		case 3: 
			Input.doungenLvL();
			Input.enemyMaxLvl();
			NpcEnemySpwan.enemySpwan();
			break;
		default: 
			System.out.println("Bad input, try again");
			 break;
		}
	}
}