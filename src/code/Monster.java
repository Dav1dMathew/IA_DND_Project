package code;

public class Monster {
    private String name;
    private int hitPoints;
    private int attack;
    private int cr;

    public Monster(String name, int hitPoints, int attack, int cr) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.cr = cr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getcr() {
        return cr;
    }

    public void setcr(int cr) {
        this.cr = cr;
    }

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}