package studio.magemonkey.tradepost;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BukkitRunner extends BukkitRunnable {

	public final TradePost plugin;

	BukkitRunner(TradePost plugin) {
		this.plugin = plugin;
	}

	public void run() {
		//force running in async// not main thread
		Bukkit.getScheduler().runTaskAsynchronously(TradePost.instance, () -> {
			try {
				plugin.check();
			} catch (Exception e) {
				plugin.getLogger().warning(e.getMessage());
				e.printStackTrace();
			}
		});
	}

}
