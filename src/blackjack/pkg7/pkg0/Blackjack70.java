package blackjack.pkg7.pkg0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack70 {

    public static void main(String[] args) {

        System.out.println("Welcome to Blackjack!");
        System.out.print("Please enter your name: ");
        Scanner userName = new Scanner(System.in);
        String name = userName.next();

        int money = 1000;
        boolean gameEnd = false;
        int bet = 0;

        Deck playingCard = new Deck();
        playingCard.createFullDeck();
        playingCard.shuffleCard();

        while(true){
            do{
                System.out.print(name);
                System.out.println(", you have RM" + money + ".");
                System.out.print("Bet: RM");
                Scanner input = new Scanner(System.in);
                bet = input.nextInt();

                if( bet > money){
                    System.out.println("Tf");
                }
            }while(bet>money);
            if(bet == 0){break;}

            boolean game = playBlackjack(name);

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

    public static boolean playBlackjack(String name){

        Player P1 = new Player(name);
        Player P2 = new Player();

        P1.drawCard();
        P1.drawCard();

        P2.drawCard();
        P2.drawCard();

        int playerValue = P1.totalValue();
        int dealerValue = P2.totalValue();

        if(playerValue == 21){
            System.out.println("You Win");
            System.out.println("You got a Blackjack!");
            System.out.println("Your card:");
            P1.getAllCard();
            return true;

        }
        if(dealerValue == 21){
            System.out.println("You Lose");
            System.out.println("Dealer got a Blackjack!");
            System.out.println("Dealer's card:");
            P2.getAllCard();
            return false;
        }

        while(true){
            System.out.println("");
            System.out.println("");
            System.out.println(P1.name + ": Your Hand ");
            System.out.println("--------------");
            P1.getAllCard();
            P1.totalValue();
            System.out.println("Total Hand = " + P1.totalValue());
            System.out.println("--------------");

            System.out.println("");
            System.out.println("");
            System.out.println("Dealer:");
            System.out.println("--------------");
            P2.getCard(0);
            P2.totalValue();
            System.out.println("[HIDDEN]");
            System.out.println("--------------");
            System.out.println("");
            System.out.println("");
            Scanner input = new Scanner(System.in);
            int userMove;
            do{
                System.out.println("1 - Hit");
                System.out.println("2 - Stand");
                userMove = input.nextInt();
                if(userMove != 1 && userMove != 2){
                    System.out.println("Please make a valid move.");
                }
            }while(userMove != 1 && userMove != 2);

            if(userMove == 2){
                break;
            }
            if(userMove == 1){
                P1.drawCard();
                P1.totalValue();
                if(P1.totalValue() > 21){
                    System.out.println(name + ", you bust!");
                    System.out.println("--------------");
                    P1.getAllCard();
                    System.out.println("Total Hand = " + P1.totalValue());
                    System.out.println("--------------");
                    return false;
                }
            }

        }


        return false;
    }

}
