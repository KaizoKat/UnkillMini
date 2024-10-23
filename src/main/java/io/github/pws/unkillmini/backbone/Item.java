/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.backbone;

import io.github.pws.unkillmini.run.Aplication;

public class Item
{
    public String name;
    public String description;
    public int count;
    public Aplication runner;

    public Item(String name, String description, int count, Aplication runner)
    {
        this.name = name;
        this.description = description;
        this.count = count;
        this.runner = runner;
    }
    
    
}
