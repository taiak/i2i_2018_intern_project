DECLARE
    i                 NUMBER;
    v_returnref       SYS_REFCURSOR;
    v_subscriber_id   NUMBER;
    v_usage_id        NUMBER;
    v_usage_type      cell2i.usage.usage_type%TYPE;
    v_used_amount     cell2i.usage.used_amount%TYPE;
    v_start_date      VARCHAR2(20);

BEGIN 
    v_returnref:= cell2i.cell2i_utility.get_usageinfo('5318929025','SMS');
    LOOP FETCH v_returnref INTO
    v_usage_type,
    v_used_amount,
    v_start_date; exit WHEN
    v_returnref%notfound;
    dbms_output.put_line(v_used_amount);
    END LOOP;

end;
/