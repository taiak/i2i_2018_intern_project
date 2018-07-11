DECLARE
    i NUMBER;
BEGIN
   -- cell2i.cell2i_utility.usage_insert('5497952991','SMS',300,sysdate,usage_seq.nextval);
    --cell2i.cell2i_utility.subscriber_insert(subscriber_seq.nextval,'1478523690','aaaa','hamza','cakmak','Esnaf Tarifesi');
    --cell2i.cell2i_utility.tariff_insert(tariff_seq.nextval,'Ciklet Tarifesi',10000,10000,10000);
    i:=cell2i.cell2i_utility.usage_insert('5446787655','VOICE',122,usage_seq.nextval);
    i:=i+cell2i.cell2i_utility.usage_insert('5446787655','SMS',245,usage_seq.nextval);
    i:=i+cell2i.cell2i_utility.usage_insert('5446787655','DATA',970,usage_seq.nextval);
    
    
    dbms_output.put_line(i);
    commit;
/*
    
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5344098872'),'SMS',350,cell2i_utility.get_startdayfrominvoice('5344098872'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5344098872'),'VOICE',300,cell2i_utility.get_startdayfrominvoice('5344098872'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5344098872'),'DATA',1230,cell2i_utility.get_startdayfrominvoice('5344098872'),usage_seq.nextval);       
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5335972016'),'SMS',550,cell2i_utility.get_startdayfrominvoice('5335672016'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5335972016'),'VOICE',250,cell2i_utility.get_startdayfrominvoice('5335672016'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5335972016'),'DATA',1440,cell2i_utility.get_startdayfrominvoice('5335672016'),usage_seq.nextval);


    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5318929025'),'SMS',400,cell2i_utility.get_startdayfrominvoice('5318929025'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5318929025'),'VOICE',420,cell2i_utility.get_startdayfrominvoice('5318929025'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5318929025'),'DATA',1025,cell2i_utility.get_startdayfrominvoice('5318929025'),usage_seq.nextval);

    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5369722537'),'SMS',120,cell2i_utility.get_startdayfrominvoice('5369722537'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5369722537'),'VOICE',150,cell2i_utility.get_startdayfrominvoice('5369722537'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5369722537'),'DATA',850,cell2i_utility.get_startdayfrominvoice('5369722537'),usage_seq.nextval);

    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5497952991'),'SMS',100,cell2i_utility.get_startdayfrominvoice('5497952991'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5497952991'),'VOICE',600,cell2i_utility.get_startdayfrominvoice('5497952991'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5497952991'),'DATA',1850,cell2i_utility.get_startdayfrominvoice('5497952991'),usage_seq.nextval);

    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5446787655'),'SMS',958,cell2i_utility.get_startdayfrominvoice('5446787655'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5446787655'),'VOICE',456,cell2i_utility.get_startdayfrominvoice('5446787655'),usage_seq.nextval);
    INSERT INTO usage (subscriber_id,usage_type,used_amount,start_date,usage_id) VALUES (cell2i_utility.get_id('5446787655'),'DATA',1456,cell2i_utility.get_startdayfrominvoice('5446787655'),usage_seq.nextval);
*/

    --.INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,37,0,get_id('5344098872'));
    /*
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,40,1,cell2i_utility.get_id('5497952991'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('5369722537'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,30,1,cell2i_utility.get_id('5318929025'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('5335972016'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,status,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,40,0,cell2i_utility.get_id('5446787655'));
*/

    commit;
        
END;
