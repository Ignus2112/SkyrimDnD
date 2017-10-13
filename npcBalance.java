package skyrimdnd;
public class npcBalance {
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
				if (NpcEnemySpwan.enemyRace!="Daedric")
				{//checks for enemy race to make sure it isnt Dadric 
					NpcEnemySpwan.EnemyArmorRating=0;//mage/witch types have no intial armor rating 
				}
				else 
				{//sets a Dadric types armor rating to 40 (unbound familiar) 
					NpcEnemySpwan.EnemyArmorRating=40; 
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
	public static void npcBalanceRnk2()
	{// rank two npc blanace 
		if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat/Magick".toLowerCase()))
		{//checks for combo type combat/magick 
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{//70% chance for start as well as the level being an even one 
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
				if (NpcEnemySpwan.enemyMagicka>250)
				{//checks upper level of mana pool
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-250);//takes the over flow from the mana pool and adds it to the hp pool 
					NpcEnemySpwan.enemyMagicka=250; // sets mana to 250 
					if (NpcEnemySpwan.enemyHealth>200)
					{//adds from mana pool to health pool to stamina pool 
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-200);
						NpcEnemySpwan.enemyHealth=200;
					}
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyHealth=100+((NpcEnemySpwan.enemyLevel)*10);
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100;
					if (NpcEnemySpwan.enemyHealth>300)
					{
						NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyHealth-300);
						NpcEnemySpwan.enemyHealth=300;
					}
			}
			else if (NpcEnemySpwan.enemyLevel%2==1 && NpcEnemySpwan.enemyLevel>25)
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyLevel*10);
				NpcEnemySpwan.enemyMagicka=100;
				if (NpcEnemySpwan.enemyStamina>=150)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-150);
					NpcEnemySpwan.enemyStamina=150;
					if (NpcEnemySpwan.enemyHealth>300)
					{
						NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyHealth-300);
						NpcEnemySpwan.enemyHealth=300;
					}
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyLevel*10);
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100;
				if (NpcEnemySpwan.enemyHealth>150){
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-150);
						NpcEnemySpwan.enemyHealth=150;
						if (NpcEnemySpwan.enemyStamina>150)
						{
							NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyStamina-150);
							NpcEnemySpwan.enemyStamina=150;
							if (NpcEnemySpwan.enemyStamina>150)
							{
								NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-150);
								NpcEnemySpwan.enemyStamina=150;
							}
						}
					}
				}
			}
			
				
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat/Stealth".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100; 
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{//70 chance rate and only if level is an even number 
				NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel)*10;
				if (NpcEnemySpwan.enemyStamina>300)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-300);
					NpcEnemySpwan.enemyStamina=300;
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/2)*10;
				if((NpcEnemySpwan.enemyLevel/2)%2==1)
				{//checks if the level at halve its value is an odd number 
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
					if(NpcEnemySpwan.enemyStamina>200)
					{//over flow check 
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-200);
						NpcEnemySpwan.enemyStamina=200;
					}
				}
				else 
				{
					NpcEnemySpwan.enemyHealth+=((NpcEnemySpwan.enemyLevel/2)+(NpcEnemySpwan.enemyLevel/4))*10;;
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/4)*10;
				}
			}else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyHealth==300)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-300);
					NpcEnemySpwan.enemyHealth=300; 
					
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Stealth/Magick".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100; 
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{
				NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				if((NpcEnemySpwan.enemyLevel/2)%2==1)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
					if(NpcEnemySpwan.enemyStamina>200)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-200);
						NpcEnemySpwan.enemyStamina=200;
					}
				}
				else 
				{
					NpcEnemySpwan.enemyMagicka=100+(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyLevel/4)*10;
				}
			}else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyMagicka==290)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyMagicka-290);
					NpcEnemySpwan.enemyMagicka=290; 
					
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Stealth".toLowerCase()))
		{
			NpcEnemySpwan.enemyStamina=100+((NpcEnemySpwan.enemyLevel)*10);
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyMagicka=100;
			if (NpcEnemySpwan.enemyStamina>180 && NpcEnemySpwan.rangeX.nextInt(10)<4)
			{
				NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyStamina-180);
				NpcEnemySpwan.enemyStamina=180;
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Magick".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
			if (NpcEnemySpwan.enemyRace!="Daedric")
			{
				NpcEnemySpwan.EnemyArmorRating=0;
			}
			else 
			{
				NpcEnemySpwan.EnemyArmorRating=75; 
			}
			if(NpcEnemySpwan.enemyMagicka>320 && NpcEnemySpwan.rangeX.nextInt(11)>4)
			{ 
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-320);
				NpcEnemySpwan.enemyMagicka=320;
			}
			else if (NpcEnemySpwan.enemyMagicka>380 &&NpcEnemySpwan.rangeX.nextInt(11)<3)
			{
				NpcEnemySpwan.enemyMagicka+=NpcEnemySpwan.enemyStamina;
				NpcEnemySpwan.enemyStamina=0;
			}
			
			
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat".toLowerCase()))
		{
			if( NpcEnemySpwan.enemyHealth==NpcEnemySpwan.enemyStamina)
			{
				NpcEnemySpwan.enemyHealth=100+((NpcEnemySpwan.enemyLevel)*10);
				NpcEnemySpwan.enemyStamina=100;
				if (NpcEnemySpwan.enemyHealth>200 && NpcEnemySpwan.rangeX.nextInt(11)<7)
				{
					NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyHealth-200);
					NpcEnemySpwan.enemyHealth=200;
				}
			}
			NpcEnemySpwan.enemyMagicka=100;
			NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(50+1-25)+25; 
			if(NpcEnemySpwan.EnemyArmorRating>150.0)
			{
				NpcEnemySpwan.EnemyArmorRating=150.0;
			}	
		}
	}
	public static void npcBalanceRnk3()
	{
		if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat/Magick".toLowerCase()))
		{
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)//creats a 70% chances for this out come 
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);//starts adding porints to the mana pool
				if (NpcEnemySpwan.enemyMagicka>300)//checks the amount of mana 
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-300);//when there is an overflow, add the over flow to the health pool
					if (NpcEnemySpwan.enemyHealth>300)//repeat overflow prosses 
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-300);
						NpcEnemySpwan.enemyHealth=300;//sets value to the needed state 
					}
					NpcEnemySpwan.enemyMagicka=300;//sets to 300 
				}
				if (NpcEnemySpwan.enemyMagicka>200 && NpcEnemySpwan.enemyMagicka<300)//Creates a range 
				{
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyMagicka-200);
					if (NpcEnemySpwan.enemyHealth>230 && NpcEnemySpwan.enemyMagicka!=200)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-230);
					}
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)//none % range 
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
					if (NpcEnemySpwan.enemyMagicka>400)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-400);
						NpcEnemySpwan.enemyMagicka=400;
					}
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+(NpcEnemySpwan.enemyLevel*10);
				if (NpcEnemySpwan.enemyMagicka>=250)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-250);
					NpcEnemySpwan.enemyMagicka=250;
					if (NpcEnemySpwan.enemyHealth>400)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-400);
						NpcEnemySpwan.enemyHealth=400;
					}
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat/Stealth".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100; 
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)//glass cannon build 
			{
				NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel)*10;
				if (NpcEnemySpwan.enemyStamina>400)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-400);
					NpcEnemySpwan.enemyStamina=400;
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<3)//balance build 
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/2)*10;
				if((NpcEnemySpwan.enemyLevel/2)%2==1)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
					if(NpcEnemySpwan.enemyStamina>325)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-325);
						NpcEnemySpwan.enemyStamina=325;
					}
				}
				else 
				{//health build
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyLevel/4)*10;
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyHealth==400)
				{//focuse on health 
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-400);
					NpcEnemySpwan.enemyHealth=400; 
					
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Stealth/Magick".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100; 
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)//balance build 
			{
				NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				if((NpcEnemySpwan.enemyLevel/2)%2==1)//balance build 
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
					if(NpcEnemySpwan.enemyStamina>300)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-300);
						NpcEnemySpwan.enemyStamina=300;
					}
				}
				else 
				{//magic with a build of SP/HP
					NpcEnemySpwan.enemyMagicka=100+(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyLevel/4)*10;
				}
			}else if (NpcEnemySpwan.enemyLevel%2==1)//stamina build 
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyMagicka>300)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyMagicka-300);
					NpcEnemySpwan.enemyMagicka=300; 
					
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Stealth".toLowerCase()))
		{
			NpcEnemySpwan.enemyStamina=100+((NpcEnemySpwan.enemyLevel)*10);
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyMagicka=100;
			if (NpcEnemySpwan.enemyStamina>300 && NpcEnemySpwan.rangeX.nextInt(11)<4)//60% 
			{
				NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyStamina-300);
				NpcEnemySpwan.enemyStamina=300;
			}
			else if (NpcEnemySpwan.enemyStamina>230)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-230);
				NpcEnemySpwan.enemyStamina=230;
				if (NpcEnemySpwan.enemyHealth>300 && NpcEnemySpwan.rangeX.nextInt(11)<3)
				{
					NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyHealth-300);
					NpcEnemySpwan.enemyHealth=300; 
					if (NpcEnemySpwan.enemyMagicka>150)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-150);
						NpcEnemySpwan.enemyMagicka=150; 
					}
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Magick".toLowerCase()))
		{
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
			if (NpcEnemySpwan.enemyRace!="Daedric")
			{
				NpcEnemySpwan.EnemyArmorRating=0;
			}
			else 
			{
				NpcEnemySpwan.EnemyArmorRating=75; 
			}
			if(NpcEnemySpwan.enemyMagicka>400 && NpcEnemySpwan.rangeX.nextInt(11)>4)
			{ 
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-400);
				NpcEnemySpwan.enemyMagicka=400;
			}
			else if (NpcEnemySpwan.enemyMagicka>430 &&NpcEnemySpwan.rangeX.nextInt(11)<3)
			{
				NpcEnemySpwan.enemyMagicka+=NpcEnemySpwan.enemyStamina;
				NpcEnemySpwan.enemyStamina=0;
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat".toLowerCase()))
		{
			NpcEnemySpwan.enemyMagicka=100;
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100+((NpcEnemySpwan.enemyLevel)*10);
			if (NpcEnemySpwan.enemyStamina>300 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-300);
				NpcEnemySpwan.enemyStamina=300;
			}
			else if( NpcEnemySpwan.enemyStamina>250)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-250);
				NpcEnemySpwan.enemyStamina=250; 
			}
		
			NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(50+1-25)+25; 
			if(NpcEnemySpwan.EnemyArmorRating>400.0)
			{
				NpcEnemySpwan.EnemyArmorRating=400.0;
			}	
		}
	}
}