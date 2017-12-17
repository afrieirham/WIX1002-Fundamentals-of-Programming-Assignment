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
            int game = playBlackjack(name, money, bet);

            if(game == 1){
                //Player Wins
                money += bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else if(game == 2){
                money -= bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else if(game == 3){
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else{
                money = game;
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

    public static int playBlackjack(String name, int money, int bet){

        Player P1 = new Player(name);
        Player P2 = new Player("Dealer");

        Split left = null;
        Split right = null;

        P1.drawCard();
        P1.drawCard();


        P2.drawCard();
        P2.drawCard();

        int playerValue = P1.totalValue();
        int dealerValue = P2.totalValue();
        boolean isSplit = false;

        if(playerValue == 21){
            System.out.println("You Win");
            System.out.println("You got a Blackjack!");
            System.out.println("Your card:");
            P1.getAllCard();
            return 1;

        }
        if(dealerValue == 21){
            System.out.println("You Lose");
            System.out.println("Dealer got a Blackjack!");
            System.out.println("Dealer's card:");
            P2.getAllCard();
            return 2;
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


            if(P1.getCardValue(0) == P1.getCardValue(1)){
                userMove = splitMove();
            }
            else{
                userMove = regularMove();
            }


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
                    return 2;
                }
            }
            ////////////////////////////////////////////////////////////////////
            if(userMove == 3){

                left = new Split(P1.name, P1.getCardValue(0));
                right = new Split(P1.name, P1.getCardValue(1));
                int leftMove = 100;
                int rightMove = 100;
                isSplit = true;

                do{
                   System.out.println("");
                    System.out.println("");
                    System.out.println(P1.name + "'s left hand: ");
                    System.out.println("--------------");
                    left.getAllCard();
                    left.totalValue();
                    System.out.println("______________");
                    System.out.println("Total: " + left.totalValue());
                    System.out.println("--------------");

                    leftMove =  regularMove();

                    if(leftMove == 2){
                        System.out.println(P1.name + "'s left hand: Stands! ");
                        break;
                    }
                    if(leftMove == 1){
                        System.out.println(P1.name + ": Hit!");
                        left.drawCard();
                        left.totalValue();
                        if(left.totalValue() > 21){
                            System.out.println(P1.name + ": Bust!");
                            System.out.println("--------------");
                            left.getAllCard();
                            System.out.println("______________");
                            System.out.println("Total: " + left.totalValue());
                            System.out.println("--------------");
                            return 2;
                        }
                    }
                }while(true);

                do{
                    System.out.println("");
                    System.out.println("");
                    System.out.println(P1.name + "'s right hand: ");
                    System.out.println("--------------");
                    right.getAllCard();
                    right.totalValue();
                    System.out.println("______________");
                    System.out.println("Total: " + right.totalValue());
                    System.out.println("--------------");

                    rightMove =  regularMove();

                    if(rightMove == 2){
                        System.out.println(P1.name + "'s right hand: Stands! ");
                        break;
                    }
                    if(rightMove == 1){
                        System.out.println(P1.name + ": Hit!");
                        right.drawCard();
                        right.totalValue();
                        if(right.totalValue() > 21){
                            System.out.println(P1.name + ": Bust!");
                            System.out.println("--------------");
                            right.getAllCard();
                            System.out.println("______________");
                            System.out.println("Total: " + right.totalValue());
                            System.out.println("--------------");
                            return 2;
                        }
                    }
                }while(true);
                break;
            }

        }

        if(isSplit == false){
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
                    return 1;
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
                return 1;
            }
            else if(P1.totalValue() < P2.totalValue()){
                System.out.println(P2.name + ": Wins!");
                System.out.println(P1.name + ": Lose!");
                System.out.println(P2.name + " total: " + P2.totalValue());
                System.out.println(P1.name + " total: " + P1.totalValue());
                return 2;
            }
            else{
                System.out.println("Push!");
                System.out.println(P1.name + " total: " + P1.totalValue());
                System.out.println(P2.name + " total: " + P2.totalValue());
                return 3;
            }
        }
        else{
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
                    return 1;
                }
            }
            System.out.println("");
            System.out.println("Dealer's hand:");
            System.out.println("--------------");
            P2.getAllCard();
            System.out.println("______________");
            System.out.println("Total: " + P2.totalValue());
            System.out.println("--------------");

            if(left.totalValue() > P2.totalValue()){
                System.out.println("");
                System.out.println(P1.name + "'s left hand: Wins!");
                System.out.println(P2.name + ": Lose!");
                System.out.println(P1.name + "'s left hand total: " + left.totalValue());
                System.out.println(P2.name + " total: " + P2.totalValue());
                money += bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else if(left.totalValue() < P2.totalValue()){
                System.out.println("");
                System.out.println(P2.name + ": Wins!");
                System.out.println(P1.name + "'s left hand: Lose!");
                System.out.println(P2.name + " total: " + P2.totalValue());
                System.out.println(P1.name + "'s left hand total: " + left.totalValue());
                money -= bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else{
                System.out.println("");
                System.out.println("Push!");
                System.out.println(P1.name + "'s left hand total: " + left.totalValue());
                System.out.println(P2.name + " total: " + P2.totalValue());


            }

            if(right.totalValue() > P2.totalValue()){
                System.out.println("");
                System.out.println(P1.name + "'s right hand: Wins!");
                System.out.println(P2.name + ": Lose!");
                System.out.println(P1.name + "'s right hand total: " + right.totalValue());
                System.out.println(P2.name + " total: " + P2.totalValue());
                money += bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else if(right.totalValue() < P2.totalValue()){
                System.out.println("");
                System.out.println(P2.name + ": Wins!");
                System.out.println(P1.name + "'s right hand: Lose!");
                System.out.println(P2.name + " total: " + P2.totalValue());
                System.out.println(P1.name + "'s right hand total: " + right.totalValue());
                money -= bet;
                System.out.println("");
                System.out.println("Current money: RM" + money);
            }
            else{
                System.out.println("");
                System.out.println("Push!");
                System.out.println(P1.name + "'s right hand total: " + right.totalValue());
                System.out.println(P2.name + " total: " + P2.totalValue());

            }
        }
        return money;
    }

    public static int regularMove(){
        int userMove = 100;
        Scanner input = new Scanner(System.in);
        do{
                System.out.println("1 - Hit");
                System.out.println("2 - Stand");
                System.out.print("Your move: ");
                userMove = input.nextInt();
                if(userMove != 1 && userMove != 2){
                    System.out.println("Please make a valid move.");
                }
            }while(userMove != 1 && userMove != 2);

        return userMove;
    }

    public static int splitMove(){
        int userMove = 100;
        Scanner input = new Scanner(System.in);
        do{
                System.out.println("1 - Hit");
                System.out.println("2 - Stand");
                System.out.println("3 - Split");
                System.out.print("Your move: ");
                userMove = input.nextInt();
                if(userMove != 1 && userMove != 2 && userMove != 3){
                    System.out.println("Please make a valid move.");
                }
            }while(userMove != 1 && userMove != 2 && userMove != 3);

        return userMove;
    }

}
