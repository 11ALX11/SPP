package SPP.s2labrab2.queue;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({EmptyQueueTest.class,
        NotEmptyQueueTest.class})
@Suite
public class QueueTest
{
}
