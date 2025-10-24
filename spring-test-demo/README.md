
创建表的sql
```sql
CREATE TABLE springtest.article (
	id BIGINT auto_increment NOT NULL,
	title varchar(256) NULL,
	content TEXT NULL,
	CONSTRAINT article_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
```