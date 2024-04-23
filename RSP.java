import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		// テキストに使う色の宣言
		final String GREEN = "\u001b[00;31m";
		final String YELLOW = "\u001b[00;33m";
		final String PURPLE = "\u001b[00;34m";
        System.out.println("Please choose game mode 0:normal 1:Osaka janken");
        Scanner scan = new Scanner(System.in);
        int gamemode = Integer.parseInt(scan.nextLine());
        //ゲームモードで別のゲームを選べる
        if (gamemode == 0) {
            System.out.println("noraml janken");
            // プレイヤーの手を入力
            System.out.println("Please input your hand! 0:Rock 1:Scissors 2:Paper\n Your hand is : ");
            int player_hand = Integer.parseInt(scan.nextLine());
            scan.close();

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
        }
        //大阪じゃんけん
        else if(gamemode == 1){
            System.out.println("Osaka janken");
            //プレイヤーの手を入力
            System.out.println("Please input your hand! 0:Rock 1:Scissors 2:Paper");
            int player_hand = Integer.parseInt(scan.nextLine());
            if(player_hand == 0){
                System.out.println(" Your hand is: " + player_hand + " :Rock");
            }
            else if(player_hand == 1){
                System.out.println(" Your hand is: " + player_hand + " :Scissors");
            }
            else{
                System.out.println(" Your hand is: " + player_hand + " :Paper");
            }
            scan.close();
            // 相手の手を決定
            int enemy_hand = getRandomInt(2);
            if(enemy_hand == 0){
                System.out.println(" Enemy hand is: " + enemy_hand + " :Rock");
            }
            else if(enemy_hand == 1){
                System.out.println(" Enemy hand is: " + enemy_hand + " :Scissors");
            }
            else{
                System.out.println(" Enemy hand is: " + enemy_hand + " :Paper1");
            }

            System.out.print("Result: ");
            
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
