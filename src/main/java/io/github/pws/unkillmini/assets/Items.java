/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.assets;

import io.github.pws.unkillmini.Scripts.Items.Apple;
import io.github.pws.unkillmini.backbone.Item;

public class Items 
{
    public static final Item apple = new Item("Apple", "Just an apple", 7,new Apple());
    
    public static Item[] list()
    {
        Item[] i = {
            apple
        };
        
        return i;
    }
}
