package ClassWork.WorkingWithSerialization;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class GameLog {
    @XmlElement(name = "GameLog")
    private List<Integer> guesses = new ArrayList<Integer>();

    public List<Integer> getGuesses() {
        return guesses;
    }
}
