package deqo.mkei.projetbowling20182019;

public class BowlingClass {
    int[] lanceesTotal;
    int lanceepresent;

    public BowlingClass() {
         this.lanceesTotal = new int[21];

    }

    public void lancee(int p)
    {
        lanceesTotal[lanceepresent++] = p;
    }


    private boolean isStrike(int frame) {
        return lanceesTotal[frame] == 10;
    }

    private boolean isSpare(int frame) {
        return sumOfRolls(frame) == 10;
    }

    private int strikeBonus(int frame) {
        return sumOfRolls(frame+1);
    }

    private int spareBonus(int frame) {
        return lanceesTotal[frame+2];
    }

    private int sumOfRolls(int frame) {
        return lanceesTotal[frame] + lanceesTotal[frame+1];
    }

    public int score()
    {
        int score = 0;
        int frame = 0;

        for (int i = 0; i < 10; i++) {
            if (isStrike(frame)) {
                score += 10 + strikeBonus(frame);
                frame++;
            } else if (isSpare(frame)) {
                score += 10 + spareBonus(frame);
                frame += 2;
            } else {
                score += sumOfRolls(frame);
                frame += 2;
            }
        }

        return score;
    }



}
