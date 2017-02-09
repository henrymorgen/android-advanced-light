package com.example.liuwangshu.moonrxjava;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public class Swordsman {
    private String name;
    private String level;
    public Swordsman(String name,String level){
        this.name=name;
        this.level=level;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
}
