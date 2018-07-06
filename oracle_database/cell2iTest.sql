DECLARE
    i                NUMBER;
    v_returnref      SYS_REFCURSOR;
    v_sub_id         NUMBER;
    v_invoice_id     VARCHAR2(100);
    v_invoice_date   DATE;
    v_due_date       DATE;
    v_total_amount   NUMBER;
    v_open_amount    NUMBER; 

BEGIN 
     v_returnref := cell2i.cell2i_utility.get_invoiceinfo('12345'); 
    LOOP FETCH v_returnref INTO
    v_sub_id,
    v_invoice_id,
    v_invoice_date,
    v_due_date,
    v_total_amount,
    v_open_amount; exit WHEN
    v_returnref%notfound;
    dbms_output.put_line(v_sub_id);
    END
loop;

end;
/