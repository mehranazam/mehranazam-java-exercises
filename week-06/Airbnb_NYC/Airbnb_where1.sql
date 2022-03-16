use airbnb_nyc;

select *
from listing
where ((neighbourhood_group = 'Manhattan' and price < 100)
    or neighbourhood = 'City Island')
and availability_365 > 0;