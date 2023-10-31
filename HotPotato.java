
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
        //Initialization of imports and CircularlyLinkedList class
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        CircularlyLinkedList<String> playerList = new CircularlyLinkedList<>();
     
        

        //start of the game prompts.
        int numPlayers = numPlayers(scanner);
        fillPlayerList(scanner, playerList, numPlayers);
        System.out.println("Players:" + playerList.toString());
        //game Loop until one player is left 
        gameLoop(playerList, random, scanner);
        //Game over message when there is one player left
        System.out.println("GAME OVER!\n");
        System.out.println("The winner is: " + playerList.getFirstElement());

    }

    public static void gameLoop(CircularlyLinkedList<String> playerList, Random random, Scanner scanner) {
        String currentPlayer;
        int randomMoves;
        String eliminatedPlayer; 
        while (playerList.size() > 1) {
            System.out.println("====================");
             randomMoves = randomTimesInput(scanner);
             

            for (int move = 0; move < randomMoves; move++) {
                currentPlayer = playerList.getFirstElement();
                playerList.rotateCCW();
                 // Get the player with the potato
                System.out.println("Has potato: " + currentPlayer);
            }
            currentPlayer = playerList.getFirstElement();
            System.out.println("Has potato " + currentPlayer);
            System.out.println("STOP!");
            
            
            eliminatedPlayer = playerList.removeFirst(); // Remove the player who was eliminated
            System.out.println("Players left: " + playerList.toString());
            System.out.println("====================");
            
        }
}

    public static int randomTimesInput(Scanner scanner) {
        System.out.print("Random time: ");
        return scanner.nextInt(20);
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
