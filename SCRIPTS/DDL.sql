-- Creo la tabla usuario
CREATE TABLE USUARIO(
  ID INTEGER,
  NOMBRE VARCHAR2(40),
  APELLIDOS VARCHAR2(80),
  EDAD INTEGER,
  TELEFONO VARCHAR2(60),
  CORREO VARCHAR2(80)
);
-- Se inserta un nuevo registro
INSERT INTO USUARIO VALUES (01,'LAURA','ALZATE AGUIRRE',21,'12345678','LAU@EAFIT.CO');
SELECT * FROM USUARIO;