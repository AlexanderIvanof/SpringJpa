# Select all row in left table where is no telephones
select * from contact c left join contact_tel_detail ct
on c.id = ct.contact_id
where ct.contact_id is null;