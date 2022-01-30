package arch.sm213.machine.student;
import arch.sm213.machine.student.MainMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainMemoryTest {

//    @Before
    @Test
    public void testIsAccessAligned() {
        MainMemory mm = new MainMemory(1431000000); // param: size of memory in bytes
        //A memory address a is said to be n-byte aligned when a is a multiple of n bytes (where n is a power of 2
        // thus, length should always be a power of 2, incl. 2^0 = 1

        //address 0 - edge case - should be aligned to everything
        assertTrue(mm.isAccessAligned(0, 1));
        assertTrue(mm.isAccessAligned(0, 2));
        assertTrue(mm.isAccessAligned(0, 4));

        //address 1: - also an edge case. Aligned to 1, not to 2.
        assertTrue(mm.isAccessAligned(1, 1));
        assertFalse(mm.isAccessAligned(1, 2));

        //address 2
        assertTrue(mm.isAccessAligned(2, 1));
        assertTrue(mm.isAccessAligned(2, 2));
        assertFalse(mm.isAccessAligned(2, 4));

        //address 16
        assertTrue(mm.isAccessAligned(16, 1));
        assertTrue(mm.isAccessAligned(16, 2));
        assertTrue(mm.isAccessAligned(16, 4));
        assertTrue(mm.isAccessAligned(16, 8));
        assertTrue(mm.isAccessAligned(16, 16));

        //address 17 - prime number, should only be aligned to 1 (and itself, but 17 isn't a power of 2)
        assertTrue(mm.isAccessAligned(17, 1));
        assertFalse(mm.isAccessAligned(17, 2));
        assertFalse(mm.isAccessAligned(17, 4));
        assertFalse(mm.isAccessAligned(17, 8));
        assertFalse(mm.isAccessAligned(17, 16));

        //address 2,147,483,647 -- can't make an array that big in Java, so can't test
        //would've said is aligned for length 1 and length 2,147,483,647
        //not aligned for 2, 4, 8, 16, etc. cos it's prime.
        //this is also an edge case - largest integer value possible

        //addresses can't be < 0, so no need to test negative nums


    }




}
