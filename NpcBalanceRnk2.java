package skyrimdnd;
public class NpcBalanceRnk2 
{
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
				if (NpcEnemySpwan.enemyHealth>150)
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
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
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
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
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
			if (NpcEnemySpwan.enemyTitle.toLowerCase().contains("unbound")==true)
			{
				NpcEnemySpwan.enemyRace="Daedric";
			}
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyStamina=100;
			NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
			if (NpcEnemySpwan.enemyRace=="Daedric")
			{
				NpcEnemySpwan.EnemyArmorRating=75;
				if (NpcEnemySpwan.enemyMagicka>230)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.maxEnemyLvL-230);
					NpcEnemySpwan.enemyMagicka=230;
				}
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
}