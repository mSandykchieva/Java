package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public abstract class MissionImpl implements Mission{
    // ????
    private State state;
    private Collection<Explorer>explorers;

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

    }
}
