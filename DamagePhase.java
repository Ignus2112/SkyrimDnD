package skyrimdnd;

import java.util.Scanner;

public class DamagePhase 
{
	static Scanner sc = new Scanner(System.in);
	// Damage input Method needed
	static double Crit;
	static double block;
	static double ResultingDamage;
	static int reply;
	static String errorHandle;
	//Damage Calculate
	static double armorFactor;
	static double blockedDamage;
	static double HiddenArmor = 100.0;
	static //SneakMultiplyer required 
	double baseSneakMulti =0;
	static double SilentWarmonger=0;
	static double Intruder=1.0;
	static int returnedValue;
	public static void damageInput()
	{
		System.out.println("What was the attack damange?");
		ResultingDamage = sc.nextDouble();//getting combat damage 
		System.out.println("Did they Crit? ");
		reply= sc.nextInt();
		if (reply==1) 
		{//checks reply for valid input of 1
			 Crit=.50;//sets crit to .50 if reply's value was 1 
			 reply=-1;
		 }
		while (reply!=1 || reply!=0)
		{
			 System.out.println("was it a sneak attack");
			 reply=sc.nextInt();
			 if(reply==0)
			 {
				 break;
			 }
			 else if (reply==1)
			 {
				 SneakMultiplyer();//sets Damage to equal the returned results of the Sneak Multiplier
				 break;
			 }
			 else if (reply!=1)
			 {
				 System.out.println("You had an invalide responce, did you want to try again? enter Yes");
				 String errorHandle=sc.next(); 
				 if(errorHandle.toLowerCase().equals("yes"))
				 {
					 reply=0;
				 }
				 else
				 {
					 reply=0;
					 break;
				 } 	 
			 }
		}
		System.out.println("What is the Armor Rating?");
		armorFactor=sc.nextDouble();
		  if (reply==0) 
		  {
			  System.out.println("Did they block?");
				 reply= sc.nextInt();
				 if (reply==1) 
				 {
						System.out.println("What's their block lvl?");
						block= sc.nextDouble();
				 }
		  }
		 System.out.println(Math.ceil(DamageCalculate()));//gets the 
	
	}
	private static double DamageCalculate()
	{
		if (armorFactor>567) 
		{
			armorFactor=567;
		}
		if(Crit==.50) {
			ResultingDamage=ResultingDamage+(ResultingDamage*Crit);
		}
		System.out.println(ResultingDamage + " Passed in damage after crit");
		if (armorFactor==0) 
		{
			 HiddenArmor=0;
		 }
		if (block>0) 
		{
			blockedDamage=(ResultingDamage*(block/100));
			System.out.println(blockedDamage+ "blocked Damage");
			armorFactor = 0.12 * (HiddenArmor+armorFactor)/100.0; 
		    ResultingDamage=ResultingDamage*(1-armorFactor);
			System.out.println(ResultingDamage+ "Resulting Damage");

			return ResultingDamage-blockedDamage;
		}
		else 
		{
		armorFactor = 0.12 * (HiddenArmor+armorFactor)/100.0; 
	    ResultingDamage=ResultingDamage*(1-armorFactor);
		return ResultingDamage;
		}
	}
	private static void SneakMultiplyer() 
	{
		System.out.println("Enter 1 for one handed/two handed, 2 for bow, 3 for dagger, 4 for spells ");
		returnedValue=sc.nextInt();
		switch(returnedValue) 
		{//figures out the base multiply for sneak attacks 
			case 1: baseSneakMulti=1.5;
					returnedValue=-1;
					break;
			case 2: baseSneakMulti=2.0;
					returnedValue=-1;
					break;
			case 3: baseSneakMulti=2.5;
					returnedValue=-1;
					break;
			case 4: 
					baseSneakMulti=1.5;
					returnedValue=-1;
					break;
		}
		ResultingDamage=ResultingDamage*baseSneakMulti;
		while(returnedValue!=-2)
		{
			System.out.println("is target in combat? enter 1 for yes, 0 for no.");
			returnedValue=sc.nextInt();	
			if(returnedValue!=1 && returnedValue!=0) 
			{
				System.out.println("Bad input try again my friend");
				continue;
			}
			else if (returnedValue==0)
			{
				break;
			}
			else if(returnedValue==1)
			{
				returnedValue=-1;
				while(returnedValue!=1 && returnedValue!=2)
				{
					System.out.println("what is the rank in Silent Warmonger (1 or 2)");
					returnedValue=sc.nextInt();
					switch(returnedValue) 
					{//sets  values to Silent Warmonger perk
						case 1: 
							SilentWarmonger=.25;
							ResultingDamage=ResultingDamage+(ResultingDamage*SilentWarmonger);
							break;
						case 2: 
							SilentWarmonger=.40;
							ResultingDamage=ResultingDamage+(ResultingDamage*SilentWarmonger);
							break;
						default: 
							System.out.println("Bad input try again my friend");
							continue;
					}
			
				}
			}
			if (SilentWarmonger==.40 ||SilentWarmonger==.25 )
			{
				returnedValue=-2;
			}
		}
		System.out.println("Is the attacker an ntruder with the trustpasperk? 1 for yes 0 for no.");
		returnedValue=sc.nextInt();
			while(returnedValue!=1 && returnedValue!=0) 
			{ 
				System.out.println("Invalde responce, want to try again? enter yes to try again");
				 errorHandle=sc.next();
				 if(errorHandle.toLowerCase().equals("yes"))
				 {
					 System.out.println("Is the attacker an ntruder with the trustpasperk? 1 for yes");
						returnedValue=sc.nextInt();
				 }
				 else 
				 {
					 returnedValue=0;
					 break;
				 }
			}
			switch(returnedValue) {//sets  values to Silent Warmonger perk
			case 1: 
				Intruder=.15;
				ResultingDamage=ResultingDamage+(ResultingDamage*Intruder);
				break;
				}
				System.out.print(ResultingDamage);
		}
	}