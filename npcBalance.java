package skyrimdnd;
public class npcBalance {
	public static void npcBalanceRnk1()
	{
		if (NpcEnemySpwan.enemyRank==1)
		{
			
			if (NpcEnemySpwan.enemyTitle.contains("Bandit Cheif")==true && NpcEnemySpwan.bossCounter<1)
			{
				NpcEnemySpwan.bossCounter=1;
				NpcEnemySpwan.enemyHealth+=Math.ceil(NpcEnemySpwan.enemyMagicka/2)+35;
				NpcEnemySpwan.enemyStamina+=Math.ceil(NpcEnemySpwan.enemyMagicka/2)+45;
				NpcEnemySpwan.enemyMagicka=100;
				NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(75+1-25)+25;
				NpcEnemySpwan.enemyLevel=15;
			}
			else if (NpcEnemySpwan.enemyType.contains("Combat"))
			{
				if (NpcEnemySpwan.bossCounter==1)
				{
					NpcEnemySpwan.enemyTitle="Bandit";
				}
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
			else if (NpcEnemySpwan.enemyType.contains("Magick"))
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				if (NpcEnemySpwan.enemyRace!="Daedric")
				{
					NpcEnemySpwan.EnemyArmorRating=0;
				}
				else 
				{
					NpcEnemySpwan.EnemyArmorRating=40; 
				}
				if (NpcEnemySpwan.enemyMagicka>220.0)
				{
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyMagicka-220);
					if (NpcEnemySpwan.enemyStamina>110)
					{
						NpcEnemySpwan.enemyHealth=NpcEnemySpwan.enemyHealth+(NpcEnemySpwan.enemyStamina-110);
						NpcEnemySpwan.enemyStamina=110;
					}
					NpcEnemySpwan.enemyMagicka=220;
				}
			}
			else if (NpcEnemySpwan.enemyType.contains("Stealth"))
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
		}
		
	}
	public static void npcBalanceRnk2()
	{
		if(NpcEnemySpwan.enemyType.toLowerCase().contains("Combat/Magick".toLowerCase()))
		{
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
				if (NpcEnemySpwan.enemyMagicka>250)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-250);
					if (NpcEnemySpwan.enemyHealth>200)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-200);
						NpcEnemySpwan.enemyHealth=200;
					}
					NpcEnemySpwan.enemyMagicka=250;
				}
				if (NpcEnemySpwan.enemyMagicka>200 && NpcEnemySpwan.enemyMagicka<250)//creats a range 
				{
					NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyMagicka-200);
					if (NpcEnemySpwan.enemyHealth>130 && NpcEnemySpwan.enemyMagicka!=250)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-130);
					}
				}
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+((NpcEnemySpwan.enemyLevel)*10);
					if (NpcEnemySpwan.enemyMagicka>300)
					{
						NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-250);
						NpcEnemySpwan.enemyMagicka=300;
					}
			}
			else if (NpcEnemySpwan.enemyLevel%2==1)
			{
				NpcEnemySpwan.enemyHealth=100;
				NpcEnemySpwan.enemyStamina=100;
				NpcEnemySpwan.enemyMagicka=100+(NpcEnemySpwan.enemyLevel*10);
				if (NpcEnemySpwan.enemyMagicka>=200)
				{
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyMagicka-200);
					NpcEnemySpwan.enemyMagicka=200;
					if (NpcEnemySpwan.enemyHealth>230)
					{
						NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyHealth-230);
						NpcEnemySpwan.enemyHealth=200;
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
			{
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
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/4)*10;
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
					NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/4)*10;
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
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/4)*10;
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
			if(NpcEnemySpwan.enemyLevel%2==0 && NpcEnemySpwan.rangeX.nextInt(11)<7)
			{
				NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/2)*10;
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				
			}
			else if (NpcEnemySpwan.enemyLevel%2==0)
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
				if((NpcEnemySpwan.enemyLevel/2)%2==1)//balancec build 
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
					NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel/2)*10;
					NpcEnemySpwan.enemyStamina+=(NpcEnemySpwan.enemyLevel/4)*10;
					NpcEnemySpwan.enemyHealth+=(NpcEnemySpwan.enemyLevel/4)*10;
				}
			}else if (NpcEnemySpwan.enemyLevel%2==1)//stamina build 
			{
				NpcEnemySpwan.enemyMagicka+=(NpcEnemySpwan.enemyLevel*10);
				if(NpcEnemySpwan.enemyMagicka==300)
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
			if (NpcEnemySpwan.enemyStamina>300 && NpcEnemySpwan.rangeX.nextInt(10)<4)//60% 
			{
				NpcEnemySpwan.enemyHealth=100+(NpcEnemySpwan.enemyStamina-300);
				NpcEnemySpwan.enemyStamina=300;
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
			NpcEnemySpwan.enemyStamina=100;
			if( NpcEnemySpwan.enemyHealth==NpcEnemySpwan.enemyStamina)
			{
				NpcEnemySpwan.enemyHealth+=((NpcEnemySpwan.enemyLevel)*10);
				if (NpcEnemySpwan.enemyHealth>400 && NpcEnemySpwan.rangeX.nextInt(11)<7)
				{
					NpcEnemySpwan.enemyStamina=100+(NpcEnemySpwan.enemyHealth-400);
					NpcEnemySpwan.enemyHealth=400;
				}
			}
		
			NpcEnemySpwan.EnemyArmorRating+=NpcEnemySpwan.rangeX.nextInt(50+1-25)+25; 
			if(NpcEnemySpwan.EnemyArmorRating>400.0)
			{
				NpcEnemySpwan.EnemyArmorRating=400.0;
			}	
		}
	}
}
