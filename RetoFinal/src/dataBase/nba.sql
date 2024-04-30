CREATE DATABASE nba;
use nba;

select * from jugadores;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
INSERT INTO jugadores (codigo,nombre,procedencia,altura,peso,posicion,equipo) VALUES (?, ?, ?, ?, ?,?, ?);

CREATE TABLE equipos (
  Nombre varchar(20) NOT NULL,
  Ciudad varchar(20) DEFAULT NULL,
  Conferencia varchar(4) DEFAULT NULL,
  Division varchar(9) DEFAULT NULL,
  constraint pkequip PRIMARY KEY (Nombre)
)engine=innodb;

INSERT INTO equipos VALUES ('Celtics','Boston','East','Atlantic');
INSERT INTO equipos VALUES ('Raptors','Toronto','East','Atlantic');
INSERT INTO equipos VALUES ('76ers','Philadelphia','East','Atlantic');
INSERT INTO equipos VALUES ('Nets','New Jersey','East','Atlantic');


INSERT INTO equipos VALUES ('Knicks','New York','East','Atlantic');
INSERT INTO equipos VALUES ('Pistons','Detroit','East','Central');
INSERT INTO equipos VALUES ('Cavaliers','Cleveland','East','Central');
INSERT INTO equipos VALUES ('Pacers','Indiana','East','Central');
INSERT INTO equipos VALUES ('Bulls','Chicago','East','Central');
INSERT INTO equipos VALUES ('Bucks','Milwaukee','East','Central');
INSERT INTO equipos VALUES ('Magic','Orlando','East','SouthEast');
INSERT INTO equipos VALUES ('Wizards','Washington','East','SouthEast');
INSERT INTO equipos VALUES ('Hawks','Atlanta','East','SouthEast');
INSERT INTO equipos VALUES ('Bobcats','Charlotte','East','SouthEast');
INSERT INTO equipos VALUES ('Heat','Miami','East','SouthEast');
INSERT INTO equipos VALUES ('Jazz','Utah','West','NorthWest');
INSERT INTO equipos VALUES ('Nuggets','Denver','West','NorthWest');
INSERT INTO equipos VALUES ('Trail Blazers','Portland','West','NorthWest');
INSERT INTO equipos VALUES ('Timberwolves','Minnesota','West','NorthWest');
INSERT INTO equipos VALUES ('Supersonics','Seattle','West','NorthWest');
INSERT INTO equipos VALUES ('Lakers','Los Angeles','West','Pacific');
INSERT INTO equipos VALUES ('Suns','Phoenix','West','Pacific');
INSERT INTO equipos VALUES ('Warriors','Golden State','West','Pacific');
INSERT INTO equipos VALUES ('Kings','Sacramento','West','Pacific');
INSERT INTO equipos VALUES ('Clippers','Los Angeles','West','Pacific');
INSERT INTO equipos VALUES ('Hornets','New Orleans','West','SouthWest');
INSERT INTO equipos VALUES ('Spurs','San Antonio','West','SouthWest');
INSERT INTO equipos VALUES ('Rockets','Houston','West','SouthWest');
INSERT INTO equipos VALUES ('Mavericks','Dallas','West','SouthWest');
INSERT INTO equipos VALUES ('Grizzlies','Memphis','West','SouthWest');

CREATE TABLE jugadores (
  codigo int NOT NULL,
  Nombre varchar(30) DEFAULT NULL,
  Procedencia varchar(20) DEFAULT NULL,
  Altura varchar(4) DEFAULT NULL, -- en pies, 1 pie 0,3048 metros
  Peso int DEFAULT NULL, -- en libras 1 libra 453.59 gramos
  Posicion varchar(12) DEFAULT NULL,
  Nombre_equipo varchar(20) DEFAULT NULL,
  constraint pkjug PRIMARY KEY (codigo),
  constraint fkjug FOREIGN KEY (Nombre_equipo) References equipos(Nombre)
) engine=innodb;

INSERT INTO jugadores VALUES (1,'Corey Brever','Florida','6,9',185,'ALA-PIVOTE','Timberwolves');
INSERT INTO jugadores VALUES (2,'Greg Buckner','Clemson','6,4',210,'ALA-PIVOTE','Timberwolves');
INSERT INTO jugadores VALUES (3,'Michael Doleac','Utah','6,11',262,'PIVOTE','Timberwolves');
INSERT INTO jugadores VALUES (4,'Randy Foye','Villanova','6,4',213,'BASE','Timberwolves');
INSERT INTO jugadores VALUES (5,'Ryan Gomes','Providence','6,7',250,'ESCOLTA','Timberwolves');
INSERT INTO jugadores VALUES (6,'Marko Jaric','Serbia','6,7',224,'BASE','Timberwolves');
INSERT INTO jugadores VALUES (7,'Al Jefferson','Prentiss Hs','6,10',265,'ALERO','Timberwolves');
INSERT INTO jugadores VALUES (8,'Mark Madsen','Stanford','6,9',250,'ALERO','Timberwolves');
INSERT INTO jugadores VALUES (9,'Rashard McCants','North Carolina','6,4',21,'BASE','Timberwolves');
INSERT INTO jugadores VALUES (10,'Chris Richard ','Florida','6,9',270,'ESCOLTA','Timberwolves');
INSERT INTO jugadores VALUES (11,'Craig Smith','Boston College','6,8',250,'ALERO','Timberwolves');
INSERT INTO jugadores VALUES (12,'Kirk Snyder','Nevada,Reno','6,6',225,'BASE','Timberwolves');
INSERT INTO jugadores VALUES (13,'Sebastian Telfair','Abraham Lincoln HS','6,0',175,'BASE','Timberwolves');
INSERT INTO jugadores VALUES (14,'Antoine Walker','Kentucky','6,9',245,'ESCOLTA','Timberwolves');
INSERT INTO jugadores VALUES (21,'Elton brand','duke','6,8',254,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (22,'Paul Davis','Michigan','6,11',270,'PIVOTE','Clippers');
INSERT INTO jugadores VALUES (23,'Dan Dickau','Gonzaga','6,0',180,'BASE','Clippers');
INSERT INTO jugadores VALUES (24,'Nick Fazekas','Nevada,Reno','6,11',235,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (25,'Chris Kaman','Central Michigan','7,0',265,'PIVOTE','Clippers');
INSERT INTO jugadores VALUES (26,'Brevin Knight','Stanford','5,10',170,'BASE','Clippers');
INSERT INTO jugadores VALUES (27,'Shaun Livingston','Peoria Central','6,7',182,'BASE','Clippers');
INSERT INTO jugadores VALUES (28,'Corey Maggette','duke','6,6',225,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (29,'Cuttino Mobley','Rhode Island','6,4',215,'BASE','Clippers');
INSERT INTO jugadores VALUES (30,'Smush Parker','Fordham','6,4',190,'BASE','Clippers');
INSERT INTO jugadores VALUES (31,'Josh Powell','North Carolina State','6,9',240,'ALERO','Clippers');
INSERT INTO jugadores VALUES (32,'Quinton Ross','Southern Methodist','6,6',193,'ALA-PIVOTE','Clippers');
INSERT INTO jugadores VALUES (33,'Tim Thomas','Villanova','6,10',240,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (34,'Al thornton','Florida State','6,8',220,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (35,'Marcus Williams','Arizona','6,7',207,'ESCOLTA','Clippers');
INSERT INTO jugadores VALUES (41,'Andre Brown','De Paul','6,9',245,'ESCOLTA','Grizzlies');
INSERT INTO jugadores VALUES (42,'Kwame Brown','Glynn Academy','6,11',270,'PIVOTE','Grizzlies');
INSERT INTO jugadores VALUES (43,'Brian Cardinal','Purdue','6,8',245,'ESCOLTA','Grizzlies');
INSERT INTO jugadores VALUES (44,'Jason Collins','Stanford','7,0',255,'ALERO','Grizzlies');
INSERT INTO jugadores VALUES (45,'Mike Conley','Ohio State','6,1',180,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (46,'Javaris Crittenton','Georgia Tech','6,5',200,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (47,'Rudy Gay','Connecticut','6,8',222,'ESCOLTA','Grizzlies');
INSERT INTO jugadores VALUES (48,'Casey Jacobsen','Stanford','6,6',215,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (49,'Kyle Lowry','Villanova','6,0',175,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (50,'Aaron Mckie','Temple','6,5',209,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (51,'Darko Milicic','Serbia Montenegro','7,0',275,'ALERO','Grizzlies');
INSERT INTO jugadores VALUES (52,'Mike Miller','Florida','6,8',218,'ALA-PIVOTE','Grizzlies');
INSERT INTO jugadores VALUES (53,'Juan Carlos Navarro','Spain','6,3',170,'BASE','Grizzlies');
INSERT INTO jugadores VALUES (54,'Hakim Warrick','Syracuse','6,9',215,'ESCOLTA','Grizzlies');
INSERT INTO jugadores VALUES (61,'Trevor Ariza','UCLA','6,8',210,'ESCOLTA','Lakers');
INSERT INTO jugadores VALUES (62,'Kobe Bryant','Lower Merion HS (PA)','6,6',205,'BASE','Lakers');
INSERT INTO jugadores VALUES (63,'Andrew Bynum','St. Joseph HS (NJ)','7,0',285,'PIVOTE','Lakers');
INSERT INTO jugadores VALUES (64,'Jordan Farmar','UCLA','6,2',180,'BASE','Lakers');
INSERT INTO jugadores VALUES (65,'Derek Fisher','Arkansas,Little Rock','6,1',210,'BASE','Lakers');
INSERT INTO jugadores VALUES (66,'Pau Gasol','Spain','7,0',250,'ALERO','Lakers');
INSERT INTO jugadores VALUES (67,'Didier Ilunga,Mbenga','Congo','7,0',255,'PIVOTE','Lakers');
INSERT INTO jugadores VALUES (68,'Coby Karl','Boise State','6,5',215,'BASE','Lakers');
INSERT INTO jugadores VALUES (69,'Chris Mihm','Texas','7,0',265,'PIVOTE','Lakers');
INSERT INTO jugadores VALUES (70,'Ira Newble','Miami(Ohia)','6,7',220,'ALA-PIVOTE','Lakers');
INSERT INTO jugadores VALUES (71,'Lamar Odom','Rhode Island','6,10',230,'ESCOLTA','Lakers');
INSERT INTO jugadores VALUES (72,'Vladimir Radmanovic','Serbia Montenegro','6,10',235,'ESCOLTA','Lakers');
INSERT INTO jugadores VALUES (73,'Ronny Turiaf','Gonzaga','6,10',250,'ALERO','Lakers');
INSERT INTO jugadores VALUES (74,'Sasha Vujacic','Slovenia','6,7',205,'BASE','Lakers');
INSERT INTO jugadores VALUES (75,'Luke Walton','Arizona','6,8',235,'ESCOLTA','Lakers');

INSERT INTO jugadores VALUES (81,'Andrea Bargnani','Italy','7,0',250,'ALERO','Raptors');
INSERT INTO jugadores VALUES (82,'Maceo Baston','Michigan','6,10',230,'ALERO','Raptors');
INSERT INTO jugadores VALUES (84,'Primoz Brezec','Slovenia','7,1',255,'PIVOTE','Raptors');
INSERT INTO jugadores VALUES (85,'Jose Calderon','Spain','6,3',210,'BASE','Raptors');
INSERT INTO jugadores VALUES (86,'Carlos Delfino','Argentina','6,6',230,'BASE','Raptors');
INSERT INTO jugadores VALUES (87,'T.J. Ford','Texas','6,0',165,'BASE','Raptors');
INSERT INTO jugadores VALUES (88,'Jorge Garbajosa','Spain','6,9',245,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (89,'Joey Graham','Oklahoma State','6,7',225,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (90,'Kris Humphries','Minnesota','6,9',235,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (91,'Linton Johnson III','Tulane','6,8',205,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (92,'Jason Kapono','UCLA','6,8',215,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (93,'Jamario Moon','Merdian CC (MS)','6,8',205,'ESCOLTA','Raptors');
INSERT INTO jugadores VALUES (94,'Rasho Nesterovic','Slovenia','7,0',255,'PIVOTE','Raptors');
INSERT INTO jugadores VALUES (95,'Anthony Parker','Bradley','6,6',215,'ALA-PIVOTE','Raptors');

INSERT INTO jugadores VALUES (100,'Renaldo Balkman','South Carolina','6,8',202,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (101,'Wilson Chandler','DePaul','6,8',220,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (102,'Mardy Collins','Temple','6,6',220,'BASE','Knicks');
INSERT INTO jugadores VALUES (103,'Jamal Crawford','Michigan','6,5',220,'BASE','Knicks');
INSERT INTO jugadores VALUES (104,'Eddy Curry','Thornwood HS','6,11',285,'PIVOTE','Knicks');
INSERT INTO jugadores VALUES (105,'Jerome James','Florida AM','7,1',285,'PIVOTE','Knicks');
INSERT INTO jugadores VALUES (106,'Jared Jeffries','Indiana','6,11',240,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (107,'Fred Jones','Oregon','6,2',225,'BASE','Knicks');
INSERT INTO jugadores VALUES (108,'David Lee','Florida','6,9',240,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (109,'Stephon Marbury','Georgia Tech','6,2',205,'BASE','Knicks');
INSERT INTO jugadores VALUES (110,'Randolph Morris','Kentucky','6,11',260,'PIVOTE','Knicks');
INSERT INTO jugadores VALUES (111,'Zach Randolph','Michigan State','6,9',260,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (112,'Quentin Richardson','DePaul','6,6',235,'ALA-PIVOTE','Knicks');
INSERT INTO jugadores VALUES (113,'Nate Robinson','Washington','5,9',180,'BASE','Knicks');
INSERT INTO jugadores VALUES (114,'Malik Rose','Drexel','6,7',255,'ESCOLTA','Knicks');
INSERT INTO jugadores VALUES (120,'Louis Amundson',' Nevada,Las Vegas',' 6,9',225,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (121,'Calvin Booth','Penn State','6,11',250,'PIVOTE','76ers');
INSERT INTO jugadores VALUES (122,'Rodney Carney','Memphis','6,7',204,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (123,'Samuel Dalembert','Seton Hall','6,11',250,'PIVOTE','76ers');
INSERT INTO jugadores VALUES (124,'Reggie Evans','Iowa','6,8',245,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (125,'Willie Green','Detroit Mercy','6,3',201,'BASE','76ers');
INSERT INTO jugadores VALUES (126,'Herbert Hill','Providence','6,10',240,'ALERO','76ers');
INSERT INTO jugadores VALUES (127,'Andre Iguodala','Arizona','6,6',207,'ALA-PIVOTE','76ers');
INSERT INTO jugadores VALUES (128,'Andre Miller','Utah','6,2',200,'BASE','76ers');
INSERT INTO jugadores VALUES (129,'Kevin Ollie','Connecticut','6,2',195,'BASE','76ers');
INSERT INTO jugadores VALUES (130,'Shavlik Randolph','Duke','6,10',240,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (131,'Jason Smith','Colorado Sate','7,0',240,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (132,'Louis Williams','South Gwinnett HS','6,2',175,'BASE','76ers');
INSERT INTO jugadores VALUES (133,'Thaddeus Young','Georgio Tech','6,8',220,'ESCOLTA','76ers');
INSERT INTO jugadores VALUES (150,'Lance Allred','Weber State','6,11',250,'PIVOTE','Cavaliers');
INSERT INTO jugadores VALUES (151,'Devin Brown','Texas,San Antonio','6,5',210,'BASE','Cavaliers');
INSERT INTO jugadores VALUES (152,'Daniel Gibson','Texas','6,2',194,'BASE','Cavaliers');
INSERT INTO jugadores VALUES (153,'Zydrunas Ilgauskas','St. Vincent,St. Mary','7,3',260,'PIVOTE','Cavaliers');
INSERT INTO jugadores VALUES (154,'LeBron James','Houston','6,8',250,'ESCOLTA','Cavaliers');
INSERT INTO jugadores VALUES (155,'Damon Jones','Saint Joseph''s','6,3',195,'BASE','Cavaliers');
INSERT INTO jugadores VALUES (156,'Dwayne Jones','Serbia','6,11',251,'ALERO','Cavaliers');
INSERT INTO jugadores VALUES (157,'Aleksandar Pavlovic','Maryland','6,7',239,'ALA-PIVOTE','Cavaliers');
INSERT INTO jugadores VALUES (158,'Joe Smith','Michigan State','6,10',225,'ALERO','Cavaliers');
INSERT INTO jugadores VALUES (159,'Eric Snow','Miami ','6,3',205,'BASE','Cavaliers');
INSERT INTO jugadores VALUES (160,'Wally Szczerbiak','Brazil','6,7',245,'ESCOLTA','Cavaliers');
INSERT INTO jugadores VALUES (161,'Anderson Varejao','Merdian CC (MS)','6,10',240,'ALERO','Cavaliers');
INSERT INTO jugadores VALUES (162,'Ben Wallace','Virginia Union','6,9',240,'ALERO','Cavaliers');
INSERT INTO jugadores VALUES (163,'Delonte West','Saint Joseph''s','6,3',180,'BASE','Cavaliers');
INSERT INTO jugadores VALUES (181,'Derek Anderson','Kentucky','6,5',195,'BASE','Bobcats');
INSERT INTO jugadores VALUES (182,'Earl Boykins','Eastern michigan','5,5',133,'BASE','Bobcats');
INSERT INTO jugadores VALUES (183,'Matt Carroll','Notre Dame','6,6',212,'BASE','Bobcats');
INSERT INTO jugadores VALUES (184,'Jermareo Davidson','Alabama','6,10',230,'ESCOLTA','Bobcats');
INSERT INTO jugadores VALUES (185,'Jared Dudley','Boston College','6,7',225,'ESCOLTA','Bobcats');
INSERT INTO jugadores VALUES (186,'Raymond Felton','North Carolina','6,1',198,'BASE','Bobcats');
INSERT INTO jugadores VALUES (187,'Othella Harrington','Georgetown','6,9',235,'ALERO','Bobcats');
INSERT INTO jugadores VALUES (188,'Ryan Hollins','Ucla','7,0',230,'PIVOTE','Bobcats');
INSERT INTO jugadores VALUES (189,'Sean May','North Carolina','6,9',266,'ALERO','Bobcats');
INSERT INTO jugadores VALUES (190,'Nazr Mohammed','Kentucky','6,10',250,'PIVOTE','Bobcats');
INSERT INTO jugadores VALUES (191,'Adam Morrison','Gonzaga','6,8',205,'ESCOLTA','Bobcats');
INSERT INTO jugadores VALUES (192,'Emeka Okafor','Connecticut','6,10',255,'ALERO','Bobcats');
INSERT INTO jugadores VALUES (193,'Jason Richardson','Michigan State','6,6',225,'ALA-PIVOTE','Bobcats');
INSERT INTO jugadores VALUES (194,'Gerald Wallace','Alabama','6,7',220,'ESCOLTA','Bobcats');
INSERT INTO jugadores VALUES (201,'Charlie Bell','Michigan State','6,3',200,'BASE','Bucks');
INSERT INTO jugadores VALUES (202,'Andrew Bouqt','Utah','7,0',260,'PIVOTE','Bucks');
INSERT INTO jugadores VALUES (203,'Dan Gadzuric','Ucla','6,11',245,'PIVOTE','Bucks');
INSERT INTO jugadores VALUES (204,'Royal Ivey','Texas','6,4',215,'BASE','Bucks');
INSERT INTO jugadores VALUES (205,'Desmond Mason','Oklahoma State','6,5',222,'ESCOLTA','Bucks');
INSERT INTO jugadores VALUES (206,'Michael Redd','Ohio State','6,6',215,'BASE','Bucks');
INSERT INTO jugadores VALUES (207,'Michael Ruffin','Tulsa','6,8',248,'ALERO','Bucks');
INSERT INTO jugadores VALUES (208,'Ramon Sessions','Nevava,Reno','6,3',190,'BASE','Bucks');
INSERT INTO jugadores VALUES (209,'Bobby Simmons','DePaul','6,6',230,'ESCOLTA','Bucks');
INSERT INTO jugadores VALUES (210,'Awvee Store','Arizona State','6,6',225,'ALA-PIVOTE','Bucks');
INSERT INTO jugadores VALUES (211,'Charlie Villanueva','Connecticut','6,11',232,'ESCOLTA','Bucks');
INSERT INTO jugadores VALUES (212,'Jake Voskuhl','Connecticut','6,11',255,'PIVOTE','Bucks');
INSERT INTO jugadores VALUES (213,'Mo Williams','Alabama','6,1',185,'BASE','Bucks');
INSERT INTO jugadores VALUES (214,'Yi Jianlian','Connecticut','7,0',238,'ESCOLTA','Bucks');
INSERT INTO jugadores VALUES (220,'Shannon Brown','Michigan State','6,4',211,'BASE','Bulls');
INSERT INTO jugadores VALUES (221,'JamesOn Curry','Oklahoma Stare','6,3',190,'BASE','Bulls');
INSERT INTO jugadores VALUES (222,'Luol Deng','Duke','6,9',220,'ESCOLTA','Bulls');
INSERT INTO jugadores VALUES (223,'Chris Duhon','Duke','6,1',185,'BASE','Bulls');
INSERT INTO jugadores VALUES (224,'Drew Gooden','Kansas','6,10',250,'ESCOLTA','Bulls');
INSERT INTO jugadores VALUES (225,'Ben Gordon','Connecticut','6,3',200,'BASE','Bulls');
INSERT INTO jugadores VALUES (226,'Aaron Gray','Pittsburgh','7,0',270,'PIVOTE','Bulls');
INSERT INTO jugadores VALUES (227,'Kirk Hinrich','Kansas','6,3',190,'BASE','Bulls');
INSERT INTO jugadores VALUES (228,'Larry Hughes','St.Luis','6,5',185,'BASE','Bulls');
INSERT INTO jugadores VALUES (229,'Demetris Nichols','Syracuse','6,8',216,'ESCOLTA','Bulls');
INSERT INTO jugadores VALUES (230,'Joakin Noah','Florida','6,11',232,'ALERO','Bulls');
INSERT INTO jugadores VALUES (231,'Andres Nocioni','Argentina','6,7',225,'ESCOLTA','Bulls');
INSERT INTO jugadores VALUES (232,'Thabo Sefolosha','Switzerland','6,7',215,'BASE','Bulls');
INSERT INTO jugadores VALUES (233,'Cedric Simmons','North Carolina State','6,9',235,'ESCOLTA','Bulls');
INSERT INTO jugadores VALUES (234,'Tyrus Thonas','Louisiana State','6,9',215,'ESCOLTA','Bulls');

INSERT INTO jugadores VALUES (240,'Ray Allen','Connecticut','6,5',205,'BASE','Celtics');
INSERT INTO jugadores VALUES (241,'Tony Allen','Oklahoma State','6,4',213,'BASE','Celtics');
INSERT INTO jugadores VALUES (242,'P.J.Brown','Louisiana State','6,11',239,'ALERO','Celtics');
INSERT INTO jugadores VALUES (243,'Sam Cassell','Florida State','6,3',185,'BASE','Celtics');
INSERT INTO jugadores VALUES (244,'Glen Davis','Louisiana State','6,9',289,'ESCOLTA','Celtics');
INSERT INTO jugadores VALUES (245,'Kevin Garnett','Farragut Academy','6,11',220,'ESCOLTA','Celtics');
INSERT INTO jugadores VALUES (246,'Eddie House','Arizona State','6,1',175,'BASE','Celtics');
INSERT INTO jugadores VALUES (247,'Kendrick Perkins','Clifton J.Ozen HS','6,10',264,'PIVOTE','Celtics');
INSERT INTO jugadores VALUES (248,'Paul Pierce','Kansas','6,7',230,'ESCOLTA','Celtics');
INSERT INTO jugadores VALUES (249,'Scot Pollard','Kansas','6,11',278,'ALERO','Celtics');
INSERT INTO jugadores VALUES (250,'James Posey','Xavier','6,8',217,'ESCOLTA','Celtics');
INSERT INTO jugadores VALUES (251,'Leon Powe','California','6,8',240,'ESCOLTA','Celtics');
INSERT INTO jugadores VALUES (252,'Gabe Pruitt','USC','6,4',170,'BASE','Celtics');
INSERT INTO jugadores VALUES (253,'Rajon Rondo','Kentucky','6,1',171,'BASE','Celtics');
INSERT INTO jugadores VALUES (254,'Brian Scalabrine','USC','6,9',235,'ALERO','Celtics');

INSERT INTO jugadores VALUES (261,'Mike Bibby','Arizona','6,1',190,'BASE','Hawks');
INSERT INTO jugadores VALUES (262,'Josh Childress','Stanford','6,8',210,'ALA-PIVOTE','Hawks');
INSERT INTO jugadores VALUES (263,'Speedy Claxton','Hofstra','6,1',170,'BASE','Hawks');
INSERT INTO jugadores VALUES (264,'Al Horford','Florida','6,10',245,'ALERO','Hawks');
INSERT INTO jugadores VALUES (265,'Joe Johnson','Arkansas','6,7',235,'BASE','Hawks');
INSERT INTO jugadores VALUES (266,'Solomon Jones','South Florida','6,10',230,'ESCOLTA','Hawks');
INSERT INTO jugadores VALUES (267,'Acie Law','Texas AM','6,3',195,'BASE','Hawks');
INSERT INTO jugadores VALUES (268,'Zaza Pachulia','Georgia','6,11',280,'PIVOTE','Hawks');
INSERT INTO jugadores VALUES (269,'Jeremy Richardson','Delta State','6,7',195,'ALA-PIVOTE','Hawks');
INSERT INTO jugadores VALUES (270,'Josh Smith','Oak Hill Academy','6,9',235,'ESCOLTA','Hawks');
INSERT INTO jugadores VALUES (271,'Salim Stoudamire','Arizona','6,1',175,'BASE','Hawks');
INSERT INTO jugadores VALUES (272,'Mario West','Georgia Tech','6,5',210,'BASE','Hawks');
INSERT INTO jugadores VALUES (273,'Marvin Williams','North Carolina','6,9',230,'ESCOLTA','Hawks');

commit;