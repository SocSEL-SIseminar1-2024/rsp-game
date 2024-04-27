import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		int enemy_hand, player_hand;
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;35m";
		final String BLUE = "\u001b[34m";
		final String RED = "\u001b[31m";
        boolean gameFinish = false;
		Scanner scan = new Scanner(System.in);
		
	    while(!gameFinish) {
	    	//状態のリフレッシュ
	        boolean isPlayerWinner = false;
	        boolean isPlayerLoser = false;
	        // プレイヤーの手を入力
			System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
			player_hand = Integer.parseInt(scan.nextLine());
			// 相手の手を決定
			enemy_hand = getRandomInt(3);
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
							isPlayerWinner = true;
							break;
						case 2:
							System.out.println(PURPLE + "Enemy win!");
							isPlayerLoser = true;
							break;
						default:
							break;
					}
					break;
				case 1:
					switch (enemy_hand) {
						case 0:
						     System.out.println(PURPLE + "Enemy win!");
						     isPlayerLoser = true;
						     break;
						 case 1:
						     System.out.println(GREEN + "Draw!");
						     break;
						 case 2:
						     System.out.println(YELLOW + "You win!");
						     isPlayerWinner = true;
						     break;
						 default:
						     break;
					}
					break;
				case 2:
					switch (enemy_hand) {
						case 0:
							System.out.println(YELLOW + "You win!");
							isPlayerWinner = true;
							break;
						case 1:
							System.out.println(PURPLE + "Enemy win!");
							isPlayerLoser = true;
							break;
						case 2:
							System.out.println(GREEN + "Draw!");
							break;
						default:
							break;
					}
					break;
				default:
					System.out.println("無効な入力です");
					break;
			}
				
			// あっち向いてホイ機能
			if (isPlayerWinner || isPlayerLoser ) {
			    System.out.print("あっち向いてほいを始める 0:Up 1:Right 2:Down 3:Left\nYour direction: ");
			    int player_direction = Integer.parseInt(scan.nextLine());
			    int enemy_direction = getRandomInt(4); // 0から3までの数値を正しく生成
			    System.out.println("Enemy direction is: " + enemy_direction);
	
			    if (isPlayerWinner) {
			        if (player_direction == enemy_direction) {
			            System.out.println(RED + "you win");
			            gameFinish = true;
			        } else {
			            System.out.println(BLUE + "retry");
			        }
			    } else {
			        if (player_direction == enemy_direction) {
			            System.out.println(RED + "you lose");
			            gameFinish = true;
			        } else {
			            System.out.println(BLUE + "retry");
			        }
			    }
			}
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
