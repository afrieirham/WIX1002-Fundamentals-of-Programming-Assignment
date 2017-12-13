/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.pkg7.pkg0;

import static blackjack.pkg7.pkg0.Moves.getIndex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Player {

    public int[] hands = new int[10];
    public static int[] playingCard = new int[52];

    private int i = 0;
    private int cardUsed = 0;
    public String name;

    public Player(String name){
        this.name = name;
    }
    
    public Player(){
        
    }

    public void drawCard(){

        hands[i] = playingCard[getIndex()];
        i++;
        cardUsed++;
    }

    public void getAllCard(){
        for(int i=0 ; i<cardUsed ; i++){
            System.out.println(getCardSymbol(hands[i]));
        }
    }
    
    public void getCard(int i){
        System.out.println(getCardSymbol(hands[i]));
    }

    private String getCardSymbol(int index){
        String message = null;
        if(index>=40){
            index -= 39;
            message = getCardNumber(index);
            message += " of Diamond";
        }
        else if(index>=27){
            index -= 26;
            message = getCardNumber(index);
            message += " of Clubs";
        }
        else if(index>=14){
            index -= 13;
            message = getCardNumber(index);
            message += " of Hearts";
        }
        else{   
        message = getCardNumber(index);
        message += " of Spades";
        }
    return message;
    }
    
    private String getCardNumber(int index){
        String message = null;
        switch(index){
                case 1:   message = "Ace"; break;
                case 2:   message = "2"; break;
                case 3:   message = "3"; break;
                case 4:   message = "4"; break;
                case 5:   message = "5"; break;
                case 6:   message = "6"; break;
                case 7:   message = "7"; break;
                case 8:   message = "8"; break;
                case 9:   message = "9"; break;
                case 10:  message = "10"; break;
                case 11:  message = "Jack"; break;
                case 12:  message = "Queen"; break;
                case 13:  message = "King"; break;
        }
        return message;
    }

    public int totalValue(){
        int total = 0;
        int aceCounter = 0;
        for(int i=0; i<cardUsed ; i++){
            int cardValue = cardValue(hands[i]);
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

    private int cardValue(int index){
        int value = 0;
        switch (index){
            case 10:
            case 11:
            case 12:
            case 13:

            case 23:
            case 24:
            case 25:
            case 26:

            case 36:
            case 37:
            case 38:
            case 39:

            case 49:
            case 50:
            case 51:
            case 52:  value = 10;
            break;

            case 1:
            case 14:
            case 27:
            case 40: value = 1;
            break;

            default: value = cardNumberValue(index);
            break;
        }
        return value;
    }
    
    private int cardNumberValue(int index){
        int value = 0;
        if(index>40){
            index -= 39;
            value = index;
        }
        else if(index>27){
            index -= 26;
            value = index;
        }
        else if(index>14){
            index -= 13;
            value = index;
        }
        else{
            value = index;
        }
        
        return value;
    }


}
