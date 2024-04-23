import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
        int end = 0; 
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		// プレイヤーの手を入力
		while(end == 0) {
            System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
			Scanner scan = new Scanner(System.in);
			int player_hand = Integer.parseInt(scan.nextLine());
			// 相手の手を決定
			int enemy_hand = getRandomInt(2);
			System.out.println(" Enemy hand is: " + enemy_hand);
	
			System.out.print("Result: ");
			// 勝敗判定
			if(player_hand == enemy_hand) {
				System.out.println(GREEN + "Draw!");
			} else if((player_hand < 2 && player_hand < enemy_hand) || (player_hand == 2 && enemy_hand == 0)) {
				System.out.println(YELLOW + "You win!");
				end++;
                scan.close();
			} else {
				System.out.println(PURPLE + "Enemy win!");
				end++;
                scan.close();
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
