import events.DrugEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Drugs extends JavaPlugin {


    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    public PluginDescriptionFile pdf = this.getDescription();
    public String ver = pdf.getVersion();

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Plugin Drugs by Ethan has loaded v1.2");
        getServer().getPluginManager().registerEvents(new DrugEvent(), this);
        getServer().getPluginManager().registerEvents(new InteractEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        this.getCommand("drug").setExecutor(new DrugCommand());
        this.getCommand("crackhead").setExecutor(new CrackheadCommand());

    }

    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            log.info(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            log.info(String.format("[%s] - Disabled due to no Economy dependency found!", getDescription().getName()));
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static String chatPrefix() {
        return ChatColor.GRAY + "Drugs" + ChatColor.DARK_GRAY + ChatColor.ITALIC + " » " + ChatColor.RESET + ChatColor.GRAY;
    }

    public static Inventory crackhead(){
        Inventory drugGui = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Drugs v1.2" + ChatColor.GRAY + " - Created by Ethan");

        ItemStack shroomsItem = new ItemStack(Material.RED_MUSHROOM);
        ItemMeta shroomsItemMeta = shroomsItem.getItemMeta();
        shroomsItemMeta.setDisplayName(ChatColor.BLUE + "S" + ChatColor.DARK_PURPLE + "h" + ChatColor.RED + "r" + ChatColor.GREEN + "o" +
                ChatColor.YELLOW + "o" + ChatColor.LIGHT_PURPLE + "m" + ChatColor.AQUA + "s");
        List<String> shroomLore = new ArrayList<>();
        shroomLore.add(ChatColor.DARK_GRAY + "$50 per gram.");
        shroomsItemMeta.setLore(shroomLore);
        shroomsItem.setItemMeta(shroomsItemMeta);
        drugGui.setItem(1, shroomsItem);

        ItemStack cokeItem = new ItemStack(Material.COCOA_BEANS);
        ItemMeta cokeItemMeta = cokeItem.getItemMeta();
        cokeItemMeta.setDisplayName(ChatColor.RESET + "Cocaína");
        List<String> cokeLore = new ArrayList<>();
        cokeLore.add(ChatColor.DARK_GRAY + "$25 per gram.");
        cokeItemMeta.setLore(cokeLore);
        cokeItem.setItemMeta(cokeItemMeta);
        drugGui.setItem(3, cokeItem);

        ItemStack baliItem = new ItemStack(Material.WHEAT);
        ItemMeta baliItemMeta = baliItem.getItemMeta();
        baliItemMeta.setDisplayName(ChatColor.DARK_GREEN + "Bali");
        List<String> baliLore = new ArrayList<>();
        baliLore.add(ChatColor.DARK_GRAY + "$20 per gram.");
        baliItemMeta.setLore(baliLore);
        baliItem.setItemMeta(baliItemMeta);
        drugGui.setItem(5, baliItem);

        ItemStack settingsItem = new ItemStack(Material.CACTUS_GREEN);
        ItemMeta settingsItemMeta = settingsItem.getItemMeta();
        settingsItemMeta.setDisplayName(ChatColor.YELLOW + "Hash");
        List<String> hashLore = new ArrayList<>();
        hashLore.add(ChatColor.DARK_GRAY + "$20 per gram.");
        settingsItemMeta.setLore(hashLore);
        settingsItem.setItemMeta(settingsItemMeta);
        drugGui.setItem(7, settingsItem);

        return drugGui;
    }


}