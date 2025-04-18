package uno_gui;

public class PlayerConfig {
    private String name;
    private boolean isHuman;
    private String difficulty;
    
    public PlayerConfig(String name, boolean isHuman, String difficulty) {
        this.name = name;
        this.isHuman = isHuman;
        this.difficulty = difficulty;
    }
    
    // Getters
    public String getName() { return name; }
    public boolean isHuman() { return isHuman; }
    public String getDifficulty() { return difficulty; }
}