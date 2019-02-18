import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DrugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("drug") && sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(Drugs.chatPrefix() + "Drugs Plugin by Ethan v" + Drugs.ver);
            return true;
        }
        return false;
    }
}
