/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.assets;

import io.github.pws.unkillmini.Scripts.Items.Apple;
import io.github.pws.unkillmini.Program.backbone.Item;
import java.util.ArrayList;
import java.util.List;

public class Items 
{
    List<Item> items = new ArrayList<>();
   
    Item apple = new Item("Apple", "Just an apple.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item bean = new Item("Bean", "Just a bean.", 
            new Item.Stats(10,0),Item.Type.inventory,new Apple());
    Item crab = new Item("Crab", "Crab!", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item dust = new Item("Dust", "An usless pile of dust.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item elephant = new Item("Elephant", "Dont step in it, its pretty small.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item fork = new Item("Fork", "Use it as a weapon.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item ghost = new Item("Ghost", "Boo!", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item horse = new Item("Horse", "Neigh", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item isaac = new Item("Isaac", "Isaac and his mother...", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item jumper = new Item("Jumper", "Soft and flexible. Perfect for high movment tasks.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item kale = new Item("Kale", "The moost overpowered weapon in the universe.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item light = new Item("Light", "It exists, and you have it. I dont know why.", 
            new Item.Stats(99,0),Item.Type.inventory,new Apple());
    Item mutton = new Item("Mutton", "Either chops or someones weirdly shaped beard.", 
            new Item.Stats(2,0),Item.Type.inventory,new Apple());
    Item note = new Item("Note", "Not the death kind.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item orange = new Item("Orange", "Acidic and bitter. Perfect to throw at your enemies.", 
            new Item.Stats(99,0),Item.Type.inventory,new Apple());
    Item piano = new Item("Piano", "Have you ever seen a looney tunes animation?", 
            new Item.Stats(10,0),Item.Type.inventory,new Apple());
    Item qween = new Item("Qween", "The strongest piece in chess. Equip it to get a boost on all your stats.", 
            new Item.Stats(10,0),Item.Type.inventory,new Apple());
    Item rabbit = new Item("Rabbit", "Its dead. But, it does taste pretty good.", 
            new Item.Stats(10,0),Item.Type.inventory,new Apple());
    Item saber = new Item("Saber", "Just a sword.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item telephone = new Item("Telephone", "No signal...", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item ubercharge = new Item("Ubercharge", "The medic has been working hard!", 
            new Item.Stats(3,0),Item.Type.inventory,new Apple());
    Item vatOfAcid = new Item("Vat of acid", "Whatever you do, dont jump in it.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
    Item word = new Item("Word", "word...", 
            new Item.Stats(99,0),Item.Type.inventory,new Apple());
    Item xCoordinate = new Item("X coordinate", "Why do you have this? Give me it.", 
            new Item.Stats(1,0),Item.Type.inventory,new Apple());
}
