import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		// プレイヤーの手を入力
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		Scanner scan = new Scanner(System.in);
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(2);
		System.out.println(" Enemy hand is: " + enemy_hand);

		System.out.print("Result: ");
		// 勝敗判定
		switch((player_hand - enemy_hand + 3) % 3){
			case 0:
				System.out.println(GREEN + "DRAW!  ONE MORE!!");
				break;
			case 1:
				System.out.println(PURPLE + "Enemy win!");
				break;
			case 2:
				System.out.println(YELLOW + "You win!");
		}
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
