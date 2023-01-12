package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CharacterSheetOrganizerGUI extends Application {
    private CharacterSheetOrganizer organizer;

    public CharacterSheetOrganizerGUI(CharacterSheetOrganizer organizer) {
        this.organizer = organizer;
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab characterTab = new Tab();
        characterTab.setText("Characters");
        characterTab.setContent(createCharacterTabContent());

        Tab monsterTab = new Tab();
        monsterTab.setText("Monsters");
        monsterTab.setContent(createMonsterTabContent());

        tabPane.getTabs().addAll(characterTab, monsterTab);

        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Character Sheet Organizer");
        primaryStage.show();
    }

    private VBox createCharacterTabContent() {
        VBox vbox = new VBox();
        
        // Create a ListView to display all characters
        ListView<PlayerCharacter> characterListView = new ListView<PlayerCharacter>();
        characterListView.setItems(organizer.getCharacters());

        // Create a TextField for user to input search term and filter the character list
        TextField nameFilterField = new TextField();
        nameFilterField.setPromptText("Filter by name");
        nameFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            organizer.filterCharactersByName(newValue);
        });

        vbox.getChildren().addAll(nameFilterField, characterListView);

        return vbox;
    }

    private VBox createMonsterTabContent() {
        VBox vbox = new VBox();
        
        // Create a ListView to display all monsters
        ListView<Monster> monsterListView = new ListView<Monster>();
        monsterListView.setItems(organizer.getMonsters());

        // Create a TextField for user to input search term and filter the monster list
        TextField nameFilterField = new TextField();
        nameFilterField.setPromptText("Filter by name");
        nameFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            organizer.filterMonstersByName(newValue);
        });

        vbox.getChildren().addAll(nameFilterField, monsterListView);

        return vbox;
    }


    public static void main(String[] args) {
        CharacterSheetOrganizer organizer = new CharacterSheetOrganizer();
        launch(args);
    }
}
