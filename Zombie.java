public class Zombie extends Musuh implements CanLoot {
    public Zombie() {
        super("Zombie Kalcer", 200);
    }

    @Override
    public void attackPlayer() {
        System.out.println(this.enemyName + " mengejar dan menggigit! Player -45 HP");
    }

    public void enemyVoice() {
        System.out.println("Hoekkkk CUIHHHHHH!!!!");
    }

    public void itemsLoot() {
        System.out.println(this.enemyName + " menjatuhkan sebuah items! Anda mendapatkan LENDIRR SSR🤢🤮");
    }
}
