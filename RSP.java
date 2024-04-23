import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		Scanner scan = new Scanner(System.in);
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		
		int enemy_hand_1 = getRandomInt(2);
		System.out.println(" Enemy 1 hand is: " + enemy_hand_1);

		int enemy_hand_2 = getRandomInt(2);
		System.out.println(" Enemy 2 hand is: " + enemy_hand_2);

		System.out.print("Result: ");
		
		String result = determineResult(player_hand, enemy_hand_1, enemy_hand_2);
		
        	switch (result) {
            		case "draw":
               			 System.out.println(GREEN + "Draw!");
                		break;
            		case "player":
                		System.out.println(YELLOW + "You win!");
                		break;
            		case "enemy1":
                		System.out.println(PURPLE + "Enemy 1 wins!");
                		break;
            		case "enemy2":
                		System.out.println(PURPLE + "Enemy 2 wins!");
                		break;
            		case "bothEnemies":
               			System.out.println(RED + "Both enemies win!");
                		break;
            		default:
                		break;
        	}
	}

	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
	
    	private static String determineResult(int player, int enemy1, int enemy2) {
        	if (player == enemy1 && player == enemy2) {
            		return "draw";
        	} else if (player == enemy1) {
            		if (win(player, enemy2)) {
                		return "player";
            		} else {
                		return "enemy2";
            		}
        	} else if (player == enemy2) {
            		if (win(player, enemy1)) {
                		return "player";
            		} else {
                		return "enemy1";
            		}
        	} else {
            		if (win(player, enemy1) && win(player, enemy2)) {
                		return "player";
            		} else if (win(enemy1, player) && win(enemy1, enemy2)) {
                		return "enemy1";
            		} else if (win(enemy2, player) && win(enemy2, enemy1)) {
                		return "enemy2";
            		} else {
                		return "draw";
            		}
        	}
    }
    
    private static boolean win(int move1, int move2) {
        return (move1 == 0 && move2 == 1) || (move1 == 1 && move2 == 2) || (move1 == 2 && move2 == 0);
    }

}
