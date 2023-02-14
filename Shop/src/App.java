
public class App {

	public static void main(String[] args) {
		
		/* DESCRIBE PRODUCT: TITLE, PRICE, CATEGORY
		 * CREATE THREE PRODUCTS; WINE BREAD, ROQUEFORT
		 * DESCRIBE USER: NAME, AGE
		 * CREATE NEW USER: BOB
		 * DESCRIBE SHOPPING CART
		 * CREATE A NEW HOPING CART
		 * SET BOB AS AN OWNER OF SHOPPING CART
		 * ADD PRODUCTS TO BOB`S SHOPPING CART
		 * SHOW SUMM ON SCREEN
		 */
		
		Product wine = new Product();
		wine.title = "Red wine";
		wine.price = 20;
		wine.category = "Alcohol";
		
		Product bread = new Product();
		bread.category = "Wheat bread";
		bread.price = 10;
		bread.category = "Bakery";
		
		Product roquefort = new Product();
		roquefort.category = "Roquefort";
		roquefort.price = 30;
		roquefort.category = "Milk";
		
		User bob = new User();
		bob.name = "Bob";
		bob.age = 16;
		
		ShoppingCart bobShopingCart = new ShoppingCart();
		bobShopingCart.owner = bob;
		bobShopingCart.products.add(wine);
		bobShopingCart.products.add(bread);
		bobShopingCart.products.add(roquefort);
		
		double totalSum = completeOrder(bobShopingCart);
		System.out.println("Total sum: " + totalSum);
	}
	public static double completeOrder(ShoppingCart shoppingCart){
		double sum = 0;
		for (Product product: shoppingCart.products){
			if (shoppingCart.owner.age < 18
					&& product.category.equals("Alcohol")){
				System.out.println("Sorry we can`t sell an Alcohol to you");
			}
			else{
				
				sum = sum + product.price;
			}
		}
		return sum;
	}
}
