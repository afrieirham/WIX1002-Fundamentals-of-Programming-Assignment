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
        int gamePlay = 0;

        Deck playingCard = new Deck();
        playingCard.createFullDeck();
        playingCard.shuffleCard();

        while(true){
            do{
                Scanner input = new Scanner(System.in);

                System.out.println("");
                System.out.println("1 - Play");
                System.out.println("0 - Exit");
                System.out.print("Enter [1] to play: ");
                gamePlay = input.nextInt();
                if(gamePlay == 0){
                    System.out.println("");
                    System.out.println("");
                    System.out.println("_______________________________________");
                    System.out.println("Thank you for playing.");
                    System.out.println("Congratulations!");
                    System.out.println("You leave with RM" + money);
                    System.out.println("Play again next time!");
                    break;
                }
                System.out.println("");
                System.out.println("");
                System.out.println(name + ", you have RM" + money + ".");
                System.out.println("Place your bet:");
                System.out.print("RM");
                bet = input.nextInt();

                if( bet > money || bet == 0){
                    System.out.println("Make a realistic bet.");
                }
            }while(bet>money || bet == 0);
            if(gamePlay == 0){break;}
            boolean game = playBlackjack(name, money, bet);

            if(game){
                //Player Wins
                money += bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else{
                money -= bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }

            if(money == 0){
                System.out.println("");
                System.out.println("You're kicked.");
                System.out.println("_______________________________________");
                System.out.println(name + ",");
                System.out.println("You are out of money.");
                System.out.println("Don't gamble again!");
                break;
            }


        }
    }

    public static boolean playBlackjack(String name, int money, int bet){

        Player P1 = new Player(name);
        Player P2 = new Player("Dealer");

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
            System.out.println(P1.name + "'s hand: ");
            System.out.println("--------------");
            P1.getAllCard();
            P1.totalValue();
            System.out.println("______________");
            System.out.println("Total: " + P1.totalValue());
            System.out.println("--------------");

            System.out.println("");
            System.out.println("");
            System.out.println(P2.name + "'s hand: ");
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
                System.out.print("Your move: ");
                userMove = input.nextInt();
                if(userMove != 1 && userMove != 2){
                    System.out.println("Please make a valid move.");
                }
            }while(userMove != 1 && userMove != 2);

            if(userMove == 2){
                break;
            }
            if(userMove == 1){
                System.out.println(P1.name + ": Hit!");
                P1.drawCard();
                P1.totalValue();
                if(P1.totalValue() > 21){
                    System.out.println(P1.name + ": Bust!");
                    System.out.println("--------------");
                    P1.getAllCard();
                    System.out.println("______________");
                    System.out.println("Total: " + P1.totalValue());
                    System.out.println("--------------");
                    return false;
                }
            }

        }

        System.out.println(P1.name + ": Stand!");
        System.out.println("Dealer:");
        System.out.println("--------------");
        P2.getAllCard();
        System.out.println("______________");
        System.out.println("Total: " + P2.totalValue());
        System.out.println("--------------");
        System.out.println("");

        while(P2.totalValue() <=17 ){
            System.out.println(P2.name + ": Hit!");
            P2.drawCard();
            P2.totalValue();
            if(P2.totalValue() > 21){
                System.out.println(P2.name + ": Bust!");
                System.out.println("");
                System.out.println(P2.name + "'s hand:");
                System.out.println("--------------");
                P2.getAllCard();
                System.out.println("______________");
                System.out.println("Total: " + P2.totalValue());
                System.out.println("--------------");
                return true;
            }
        }
        System.out.println("");
        System.out.println("Dealer's hand:");
        System.out.println("--------------");
        P2.getAllCard();
        System.out.println("______________");
        System.out.println("Total: " + P2.totalValue());
        System.out.println("--------------");

        if(P1.totalValue() > P2.totalValue()){
            System.out.println(P1.name + ": Wins!");
            System.out.println(P2.name + ": Lose!");
            System.out.println(P1.name + " total: " + P1.totalValue());
            System.out.println(P2.name + " total: " + P2.totalValue());
            return true;
        }
        else if(P1.totalValue() < P2.totalValue()){
            System.out.println(P2.name + ": Wins!");
            System.out.println(P1.name + ": Lose!");
            System.out.println(P2.name + " total: " + P2.totalValue());
            System.out.println(P1.name + " total: " + P1.totalValue());
            return false;
        }
        else{
            System.out.println("Push!");
            System.out.println(P1.name + " total: " + P1.totalValue());
            System.out.println(P2.name + " total: " + P2.totalValue());
            money += bet;
            return false;
        }



    }

}
