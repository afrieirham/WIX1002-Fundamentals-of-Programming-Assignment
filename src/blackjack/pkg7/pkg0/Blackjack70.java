package blackjack.pkg7.pkg0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack70 {

    public static void main(String[] args) {

        int money = 1000;
        boolean gameEnd = false;
        int bet = 0;

        while(true){
            do{
                System.out.print("Bet: ");
                Scanner input = new Scanner(System.in);
                bet = input.nextInt();

                if( bet > money){
                    System.out.println("Tf");
                }
            }while(bet>money);
            if(bet == 0){break;}

            boolean game = playBlackjack();

            if(game){
                //Player Wins
                money += bet;
            }
            else{
                money -= bet;
            }

            if(money == 0){
                break;
            }


        }
    }

    public static boolean playBlackjack(){
        Deck playingCard = new Deck();

        playingCard.createFullDeck();
        playingCard.shuffleCard();


        Player P1 = new Player();
        Player P2 = new Player();

        P1.drawCard();
        P1.drawCard();

        P2.drawCard();
        P2.drawCard();

        System.out.println("P1:");
        P1.getCard();
        System.out.println("P2:");
        P2.getCard();
        
        P1.totalValue();
        P2.totalValue();
        
        System.out.println("Total P1 = " + P1.totalValue());
        System.out.println("Total P2 = " + P2.totalValue());



        return false;
    }

}
