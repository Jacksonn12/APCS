import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("VI"), 6);
        assertEquals(RomanToDecimal.romanToDecimal("MC"), 1100);
        assertEquals(RomanToDecimal.romanToDecimal("X"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("XLIV"), 44);
        assertEquals(RomanToDecimal.romanToDecimal("XXIII"), 23);
        assertEquals(RomanToDecimal.romanToDecimal("XXX"), 30);
        assertEquals(RomanToDecimal.romanToDecimal("C"), 100);
        assertEquals(RomanToDecimal.romanToDecimal("DI"), 501);
        assertEquals(RomanToDecimal.romanToDecimal("IXIXI"), 21);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("IVMC"), 1104);
        assertEquals(RomanToDecimal.romanToDecimal("IXDIX"), 520);
        assertEquals(RomanToDecimal.romanToDecimal("KLESJF"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("your mom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("batman"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("comp sci"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("X"), 11);
        assertNotEquals(RomanToDecimal.romanToDecimal("b"), 4);
    }
}