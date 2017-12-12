/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.pkg7.pkg0;

/**
 *
 * @author Afrie Irham
 */
public class Moves {
    
    private static int index = 0;
    
    public Moves(){
        
    }
    
    public static int getIndex(){
        int theIndex = index;
        index++;
        return theIndex;
    }
    
}
