public class Dragon extends Musuh {

    public Dragon () {
        super("Black Fire Dragon", 500);
    }

    @Override
    public void attackPlayer() {
        System.out.println(this.enemyName + " menyemburkan nafas api dari udara! Player -50 HP");
    }

    public void enemyVoice() {
        System.out.println("Rawrrrrrrrrsrrr!!!!");
    }
}
