BEGIN
/*
    INSERT INTO tariff (tariff_id,name,granted_voice,granted_sms,granted_data) VALUES (tariff_seq.nextval,'Genç Tarife',500,5000,3000);
    INSERT INTO tariff (tariff_id,name,granted_voice,granted_sms,granted_data) VALUES (tariff_seq.nextval,'Taraftar Tarifesi',500,1000,2000);
    INSERT INTO tariff (tariff_id,name,granted_voice,granted_sms,granted_data) VALUES (tariff_seq.nextval,'Sosyal Tarife',100,10000,5000);
    INSERT INTO tariff (tariff_id,name,granted_voice,granted_sms,granted_data) VALUES (tariff_seq.nextval,'Esnaf Tarifesi',1000,2000,2000);
    INSERT INTO tariff (tariff_id,name,granted_voice,granted_sms,granted_data) VALUES (tariff_seq.nextval,'Esnek Tarife',750,3000,4000);

    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5335972016','2016','ERDEM','ÖZGEN',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Esnek Tarife'));
    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5344098872','8872','SENA','UZUN',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Esnaf Tarifesi'));
    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5318929025','9025','RUMEYSA','DÝNÇSOY',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Taraftar Tarifesi'));
    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5497952991','2991','RUMEYSA','TALU',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Sosyal Tarife'));
    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5369722537','2537','HASAN','UYANIK',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Esnek Tarife'));
    INSERT INTO subscriber (subscriber_id,msisdn,password,first_name,last_name,tariff_id) VALUES (subscriber_seq.nextval,'5446787655','7655','AHMET','GENÇ',CELL2I_UTILITY.GET_TARIFF_ID_BYNAME('Sosyal Tarife'));

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
/*
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('5344098872'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,40,40,cell2i_utility.get_id('5497952991'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,0,cell2i_utility.get_id('5369722537'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,30,15,cell2i_utility.get_id('5318929025'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,35,35,cell2i_utility.get_id('5335972016'));
    INSERT INTO invoice (invoice_id,invoice_date,due_date,total_amount,open_amount,subscriber_id) VALUES (invoice_seq.nextval,sysdate,sysdate+30,40,20,cell2i_utility.get_id('5446787655'));
*/

    commit;
        
END;
