# EtiyaAkademi

>- **<h3>Soru 1</h3>Bugün verilen siparişleri listele :**

```
select * from orders where current_date = date
select current_date as "Bugünün tarihi"
 
```
#### Kod Çıktısı :


![1](https://user-images.githubusercontent.com/96656340/204493462-8e66c1a8-4905-4f96-9938-abc0433d153c.PNG)



-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 2</h3>2021'de  verilen siparişleri listele :**

```
select * from orders where date_part('year', date) = 2021
 
```
#### Kod Çıktısı :


![2](https://user-images.githubusercontent.com/96656340/204493914-87c27c8e-1e54-40b0-bf3f-8c231c01c19e.PNG)


-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 3</h3>Doğum yılı 1995 ve sonrası olan müşterileri listele :**

```

select * from customers where   date_part('year',birth_date) >= 1995
 
```
#### Kod Çıktısı :


![3](https://user-images.githubusercontent.com/96656340/204494151-cdb48c32-71a3-4771-8e59-2cc6df0b47e6.PNG)


-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 4</h3>Son 1 hafta içersinde verilen ve kargosu ptt olan siparişleri listele :**

```

select o.date as "Sipariş Tarihi", c.name as "Kargo Adı" ,count(o.id) as "Sipariş adedi"
from orders o
inner join cargo c on c.id =o.cargoid
where date_part('year',current_date) = date_part('year',o.date)
and date_part('month',current_date) = date_part('month',o.date)
and (date_part('day',current_date) - date_part('day',o.date))<=7
and c.name = 'ptt'
group by o.id,o.date,c.name
 
```
#### Kod Çıktısı :


![4](https://user-images.githubusercontent.com/96656340/204494391-43fde40f-f0bb-4d70-adcf-67153f836053.PNG)


-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 5</h3>Bu yılın bu ayı içerisinde verilen ve Hakan'ın verdiği siparişleri listele :**

```

select c.firstname as "Müşteri Adı", o.date as "Sipariş Tarihi", 
count(o.id) as "Sipariş Sayısı"
from orders o
inner join customers c on c.id = o.customerid
where (extract(year from current_date) = extract(year from o.date))
and (extract(month from current_date) = extract(month from o.date))
and lower(c.firstname) = 'hakan'
group by c.firstname, o.date
 
```
#### Kod Çıktısı :


![5](https://user-images.githubusercontent.com/96656340/204495006-0f771ed4-2c39-4532-81d4-4e288315dba3.PNG)



-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 6</h3>Son 10 gün içerisindeki verilen siparişleri listele :**

```

select * from orders
where date_part('day',current_date::timestamp- date::timestamp) <=10
 
```
#### Kod Çıktısı :


![6](https://user-images.githubusercontent.com/96656340/204495221-ff2a3f3c-79d4-44a3-b645-b66f66f0826c.PNG)


-----------------------------------------------------------------------------------------------------------------



>- **<h3>Soru 7</h3>Son 1 ay içerisinde kategorisi summer olan siparişleri listele :**

```

select o.date as "Sipariş Tarihi", cat.name as "Kategori" from orders o
inner join productcategories pro on pro.productid = o.productid
inner join categories cat on cat.id = pro.categoryid
where cat.name = 'summer' and (date_part('day',current_date) - date_part('day',o.date)) <30
and date_part('month',current_date) = date_part('month', o.date)
and date_part('year',current_date) = date_part('year', o.date)

 
```
#### Kod Çıktısı :


![7](https://user-images.githubusercontent.com/96656340/204495460-f22189dd-c5b6-4771-bafe-73e85ca025b9.PNG)


-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 8</h3>Bu ay içerisinde verilen tshirt siparişlerini ve tarihlerini listele :**

```

select  o.date as "Sipariş Tarihi", pro.name as "Ürün Adı"
from orders o
inner join products pro on o.productid = pro.id
where (extract(year from current_date) = extract(year from o.date))
and (extract(month from current_date) = extract(month from o.date))
and pro.name = 'tshirt'

 
```
#### Kod Çıktısı :


![8](https://user-images.githubusercontent.com/96656340/204495888-705c1938-0acd-4604-8e9b-0452b082ac76.PNG)


-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 9</h3>Ödeme yöntemi cash olan ve 2021 sonrası verilen siparişleri listele :**

```

select * from orders o
inner join payment p on o.paymentid = p.id
inner join moneytype mt on mt.id = p.moneytypeid
where mt.name = 'cash'
and extract(year from o.date)>=2021

 
```
#### Kod Çıktısı :


![9](https://user-images.githubusercontent.com/96656340/204496324-8634b9df-a5d3-40e3-b07e-323772e30fff.PNG)




-----------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 10</h3>İstanbula bu ay içerisinde verilen siparişleri listele :**

```

select city.name as "Şehir", o.date as "Sipariş Tarihi" from orders o
inner join address ad on ad.id = o.addressid
inner join city on city.id = ad.cityid
where city.name = 'istanbul'
and date_part('month',current_date) = date_part('month', o.date)
and date_part('year',current_date) = date_part('year', o.date) 

 
```
#### Kod Çıktısı :


![10](https://user-images.githubusercontent.com/96656340/204496745-7a48a784-55ae-42c3-babf-62f3c10ba7f2.PNG)




-----------------------------------------------------------------------------------------------------------------

























