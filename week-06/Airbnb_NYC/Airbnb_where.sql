use airbnb_nyc;

select
    name,
    neighbourhood,
    host_name
from listing
where host_name = 'Andrea'; -- `where` keyword, then a boolean expression