--Kargo şirketi ptt olan siparişleri getir
select * from orders where orders.cargoid=4;

--s harfi ile başlayan ürünleri ve stoğu 25 den büyük olan ürünleri göster

select * from products where lower(name) like 's%' and stock>25;

--Adres id'si 3 olan en çok sipariş edilen ürünler veya ürün

select * from products p 
inner join orders o 
on o.productid=p.id
where o.addressid='3'

--İsmi Hakan olan müşterinin sipariş ettiği ürün id sini ve sipariş tarihini göster.

select o.date, c.firstname, products.name from customers c 
inner join orders o 
on o.customerid=c.id
inner join products on o.productid=products.id
where lower(c.firstname)='hakan'

--İstanbul'dan sipariş edilen ürünler 

select c.name, p.name from products p 
inner join orders o 
on p.id=o.productid
inner join address a
on o.addressid=a.id
inner join city c 
on a.cityid=c.id
where c.name='istanbul'

--RENGİ BLUE OLAN VE Ankaraya SİPARİŞ EDİLEN ÜRÜNLERİ GETİR

select cl.name, p.name, ct.name from products p
inner join orders o
on p.id=o.productid
inner join colorsizerelations co
on co.id=p.colorsizeid
inner join colors cl
on cl.id=co.colorid
inner join address a
on o.addressid=a.id
inner join city ct
on ct.id=a.cityid
where ct.name='ankara'

----BEDENİ LARGE OLAN VE PTT İLE GÖNDERİLEN VE ÖDEME TÜRÜ NAKİT OLAN SİPARİŞLERİ GETİR.

select s.name as size, cargo.name as cargocompany, m.name as moneytype, p.name as product from orders o 
inner join cargo on cargo.id=o.cargoid
inner join products p
on p.id=o.productid
inner join colorsizerelations cs
on cs.id=p.colorsizeid
inner join size s
on s.id=cs.sizeid
inner join payment pa
on pa.id=o.paymentid
inner join moneytype m
on m.id=pa.moneytypeid
where s.name='large' and cargo.name='ptt' and m.name='cash'

--Farklı adreste bulunan ürünlerin kategorisini göster.

select p.name as urunler,ca.name as kategori, a.street as mahalle from address a
inner join customers c 
on c.id=a.customerid
inner join orders o
on c.id=o.customerid
inner join products p 
on p.id=o.productid
inner join productcategories pc
on p.id=pc.productid
inner join categories ca
on ca.id=pc.categoryid
where ca.name='tops'


--Stoklara göre 70 den az olan ürünleri küçükten büyüğe doğru sıralayınız.

select * from products 
where stock < 70 
order by stock asc

--En pahalı ürünü alan müşteriyi ve aldığı ürünü göster(kişiyi ve unitprice ı en fazla olanı göster)

select c.firstname as MusteriAdi, c.lastname as MusteriSoyadi, p.name as satılanurun from orders o
inner join products p
on o.productid=p.id
inner join customers c
on c.id=o.customerid
where p.unitprice=(select max (unitprice) from products)












