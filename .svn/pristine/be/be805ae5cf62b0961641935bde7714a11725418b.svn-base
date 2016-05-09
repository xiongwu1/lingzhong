-- Create table
create table T_ZL_BLOG_OPERATE
(
  objectid          VARCHAR2(50),
  blogID            VARCHAR2(50),
  userID            VARCHAR2(50),
  operate_time	    VARCHAR2(14),
  operate_type      VARCHAR2(1),
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
comment on table T_ZL_BLOG_OPERATE
  is '众邻-微博操作表';
-- Add comments to the columns 
comment on column T_ZL_BLOG_OPERATE.objectid
  is '主键ID';
comment on column T_ZL_BLOG_OPERATE.blogID
  is '微博ID';
comment on column T_ZL_BLOG_OPERATE.userID
  is '用户ID';
comment on column T_ZL_BLOG_OPERATE.operate_time
  is '操作时间';
comment on column T_ZL_BLOG_OPERATE.operate_type
  is '操作类别（0赞 1收藏）';
comment on column T_ZL_BLOG_OPERATE.delete_staues
  is '状态（0已删除 1未删除）';