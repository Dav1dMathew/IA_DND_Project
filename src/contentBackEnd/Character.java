package code;

import java.util.List;
import java.util.Map;

class Character {
private String name;
private String race;
private String characterClass;
private Map<String, Integer> stats;
private List<String> abilities;
private int level;

public Character(String name, String race, String characterClass, Map<String, Integer> stats, List<String> abilities, int level) {
    this.name = name;
    this.race = race;
    this.characterClass = characterClass;
    this.setStats(stats);
    this.setAbilities(abilities);
    this.setLevel(level);
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

public List<String> getAbilities() {
	return abilities;
	}

public void setAbilities(List<String> abilities) {
	this.abilities = abilities;
	}

public Map<String, Integer> getStats() {
	return stats;
	}

public void setStats(Map<String, Integer> stats) {
	this.stats = stats;
	}

public int getLevel() {
	return level;
	}

public void setLevel(int level) {
	this.level = level;
	}
}