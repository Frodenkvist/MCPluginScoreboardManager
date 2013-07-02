package me.frodenkvist.scoreboardmanager;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import PvpBalance.PvpBalance;

public class ScoreboardManager extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static ScoreboardManager plugin;
	public final PlayerListener pl = new PlayerListener();
	public final HealthListener hl = new HealthListener();
	public final ScoreboardMessageListener sml = new ScoreboardMessageListener();
	public static PvpBalance pvpPlugin;
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	
	//@SuppressWarnings("deprecation")
	@Override
	public void onEnable()
	{
		plugin = this;
		
		getServer().getPluginManager().registerEvents(pl, this);
		getServer().getPluginManager().registerEvents(hl, this);
		
		Bukkit.getMessenger().registerIncomingPluginChannel(this, "Scoreboard", sml);
		
		//Bukkit.getMessenger().registerOutgoingPluginChannel(this, "Scoreboard");
		PluginDescriptionFile pdfFile = this.getDescription();
		
		for(Player player : getServer().getOnlinePlayers())
		{
			if(player == null)
				continue;
			SMPlayer smp = new SMPlayer(player, Bukkit.getScoreboardManager().getNewScoreboard());
			SMHandler.addPlayer(smp);
		}
		
		pvpPlugin = (PvpBalance)getServer().getPluginManager().getPlugin("PVPBalance");
		
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
	}
	
	public boolean onCommand(CommandSender sender,Command cmd,String commandLabel, String[] args)
	{
		//Player player = (Player)sender;
		/*if(commandLabel.equalsIgnoreCase("sm"))
		{
			//Team team;
			//team.
			//Bukkit.getMessenger().dispatchIncomingMessage(player, "Scoreboard", "BELOW_NAME,Frodenkvist,Thing,10".getBytes());
			/*SMPlayer smp = SMHandler.getPlayer(player);
			Team team;
			if(smp.getScoreboard().getTeam("Testthings") == null)
				 team = smp.getScoreboard().registerNewTeam("Testthings");
			else
				team = smp.getScoreboard().getTeam("Testthings");
			team.setSuffix(" §cI§8IIIIIIIII");
			Player target = null;
			for(Player p : Bukkit.getOnlinePlayers())
			{
				if(p == null)
					continue;
				if(p.getName().equalsIgnoreCase(args[0]))
				{
					target = p;
					break;
				}
			}
			team.addPlayer((OfflinePlayer)target);
			team.setCanSeeFriendlyInvisibles(false);
			team.setAllowFriendlyFire(true);
			SMPlayer smp = SMHandler.getPlayer(player);
			smp.getScoreboard().resetScores(Bukkit.getOfflinePlayer("Thing"));
		}
		else if(commandLabel.equalsIgnoreCase("sf"))
		{
			Bukkit.getMessenger().dispatchIncomingMessage(player, "Scoreboard", "SIDEBAR,Dungeon,Thing,10".getBytes());
			Bukkit.getMessenger().dispatchIncomingMessage(player, "Scoreboard", "SIDEBAR,Dungeon,Fork,10".getBytes());
		}*/
		return true;
	}
}
