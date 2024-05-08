drop TABLE BIEN_IMMOBILIERS
/
drop TABLE CLIENT
/
drop table transactions
/
drop table rendez_vous
/
drop table agent_immb
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
    taille number(10,10) not null,
    PRIX number(10,10) not null,
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
    numTransaction number(10) not null,
    FOREIGN KEY(numTransaction)
    REFERENCES transactions(numTransaction)
)
/
CREATE TABLE transactions(
    numTransaction number(10) PRIMARY KEY  not null,
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

