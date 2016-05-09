-- Create table
create table T_ZL_COMMENT
(
  objectid          VARCHAR2(50),
  blogID            VARCHAR2(50),
  userID            VARCHAR2(50),
  comment_time	    VARCHAR2(14),
  comment_content   VARCHAR2(200),
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
comment on table T_ZL_COMMENT
  is '众邻-评论表';
-- Add comments to the columns 
comment on column T_ZL_COMMENT.objectid
  is '主键ID';
comment on column T_ZL_COMMENT.blogID
  is '微博ID';
comment on column T_ZL_COMMENT.userID
  is '用户ID';
comment on column T_ZL_COMMENT.comment_time
  is '评论时间';
comment on column T_ZL_COMMENT.comment_content
  is '评论内容';
comment on column T_ZL_COMMENT.delete_staues
  is '状态（0已删除 1未删除）';  