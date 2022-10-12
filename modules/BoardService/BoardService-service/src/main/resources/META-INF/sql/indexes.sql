create index IX_8A09E749 on HHL_PROJECT_ADDFILE (bno);

create index IX_F78A20C9 on HHL_PROJECT_REP (bno);

create index IX_62E97539 on HHL_PROJECT_TBL (contents[$COLUMN_LENGTH:4096$]);
create index IX_3B62AA51 on HHL_PROJECT_TBL (subject[$COLUMN_LENGTH:75$]);
create index IX_3885C392 on HHL_PROJECT_TBL (writer[$COLUMN_LENGTH:75$]);