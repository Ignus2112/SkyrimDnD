package skyrimdnd;
import java.util.Scanner;
public class Input 
{
	static Scanner sc = new Scanner(System.in);
	public static void damageInput()
	{
		System.out.println("What was the attack damange?");
		DamagePhase.ResultingDamage = sc.nextDouble();//getting combat damage 
		while (DamagePhase.reply!=1 && DamagePhase.reply!=2)
		{
			System.out.println("Did they Crit? ");
			DamagePhase.reply= sc.nextInt();
			switch (DamagePhase.reply)
			{
			case 1: 
				 DamagePhase.Crit=.50;//sets DamagePhase.Crit to .50 if DamagePhase.reply's value was 1 
				 break;
			case 2: 		
				break;
			default: 
				System.out.println("Bad input my Friend try again");
			}
		}
		DamagePhase.reply=0;
		while (DamagePhase.reply!=1 && DamagePhase.reply!=2)
		{
			System.out.println("was it a sneak attack");
			DamagePhase.reply=sc.nextInt();
			switch(DamagePhase.reply)
			{
			case 1: 
				sneakAttackInput();//sets Damage to equal the returned results of the Sneak Multiplier
				 break;
			case 2: 
				break;
			default: 
				 System.out.println("You had an invalide responce.");
				 break;
			}
		}
		DamagePhase.reply=0;
		while (DamagePhase.reply!=1 && DamagePhase.reply!=2)
		{
			System.out.println("Did they block?");
			DamagePhase.reply= sc.nextInt();
			switch(DamagePhase.reply)
			{
			case 1: 
				System.out.println("What's their block lvl?");
				DamagePhase.block= sc.nextDouble();
				System.out.println(Math.ceil(DamagePhase.DamageCalculate())+ " As Stamina Damage");//gets the total damange 
				break;
			case 2: 
				break;
			default: 
				 System.out.println("You had an invalide responce.");
				 break;
			}
		}
		if (DamagePhase.block==0)
		{
			System.out.println("What is the Armor Rating?");
			DamagePhase.armorFactor=sc.nextDouble();
			System.out.println(Math.ceil(DamagePhase.DamageCalculate())+ " As Health Damage");//gets the total damange 
		}
	}
	
	public static void blockInput()
	{
		System.out.println("What is the armor rating of your sheild.");
		BlockRating.BaseShieldArmorRating= sc.nextDouble();
		System.out.println("What is your block skill?");
		BlockRating.BlockSkill= sc.nextDouble();
		System.out.println("What is your Safeguard perk?");
		BlockRating.PerkLvl=sc.nextInt();
		BlockRating.BlockRatting();
		System.out.println(BlockRating.BlockDamage);
	}
	public static void sneakAttackInput()
	{
		System.out.println("Enter 1 for one handed/two handed, 2 for bow, 3 for dagger, 4 for spells ");
		int sneakMulti=sc.nextInt();
		switch(sneakMulti) 
		{//figures out the base multiply for sneak attacks 
			case 1:DamagePhase.baseSneakMulti=1.5;;
					break;
			case 2: DamagePhase.baseSneakMulti=2.0;
					break;
			case 3: DamagePhase.baseSneakMulti=2.5;
					break;
			case 4: 
				DamagePhase.baseSneakMulti=1.5;
					break;
		}
		while(DamagePhase.returnedValue!=-2)
		{
			System.out.println("is target in combat? enter 1 for yes, 0 for no.");
			DamagePhase.returnedValue=sc.nextInt();	
			if(DamagePhase.returnedValue!=1 && DamagePhase.returnedValue!=0) 
			{
				System.out.println("Bad input try again my friend");
				continue;
			}
			else if (DamagePhase.returnedValue==0)
			{
				break;
			}
			else if(DamagePhase.returnedValue==1)
			{
				DamagePhase.returnedValue=-1;
				while(DamagePhase.returnedValue!=1 && DamagePhase.returnedValue!=2)
				{
					System.out.println("what is the rank in Silent Warmonger (1 or 2)");
					DamagePhase.returnedValue=sc.nextInt();
					switch(DamagePhase.returnedValue) 
					{//sets  values to Silent Warmonger perk
					case 1:
						DamagePhase.SilentWarmonger=.20;
						break;
					case 2: 
						DamagePhase.SilentWarmonger=.40;
						break;
					default: 
						System.out.println("Bad Input try again");
					}
			
				}
			}
			if (DamagePhase.SilentWarmonger==.40 ||DamagePhase.SilentWarmonger==.25 )
			{
				DamagePhase.returnedValue=-2;
			}
		}
		System.out.println("Is the attacker an ntruder with the trustpasperk? 1 for yes 0 for no.");
		DamagePhase.returnedValue=sc.nextInt();
			while(DamagePhase.returnedValue!=1 && DamagePhase.returnedValue!=0) 
			{ 
				System.out.println("Invalde responce, want to try again? enter yes to try again");
				DamagePhase.errorHandle=sc.next();
				 if(DamagePhase.errorHandle.toLowerCase().equals("yes"))
				 {
					 System.out.println("Is the attacker an ntruder with the trustpasperk? 1 for yes");
					 DamagePhase.returnedValue=sc.nextInt();
				 }
				 else 
				 {
					 DamagePhase.returnedValue=0;
					 break;
				 }
			}
			switch(DamagePhase.returnedValue) 
			{//sets  values to Silent Warmonger perk
			case 1: 
				DamagePhase.Intruder=.15;
			}
	}	
	
	public static void doungenLvL()
	{//get the diffculty of the doungen, which decides the range of spwan rate 
		System.out.println("What is the rank of the doungen");
		while (NpcEnemySpwan.doungenRank==0)
		{
			NpcEnemySpwan.doungenRank=sc.nextInt();
			switch (NpcEnemySpwan.doungenRank) 
			{
			case 1: 
				NpcEnemySpwan.numOfEnemies=NpcEnemySpwan.rangeX.nextInt(11+1-1)+1;
				break;
			case 2: 
				NpcEnemySpwan.numOfEnemies=NpcEnemySpwan.rangeX.nextInt(20-10+1)+10;
				 break;
			case 3: 
				NpcEnemySpwan.numOfEnemies=NpcEnemySpwan.rangeX.nextInt(30-20+1)+20;
				break;
			case 4: 
				NpcEnemySpwan.numOfEnemies=NpcEnemySpwan.rangeX.nextInt(40-30+1)+30;
				break;
			case 5: 
				NpcEnemySpwan.numOfEnemies=NpcEnemySpwan.rangeX.nextInt(50-40+1)+40;
				break;
			default: 
				System.out.println("Bad input, try again");
				 break;
			}
		}
	}
	public static void enemyMaxLvl()
	{
		System.out.println("What is the rank of the enemies for this location?");
		while (NpcEnemySpwan.enemyRank==0)
		{
			NpcEnemySpwan.enemyRank=sc.nextInt();
			switch (NpcEnemySpwan.enemyRank) 
			{
				case 1: 
					NpcEnemySpwan.maxEnemyLvL=15;
					NpcEnemySpwan.minLVL=1;
					NpcEnemySpwan.enemyArmorRatingMax=150;
					 break;
				case 2: 
					NpcEnemySpwan.maxEnemyLvL=30;
					NpcEnemySpwan.minLVL=15;
					NpcEnemySpwan.enemyArmorRatingMax=300;
					 break;
				case 3: 
					NpcEnemySpwan.maxEnemyLvL=45;
					NpcEnemySpwan.minLVL=30;
					NpcEnemySpwan.enemyArmorRatingMax=400;
					break;
				case 4: 
					NpcEnemySpwan.maxEnemyLvL=60;
					NpcEnemySpwan.minLVL=45;
					NpcEnemySpwan.enemyArmorRatingMax=500;
					break;
				case 5: 
					NpcEnemySpwan.maxEnemyLvL=75;
					NpcEnemySpwan.minLVL=60;
					NpcEnemySpwan.enemyArmorRatingMax=600;
					break;
				default: 
					System.out.println("Bad input, try again");
					 break;
			}
		}
	}
}