package me.frodenkvist.scoreboardmanager;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener
{
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event)
	{
		SMHandler.removePlayer(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event)
	{
		SMHandler.addPlayer(new SMPlayer(event.getPlayer(),Bukkit.getScoreboardManager().getNewScoreboard()));
	}
}
