CREATE INDEX subID_idx
ON subscriber (sub_id);
/
COMMENT ON COLUMN subscriber.msisdn
IS 'this column is referred to mobile subscriber identification number.';
/
CREATE SEQUENCE subscriber_seq
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE invoice_seq
START WITH 100
INCREMENT BY 1;
/
CREATE SEQUENCE tariff_seq
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE usage_seq
START WITH 1
INCREMENT BY 1;
