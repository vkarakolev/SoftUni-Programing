package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.List;

import static glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State {
    private String name;
    private List<String> exhibits;

    public StateImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
    }

    @Override
    public List<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
