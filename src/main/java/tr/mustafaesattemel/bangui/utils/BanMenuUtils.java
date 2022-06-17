package tr.mustafaesattemel.bangui.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanMenuUtils {

    public static void openBanMenu(Player p){
        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers()) ;
        Inventory banGui = Bukkit.createInventory(p,45, ChatColor.BLUE+"Player list");

        for (Player player : list) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(player.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + player.getHealth());
            lore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + player.getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            banGui.addItem(playerHead);
        }
        p.openInventory(banGui);

    }
    public static void openConfirmBanMenu(Player p,Player whoToBan){

        Inventory confirmBanMenu = Bukkit.createInventory(p,9,"Ban This Noob");

        ItemStack ban = new ItemStack(Material.WOODEN_AXE,1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_GREEN+"Ban ");
        ban.setItemMeta(banMeta);
        confirmBanMenu.setItem(0,ban);

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta playerMeta = playerHead.getItemMeta();
        playerMeta.setDisplayName(whoToBan.getDisplayName());
        confirmBanMenu.setItem(4,playerHead);

        ItemStack cancel = new ItemStack(Material.BARRIER);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED+"Go back!");
        cancel.setItemMeta(cancelMeta);
        confirmBanMenu.setItem(8,cancel);

        p.openInventory(confirmBanMenu);

    }
}
