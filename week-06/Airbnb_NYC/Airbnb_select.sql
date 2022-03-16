-- Always set the context.
-- To simplify code samples, we will omit the `use` statement
-- moving forward and assume it is present.
use airbnb_nyc;

select        -- the `select` keyword
    name,     -- one or more column expressions, separated by commas
    host_name
from listing; -- `from` keyword, then table name, then semicolon