package com.etiya.ecommercedemo5.business.constants;

public class Messages {
    public static class Category{
        public static final String CategoryExistsWithSameName = "CategoryExistsWithSameName";
        public static final String CheckIfExistsCategoryId = "CheckIfExistsCategoryId";
        public static final String addCategory= "addCategory";
        public static final String getAllCategory= "getAllCategory";
        public static final String getByCategoryId = "getByCategoryId";
        public static final String runTimeException = "runTimeExceptionCategory";
        public static final String getByCategoryName = "getByCategoryName";
        public static final String getByPage = "getByPage";
    }

    public static class Address{
        public static final String CheckIfExistsAddressId = "CheckIfExistsAddressId";
        public static final String addAddress= "addAddress";
        public static final String getStreet="getStreet";
        public static final String getAllAddress= "getAllAddress";
        public static final String getByAddressId = "getByAddressId";
        public static final String runTimeException = "runTimeExceptionAddress";
        public static final String getByPage = "getByPage";
    }

    public static class Exception {
        public static final String badRequest = "badRequest";
        public static final String noSuchException = "noSuchException";
        public static final String validationException = "validationException";

        public static final String runTimeException = "runTimeException";
        public static final String getByPage = "getByPage";
    }

    public static class AddressTitle {
        public static final String CheckIfExistsAddressTitleId = "CheckIfExistsAddressTitleId";
        public static final String addAddressTitle= "addAddressTitle";
        public static final String getAllAddressTitle= "getAllAddressTitle";
        public static final String getByAddressTitleId = "getByAddressTitleId";
        public static final String runTimeException = "runTimeExceptionAddressTitle";
        public static final String getByAddressTitleName = "getByAddressTitleName";
        public static final String AddressTitleExistsWithSameName = "AddressTitleExistsWithSameName";
        public static final String getByPage = "getByPage";
    }

    public static class Customer {
        public static final String CheckIfExistsCustomerId = "CheckIfExistsCustomerId";
        public static final String addCustomer="addCustomer";
        public static final String getAllCustomers= "getAllCustomers";
        public static final String getByCustomerId= "getByCustomerId";
        public static final String runTimeException = "runTimeExceptionCustomer";
        public static final String getFirstName="getFirstName";
        public static final String getLastName="getLastName";
        public static final String getByPage = "getByPage";
    }

    public static class City {
        public static final String CheckIfExistsCityId = "CheckIfExistsCityId";
        public static final String addCity="addCity";
        public static final String getAllCities= "getAllCities";
        public static final String getByCityId= "getByCityId";
        public static final String runTimeException = "runTimeExceptionCity";
        public static final String getByCityName = "getByCityName";
        public static final String existCity = "existCity";
        public static final String CityExistsWithSameName = "CityExistsWithSameName";
        public static final String getByPage = "getByPage";
    }

    public static class Color {
        public static final String CheckIfExistsColorId = "CheckIfExistsColorId";
        public static final String addColor="addColor";
        public static final String getAllColor= "getAllColor";
        public static final String getByColorId= "getByColorId";
        public static final String runTimeException = "runTimeExceptionColor";
        public static final String getByColorName = "getByColorName";
        public static final String ColorExistsWithSameName = "ColorExistsWithSameName";
        public static final String getByPage = "getByPage";
    }

    public static class ColorSizeRelation {
        public static final String CheckIfExistsColorSizeRelationId = "CheckIfExistsColorSizeRelationId";
        public static final String addColorSizeRelation="addColorSizeRelation";
        public static final String getAllColorSizeRelation= "getAllColorSizeRelation";
        public static final String getByColorSizeRelationId= "getByColorSizeRelationId";
        public static final String runTimeException = "runTimeExceptionColorSizeRelation";
        public static final String getByColorSizeRelationName = "getByColorSizeRelationName";
        public static final String getByPage = "getByPage";
    }

    public static class MoneyType {
        public static final String CheckIfExistsMoneyTypeId = "CheckIfExistsMoneyTypeId";
        public static final String addMoneyType="addMoneyType";
        public static final String getAllMoneyType= "getAllMoneyType";
        public static final String getByMoneyTypeId= "getByMoneyTypeId";
        public static final String runTimeException = "runTimeExceptionMoneyType";
        public static final String getByMoneyTypeName = "getByMoneyTypeName";
        public static final String MoneyTypeExistsWithSameName = "MoneyTypeExistsWithSameName";
        public static final String getByPage = "getByPage";
    }

    public static class Order {
        public static final String CheckIfExistsOrderId = "CheckIfExistsOrderId";
        public static final String getOrderDate = "getOrderDate";
        public static final String addOrder="addOrder";
        public static final String getAllOrder= "getAllOrder";
        public static final String getByOrderId= "getByOrderId";
        public static final String runTimeException = "runTimeExceptionOrder";
        public static final String getByOrderName = "getByOrderName";
        public static final String getAllOrderByCargoCompany = "getAllOrderByCargoCompany";
        public static final String getByPage = "getByPage";

    }

    public static class Payment {
        public static final String CheckIfExistsPaymentId = "CheckIfExistsPaymentId";
        public static final String addPayment="addPayment";
        public static final String getAllPayment= "getAllPayment";
        public static final String getByPaymentId= "getByPaymentId";
        public static final String runTimeException = "runTimeExceptionPayment";
        public static final String getByPaymentName = "getByPaymentName";
        public static final String PaymentExistsWithSameName = "PaymentExistsWithSameName";
        public static final String getByPage = "getByPage";


    }

    public static class ProductCategory {
        public static final String CheckIfExistsProductCategoryId = "CheckIfExistsProductCategoryId";
        public static final String addProductCategory="addProductCategory";
        public static final String getAllProductCategory= "getAllProductCategory";
        public static final String getByProductCategoryId= "getByProductCategoryId";
        public static final String runTimeException = "runTimeExceptionProductCategory";
        public static final String getByProductCategoryName = "getByProductCategoryName";
        public static final String getByPage = "getByPage";

    }

    public static class Product {
        public static final String CheckIfExistsProductId = "CheckIfExistsProductId";
        public static final String addProduct="addProduct";
        public static final String getAllProduct= "getAllProduct";
        public static final String getByProductId= "getByProductId";
        public static final String runTimeException = "runTimeExceptionProduct";
        public static final String getByProductName = "getByProductName";
        public static final String getProductStartingWith = "getProductStartingWith";
        public static final String getProductLike = "getProductLike";
        public static final String getStockDesc = "getStockDesc";
        public static final String getByProductAllName = "getByProductAllName";
        public static final String getByColorSizeIdProduct = "getByColorSizeIdProduct";
        public static final String getByPage = "getByPage";
        public static final String getBySlice = "getBySlice";
        public static final String ProductExistsWithSameName = "ProductExistsWithSameName";
        public static final String getProductGreaterThanStock = "getProductGreaterThanStock";


    }

    public static class Size {
        public static final String CheckIfExistsSizeId = "CheckIfExistsSizeId";
        public static final String addSize="addSize";
        public static final String getAllSize= "getAllSize";
        public static final String getBySizeId= "getBySizeId";
        public static final String runTimeException = "runTimeExceptionSize";
        public static final String getBySizeName = "getBySizeName";
        public static final String getBySizeGreaterThanStock = "getBySizeGreaterThanStock";
        public static final String SizeExistsWithSameName = "SizeExistsWithSameName";
        public static final String getByPage = "getByPage";
    }

    public static class Cargo {
        public static final String CheckIfExistsCargoId = "CheckIfExistsCargoId";
        public static final String addCargo="addCargo";
        public static final String getAllCargo= "getAllCargo";
        public static final String getByCargoId= "getByCargoId";
        public static final String runTimeExceptionCargo = "runTimeExceptionCargo";
        public static final String getByCargoName = "getByCargoName";
        public static final String CargoExistsWithSameName = "CargoExistsWithSameName";
        public static final String getCargoPriceGreaterThan = "getCargoPriceGreaterThan";
        public static final String getByPage = "getByPage";
    }




}
