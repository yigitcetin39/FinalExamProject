public class lesson26_getterSetter {
    public static void main(String[] args){
        lesson26_product product = new lesson26_product();
        product.setId(25);
        System.out.println(product.getId());
        product.setName("Laptop");
        System.out.println(product.getName());
    }
}
