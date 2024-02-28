import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
public class Paragraph
{
    // агрегация (1 парграф - 0..n строк)
    private List<CustomString> strings;

    public Paragraph()
    {
        strings = new ArrayList<>();
    }

    public void addString(CustomString customString)
    {
        strings.add(customString);
    }

    public void printParagraph()
    {
        for (CustomString customString : strings)
        {
            System.out.println(customString.getText());
        }
    }
}
