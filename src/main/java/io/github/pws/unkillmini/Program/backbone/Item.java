package io.github.pws.unkillmini.Program.backbone;



public class Item
{
    public String name;
    public String description;
    public Stats stats;
    public ScriptableNode runner;
    public Type itemType = Type.none;
    
    public enum Type 
    {
        none,
        inventory,
        equipment
    }
    
    public Item(String name, String description, Stats stats, Type itemType, ScriptableNode runner)
    {
        this.name = name;
        this.description = description;
        this.stats = stats;
        this.runner = runner;
        this.itemType = itemType;
    }
    
    public static class Stats
    {
        public int count = 1;
        public int equipmentSlot;
        
        public Stats(int count, int equipmentSlot)
        {
            this.count = count;
            this.equipmentSlot = equipmentSlot;
        }
    }
}
