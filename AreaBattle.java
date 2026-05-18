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

            for (int i = 0; i < monsterWave.length; i++) {
                if (monsterWave[i].healtPoint > 0) {
                    System.out.println(
                            (i + 1) + ". " + monsterWave[i].enemyName + " (HP: " + monsterWave[i].healtPoint + ")");
                } else {
                    System.out.println((i + 1) + ". " + monsterWave[i].enemyName + " [TEWAS]");
                }
            }

            System.out.println("4. Kabur (Keluar)");
            System.out.print("Pilih Target Monster: ");

            try {
                int pilihTarget = input.nextInt();

                if (pilihTarget == 4) {
                    System.out.println("\nAnda melarikan diri dari pertarungan...");
                    isPlaying = false;
                    continue;
                }

                if (pilihTarget < 1 || pilihTarget > 3) {
                    System.out.println("Pilihan tidak valid! Anda membuang girilan.");
                    continue;
                }

                int indexMonster = pilihTarget - 1;

                if (monsterWave[indexMonster].healtPoint <= 0) {
                    throw new TargetDeadExc(
                            "Tindakan Ilegal: Anda tidak bisa menyerang monster yang sudah mati!");
                }

                System.out.print("Masukan kekuatan serangan anda (10-100): ");
                int power = input.nextInt();

                if (power < 10 || power > 100) {
                    throw new InvalidAttackExc(
                            "Tindakan Ilegal: Kekuatan serangan harus di antara 10 - 100!!");
                }

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                monsterWave[indexMonster].damageTaken(power);

                if (monsterWave[indexMonster].healtPoint <= 0) {
                    System.out.println("\n" + monsterWave[indexMonster].enemyName + " sudah dikalahkan!🤩");
                    if (monsterWave[indexMonster] instanceof CanLoot) {
                        CanLoot monsterLoot = (CanLoot) monsterWave[indexMonster];
                        monsterLoot.itemsLoot();
                    }
                }

            }

            catch (java.util.InputMismatchException e) {
                System.out.println("ERROR INPUT: Anda harus memasukan ANGKA!!");
                input.nextLine();
            }

            catch (TargetDeadExc e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());
            }

            catch (InvalidAttackExc e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());
            }

            catch (Exception e) {
                System.err.println("Terjadi kesalahan sistem: " + e.getMessage());
            }

            System.out.println("\n>>> GILIRAN MONSTER MEMBALAS <<<");

            for (int i = 0; i < monsterWave.length; i++) {
                if (monsterWave[i].healtPoint > 0) {
                    System.out.println();
                    Musuh activeMonster = monsterWave[i];
                    activeMonster.enemyVoice();

                    if (activeMonster instanceof CanFly) {
                        System.out.println(">> PERINGATAN SERANGAN UDARA TERDETEKSI");
                        CanFly flyingMonster = (CanFly) activeMonster;
                        flyingMonster.takeOff();
                        flyingMonster.airAttack();
                        System.out.println();
                    } else {
                        activeMonster.attackPlayer();
                    }
                } else {
                    System.out.println(monsterWave[i].enemyName + " sudah mati dan tidak bisa menyerang.");
                }
            }

        }

        boolean everyoneDead = true;
        for (int i = 0; i < monsterWave.length; i++) {
            if (monsterWave[i].healtPoint > 0) {
                everyoneDead = false;
                break;
            }
        }

        if (everyoneDead) {
            System.out.println("\nSELAMAT🥳🥳🥳! Anda telah menyapu bersih gelobang monster ini");
            isPlaying = false;
        }

        input.close();
        System.out.println("Permainan Berakhir, Sampai jumpa di pertualangan berikutnya..");

    }
}
