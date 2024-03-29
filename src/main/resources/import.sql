insert  into users_tb (id, name, "password", username) values (1,'leandro vargas', '$2a$10$oV9v7ImHYO3ZTdA2q6ocxeBSf55nTVwG.fsRVUNJzlMWSACUirHQW', 'Lvargas');

insert into company_tb (id, corporate_name, cnpj, address, county, zip_code, phone, mail, titular_name, cpf) values (1,'Pedro piramides', '00.000.000/0001-02', 'Baker Street', 'Bullock', '00765', '202-555-0135', 'corpporp@corp.com', 'Peter smith', '08149482008');
insert into company_tb (id, corporate_name, cnpj, address, county, zip_code, phone, mail, titular_name, cpf)values (2, 'Davi Auto peças', '28768640000165', 'Street flowers','Chilton', '86081', '202-555-0135', 'davicorp@corp.com', 'Davi Jones', '81344787002');

insert into bank_account_tb (id,account_number, agency_number, bank, classification, description, inicial_balance, inicial_balance_date, cnpj_Company) values (1,'6559', 1441, 103, 'Crédito', 'BV BANK', 1.0, '1999-01-08', '00.000.000/0001-02');

insert into account_chart_tb (id, account_type, aspect, classification, description, bank_account_id) values (1,'1', 1, '1','Ativos',1);

insert into customer_tb (id, address, cnpj_cpf, corporate_name, county, mail, phone, zip_code) values (1, 'Live Street', '66981350033', 'Lucas', 'Lumpkin', 'lucas@gmail.com', '+1-202-555-0130', '83585');
insert into customer_tb (id, address, cnpj_cpf, corporate_name, county, mail, phone, zip_code) values (2, 'Pop Street', '35725344029', 'Julia', 'Orange', 'julia@outlook.com', '+1-202-555-0116', '18113');

insert into provider_tb (id, address, cnpj_cpf, corporate_name, county, mail, phone, zip_code) values (1, 'Colorful Street', '24405357000118', 'James Esfirras','Alabama', 'esfirras@corporation.com', '202-555-0119', '09456');
insert into provider_tb (id, address, cnpj_cpf, corporate_name, county, mail, phone, zip_code) values (2, 'Sunset Street', '91410886000105', 'Pedro Pedrinhas','Bibb', 'pedrinhas@corporation.com', '202-555-0140', '30603');


insert into payment_form_tb (id, description) values (1, 'Dinheiro');
insert into payment_form_tb (id, description) values (2, 'Cartão/Débito');
insert into payment_form_tb (id, description) values (3, 'Cartão/Crédito');
insert into payment_form_tb (id, description) values (4, 'Pix');
insert into payment_form_tb (id, description) values (5, 'Boleto');

insert into entry_pay_tb (id, doc_number, emission_date ,due_date, title_value, company_id, customer_id) values (1, 'ab 12456878', '2022-07-01', '2022-01-01', 50.05, 1, 1);

insert into bills_to_pay_tb (id, doc_number, emission_date ,due_date, title_value, company_id, provider_id) values (1, 'ab 12456878', '2022-07-01', '2022-01-01', 50.05, 1, 1);

insert into products_tb (id,company_id, provider_id, description, name_product,value) values (1, 1, 1,'Pacote 1kg','Café',17.5 );

insert into inventory_tb (id,products_id, qtde, estimated_sale_price) values (1, 1, 8 ,20.7 );

insert into law_tb (id,law_number,law_description) values (1, '103/2020', 'Altera os valoress das alíquotas' );

insert into tax_tb (id,"percent", name_tax, "scope", law_id) values (1, 17.5 , 'ICMS','Estadual', 1 );

insert into bank_tb (id,cnpj, febraban_code, name_bank) values (1, '00000000000' , 217,'BANCO UFMT');

insert into professions_tb (id,profession_name,workload) values (1,'Programador',220);

insert into funds_tb (id,name,provento) values(1,'Vencimento Base','1');

insert into sector_tb (id,name_sector,company_id) values(1,'COORD. DESENVOLVIMENTO',1);

insert into health_plan_tb (id,codigo_ans,operadora) values(1,'ABC123','Brad Saúde');

insert into personal_data_tb (id,	bairro,	birth_date,	cidade,	cpf,	email,	"name",	phone,	rua) values (1,'Centro','1997-09-03', 'VG', '000.000.000-55', 'lvar@lvarg.com', 'Leandro Var', '(65) 9 9999-9999', 'Joao L');

insert  into employee_tb (id,company_id,funds_id,health_plan_id,people_id,profession_id,sector_id) values (1,1,	1,	1,	1,	1,	1);

