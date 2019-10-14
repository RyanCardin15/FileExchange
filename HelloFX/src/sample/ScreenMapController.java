package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenMapController {
    private HashMap<String, Pane> map = new HashMap<>();
    private Scene main;

    public ScreenMapController(Scene main) {
        this.main = main;
    }

    protected void addScene(String name, Pane pane){
        map.put(name, pane);
    }

    protected void removeScene(String name){
        map.remove(name);
    }

    protected void switchMap(String name){
        main.setRoot( map.get(name) );
    }
}
