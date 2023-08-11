use shopdb;

CREATE TABLE cust(
                     id VARCHAR(20) PRIMARY KEY,
                     pwd VARCHAR(20),
                     name VARCHAR(20)
);

INSERT INTO cust VALUES ('1', 123, '홍길동');
INSERT INTO cust VALUES ('2', 123, '김철수');
INSERT INTO cust VALUES ('3', 123, '영희');

CREATE TABLE item(
                     id INT PRIMARY KEY AUTO_INCREMENT,
                     name VARCHAR(30),
                     price BIGINT,
                     regdate DATETIME
);

INSERT INTO item (name, price, regdate) VALUES ('pants', 10000, NOW());
INSERT INTO item (name, price, regdate) VALUES ('shirts', 20000, NOW());
INSERT INTO item (name, price, regdate) VALUES ('hat', 50000, NOW());
