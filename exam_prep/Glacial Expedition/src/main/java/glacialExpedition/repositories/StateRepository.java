package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class StateRepository implements Repository{

    private Collection<State> states;

    @Override
    public Collection getCollection() {
        return null;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public boolean remove(Object entity) {
        return false;
    }

    @Override
    public Object byName(String name) {
        return null;
    }
}
