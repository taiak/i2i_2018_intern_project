DECLARE
    i                 NUMBER;
    v_returnref       SYS_REFCURSOR;
    v_subscriber_id   NUMBER;
    v_invoice_date    VARCHAR2(20);
    v_due_date        VARCHAR2(20);
    v_msisdn          VARCHAR2(10);
    v_first_name      VARCHAR2(40);
    v_last_name       VARCHAR2(40);
    v_tariff_name     VARCHAR2(40);
    v_granted_voice   NUMBER;
    v_granted_sms     NUMBER;
    v_granted_data    NUMBER;
    v_usage_id        NUMBER;
    v_usage_type      cell2i.usage.usage_type%TYPE;
    v_used_amount     cell2i.usage.used_amount%TYPE;
    v_start_date      VARCHAR2(20);
    v_end_date        VARCHAR2(20);
    v_total_amount    NUMBER;
    v_status          NUMBER;

BEGIN 
    v_returnref:= cell2i.cell2i_utility.get_invoiceinfo('5318929025');   
    LOOP FETCH v_returnref INTO
    v_invoice_date,
    v_due_date,
    v_total_amount,
    v_status; exit WHEN
    v_returnref%notfound;
    dbms_output.put_line(v_invoice_date||' '||v_due_date||' '||v_total_amount||' '||v_status);
    END LOOP;

end;
/