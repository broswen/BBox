package me.broswen.bbox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Menu implements Listener{
	
	private Inventory inv;
	private ItemStack thirteen, cat, blocks, 
		chirp, far, mall, mellohi, stall, strad, ward, eleven, wait;
	
	public Menu(Plugin plugin){
		inv = Bukkit.getServer().createInventory(null, 18, 
				ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Music");
		
		thirteen = createItem(Material.GOLD_RECORD, ChatColor.GREEN.toString() + ChatColor.BOLD + "Play '13'");
		cat = createItem(Material.GREEN_RECORD, ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'cat'");
		blocks = createItem(Material.getMaterial(2258), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'blocks'");
		chirp = createItem(Material.getMaterial(2259), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'chirp'");
		far = createItem(Material.getMaterial(2260), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'far'");
		mall = createItem(Material.getMaterial(2261), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'mall'");
		mellohi = createItem(Material.getMaterial(2262), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'mellohi'");
		stall = createItem(Material.getMaterial(2263), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'stall'");
		strad = createItem(Material.getMaterial(2264), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'strad'");
		ward = createItem(Material.getMaterial(2265), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'ward'");
		eleven = createItem(Material.getMaterial(2266), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'eleven'");
		wait = createItem(Material.getMaterial(2267), ChatColor.GREEN.toString() + ChatColor.BOLD + "Play 'wait'");
		
		inv.addItem(thirteen, cat, blocks, chirp, far, mall, mellohi, stall, strad, ward, eleven, wait);
		
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	private ItemStack createItem(Material m, String name){
		ItemStack i = new ItemStack(m, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		i.setItemMeta(im);
		
		return i;
	}
	
	public void openInventory(Player player){
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		Location playerLocation = player.getLocation();
		ItemStack i = event.getCurrentItem();
		
		if(!event.getInventory().getTitle().contains("Music")){
			return;
		}
		
		event.setCancelled(true);
		
		if(i.getItemMeta() == null || i == null || i.getItemMeta().getDisplayName() == null){
			return;
		}
		
		if(i.getItemMeta().getDisplayName().contains("13")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, Material.GOLD_RECORD.getId());
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("cat")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, Material.GREEN_RECORD.getId());
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("blocks")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2258);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("chirp")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2259);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("far")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2260);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("mall")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2261);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("mellohi")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2262);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("stall")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2263);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("strad")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2264);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("ward")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2265);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("eleven")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2266);
			player.closeInventory();
		}
		
		if(i.getItemMeta().getDisplayName().contains("wait")){
			event.setCancelled(true);
			player.playEffect(playerLocation, Effect.RECORD_PLAY, 2267);
			player.closeInventory();
		}
	}
}
