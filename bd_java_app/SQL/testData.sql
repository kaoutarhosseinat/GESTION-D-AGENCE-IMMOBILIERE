DROP PROCEDURE test_Data;
DROP TABLE  BIEN_IMMOBILIERS  CASCADE CONSTRAINTS;
DROP TABLE agent_immb  CASCADE CONSTRAINTS;

CREATE TABLE agent_immb (
    ID_Agent NUMBER(10) PRIMARY KEY NOT NULL,
    noma VARCHAR2(20) NOT NULL,
    prenoma VARCHAR2(20) NOT NULL
)
/

CREATE TABLE BIEN_IMMOBILIERS (
    id_bienimm NUMBER(10) PRIMARY KEY NOT NULL,
    typebi VARCHAR2(30) NOT NULL,
    sizebi NUMBER(10) NOT NULL,
    PRIX NUMBER(10) NOT NULL,
    localisation VARCHAR2(50) NOT NULL,
    descbi VARCHAR2(500) NOT NULL,
    ID_Agent NUMBER(10) NOT NULL,
    FOREIGN KEY(ID_Agent) REFERENCES agent_immb(ID_Agent)
)
/

INSERT INTO agent_immb (ID_Agent, noma, prenoma) VALUES (1, 'Agent 1', 'Last Name 1');
INSERT INTO agent_immb (ID_Agent, noma, prenoma) VALUES (2, 'Agent 2', 'Last Name 2');

CREATE OR REPLACE PROCEDURE test_Data AS
BEGIN
    INSERT INTO BIEN_IMMOBILIERS(id_bienimm, typebi, taille, PRIX, localisation, descbi,ID_Agent) VALUES  (1, 'villa', 800, 9800000, 'hydra',
        'salam elikoum khawty l3zaz lyoum jebnalkoum villa fakhma R+2 fi ar9a a7ya2 al3asima b 9 mlayer w 800 bi dafter 3a9ari w 3a9ed milkiya ', 1);
    INSERT INTO BIEN_IMMOBILIERS (id_bienimm, typebi, taille, PRIX, localisation, descbi,ID_Agent)  VALUES (2, 'villa', 800, 9800000, 'hydra',
        'salam elikoum khawty l3zaz lyoum jebnalkoum villa fakhma R+2 fi ar9a a7ya2 al3asima b 9 mlayer w 800 bi dafter 3a9ari w 3a9ed milkiya ', 2);
END
/

EXEC test_Data;



