package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MainMenu {
    private Bestiary bestiary;
    private List<CharacterSheet> characterSheets;
    private Search search;
    private InputValidator validator;

    public MainMenu() {
        this.bestiary = new Bestiary();
        this.characterSheets = new ArrayList<CharacterSheet>();
        this.search = new Search();
        this.validator = new InputValidator();
    }

    public void displayMenu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
        	System.out.println("Welcome to a D&D Character Sheet Organizer! Please select one of the following options: ");
            System.out.println("1. Bestiary");
            System.out.println("2. Character Sheet");
            System.out.println("0. Exit program");
            
            choice = validator.getValidInt("Enter your choice:");

            switch (choice) {
                case 1:
                    displayBestiaryMenu();
                    break;
                case 2:
                    displayCharacterSheetsMenu();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void displayBestiaryMenu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("1. Display all monsters");
            System.out.println("2. Search for monster by name");
            System.out.println("3. Modify Monster Data");
            System.out.println("4. Segregate monsters by creature type");
            System.out.println("0. Return to main menu");

            choice = validator.getValidInt("Enter your choice:");

            switch (choice) {
                case 1:
                    displayAllMonsters();
                    break;
                case 2:
                    searchBestiaryByName();
                    String name = validator.getValidString("Enter the monster's name:");
                    break;
                case 3:
                	modifyMonsterData();
                	String monsterName = validator.getValidString("Enter the monster's name:");
                	break;
                case 4:
                	segregateMonstersByType();
                	String creatureType = validator.getValidString("Enter the creature type:");
                    break;
                case 0:
                	System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void displayAllMonsters() {
    	int choice = -1;
        Scanner input = new Scanner(System.in);
        List<Monster> monsters = bestiary.getMonsters();
        for (Monster monster : bestiary.getMonsters()) {
            System.out.println(monster.toString());
        }
        while (choice != 0) {
            System.out.println("0. Return to Bestiary menu");
            choice = validator.getValidInt("Enter your choice:");
            switch (choice) {
            case 0:
            	System.out.println("Returning to bestiary menu...");
            	displayBestiaryMenu();
                break;
            }
        }
    }


    public void searchBestiaryByName() {
    	int choice = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the monster to search for:");
        String name = input.nextLine();
        List<Monster> searchResults = search.searchMonstersByName(name, bestiary.getMonsters());
        for (Monster monster : searchResults) {
            System.out.println(monster.toString());

            while (choice != 0) {
                System.out.println("0. Return to Bestiary menu");
                choice = validator.getValidInt("Enter your choice:");
                switch (choice) {
                case 0:
                	System.out.println("Returning to bestiary menu...");
                	displayBestiaryMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }
    }

    public void segregateMonstersByType() {
    	int choice = -1;
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the type of monsters you would like to segregate:");
    	String type = input.nextLine();
    	Map<String, List<Monster>> segregatedMonsters = bestiary.segregateMonstersByType(type);
    	if (segregatedMonsters.isEmpty()) {
    	System.out.println("No monsters found of that type.");
    	} else {
    		for (Map.Entry<String, List<Monster>> entry : segregatedMonsters.entrySet()) {
    			System.out.println("Monsters of type " + entry.getKey() + ":");
    			for (Monster monster : entry.getValue()) {
    				System.out.println(monster.toString());
    				}
    			}
    		}
    	while (choice != 0) {
            System.out.println("0. Return to Bestiary menu");
            choice = validator.getValidInt("Enter your choice:");
            switch (choice) {
            case 0:
            	System.out.println("Returning to bestiary menu...");
            	displayBestiaryMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
            	}
    		}
    	}

    public void modifyMonsterData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the monster you would like to modify:");
        String name = input.nextLine();
        List<Monster> monsters = search.searchMonstersByName(name, bestiary.getMonsters());
        if (monsters == null || monsters.size() == 0) {
            System.out.println("Monster not found.");
            return;
        }

        Monster monster = monsters.get(0); // Assumes the list only contains one monster with the given name
        int choice = -1;
        while (choice != 0) {
            System.out.println("Please select the data you would like to modify:");
            System.out.println("1. Name");
            System.out.println("2. Type");
            System.out.println("3. HP");
            System.out.println("4. CR");
            System.out.println("5. Abilities");
            System.out.println("0. Return to Bestiary menu");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new name:");
                    monster.setName(input.nextLine());
                    break;
                case 2:
                    System.out.println("Enter the new type:");
                    monster.setType(input.nextLine());
                    break;
                case 3:
                    System.out.println("Enter the new HP:");
                    monster.setHP(input.nextInt());
                    break;
                case 4:
                    System.out.println("Enter the new CR:");
                    monster.setCR(input.nextInt());
                    break;
                case 5:
                    System.out.println("Enter the new abilities:");
                    monster.setAbilities(input.nextLine());
                    break;
                case 0:
                	System.out.println("Returning to bestiary menu...");
                	displayBestiaryMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void displayCharacterSheetsMenu() {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Please select an option:");
            System.out.println("1. Display all character sheets");
            System.out.println("2. Create new Character Sheet");
            System.out.println("3. Search Character Sheets by Name");
            System.out.println("4. Modify character sheet data");
            System.out.println("0. Return to Character Sheet menu");

            choice = validator.getValidInt("Enter your choice:");
            
            switch (choice) {
            case 1:
                displayAllCharacterSheets();
                break;
            case 2:
                createCharacterSheet();
                break;
            case 3:
            	String characterName = validator.getValidString("Enter the character's name:");
                searchCharacterSheetsByName();
                break;
            case 4:
                modifyCharacterSheetData();
                break;
            case 0:
            	System.out.println("Returning to Bestiary menu...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
    }

    public void displayAllCharacterSheets() {
        for (CharacterSheet characterSheet : characterSheets) {
            System.out.println(characterSheet.toString());
        }
    }

    public void searchCharacterSheetsByName() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the name of the character sheet to search for:");
    String name = input.nextLine();
    List<CharacterSheet> searchResults = search.searchCharacterSheetsByName(name, characterSheets);
    for (CharacterSheet characterSheet : searchResults) {
    System.out.println(characterSheet.toString());
    	}
    }

    public void createCharacterSheet() {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the name of the new character:");
    	String name = input.nextLine();
    	System.out.println("Enter the race of the new character: ");
    	String race = input.nextLine();
    	System.out.println("Enter the class of the new character:");
    	String characterClass = input.nextLine();
    	System.out.println("Enter the level of the new character:");
    	int level = input.nextInt();
    	System.out.println("Enter the stats of the new character: ");
    	int stats = input.hashCode();
    	CharacterSheet newChar = new CharacterSheet(name, characterClass, race, level);
    	characterSheets.add(newChar);
    	System.out.println("Character sheet for " + name + " has been created.");
    	}

    	public void modifyCharacterSheetData() {
    		Scanner input = new Scanner(System.in);
    		System.out.println("Enter the name of the character you would like to modify:");
    		String name = input.nextLine();
    		boolean found = false;
    		for (CharacterSheet charSheet : characterSheets) {
    			if (charSheet.getName().equals(name)) {
    				System.out.println("What would you like to modify? (name, class, level)");
    				String field = input.nextLine();
    				System.out.println("Enter the new value:");
    				String newValue = input.nextLine();
    				switch (field) {
    				case "name":
    					charSheet.setName(newValue);
    					break;
    				case "race":
    					charSheet.setRace(newValue);
    					break;
    				case "class":
    					charSheet.setCharacterClass(newValue);
    					break;
    				case "level":
    					charSheet.setLevel(Integer.parseInt(newValue));
    					break;
    				case "HP":
    					charSheet.setHP(Integer.parseInt(newValue));
    				default:
    					System.out.println("Invalid field. Please try again.");
    					break;
    				}
    				System.out.println("Character sheet for " + name + " has been modified.");
    				found = true;
    				break;
    			}
    		}
    		if (!found) {
    			System.out.println("Character sheet not found. Please check the name and try again.");
    		}
    	}
    	
    	public static void main(String[] args) {
    		MainMenu mainMenu = new MainMenu();
    		mainMenu.displayMenu();
    		}
}

