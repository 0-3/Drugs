import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryEvent implements Listener {

    public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getSize() == 9 && e.getInventory().getHolder() == null) {
            if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta())
                return;
            ItemStack item = e.getCurrentItem();
            Player p = (Player) e.getWhoClicked();
            if (item.getItemMeta().hasDisplayName()) {
                e.setCancelled(true);
                switch (ChatColor.stripColor(item.getItemMeta().getDisplayName())) {
                    default:
                        return;
                    case "Shrooms":
                        if (p.getInventory().contains(Material.RED_MUSHROOM) || p.getInventory().contains(Material.BROWN_MUSHROOM)){
                            int i = getAmount(p, new ItemStack(Material.RED_MUSHROOM)) + getAmount(p, new ItemStack(Material.BROWN_MUSHROOM));
                            String n = Integer.toString(i);
                            EconomyResponse r = Drugs.getEconomy().depositPlayer(p, i*25);
                            if(r.transactionSuccess()) {
                                p.sendMessage(Drugs.chatPrefix() + "You have sold " + ChatColor.YELLOW + n + ChatColor.GRAY + " Shrooms for " +
                                        ChatColor.YELLOW + "$" + Integer.toString(i*25) + ChatColor.GRAY + ".");
                                p.getInventory().remove(Material.RED_MUSHROOM);
                                p.getInventory().remove(Material.BROWN_MUSHROOM);
                            } else {
                                p.sendMessage(Drugs.chatPrefix() + ChatColor.RED + "An Error occurred, tell James to send Ethan the console logs." );
                            }
                        }
                        return;
                    case "Cocaína":
                        if (p.getInventory().contains(Material.COCOA_BEANS)){
                            int i = getAmount(p, new ItemStack(Material.COCOA_BEANS));
                            String n = Integer.toString(i);
                            EconomyResponse r = Drugs.getEconomy().depositPlayer(p, i*15);
                            if(r.transactionSuccess()) {
                                p.sendMessage(Drugs.chatPrefix() + "You have sold " + ChatColor.YELLOW + n + ChatColor.GRAY + " Coke for " +
                                        ChatColor.YELLOW + "$" + Integer.toString(i*15) + ChatColor.GRAY + ".");
                                p.getInventory().remove(Material.COCOA_BEANS);
                            } else {
                                p.sendMessage(Drugs.chatPrefix() + ChatColor.RED + "An Error occurred, tell James to send Ethan the console logs." );
                            }
                        }
                        return;
                    case "Bali":
                        if (p.getInventory().contains(Material.WHEAT)){
                            int i = getAmount(p, new ItemStack(Material.WHEAT));
                            String n = Integer.toString(i);
                            EconomyResponse r = Drugs.getEconomy().depositPlayer(p, i*10);
                            if(r.transactionSuccess()) {
                                p.sendMessage(Drugs.chatPrefix() + "You have sold " + ChatColor.YELLOW + n + ChatColor.GRAY + " Bali for " +
                                        ChatColor.YELLOW + "$" + Integer.toString(i*10) + ChatColor.GRAY + ".");
                                p.getInventory().remove(Material.WHEAT);
                            } else {
                                p.sendMessage(Drugs.chatPrefix() + ChatColor.RED + "An Error occurred, tell James to send Ethan the console logs." );
                            }
                        }
                        break;
                    case "Hash":
                        if (p.getInventory().contains(Material.GREEN_DYE)){
                            int i = getAmount(p, new ItemStack(Material.GREEN_DYE));
                            String n = Integer.toString(i);
                            EconomyResponse r = Drugs.getEconomy().depositPlayer(p, i*5);
                            if(r.transactionSuccess()) {
                                p.sendMessage(Drugs.chatPrefix() + "You have sold " + ChatColor.YELLOW + n + ChatColor.GRAY + " Hash for " +
                                        ChatColor.YELLOW + "$" + Integer.toString(i*5) + ChatColor.GRAY + ".");
                                p.getInventory().remove(Material.GREEN_DYE);
                            } else {
                                p.sendMessage(Drugs.chatPrefix() + ChatColor.RED + "An Error occurred, tell James to send Ethan the console logs." );
                            }
                        }
                        break;
                }
            }


        }

    }
}