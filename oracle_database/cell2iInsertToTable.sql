BEGIN

        
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('532'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate+10,sysdate+40,40,40,cell2i_utility.get_id('533'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate+20,sysdate+50,20,0,cell2i_utility.get_id('534'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate+20,sysdate+50,30,15,cell2i_utility.get_id('535'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate+30,sysdate+60,35,35,cell2i_utility.get_id('536'));
    
    commit;
        
END;
/
TRUNCATE TABLE subscriber;
TRUNCATE TABLE invoice;
TRUNCATE TABLE tariff;
select * from all_indexes where table_name = 'SUBSCRIBER';
/
select * from TARIFF;
/
select * from subscriber;