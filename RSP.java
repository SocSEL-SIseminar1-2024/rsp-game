import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";

		Scanner scan = new Scanner(System.in);
		System.out.print("Please select the mode! 0:Normal 1:Reverse\n Your mode is : ");
		int mode = Integer.parseInt(scan.nextLine());
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(2);
		System.out.println(" Enemy hand is: " + enemy_hand);

		System.out.print("Result: ");
		// 勝敗判定
		if (mode == 0) {
			switch (player_hand) {
				case 0:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Draw!");
							break;
						case 1:
							System.out.println(YELLOW + "You win!");
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							break;
						default:
							break;
					}
					break;
				case 1:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Enemy win!");
							break;
						case 1:
							System.out.println(YELLOW + "Draw!");
							break;
						case 2:
							System.out.println(PURPLE + "you win!");
							break;
						default:
							break;
					}
					break;
				case 2:
					switch (enemy_hand) {
						case 0:
							System.out.println(YELLOW + "You win!");
							break;
						case 1:
							System.out.println(PURPLE + "Enemy win!");
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
		} else {
			switch (player_hand) {
				case 0:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Draw!");
							break;
						case 1:
							System.out.println(PURPLE + "Enemy win!");
							break;
						case 2:
							System.out.println(YELLOW + "You win!");
							break;
						default:
							break;
					}
					break;
				case 1:
					switch (enemy_hand) {
						case 0:
							System.out.println(YELLOW + "You win!");
							break;
						case 1:
							System.out.println(GREEN + "Draw!");
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							break;
						default:
							break;
					}
					break;
				case 2:
					switch (enemy_hand) {
						case 0:
							System.out.println(PURPLE + "Enemy win!");
							break;
						case 1:
							System.out.println(YELLOW + "You win!");
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
		}
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
