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
    
    FUNCTION get_id(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN NUMBER AS
        v_subscriber_id NUMBER;
        BEGIN
            SELECT subscriber_id INTO v_subscriber_id FROM cell2i.subscriber WHERE msisdn = pis_msisdn;
            RETURN v_subscriber_id;
        END get_id;
        
    FUNCTION get_startdayfrominvoice (pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN DATE AS
    v_date DATE;
    v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= get_id(pis_msisdn);
        SELECT max(invoice_date) INTO v_date FROM cell2i.invoice WHERE subscriber_id = v_subscriber_id;
        RETURN v_date;
    END get_startdayfrominvoice;      
       
    FUNCTION get_tariff_id_byname(pis_tariffname cell2i.tariff.name%TYPE) RETURN NUMBER AS
        v_tariff_id NUMBER;
        BEGIN
            SELECT tariff_id INTO v_tariff_id FROM cell2i.tariff WHERE name = pis_tariffname;
            RETURN v_tariff_id;
        END get_tariff_id_byname;
        
    FUNCTION check_user_is_valid(pis_searchMsisdn cell2i.subscriber.msisdn%TYPE, pis_searchPassword cell2i.subscriber.password%TYPE) RETURN NUMBER IS
        v_exist NUMBER;
        BEGIN                    
            SELECT COUNT(*) INTO v_exist FROM cell2i.subscriber  WHERE msisdn = pis_searchMsisdn AND password = pis_searchPassword;
            RETURN v_exist;
    END check_user_is_valid; 

    FUNCTION change_password(pis_searchMsisdn cell2i.subscriber.msisdn%TYPE, pis_newPassword cell2i.subscriber.password%TYPE)RETURN NUMBER AS
        v_row_count NUMBER;
        BEGIN
            UPDATE cell2i.subscriber 
            SET password = pis_newPassword
            WHERE msisdn = pis_searchMsisdn;
            v_row_count:=sql%rowcount;
            RETURN control_rowcount(v_row_count);
        END change_password;

    FUNCTION get_invoiceinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
      v_refcursor SYS_REFCURSOR;
      v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= get_id(pis_msisdn);
        OPEN v_refcursor FOR 'SELECT to_char(invoice_date),to_char(due_date),total_amount,status FROM cell2i.invoice WHERE subscriber_id = :v_subscriber_id' USING  v_subscriber_id;
        RETURN v_refcursor;
    END get_invoiceinfo;
    
    FUNCTION get_subscriberinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
      v_refcursor SYS_REFCURSOR;
      v_subscriber_id NUMBER;
    BEGIN
        v_subscriber_id:= get_id(pis_msisdn);
        OPEN v_refcursor FOR 'SELECT msisdn,first_name,last_name FROM cell2i.subscriber WHERE subscriber_id = :v_subscriber_id' USING  v_subscriber_id;
        RETURN v_refcursor;
    END get_subscriberinfo;
    
    FUNCTION get_tariffinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR AS
    v_refcursor SYS_REFCURSOR;
    v_tariff_id NUMBER;
    BEGIN
        SELECT tariff_id INTO v_tariff_id FROM cell2i.subscriber WHERE msisdn = pis_msisdn;        
        OPEN v_refcursor FOR 'SELECT name,granted_voice,granted_sms,granted_data FROM cell2i.tariff WHERE tariff_id = :v_tariff_id' USING v_tariff_id;
        RETURN v_refcursor;
    END get_tariffinfo;
    
    FUNCTION get_usageinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE,pis_usage_type cell2i.usage.usage_type%TYPE) RETURN  SYS_REFCURSOR AS
    v_refcursor SYS_REFCURSOR;
    v_subscriber_id NUMBER;
    v_usage_type   VARCHAR2(20);    
    BEGIN
        v_subscriber_id:=get_id(pis_msisdn);
        v_usage_type:=pis_usage_type;
        OPEN v_refcursor FOR 'SELECT usage_type,used_amount,to_char(start_date) FROM cell2i.usage WHERE subscriber_id= :v_subscriber_id AND usage_type =:v_usage_type' USING v_subscriber_id,v_usage_type;
        RETURN v_refcursor;
    END get_usageinfo;
    
    FUNCTION usage_insert (
        pis_msisdn        cell2i.subscriber.msisdn%TYPE,
        pis_usage_type    cell2i.usage.usage_type%TYPE,
        pin_used_amount   cell2i.usage.used_amount%TYPE,
        pin_usage_id      cell2i.usage.usage_id%TYPE
    ) RETURN NUMBER AS

        v_subscriber_id   cell2i.usage.subscriber_id%TYPE;
        v_usage_type      cell2i.usage.usage_type%TYPE;
        v_used_amount     cell2i.usage.used_amount%TYPE;
        v_start_date      cell2i.usage.start_date%TYPE;
        v_usage_id        cell2i.usage.usage_id%TYPE;
        v_row_count       NUMBER;
    BEGIN
        v_subscriber_id := get_id(pis_msisdn);
        v_usage_type := pis_usage_type;
        v_used_amount := pin_used_amount;
        v_start_date := get_startdayfrominvoice(pis_msisdn);
        v_usage_id := pin_usage_id;
        INSERT INTO cell2i.usage (
            subscriber_id,
            usage_type,
            used_amount,
            start_date,
            usage_id
        ) VALUES (
            v_subscriber_id,
            v_usage_type,
            v_used_amount,
            v_start_date,
            v_usage_id
        );

        v_row_count := SQL%rowcount;
        RETURN control_rowcount(v_row_count);
    END usage_insert;

    FUNCTION subscriber_insert (
        pin_subscriber_id   cell2i.subscriber.subscriber_id%TYPE,
        pis_msisdn          cell2i.subscriber.msisdn%TYPE,
        pis_password        cell2i.subscriber.password%TYPE,
        pis_first_name      cell2i.subscriber.first_name%TYPE,
        pis_last_name       cell2i.subscriber.last_name%TYPE,
        pis_tariff_name     cell2i.tariff.name%TYPE
    ) RETURN NUMBER AS

        v_subscriber_id   cell2i.subscriber.subscriber_id%TYPE;
        v_msisdn          cell2i.subscriber.msisdn%TYPE;
        v_password        cell2i.subscriber.password%TYPE;
        v_first_name      cell2i.subscriber.first_name%TYPE;
        v_last_name       cell2i.subscriber.last_name%TYPE;
        v_tariff_id       cell2i.subscriber.tariff_id%TYPE;
        v_row_count       NUMBER;
    BEGIN
        v_subscriber_id := pin_subscriber_id;
        v_msisdn := pis_msisdn;
        v_password := pis_password;
        v_first_name := pis_first_name;
        v_last_name := pis_last_name;
        v_tariff_id := get_tariff_id_byname(pis_tariff_name);
        INSERT INTO cell2i.subscriber (
            subscriber_id,
            msisdn,
            password,
            first_name,
            last_name,
            tariff_id
        ) VALUES (
            v_subscriber_id,
            v_msisdn,
            v_password,
            v_first_name,
            v_last_name,
            v_tariff_id
        );

        v_row_count := SQL%rowcount;
        RETURN control_rowcount(v_row_count);
    END subscriber_insert;

    FUNCTION tariff_insert (
        pin_tariff_id       cell2i.tariff.tariff_id%TYPE,
        pis_name            cell2i.tariff.name%TYPE,
        pin_granted_voice   cell2i.tariff.granted_voice%TYPE,
        pin_granted_sms     cell2i.tariff.granted_sms%TYPE,
        pin_granted_data    cell2i.tariff.granted_data%TYPE
    ) RETURN NUMBER AS

        v_tariff_id       cell2i.tariff.tariff_id%TYPE;
        v_name            cell2i.tariff.name%TYPE;
        v_granted_voice   cell2i.tariff.granted_voice%TYPE;
        v_granted_sms     cell2i.tariff.granted_sms%TYPE;
        v_granted_data    cell2i.tariff.granted_data%TYPE;
        v_row_count       NUMBER;
    BEGIN
        v_tariff_id := pin_tariff_id;
        v_name := pis_name;
        v_granted_voice := pin_granted_voice;
        v_granted_sms := pin_granted_sms;
        v_granted_data := pin_granted_data;
        INSERT INTO cell2i.tariff (
            tariff_id,
            name,
            granted_voice,
            granted_sms,
            granted_data
        ) VALUES (
            v_tariff_id,
            v_name,
            v_granted_voice,
            v_granted_sms,
            v_granted_data
        );

        v_row_count := SQL%rowcount;
        RETURN control_rowcount(v_row_count);
    END tariff_insert;

    FUNCTION invoice_insert (
        pis_msisdn         cell2i.subscriber.msisdn%TYPE,
        pin_invoice_id     cell2i.invoice.invoice_id%TYPE,
        pid_invoice_date   cell2i.invoice.invoice_date%TYPE,
        pid_due_date       cell2i.invoice.due_date%TYPE,
        pin_total_amount   cell2i.invoice.total_amount%TYPE,
        pin_status         cell2i.invoice.status%TYPE
    ) RETURN NUMBER AS

        v_subscriber_id   cell2i.invoice.subscriber_id%TYPE;
        v_invoice_id      cell2i.invoice.invoice_id%TYPE;
        v_invoice_date    cell2i.invoice.invoice_date%TYPE;
        v_due_date        cell2i.invoice.due_date%TYPE;
        v_total_amount    cell2i.invoice.total_amount%TYPE;
        v_status          cell2i.invoice.status%TYPE;
        v_row_count       NUMBER;
    BEGIN
        v_subscriber_id := get_id(pis_msisdn);
        v_invoice_id := pin_invoice_id;
        v_invoice_date := pid_invoice_date;
        v_due_date := pid_due_date;
        v_total_amount := pin_total_amount;
        v_status := pin_status;
        INSERT INTO cell2i.invoice (
            subscriber_id,
            invoice_id,
            invoice_date,
            due_date,
            total_amount,
            status
        ) VALUES (
            v_subscriber_id,
            v_invoice_id,
            v_invoice_date,
            v_due_date,
            v_total_amount,
            v_status
        );

        v_row_count := SQL%rowcount;
        RETURN control_rowcount(v_row_count);
    END invoice_insert;
    
END cell2i_utility;