package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.List;

public class Carton implements Suitcase {
    private List<String> exhibits;

    public Carton() {
        exhibits = new ArrayList<>();
    }

    @Override
    public List<String> getExhibits() {
        return this.exhibits;
    }
}
