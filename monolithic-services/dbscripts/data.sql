use moviecruiser;
INSERT INTO movie(mo_name,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser,mo_image_url) 
VALUES ('The Pursuit Of Happyness',2787965087,true,'2017/03/15','Drama',true,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_QY8kCmvcPtuapMXJzhDZ2Xo9US6ELVfH8Lg8MRJVWHxxtlkG&s'),
('Horrible Bosses',1518812988,true,'2017/12/23','Comedy',false,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqJeOtu9gEiOagXx7AHNozvyrw3183ywYgHclemefxWf9BovqI&s'),
('Deathnote',2187463944,true,'2018/08/21','Horror',false,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKrvi2KmdO4oqUmILPw1gWQU1OoPrIE1suS1c_HLv5KYybMqh2'),
('Interstellar',1671713208,false,'2017/07/02','Science Fiction',true,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWYwzytvlTZ6_QEuhjZQZPm9LQcC_UT-QfNlPwYZe3mV4tYUDn&s'),
('Avengers End Game',2750760348,true,'2022/11/02','Superhero',true,'https://www.soyacincau.com/wp-content/uploads/2019/08/20190804-Avengers_Endgame_KATT_English_2560x1422-768x427.jpeg');

INSERT INTO user(us_username,us_password) VALUES ('user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),('admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
desc favorites;
select * from role;
INSERT INTO role(ro_name) VALUES ('ROLE_USER'),('ROLE_ADMIN');
desc movie;
INSERT INTO user_role(ur_us_id,ur_ro_id) values (1,1),(2,2);
 show tables;
select * from user;
