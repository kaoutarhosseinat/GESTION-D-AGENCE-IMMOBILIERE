use AGENCE_IMMOBILIER
/

CREATE TABLE BIEN_IMMOBILIERS(
    id_bienimm number(10) PRIMARY KEY auto_increment,
    typebi varchar2(30),
    taille number(10,10),
    PRIX number(10,10),
    localisation varchar2(50),
    descbi varchar2(100),
    ID_Agent number(10),
    FOREIGN KEY(ID_Agent)
    REFERENCES agent_immb(ID_Agent),
)
