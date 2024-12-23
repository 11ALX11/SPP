package SPP.s2labrab3;

import SPP.s2labrab3.service.TestService;

public class Main
{
    public static void main(String[] args)
    {
        TestService ts = new TestService();

        System.out.println("\nAuthors:");
        ts.printAllAuthors();

        System.out.println("\nJournals:");
        ts.printAllJournals();

        System.out.println("\nPapers:");
        ts.printAllPapers();

    }
}
