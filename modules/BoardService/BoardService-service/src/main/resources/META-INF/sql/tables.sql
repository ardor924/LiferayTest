create table HHL_PROJECT_REP (
	rno LONG not null primary key,
	bno LONG,
	rWriter VARCHAR(75) null,
	rContents VARCHAR(75) null,
	rRegDate VARCHAR(75) null,
	rIndent INTEGER,
	rAnsNum INTEGER
);

create table HHL_PROJECT_TBL (
	bno LONG not null primary key,
	subject VARCHAR(75) null,
	writer VARCHAR(75) null,
	contents VARCHAR(75) null,
	regDate VARCHAR(75) null,
	hit INTEGER
);