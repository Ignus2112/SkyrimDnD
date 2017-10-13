package skyrimdnd;
import java.util.Scanner;
public class Blockrating 
{
	static Scanner sc = new Scanner(System.in);
	static double Safeguard;
	static double BlockDamage;
	static double BlockSkill;
	static double BaseShieldArmorRating;
	static int PerkLvl;
	public static void BlockRatting() 
	{// gets characters block rating 
		if (PerkLvl==1) {//checks asks for perk level 
			Safeguard=.15;
		}else if (PerkLvl==2) {
			Safeguard=.30;
		}
		BlockDamage=(45+0.2*BaseShieldArmorRating*(1.0+(BlockSkill/100.0)))*(1+Safeguard);//calculates max % shield blocking
	}
}