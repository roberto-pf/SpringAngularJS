
delete from city;

/**
 * reset sequence
 */
ALTER SEQUENCE IF EXISTS city_example_seq RESTART WITH 1 INCREMENT BY 1;
	

/**
 * insert data test
 */
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '1Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '2Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '3Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '4Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '5Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '6Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '7Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '8Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '9Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '10Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '11Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '12Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '13Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
insert into city(id, country, name, state, map) values (city_example_seq.nextval, '14Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502');
/*
INSERT INTO useros VALUES (1, 'unos', 'uno@gmail.com');
INSERT INTO useros VALUES (2, 'dos', 'dos@yahoo.com');
INSERT INTO useros VALUES (3, 'tres', 'tres@gmail.com');
*/
