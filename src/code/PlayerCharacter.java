package code;

public class PlayerCharacter {
    private String name;
    private int level;
    private String classType;
    private int hitPoints;

    public PlayerCharacter(String name, int level, String classType, int hitPoints) {
        this.name = name;
        this.level = level;
        this.classType = classType;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

	public Object getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
}
