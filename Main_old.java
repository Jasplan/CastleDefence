package castledefence;
import java.util.Scanner;
import java.util.Random;
public class Main {

	//Declare player and playeritems variables
	public static String playerName = "Player"; //Name
	public static int killCounter = 0; //Amount
	public static int damageDealtByPlayer = 0; //HP
	public static int closeGateHealAmount = 15; //HP
	public static int baseGateHealth = 10; //HP
	public static int gateHealth = baseGateHealth; //HP 
	public static int playerHealth = 100; //HP
	public static int maxPlayerHealth = 100; //HP
	public static int basePlayerMaxDamage = 40; //HP
	public static int baseHealthPotionAmount = 3; //Amount
	public static int healthPotionAmount = baseHealthPotionAmount; //Amount
	public static int healthPotionHealAmount = 30; //HP 
	public static int healthPotionDropChance = 30; //Percent
	
	//Declare enemy variables
	public static String[] enemies = {"A Bandit", "A Boar","A Wolf",
									  "A Bear", "A Tiger", "A Dragon",
									  "A Black knight", "An Assasin"}; //Names
	public static int baseEnemyMaxHealth = 80; //HP
	public static int baseEnemyMaxDamage = 30; //HP
	public static int enemyGateDamage = 1; //HP
	public static int damageDealtByEnemy = 0; //HP
	public static int enemyHealth = 0; //HP
	public static String enemy = "0"; //Name
	
	
	//Declare other variables
	public static Boolean running = true; //Game running variable 
	public static Boolean choosing = false; //Menu running variable
	//MAIN GAME
	public static void main(String[] args) {
		//Call needed Classes
		Scanner inputScanner = new Scanner(System.in);
		Random randomNumber = new Random();
		
		//Enter starting screen
		System.out.println("\tWelcome to CastleDefence!");
		System.out.println("\t1. Start Game");
		System.out.println("\t2. Settings");
		System.out.println("\t3. Exit");
		int startScreenChoise = 0;
		
		//Player chooses what to do in startup
			for(choosing = true; choosing; ) {
				startScreenChoise = inputScanner.nextInt();
				if(startScreenChoise == 1) {
					System.out.println("\n\tStarting Game:");
					choosing = false;
				}
				else if(startScreenChoise == 2) {
					Settings.settings();
					
					
					
					choosing =false;
				}
				else if(startScreenChoise == 3) {
					System.out.println("\n\t----------------");
					System.out.println("\t# Exiting Game #");
					System.out.println("\t----------------");
					running = false;
					choosing = false;
				}
				else {
					
				}
		
			}
		
		//Run game loop
		
		GAME:
		while(running) {
			
			if(playerHealth > 0 && gateHealth > 0) {
				System.out.println("\t----------------------------------------");
				enemy = enemies[randomNumber.nextInt(enemies.length)];
				while(enemyHealth < 1) {
					enemyHealth = randomNumber.nextInt(baseEnemyMaxHealth);
				}
				System.out.println("\n\t# " + enemy + " attacks your castle! #");
			}
			
			FIGHTING:
			while(enemyHealth > 0 ||playerHealth == 0) {
			if(playerHealth > 0 && gateHealth > 0){	
				//Print player/enemy health and display options
				System.out.println("\n\t----------------------------------------");
				System.out.println("\tGate HP: " + gateHealth);
				System.out.println("\t" + playerName + " HP: " + playerHealth);
				System.out.println("\t" + enemy + " HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack the " + enemy + "!");
				System.out.println("\t2. Drink a potion.(" + healthPotionAmount + " left)");
				System.out.println("\t3. Close the gate for one day.");
				
				
				//get actioninput from player
				int actionInput = inputScanner.nextInt();
				
				//Calculate the battle health results and print damage dealt to the player
				if(actionInput == 1) {
					if(playerHealth > 1) {
						while(damageDealtByPlayer < 1 || damageDealtByEnemy < 1) {
						damageDealtByPlayer =randomNumber.nextInt(basePlayerMaxDamage);
						damageDealtByEnemy = randomNumber.nextInt(baseEnemyMaxDamage);
						}
						if((playerHealth - damageDealtByEnemy) < 0) {
							playerHealth = 0;
						}
						else {
							playerHealth -= damageDealtByEnemy;
						}
						if((enemyHealth - damageDealtByPlayer) < 0) {
							enemyHealth = 0;
						}
						else {
							enemyHealth -= damageDealtByPlayer;
						}
						if(enemyHealth > 0) {
		
							System.out.println("\t*You dealt " + damageDealtByPlayer + 
										   " damage to the " + enemy + "!" );
							System.out.println("\t*The " + enemy + " did " + damageDealtByEnemy + 
										   " damage\n\tto you in return!");
						}
						//Enemy gets killed
						else if(enemyHealth == 0) {
							System.out.println("\t*You killed the " + enemy +" with a final strike\n\tof " +
											   damageDealtByPlayer + " damage!");
							System.out.println("\t*The " + enemy + " manage to land one last blow\n\tdealing " +
											   damageDealtByEnemy + " damage!");
							killCounter++;
							//generate a potion drop/no drop
							if(healthPotionDropChance > (randomNumber.nextInt(100))) {
								healthPotionAmount++;
								System.out.println("\t*The " + enemy + " dropped a Health potion!");
							}
							
						}
						else {
							System.out.println("%%%ERROR(enemy hp less than 0)%%%");
						}
						damageDealtByPlayer = 0;
						damageDealtByEnemy = 0;
					}
					else {
						System.out.println("\t*You do not have enough health for this move!");
						if(healthPotionAmount > 0) {
							System.out.println("\t*Take a health potion before continuing!");
						}
						else {
							System.out.println("\t*There is no chance of survival\nyou have to close the gate!");
						}
					}
				}
				//POTION SYSTEM START
				//Take away a health potion and add the points to health
				else if(actionInput == 2) {
					if(healthPotionAmount > 0) {
						//If the potions will heal the player to max do this 
						if(playerHealth >= (maxPlayerHealth - healthPotionHealAmount) && 
						   playerHealth != maxPlayerHealth) {
							int difference = maxPlayerHealth - playerHealth;
							playerHealth = maxPlayerHealth;
							healthPotionAmount--;
							System.out.println("\t*You lost one potion and restored " + 
									   		   difference + "HP");
							System.out.println("\t*You know have full HP");
						}
						//Cancel if the player alreadey have full HP
						else if(playerHealth == maxPlayerHealth) {
							System.out.println("\t*Your health is already full!");
						}
						//Regular heal
						else if(playerHealth < (maxPlayerHealth - healthPotionHealAmount)) {
							playerHealth += healthPotionHealAmount;
							healthPotionAmount--;
							System.out.println("\t*You lost one potion and restored " + 
											   healthPotionHealAmount + " HP");
						}
					}	
					else {
						System.out.println("\t*You do not have any health potions left!");
					}
					
				}
				//POTION SYSTEM STOP
				//CLOSE GATE SYSTEM START
				//closing the gates will do 1 damage to gates and heal the player aswell as you get a new enemy
				else if(actionInput == 3) {
					gateHealth -= enemyGateDamage;
					if(playerHealth < (maxPlayerHealth - closeGateHealAmount)) {
						playerHealth += closeGateHealAmount;
						System.out.println("\t*You flee into your castle to rest over\n\tthe night and restore " + closeGateHealAmount + "HP!");
						System.out.println("\t*While you are inside the " + enemy + " deals " + enemyGateDamage + " to your gate!");
					}
					else if(playerHealth >= (maxPlayerHealth - closeGateHealAmount) && playerHealth != maxPlayerHealth) {
						int difference = maxPlayerHealth - playerHealth;
						playerHealth = maxPlayerHealth;
						System.out.println("\t*You flee into your castle to rest over\n\tthe night and restore " + difference + "HP!");
						System.out.println("\tYou know have full HP");
						System.out.println("\t*While you are inside the " + enemy + "\n\tdeals " + enemyGateDamage + " damage to your gate!");
					}
					else if(playerHealth == maxPlayerHealth) {
						System.out.println("\t*You flee into your castle to rest over\n\tthe night.");
						System.out.println("\tYou know have full HP");
						System.out.println("\t*While you are inside the " + enemy + "\n\tdeals " + enemyGateDamage + " damage to your gate!");
					}
					//GATE SYSTEM STOP
					continue GAME;
				}
				//Redo loop if invalid input
				else {
					continue FIGHTING;
				}
			}
			//Print thanks you screen and break loops to stop the game.
			else {
				if(playerHealth == 0) {
					System.out.println("\n\t----------------------------------------");
					System.out.println("\t*You have died!");
				}
				else{
					System.out.println("\t*The gate have been breached!");
				}
				System.out.println("\n\t*You got " + killCounter + " kills!");
				System.out.println("\t#######################");
				System.out.println("\t# Thanks for playing! #");
				System.out.println("\t#######################");			
				running = false;
				inputScanner.close();
				break;
			}
			
		}		
		}
		
	}


	
		
	
}




