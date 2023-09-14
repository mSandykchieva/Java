package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;

public class ExplorerRepository implements Repository{

    private Collection<Explorer> explorers;

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
