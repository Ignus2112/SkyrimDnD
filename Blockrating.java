package skyrimdnd;
import java.util.Scanner;
public class Blockrating 
{
	static Scanner sc = new Scanner(System.in);
	static double Safeguard;
	static double BlockDamage;
	static double BlockSkill;
	public static void BlockRatting() 
	{// gets characters block rating 
		System.out.println("What is the armor rating of your sheild.");
		double BaseShieldArmorRating= sc.nextDouble();
		System.out.println("What is your block skill?");
		BlockSkill= sc.nextDouble();
		System.out.println("What is your Safeguard perk?");
		int PerkLvl= sc.nextInt();//gets perk level 
		if (PerkLvl==1) {//checks asks for perk level 
			Safeguard=.15;
		}else if (PerkLvl==2) {
			Safeguard=.30;
		}
		BlockDamage=(45+0.2*BaseShieldArmorRating*(1.0+(BlockSkill/100.0)))*(1+Safeguard);//calculates max % shield blocking
		System.out.println(BlockDamage);
	}
}