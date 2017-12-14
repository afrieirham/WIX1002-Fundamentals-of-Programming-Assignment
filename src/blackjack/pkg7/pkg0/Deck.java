/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.pkg7.pkg0;

import static blackjack.pkg7.pkg0.Player.playingCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Afrie Irham
 */
public class Deck extends Player{
    
    
    //Creating the full Deck of card
    //Only 1 Deck
    public void createFullDeck(){
        for(int i=0; i<52 ;i++){
            playingCard[i] = i+1;
        }
    }
    
    //Shuffle the card index number from 0 - 51
    public void shuffleCard(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 52; i++){
          numbers.add(i);
        }
        Collections.shuffle(numbers);
        
        for(int i = 0; i<52 ; i++ ){
            playingCard[i] = numbers.get(i);
        }
    }
    
}
