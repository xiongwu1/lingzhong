-- Create table
create table T_ZL_USER_PERSON
(
  objectid          VARCHAR2(50),
  login_name        VARCHAR2(50),
  password          VARCHAR2(50),
  nick_name         VARCHAR2(50),
  head_portrait		VARCHAR2(100),
  real_name         VARCHAR2(50),
  szd_province      VARCHAR2(20),
  szd_city          VARCHAR2(20),
  gender            VARCHAR2(1),
  xqx               VARCHAR2(1),
  gqzk              VARCHAR2(1),
  birthday          VARCHAR2(14),
  blood_type        VARCHAR2(1),
  email             VARCHAR2(50),
  mobile_phone      VARCHAR2(50),
  qq                VARCHAR2(20),
  gxqm              VARCHAR2(200),
  registered_time   VARCHAR2(14),
  update_time		VARCHAR2(14),
  last_login_time   VARCHAR2(14),
  is_lock           VARCHAR2(1),
  djzd              VARCHAR2(1),
  user_type         VARCHAR2(1)  
);
/**
tablespace ZL_DATA0
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );**/
-- Add comments to the table 
comment on table T_ZL_USER_PERSON
  is '众邻-个人用户';
-- Add comments to the columns 
comment on column T_ZL_USER_PERSON.objectid
  is '主键ID';
comment on column T_ZL_USER_PERSON.login_name
  is '登录名';
comment on column T_ZL_USER_PERSON.password
  is '密码(MD5加密)';
comment on column T_ZL_USER_PERSON.nick_name
  is '昵称';
comment on column T_ZL_USER_PERSON.head_portrait
  is '头像';
comment on column T_ZL_USER_PERSON.real_name
  is '真实姓名';
comment on column T_ZL_USER_PERSON.szd_province
  is '所在地-省';
comment on column T_ZL_USER_PERSON.szd_city
  is '所在地-市';
comment on column T_ZL_USER_PERSON.gender
  is '性别（0男 1女）';
comment on column T_ZL_USER_PERSON.xqx
  is '性取向（0男 1女）';
comment on column T_ZL_USER_PERSON.gqzk
  is '感情状况（0单身 1恋爱 2订婚 3已婚 4离婚 5丧偶）';
comment on column T_ZL_USER_PERSON.birthday
  is '生日';
comment on column T_ZL_USER_PERSON.blood_type
  is '血型（0A型 1B型 2AB型 3O型）';
comment on column T_ZL_USER_PERSON.email
  is '邮箱';
comment on column T_ZL_USER_PERSON.mobile_phone
  is '手机号';
comment on column T_ZL_USER_PERSON.qq
  is 'QQ';
comment on column T_ZL_USER_PERSON.gxqm
  is '个性签名';
comment on column T_ZL_USER_PERSON.registered_time
  is '注册时间';
comment on column T_ZL_USER_PERSON.update_time
  is '修改时间';
comment on column T_ZL_USER_PERSON.last_login_time
  is '上次登录时间';
comment on column T_ZL_USER_PERSON.is_lock
  is '是否锁定（0是1否）';
comment on column T_ZL_USER_PERSON.djzd
  is '等级制度';
comment on column T_ZL_USER_PERSON.user_type
  is '用户类型（1注册用户 2管理员）';
