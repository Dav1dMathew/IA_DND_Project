package code;

import java.util.List;
import java.util.Map;

class Monster {
private String name;
private String type;
private int CR;
private int HP;
private String abilities;
private Map<String, Integer> stats;

public Monster(String name, String type, int CR, int HP, String abilities) {
    this.name = name;
    this.type = type;
    this.CR = CR;
    this.HP = HP;
    this.abilities = abilities;
    this.stats = stats;
	}

public String getName() {
    return name;
	}

public void setName(String name) {
	this.name = name;
	}

public String getType() {
    return type;
	}

public void setType(String type) {
    this.type = type;
	}

public int getCR() {
    return CR;
	}

public void setCR(int newCR) {
    this.CR = newCR;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setHP(int newHP) {
		HP = newHP;
	}

public String getAbilities() {
    return abilities;
	}

public void setAbilities(String abilities) {
    this.abilities = abilities;
	}

public Map<String, Integer> getStats() {
    return stats;
	}

public void setStats(Map<String, Integer> stats) {
    this.stats = stats;
	}

	@Override
	public String toString() {
    return "Name: " + name + "\nType: " + type + "\nHP: " + HP + "\nCR: " + CR + "\nAbilities: " + abilities;
	}
}