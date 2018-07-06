BEGIN

        
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,sub_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('532'));
    
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