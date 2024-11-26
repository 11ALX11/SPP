package SPP.s2labrab2;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({StringUtilsKeepTest.class,
        StringUtilsLooseTest.class})
@Suite
public class StringUtilsTestSuite
{
}
