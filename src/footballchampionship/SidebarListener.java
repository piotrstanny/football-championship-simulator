package footballchampionship;

import java.util.EventListener;

public interface SidebarListener extends EventListener {
    public void sidebarEventOccurred(SidebarEvent event);
}
