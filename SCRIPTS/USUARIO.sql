-- Se crea el usuario
CREATE USER EJEMPLOCRUD IDENTIFIED BY EJEMPLOCRUD
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

GRANT RESOURCE TO EJEMPLOCRUD;
GRANT CONNECT TO EJEMPLOCRUD;