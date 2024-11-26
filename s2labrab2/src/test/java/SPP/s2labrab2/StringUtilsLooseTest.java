package SPP.s2labrab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsLooseTest
{

    @Test
    void TestNullException()
    {
        assertThrows(
                NullPointerException.class,
                () -> StringUtils.loose(null, null)
        );
    }

    @Test
    void TestNullStr()
    {
        assertNull(StringUtils.loose(null, ""));
        assertNull(StringUtils.loose(null, "3rfeds"));
        assertNull(StringUtils.loose(null, "q"));
    }

    @Test
    void TestEmptyStr()
    {
        assertEquals("", StringUtils.loose("", ""));
        assertEquals("", StringUtils.loose("", "q"));
        assertEquals("", StringUtils.loose("", "2r3f"));
    }

    @Test
    void TestNullRemove()
    {
        assertEquals("", StringUtils.loose("", null));
        assertEquals("q", StringUtils.loose("q", null));
        assertEquals("1ewds", StringUtils.loose("1ewds", null));
    }

    @Test
    void TestEmptyRemove()
    {
        assertEquals("", StringUtils.loose("", ""));
        assertEquals("q", StringUtils.loose("q", ""));
        assertEquals("1rwfsdv", StringUtils.loose("1rwfsdv", ""));
    }

    @Test
    void Test1()
    {
        assertEquals("eo", StringUtils.loose("hello", "hl"));
    }

    @Test
    void Test2()
    {
        assertEquals("ho", StringUtils.loose("hello", "le"));
    }

}