ALTER TABLE rdfleet.cartype ALTER horsepower SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER fiscHp SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER idealKm SET DEFAULT 0;
ALTER TABLE rdfleet.carType ALTER maxKm SET DEFAULT 0;

ALTER TABLE rdfleet.car ALTER amountOfRefuels SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER mileage SET DEFAULT 0;
ALTER TABLE rdfleet.car ALTER leasingDurationYears SET DEFAULT 4;
ALTER TABLE rdfleet.car ALTER noLongerInUse SET DEFAULT false;

ALTER TABLE rdfleet.caroption ALTER price SET DEFAULT 0;

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



insert into carType (id, category, name, modelName, modelDesignation, horsePower, versionName, imageUrl,
                     co2, listPriceInclRealVat, fiscHp, benefitInKindPerMonth, amountUpgradeInclVat, amountDowngradeInclVat,
                     idealKm, maxKm,
                     fuelType, winterTyresRimType, isAvailable)
values (3, 3, 'Audi', 'A4', 'ST 1,6 crtdi', 105, 'Style ecomotive', 'http://www.topgear.nl/image/popup/seat-ibiza-sc-12-tsi-fr-full-12062012081532-7062.jpg',
        109, 19945, 7, 104.17, 0, 2479.78,
        140000, 180000,
        'DIESEL', 'STEEL', true);

insert into carType (id, category, name, modelName, modelDesignation, horsePower, versionName, imageUrl,
                     co2, listPriceInclRealVat, fiscHp, benefitInKindPerMonth, amountUpgradeInclVat, amountDowngradeInclVat,
                     idealKm, maxKm,
                     fuelType, winterTyresRimType, isAvailable)
values (4, 4, 'Audi', 'A5', 'ST 1,6 crtdi', 105, 'Style ecomotive', 'http://www.topgear.nl/image/popup/seat-ibiza-sc-12-tsi-fr-full-12062012081532-7062.jpg',
        109, 19945, 7, 104.17, 0, 2479.78,
        140000, 180000,
        'DIESEL', 'STEEL', true);

insert into carType (id, category, name, modelName, modelDesignation, horsePower, versionName, imageUrl,
                     co2, listPriceInclRealVat, fiscHp, benefitInKindPerMonth, amountUpgradeInclVat, amountDowngradeInclVat,
                     idealKm, maxKm,
                     fuelType, winterTyresRimType, isAvailable)
values (5, 4, 'Aston', 'Martin', 'ST 1,6 crtdi', 105, 'Style ecomotive', 'http://www.topgear.nl/image/popup/seat-ibiza-sc-12-tsi-fr-full-12062012081532-7062.jpg',
        109, 19945, 7, 104.17, 0, 2479.78,
        140000, 180000,
        'DIESEL', 'STEEL', true);





insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (1, '10', 1, '2015-11-06', '2018-11-06', '1-JNL-715', '145', FALSE );
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (2, '300', 2, '2015-01-01', '2018-11-06','1-JNL-714', '1451', FALSE );
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (3, '200', 2, '2015-01-01', '2018-11-06','1-JNL-713', '1452', FALSE );
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (4, '150', 3, '2015-01-01', '2018-11-06','1-JNL-717', '1453e', FALSE );
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (5, '110000', 4, '2015-01-01', '2018-11-06','1-JNL-716', '1459', FALSE );
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (6, '110000', 4, '2015-01-01', '2018-11-06','1-JNL-718', '1458', true);
insert into car (id, mileage, carType_id, startLeasing, endleasing, numberPlate, vinNumber, inThePool) values (7, '110000', 5, '2015-01-01', '2015-11-12','1-JNL-719', '1457', true);

insert into caroption(id, car_option, optionName, leatherType) values (1, 'cc', 'Cruise Control', null);
insert into caroption(id, car_option, optionName, leatherType) values (2, 'li', 'Leather Interior', 'IMITATION');
insert into caroption(id, car_option, optionName, leatherType) values (3, 'hs', 'Heated Seats', null);


insert into employee(id, firstName, lastName, email, password_hash, role, functionalLevel, active, currentCar_id) values(5, 'Gek', 'kie', 'tmcmowner@gmail.com', '$2a$10$JXj2OAsht0aNszmIkFlnDuWXdcoWN7hXaw1JOg3tUpokeT5udbRVa', 'FLEET_EMPLOYEE', 1, true, 1);
insert into employee(id, firstName, lastName, email, password_hash, role, functionalLevel, active, currentCar_id) values(6, 'Floo', 'Bar', 'floo@bar.com', '$2a$10$JXj2OAsht0aNszmIkFlnDuWXdcoWN7hXaw1JOg3tUpokeT5udbRVa', 'FLEET_EMPLOYEE', 1, true, 2);
insert into employee(id, firstName, lastName, email, password_hash, role, functionalLevel, active, currentCar_id) values(7, 'Foo', 'Bar', 'foo@bar.com', '$2a$10$JXj2OAsht0aNszmIkFlnDuWXdcoWN7hXaw1JOg3tUpokeT5udbRVa', 'EMPLOYEE', 1, true, 3);

insert into carOrder(id, carType_id, employee_id) values (1,2, 5);