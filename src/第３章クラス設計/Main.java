package 第３章クラス設計;

import java.util.Currency;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		//　悪いお金クラス
		悪いお金クラス お金インスタンス=new 悪いお金クラス();
		System.out.println(お金インスタンス.通貨単位); //通貨単位を入れずにインスタンス使うと…ヌルポで落ちる!
		お金インスタンス.金額値=100; // マイナスの値でもなんでも入れ放題！
		お金インスタンス.通貨単位=Currency.getInstance(Locale.US);		
		
//		// 100円という金額をもったお金インスタンス
//		ナイスなお金クラス お金インスタンス = new ナイスなお金クラス(100, Currency.getInstance(Locale.US));
//		System.out.println(お金インスタンス.金額);
//		
//		//　↑↑で作ったお金インスタンスに２００円追加
//		お金インスタンス = お金インスタンス.add(new ナイスなお金クラス(200, Currency.getInstance(Locale.US)));
//		System.out.println(お金インスタンス.金額);
	}

}
