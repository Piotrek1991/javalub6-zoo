package multiplicationtest;

import org.junit.Test;
import pl.sdacademy.multiplication.Dollar;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest {

    @Test
    public void testMutliplication()
    {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

    }

    @Test
    public void testEquality(){
        assertTrue( new Dollar(5).equals(new Dollar(5)));
        assertFalse( new Dollar(5).equals(new Dollar(6)));
    }

    @Test
    public void testFrancMutliplication()
    {
        Franc five = new Franc(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

    }


}
