package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bestiary {
    private List<Monster> monsters;

    public Bestiary() {
    	this.monsters = new ArrayList<Monster>();
        Monster beholder = new Monster("Beholder", "Aberration", 13, 180, "Eye Ray");
        Monster dragon = new Monster("Dragon", "Dragon", 20, 250, "Fire Breath");
        Monster golem = new Monster("Golem", "Construct", 15, 200, "Slam Attack");
        Monster medusa = new Monster("Medusa", "Monstrous Humanoid", 14, 190, "Petrifying Gaze");
        Monster minotaur = new Monster("Minotaur", "Monstrous Humanoid", 16, 210, "Charge Attack");
        Monster mummy = new Monster("Mummy", "Undead", 12, 170, "Rotting Touch");
        Monster ogre = new Monster("Ogre", "Giant", 17, 220, "Cleave Attack");
        Monster vampire = new Monster("Vampire", "Undead", 18, 230, "Blood Drain");
        Monster werewolf = new Monster("Werewolf", "Lycanthrope", 19, 240, "Claw Attack");
        Monster zombie = new Monster("Zombie", "Undead", 11, 160, "Bite Attack");
        Monster tarrasque = new Monster("Tarrasque", "Undead", 30, 676, "Swallow");
        this.monsters = Arrays.asList(beholder, dragon, golem, medusa, minotaur, mummy, ogre, vampire, werewolf, zombie, tarrasque);
    }

    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public Map<String, List<Monster>> segregateMonstersByType(String type) {
        Map<String, List<Monster>> segregatedMonsters = new HashMap<>();
        List<Monster> typeMonsters = new ArrayList<>();
        for (Monster monster : monsters) {
            if (monster.getType().equals(type)) {
                typeMonsters.add(monster);
            }
        }
        segregatedMonsters.put(type, typeMonsters);
        return segregatedMonsters;
    }

}
