package net.kigawa.escapeplugin.util.plugin.all.command;

import net.kigawa.escapeplugin.util.all.Named;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.message.logger.PluginLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public abstract class TabList extends PluginLogger implements Named {
    List<TabList> tabLists;


    public TabList(KigawaPlugin kigawaPlugin) {
        super(kigawaPlugin);
        List<TabList> tabLists;
        tabLists = new ArrayList<>();
        this.tabLists = tabLists;
    }

    public abstract int getWordNumber();

    public abstract List<String > getTabStrings(CommandSender sender, Command command,String label,String[] strings);

    public void addTabLists(TabList tabList) {
        tabLists.add(tabList);
    }

    public List<String> tabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        //new instance
        List<String> tabListStr=null;
        //check null
        logger("check null");

        if (tabLists != null) {
            //when send here
            if (strings.length == getWordNumber() + 1) {
                //get tab list
                tabListStr=getTabStrings(commandSender,command,s,strings);
                //when null
                if (tabListStr==null) {
                    logger("when send here");
                    //new list
                    tabListStr=new ArrayList<>();
                    for (TabList tabList : tabLists) {
                        tabListStr.add(tabList.getName());
                    }
                }
            }


            //when do not send here
            if (strings.length > getWordNumber() + 1) {
                //new list
                tabListStr=new ArrayList<>();
                logger("when do not send here");
                //check contain tabList
                if (tabLists.contains(new EqualsCommand(strings[getWordNumber() + 1]))) {
                    TabList tabList = tabLists.get(tabLists.indexOf(new EqualsCommand(strings[getWordNumber() + 1])));
                    tabListStr = tabList.tabComplete(commandSender, command, s, strings);
                }
            }
        }

        return tabListStr;
    }

}
