use airbnb_nyc;

-- DOES NOT WORK.
select * from listing
where reviews_per_month <= 0;

-- DOES NOT WORK.
select * from listing
where reviews_per_month = 0;

-- DOES NOT WORK.
select * from listing
where reviews_per_month = '';

-- DOES NOT WORK.
-- Even an explicit check for the null value doesn't work.
select * from listing
where reviews_per_month = null;