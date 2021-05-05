insert into cusine values (1, 'wloska');
insert into recipes values (1, 'zrob cos', 15, 'smaczna', 'przepis', 1);
insert into recipes values (2,'przygotowanie', 15,'jakis tam opis', 'pad thai', 1);

insert into ingredients values (1,'krewetki', 250);
insert into ingredients values (2,'olej', 100);
insert into ingredients values (3,'ryz', 125);
insert into ingredients values (4,'cebula', 50);
insert into ingredients values (5,'jajko', 75);

insert into recipe_ingredients values (1, 1);
insert into recipe_ingredients values (1, 2);
insert into recipe_ingredients values (1, 3);
insert into recipe_ingredients values (1, 4);
insert into recipe_ingredients values (1, 5);
insert into recipe_ingredients values (2, 2);
insert into recipe_ingredients values (2, 4);
insert into recipe_ingredients values (2, 5);

insert into cusine_recipes values (1, 1);