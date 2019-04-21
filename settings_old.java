package castledefence;
import java.util.Scanner;
public class Settings {
	
	public static void setDefault() {
		
	}
	

	public static void settings(){
		//create scanner
		
		
		//Set temporary variables
		int tempMaxPlayerHealth = Main.maxPlayerHealth;//2
		int tempMaxPlayerDamage = Main.basePlayerMaxDamage;//3
		int tempMaxEnemyHealth = Main.baseEnemyMaxHealth;//4
		int tempMaxEnemyDamage = Main.baseEnemyMaxDamage;//5
		int tempMaxGateHealth = Main.baseGateHealth;//6
		int tempEnemyGateDamage = Main.enemyGateDamage;//7
		int tempPotionHealAmount = Main.healthPotionHealAmount;//8
		int tempPotionAmount = Main.baseHealthPotionAmount;//9
		int tempPotionDropChance = Main.healthPotionDropChance;//10
		int tempCloseGateHealAmount = Main.closeGateHealAmount;//11
		
		//Settings loop
		SETTINGS:
		for(Boolean editing = true; editing;) {
			
			//Clear Screen
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}catch(Exception e){
				System.out.println("\t## Error clearing console(settings) ##");
			}
			//Print options

			System.out.println("\n\t              # Settings #");
			System.out.println("\t----------------------------------------");
			System.out.println("\t|0. Return to Menu");
			System.out.println("\t|1. Set Default");
			System.out.println("\n\t|2. Max player HP: " + tempMaxPlayerHealth);
			System.out.println("\t|3. Max player DMG: " + tempMaxPlayerDamage );
			System.out.println("\t|4. Max enemy HP: " + tempMaxEnemyHealth);
			System.out.println("\t|5. Max enemy DMG: " + tempMaxEnemyDamage);
			System.out.println("\t|6. Max gate HP: " + tempMaxGateHealth);
			System.out.println("\t|7. Enemy gate DMG: " + tempEnemyGateDamage);
			System.out.println("\t|8. Health potion HP gain: " + tempPotionHealAmount);
			System.out.println("\t|9. Health potion start Amount: " + tempPotionAmount);
			System.out.println("\t|10. Health potion drop chance: " + tempPotionDropChance + "%");
			System.out.println("\t|11. Close gate HP gain: " + tempCloseGateHealAmount);
			System.out.println("\t----------------------------------------");
			
			
			//Get input and set tempVariables accordingly
			Scanner inputScanner = new Scanner(System.in);
			int refNum = 100;
			int setNum = 0;
			System.out.print("\tChoose a setting:");
			try {
				refNum = inputScanner.nextInt();
			}
			catch(Exception e) {
				System.out.println("\t## Invalid Input ##");
				continue SETTINGS;
			}
			
			if(refNum == 0) {			
				inputScanner.close();
				System.out.println("\t1. Start Game");
				System.out.println("\t2. Settings");
				System.out.println("\t3. Exit");
				Main.choosing = false;
				break;
			}
			else if(refNum == 1) {
				
			}
			
			
			else {
				continue SETTINGS;
			}
		
		}
	}
}
