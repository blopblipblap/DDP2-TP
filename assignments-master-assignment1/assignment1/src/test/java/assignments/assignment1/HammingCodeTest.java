package assignments.assignment1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HammingCodeTest {
    @Test public void testEncodeSample1() {
        assertEquals(HammingCode.encode("10011010"), "011100101010");
    }

    @Test public void testEncodeSample2() {
        assertEquals(HammingCode.encode("1011001"), "10100111001");
    }

    @Test public void testDecodeSample1() {
        assertEquals(HammingCode.decode("011100101110"), "10011010");
    }

    @Test public void testDecodeSample2() {
        assertEquals(HammingCode.decode("01110110101"), "1001101");
    }

    @Test public void testEncodeZero() {
        assertEquals(HammingCode.encode("0"), "000");
    }

    @Test public void testEncodeOne() {
        assertEquals(HammingCode.encode("1"), "111");
    }

    @Test public void testEncodeLengthPowerOfTwo() {
        assertEquals(HammingCode.encode("1101"), "1010101");
    }

    @Test public void testEncodeRandom() {
        assertEquals(HammingCode.encode("00110"), "100001100");
    }

    @Test public void testEncodeLongLength() {
        assertEquals(HammingCode.encode("011010111011101"), "00001101101110111101");
    }

    @Test public void testDecodeToLengthOne() {
        assertEquals(HammingCode.decode("000"), "0");
    }

    @Test public void testDecodeToLengthOneWithErrorAtR() {
        assertEquals(HammingCode.decode("101"), "1");
    }

    @Test public void testDecodeToLengthPowerOfTwo() {
        assertEquals(HammingCode.decode("1010101"), "1101");
    }

    @Test public void testDecodeWithErrorAtData() {
        assertEquals(HammingCode.decode("00001101101110111101"), "011010111011101");
    }
}
