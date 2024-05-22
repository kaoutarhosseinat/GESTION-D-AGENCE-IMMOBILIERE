
DROP TABLE  BIEN_IMMOBILIERS  CASCADE CONSTRAINTS;
DROP TABLE agent_immb  CASCADE CONSTRAINTS;
DROP table client CASCADE CONSTRAINTS;
DROP table transactions CASCADE CONSTRAINTS;


drop table agent_immb
/
drop TABLE BIEN_IMMOBILIERS
/
drop TABLE CLIENT
/
drop table transactions
/
drop table rendez_vous
/



CREATE TABLE agent_immb(
    ID_Agent number (10) PRIMARY KEY not null,
    noma varchar2(20) not null,
    prenoma varchar2(20) not null
)
/

CREATE TABLE BIEN_IMMOBILIERS(
    id_bienimm number(10) PRIMARY KEY  not null,
    typebi varchar2(30) not null,
    sizebi number(10,1) not null,
    PRIX number(10,1) not null,
    localisation varchar2(50) not null,
    descbi varchar2(500) not null,
    ID_Agent number(10) not null,
    FOREIGN KEY(ID_Agent)
    REFERENCES agent_immb(ID_Agent)
)
/
CREATE TABLE CLIENT(
    id_client number(10) PRIMARY KEY  not null,
    nomc varchar2(20) not null,
    prenomc varchar2(20) not null,
    typec varchar2(15) not null,
    demandec varchar2(100) not null,
    numTransaction number(10) not null
)
/
CREATE TABLE transactions(
    numTransaction number(10) UNIQUE,
    typeT varchar2(15) not null,
    paiement number(10) not null,
    dateT date not null ,
    id_client number(10) not null,
    FOREIGN KEY(id_client)
    REFERENCES CLIENT(id_client),
    id_bienimm number(10) not null,
    FOREIGN KEY (id_bienimm)
    REFERENCES BIEN_IMMOBILIERS(id_bienimm)
)
/
CREATE TABLE rendez_vous(
    id_rdv number(10) not null ,
    date_rdv date not null,
    id_client number(10) not null,
    FOREIGN KEY (id_client)
    REFERENCES CLIENT (id_client)
)
/


INSERT INTO CLIENT VALUES(1,'hosseinat','kaoutar','achteur','villa 5 etage',1);

INSERT INTO agent_immb (ID_Agent, noma, prenoma) VALUES (1, 'Agent 1', 'Last Name 1');
INSERT INTO agent_immb (ID_Agent, noma, prenoma) VALUES (2, 'Agent 2', 'Last Name 2');
INSERT INTO BIEN_IMMOBILIERS(id_bienimm, typebi, sizebi , PRIX, localisation, descbi,ID_Agent) VALUES  (1, 'villa', 800, 9800000, 'hydra',
        'salam elikoum khawty l3zaz lyoum jebnalkoum villa fakhma R+2 fi ar9a a7ya2 al3asima b 9 mlayer w 800 bi dafter 3a9ari w 3a9ed milkiya ', 1);
INSERT INTO BIEN_IMMOBILIERS (id_bienimm, typebi, sizebi , PRIX, localisation, descbi,ID_Agent)  VALUES (2, 'villa', 800, 9800000, 'hydra',
        'salam elikoum khawty l3zaz lyoum jebnalkoum villa fakhma R+2 fi ar9a a7ya2 al3asima b 9 mlayer w 800 bi dafter 3a9ari w 3a9ed milkiya ', 2);




