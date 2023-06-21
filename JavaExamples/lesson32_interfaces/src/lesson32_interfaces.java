public class lesson32_interfaces {
    public static void main(String[] args){
        lesson32_ICostumerDal costumerDal = new lesson32_oracleCostumerDal();
        costumerDal.Add();
    }
}
