package me.frodenkvist.scoreboardmanager;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class SMPlayer
{
	private Player player;
	private Scoreboard sb;
	
	public SMPlayer(Player player, Scoreboard sb)
	{
		this.player = player;
		this.sb = sb;
		sb.registerNewTeam("hbr1").setSuffix(" §c|§8|||||||||");
		sb.registerNewTeam("hbr2").setSuffix(" §c||§8||||||||");
		sb.registerNewTeam("hbr3").setSuffix(" §c|||§8|||||||");
		sb.registerNewTeam("hbr4").setSuffix(" §e||||§8||||||");
		sb.registerNewTeam("hbr5").setSuffix(" §e|||||§8|||||");
		sb.registerNewTeam("hbr6").setSuffix(" §a||||||§8||||");
		sb.registerNewTeam("hbr7").setSuffix(" §a|||||||§8|||");
		sb.registerNewTeam("hbr8").setSuffix(" §a||||||||§8||");
		sb.registerNewTeam("hbr9").setSuffix(" §a|||||||||§8|");
		sb.registerNewTeam("hbr10").setSuffix(" §a||||||||||");
	}
	
	public Scoreboard getScoreboard()
	{
		return sb;
	}
	
	public Player getPlayer()
	{
		return player;
	}
}
