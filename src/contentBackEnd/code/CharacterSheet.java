package code;

import java.util.HashMap;
import java.util.Map;

class CharacterSheet {
    private String name;
    private String race;
    private String characterClass;
    private int level;
    private int HP;
    private Map<String, Integer> stats;

    public CharacterSheet(String name, String race, String characterClass, int level) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.level = level;
        this.stats = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public void addStat(String statName, int statValue) {
        this.stats.put(statName, statValue);
    }

    public void modifyStat(String statName, int statValue) {
        this.stats.replace(statName, statValue);
    }

    public void displayCharacterSheet() {
        System.out.println("Name: " + this.name);
        System.out.println("Race: " + this.race);
        System.out.println("Class: " + this.characterClass);
        System.out.println("Level: " + this.level);
        System.out.println("Stats: ");
        for (Map.Entry<String, Integer> stat : this.stats.entrySet()) {
            System.out.println(stat.getKey() + ": " + stat.getValue());
        }
    }
    
    public int getHP() {
		return HP;
	}
    
    public void setHP(int newHP) {
		this.HP = newHP;
	}
    
    @Override
    public String toString(){
        return "Name: " + this.name + "\nClass: " + this.characterClass + "\nLevel: " + this.level + "\nRace: " + this.race;
    }

}
