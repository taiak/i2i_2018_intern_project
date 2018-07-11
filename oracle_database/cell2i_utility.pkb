create or replace PACKAGE BODY CELL2I_UTILITY AS
   
     FUNCTION control_rowcount(pin_rowcount NUMBER) RETURN NUMBER AS
        v_control_num NUMBER;
        BEGIN
            v_control_num:=pin_rowcount;
            IF v_control_num < 1 THEN
                RETURN 0;
            ELSE
                RETURN 1;
            END IF;
        END control_rowcount;
        
    FUNCTION check_user_is_valid(pis_searchMsisdn subscriber.msisdn%TYPE, pis_searchPassword subscriber.password%TYPE) RETURN NUMBER IS
        v_exist NUMBER;
        BEGIN                    
            SELECT COUNT(*) INTO v_exist FROM subscriber  WHERE msisdn = pis_searchMsisdn AND password = pis_searchPassword;
            RETURN v_exist;
    END check_user_is_valid; 

    FUNCTION change_password(pis_searchMsisdn subscriber.msisdn%TYPE, pis_newPassword subscriber.password%TYPE)RETURN NUMBER AS
        v_row_count NUMBER;
        BEGIN
            UPDATE subscriber 
            SET password = pis_newPassword
            WHERE msisdn = pis_searchMsisdn;
            v_row_count:=sql%rowcount;
            RETURN control_rowcount(v_row_count);
        END change_password;
        
    FUNCTION get_id(pis_msisdn subscriber.msisdn%TYPE) RETURN NUMBER AS
        v_subscriber_id NUMBER;
        BEGIN
            SELECT subscriber_id INTO v_subscriber_id FROM subscriber WHERE msisdn = pis_msisdn;
            RETURN v_subscriber_id;
        END get_id;
    
   
    
    FUNCTION get_tariff_id_byname(pis_tariffname tariff.name%TYPE) RETURN NUMBER AS
        v_tariff_id NUMBER;
        BEGIN
            SELECT tariff_id INTO v_tariff_id FROM tariff WHERE name = pis_tariffname;
            RETURN v_tariff_id;
        END get_tariff_id_byname;
    
    FUNCTION get_tariff_id_bysubmsisdn(pis_msisdn subscriber.msisdn%TYPE) RETURN NUMBER AS
        v_tariff_id NUMBER;
        BEGIN
            SELECT tariff_id INTO v_tariff_id FROM subscriber WHERE msisdn = pis_msisdn;
            RETURN v_tariff_id;
        END get_tariff_id_bysubmsisdn;
        

    FUNCTION get_invoiceinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
      v_refcursor SYS_REFCURSOR;
      v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= cell2i_utility.get_id(pis_msisdn);
        OPEN v_refcursor FOR 'SELECT subscriber_id,invoice_id,invoice_date,due_date,total_amount,open_amount FROM invoice_info WHERE subscriber_id = :v_subscriber_id' USING  v_subscriber_id;
    RETURN v_refcursor;
    END get_invoiceinfo;
    
    FUNCTION get_subscriberinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
      v_refcursor SYS_REFCURSOR;
      v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= cell2i_utility.get_id(pis_msisdn);
        OPEN v_refcursor FOR 'SELECT subscriber_id,msisdn,password,first_name,last_name,tariff_id FROM subscriber WHERE subscriber_id = :v_subscriber_id' USING  v_subscriber_id;
    RETURN v_refcursor;
    END get_subscriberinfo;
    
    FUNCTION get_tariffinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
    v_refcursor SYS_REFCURSOR;
    v_tariff_id NUMBER;
    BEGIN
        SELECT tariff_id INTO v_tariff_id FROM subscriber WHERE msisdn = pis_msisdn;        
        OPEN v_refcursor FOR 'SELECT tariff_id,name FROM tariff WHERE tariff_id = :v_tariff_id' USING v_tariff_id;
    RETURN v_refcursor;
    END get_tariffinfo;
    
    FUNCTION get_usageinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
    v_refcursor SYS_REFCURSOR;
    v_subscriber_id NUMBER;
    BEGIN
        SELECT subscriber_id INTO v_subscriber_id FROM subscriber WHERE msisdn = pis_msisdn;        
        OPEN v_refcursor FOR 'SELECT subscriber_id,usage_type,used_amount,start_date,usage_id FROM usage WHERE subscriber_id= :v_subscriber_id' USING v_subscriber_id;
    RETURN v_refcursor;
    END get_usageinfo;
    
    
    FUNCTION get_startdayfrominvoice (pis_msisdn subscriber.msisdn%TYPE) RETURN DATE AS
    v_date DATE;
    v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= cell2i_utility.get_id(pis_msisdn);
        SELECT invoice_date INTO v_date FROM invoice WHERE subscriber_id = v_subscriber_id;
        RETURN v_date;
    END get_startdayfrominvoice;
    
        
END cell2i_utility;