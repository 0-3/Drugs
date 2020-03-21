package events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrugEvent implements Listener {
    @EventHandler
    public void onPlayerClick(PlayerInteractEvent evt) {
        Player player = evt.getPlayer();

        if (player.isSneaking()) {
            if (player.getItemInHand().getType() == Material.COCOA_BEANS) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 10));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
                player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
            } else if (player.getItemInHand().getType() == Material.WHEAT) {
                player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1200, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1200, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
            } else if (player.getItemInHand().getType() == Material.BROWN_MUSHROOM || player.getItemInHand().getType() == Material.RED_MUSHROOM) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 900, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 900, 5));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 900, 2));
                player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
            } else if (player.getItemInHand().getType() == Material.GREEN_DYE) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
                player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
            }
        }

    }

}
