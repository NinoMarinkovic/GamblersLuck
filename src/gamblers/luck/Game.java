package gamblers.luck;

import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private int gameRunning;
    private int Etage;
    private int roomNumber;
    private int RoomDifficulty;
    private int FightWave;
    private int LootMultiplier;
    private int LootComplete;
    private int VodkaActive;
    private int BloodyMaryActive;
    private int DealerDefeated;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.gameRunning = 0;
        this.Etage = 1;
        this.roomNumber = 0;
        this.RoomDifficulty = 1;
        this.FightWave = 1;
        this.LootMultiplier = 1;
        this.LootComplete = 0;
        this.VodkaActive = 0;
        this.BloodyMaryActive = 0;
        this.DealerDefeated = 0;
    }

    public int getGameRunning() { return gameRunning; }
    public void setGameRunning(int gameRunning) { this.gameRunning = gameRunning; }

    public int getEtage() { return Etage; }
    public void setEtage(int Etage) { this.Etage = Etage; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public int getRoomDifficulty() { return RoomDifficulty; }
    public void setRoomDifficulty(int RoomDifficulty) { this.RoomDifficulty = RoomDifficulty; }

    public int getFightWave() { return FightWave; }
    public void setFightWave(int FightWave) { this.FightWave = FightWave; }

    public int getLootMultiplier() { return LootMultiplier; }
    public void setLootMultiplier(int LootMultiplier) { this.LootMultiplier = LootMultiplier; }

    public int getLootComplete() { return LootComplete; }
    public void setLootComplete(int LootComplete) { this.LootComplete = LootComplete; }

    public int getVodkaActive() { return VodkaActive; }
    public void setVodkaActive(int VodkaActive) { this.VodkaActive = VodkaActive; }

    public int getBloodyMaryActive() { return BloodyMaryActive; }
    public void setBloodyMaryActive(int BloodyMaryActive) { this.BloodyMaryActive = BloodyMaryActive; }

    public int getDealerDefeated() { return DealerDefeated; }
    public void setDealerDefeated(int DealerDefeated) { this.DealerDefeated = DealerDefeated; }

    public void begruessung() {
        System.out.println("Willst du ein Spiel spielen? (ja/nein)");
        String wanna = scanner.nextLine();
        if (wanna.equals("ja")) {
            System.out.println("Gut dass du darauf vorbereitet bist\nmal sehen wie lange du es durchhälst...");
            this.gameRunning = 1;
        } else if (wanna.equals("nein")) {
            System.out.println("Zu schade,\ndu kommst hier sonst aber nicht raus ...");
            this.gameRunning = 1;
        } else {
            System.out.println("Das war keine option.\nAber egal, du währst so und so nicht rausgekommen...");
            this.gameRunning = 1;
        }
        System.out.println("\nDu wachst in einem dunklen Raum auf...");
        System.out.println("Eine robotisch klingende Stimme erklärt dir folgendes:");
        System.out.println("'Ihr habt 2 Möglichkeiten, entweder ihr bezahlt, oder ihr sterbt!'");
        System.out.println("Vor dir öffnet sich ein Gang mit 2 Türen...");
    }

    public void spielEndeGut() {
        System.out.printf("%nDu hast Kinpin & alle seine Schergen Besiegt.");
        System.out.printf("%nWährend du nicht Schaust, öffnet sich ein Rotes Portal unter ihm...");
        System.out.printf("%nEine Scharlachrote Hand kommt hinaus & zieht ihn mit hinein...");
        System.out.printf("%nVielen dank fürs Spielen!");
    }

    public void spielEndeSchlecht() {
        System.out.printf("%nKinpin reisst dich von deinem Körper...");
        System.out.printf("%nDu siehst wie sich dein Körper in eine Blackjack - Karte verwandelt...");
        System.out.printf("%nVielen dank fürs Spielen!");
    }

    public void etagen() {
        this.Etage++;
        if (this.Etage == 2) {
            System.out.printf("%nDu betretest den Roten Teppich");
            System.out.printf("%nDu fühlst dass die Gegner stärker geworden sind...");
        } else if (this.Etage == 3) {
            System.out.printf("%nDu betretest die Spielhalle");
            System.out.printf("%nDu fühlst dass die Gegner stärker geworden sind...");
        } else if (this.Etage == 4) {
            System.out.printf("%nDu betretest den VIP Tisch");
            System.out.printf("%nDu fühlst dass die Gegner stärker geworden sind...");
        } else if (this.Etage == 5) {
            System.out.printf("%nDu betretest das Theater");
            System.out.printf("%nDu fühlst dass die Gegner stärker geworden sind...");
        } else if (this.Etage == 6) {
            System.out.printf("%nDu betretest die VIP - Lounge");
            System.out.printf("%nDu fühlst dass die Gegner stärker geworden sind...");
        } else if (this.Etage == 7) {
            System.out.printf("%nDu betretst den King's Court");
            System.out.printf("%nDie letzte Etage...");
        }
    }

    public void loot(Player player) {
        int loot = (int)Math.floor(Math.random() * 9) + 1;
        this.LootComplete = loot * this.LootMultiplier;
        player.setCoins(player.getCoins() + this.LootComplete);
        System.out.printf("%nDu findest %d Münzen!", this.LootComplete);
        this.LootComplete = 0;
    }

    public void lootRoom(Player player) {
        int antwort = 0;
        System.out.printf("%nDu betrittst einen Raum ohne sichtbare Gefahr...");
        while (!((antwort == 1) || (antwort == 2))) {
            System.out.printf("%nWillst du dich umsehen? (1 => ja/2 => nein)");
            antwort = scanner.nextInt();
            if (antwort == 1) {
                int LootChance = (int)Math.floor(Math.random() * 9) + 1;
                if (LootChance >= 3) {
                    loot(player);
                } else {
                    player.setHeart(player.getHeart() - 1);
                    System.out.printf("%nDu hast dich an einem Blatt Papier Geschnitten!");
                }
            } else if (antwort == 2) {
                System.out.printf("%nDu gehst in den nächsten Raum...");
            } else {
                System.out.printf("%nbitte gib eine richtige Antwort!");
            }
        }
    }

    public void npcHausmeister(Player player) {
        System.out.printf("%n(Hausmeister)=> Willst du wetten?...");
        System.out.printf("%n(1 => ja/2 => nein)");
        int antwort = scanner.nextInt();
        if (antwort == 1) {
            int Bet = (int)Math.floor(Math.random() * 4) + 1;
            if (Bet == 1 && this.roomNumber >= 8) {
                player.setCoins(player.getCoins() + 25);
                System.out.printf("%n(Hausmeister)=> Tja, wahr wohl zu leicht...");
            } else if (Bet == 2 && this.roomNumber >= 16) {
                player.setCoins(player.getCoins() + 50);
                System.out.printf("%n(Hausmeister)=> Tja, wahr wohl zu leicht...");
            } else if (Bet == 3 && this.roomNumber >= 24) {
                player.setCoins(player.getCoins() + 75);
                System.out.printf("%n(Hausmeister)=> Tja, hätte ich nicht gedacht...");
            } else if (Bet == 4 && this.roomNumber >= 40) {
                player.setCoins(player.getCoins() + 100);
                System.out.printf("%n(Hausmeister)=> Das haut mich wirklich aus den Latschen...");
            }
        } else {
            System.out.printf("%n(Hausmeister)=> Hau ab!");
        }
    }

    public void npcBarkeeper(Player player) {
        System.out.printf("%n(Barkeeper)=> Willst du einen Drink? Kostet nur 10 Münzen...");
        System.out.printf("%n(1 => ja/2 => nein)%n");
        int antwort = scanner.nextInt();
        if (antwort == 1) {
            player.setCoins(player.getCoins() - 10);
            int DrinkArt = (int)Math.floor(Math.random() * 4) + 1;
            if (DrinkArt == 1) {
                System.out.printf("%n(Barkeeper)=> Ein Bier...");
                System.out.printf("%nDas Bier sieht etwas ranzig aus. Trinken? (1 => ja/2 => nein)%n");
                int antwortZwei = scanner.nextInt();
                if (antwortZwei == 2) {
                    player.setCoins(player.getCoins() + 15);
                    System.out.printf("%nDu bekommst 15 Münzen zurück");
                }
            } else if (DrinkArt == 2) {
                System.out.printf("%n(Barkeeper)=> Einen Shot Whiskey...");
            } else if (DrinkArt == 3) {
                System.out.printf("%n(Barkeeper)=> Einen Vodka...");
                this.VodkaActive = 1;
            } else if (DrinkArt == 4) {
                System.out.printf("%n(Barkeeper)=> Ein Bloody Mary...");
                this.BloodyMaryActive = 1;
            }
        } else {
            System.out.printf("%n(Barkeeper)=> Viel Glück...");
        }
    }

    public void npcCroupier() {
        System.out.printf("%n(Croupier)=> B-Brauchst du Hilfe mit Items?");
        System.out.printf("%n(1 => ja/2 => nein)%n");
        int antwort = scanner.nextInt();
        if (antwort == 1) {
            System.out.printf("%n(1=>Coinbeutel/2=>Billardkugel/3=>Zufallswürfel/4=>Zigarre/5=>PockerChips/6=>Papier-Kranich)");
            int antwortZwei = scanner.nextInt();
            if (antwortZwei == 1) System.out.printf("%n(Croupier)=> Erhöht das Münzenlimit um 100...");
            else if (antwortZwei == 2) System.out.printf("%n(Croupier)=> 8 Münzen für noch einen Zug...");
            else if (antwortZwei == 3) System.out.printf("%n(Croupier)=> 50/50 Schaden x10 oder 5 Herzen Schaden...");
            else if (antwortZwei == 4) System.out.printf("%n(Croupier)=> Gibt 3 Leben zurück...");
            else if (antwortZwei == 5) System.out.printf("%n(Croupier)=> Setzt Verteidigung auf 0...");
            else if (antwortZwei == 6) System.out.printf("%n(Croupier)=> Schaden steigt mit jeder Papierverletzung...");
        } else {
            System.out.printf("%n(Croupier)=> ok...");
        }
    }

    public void npcHändler(Player player) {
        int Stock = (int)Math.floor(Math.random() * 6) + 1;
        int CostItem = 10 + (this.Etage * this.roomNumber) / this.RoomDifficulty;
        System.out.printf("%n(Händler)=> Willst du ein Item kaufen? Nur %d Münzen", CostItem);
        System.out.printf("%n(1 => ja/2 => nein)%n");
        int antwort = scanner.nextInt();
        if (antwort == 1) {
            player.setCoins(player.getCoins() - CostItem);
            System.out.printf("%nDu bekommst Item %d", Stock);
        } else {
            System.out.printf("%n(Händler)=> Nagut, dein Verlust...");
        }
    }

    public void npcSpawn(Player player) {
        int npcType = (int)Math.floor(Math.random() * 4) + 1;
        if (npcType == 1) {
            System.out.printf("%nEin mysteriöser Händler steht vor dir...");
            npcHändler(player);
        } else if (npcType == 2) {
            System.out.printf("%nEin Croupier scheint dir helfen zu wollen...");
            npcCroupier();
        } else if (npcType == 3) {
            System.out.printf("%nDu betrittst eine heruntergekommene Bar...");
            npcBarkeeper(player);
        } else if (npcType == 4) {
            System.out.printf("%nDer Hausmeister möchte mit dir reden...");
            npcHausmeister(player);
        }
    }

    public void fight(Player player, Enemy enemy) {
        while (enemy.getHpGegner() > 0) {
            player.coinSicherung();
            player.heartSafe(this);
            if (player.getHeart() <= 0) break;
            player.statBlockAnzeigen();
            player.playerAttack(scanner, enemy);
            player.coinSicherung();
            enemy.enemyAttack(player);
            if (player.getHeart() <= 0) {
                player.heartSafe(this);
                break;
            }
        }
    }

    public void gegnerSpawn(Player player, Enemy enemy) {
        int typeGegner = (int)Math.floor(Math.random() * 4) + 1;
        this.FightWave = (int)Math.floor(Math.random() * 8) + 1;
        while (this.FightWave > 0) {
            if (typeGegner == 1) enemy.gegnerWürfel(this.Etage, this.RoomDifficulty, this.roomNumber);
            else if (typeGegner == 2) enemy.gegnerBodyguard(this.Etage, this.RoomDifficulty, this.roomNumber);
            else if (typeGegner == 3) enemy.gegnerBlackjackKarten(this.Etage, this.RoomDifficulty, this.roomNumber);
            else enemy.gegnerSlotMaschine(this.Etage, this.RoomDifficulty, this.roomNumber);
            fight(player, enemy);
            --this.FightWave;
            loot(player);
        }
    }

    public void raumLaden(Player player, Enemy enemy) {
        this.roomNumber++;
        int TreppeChance = (int)Math.floor(Math.random() * 10) + 1;
        int AmbushChance = (int)Math.floor(Math.random() * 10) + 1;
        int npcChance    = (int)Math.floor(Math.random() * 10) + 1;
        if (TreppeChance >= 9) {
            System.out.printf("%nDu siehst eine Treppe...");
            etagen();
        } else if (AmbushChance >= 4) {
            gegnerSpawn(player, enemy);
        } else if (npcChance >= 7) {
            npcSpawn(player);
        } else {
            lootRoom(player);
        }
    }
    
    public static void GameOver() {
		System.out.printf("%n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡤⠴⡿⠓⠶⠾⠿⠶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                                                                                                    ⣀⣀⠀⠀⢀⣤⣤⣤⣶⣶⣷⣤⣀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡖⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣶⣶⠀⠀⠀⠀⣠⣾⣿⣿⡇⠀⣿⣿⣿⣿⠿⠛⠉⠉\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⣤⣤⣿⠖⠻⠷⡶⣮⡙⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀              ⠀    ⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠀⠀⠀⠀⠀⢀⣿⣿⣶⡀⠀⠀⠀⠀⠀⣾⣿⣿⣿⡄⠀⢀⣴⣿⣿⣿⣿⠁⢸⣿⣿⣿⣀⣤⡀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠉⠀⠀⠀⠀⠀⠀⠀⢀⣚⡯⠉⠀⠀⠀⠀⠀⠀⠀⠉⠛⢷⣄⣀⣀⣀⣀⣠⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⣼⣿⣿⣿⣧⠀⠀⠀⠀⢰⣿⣿⣿⣿⣇⣠⣿⣿⣿⣿⣿⡏⢠⣿⣿⣿⣿⣿⡿⠗⠂\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠟⠀⠀⠀⠀⠀⠀⠀⢀⣰⠿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠉⠉⠛⠿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⣰⣾⣿⣿⠟⠛⠉⠉⠉⠉⠋⠀⠀⠀⣰⣿⣿⣿⣿⣿⣇⣠⣤⣤⣿⣿⣿⢿⣿⣿⣿⣿⢿⣿⣿⡿⠀⣼⣿⣿⡟⠉⠁⢀⣀⡄\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⣾⣉⠳⠄⠀⠀⠀⠀⠀⠀⠀⠉⠻⢶⣄⠀⠀⠀⠀⠀⠀⠀⠀         ⠀⢀⣾⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣴⣿⣿⣿⣿⡿⣿⣿⣿⡏⠈⢿⣿⣿⠏⣾⣿⣿⠃⢠⣿⣿⣿⣶⣶⣿⣿⣿⡷⠦\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣅⡀⠉⠁⠀⠀⠀⠀⢠⣴⣤⡀⠀⠀⠀⠙⢷⣄⡀⠀⠀⠀⠀⠀       ⢠⣾⣿⡿⠀⠀⠀⣀⣠⣴⣶⣿⣿⡷⠀⣠⣿⣿⣿⣿⡿⠟⣿⣿⣿⣠⣿⣿⣿⠀⠀⠀⠀⠁⢸⣿⣿⡏⠀⣼⣿⣿⣿⠿⠛⠛⠉⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣳⣾⠿⠁⠀⠀⠀⠀⠀⠀⠻⠿⠿⠟⠀⠀⠀⠀⠀⠉⠻⣦⠀⠀⠀⠀       ⢸⣿⣿⠣⣴⣾⣿⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⠋⠁⠀⠀⠸⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠸⠿⠿⠀⠀⠛⠛⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠖⠋⠁⢀⣼⡧⠀⠀⠀⠀⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢶⡿⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣠⣤⣴⡒⠒⠶⣤⣿⠀⠀⠀⠀      ⠸⣿⣿⣆⣉⣻⣭⣿⣿⣿⡿⠋⠀⠀⢿⣿⡿⠁⠀⠀⠀⠀⠀⠹⠟⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠏⠁⠀⢀⣠⣼⡟⠀⠀⠀⠀⠀⠀⠀⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣤⠀⠀⠀⠤⠖⠚⠉⠉⣀⡠⠤⠒⢲⡆⠁⢀⡴⢩⡿⢤⡀⠀⠀     ⠀⠙⠿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢀⣴⠋⠀⢀⣴⠞⠋⠉⢸⡇⠀⠀⠀⠀⠀⠀⠀⢽⣟⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠴⠋⠀⠀⠀⠀⠀⢀⡠⠖⠋⠁⢀⣤⣾⣥⠤⠴⠛⠋⠉⠙⣆⠉⠢⡄ ⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⣀⣤⣤⣶⣶⣶⣶⣦⣄⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⣠⠟⠁⢠⡾⠋⠁⠀⠀⠀⣼⡇⠀⡀⠀⠀⠀⠀⠀⢰⣿⣗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡔⠋⠀⠀⠀⢠⠞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠈⢆⠀⠈   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⢀⣷⠄⣤⣤⣤⣤⣶⣾⣷⣴⣿⣿⣿⣿⠿⠿⠛⣻⣿⣿⣷⡄\r\n"
				+ "⠀⠀⠀⠀⣴⠋⢀⡴⠋⠀⠀⠀⠀⠀⠀⣿⠿⢛⣣⣄⣀⡀⠀⠀⠀⢨⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢠⣄⣴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣄⠀⣶⣶⣤⡀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠋⢠⣿⣿⣿⠿⠛⠋⠉⠛⣿⣿⣿⠏⢀⣤⣾⣿⣿⡿⠋⠀\r\n"
				+ "⠀⠀⠀⣼⠇⢀⡟⠁⠀⠀⠀⠀⠀⠀⠰⣿⠀⠈⠈⢻⣟⠉⠉⠉⠉⠉⠛⠻⢶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⢠⣶⠏⢸⠛⠛⠒⢲⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⠓⢹⣿⣿⣷⠀⠀⠀⠀⢀⣶⣿⡿⠁⠀⣾⣿⣿⣟⣠⣤⠀⠀⢸⣿⣿⣿⣾⣿⣿⣿⡟⠋⠀⠀⠀\r\n"
				+ "⠀⠀⢠⡟⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⢰⡟⠀⠀⠀⡀⣿⣷⣄⠀⠀⠀⠀⠀⠀⠙⠿⣿⣀⢀⣀⣤⣄⠀⠀⠀⠀⣀⣀⣾⣿⣿⣄⣠⣏⠀⠀⠀⠺⣯⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⣠⣾⣿⣿⡿⠛⠉⠸⣿⣦⡈⣿⣿⣿⡇⠀⠀⣰⣿⣿⡿⠁⠀⢸⣿⣿⣿⣿⣿⠿⠷⢀⣿⣿⣿⣿⡿⠛⣿⣿⣿⡀⠀⠀⠀\r\n"
				+ "⠀⠀⣸⡇⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠘⣷⣤⢹⣄⢻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠻⣯⣤⣴⣦⣾⠷⣿⡋⠀⠀⠈⠉⢹⣿⣦⣿⠛⢷⣬⣿⠁⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⢀⣼⣿⣿⡿⠋⠀⠀⠀⠀⣿⣿⣧⠘⣿⣿⣿⡀⣼⣿⣿⡟⠀⠀⢀⣿⣿⣿⠋⠁⠀⣀⣀⣼⣿⣿⡟⠁⠀⠀⠘⣿⣿⣧⠀⠀⠀\r\n"
				+ "⠀⠀⣿⡇⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⡏⠙⢿⠟⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣯⡀⠀⠀⠈⢿⡷⣦⡀⠀⢸⠀⠉⠀⠀⠀⢀⣀⣀⠀          ⠀⠀⠀⠀         ⣼⣿⣿⡟⠀⠀⠀⠀⠀⣠⣿⣿⣿⠀⢹⣿⣿⣿⣿⣿⡟⠀⠀⠀⣼⣿⣿⣷⣶⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠸⣿⣿⡆⠀⠀\r\n"
				+ "⠀⠀⢻⡇⢠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡏⠀⣇⠘⡆⢳⣬⣿⡄⠀⠀⠀⠀⠀⠀⠀⡏⠀⠀⢳⡀⣀⡤⠤⡄⠀⠀⠀⠀⠀  ⢹⣿⣿⣇⠀⠀⢀⣠⣴⣿⣿⣿⡿⠀⠈⣿⣿⣿⣿⡟⠀⠀⠀⢰⣿⣿⣿⠿⠟⠛⠉⠁⠸⢿⡟⠀⠀⠀⠀⠀⠀⠀⠘⠋⠁⠀⠀\r\n"
				+ "⠀⠀⣸⡇⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⡾⢻⣶⠿⣶⡏⠉⠀⠀⠀⠀⠀⠀⠀⠀⢧⡀⠀⠀⠛⠁⠀⠀⠸⡀  ⠀⠀⠀⠀⠈⢻⣿⣿⣿⣾⣿⣿⣿⣿⣿⠟⠁⠀⠀⠸⣿⣿⡿⠁⠀⠀⠀⠈⠙⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⣿⠃⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠁⠀⠉⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⡀⠀⠀⠀⠀⠀⡰⠃⠀      ⠀⠀   ⠀⠉⠛⠿⠿⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⣼⣏⡼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢆⣀⣠⠔⠊⠁⠀⠀\r\n"
				+ "⣼⣿⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀");
		System.out.printf("%n");
		System.out.printf("%n");
		System.out.printf("%n");
		System.out.printf("%n⠀⠀⠀⠀⠀⢀⣤⠤⠤⠤⠤⠤⠤⠤⠤⠤⠤⢤⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢀⡼⠋⠀⣀⠄⡂⠍⣀⣒⣒⠂⠀⠬⠤⠤⠬⠍⠉⠝⠲⣄⡀⠀⠀\r\n"
				+ "⠀⠀⠀⢀⡾⠁⠀⠊⢔⠕⠈⣀⣀⡀⠈⠆⠀⠀⠀⡍⠁⠀⠁⢂⠀⠈⣷⠀⠀\r\n"
				+ "⠀⠀⣠⣾⠥⠀⠀⣠⢠⣞⣿⣿⣿⣉⠳⣄⠀⠀⣀⣤⣶⣶⣶⡄⠀⠀⣘⢦⡀\r\n"
				+ "⢀⡞⡍⣠⠞⢋⡛⠶⠤⣤⠴⠚⠀⠈⠙⠁⠀⠀⢹⡏⠁⠀⣀⣠⠤⢤⡕⠱⣷\r\n"
				+ "⠘⡇⠇⣯⠤⢾⡙⠲⢤⣀⡀⠤⠀⢲⡖⣂⣀⠀⠀⢙⣶⣄⠈⠉⣸⡄⠠⣠⡿\r\n"
				+ "⠀⠹⣜⡪⠀⠈⢷⣦⣬⣏⠉⠛⠲⣮⣧⣁⣀⣀⠶⠞⢁⣀⣨⢶⢿⣧⠉⡼⠁\r\n"
				+ "⠀⠀⠈⢷⡀⠀⠀⠳⣌⡟⠻⠷⣶⣧⣀⣀⣹⣉⣉⣿⣉⣉⣇⣼⣾⣿⠀⡇⠀\r\n"
				+ "⠀⠀⠀⠈⢳⡄⠀⠀⠘⠳⣄⡀⡼⠈⠉⠛⡿⠿⠿⡿⠿⣿⢿⣿⣿⡇⠀⡇⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠙⢦⣕⠠⣒⠌⡙⠓⠶⠤⣤⣧⣀⣸⣇⣴⣧⠾⠾⠋⠀⠀⡇⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠈⠙⠶⣭⣒⠩⠖⢠⣤⠄⠀⠀⠀⠀⠀⠠⠔⠁⡰⠀⣧⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠲⢤⣀⣀⠉⠉⠀⠀⠀⠀⠀⠁⠀⣠⠏⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠛⠒⠲⠶⠤⠴⠒⠚⠁⠀⠀");
	}
	//Daten, Mechaniken & AI vom Würfel (Geg. Typ 1) '=fertig='
    
    public static void main(String[] args) {
        Game game   = new Game();
        Player player = new Player();
        Enemy enemy  = new Enemy();
        game.begruessung();
        game.etagen();
        while (game.getGameRunning() == 1 && player.getHeart() > 0) {
            game.raumLaden(player, enemy);
        }
        if (game.getGameRunning() == 2) {
            game.spielEndeSchlecht();
        } else if (game.getGameRunning() == 3) {
            game.spielEndeGut();
        }
        game.scanner.close();
    }

} // KLASSE ENDET HIER