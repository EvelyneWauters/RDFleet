ALTER TABLE rdfleet.car ALTER amountOfRefuels SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER mileage SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER leasingDurationYears SET DEFAULT 4;
ALTER TABLE rdfleet.car ALTER noLongerInUse SET DEFAULT false;

ALTER TABLE rdfleet.carType ALTER fiscHp SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER idealKm SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER maxKm SET DEFAULT 0;


insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (1, 1, 'Audi', 'A1', 15000, 120, true);
insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (2, 3, 'Audi', 'A3', 20000, 130, true);
insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (3, 3, 'Audi', 'A4', 20000, 130, true);
insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (4, 3, 'Audi', 'A5', 20000, 130, true);



insert into car (id, mileage, carType_id, startLeasing) values (1, '10', 1, '2015-04-01');
insert into car (id, mileage, carType_id, startLeasing) values (2, '300', 2, '2015-01-01');
insert into car (id, mileage, carType_id, startLeasing) values (3, '200', 2, '2015-01-01');
insert into car (id, mileage, carType_id, startLeasing) values (4, '150', 3, '2015-01-01');
insert into car (id, mileage, carType_id, startLeasing) values (5, '110000', 4, '2015-01-01');


insert into employee(id, firstName, lastName, email, password_hash, role, functionalLevel, active) values(5, 'Gek', 'kie', 'gek@rd.com', 'gek', 'EMPLOYEE', 1, true);

