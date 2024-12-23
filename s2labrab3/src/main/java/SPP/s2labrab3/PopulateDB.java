package SPP.s2labrab3;

import SPP.s2labrab3.service.TestService;

import java.io.IOException;

public class PopulateDB
{
    public static void main(String[] args)
    {
        {
            TestService ts = new TestService();
            try
            {
                ts.populateDB();

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
