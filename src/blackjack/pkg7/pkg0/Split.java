/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.pkg7.pkg0;

import static blackjack.pkg7.pkg0.Moves.getIndex;
import static blackjack.pkg7.pkg0.Player.playingCard;

/**
 *
 * @author Afrie Irham
 */
public class Split extends Player{
    
    int[] newHand = new int[100];
    private int cardUsed = 1;
    private int i = 1;
    
    public Split(String name, int CardValue){
        this.name = name;
        newHand[0] = CardValue;
    }
    
    public void drawCard(){

        newHand[i] = playingCard[getIndex()];
        super.i++;
        this.i++;
        super.cardUsed++;
        this.cardUsed++;
    }
    
    public int getCardValue(int index){
        return cardValue(newHand[index]);
    }
    
    public void getAllCard(){
        for(int i=0 ; i<this.cardUsed ; i++){
            System.out.println(getCardSymbol(newHand[i]));
        }
    }
    
    public int totalValue(){
        int total = 0;
        int aceCounter = 0;
        for(int i=0; i<this.cardUsed; i++){
            int cardValue = cardValue(newHand[i]);
            if(cardValue == 1 || cardValue == 14 || cardValue == 27 || cardValue == 40 ){
                aceCounter++;
            }
            else{
                total += cardValue;
            }

        }

        if(aceCounter == 0){
            return total;
        }
        else{
            if(total>10){
                total += 1;
            }
            else{
                total += 11;
            }
        }
        return total;
    }
}
