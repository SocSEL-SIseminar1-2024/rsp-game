import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		// プレイヤーの手の候補入力

		Scanner scan = new Scanner(System.in);
		try{
		System.out.print("Please input your candidate of the hand two! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		int player_hand_1 = Integer.parseInt(scan.nextLine());
		System.out.print(" or ");
		int player_hand_2 = Integer.parseInt(scan.nextLine());

		// 相手の手の候補決定
		int enemy_hand_1 = getRandomInt(2);
		int enemy_hand_2 = getRandomInt(2);
		System.out.println(" Enemy hand is: " + enemy_hand_1 + " or " +enemy_hand_2);

		//自分の手の最終決定
		System.out.print("Please input your final hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		int player_hand = Integer.parseInt(scan.nextLine());
		if ((player_hand==player_hand_1) || (player_hand == player_hand_2)){
			break;
		} else {
			System.out.println("Please inuput" + player_hand_1 +"or"+player_hand_2);
		}
		} catch (NumberFormatException e) {
			System.out.println("Please input number");

		//相手の手を最終決定
		int random_choice = getRandomInt(1); // 0または1のランダムな値を取得
            	int enemy_hand;
            	if (random_choice == 0) {
                	enemy_hand = enemy_hand_1;
            	} else {
                	enemy_hand = enemy_hand_2;
            	}

		scan.close();

		System.out.print("Result: ");
		// 勝敗判定
		if (player_hand == enemy_hand){
			System.out.println(GREEN + "Draw!");
		} else if((player_hand+1==enemy_hand) ||(player_hand-2==enemy_hand)){
			System.out.println(YELLOW + "You win!");
		} else{
			System.out.println(PURPLE + "Enemy win!");
		}
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
