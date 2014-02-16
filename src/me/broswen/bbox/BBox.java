package me.broswen.bbox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BBox extends JavaPlugin implements Listener{
	public static BBox plugin;
	private Menu menu;
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().info("BBox version " + pdfFile.getVersion() + " has been enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		menu = new Menu(this);
		this.plugin = this;
	}
	
	@Override
	public void onDisable(){
		getLogger().info("BBox has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		PluginDescriptionFile pdfFile = this.getDescription();
		
		if(cmd.getName().equalsIgnoreCase("bbox")){
			if(!sender.hasPermission("bbox.info")){
				sender.sendMessage(ChatColor.RED + "You don't have permission!");
				return true;
			}
			
			if(sender instanceof Player){
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "======" + ChatColor.BOLD + " BBox " + ChatColor.AQUA.toString() + ChatColor.BOLD + "======");
				player.sendMessage(ChatColor.GRAY.toString() + ChatColor.BOLD + "Version: " + pdfFile.getVersion());
				player.sendMessage(ChatColor.GRAY.toString() + ChatColor.BOLD + "Author: " + pdfFile.getAuthors());
				player.sendMessage(ChatColor.GRAY.toString() + ChatColor.BOLD + "About: " + pdfFile.getDescription());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "======" + ChatColor.BOLD + " BBox " + ChatColor.AQUA.toString() + ChatColor.BOLD + "======");
				
			}else{
				getLogger().info("====== BBox ======");
				getLogger().info("Version: " + pdfFile.getVersion());
				getLogger().info("Author: " + pdfFile.getAuthors());
				getLogger().info("About: " + pdfFile.getDescription());
				getLogger().info("====== BBox ======");
			}
		}
		
		return true;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
	
		if(block == null){
			return;
		}
		
		if(block.getType() == Material.JUKEBOX && player.isSneaking() && event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(!player.hasPermission("bbox.use")){
				return;
			}
			
			menu.openInventory(player);
		}
	}
}
