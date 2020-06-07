create database hr_dev;

create user 'hr_dev_user'@'localhost' identified by 'HR';

grant select on hr_dev.* to 'hr_dev_user'@'localhost';
grant insert on hr_dev.* to 'hr_dev_user'@'localhost';
grant delete on hr_dev.* to 'hr_dev_user'@'localhost';
grant update on hr_dev.* to 'hr_dev_user'@'localhost';