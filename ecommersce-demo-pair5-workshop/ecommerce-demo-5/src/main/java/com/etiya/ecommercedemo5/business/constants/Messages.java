package com.etiya.ecommercedemo5.business.constants;

public class Messages {
    public static class Category{
        public static final String CategoryExistsWithSameName = "Bu isimle bir kategori mevcut";
    }

    public static class Address{
        public static final String IdExist = "Aynı ";
    }

    public static class Exception {
        public static final String badRequest = "Bad request";
        public static final String noSuchException = "No such exception";
        public static final String validationException = "Validation exception";

        public static final String runTimeException = "This is exists";
    }

    public static class AddressTitle {
        public static final String CheckIfExistsAddressTitleId = "This AddressTitle found";
        public static final String addAddressTitle= "This AddressTitle has been successfully added. ";
        public static final String getAllAddressTitle= "All AddressTitle have been successfully called.";
        public static final String getByAddressTitleId = "This AddressTitle was called successfully";
        public static final String runTimeException = "This AddressTitle not found";
    }

    public static class Customer {
        public static final String CheckIfExistsCustomerId = "This customer  found";
        public static final String createCustomer="This customer has been successfully added. ";
        public static final String getAllCustomers= "All customers have been successfully called.";
        public static final String getByCustomerId= "This customer was called successfully";
        public static final String runTimeException = "This customer not found";
    }

    public static class City {
        public static final String CheckIfExistsCityId = "This city  found";
        public static final String addCity="This city has been successfully added. ";
        public static final String getAllCities= "All ciyt have been successfully called.";
        public static final String getByCityId= "This city was called successfully";
        public static final String runTimeException = "This city not found";
    }



}
