import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {
        // テキストに使う色の宣言
        final String GREEN = "\u001b[00;31m";
        final String YELLOW = "\u001b[00;33m";
        final String PURPLE = "\u001b[00;34m";
        final String BLUE = "\u001b[00;36m"; // 新しい色を追加

        // プレイヤーの手を入力
        System.out.print("Please input your hand! 0:Rock 1:Scissors 2:Paper 3:Pistol\n Your hand is : "); // ピストルの手を追加
        Scanner scan = new Scanner(System.in);
        int player_hand = Integer.parseInt(scan.nextLine());
        scan.close();

        // 相手の手を決定
        int enemy_hand = getRandomInt(3); // ピストルの手を追加に伴い、範囲を修正
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
                    case 3:
                        System.out.println(BLUE + "You win!"); // ピストルの勝ちを追加
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
                    case 3:
                        System.out.println(BLUE + "You win!"); // ピストルの勝ちを追加
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
                    case 3:
                        System.out.println(BLUE + "You win!"); // ピストルの勝ちを追加
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (enemy_hand) {
                    case 0:
                        System.out.println(PURPLE + "Enemy win!"); // ピストルの負けを追加
                        break;
                    case 1:
                        System.out.println(GREEN + "Draw!"); // ピストルの引き分けを追加
                        break;
                    case 2:
                        System.out.println(YELLOW + "You win!"); // ピストルの勝ちを追加
                        break;
                    case 3:
                        System.out.println(GREEN + "Draw!"); // ピストル同士の引き分けを追加
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
