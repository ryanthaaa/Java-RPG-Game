public abstract class Musuh {
    protected String enemyName;
    protected int healtPoint;

    // Construktor
    public Musuh (String enemyName, int healtPoint) {
        this.enemyName = enemyName;
        this.healtPoint = healtPoint;
    }

    // Method
    public void damageTaken(int damage) {
        this.healtPoint -= damage;
        System.out.println(this.enemyName + " terkena serangan biasa. Sisa HP: " + this.healtPoint);
    }

    public abstract void attackPlayer();
    public abstract void enemyVoice();

}