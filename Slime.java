public class Slime extends Musuh {
    
    public Slime () {
        super("Slime Berlendir", 50);
    }

    @Override
    public void attackPlayer() {
        System.out.println(this.enemyName + " melompat dan menyiram cairan berlendir! Player -15 HP");
    }

    public void enemyVoice() {
        System.out.println("HIDUPPP JOKOWIII!!!!");
    }

}
