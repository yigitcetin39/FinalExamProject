public class lesson25_attribute {
    public static void main(String[] args){
        lesson25_product product1 = new lesson25_product();
        product1.name = "Laptop";
        product1.id = 1;
        product1.description = "Asus Laptop";
        product1.price = 5000;
        product1.stockAmount = 3;


        lesson25_productManager productManager = new lesson25_productManager();
        productManager.Add(product1);

    }
}
