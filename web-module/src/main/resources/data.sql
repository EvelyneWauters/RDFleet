ALTER TABLE rdfleet.car ALTER amountOfRefuels SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER mileage SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER leasingDurationYears SET DEFAULT 4;
ALTER TABLE rdfleet.car ALTER noLongerInUse SET DEFAULT false;

ALTER TABLE rdfleet.carType ALTER fiscHp SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER idealKm SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER maxKm SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER versionNumber SET DEFAULT 0;





insert into car (mileage) values ('10');
insert into car (mileage) values ('300');
insert into car (mileage) values ('200');
insert into car (mileage) values ('150');
insert into car (mileage) values ('110000');


# insert into carType (category, name, modelName, listPriceInclRealVat, co2,isAvailable, versionNumber) values (1, 'Audi', 'A1', 15000, 120, true, 0);
# insert into carType (category, name, modelName, listPriceInclRealVat, co2,isAvailable, versionNumber) values (3, 'Audi', 'A3', 20000, 130, true, 0);
insert into carType (category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (1, 'Audi', 'A1', 15000, 120, true);
insert into carType (category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (3, 'Audi', 'A3', 20000, 130, true);


