create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
create table job_post (id bigint not null auto_increment, city varchar(255), description varchar(255), requirement varchar(255), title varchar(255), poster_user_id bigint, primary key (id)) engine=InnoDB
create table jobpost_user (jobpost_id bigint not null, user_id bigint not null, primary key (jobpost_id, user_id)) engine=InnoDB
create table job_skill (id bigint not null auto_increment, skill_level integer not null, skill_name varchar(255), job_post_id bigint, primary key (id)) engine=InnoDB
create table user (user_id bigint not null auto_increment, active integer not null, city varchar(255), email_user varchar(255), first_name varchar(255), image longblob, job_title varchar(255), last_name varchar(255), password varchar(255), resume varchar(255), role varchar(255), seniority_level varchar(255), username varchar(255), primary key (user_id)) engine=InnoDB
create table user_job_applied (user_user_id bigint not null, job_applied_id bigint not null, primary key (user_user_id, job_applied_id)) engine=InnoDB
create table user_job_posted (user_user_id bigint not null, job_posted_id bigint not null, primary key (user_user_id, job_posted_id)) engine=InnoDB
create table user_user_skills (user_user_id bigint not null, user_skills_id bigint not null, primary key (user_user_id, user_skills_id)) engine=InnoDB
create table user_skill (id bigint not null auto_increment, user_skill_level integer not null, user_skill_name varchar(255), user_user_id bigint, primary key (id)) engine=InnoDB
alter table user_job_posted add constraint UK_8jdo32k3qxse59ii816y5m5h9 unique (job_posted_id)
alter table user_user_skills add constraint UK_2472up7kc2brf5d3ktcylsbui unique (user_skills_id)
alter table job_post add constraint FKshvyhlmkn5se6chwmcia3q5mm foreign key (poster_user_id) references user (user_id)
alter table jobpost_user add constraint FK6j41tf5fs6ns5k328s06f185f foreign key (user_id) references user (user_id)
alter table jobpost_user add constraint FKr7fcof4yfh2me120vlc1xko0h foreign key (jobpost_id) references job_post (id)
alter table job_skill add constraint FKdj7eauyix6jdi5qbd6sn6d4xr foreign key (job_post_id) references job_post (id)
alter table user_job_applied add constraint FKiq399s7k6htqf1dxg7nt8stk1 foreign key (job_applied_id) references job_post (id)
alter table user_job_applied add constraint FKqdo5j35bxv7rumpwhnm8wf3u0 foreign key (user_user_id) references user (user_id)
alter table user_job_posted add constraint FKc71dee5sl9dnvawropqa40ve8 foreign key (job_posted_id) references job_post (id)
alter table user_job_posted add constraint FK3t5m5nbthpf7fjpp2u52ireco foreign key (user_user_id) references user (user_id)
alter table user_user_skills add constraint FKmgaevocklquhpfa0y99apnjcd foreign key (user_skills_id) references user_skill (id)
alter table user_user_skills add constraint FKin2qabo24mp0085cfvs5b8h4d foreign key (user_user_id) references user (user_id)
alter table user_skill add constraint FK2mvjqg1v01l2q9ys7twmvov7m foreign key (user_user_id) references user (user_id)
