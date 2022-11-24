public class lesson30_overriding {
    public static void main(String[] args){
        lesson30_baseCreditManager[] creditManagers = new lesson30_baseCreditManager[]
                {new lesson30_teacherCreditManager(),new lesson30_agricultureCreditManager(), new lesson30_studentsCreditManager()};

        for(lesson30_baseCreditManager creditManager : creditManagers){
            System.out.println(creditManager.hesapla(1000));
        }
    }
}
