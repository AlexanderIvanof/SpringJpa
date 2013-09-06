# Select row from left and right table 
#SELECT ... FROM a FULL [OUTER] JOIN b ON a.id=b.id
#is equivalent to
#(SELECT ... FROM a LEFT JOIN b ON a.id=b.id)
#UNION
#(SELECT ... FROM a RIGHT JOIN b ON a.id=b.id)
select * from contact c 
full outer join contact_tel_detail ct
on c.id = ct.contact_id;