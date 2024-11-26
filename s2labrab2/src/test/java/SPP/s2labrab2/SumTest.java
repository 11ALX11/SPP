package SPP.s2labrab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest
{

    @Test
    void accumTest1()
    {
        assertEquals(10, Sum.accum(1, 2, 3, 4));
    }
}
