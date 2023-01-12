package code;

import java.util.List;

class Data {
    public final List<PlayerCharacter> characters;
    public final List<Monster> monsters;

    public Data(List<PlayerCharacter> characters, List<Monster> monsters) {
        this.characters = characters;
        this.monsters = monsters;
    }
}