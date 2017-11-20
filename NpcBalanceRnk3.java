package skyrimdnd;
public class NpcBalanceRnk3
{
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
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina/2);
				NpcEnemySpwan.enemyStamina=(NpcEnemySpwan.enemyStamina/2);
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
			}else if (NpcEnemySpwan.enemyLevel%2==1)//Magic build 
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyMagicka>300)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyMagicka-300);
					NpcEnemySpwan.enemyMagicka=300; 
					if(NpcEnemySpwan.enemyStamina>200)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-200);
						NpcEnemySpwan.enemyStamina=200;
					}
				}
			}
		}
		else if(NpcEnemySpwan.enemyType.toLowerCase().contains("Stealth".toLowerCase()))
		{
			NpcEnemySpwan.enemyStamina=100+((NpcEnemySpwan.enemyLevel)*10);
			NpcEnemySpwan.enemyHealth=100;
			NpcEnemySpwan.enemyMagicka=100;
			if (NpcEnemySpwan.enemyStamina>250 && NpcEnemySpwan.rangeX.nextInt(11)<4)//60% 
			{
				NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyStamina-250);
				NpcEnemySpwan.enemyStamina=250;
			}
			else if (NpcEnemySpwan.enemyStamina>200)
			{
				NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyStamina-200);
				NpcEnemySpwan.enemyStamina=200;
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
				NpcEnemySpwan.EnemyArmorRating=0;
				if (NpcEnemySpwan.enemyTitle.toLowerCase().contains("unbound")==true)
				{
					NpcEnemySpwan.enemyRace="Daedric";
				}
				if (NpcEnemySpwan.enemyRace=="Daedric")
				{
					NpcEnemySpwan.enemyMagicka=100;
					NpcEnemySpwan.EnemyArmorRating=200;
					NpcEnemySpwan.enemyHealth=100+((NpcEnemySpwan.enemyLevel)*10);
					if (NpcEnemySpwan.enemyHealth>500)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-500);
						NpcEnemySpwan.enemyHealth=500;
					}
				}
				else if(NpcEnemySpwan.enemyMagicka>400 && NpcEnemySpwan.rangeX.nextInt(11)>4)
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