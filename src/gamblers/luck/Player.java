package gamblers.luck;

import java.util.Scanner;

public class Player {

    private int heart;
    private int coins;
    private int coinCap;
    private int heartCap;
    private int attackPlayer;
    private int combatTurn;
    private int Item;
    private int coinMultiplierActual;
    private int coinMultiplier;
    private int coinDamageMultiplier;
    private int HeavyAttackMultiplier;
    private int HeavyAttack;
    private int HeavyActive;
    private int PaperCut;
    private int PaperCutMultiplier;
    private int CraneActive;
    private int damagePlayer;

    public Player() {
        this.heart = 20;
        this.coins = 1;
        this.coinCap = 100;
        this.attackPlayer = 5;
        this.combatTurn = 1;
        this.Item = 0;
        this.coinMultiplierActual = 1;
        this.coinMultiplier = 1;
        this.coinDamageMultiplier = 1;
        this.HeavyAttackMultiplier = 2;
        this.HeavyAttack = attackPlayer * 2;
        this.HeavyActive = 0;
        this.PaperCut = 0;
        this.PaperCutMultiplier = 0;
        this.CraneActive = 0;
        this.damagePlayer = 0;
        this.heartCap = 20;
    }

    public int getHeart() { return heart; }
    public void setHeart(int heart) { this.heart = heart; }

    public int getCoins() { return coins; }
    public void setCoins(int coins) { this.coins = coins; }

    public int getCoinCap() { return coinCap; }
    public void setCoinCap(int coinCap) { this.coinCap = coinCap; }

    public int getAttackPlayer() { return attackPlayer; }
    public void setAttackPlayer(int attackPlayer) { this.attackPlayer = attackPlayer; }

    public int getDamagePlayer() { return damagePlayer; }
    public void setDamagePlayer(int damagePlayer) { this.damagePlayer = damagePlayer; }

    public void coinSicherung() {
        if (this.coins < 0) {
            for (int pain = 1; pain <= 3; pain++) {
                --this.heart;
            }
            this.coins = 1;
        }
        coinGrenze();
    }

    public void coinGrenze() {
        if (this.coins > this.coinCap) {
            this.coins = this.coinCap;
        }
    }

    public void heartSafe(Game game) {
        if (this.heart <= 0) {
            this.heart = 0;
            game.GameOver();
            game.setGameRunning(2);
        }
    }
    public void statBlockAnzeigen() {
        System.out.printf("%n");
        System.out.printf("%nDu hast %d Münzen", this.coins);
        System.out.printf("%nDu hast noch %d Herzen", this.heart);
        System.out.printf("%nEs ist die %d Runde", this.combatTurn);
    }

    public void playerHeavyAttack() {
        this.HeavyActive = 1;
        this.coins = this.coins - 3;
    }

    public void playerDamage() {
        this.damagePlayer =
            (this.attackPlayer + (this.HeavyActive * this.HeavyAttack * this.HeavyAttackMultiplier)
            + (this.coinDamageMultiplier * this.coins)
            + (this.CraneActive * (this.attackPlayer * this.PaperCutMultiplier)));
    }

    public void playerAttack(Scanner scanner, Enemy enemy) {
        System.out.printf("%nWähle Attackentyp. %n(1 => Normal/2 => Schwer) %n");
        int antwort = scanner.nextInt();
        if (antwort == 2) {
            playerHeavyAttack();
            playerDamage();
            enemy.setHpGegner(enemy.getHpGegner() - this.damagePlayer);
        } else if (antwort == 1) {
            this.HeavyActive = 0;
            playerDamage();
            enemy.setHpGegner(enemy.getHpGegner() - this.damagePlayer);
        } else {
            System.out.printf("%nDas war keine Gültige Eingabe!");
        }
    }

} // KLASSE ENDET HIER
