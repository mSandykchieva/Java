package glacialExpedition.models.suitcases;

import java.util.Collection;

public abstract class Carton implements Suitcase{

    private Collection<String> exhibits;

    public Carton() {

    }

    @Override
    public Collection<String> getExhibits() {
        return null;
    }
}
