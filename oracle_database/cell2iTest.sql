DECLARE
    i                NUMBER;
    v_returnref      SYS_REFCURSOR;
    v_subscriber_id         NUMBER;
    v_invoice_id     VARCHAR2(100);
    v_invoice_date   DATE;
    v_due_date       DATE;
    v_total_amount   NUMBER;
    v_open_amount    NUMBER; 
    v_usage_type     VARCHAR2(20);
    v_used_amount    NUMBER;
    v_usage_id       NUMBER;
    v_start_date     DATE;

BEGIN 
/*
     v_returnref := cell2i.cell2i_utility.get_invoiceinfo('12345'); 
    LOOP FETCH v_returnref INTO
    v_subscriber_id,
    v_invoice_id,
    v_invoice_date,
    v_due_date,
    v_total_amount,
    v_open_amount; exit WHEN
    v_returnref%notfound;
    dbms_output.put_line(v_sub_id);
    END
loop;
*/
  /*  v_returnref:= cell2i.cell2i_utility.get_usageinfo(5318929025);
    LOOP FETCH v_returnref INTO
    v_subscriber_id,
    v_usage_type,
    v_used_amount,
    v_start_date,
    v_usage_id;    exit WHEN
    v_returnref%notfound;
    dbms_output.put_line(v_used_amount);
    END LOOP;
    */
    v_subscriber_id:=cell2i.cell2i_utility.get_id('5318929025');
--    i:=cell2i_utility.check_user_is_valid('532212','1234532');
--    dbms_output.put_line(i);
    --i:=cell2i_utility.change_password('5318929025','zeynep1*');
    dbms_output.put_line(v_subscriber_id);
end;
/