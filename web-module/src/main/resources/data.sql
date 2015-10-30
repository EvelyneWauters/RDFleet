ALTER TABLE rdfleet.car ALTER amountOfRefuels SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER mileage SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER leasingDurationYears SET DEFAULT 4;
ALTER TABLE rdfleet.car ALTER noLongerInUse SET DEFAULT false;




insert into car (mileage) values ('10');
insert into car (mileage) values ('300');
insert into car (mileage) values ('200');
insert into car (mileage) values ('150');
insert into car (mileage) values ('110000');


insert into employee(email, password_hash, role, functionalLevel) values('gek@rd.com', 'gek', 'EMPLOYEE', 1)

