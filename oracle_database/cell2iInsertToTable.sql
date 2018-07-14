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

    
      
END;
