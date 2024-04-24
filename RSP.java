import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";

		// プレイヤーと敵の進行距離
	        int player_distance = 0;
	        int enemy_distance = 0;
	        final int GOAL = 30;

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Let's play rock, paper, scissors. " + GOAL + " steps to the goal. ");

		while (player_distance < GOAL && enemy_distance < GOAL) {
			int player_hand = -1; // プレイヤーの手を初期化
		            while (player_hand < 0 || player_hand > 2) {
		                try {
		                    // プレイヤーの手を入力
		                    System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		                    player_hand = Integer.parseInt(scan.nextLine());
		                    if (player_hand < 0 || player_hand > 2) {
		                        System.out.println("Invalid input. Please enter 0, 1, or 2.");
		                    }
		                } catch (NumberFormatException e) {
		                    System.out.println("Invalid input. Please enter an integer.");
		                }
		            }

			// 相手の手を決定
			int enemy_hand = getRandomInt(3);
			System.out.println(" Enemy hand is: " + enemy_hand);

			System.out.print("Result: ");
			// 勝敗判定
			switch (player_hand) {
				case 0:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Draw!");
							break;
						case 1:
							System.out.println(YELLOW + "You win!");
							player_distance += 3;
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							enemy_distance += 3;
							break;
						default:
							break;
					}
					break;
				case 1:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Enemy win!");
							enemy_distance += 3;
							break;
						case 1:
							System.out.println(YELLOW + "Draw!");
							break;
						case 2:
							System.out.println(PURPLE +  "You win!");
							player_distance += 6;
							break;
						default:
							break;
					}
					break;
				case 2:
					switch (enemy_hand) {
						case 0:
							System.out.println(YELLOW + "You win!");
							player_distance += 6;
							break;
						case 1:
							System.out.println(PURPLE + "Enemy win!");
							enemy_distance += 6;
							break;
						case 2:
							System.out.println(GREEN + "Draw!");
							break;
						default:
							break;
					}
					break;
				default:
					break;
			}
			System.out.println("Player distance: " + player_distance + ", Enemy distance: " + enemy_distance);
		}
		if (player_distance >= GOAL) {
	            System.out.println(GREEN + "You reached the goal! You win!");
	        } else {
	            System.out.println(PURPLE + "Enemy reached the goal! You lose!");
	        }

       		 scan.close();
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
