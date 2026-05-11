public class Dragon extends Musuh implements CanFly {

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

    public void takeOff() {
        System.out.println(this.enemyName + " terbang tinggi! Sulit diserang.");
    }

    public void airAttack() {
        System.out.println(this.enemyName + " menyemburkan badai api! Pemain -80 HP.");
    }

}
