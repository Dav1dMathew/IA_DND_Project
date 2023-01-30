package code;

import java.util.ArrayList;
import java.util.List;

class Search {
	public List<Monster> searchMonstersByName(String name, List<Monster> monsters) {
	    List<Monster> searchResults = new ArrayList<Monster>();
	    for (Monster monster : monsters) {
	        if (monster.getName().equalsIgnoreCase(name)) {
	            searchResults.add(monster);
	        }
	    }
	    return searchResults;
	}

	public List<CharacterSheet> searchCharacterSheetsByName(String name, List<CharacterSheet> characterSheetList) {
	    List<CharacterSheet> searchResults = new ArrayList<CharacterSheet>();
	    for (CharacterSheet characterSheet : characterSheetList) {
	        if (characterSheet.getName().equalsIgnoreCase(name)) {
	            searchResults.add(characterSheet);
	        }
	    }
	    return searchResults;
	}
}