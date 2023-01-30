package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Segregate {
public void segregateMonstersByType(List<Monster> monsters) {
    Map<String, List<Monster>> segregatedMonsters = new HashMap<String, List<Monster>>();
    for (Monster monster : monsters) {
    	String type = monster.getType();
    	if (!segregatedMonsters.containsKey(type)) {
    		segregatedMonsters.put(type, new ArrayList<Monster>());
    		}
    		segregatedMonsters.get(type).add(monster);
    	}
    for (Map.Entry<String, List<Monster>> entry : segregatedMonsters.entrySet()) {
        System.out.println("Type: " + entry.getKey());
        for (Monster monster : entry.getValue()) {
            System.out.println(monster.toString());
        	}
    	}
	}
}