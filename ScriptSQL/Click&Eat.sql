create schema ClickAndEat;
use ClickAndEat;

create table Locale (
	nome varchar(30) NOT NULL,
    indirizzo varchar(60) NOT NULL,
    tipologia varchar(20) NOT NULL,
    telefono varchar(15) NOT NULL,
    PRIMARY KEY(nome,indirizzo)
);

create table Coupon (
	codice char(10) PRIMARY KEY NOT NULL,
    data_inizio date NOT NULL,
    spesa_minima double NOT NULL,
    valore_sconto int NOT NULL,
    scadenza date NOT NULL,
    locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade
);

create table Menù (
	nome varchar(15) NOT NULL,
    locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    num_pagine int NOT NULL,
    PRIMARY KEY (nome,locale_nome,locale_indirizzo),
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade
);

create table Fattorino (
	cf char(16) PRIMARY KEY NOT NULL,
    nome varchar(15) NOT NULL,
    cognome varchar(15) NOT NULL,
    telefono varchar(15) NOT NULL,
    locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade
);

create table AccountUser (
	email varchar(30) PRIMARY KEY NOT NULL,
    passw varchar(20) NOT NULL,
    nome varchar(30) NOT NULL,
    cogmome varchar(30) NOT NULL,
    indirizzo varchar(60) NOT NULL,
    telefono varchar(15) NOT NULL
);

create table FidelityCard (
	codice char(10) NOT NULL,
	locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    num_consumazioni int NOT NULL DEFAULT 0,
    account_email varchar(30) NOT NULL,
    PRIMARY KEY (codice,locale_nome,locale_indirizzo),
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(account_email) REFERENCES AccountUser(email) ON UPDATE cascade ON DELETE cascade
);

create table Ordine (
	codice char(10) PRIMARY KEY NOT NULL,
    nota text(500),
    prezzo_tot double NOT NULL,
    orario timestamp DEFAULT current_timestamp NOT NULL,
    account_email varchar(30) NOT NULL,
    locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    fattorino_cf char(16) NOT NULL,
    orario_previsto time NOT NULL,
    FOREIGN KEY(account_email) REFERENCES AccountUser(email) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(fattorino_cf) REFERENCES Fattorino(cf) ON UPDATE cascade ON DELETE cascade
);

create table Bibita (
	nome varchar(20) PRIMARY KEY NOT NULL,
    grado_alcolico int NOT NULL
);

create table Pietanza (
	nome varchar(30) PRIMARY KEY NOT NULL
);

create table Ingrediente (
	nome varchar(20) NOT NULL,
    pietanza_nome varchar(30) NOT NULL,
    PRIMARY KEY (nome,pietanza_nome),
    FOREIGN KEY(pietanza_nome) REFERENCES Pietanza(nome) ON UPDATE cascade ON DELETE cascade
);

create table Recensione (
	data_ora timestamp DEFAULT current_timestamp NOT NULL,
    account_email varchar(30) NOT NULL,
    descrizione text(1000),
    stelle enum('1','2','3','4','5') NOT NULL,
    locale_nome varchar(30) NOT NULL,
    locale_indirizzo varchar(60) NOT NULL,
    PRIMARY KEY(data_ora,account_email),
    FOREIGN KEY(account_email) REFERENCES AccountUser(email) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(locale_nome,locale_indirizzo) REFERENCES Locale(nome,indirizzo) ON UPDATE cascade ON DELETE cascade
);

create table È_utilizzato (
	coupon_codice char(10) NOT NULL,
    account_email varchar(30) NOT NULL,
    PRIMARY KEY(coupon_codice,account_email),
    FOREIGN KEY(coupon_codice) REFERENCES Coupon(codice) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(account_email) REFERENCES AccountUser(email) ON UPDATE cascade ON DELETE cascade
);

create table È_inserito (
	coupon_codice char(10) NOT NULL,
    ordine_codice char(10) NOT NULL,
    PRIMARY KEY(coupon_codice,ordine_codice),
    FOREIGN KEY(coupon_codice) REFERENCES Coupon(codice) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(ordine_codice) REFERENCES Ordine(codice) ON UPDATE cascade ON DELETE cascade
);

create table È_applicata (
	fidelityCard_codice char(10) NOT NULL,
    fidelityCard_locale_nome varchar(30) NOT NULL,
    fidelityCard_locale_indirizzo varchar(60) NOT NULL,
    ordine_codice char(10) NOT NULL,
    PRIMARY KEY(fidelityCard_codice,fidelityCard_locale_nome,fidelityCard_locale_indirizzo,ordine_codice),
    FOREIGN KEY(fidelityCard_codice,fidelityCard_locale_nome,fidelityCard_locale_indirizzo)
		REFERENCES FidelityCard(codice,locale_nome,locale_indirizzo) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(ordine_codice) REFERENCES Ordine(codice) ON UPDATE cascade ON DELETE cascade 
);

create table È_composto_B (
	menù_nome varchar(15) NOT NULL,
    menù_locale_nome varchar(30) NOT NULL,
    menù_locale_indirizzo varchar(60) NOT NULL,
    bibita_nome varchar(20) NOT NULL,
    prezzo double NOT NULL,
    PRIMARY KEY(menù_nome,menù_locale_nome,menù_locale_indirizzo,bibita_nome),
    FOREIGN KEY(menù_nome,menù_locale_nome,menù_locale_indirizzo) 
		REFERENCES Menù(nome,locale_nome,locale_indirizzo) ON UPDATE cascade ON DELETE cascade,
	FOREIGN KEY(bibita_nome) REFERENCES Bibita(nome) ON UPDATE cascade ON DELETE cascade
);

create table È_composto_P (
	menù_nome varchar(15) NOT NULL,
    menù_locale_nome varchar(30) NOT NULL,
    menù_locale_indirizzo varchar(60) NOT NULL,
    pietanza_nome varchar(30) NOT NULL,
    prezzo double NOT NULL,
    PRIMARY KEY(menù_nome,menù_locale_nome,menù_locale_indirizzo,pietanza_nome),
    FOREIGN KEY(menù_nome,menù_locale_nome,menù_locale_indirizzo) 
		REFERENCES Menù(nome,locale_nome,locale_indirizzo) ON UPDATE cascade ON DELETE cascade,
	FOREIGN KEY(pietanza_nome) REFERENCES Pietanza(nome) ON UPDATE cascade ON DELETE cascade
);

create table Comprende_B (
	ordine_codice char(10) NOT NULL,
    bibita_nome varchar(20) NOT NULL,
    PRIMARY KEY(ordine_codice,bibita_nome),
    FOREIGN KEY(ordine_codice) REFERENCES Ordine(codice) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(bibita_nome) REFERENCES Bibita(nome) ON UPDATE cascade ON DELETE cascade
);

create table Comprende_P (
	ordine_codice char(10) NOT NULL,
    pietanza_nome varchar(30) NOT NULL,
    PRIMARY KEY(ordine_codice,pietanza_nome),
    FOREIGN KEY(ordine_codice) REFERENCES Ordine(codice) ON UPDATE cascade ON DELETE cascade,
    FOREIGN KEY(pietanza_nome) REFERENCES Pietanza(nome) ON UPDATE cascade ON DELETE cascade
);

ALTER TABLE Comprende_B ADD quantità int DEFAULT 1;
ALTER TABLE Comprende_P ADD quantità int DEFAULT 1;
