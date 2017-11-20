-- INSERT INTO address VALUES (NULL,'442 Glenwood Avenue','Culver City','CA', '87547');
-- INSERT INTO address VALUES (NULL,'1 Yellow Brook Road','Emerald City','OZ', '12345');
 
-- INSERT INTO employee VALUES (NULL,12, 8754,'Curious','George' ,'Boy Monkey',1);
-- INSERT INTO employee VALUES (NULL,123, 8733,'Allen','Rench' ,'Torque Master',2);

INSERT INTO Username(username,password,enabled) VALUES ('restaurant','restaurant123', TRUE);
-- INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
INSERT INTO Username(username,password,enabled) VALUES ('admin','admin123', TRUE);
INSERT INTO Username(username,password,enabled) VALUES ('deliverer','deliverer123', TRUE);
  
INSERT INTO Role (username, role) VALUES ('restaurant', 'ROLE_RESTAURANT');
INSERT INTO Role (username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Role (username, role) VALUES ('deliverer', 'ROLE_DELIVERER');
-- INSERT INTO role (username, role) VALUES ('admin', 'ROLE_USER');
 
-- INSERT INTO  User (firstname, lastname,age,title,membernumber, username) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
-- INSERT INTO User (firstname, lastname,age,title,membernumber,username) VALUES ('Allen','Rench',123,'Torque Master', 8733,'restaurant');
-- INSERT INTO User (firstname, lastname,age,title,membernumber,username) VALUES ('Allen2','Rench2',123,'Torque Master', 8736,'deliverer');

INSERT INTO  Admin (firstname, lastname,title,username) VALUES ('Peter','Xi','Mr.', 'admin');
INSERT INTO  Rider (firstname, lastname,title,username) VALUES ('Camilo','Andres','Mr.', 'rider');
INSERT INTO  Restaurant (name,firstname, lastname,title,username) VALUES ('Panda Chinese Food','Sam','Khlok','Mr.', 'restaurant');
INSERT INTO  Deliverer (firstname, lastname,title,username) VALUES ('Camilo','Antonio','Mr.', 'deliverer');
INSERT INTO  Restaurant (name,firstname, lastname,username,note,email,address) VALUES ('Panda Chinese Food','Sam','Khlok','restaurant', 'great restaurant', 'sam@ting.com','address 1 2 3');
 