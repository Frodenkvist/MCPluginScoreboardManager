package me.frodenkvist.scoreboardmanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import Event.PBEntityDamageEntityEvent;
import Event.PBEntityRegainHealthEvent;
import PvpBalance.PVPPlayer;
import PvpBalance.PvpHandler;

public class HealthListener implements Listener
{
	@EventHandler
	public void onPBHealthRegainEvent(PBEntityRegainHealthEvent event)
	{
		if(event.isCancelled())
			return;
		if(!(event.getEntity() instanceof Player))
			return;
		PVPPlayer player = PvpHandler.getPvpPlayer(((Player)event.getEntity()));
		//double oldPercent = 0.0D;
		double percent = 0.0D;
		
		//oldPercent = (player.gethealth() / player.getMaxHealth());
		int health = player.gethealth() + event.getAmount();
		if(health > player.getMaxHealth())
			health = player.getMaxHealth();
		percent = ((double)health / (double)player.getMaxHealth());
		SMHandler.setHealthBar(percent, (Player)event.getEntity());
	}
	
	@EventHandler
	public void onPBEntityDamageEntityEvent(PBEntityDamageEntityEvent event)
	{
		if(event.isCancelled())
			return;
		if(!(event.getEntity() instanceof Player))
			return;
		PVPPlayer player = PvpHandler.getPvpPlayer(((Player)event.getEntity()));
		//double oldPercent = 0.0D;
		double percent = 0.0D;
		
		//oldPercent = (player.gethealth() / player.getMaxHealth());
		int health = player.gethealth() - event.getDamage();
		if(health < 0)
			health = 0;
		percent = ((double)health / (double)player.getMaxHealth());
		//Bukkit.broadcastMessage("" + percent);
		SMHandler.setHealthBar(percent, (Player)event.getEntity());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawnEvent(PlayerRespawnEvent event)
	{
		PVPPlayer player = PvpHandler.getPvpPlayer(event.getPlayer());
		//double oldPercent = 0.0D;
		double percent = 0.0D;
		
		//oldPercent = (player.gethealth() / player.getMaxHealth());
		percent = (1.0);
		//Bukkit.broadcastMessage("" + percent);
		SMHandler.setHealthBar(percent, player.getPlayer());
	}
}
