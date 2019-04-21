package castledefence;

import java.util.Random;
import java.util.Scanner;

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
		
		startScreenChoise = inputScanner.nextInt();
		if(startScreenChoise == 1) {
			System.out.println("\n\tStarting Game:");
			choosing = false;
		}
		else if(startScreenChoise == 2) {
			Settings.settings();
			
			
			
			
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
}
