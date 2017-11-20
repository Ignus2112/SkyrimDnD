 package skyrimdnd;
public class DamagePhase 
{
	// Damage input Method needed
	static double Crit;
	static double block=0;
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
	static int returnedValue=0;
	static int sneakMulti;
	public static double DamageCalculate()
	{
		if (armorFactor>567) 
		{
			armorFactor=567;
		}
		if(Crit!=0) {
			ResultingDamage=ResultingDamage+(ResultingDamage*Crit);
		}
		if (armorFactor==0) 
		{
			 HiddenArmor=0;
		 }
		if (block!=0) 
		{
			blockedDamage=ResultingDamage-(ResultingDamage*(block/100));
			return ResultingDamage=(blockedDamage/100)*ResultingDamage;
		}
		else 
		{
		if (baseSneakMulti!=0)
		{
			ResultingDamage=ResultingDamage*baseSneakMulti;
		}
			
		if (SilentWarmonger==.20 || SilentWarmonger==.40)
		{
			ResultingDamage=ResultingDamage+(ResultingDamage*SilentWarmonger);	
		}
		if (Intruder==.15)
		{
			ResultingDamage=ResultingDamage+(ResultingDamage*Intruder);
		}
		armorFactor = 0.12 * (HiddenArmor+armorFactor)/100.0; 
	    ResultingDamage=ResultingDamage*(1-armorFactor);
		return ResultingDamage;
		}
	}
}