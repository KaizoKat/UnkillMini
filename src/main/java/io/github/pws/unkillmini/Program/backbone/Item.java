/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Program.backbone;

public class Item
{
    public String name;
    public String description;
    public int count;
    public ScriptableNode runner;

    public Item(String name, String description, int count, ScriptableNode runner)
    {
        this.name = name;
        this.description = description;
        this.count = count;
        this.runner = runner;
    }
    
    
}
