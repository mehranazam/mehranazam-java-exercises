use airbnb_nyc;

select *
from listing
where neighbourhood_group = 'Manhattan'
and reviews_per_month is null;