create table HHL_PROJECT_ADDFILE (
	fno LONG not null primary key,
	bno LONG,
	fRealName VARCHAR(75) null,
	fName VARCHAR(75) null,
	fPath TEXT null,
	fDate VARCHAR(75) null
);

create table HHL_PROJECT_REP (
	rno LONG not null primary key,
	bno LONG,
	rWriter VARCHAR(75) null,
	rContents TEXT null,
	rRegDate VARCHAR(75) null
);

create table HHL_PROJECT_TBL (
	bno LONG not null primary key,
	subject VARCHAR(75) null,
	writer VARCHAR(75) null,
	contents TEXT null,
	regDate VARCHAR(75) null,
	hit INTEGER,
	subject_id INTEGER
);