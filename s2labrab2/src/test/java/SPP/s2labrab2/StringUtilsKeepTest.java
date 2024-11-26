package SPP.s2labrab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsKeepTest
{

    @Test
    void TestNullException()
    {
        assertThrows(
                NullPointerException.class,
                () -> StringUtils.keep(null, null)
        );
    }

    @Test
    void TestNullStr()
    {
        assertNull(StringUtils.keep(null, ""));
        assertNull(StringUtils.keep(null, "3rfeds"));
        assertNull(StringUtils.keep(null, "q"));
    }

    @Test
    void TestEmptyStr()
    {
        assertEquals("", StringUtils.keep("", ""));
        assertEquals("", StringUtils.keep("", "q"));
        assertEquals("", StringUtils.keep("", "2r3f"));
    }

    @Test
    void TestNullPattern()
    {
        assertEquals("", StringUtils.keep("", null));
        assertEquals("", StringUtils.keep("q", null));
        assertEquals("", StringUtils.keep("1ewds", null));
    }

    @Test
    void TestEmptyPattern()
    {
        assertEquals("", StringUtils.keep("", ""));
        assertEquals("", StringUtils.keep("q", ""));
        assertEquals("", StringUtils.keep("1rwfsdv", ""));
    }

    @Test
    void Test1()
    {
        assertEquals("hll", StringUtils.keep("hello", "hl"));
    }

    @Test
    void Test2()
    {
        assertEquals("ell", StringUtils.keep("hello", "le"));
    }

}
