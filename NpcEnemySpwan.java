package skyrimdnd;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class NpcEnemySpwan
{
	//passed atrubites 
	static Random rangeX = new Random();
	static double enemyLevel; 
	static double enemyHealth;
	static double enemyMagicka;
	static double enemyStamina;
	static double EnemyArmorRating;
	static int maxEnemyLvL;
	static int minLVL=1;
	static int enemyArmorRatingMax;
	static int enemyRank=0; 
	static int bossCounter=0;
	public static int numOfEnemies=0; 
	static String enemyTitle; 
	static String enemyType; 
	static String enemyRace;
	//local attubits only 
	static int doungenRank=0;
	// list of races for npc 
	private static String[] Race= {"High Elf", "Dark Elf", "Wood Elf", "Orc", "Argoninan", "Khajiit", "Breton", "Nord ", "Imperial", "Redguard"};
	//list of npcs titles 
	private static String[] enemylist1= {"Hunter","Petty Thief","Bandit","Bandit Cheif","Bandit Ranger","Novice Witch","Novice Mage", 
			"Novice Fire Mage", "Novice Storm Mage", "Novice Ice Mage" , "Novice Summoner Mage", "Novice Neco Mage", "Novice Illisuon Mage"," Unbound Familer"};
	
	private static String[] enemylist2= {"Battle Healer","WitchHunter", "Sell Sword","Spell Sword", "Thief","Omega WearBeast", "Vampire", "Apprentince Ice Mage", "Apprentince Fire Mage", 
			"Apprentince Storm Mage", "Apprentince Summoner Mage", "Apprentince Neco Mage", "Apprentince Illison Mage", " Apprentince Witch", " Unbound Flame Atronach "};
	
	private static String[] enemylist3= {"NightBlade", "Assassin","Vigil Of Stendar","NightStaker Vampire","Beta WearBeast","Master WitchHunter","Adept Witch","Adept Mage", 
			"Adept Fire Mage", "Adept Storm Mage", "Adept Ice Mage" , "Adept Summoner Mage", "Adept Neco Mage", "Adept Illisuon Mage", };
	
	private static String[] enemylist4= {"Battle Summoner","Battle Mage","Master Vampire","Dark Brotherhood Assassin","Nightin Gale "," Hag Raven"," Expert Mage", "Expert Fire Mage", 
			"Expert Storm Mage", "Expert Ice Mage" , "Expert Summoner Mage", "Expert Neco Mage", "Expert Illisuon Mage", };
	
	private static String[] enemylist5= {"Vampire Lord","Alpha WearBeast"," Bandit Ranger","Damora Lord"," Arch Mage", "Arch Fire Mage", 
			"Arch Storm Mage", "Arch Ice Mage" , "Arch Summoner Mage", "Arch Neco Mage", "Arch Illisuon Mage", };
	
	public static void enemySpwan() throws FileNotFoundException
	{
		PrintWriter spwan = new PrintWriter("EnemyThatSpwan.txt");
				for (int i=0; i<numOfEnemies;i++)
				{
					System.out.println("Enemy Rank:"+ enemyRank);
					switch (enemyRank) 
					{
					case 1: 
						enemyTitle=enemylist1[rangeX.nextInt(enemylist1.length)];
						enemyLevel=rangeX.nextInt(maxEnemyLvL-minLVL+1)+minLVL;
						enemyRace=Race[rangeX.nextInt(Race.length+1-1)];
						enemyTypeSort();
						enemyHealth=100+(enemyLevel*10);
						enemyMagicka=100+(enemyLevel*10);
						enemyStamina=100+(enemyLevel*10);
						EnemyArmorRating=rangeX.nextInt(enemyArmorRatingMax);
						npcBalance.npcBalanceRnk1();
						break;
					case 2:
						enemyTitle=enemylist2[rangeX.nextInt(enemylist2.length)];
						enemyLevel=rangeX.nextInt((maxEnemyLvL-minLVL)+1)+minLVL;
						enemyRace=Race[rangeX.nextInt(Race.length+1-1)];
						enemyTypeSort();
						enemyHealth=100+(enemyLevel*10);
						enemyMagicka=100+(enemyLevel*10);
						enemyStamina=100+(enemyLevel*10);
						EnemyArmorRating=rangeX.nextInt((enemyArmorRatingMax-100)+1)+100;
						npcBalance.npcBalanceRnk2();
						break;
					case 3:
						enemyTitle=enemylist3[rangeX.nextInt(enemylist3.length)];
						enemyLevel=rangeX.nextInt((maxEnemyLvL-minLVL)+1)+minLVL;
						enemyRace=Race[rangeX.nextInt(Race.length+1-1)];
						enemyTypeSort();
						enemyHealth=100+(enemyLevel*10);
						enemyMagicka=100+(enemyLevel*10);
						enemyStamina=100+(enemyLevel*10);
						EnemyArmorRating=rangeX.nextInt((enemyArmorRatingMax-100)+1)+100;
						npcBalance.npcBalanceRnk3();
						break;
					case 4:
						enemyTitle=enemylist4[rangeX.nextInt(enemylist4.length)];
						enemyLevel=rangeX.nextInt((maxEnemyLvL-minLVL)+1)+minLVL;
						enemyRace=Race[rangeX.nextInt(Race.length+1-1)];
						enemyTypeSort();
						enemyHealth=100+(enemyLevel*10);
						enemyMagicka=100+(enemyLevel*10);
						enemyStamina=100+(enemyLevel*10);
						EnemyArmorRating=rangeX.nextInt((enemyArmorRatingMax-100)+1)+100;
						npcBalance.npcBalanceRnk2();
						break;
					case 5:
						enemyTitle=enemylist5[rangeX.nextInt(enemylist5.length)];
						enemyLevel=rangeX.nextInt((maxEnemyLvL-minLVL)+1)+minLVL;
						enemyRace=Race[rangeX.nextInt(Race.length+1-1)];
						enemyTypeSort();
						enemyHealth=100+(enemyLevel*10);
						enemyMagicka=100+(enemyLevel*10);
						enemyStamina=100+(enemyLevel*10);
						EnemyArmorRating=rangeX.nextInt((enemyArmorRatingMax-100)+1)+100;
						npcBalance.npcBalanceRnk2();
						break;
					}
					if (enemyTitle.toLowerCase().contains("unbound".toLowerCase().toLowerCase())==true)
					{
						enemyRace="Daedric";
					}
					try(PrintWriter out = new PrintWriter("EnemyThatSpwan.txt"))
					{
						spwan.println("Level:" + enemyLevel+" Title:" + enemyTitle+", " +"Race:"+ enemyRace+", "+ 
					"Type:" + enemyType+" Health:"+enemyHealth+" Mana:"+enemyMagicka+" "
							+ "Stamina:"+enemyStamina+" Armor Rating:"+EnemyArmorRating);
						System.out.println();
					}
				}
		spwan.close();	
	}
	//"Assassin","Vigil Of Stendar","NightStaker Vampire","Beta WearBeast","Master WitchHunter"," Adept Witch"," Adept Mage", 
	//"Adept Fire Mage", " Adept Storm Mage", " Adept Ice Mage" , "Adept Summoner Mage", "Adept Neco Mage", "Adept Illisuon Mage",
	public static void enemyTypeSort()
	{
		 if (enemyTitle.toLowerCase().contains("vampire".toLowerCase())==true || enemyTitle.toLowerCase().contains("Nightin Gale".toLowerCase())==true || 
				enemyTitle.toLowerCase().contains("WitchHunter".toLowerCase())==true || enemyTitle.toLowerCase().contains("NightBlade".toLowerCase())==true)
		{
			enemyType="Stealth/Magick";
		}
		else if (enemyTitle.toLowerCase().contains("Spell sword".toLowerCase())==true || enemyTitle.toLowerCase().contains("Vigil".toLowerCase())==true
				|| enemyTitle.toLowerCase().contains("Battle".toLowerCase())==true)
		{
			enemyType="Combat/Magick";
		}
		else if (enemyTitle.toLowerCase().contains("Assassine".toLowerCase())==true)
		{
			enemyType="Combat/Stealth";
		}
		else if ((enemyTitle.contains("Bandit")==true && !enemyTitle.contains("Bandit Ranger"))|| enemyTitle.toLowerCase().contains("Bounty Hunter".toLowerCase())==true ||
			enemyTitle.toLowerCase().contains("WearBeast".toLowerCase())==true || enemyTitle.toLowerCase().contains("sell sword".toLowerCase())==true)
		{
			enemyType="Combat";
		}
		else if (enemyTitle.toLowerCase().contains("Mage".toLowerCase())==true || enemyTitle.toLowerCase().contains("Unbound".toLowerCase())==true ||
				(enemyTitle.toLowerCase().contains("Witch".toLowerCase())==true && !enemyTitle.toLowerCase().contains("WitchHunter".toLowerCase())))
		{
			enemyType="Magick";
		}
		else if (enemyTitle.toLowerCase().contains("Hunter".toLowerCase())==true || enemyTitle.toLowerCase().contains("Bandit Ranger".toLowerCase())==true || 
				enemyTitle.toLowerCase().contains("Thief".toLowerCase())==true || enemyTitle.toLowerCase().contains("Assassin".toLowerCase())==true)
		{
			enemyType="Stealth";
		}
	}	
}