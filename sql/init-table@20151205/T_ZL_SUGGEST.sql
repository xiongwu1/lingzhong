-- Create table
create table T_ZL_SUGGEST
(
  objectid          VARCHAR2(50),
  userID            VARCHAR2(50),
  suggest_content   VARCHAR2(200),
  mobile_phone	    VARCHAR2(12),
  suggest_time	    VARCHAR2(14),
  suggest_status    VARCHAR2(1)
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
comment on table T_ZL_SUGGEST
  is '众邻-反馈建议表';
-- Add comments to the columns 
comment on column T_ZL_SUGGEST.objectid
  is '主键ID';
comment on column T_ZL_SUGGEST.userID
  is '用户ID';
comment on column T_ZL_SUGGEST.suggest_content
  is '建议内容';
comment on column T_ZL_SUGGEST.mobile_phone
  is '联系方式';
comment on column T_ZL_SUGGEST.suggest_time
  is '建议时间';
comment on column T_ZL_SUGGEST.suggest_status
  is '状态（0已删除 1未删除）';  