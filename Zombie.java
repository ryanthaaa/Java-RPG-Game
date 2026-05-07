public class Zombie extends Musuh{
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
}
