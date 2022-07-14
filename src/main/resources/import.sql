insert into company_tb (id, corporate_name, cnpj, address,
 county, zip_code, phone, mail, titular_name, cpf)
 values (1, 'Pedro piramides', '00.000.000/0001-02, 'Baker Street',
 'Bullock', '00765', '202-555-0135', 'corpporp@corp.com', 'Peter smith', '08149482008');

insert into company_tb (id, corporate_name, cnpj, address,
county, zip_code, phone, mail, titular_name, cpf)
values (2, 'Davi Auto peças', '28768640000165', 'Street flowers',
'Chilton', '86081', '202-555-0135', 'davicorp@corp.com', 'Davi Jones', '81344787002');

insert into bank_account_tb (id,account_number, agency_number, bank, classification, description,
inicial_balance, inicial_balance_date, cnpj_Company) values
(1,'6559', 1441, 103, 'Bank', 'Its an account bank',
1.0, '1999-01-08', '00.000.000/0001-02');


insert into account_chart_tb (id, account_type, bank, classification,
description, resource_departure, resource_entry, bank_account_id)
 values ( 'physical', 1442, 'bank','Another account', '2022-01-23', '2022-05-08', 1);

insert into account_chart_tb (id, account_type, bank, classification, description, resource_departure, resource_entry, bank_account_id) values ('physical', 1332, 'bank','Just another account', '2021-05-12', '2022-11-16', 7);