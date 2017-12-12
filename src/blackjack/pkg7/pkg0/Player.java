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

    public Player(){

    }

    public void drawCard(){

        hands[i] = playingCard[getIndex()];
        i++;
        cardUsed++;
    }

    public void getCard(){
        for(int i=0 ; i<cardUsed ; i++){
            System.out.println(getCardSymbol(hands[i]));
        }
    }

    private String getCardSymbol(int index){
        String message = null;
        if(index>=40){
            index -= 39;
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
            
            message += " of Diamond";
        }
        else if(index>=27){
            index -= 26;
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
            
            message += " of Clubs";
        }
        else if(index>=14){
            index -= 13;
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
            
            message += " of Hearts";
        }
        else{
           
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

        message += " of Spades";
        }


        return message;
    }

    public int totalValue(){
        int total = 0;
        int aceCounter = 0;
        for(int i=0; i<cardUsed ; i++){
            if(cardValue(hands[i]) == 1 || cardValue(hands[i]) == 14 || cardValue(hands[i]) == 27 || cardValue(hands[i]) == 40 ){
                aceCounter++;
            }
            else{
                total += cardValue(hands[i]);
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

            default: break;
        }

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

        return value;
    }




//    public int getCardValue(){
//        int aceCount = 0;
//        int value = 0;
//        for(int i=0 ; i<10 ; i++){
//            int test = hands[i];
//
//            switch(test){
//                case 1:
//                case 14:
//                case 27:
//                case 40: aceCount++;
//                break;
//
//                case 10:
//                case 11:
//                case 12:
//                case 13:
//
//                case 23:
//                case 24:
//                case 25:
//                case 26:
//
//                case 36:
//                case 37:
//                case 38:
//                case 39:
//
//                case 49:
//                case 50:
//                case 51:
//                case 52:  value = 10;
//
//                default: break;
//            }
//
//            if(test>40){
//                test -= 39;
//            }
//            else if(test>27){
//                test -= 26;
//            }
//            else if(test>14){
//                test -= 13;
//            }
//
//        }
//    }


}
