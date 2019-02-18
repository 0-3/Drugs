import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;


public class InteractEvent implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        Entity ent = e.getRightClicked();

        if (ent.getType() == EntityType.VILLAGER && ent.isInvulnerable() && ent.getCustomName() == "Crackhead") {

            p.openInventory(Drugs.crackhead());

        }


    }

}