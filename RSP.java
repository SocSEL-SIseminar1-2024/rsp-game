import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		//再戦のためのflagの宣言
		boolean rematchflag = true;
		//勝利数を数える変数の宣言
		int wincount = 0;
		int losecount = 0;
		int drawcount = 0;
		
		while (rematchflag) {
			// プレイヤーの手を入力
			System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
			Scanner scan = new Scanner(System.in);
			int player_hand = Integer.parseInt(scan.nextLine());
	
			// 相手の手を決定
			int enemy_hand = getRandomInt(2);
			System.out.println(" Enemy hand is: " + enemy_hand);
	
			System.out.print("Result: ");
			// 勝敗判定
			switch (player_hand) {
				case 0:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Draw!");
							drawcount++;
							break;
						case 1:
							System.out.println(YELLOW + "You win!");
							wincount++;
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							losecount++;
							break;
						default:
							break;
					}
					break;
				case 1:
					switch (enemy_hand) {
						case 0:
							System.out.println(GREEN + "Draw!");
							drawcount++;
							break;
						case 1:
							System.out.println(YELLOW + "You win!");
							wincount++;
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							losecount++;
							break;
						default:
							break;
					}
					break;
				case 2:
					switch (enemy_hand) {
						case 0:
							System.out.println(YELLOW + "You win!");
							wincount++;
							break;
						case 1:
							System.out.println(PURPLE + "Enemy win!");
							losecount++;
							break;
						case 2:
							System.out.println(GREEN + "Draw!");
							drawcount++;
							break;
						default:
							break;
					}
					break;
				default:
					break;
			}
			//戦績の表示
			System.out.print("Now Recode ==>");
			System.out.print(" Win:" + wincount);
			System.out.print(", Lose:" + losecount);
			System.out.println(", Draw:" + drawcount);
			//再戦の要求
			System.out.println("Do you want to rematch ?");
			System.out.print("No:0 ,Yes:1 ==> ");
			int rematch_request = Integer.parseInt(scan.nextLine());
			switch (rematch_request) {
				case 0:
					System.out.println("Finish!");
					rematchflag = false;
					break;
				case 1:
					System.out.println("Rematch!");
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
