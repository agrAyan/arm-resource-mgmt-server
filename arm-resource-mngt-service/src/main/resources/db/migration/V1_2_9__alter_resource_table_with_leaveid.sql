alter table resource drop FOREIGN KEY resource_ibfk_2;
alter table resource drop column leave_id;

alter table leaves add column resource_id int(11),add foreign key(resource_id) references resource(resource_id);