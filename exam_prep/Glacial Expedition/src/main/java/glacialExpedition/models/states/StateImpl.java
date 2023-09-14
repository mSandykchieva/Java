package glacialExpedition.models.states;

import java.util.Collection;

import static glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public abstract class StateImpl implements State{

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
    }

    private void setName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name=name;
    }

    @Override
    public Collection<String> getExhibits() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
