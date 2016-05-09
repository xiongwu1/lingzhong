-- Create table
create table T_ZL_USER_RELATION
(
  objectid          VARCHAR2(50),
  promoter          VARCHAR2(50),
  recipient         VARCHAR2(50),
  status            VARCHAR2(50),
  attention_time    VARCHAR2(50) 
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
comment on table T_ZL_USER_RELATION
  is '众邻-用户关系表';
-- Add comments to the columns 
comment on column T_ZL_USER_RELATION.objectid
  is '主键ID';
comment on column T_ZL_USER_RELATION.promoter
  is '发起人';
comment on column T_ZL_USER_RELATION.recipient
  is '接收人';
comment on column T_ZL_USER_RELATION.status
  is '状态';
comment on column T_ZL_USER_RELATION.attention_time
  is '关注时间';