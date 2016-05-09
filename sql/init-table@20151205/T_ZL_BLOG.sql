-- Create table
create table T_ZL_BLOG
(
  objectid          VARCHAR2(50),
  content           VARCHAR2(200),
  userID            VARCHAR2(50),
  is_open           VARCHAR2(1),
  release_time	    VARCHAR2(14),
  release_place     VARCHAR2(50),
  before_blogid		VARCHAR2(50),
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
comment on table T_ZL_BLOG
  is '众邻-微博表';
-- Add comments to the columns 
comment on column T_ZL_BLOG.objectid
  is '主键ID';
comment on column T_ZL_BLOG.content
  is '内容';
comment on column T_ZL_BLOG.userID
  is '用户ID';
comment on column T_ZL_BLOG.is_open
  is '是否公开(0是1否)';
comment on column T_ZL_BLOG.release_time
  is '发布时间';
comment on column T_ZL_BLOG.release_place
  is '发布地点';
comment on column T_ZL_BLOG.before_blogid
  is '原微博ID';  
comment on column T_ZL_BLOG.delete_staues
  is '状态（0已删除 1未删除）';  