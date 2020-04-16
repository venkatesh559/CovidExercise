create database if not exists covid;
use covid;
drop table if exists covidData;
CREATE TABLE covidData(
	state varchar(64),
    city varchar(64),
    male numeric,
    female numeric
);
insert into covidData(state,city,male,female) values("Tamilnadu","Chennai",60,30);
insert into covidData (state,city,male,female) values("Tamilnadu","Coimbatore",25,10);
insert into covidData(state,city,male,female) values("AP","Chitoor",15,20);
insert into covidData(state,city,male,female) values("AP","Vijayawada",45,31);
insert into covidData(state,city,male,female) values("Kerala","Cochin",75,45);
insert into covidData(state,city,male,female) values("Kerala","Wayanad",15,15);
