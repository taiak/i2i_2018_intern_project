CREATE OR REPLACE PACKAGE BODY CELL2I_UTILITY AS
   
    FUNCTION login(pis_searchMsisdn subscriber.sub_msisdn%TYPE, pis_searchPassword subscriber.password%TYPE) RETURN NUMBER IS
        v_exist NUMBER;
        BEGIN                    
            SELECT count(*) INTO v_exist FROM subscriber  WHERE sub_msidn = pis_searchMsidn AND password = pis_searchPassword;
            RETURN v_exist;
        END login;    
END;