-- Create table
create table T_ZL_IMAGE
(
  objectid          VARCHAR2(50),
  userID            VARCHAR2(50),
  blogID            VARCHAR2(50),
  image_name	    VARCHAR2(50),
  image_url			VARCHAR2(100),
  upload_time	    VARCHAR2(14),
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
comment on table T_ZL_IMAGE
  is '众邻-图片表';
-- Add comments to the columns 
comment on column T_ZL_IMAGE.objectid
  is '主键ID';
comment on column T_ZL_IMAGE.userID
  is '用户ID';
comment on column T_ZL_IMAGE.blogID
  is '微博ID';
comment on column T_ZL_IMAGE.image_name
  is '图片名称';
comment on column T_ZL_IMAGE.image_url
  is '图片路径';
comment on column T_ZL_IMAGE.upload_time
  is '上传时间';  
comment on column T_ZL_IMAGE.delete_staues
  is '状态（0已删除 1未删除）';  