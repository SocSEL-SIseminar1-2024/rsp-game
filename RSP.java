import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
		//言語選択用の変数の宣言
		boolean languageflag = true;
		//言語を選択
		do {
			System.out.println("Please set language e:English j:japanese\n（言語を選択してください e:英語 j:日本語）");
			System.out.print("Your language is （あなたの言語は）: ");
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			if (str.equals("e")) {
				languageflag = false;
				break;
			} else if (str.equals("j")) {
				break;
			}
			System.out.println("Please type it again （もう一度入力してください）");
		}while (true);
		// プレイヤーの手を入力
		if (languageflag) {
			System.out.print("あなたの手を入力してください 0:グー 1:チョキ 2:パー\n　あなたの手は : ");
		} else {
			System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
		}
		Scanner scan = new Scanner(System.in);
		int player_hand = Integer.parseInt(scan.nextLine());
		scan.close();

		// 相手の手を決定
		int enemy_hand = getRandomInt(2);
		if (languageflag) {
			System.out.println(" 相手の手は  : " + enemy_hand);
		} else {
			System.out.println(" Enemy hand is: " + enemy_hand);
		}

		if (languageflag) {
			System.out.println("結果: ");
		} else {
			System.out.print("Result: ");
		}
		// 勝敗判定
		switch (player_hand) {
			case 0:
				switch (enemy_hand) {
					case 0:
						if (languageflag) {
							System.out.println(GREEN +"引き分け！");
						} else {
							System.out.println(GREEN + "Draw!");
						}
						break;
					case 1:
						if (languageflag) {
							System.out.println(YELLOW +"あなたの勝利！");
						} else {
							System.out.println(YELLOW + "You win!");
						}
						break;
					case 2:
						if (languageflag) {
							System.out.println(PURPLE +"相手の勝利！");
						} else {
							System.out.println(PURPLE + "Enemy win!");
						}
						break;
					default:
						break;
				}
				break;
			case 1:
				switch (enemy_hand) {
					case 0:
						if (languageflag) {
							System.out.println(GREEN + "引き分け！");
						} else {
							System.out.println(GREEN + "Draw!");
						}
						break;
					case 1:
						if (languageflag) {
							System.out.println(YELLOW +"あなたの勝利！");
						} else {
							System.out.println(YELLOW + "You win!");
						}
						break;
					case 2:
						if (languageflag) {
							System.out.println(PURPLE +"相手の勝利！");
						} else {
							System.out.println(PURPLE + "Enemy win!");
						}
						break;
					default:
						break;
				}
				break;
			case 2:
				switch (enemy_hand) {
					case 0:
						if (languageflag) {
							System.out.println(YELLOW +"あなたの勝利！");
						} else {
							System.out.println(YELLOW + "You win!");
						}
						break;
					case 1:
						if (languageflag) {
							System.out.println(PURPLE +"相手の勝利！");
						} else {
							System.out.println(PURPLE + "Enemy win!");
						}
						break;
					case 2:
						if (languageflag) {
							System.out.println(GREEN + "引き分け！");
						} else {
							System.out.println(GREEN + "Draw!");
						}
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	// 受け取った範囲でランダムな数値を生成
	private static int getRandomInt(int range) {
		Random random = new Random();
		int random_num = random.nextInt(range);
		return random_num;
	}
}
