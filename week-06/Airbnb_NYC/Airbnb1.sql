use airbnb_nyc;
/*
select
    name,
    host_name
from listing
where name like '%clean';


select
    name,
    host_name
from listing
where host_name like '_o__';  
  
  
  select *
from listing
where neighbourhood in ('Bayside', 'Eltingville', 'Jackson Heights', 'Van Nest');
   
   
   select *
from listing
where neighbourhood_group not in ('Manhattan', 'Bronx', 'Brooklyn');
   
   
   select *
from listing
where reviews_per_month in (5, 6, 7, 8);
 
 
 select *
from listing
where reviews_per_month between 5 and 8;


select *
from listing
where last_review between '2018-10-01' and '2019-02-01';
  
  
    select *
  from listing
  where price > 155.0
  and price < 225.0;

 
 select
    name,
    host_name
from listing
order by host_name asc;
  
  
  select
    name,
    host_name
from listing
order by host_name desc;
  
  
  select
    name,
    neighbourhood_group,
    neighbourhood,
    host_name
from listing
where price > 200
order by neighbourhood_group asc, neighbourhood asc;
	 
    
    select
    name,
    neighbourhood_group,
    neighbourhood,
    price
from listing
order by neighbourhood_group asc, neighbourhood asc, price desc;
  
 
 select 
    name,
    host_name
from listing
where neighbourhood = 'Hell''s Kitchen'
order by price desc;

 
 select
    name,
    neighbourhood,
    price
from listing
order by price asc
limit 7;

 
 select
    name,
    neighbourhood,
    price
from listing
order by price desc
limit 7;
  
  
  select
    name,
    neighbourhood,
    price
from listing
order by price desc
limit 10, 7; -- 10 is offset, 7 is count


select * from listing limit 0;        -- zero rows returned
select * from listing limit 5000, 10; -- no rows available after row 4849


select
    name,
    price * minimum_nights, -- the min price we could pay
    number_of_reviews / 25.0 
        * calculated_host_listings_count  -- a "credibility" score
from listing;
 
 
 select
    name,  
    price * minimum_nights, -- the min price we could pay
    number_of_reviews / 25.0 
        * calculated_host_listings_count  -- a "credibility" score
from listing
where number_of_reviews / 25.0 
        * calculated_host_listings_count > 5.0
order by price * minimum_nights desc;
 
 
 select
    name,
    host_name
from listing
where number_of_reviews / 25.0 
        * calculated_host_listings_count > 5.0
order by price * minimum_nights desc;
 
  
  select
    name,
    concat(neighbourhood_group, ": ", neighbourhood)
from listing;
  
  
  select
    name,
    host_name,
    price,
    year(last_review)
from listing
where year(last_review) + 1 = year(now());


select
    name
from listing
where ifnull(reviews_per_month, 0) = 0; -- null values are replaced with 0


 
 -- If reviews_per_month is 0, make it null.
-- Then exclude all null values.
select
    name,
    reviews_per_month
from listing
where nullif(reviews_per_month, 0) is not null;
  
  
  select
    name,  
    price * minimum_nights, -- the min price we could pay
    number_of_reviews / 25.0 
        * calculated_host_listings_count  -- a "credibility" score
from listing;
 
 
 select
    name,  
    price * minimum_nights as 'min_price',
    number_of_reviews / 25.0 
        * calculated_host_listings_count as 'credibility'
from listing;


select
    name,  
    price * minimum_nights min_price, -- as and quotes not required
    number_of_reviews / 25.0 
        * calculated_host_listings_count credibility
from listing;
*/

select
    name 'description', -- while we're at it, name is more like a description
    host_name 'host',   -- host remains host even after schema changes
    price * minimum_nights 'min_price',
    number_of_reviews / 25.0 
        * calculated_host_listings_count 'credibility'
from listing;