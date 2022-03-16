use airbnb_nyc;

select
    name,
    neighbourhood,
    host_name,
    availability_365
from listing
where host_name = 'Andrea'
    or availability_365 = 0; -- `and`: both conditions must be true