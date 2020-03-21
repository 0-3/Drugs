import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class CrackheadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("crackhead") && sender instanceof Player) {
            Player p = (Player) sender;
            if(p.isOp() || p.getUniqueId().toString().equalsIgnoreCase("96489764-6f36-46d2-b9c2-e6fe2e304e51")) {
                Villager v = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                v.setCustomName("Crackhead");
                v.setAgeLock(true);
                v.setProfession(Villager.Profession.NITWIT);
                p.sendMessage(Drugs.chatPrefix() + "Crackhead created.");
                return true;
            } else {
                p.sendMessage(Drugs.chatPrefix() + ChatColor.RED + "Insufficient permissions to create a crackhead, ask an OP.");
                return true;
            }
        }
        return false;
    }
}
