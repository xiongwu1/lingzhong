-- Create table
create table T_ZL_SKIN
(
  objectid          VARCHAR2(50),
  userID            VARCHAR2(50),
  skin_name			VARCHAR2(50),
  image_url	  		VARCHAR2(50),
  upload_time  	    VARCHAR2(14),
  delete_staues		VARCHAR2(1)
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
comment on table T_ZL_SKIN
  is '众邻-皮肤表';
-- Add comments to the columns 
comment on column T_ZL_SKIN.objectid
  is '主键ID';
comment on column T_ZL_SKIN.userID
  is '用户ID';
comment on column T_ZL_SKIN.skin_name
  is '皮肤名称';
comment on column T_ZL_SKIN.image_url
  is '图片路径';
comment on column T_ZL_SKIN.upload_time
  is '上传时间';
comment on column T_ZL_SKIN.delete_staues
  is '状态（0已删除 1未删除）';  