package code;

import com.google.gson.Gson;

import org.apache.commons.cli.ParseException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharacterSheetOrganizer {
    // ObservableList is a collection that can be observed for changes
	  private ObservableList<PlayerCharacter> characters;
	  private ObservableList<Monster> monsters;
    
    // constructor to initialize the observable lists
    public CharacterSheetOrganizer() {
       characters = FXCollections.observableArrayList();
       monsters = FXCollections.observableArrayList();
        }
    // add a new character to the list of characters
    public void addCharacter(PlayerCharacter character) {
        characters.add(character);
    }
    // remove a character from the list of characters
    public void removeCharacter(PlayerCharacter character) {
        characters.remove(character);
    }
    // method to save data to a file. The data saved is in json format.
    public void saveDataToFile(String filename) throws IOException {
        Gson gson = new Gson();
        // create a new object of Data class, which holds the current state of the characters and monsters
        Data data = new Data(characters, monsters);
        // use Gson library to convert the data object to json format
        String json = gson.toJson(data);

        FileWriter writer = new FileWriter(filename);
        // write the json to the file
        writer.write(json);
        writer.close();
    }

    // method to load data from a file
    public void loadDataFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        // read the file and convert it to string
        String json = new String(Files.readAllBytes(Paths.get(filename)));
        // use Gson library to convert the json string to a Data object
        Data data = gson.fromJson(json, Data.class);

        // update the characters and monsters list with the data loaded from the file
        characters.setAll(data.characters);
        monsters.setAll(data.monsters);
    }
    
    // method to load character data from a file
    public void loadCharactersFromFile(String filename) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filename);
            sc = new Scanner(inputStream);
            // iterate through each line in the file
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // split the line by ',' to separate the fields
                String[] parts = line.split(",");
                String name = parts[0];
                int level = Integer.parseInt(parts[1]);
                //NOTE: add for loop to read the data from each Character from the PlayersHandbook.txt
                String classType = parts[2];
                int hitPoints = Integer.parseInt(parts[3]);
                // add for loop for the additional Character data in the parts array
                for(int i = 4; i < parts.length; i++) {
                    // process the additional data fields
                	String additionalData = parts[i];
                	// do something with the additionalData
                	// e.g. add it to the newChar object or store it in a separate list
                }
                // create a new character object with the fields
                PlayerCharacter newChar = new PlayerCharacter(name, level, classType, hitPoints);
                // add the character to the list of characters
                characters.add(newChar);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();

            }
        }

    }
    
 // Method to save characters to a file
    public void saveCharactersToFile(String filename) throws IOException {
    	//NOTE: add method to read the name of the character and the number of attributes for each character
        // code to save character data to a file
    	FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            for (PlayerCharacter character : characters) {
                String line = character.getName() + "," + character.getLevel() + "," + character.getClassType() + "," + character.getHitPoints() + System.lineSeparator();
                fileWriter.write(line);
            }
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
    
    public void loadMonstersFromWeb(String url) throws IOException, ParseException {
        // This method loads monster data from a website by using a URL provided by the user
        // It then connects to the website using an HttpURLConnection, sets the request method to "GET"
        // Then it creates a BufferedReader to read the response from the website, and appends each line of the response
    	// to a StringBuilder
        // Then it uses a JsonParser to parse the response into a JsonArray of monsters and for each JsonObject in the
    	// JsonArray it reads the values of "name", "hitPoints", "attack", and "ac" and creates a new Monster object
        // With those values and adds it to the monster list
    	 URL website = new URL(url);
    	    HttpURLConnection connection = (HttpURLConnection) website.openConnection();
    	    connection.setRequestMethod("GET");
    	    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

    	    StringBuilder content = new StringBuilder();
    	    String inputLine;
    	    while ((inputLine = in.readLine()) != null) {
    	        content.append(inputLine);
    	    }
    	    in.close();
    	    connection.disconnect();

    	    JsonParser parser = new JsonParser();
    	    JsonArray jsonMonsters = (JsonArray) parser.parse(content.toString());

    	    for (Object obj : jsonMonsters) {
    	        JsonObject jsonMonster = (JsonObject) obj;
    	        String name = jsonMonster.get("name").getAsString();
    	        int hitPoints = jsonMonster.get("hitPoints").getAsInt();
    	        int attack = jsonMonster.get("attack").getAsInt();
    	        int ac = jsonMonster.get("ac").getAsInt();
    	        Monster newMonster = new Monster(name, hitPoints, attack, ac);
    	        monsters.add(newMonster);
    	    }
    }
    
    public ArrayList<Monster> searchMonsters(String searchTerm) {
        // This method creates an empty ArrayList of Monsters and then iterates over the monsters list
        // Checking if the name of the monster contains the provided search term, if so it adds that monster to the returned list
    	ArrayList<Monster> results = new ArrayList<Monster>();
        for (Monster monster : monsters) {
            if (monster.getName().contains(searchTerm)) {
                results.add(monster);
            }
        }
        return results;
    }
    
    public List<PlayerCharacter> searchPlayerCharacterByName(String name) {
        // This method creates an empty ArrayList of PlayerCharacter and then iterates over the character list
        // Checking if the name of the character contains the provided search term, if so it adds that character to the returned list
        // Note that this method will do case-insensitive search
        List<PlayerCharacter> result = new ArrayList<>();
        for (PlayerCharacter character : characters) {
            if (character.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(character);
            }
        }
        return result;
    }
    
 // This method creates a new JFrame, with the title "Character Sheet Organizer"
 // It sets the default close operation so that when the frame is closed, the program will exit
    public static void main(String[] args) {
        // code to create a GUI for displaying and editing character and monster data
    	CharacterSheetOrganizer organizer = new CharacterSheetOrganizer();
        try {
            organizer.loadCharactersFromFile("PlayersHandbook.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            organizer.loadMonstersFromWeb("https://www.aidedd.org/dnd-filters/monsters.php");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Character Sheet Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        JPanel characterPanel = new JPanel();
        // Code to create the character panel, displaying and editing character data
        JPanel monsterPanel = new JPanel();
        // Code to create the monster panel, displaying and searching monster data
        tabs.addTab("Characters", characterPanel);
        tabs.addTab("Monsters", monsterPanel);

        frame.getContentPane().add(tabs);
        frame.pack();
        frame.setVisible(true);
    }

    public ObservableList<PlayerCharacter> getCharacters() {
        return characters;
    }

    public void filterCharactersByName(String name) {
        characters.removeIf(character -> !character.getName().contains(name));
    }

    public ObservableList<Monster> getMonsters() {
        return monsters;
    }
 
    public void filterMonstersByName(String name) {
        monsters.removeIf(monster -> !monster.getName().contains(name));
    }
}