CREATE TABLE subscriber
(
    sub_id NUMBER,
    msisdn VARCHAR(10) NOT NULL,
    password VARCHAR(60) NOT NULL,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    CONSTRAINT subscriber_pk PRIMARY KEY (sub_id)
);
/
SELECT * FROM subscriber;
/
CREATE TABLE invoice
(   
    sub_id NUMBER,
    invoice_id NUMBER,
    invoice_date DATE,
    due_date DATE,
    total_amount NUMBER,
    open_amount NUMBER,
    CONSTRAINT invoice_pk PRIMARY KEY (invoice_id)
);
/
CREATE TABLE tariff
(
    tariff_id NUMBER,
    name VARCHAR2(50),
    CONSTRAINT tariff_pk PRIMARY KEY (tariff_id)
);
/
CREATE TABLE usage
(
    sub_id NUMBER,
    usage_type VARCHAR2(15),
    granted_amount NUMBER,
    used_amount NUMBER,
    start_date DATE,
    usage_id NUMBER,
    CONSTRAINT usage_pk PRIMARY KEY (usage_id)
    
);

