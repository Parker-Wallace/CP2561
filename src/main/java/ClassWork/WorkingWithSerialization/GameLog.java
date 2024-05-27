package ClassWork.WorkingWithSerialization;

import javax.xml.bind.annotation.XmlElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class GameLog {
    @XmlElement(name = "GameLog")
    private List<Integer> guesses = new ArrayList<Integer>();

    public List<Integer> getGuesses() {
        return guesses;
    }
}
