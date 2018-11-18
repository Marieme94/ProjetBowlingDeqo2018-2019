package deqo.mkei.projetbowling20182019;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingClassTest {

    private BowlingClass g;

    void rollMany(int n, int pins, BowlingClass g) {
        for (int i = 0; i < n; i++) g.lancee(pins);
    }

    @Before
    public void setUp() {
        this.g = new BowlingClass();
    }

    @Test
    public void testZero() {
        rollMany(20, 0, g);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1, g);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() {
        g.lancee(5);
        g.lancee(5);
        g.lancee(3);
        rollMany(17, 0, g);
        assertEquals(16, g.score());
    }

    @Test
    public void testOneStrike() {
        g.lancee(10);
        g.lancee(3);
        g.lancee(4);
        rollMany(16, 0, g);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10, g);
        assertEquals(300, g.score());
    }
}