package castledefence;
import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		//Call needed Classes
		Scanner inputScanner = new Scanner(System.in);
		Random randomNumber = new Random();
		
		//Declare player and playeritems variables
		String playerName = "Player";
		int playerHealth = 100;
		int basePlayerMaxDamage = 40;
		int baseHealthPotionAmount = 3;
		int healthPotionAmount = baseHealthPotionAmount;
		int healthPotionHealAmount = 30;
		int baseSpellStoneAmount = 3;
		int spellStoneAmount = baseSpellStoneAmount;
		//Declare enemy variables
		String[] enemies = {"Rat", "Boar", "Wolf", "Bear", "Tiger"};
		int baseEnemyMaxHealth = 80;
		int baseEnemyMaxDamage = 30;
		
		//Declare other variables
		Boolean running = true;
		
		
		//Run game loop
		System.out.println("\tWelcome to CastleDefence!");
		GAME:
		while(running) {
			System.out.println("\t----------------------------------------");
			String enemy = enemies[randomNumber.nextInt(enemies.length)];
			int enemyHealth = randomNumber.nextInt(baseEnemyMaxHealth);
			System.out.println("\t# A " + enemy + " attacks your castle! #");
			
			while(enemyHealth > 0) {
				//Print player/enemy health and display options
				System.out.println("\t" + playerName + " HP: " + playerHealth);
				System.out.println("\t" + enemy + " HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack the " + enemy + "!");
				System.out.println("\t2. Drink a potion.(" + healthPotionAmount + " left)");
				System.out.println("\t3. Run away.");
				System.out.println("\t----------------------------------------");
				//get actioninput from player
				String actionInput = inputScanner.nextLine();
				if(actionInput.equals("1")) {
					if(playerHealth > 1) {
						int damageDealtByPlayer =randomNumber.nextInt(basePlayerMaxDamage);
						int damageDealtByEnemy = randomNumber.nextInt(baseEnemyMaxDamage);
						enemyHealth -= damageDealtByPlayer;
						playerHealth -= damageDealtByEnemy;
						System.out.println("\tYou dealt " + damageDealtByPlayer + 
										   " damage to the " + enemy + "!" );
						System.out.println("\tThe " + enemy + " did " + damageDealtByEnemy + 
										   " damage to you in return!");
					}
					else {
						System.out.println("You do not have enough health for this move!");
						if(healthPotionAmount > 0) {
							System.out.println("Take a health potion before continuing!");
						}
						else {
							System.out.println("There is no chance of survival, You have to run away!");
						}
					}
				}
				
				else if(actionInput.equals("2")) {
					if(healthPotionAmount > 0) {
						playerHealth += healthPotionHealAmount;
						healthPotionAmount--;
						System.out.println("\tYou lost one potion and restored " + 
									   healthPotionHealAmount + "HP");
					}
					else {
						System.out.println("You do not have any health potions left!");
					}
					
				}
				
				else if(actionInput.equals("3")) {
					continue GAME;
					
				}
				else {
					
				}
			}
				
		}
		
	}

}
