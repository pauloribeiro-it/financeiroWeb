CREATE DATABASE financeiro;
use financeiro;
CREATE TABLE usuario(
	codigo INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	login VARCHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(10) NOT NULL,
	nascimento DATE NOT NULL,
	celular VARCHAR(25),
	idioma VARCHAR(5) NOT NULL,
	ativo TINYINT(1) NOT NULL,
	PRIMARY KEY(codigo),
	UNIQUE KEY login(login)
);

CREATE TABLE conta_bancaria(
	cod_conta int(11) not null auto_increment,
	cod_usuario int(11) not null,
	des_conta varchar(255) default null,
	dat_cadastro datetime not null,
	saldo_inicial float default null,
	favorita bit(1) default null,
	primary key(cod_conta),
	key fk_conta_usuario(cod_usuario),
	constraint fk_conta_usuario
	foreign key (cod_usuario)
	references usuario(codigo) on delete cascade
);

CREATE TABLE cheque(
	cheque int(11) not null,
	conta int(11) not null,
	data_cadastro date not null,
	situacao char(1) not null,
	lancamento int(11) default null,
	primary key(cheque,conta),
	key fk_cheque_lancamento (lancamento),
	key fk_cheque_conta (conta),
	constraint fk_cheque_conta foreign key (conta) references conta_bancaria(cod_conta)
	on delete cascade,
	constraint fk_cheque_lancamento foreign key(lancamento) references lancamento(codigo) on delete cascade
 
);