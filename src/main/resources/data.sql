INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,to_timestamp('2020-06-14 00.00.00', 'yyyy-mm-dd hh24:mi:ss'),to_timestamp('2020-12-31 23.59.59', 'yyyy-mm-dd hh24:mi:ss'),35455,0,35.50,'EUR');

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,to_timestamp('2020-06-14-15.00.00', 'yyyy-mm-dd hh24:mi:ss'),to_timestamp('2020-06-14-18.30.00', 'yyyy-mm-dd hh24:mi:ss'),35455,1,25.45,'EUR');

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,to_timestamp('2020-06-15-00.00.00', 'yyyy-mm-dd hh24:mi:ss'),to_timestamp('2020-06-15-11.00.00', 'yyyy-mm-dd hh24:mi:ss'),35455,1,30.50,'EUR');

INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1,to_timestamp('2020-06-15 16.00.00', 'yyyy-mm-dd hh24:mi:ss'),to_timestamp('2020-12-31-23.59.59', 'yyyy-mm-dd hh24:mi:ss'),35455,1,38.95,'EUR');