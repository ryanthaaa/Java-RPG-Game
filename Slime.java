public class Slime extends Musuh implements CanLoot {
    
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

    public void itemsLoot() {
        System.out.println(this.enemyName + " menjatuhkan sebuah items! Anda mendapatkan Items MUWANI SSR💦💦");
    }

}
