package 第８章密結合;

import java.util.List;

public class DiscountManager {
	List<Product> discountProducts;
	int totalPrice;

	/**
	 * 商品を追加する
	 * @param product			商品
	 * @param productDiscount	商品割引情報
	 * @return	追加に成功した場合true
	 */
	boolean add(Product product, ProductDiscount productDiscount) {
		// 商品情報のチェック
		if(product.id < 0) {
			throw new IllegalArgumentException();
		}
		if(product.name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if(product.price <0) {
			throw new IllegalArgumentException();
		}
		if(product.id != productDiscount.id) {
			throw new IllegalArgumentException();
		}
		
		// 割引価格の取得
		int discountPrice = getDiscountPrice(product.price);
		
		// 割引価格の適用可否によって登録する商品の金額を設定
		int tmp;
		if(productDiscount.canDiscount) {
			tmp = totalPrice + discountPrice;
		}else {
			tmp = totalPrice + product.price;
		}
		
		// 上限の20,000円であれば追加
		if(tmp <= 20_000) {
			totalPrice = tmp;
			discountProducts.add(product);
			return true;
		}else {			
			return false;
		}
	}

	/**
	 * 割引価格を取得する
	 * @param price 商品価格
	 * @return 割引価格
	 */
	static int getDiscountPrice(int price) {
		int discountPrice = price -300;
		if(discountPrice < 0) {
			discountPrice =0;
		}
		return discountPrice;
	}
}



// 商品
class Product{
	int id;			// 商品ID
	String name;	// 商品名
	int price;		// 価格
	boolean canDiscount;	//新規追加：下記割引可能ならtrue
}

// 商品割引情報
class ProductDiscount{
	int id;					// 商品ID
	boolean canDiscount;	// 割引可能な場合true
}