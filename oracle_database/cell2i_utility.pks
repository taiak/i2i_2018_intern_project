create or replace PACKAGE CELL2I_UTILITY AS
    FUNCTION check_user_is_valid(pis_searchMsisdn subscriber.msisdn%TYPE, pis_searchPassword subscriber.password%TYPE) RETURN NUMBER;
    FUNCTION change_password(pis_searchMsisdn subscriber.msisdn%TYPE, pis_newPassword subscriber.password%TYPE)RETURN NUMBER;
    FUNCTION get_id(pis_msisdn subscriber.msisdn%TYPE) RETURN NUMBER;
    FUNCTION get_tariff_id_byname(pis_tariffname tariff.name%TYPE) RETURN NUMBER;
    FUNCTION get_tariff_id_bysubmsisdn(pis_msisdn subscriber.msisdn%TYPE) RETURN NUMBER;
    FUNCTION get_invoiceinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_subscriberinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_tariffinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
    FUNCTION get_startdayfrominvoice (pis_msisdn subscriber.msisdn%TYPE) RETURN DATE;
    FUNCTION get_usageinfo(pis_msisdn subscriber.msisdn%TYPE) RETURN  SYS_REFCURSOR;
END;