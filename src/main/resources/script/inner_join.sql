# Select row from left and right table 
select * from contact c inner join contact_tel_detail ct
on c.id = ct.contact_id;