package gamblers.luck;

public class Enemy {

    private int HpGegner;
    private int AttackGegner;
    private int DefenceGegner;
    private int damageGegner;
    private int BossBuffActive;
    private int BossBuff;

    public Enemy() {
        this.HpGegner = 1;
        this.AttackGegner = 1;
        this.DefenceGegner = 0;
        this.BossBuffActive = 0;
        this.BossBuff = 0;
        this.damageGegner = this.AttackGegner + (this.BossBuffActive * this.BossBuff);
    }

    public int getHpGegner() { return HpGegner; }
    public void setHpGegner(int HpGegner) { this.HpGegner = HpGegner; }

    public int getAttackGegner() { return AttackGegner; }
    public void setAttackGegner(int AttackGegner) { this.AttackGegner = AttackGegner; }

    public int getDefenceGegner() { return DefenceGegner; }
    public void setDefenceGegner(int DefenceGegner) { this.DefenceGegner = DefenceGegner; }

    public int getDamageGegner() { return damageGegner; }
    public void setDamageGegner(int damageGegner) { this.damageGegner = damageGegner; }

    public int getBossBuffActive() { return BossBuffActive; }
    public void setBossBuffActive(int BossBuffActive) { this.BossBuffActive = BossBuffActive; }

    public int getBossBuff() { return BossBuff; }
    public void setBossBuff(int BossBuff) { this.BossBuff = BossBuff; }

    public void enemyAttack(Player player) {
        player.setHeart(player.getHeart() - this.damageGegner);
    }

    public void gegnerWürfel(int etage, int roomDifficulty, int roomNumber) {
        this.HpGegner = 6 * etage * roomDifficulty + 2 * roomNumber;
        System.out.printf("%nVor dir Erscheint ein Schwebender Würfel");
        int SeiteWürfel = (int)Math.floor(Math.random() * 5) + 1;
        this.AttackGegner = 5 + (etage * roomDifficulty) / 2 + SeiteWürfel / 2;
        System.out.printf("%nEr hat die Seite %d", SeiteWürfel);
    }

    public void gegnerBodyguard(int etage, int roomDifficulty, int roomNumber) {
        this.HpGegner = 18 * etage * roomDifficulty + 2 * roomNumber;
        this.AttackGegner = 2 + (etage * roomDifficulty) / 2;
        System.out.printf("%nVor dir Erscheint ein Bodyguard");
    }

    public void gegnerBlackjackKarten(int etage, int roomDifficulty, int roomNumber) {
        this.HpGegner = 9 * etage * roomDifficulty + 2 * roomNumber;
        this.AttackGegner = 4 + (etage * roomDifficulty) / 2;
        this.DefenceGegner = (int)Math.floor(Math.random() * 4) + 1;
        System.out.printf("%nVor dir Erscheint ein Deck Blackjack - Karten");
    }

    public void gegnerSlotMaschine(int etage, int roomDifficulty, int roomNumber) {
        this.HpGegner = 10 * etage * roomDifficulty + 2 * roomNumber;
        this.AttackGegner = 3 + (etage * roomDifficulty) / 2;
        System.out.printf("%nVor dir Erscheint eine Slot - Maschine");
        int OneHitChance = (int)Math.floor(Math.random() * 9) + 1;
        if (OneHitChance == 1) {
            this.HpGegner = 1;
        }
    }

} // KLASSE ENDET HIER