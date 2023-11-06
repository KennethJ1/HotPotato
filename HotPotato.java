package HotPotato;

/**
 *This program runs the hot potato game, prompting the user to input 
 * a number of players and player names. The game prompts the user if they would 
 * like to switch the location of two of the players in the circle. 
 * They can answer (Y/N). The game then runs prompting the user after each round
 * how many times they would like to randomly pass the potato around the circle. 
 * 
 */

/**
 *
 * @author kmf.joseph
 */
import java.util.Scanner;
import java.util.Random;

public class HotPotato {

    public static void main(String[] args) {
        // Initialization of imports and CircularlyLinkedList class
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        CircularlyLinkedList<String> playerList = new CircularlyLinkedList<>();

        // start of the game prompts.
        int numPlayers = numPlayers(scanner);
        fillPlayerList(scanner, playerList, numPlayers);
        System.out.println("Players:" + playerList.toString());
        // game Loop until one player is left
        gameLoop(playerList, random, scanner);
        // Game over message when there is one player left
        System.out.println("GAME OVER!\n");
        System.out.println("The winner is: " + playerList.getFirstElement());

    }

    public static void gameLoop(CircularlyLinkedList<String> playerList, Random random, Scanner scanner) {
        String currentPlayer;
        int randomMoves;

        while (playerList.size() > 1) {
            exchangePlayers(playerList, scanner);
            System.out.println("====================");
            randomMoves = randomTimesInput(scanner);

            for (int move = 1; move < randomMoves; move++) {
                currentPlayer = playerList.getFirstElement();
                playerList.rotateCCW();
                // Get the player with the potato
                System.out.println("Has potato: " + currentPlayer);
            }

            System.out.println("Has potato: " + playerList.getFirstElement());
            System.out.println("STOP!");

            playerList.removeFirst(); // Remove the player who was eliminated

            System.out.println("Players left: " + playerList.toString());
            playerList.rotateCCW();
            System.out.println("====================");

        }
    }

    private static void exchangePlayers(CircularlyLinkedList<String> playerList, Scanner scanner) {
        System.out.println("Switch Players? (Y/N)?");
        var answer=scanner.next();
        if (!answer.equals("Y"))
        {
            return;
        }
        System.out.println("Who:");
        String who = scanner.next();
        System.out.println("With:");
        String with = scanner.next();
        if (!checkIfInputInList(who, playerList)){
            System.out.println(String.format("Player %s not in list"));
        }
        if (!checkIfInputInList(with, playerList)){
            System.out.println(String.format("Player %s not in list"));
        }
        playerList.exchangeTwoPlayers(who, with);
        System.out.println(playerList.toString());
    }

    private static Boolean checkIfInputInList(String input, CircularlyLinkedList<String> playerList) {
        return playerList.toString().contains(input);
    }

    public static int randomTimesInput(Scanner scanner) {
        int randomMoves = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Random time: ");

            if (scanner.hasNextInt()) {
                randomMoves = scanner.nextInt();
                if (randomMoves >= 1 && randomMoves <= 20) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a number between 1 and 20.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume invalid input
            }
        }

        return randomMoves;
    }

    public static int numPlayers(Scanner scanner) {
        System.out.println("Please enter the number of players: ");
        return scanner.nextInt();

    }

    public static void fillPlayerList(Scanner scanner,
            CircularlyLinkedList<String> playersList, int numPlayers) {
        scanner.nextLine();
        for (int playerNum = 1; playerNum <= numPlayers; playerNum++) {
            System.out.print("Enter name of player " + playerNum + ": ");
            String playerName = scanner.nextLine();
            playersList.addAsLast(playerName);
        }

    }
}