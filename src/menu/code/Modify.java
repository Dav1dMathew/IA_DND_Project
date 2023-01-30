package code;

import java.util.Map;
import java.util.Scanner;

class Modify {

	public void modifyMonsterData(Monster monster) {
	    Scanner input = new Scanner(System.in);
	    System.out.println("What data would you like to modify? (name, type, hp, cr, etc.)");
	    String dataToModify = input.nextLine();
	    System.out.println("What is the new value for " + dataToModify + "?");
	    String newValue = input.nextLine();

	    switch (dataToModify) {
	        case "name":
	            monster.setName(newValue);
	            break;
	        case "type":
	            monster.setType(newValue);
	            break;
	        case "hp":
	            try {
	                int newHP = Integer.parseInt(newValue);
	                monster.setHP(newHP);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a numerical value for HP.");
	            }
	            break;
	        case "cr":
	            try {
	                int newCR = Integer.parseInt(newValue);
	                monster.setCR(newCR);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a numerical value for CR.");
	            }
	            break;
	        // add additional cases for any other data fields in the Monster class
	        default:
	            System.out.println("Invalid data field. Please try again.");
	            break;
	    }
	}

	public void modifyCharacterSheetData(CharacterSheet characterSheet) {
	    Scanner input = new Scanner(System.in);
	    System.out.println("What data would you like to modify? (name, class, level, hp, etc.)");
	    String dataToModify = input.nextLine();
	    System.out.println("What is the new value for " + dataToModify + "?");
	    String newValue = input.nextLine();

	    switch (dataToModify) {
	        case "name":
	            characterSheet.setName(newValue);
	            break;
	        case "class":
	            characterSheet.setCharacterClass(newValue);
	            break;
	        case "level":
	            try {
	                int newLevel = Integer.parseInt(newValue);
	                characterSheet.setLevel(newLevel);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a numerical value for level.");
	            }
	            break;
	        case "HP":
	            try {
	                int newHP = Integer.parseInt(newValue);
	                characterSheet.setHP(newHP);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a numerical value for HP.");
	            }
	            break;
	        // add additional cases for any other data fields in the CharacterSheet class
	        default:
	            System.out.println("Invalid data field. Please try again.");
	            break;
	    }
	}
}
