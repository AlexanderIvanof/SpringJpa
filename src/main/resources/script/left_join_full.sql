select * from contact c left join contact_tel_detail ct
on c.id = ct.contact_id;