package me.frodenkvist.scoreboardmanager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class SMHandler
{
	private static List<SMPlayer> players = new ArrayList<SMPlayer>();
	
	public static SMPlayer getPlayer(Player player)
	{
		for(SMPlayer smp : players)
		{
			if(smp.getPlayer().equals(player))
				return smp;
		}
		return null;
	}
	
	public static boolean addPlayer(SMPlayer smp)
	{
		return players.add(smp);
	}
	
	public static boolean removePlayer(Player player)
	{
		for(SMPlayer smp : players)
		{
			if(smp.getPlayer().equals(player))
				return players.remove(smp);
		}
		return false;
	}
	
	public static void setHealthBar(double percent, Player player)
	{
		if(percent <= 1.0D && percent > 0.9D)
		{
			setTeam(10, player);
		}
		else if(percent <= 0.9D && percent > 0.8D)
		{
			setTeam(9, player);
		}
		else if(percent <= 0.8D && percent > 0.7D)
		{
			setTeam(8, player);
		}
		else if(percent <= 0.7D && percent > 0.6D)
		{
			setTeam(7, player);
		}
		else if(percent <= 0.6D && percent > 0.5D)
		{
			setTeam(6, player);
		}
		else if(percent <= 0.5D && percent > 0.4D)
		{
			setTeam(5, player);
		}
		else if(percent <= 0.4D && percent > 0.3D)
		{
			setTeam(4, player);
		}
		else if(percent <= 0.3D && percent > 0.2D)
		{
			setTeam(3, player);
		}
		else if(percent <= 0.2D && percent > 0.1D)
		{
			setTeam(2, player);
		}
		else if(percent <= 0.1D && percent >= 0.0D)
		{
			setTeam(1, player);
		}
	}
	
	private static void setTeam(int nr, Player player)
	{
		for(SMPlayer smp : players)
		{
			if(smp == null)
				continue;
			if(smp.getPlayer().equals(player))
				continue;
			smp.getScoreboard().getTeam(("hbr" + nr)).addPlayer((OfflinePlayer)player);
		}
	}
}
