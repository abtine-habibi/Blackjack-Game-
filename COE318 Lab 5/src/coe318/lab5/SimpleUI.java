package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("The House is Holding: \n " + this.game.getHouseCards().toString());
        System.out.println("You are Holding: \n" + this.game.getYourCards().toString());
    }

    @Override
    public boolean hitMe() {
        System.out.println("Would you like to hit your cards? (y/n)");
        String d = user.nextLine();
        boolean h = false;

        if (d.equals("y")) {
            h = true;
        } else if (d.equals("n")) {
            h = false;
        } else {
            System.out.println("NOT A VALID INPUT");
        }
        return h;
    }

    @Override
    public void gameOver() {
        this.display();
        int ps = game.score(game.getYourCards());
        int hs = game.score(game.getHouseCards());
        System.out.println("The House scores: " + hs + " You scored: " + ps);
        if (ps > hs || hs > 21 && ps <= 21) {
            System.out.println("You Win!");
        } else {
            System.out.println("The House Wins!");
        }
        System.out.println("Thank you for playing");
    }
}
