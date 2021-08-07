package net.kigawa.escapeplugin.util.yaml;

import net.kigawa.escapeplugin.util.all.Named;

public interface YamlData extends Named {
    String name = null;
    public String getName();
    public void setName(String name);
}
