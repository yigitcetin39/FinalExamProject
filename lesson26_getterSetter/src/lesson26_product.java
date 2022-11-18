public class lesson26_product {
    public lesson26_product(int _id, String _name, String _description, double _price, int _stockAmount,String _renk){
        System.out.println("Blok çalıştı");
        this._id = _id;
        this._description = _description;
        this._name = _name;
        this._price = _price;
        this._stockAmount = _stockAmount;
        this._renk = _renk;
    }
    public lesson26_product(){

    }

    // Method Overloading...

    private int _id;
    private String _name;
    private String _description;
    private double _price;
    private int _stockAmount;
    private String _renk;
    private String _kod;

    //getter
    public int getId(){
        return _id;
    }

    //setter
    public void setId(int id){
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
    }

    public int getStockAmount() {
        return _stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        _stockAmount = stockAmount;
    }

    public String getRenk() {
        return _renk;
    }

    public void setRenk(String renk) {
        _renk = renk;
    }

    public String getKod() {
        return _kod;
    }

    public void setKod(String kod) {
        _kod = kod;
    }
}
