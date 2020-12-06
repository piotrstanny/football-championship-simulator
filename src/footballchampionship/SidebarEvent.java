package footballchampionship;

import java.util.EventObject;

public class SidebarEvent extends EventObject {

    private String action;

    public SidebarEvent(Object source, String action) {
        super(source);
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
