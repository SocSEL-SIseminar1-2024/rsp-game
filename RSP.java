import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// プレイヤーの手を入力
		System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		Scanner scan = new Scanner(System.in);
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(3);
		System.out.println(" Enemy hand is: " + enemy_hand);

		System.out.print("Result: ");
        judge(player_hand, enemy_hand);
		
    }

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}

    //勝敗判定
    private static void judge(int player_hand, int enemy_hand) {
        // テキストに使う色の宣言
        //Drawはgreen、Winはyellow、Loseはpurple
		final String DrawColor = "\u001b[00;32m";
		final String WinColor = "\u001b[00;33m";
		final String LoseColor = "\u001b[00;34m";
        
        if (player_hand == enemy_hand) {
            System.out.println(DrawColor + "Draw");
        } else if ((player_hand == 0 && enemy_hand == 1) || (player_hand == 1 && enemy_hand == 2) || (player_hand == 2 && enemy_hand == 0)) {
            System.out.println(WinColor + "You Win!");
        } else {
            System.out.println(LoseColor + "You Lose...");
        }
    }
}
