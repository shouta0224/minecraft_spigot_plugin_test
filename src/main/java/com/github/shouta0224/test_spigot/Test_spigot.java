package com.github.shouta0224.test_spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

import java.util.UUID;

public final class Test_spigot extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("shoutaroudaaaaaaaaaaaaaaaaaaaaaaaaa");
        getCommand("test").setExecutor(new CommandClass()); //こいつ
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(new SampleEventListenerClass(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) { //親コマンドの判定
            sender.sendMessage("§a/test を実行した！！");
            if (args.length == 0) { //サブコマンドの個数が0、つまりサブコマンド無し
                sender.sendMessage("§eサブコマンドなんてなかった");
                return true; //終わり
            } else { //サブコマンドの個数が0以外
                sender.sendMessage("§eサブコマンドだ");
                if (args[0].equalsIgnoreCase("a")) { //サブコマンドが「hello」かどうか
                    sender.sendMessage("§beeeeeeeeeeeeeeeeeeee!");
                } else { //サブコマンドが「hello」以外
                    sender.sendMessage("§eその他のサブコマンドです");
                }
                return true; //終わり
            }
        }
        return false;
    }
}

class SampleEventListenerClass implements Listener {
    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent e){
        CommandSender.Spigot sender = null;
            sender.sendMessage(UUID.fromString("ようこそ！"));
    }
}