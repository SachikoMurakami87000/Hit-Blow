package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



class hitAndblow{
	
	public static void main(String[] args) {
		
		//乱数発生
		Random random = new Random();
		
		//数字が被らないように乱数を比較
		int[] foo = new int[3];
		
		foo[0] = random.nextInt(9);
		foo[1] = random.nextInt(9);
		foo[2] = random.nextInt(9);
		
		//for文で0と1を比較
		for(;;) {
			if(foo[0] == foo[1]) {
				foo[1] = random.nextInt(9);
			} else {
				break;
			}
		}
		
		for(;;) {
			if(foo[0] == foo[2]) {
				foo[2] = random.nextInt(9);
			} else if(foo[1] == foo[2]) {
				foo[2] = random.nextInt(9);
			} else {
				break;
			}
		}
		
//		for(int i = 0; i > 3; i++) {
//			System.out.println(foo[i]);
//		}
		
		System.out.print(Arrays.toString(foo)); 
			
		//入力用の配列作成
		int[] hoge = new int[3];
		//カウント変数
		int countHit = 0;
		int countBlow = 0;

		for (;;) {
			countHit = 0;
			countBlow = 0;
			
			//答えを入力
			System.out.println("3つの数字を入力してね");
			Scanner scanner = new Scanner(System.in);

			hoge[0] = scanner.nextInt();
			hoge[1] = scanner.nextInt();
			hoge[2] = scanner.nextInt();

			//ヒットの数を数える(ドンピシャで数字が当たっている場合)
			if (foo[0] == hoge[0]) {
				//単行演算子
				countHit++;
			}
			if (foo[1] == hoge[1]) {
				countHit++;
			}
			if (foo[2] == hoge[2]) {
				countHit++;
			}

			//ブローの数を数える(場所は違えど数字が当たっている場合)
			if (foo[0] == hoge[1]) {
				countBlow++;
			}
			if (foo[0] == hoge[2]) {
				countBlow++;
			}
			if (foo[1] == hoge[0]) {
				countBlow++;
			}
			if (foo[1] == hoge[2]) {
				countBlow++;
			}
			if (foo[2] == hoge[0]) {
				countBlow++;
			}
			if (foo[2] == hoge[1]) {
				countBlow++;
			}

			//答えが正解の場合当たりコメント
			if (countHit == 3) {
				System.out.print("A TA RI");
				break;
			} else {
				//結果を表示
				System.out.println("ヒットの数は、" + countHit + "です。");
				//結果を表示
				System.out.println("ブローの数は、" + countBlow + "です。");
			}
		}
	}
}