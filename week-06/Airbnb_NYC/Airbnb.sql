use airbnb_nyc;

select *
from listing
where neighbourhood = 'Williamsburg'
and (reviews_per_month is null
    or reviews_per_month = 0);