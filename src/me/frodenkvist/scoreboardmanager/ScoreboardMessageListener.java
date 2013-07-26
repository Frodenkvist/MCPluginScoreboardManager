package me.frodenkvist.scoreboardmanager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardMessageListener implements PluginMessageListener
{
	@Override
	public void onPluginMessageReceived(String thing, Player player, byte[] bytes)
	{
		SMPlayer smp = SMHandler.getPlayer(player);
		if(smp == null)
			return;
		String message = new String(bytes);
		String[] split = message.split(",");
		if(split[0].equalsIgnoreCase("REMOVE"))
		{
			removeScore(smp, split);
			return;
		}
		//org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		//Scoreboard sb = sm.getMainScoreboard();
		Scoreboard sb = smp.getScoreboard();
		boolean check = false;
		for(Objective obj : sb.getObjectives())
		{
			if(obj.getDisplayName().equalsIgnoreCase(split[1]))
			{
				check = true;
				break;
			}
		}
		Objective obj;
		if(!check)
		{
			 obj = sb.registerNewObjective(split[1], "thing");
			 obj.setDisplayName(split[1]);
			 obj.setDisplaySlot(DisplaySlot.valueOf(split[0]));
		}
		else
			obj = sb.getObjective(split[1]);
		Score score = obj.getScore(Bukkit.getOfflinePlayer(split[2]));
		//Bukkit.broadcastMessage(split[3]);
		//Bukkit.broadcastMessage(message);
		int newScore = 0;
		if(split[3].startsWith("-"))
		{
			split[3].replace("-", "");
			newScore = score.getScore() - Integer.valueOf(split[3]);
		}
		else if(split[3].startsWith("+"))
		{
			split[3].replace("+", "");
			newScore = score.getScore() + Integer.valueOf(split[3]);
		}
		else
		{
			newScore = Integer.valueOf(split[3]);
		}
		score.setScore(newScore);
		player.setScoreboard(sb);
	}
	
	private void removeScore(SMPlayer smp, String[] split)
	{
		//Objective obj = smp.getScoreboard().getObjective(split[1]);
		//obj
		Scoreboard sb = smp.getScoreboard();
		sb.resetScores(Bukkit.getOfflinePlayer(split[1]));
		smp.getPlayer().setScoreboard(sb);
	}
}
