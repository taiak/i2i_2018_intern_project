create or replace PACKAGE CELL2I_UTILITY AS
    FUNCTION check_user_is_valid(pis_searchMsisdn cell2i.subscriber.msisdn%TYPE, pis_searchPassword cell2i.subscriber.password%TYPE) RETURN NUMBER;
    FUNCTION change_password(pis_searchMsisdn cell2i.subscriber.msisdn%TYPE, pis_newPassword cell2i.subscriber.password%TYPE)RETURN NUMBER;
    FUNCTION get_invoiceinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_subscriberinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_tariffinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_usageinfo(pis_msisdn cell2i.subscriber.msisdn%TYPE,pis_usage_type cell2i.usage.usage_type%TYPE) RETURN  SYS_REFCURSOR;
    
    FUNCTION usage_insert
    (pis_msisdn cell2i.subscriber.msisdn%TYPE,pis_usage_type cell2i.usage.usage_type%TYPE,
    pin_used_amount cell2i.usage.used_amount%TYPE,pin_usage_id cell2i.usage.usage_id%TYPE) RETURN NUMBER;
    
    FUNCTION subscriber_insert
    (pin_subscriber_id cell2i.subscriber.subscriber_id%TYPE, pis_msisdn cell2i.subscriber.msisdn%TYPE, pis_password cell2i.subscriber.password%TYPE,
    pis_first_name cell2i.subscriber.first_name%TYPE, pis_last_name cell2i.subscriber.last_name%TYPE, pis_tariff_name cell2i.tariff.name%TYPE) RETURN NUMBER;
    
    FUNCTION tariff_insert
    (pin_tariff_id cell2i.tariff.tariff_id%TYPE, pis_name cell2i.tariff.name%TYPE, pin_granted_voice cell2i.tariff.granted_voice%TYPE,
    pin_granted_sms cell2i.tariff.granted_sms%TYPE, pin_granted_data cell2i.tariff.granted_data%TYPE) RETURN NUMBER;
    
    FUNCTION invoice_insert   
    (pis_msisdn cell2i.subscriber.msisdn%TYPE, pin_invoice_id cell2i.invoice.invoice_id%TYPE, pid_invoice_date cell2i.invoice.invoice_date%TYPE,
    pid_due_date cell2i.invoice.due_date%TYPE, pin_total_amount cell2i.invoice.total_amount%TYPE, pin_status cell2i.invoice.status%TYPE) RETURN NUMBER;
END;