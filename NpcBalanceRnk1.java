package skyrimdnd;
public class NpcBalanceRnk1 
{
	public static void npcBalanceRnk1()//rank 1 enemy balance 
	{
		if (NpcEnemySpwan.enemyRank==1)//checks the rank to make sure that its correct 
		{
			
			if (NpcEnemySpwan.enemyTitle.contains("Bandit Cheif")==true && NpcEnemySpwan.bossCounter<1)
			{//bandit cheif edge case 
				NpcEnemySpwan.bossCounter=1;//changes the counter 
				NpcEnemySpwan.enemyHealth+=Math.ceil(NpcEnemySpwan.enemyMagicka/2)+35;
				NpcEnemySpwan.enemyStamina+=Math.ceil(NpcEnemySpwan.enemyMagicka/2)+45;
				NpcEnemySpwan.enemyMagicka=100;
				NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(75+1-25)+25;//increases the armor rating, even past the max amount 
				NpcEnemySpwan.enemyLevel=15;
			}
			else if (NpcEnemySpwan.enemyType.contains("Combat"))
			{//checks for type combat of this instance of enemy 
				if (NpcEnemySpwan.bossCounter==1)
				{//checks if there is already a bandit cheif, if there is, changes this enemy type to Bandit 
					NpcEnemySpwan.enemyTitle="Bandit";
				}
					NpcEnemySpwan.enemyHealth=100+((NpcEnemySpwan.enemyLevel)*10);
					NpcEnemySpwan.enemyStamina=100;
					NpcEnemySpwan.enemyMagicka=100;
					if (NpcEnemySpwan.enemyHealth>200 && NpcEnemySpwan.rangeX.nextInt(11)<7)
					{//creats a 70% chance that the enemy will switch after 200 hp to a stamina build *stamina shouldn't pass 150
						NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyHealth-200);
						NpcEnemySpwan.enemyHealth=200;//locks enemy H at 200 
					}
				NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(50+1-25)+25; //Creates a boost to all combat types in armor rating, cannot pass 150
				if(NpcEnemySpwan.EnemyArmorRating>150.0)
				{//makes sure to set any armor rating to 150 if it pass that value 
					NpcEnemySpwan.EnemyArmorRating=150.0;
				}	
			}
			else if (NpcEnemySpwan.enemyType.contains("Magick"))
			{//checks for type Magick enemies 
				NpcEnemySpwan.enemyHealth=100;//sets health to base state 
				NpcEnemySpwan.enemyStamina=100;//sets stamina to base state 
				NpcEnemySpwan.enemyMagicka=100+(NpcEnemySpwan.enemyLevel*10);
				NpcEnemySpwan.EnemyArmorRating=0;//mage/witch types have no intial armor rating 
				if (NpcEnemySpwan.enemyTitle.toLowerCase().contains("unbound")==true)
				{
					NpcEnemySpwan.enemyRace="Daedric";
				}
				if (NpcEnemySpwan.enemyRace=="Daedric")
				{
					NpcEnemySpwan.EnemyArmorRating=40;
					NpcEnemySpwan.enemyMagicka=100;
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel*10);
					if (NpcEnemySpwan.enemyHealth>200)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-200);
						NpcEnemySpwan.enemyHealth=200;
					}
					
				}
				if (NpcEnemySpwan.enemyMagicka>220.0 && NpcEnemySpwan.rangeX.nextInt(11)>3)
				{//checks upper limit for mana pool and at a 70% rate 
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-220);
					NpcEnemySpwan.enemyMagicka=220;
					if (NpcEnemySpwan.enemyHealth>130 && NpcEnemySpwan.rangeX.nextInt(11)<3)
					{//creates a 30% chance for stamina conversion to mana reducing stamina to 0, the more mana the higher spell 
						NpcEnemySpwan.enemyMagicka+=NpcEnemySpwan.enemyStamina;
						NpcEnemySpwan.enemyStamina=0;
					}
				}
			}
			else if (NpcEnemySpwan.enemyType.contains("Stealth"))
			{//checks for type stealth enemies 
				NpcEnemySpwan.enemyStamina=100+((NpcEnemySpwan.enemyLevel)*10);
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyMagicka=100;
				if (NpcEnemySpwan.enemyStamina>180 && NpcEnemySpwan.rangeX.nextInt(10)<4)
				{
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyStamina-180);
					NpcEnemySpwan.enemyStamina=180;
				}
				else if (NpcEnemySpwan.enemyStamina>200 && NpcEnemySpwan.rangeX.nextInt(11)>8)
				{//20% chance of active for adding manan to pool, allowing for some spell uses, moves 50 sp->hp 
					NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyStamina-200);
					NpcEnemySpwan.enemyStamina=150;
					NpcEnemySpwan.enemyHealth+=50; 
				}
				else if (NpcEnemySpwan.enemyStamina>150)
				{//adds to health pool
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-150);
					NpcEnemySpwan.enemyStamina=150;
				}
			}
		}
		else 
		{
			System.out.println("Rank does not match required value for balance " );
		}
		
	}
}