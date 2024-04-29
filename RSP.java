import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {
        //色宣言
        final String GREEN = "\u001b[00;32m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";
        final String RED = "\u001b[00;35m";
        
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            try {
                //参加者の手の設定
                System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper\nYour hand is: ");
                int player_hand = Integer.parseInt(scan.nextLine());

                int enemy_hand_1 = random.nextInt(3); 
                System.out.println("Enemy 1 hand is: " + enemy_hand_1);

                int enemy_hand_2 = random.nextInt(3); 
                System.out.println("Enemy 2 hand is: " + enemy_hand_2);

                System.out.print("Result: ");
                String result = determineResult(player_hand, enemy_hand_1, enemy_hand_2);
                
                //結果の表示
                switch (result) {
                    case "draw":
                        System.out.println(GREEN + "Draw! Let's play again!");
                        continue; //あいこで継続
                    case "player":
                        System.out.println(YELLOW + "You win!");
                        break;
                    case "enemy1":
                        System.out.println(PURPLE + "Enemy 1 wins!");
                        break;
                    case "enemy2":
                        System.out.println(PURPLE + "Enemy 2 wins!");
                        break;
                    case "playerandenemy1":
                        System.out.println(YELLOW + "Player and Enemy 1 win!");
                        break;
                    case "playerandenemy2":
                        System.out.println(YELLOW + "Player and Enemy 2 win!");
                        break;
                    case "enemy1andenemy2":
                        System.out.println(PURPLE + "Enemies 1 and 2 win!");
                        break;
                    default:
                        break;
                }
                break; //あいこ以外でループ脱出
            } catch (NumberFormatException e) {
                System.out.println(RED + "0,1,2を入力してください");
                // 正しい入力を促す
            }
        }

        scan.close();
    }

    private static String determineResult(int player, int enemy1, int enemy2) {
        boolean playerWinsEnemy1 = win(player, enemy1);
        boolean playerWinsEnemy2 = win(player, enemy2);
        boolean enemy1WinsPlayer = win(enemy1, player);
        boolean enemy1WinsEnemy2 = win(enemy1, enemy2);
        boolean enemy2WinsPlayer = win(enemy2, player);
        boolean enemy2WinsEnemy1 = win(enemy2, enemy1);
        
        //勝敗判定(勝った人を返す)
        if (player == enemy1 && player == enemy2) {
            return "draw";  
        } else if (playerWinsEnemy1 && playerWinsEnemy2) {
            return "player";
        } else if (enemy1WinsPlayer && enemy1WinsEnemy2) {
            return "enemy1";
        } else if (enemy2WinsPlayer && enemy2WinsEnemy1) {
            return "enemy2";
        } else if (playerWinsEnemy2 && enemy1WinsEnemy2) {
            return "playerandenemy1";
        } else if (playerWinsEnemy1 && enemy2WinsEnemy1) {
            return "playerandenemy2";
        } else if (enemy1WinsPlayer && enemy2WinsPlayer) {
            return "enemy1andenemy2";
        } else {
            return "draw"; 
        }
    }
    
    private static boolean win(int move1, int move2) { // 1つ目の手が勝つ場合、TRUE
        return (move1 == 0 && move2 == 1) || (move1 == 1 && move2 == 2) || (move1 == 2 && move2 == 0);
    }
}
