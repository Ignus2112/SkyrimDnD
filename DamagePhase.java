package skyrimdnd;
public class DamagePhase 
{
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
	double baseSneakMulti=0;
	static double SilentWarmonger=0;
	static double Intruder=1.0;
	static int returnedValue;
	public static double DamageCalculate()
	{
		if (armorFactor>567) 
		{
			armorFactor=567;
		}
		if(Crit==.50) {
			ResultingDamage=ResultingDamage+(ResultingDamage*Crit);
		}
		if (armorFactor==0) 
		{
			 HiddenArmor=0;
		 }
		if (block>0) 
		{
			blockedDamage=(ResultingDamage*(block/100));
			armorFactor = 0.12 * (HiddenArmor+armorFactor)/100.0; 
		    ResultingDamage=ResultingDamage*(1-armorFactor);
			return ResultingDamage=(blockedDamage/100)*ResultingDamage;
		}
		else 
		{
		armorFactor = 0.12 * (HiddenArmor+armorFactor)/100.0; 
	    ResultingDamage=ResultingDamage*(1-armorFactor);
		return ResultingDamage;
		}
	}
	public static void SneakMultiplyer() 
	{
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
		ResultingDamage=ResultingDamage+(ResultingDamage*SilentWarmonger);	
		ResultingDamage=ResultingDamage+(ResultingDamage*Intruder);
	}
}