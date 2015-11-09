ALTER TABLE rdfleet.cartype ALTER horsepower SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER fiscHp SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER idealKm SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER maxKm SET DEFAULT 0;

ALTER TABLE rdfleet.car ALTER amountOfRefuels SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER mileage SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER leasingDurationYears SET DEFAULT 4;
ALTER TABLE rdfleet.car ALTER noLongerInUse SET DEFAULT false;

ALTER TABLE rdfleet.employee ALTER receivedMailForNewCar SET DEFAULT 0;


insert into carType (id, category, name, modelName, modelDesignation, horsePower, versionName, imageUrl,
                     co2, listPriceInclRealVat, fiscHp, benefitInKindPerMonth, amountUpgradeInclVat, amountDowngradeInclVat,
                     idealKm, maxKm,
                     fuelType, winterTyresRimType, isAvailable)
values (1, 2, 'Audi', 'A3', 'Sportback 1,6 tdi', 110, 'ultra attraction', 'http://www.audi-me.com/content/dam/ngw/product/a3/a3_sportback/my_2013/multimedia/704x396_aa3_d_11109.jpg',
        89, 25048, 9, 104.17, 0, 3924.45,
        140000, 180000,
        'DIESEL', 'STEEL', true);


insert into carType (id, category, name, modelName, modelDesignation, horsePower, versionName, imageUrl,
                     co2, listPriceInclRealVat, fiscHp, benefitInKindPerMonth, amountUpgradeInclVat, amountDowngradeInclVat,
                     idealKm, maxKm,
                     fuelType, winterTyresRimType, isAvailable)
values (2, 1, 'Seat', 'Ibiza', 'ST 1,6 crtdi', 105, 'Style ecomotive', 'http://www.topgear.nl/image/popup/seat-ibiza-sc-12-tsi-fr-full-12062012081532-7062.jpg',
        109, 19945, 7, 104.17, 0, 2479.78,
        140000, 180000,
        'DIESEL', 'STEEL', true);


insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (3, 3, 'Audi', 'A4', 20000, 130, true);
insert into carType (id, category, name, modelName, listPriceInclRealVat, co2,isAvailable) values (4, 3, 'Audi', 'A5', 20000, 130, true);




insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber) values (1, '10', 1, '2015-11-06', '2015-11-06', '1-JNL-715', '145');
insert into car (id, mileage, carType_id, startLeasing, numberPlate, vinNumber) values (2, '300', 2, '2015-01-01', '1-JNL-714', '1451');
insert into car (id, mileage, carType_id, startLeasing, numberPlate, vinNumber) values (3, '200', 2, '2015-01-01', '1-JNL-713', '1452');
insert into car (id, mileage, carType_id, startLeasing, numberPlate, vinNumber) values (4, '150', 3, '2015-01-01', '1-JNL-717', '1453e');
insert into car (id, mileage, carType_id, startLeasing, numberPlate, vinNumber) values (5, '110000', 4, '2015-01-01', '1-JNL-716', '1459');


insert into employee(id, firstName, lastName, email, password_hash, role, functionalLevel, active, currentCar_id) values(5, 'Gek', 'kie', 'tmcmowner@gmail.com', 'gek', 'FLEET_EMPLOYEE', 1, true, 1);

insert into carOrder(id, carType_id, employee_id) values (1,2, 5);