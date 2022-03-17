use gravel_family;

/*
SELECT * FROM item
left join unit on item.unit_id = unit.unit_id
left join category on category.category_id = item.category_id;
*/



SELECT item.category_id, avg(price_per_unit) as avg_ppu, max(price_per_unit) as max_ppu, category.`name` FROM item
left join unit on item.unit_id = unit.unit_id
left join category on category.category_id = item.category_id
group by item.category_id, unit.unit_id;
