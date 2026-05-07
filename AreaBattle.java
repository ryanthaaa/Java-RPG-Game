import java.util.Scanner;

public class AreaBattle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Musuh[] monsterWave = new Musuh[3];
        monsterWave[0] = new Slime();
        monsterWave[1] = new Dragon();
        monsterWave[2] = new Zombie();

        System.out.println("<-------------------------------------->");
        System.out.println("     WELCOME TO AREA BATTLE RPG 2D");
        System.out.println("<-------------------------------------->");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("\n--- STATUS MONSTER ---");

            for ( int i = 0; i < monsterWave.length; i++) {
                System.out.println((i + 1) + ". " + monsterWave[i].enemyName + " (HP: " + monsterWave[i].healtPoint + ")");
            }
            System.out.println("4. Kabur (Keluar)");
            System.out.print("Pilih Target Monster: ");
            int pilihTarget = input.nextInt();

            if ( pilihTarget == 4 ) {
                System.out.println("\nAnda melarikan diri dari pertarungan...");
                isPlaying = false;
                continue;
            }

            if ( pilihTarget < 1 || pilihTarget > 3) {
                System.out.println("Pilihan tidak valid! Anda membuang girilan.");
            } else {
                System.out.print("Masukan kekuatan serangan anda (10-100): ");
                int power = input.nextInt();

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                int indexMonster = pilihTarget - 1;
                monsterWave[indexMonster].damageTaken(power);
            }

            System.out.println("\n>>> GILIRAN MONSTER MEMBALAS <<<");

            for ( int i = 0; i < monsterWave.length; i++) {
                if ( monsterWave[i].healtPoint > 0) {
                    monsterWave[i].enemyVoice();
                    monsterWave[i].attackPlayer();
                } else {
                    System.out.println(monsterWave[i].enemyName + " sudah mati dan tidak bisa menyerang.");
                }
                System.out.println("<----------------------------------->");
            }
           
        }

        input.close();
        System.out.println("Permainan Berakhir " + " Sampai jumpa di pertualangan berikutnya..");

    }
}
