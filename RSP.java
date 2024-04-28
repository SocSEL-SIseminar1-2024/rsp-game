import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
        	int end = 0; 
		final String GREEN = "\u001b[00;32m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
        	Scanner scan = new Scanner(System.in);
        
		// プレイヤーの手を入力
		while(end == 0) {
            	System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is : ");
			int player_hand = Integer.parseInt(scan.nextLine());
			// 相手の手を決定
			int enemy_hand = getRandomInt(3);
			System.out.println("Enemy hand is: " + enemy_hand);
	
			System.out.print("Result: ");
			// 勝敗判定+叩いてかぶってじゃんけんポン
			if(player_hand == enemy_hand) {
				System.out.println(GREEN + "Draw!");
			} else if((player_hand < 2 && player_hand < enemy_hand) || (player_hand == 2 && enemy_hand == 0)) {
				System.out.println(YELLOW + "You win RSP!");
                		System.out.print("Please input your action! 0:Guard 1:Attack\nYour action is : ");
               	 		long timeStart = System.currentTimeMillis();
                		boolean tmp = false;
                		while((System.currentTimeMillis() - timeStart) < 500 || !tmp){
                    			int player_action = Integer.parseInt(scan.nextLine());
                    			if(player_action == 1 && ((System.currentTimeMillis() - timeStart) < 3000)) {
                        			System.out.println(YELLOW + "You win!");
                        			tmp = true;
                        			end++;
                        			scan.close();
                    			} else {
                        			System.out.println(YELLOW + "You lose Guard and attack.... continue!");
                        			tmp = true;
                    			}
               	 		}
				
        		} else {
				System.out.println(PURPLE + "Enemy win RSP!");
				System.out.print("Please input your action! 0:Guard 1:Attack\nYour hand is : ");
                		long timeStart = System.currentTimeMillis();
                		boolean tmp = false;
                		while((System.currentTimeMillis() - timeStart) < 30 || !tmp){
                    			int player_action = Integer.parseInt(scan.nextLine());
                    			if(player_action == 0 && ((System.currentTimeMillis() - timeStart) < 3000)) {
                        			System.out.println(YELLOW + "You win Guard and attack! continue!");
                        			tmp = true;
                    			} else {
                        			System.out.println(PURPLE + "Enemy win!");
                        			tmp= true;
                        			end++;
                        			scan.close();
                    			}
                		}
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
