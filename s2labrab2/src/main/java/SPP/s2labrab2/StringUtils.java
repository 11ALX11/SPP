package SPP.s2labrab2;

public class StringUtils
{
    static String keep(String str, String pattern) throws NullPointerException
    {
        if (str == null && pattern == null) {
            throw new NullPointerException("Both arguments are null");
        }
        if (str == null) {
            return null;
        }
        if (pattern == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (pattern.indexOf(c) != -1) {
                result.append(c);
            }
        }

        return result.toString();
    }

    static String loose(String str, String remove) throws NullPointerException
    {
        if (str == null && remove == null) {
            throw new NullPointerException("Both arguments are null");
        }
        if (str == null || remove == null) {
            return str;
        }

        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (remove.indexOf(c) == -1) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
