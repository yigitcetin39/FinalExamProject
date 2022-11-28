# EtiyaAkademi

>- **<h3>Soru 1</h3> --Verilen sipariş başlıklarını en azdan en çok ' a sırala:**

```
SELECT at.name as "Sipariş başlıkları",COUNT(*) as "Sayısı" FROM orders o
right join address a
on o.addressid=a.id
inner join addresstitle at
on at.id=a.addresstitleid
GROUP BY at.name
ORDER BY COUNT(*) ASC
 
```
#### Kod Çıktısı :

![1](https://user-images.githubusercontent.com/96656340/204249629-f18ef316-c121-4991-8d54-7c5ff68d0e5a.PNG)


-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 2</h3> Hangi kargo şirketinin ne kadar teslimat yaptığını büyükten küçüğe sırala:**

```
SELECT c.name as "Kargo",COUNT(o.cargoid) "Sipariş Sayısı" FROM orders o
right join cargo c
on c.id=o.cargoid
GROUP BY c.name
ORDER BY COUNT(o.cargoid) DESC
 
```

#### Kod Çıktısı :

![2](https://user-images.githubusercontent.com/96656340/204251764-4ac2f75d-c3d2-491c-aa58-a892857dc620.PNG)

-----------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 3</h3> Stok sayısı 10 ile 50 arasındaki product ' ları bize getir**

```
SELECT * from products
WHERE stock BETWEEN 10 AND 50
 
```

#### Kod Çıktısı :


![3](https://user-images.githubusercontent.com/96656340/204253222-2ca45c3d-22f3-49ff-8b8f-078d2ac1b30a.PNG)

---------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 4</h3> Kot ile jean in bize stok sayısını getirsin (in kullanımı)**


```
SELECT name as "Ürün adı", stock as "Stoğu" FROM products
WHERE name IN('coat','jean','tshirt')
 
```

#### Kod Çıktısı :

![4](https://user-images.githubusercontent.com/96656340/204256031-42308eb5-b90f-48f8-98b3-f1a43b2ee2c9.PNG)


---------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 5</h3> Product'ı olan veya olmayan bütün kategorileri bize göster**


```
Select * from categories c
left join productcategories pc
on c.id=pc.categoryid
 
```

#### Kod Çıktısı :

![5](https://user-images.githubusercontent.com/96656340/204257203-74c8dc2c-44d4-47b5-b226-9c132f930ec5.PNG)


---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 6</h3>Product ı olmayan kategorileri bize göster :**


```
Select c.id, COUNT(productid) from categories c
left join productcategories pc
on c.id=pc.categoryid
group by c.id
HAVING COUNT(productid)<1
 
```
#### Kod Çıktısı :


![6](https://user-images.githubusercontent.com/96656340/204257677-7abdde31-d37e-4532-ad22-fd361ed96013.PNG)


---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 7</h3>Hangi kategoriden kaç tane product var**

```
Select c.id, COUNT(productid) from categories c
left join productcategories pc
on c.id=pc.categoryid
group by c.id
 
```
#### Kod Çıktısı :

![7](https://user-images.githubusercontent.com/96656340/204258177-be8e2ccd-23c7-485e-ab9d-37f13eb4fa0a.PNG)

---------------------------------------------------------------------------------------------------------------



>- **<h3>Soru 8</h3>Product tablosuna ismi shoes olan - 230 unitprice 'ı olan ve 150 adet stock ' u olan ve rengi mavi olan 1 tane daha ürün ekle :**


```
INSERT INTO products (name,unitprice,stock,colorsizeid) VALUES('shoes',230,150,3)
 
```

#### Kod Çıktısı :

![8](https://user-images.githubusercontent.com/96656340/204259063-8aa08718-edf9-4ec6-b9e4-a57d11107718.PNG)

---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 9</h3>Colors tablosundan black rengini sil. :**


```
DELETE FROM colors
WHERE id = 6
 
```

#### Kod Çıktısı :

![9](https://user-images.githubusercontent.com/96656340/204259564-0886904a-f89c-4db7-bf15-07b52025b548.PNG)

---------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 10</h3>Products tablosundaki tshirt ün fiyatını 60 , stoğunu da 80 olarak güncelle**


```
UPDATE products
SET stock = 80, unitprice = 60
WHERE id = 4
 
```

#### Kod Çıktısı :

![10](https://user-images.githubusercontent.com/96656340/204260227-eb64d408-789a-405b-8f1e-c530bd9a161b.PNG)


---------------------------------------------------------------------------------------------------------------

>- **<h3>Soru 11</h3>Hangi bedenden kaç adet var küçükten büyüğe sıralayanız**


```
SELECT s.name,COUNT(cl.sizeid) FROM colorsizerelations cl
right join size s
on cl.sizeid=s.id
GROUP BY s.name
ORDER BY COUNT(cl.sizeid) ASC
 
```

#### Kod Çıktısı :

![11](https://user-images.githubusercontent.com/96656340/204260818-1a410d01-8f83-48cc-a7ad-5156904ac840.PNG)



---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 12</h3>Unitprice ı 20 ile 90 arasında olanları bize göster**


```
SELECT name as "Ürün adı ", unitprice as "Fiyat" FROM products
WHERE unitprice BETWEEN '20' AND '90'

 
```

#### Kod Çıktısı :

![12](https://user-images.githubusercontent.com/96656340/204261446-aa295453-d0e1-467a-86b4-287753b3433b.PNG)


---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 13</h3>Kargo ismine hepsijet firmasını ekle**


```
INSERT INTO cargo (name) VALUES ('hepsijet')
 
```

#### Kod Çıktısı :

![13](https://user-images.githubusercontent.com/96656340/204261926-c1ce4450-4872-419b-944f-5e7f82f78ffa.PNG)


---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 14</h3>İllere göre alınan sipariş sayısını göster**


```
SELECT c.name,COUNT(a.cityid) FROM address a
right join city c
on a.cityid=c.id
inner join orders o
on o.addressid=a.id
GROUP BY c.name
 
```

#### Kod Çıktısı :

![14](https://user-images.githubusercontent.com/96656340/204262449-52c75aa8-6b06-4e34-8c44-7802de438e50.PNG)


---------------------------------------------------------------------------------------------------------------


>- **<h3>Soru 15</h3>1 ten fazla product a sahip olan kategorileri göster**


```
Select c.id as "Kategori ID", COUNT(productid) as "Sayısı" from categories c
left join productcategories pc
on c.id=pc.categoryid
group by c.id
HAVING COUNT(productid)>1
 
```

#### Kod Çıktısı :

![15](https://user-images.githubusercontent.com/96656340/204262836-67948736-7f57-44e2-8fa0-5309aeaf4999.PNG)
