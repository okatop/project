--funding.sql

DROP TABLE funding CASCADE CONSTRAINTS;
CREATE TABLE funding(
   no            	NUMBER          NOT NULL,   --�۹�ȣ   PK
   musician_id     	VARCHAR2(16)    NOT NULL,   --�����Ǿ��̵� FK
   category      	VARCHAR2(16)    NOT NULL,   --ī�װ��� (����, ����)
   goal         	NUMBER          NOT NULL,   --��ǥ�ݾ�
   open         	DATE  	        NOT NULL,   --������
   close          	DATE  	        NOT NULL,   --������
   pic              VARCHAR2(100)   NOT NULL,   --��ǥ�̹���
   title         	VARCHAR2(50)    NOT NULL,   --����
   contents      	CLOB     	    NOT NULL,   --����
   write_date   	DATE            DEFAULT SYSDATE,   --�ۼ���
   
   CONSTRAINT funding_pk PRIMARY KEY(no),
   CONSTRAINT musician_id_fk FOREIGN KEY(musician_id) REFERENCES member(id)
);

DROP SEQUENCE funding_seq;
CREATE SEQUENCE funding_seq INCREMENT BY 1 START WITH 1;

DROP TABLE funding_reward CASCADE CONSTRAINTS;
CREATE TABLE funding_reward(
   no             NUMBER         NOT NULL,   --�۹�ȣ FK
   amount         NUMBER         NOT NULL,   --���رݾ�
   pic            VARCHAR2(100)  NOT NULL,   --�̹���
   title          VARCHAR2(50)   NOT NULL,   --����
   contents       CLOB           NOT NULL,   --����
   
   CONSTRAINT funding_reward_no_fk FOREIGN KEY(no) REFERENCES funding(no)
);

DROP TABLE funding_status CASCADE CONSTRAINTS;
CREATE TABLE funding_status(
   no             NUMBER         NOT NULL,   --�۹�ȣ FK
   amount         NUMBER         NOT NULL,   --����޼��ݾ�
   status         VARCHAR2(1)    DEFAULT 'W',   --����(W���δ��, S����, E����)
   
   CONSTRAINT funding_reward_no_fk FOREIGN KEY(no) REFERENCES funding(no)
);

DROP TABLE backer CASCADE CONSTRAINTS;
CREATE TABLE backer(
   no              NUMBER         NOT NULL,   --�۹�ȣ FK
   member_id       VARCHAR2(16)   NOT NULL,   --ȸ�����̵� FK
   amount          NUMBER         NOT NULL,   --�Ŀ��ݾ�
   
   CONSTRAINT funding_reward_no_fk FOREIGN KEY(no) REFERENCES funding(no)
);