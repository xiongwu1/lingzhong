prompt PL/SQL Developer import file
prompt Created on 2016年3月9日 星期三 by leizhu2
set feedback off
set define off
prompt Disabling triggers for T_ZL_BLOG...
alter table T_ZL_BLOG disable all triggers;
prompt Disabling triggers for T_ZL_BLOG_OPERATE...
alter table T_ZL_BLOG_OPERATE disable all triggers;
prompt Disabling triggers for T_ZL_COMMENT...
alter table T_ZL_COMMENT disable all triggers;
prompt Disabling triggers for T_ZL_IMAGE...
alter table T_ZL_IMAGE disable all triggers;
prompt Disabling triggers for T_ZL_SKIN...
alter table T_ZL_SKIN disable all triggers;
prompt Disabling triggers for T_ZL_SUGGEST...
alter table T_ZL_SUGGEST disable all triggers;
prompt Disabling triggers for T_ZL_USER_PERSON...
alter table T_ZL_USER_PERSON disable all triggers;
prompt Disabling triggers for T_ZL_USER_RELATION...
alter table T_ZL_USER_RELATION disable all triggers;
prompt Disabling triggers for T_ZL_ZD...
alter table T_ZL_ZD disable all triggers;
prompt Deleting T_ZL_ZD...
delete from T_ZL_ZD;
commit;
prompt Deleting T_ZL_USER_RELATION...
delete from T_ZL_USER_RELATION;
commit;
prompt Deleting T_ZL_USER_PERSON...
delete from T_ZL_USER_PERSON;
commit;
prompt Deleting T_ZL_SUGGEST...
delete from T_ZL_SUGGEST;
commit;
prompt Deleting T_ZL_SKIN...
delete from T_ZL_SKIN;
commit;
prompt Deleting T_ZL_IMAGE...
delete from T_ZL_IMAGE;
commit;
prompt Deleting T_ZL_COMMENT...
delete from T_ZL_COMMENT;
commit;
prompt Deleting T_ZL_BLOG_OPERATE...
delete from T_ZL_BLOG_OPERATE;
commit;
prompt Deleting T_ZL_BLOG...
delete from T_ZL_BLOG;
commit;
prompt Loading T_ZL_BLOG...
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f55286043301528619bf040005', '发条邻文[哈哈][亲亲] ' || chr(13) || '' || chr(10) || '                               ---------来自我的测试用户2', 'e4e4e4f15262270c0152622922280001', '0', '20160128103940', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f552860433015286249dc90008', '您好，我是TEST04，很高兴见到您！[太开心]', 'e4e4e4f65277ce29015277d96bc00002', '0', '20160128105132', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e426526d74cb01526d8ad4870002', '今天周六了，发条邻文，我还在加班！[睡][酷]', '40281d8151a85cd20151a85f2dd80001', '0', '20160123161240', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f5528647040152868fd55d0002', '来一发[微笑]', '40281d8151a85cd20151a85f2dd80001', '0', '20160128124839', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f0529a8dea01529a8f1a520002', '嗯嗯，下雪啦！[哈欠]', '40281d8151a85cd20151a85f2dd80001', '0', '20160201100015', '安徽亳州', null, '0');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f0529a8dea01529a90fa8f0004', '恩恩额[亲亲]', '40281d8151a85cd20151a85f2dd80001', '0', '20160201100218', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f0529a6e6a01529a879897000a', '测试数据 20160201[哈哈]', '40281d8151a85cd20151a85f2dd80001', '0', '20160201095203', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f0529a6e6a01529a8af81c000c', '测试数据 201602010955[偷笑] [馋嘴]', '40281d8151a85cd20151a85f2dd80001', '0', '20160201095544', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f152639791015263b7efde0009', '测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试测试测试试', '40281d8151a85cd20151a85f2dd80001', '0', '20160121182544', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f15263c056015263c449f00007', '什么能造成中国互联网行业大震动？[疑问][酷]', '40281d8151a85cd20151a85f2dd80001', '0', '20160121183914', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f15263979101526398b80b0007', '今天心情很开心，因为可以发邻文啦啦啦啦啦![哈哈][嘻嘻][偷笑][色]', '40281d8151a85cd20151a85f2dd80001', '0', '20160121175138', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f152639791015263b315340008', '2121', '40281d8151a85cd20151a85f2dd80001', '0', '20160121182026', '安徽亳州', null, '0');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f5527bf50901527bf6bb490003', '今天周二了，2016年1月26日，天气：晴[哈哈][偷笑][酷]', '40281d8151a85cd20151a85f2dd80001', '0', '20160126112513', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4ed5291ba53015291cae6290004', '[嘻嘻]', 'e4e4e4ed5291ba53015291c731e10001', '0', '20160130170859', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4ed5291ba53015291c81ec40002', 'hi 你好', 'e4e4e4ed5291ba53015291c731e10001', '0', '20160130170557', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4ed5291ba53015291c9395f0003', '[微笑]', 'e4e4e4ed5291ba53015291c731e10001', '0', '20160130170709', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('4028835d52e7ae610152e83fd5790006', '新年上班第一天！[哈哈]', '40281d8151a85cd20151a85f2dd80001', '0', '20160216120403', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f552871a810152872101520002', '再来一发！[偷笑]', '40281d8151a85cd20151a85f2dd80001', '0', '20160128152713', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4e4f5528784b60152879f44cd0001', '呵呵呵[bm做操]', '40281d8151a85cd20151a85f2dd80001', '0', '20160128174507', '安徽亳州', null, '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4d426536d74cb01526d8ad4871002', '转发一次@易先生3729今天周六了，发条邻文，我还在加班！[睡][酷]', 'e4e4e4f15262270c0152622922280001', '0', '20160123171240', '安徽芜湖', 'e4e4e426526d74cb01526d8ad4870002', '1');
insert into T_ZL_BLOG (objectid, content, userid, is_open, release_time, release_place, before_blogid, delete_staues)
values ('e4e4es26526d74cb61526d8dd4870002', '转发两次@易先生3729今天周六了，发条邻文，我还在加班！[睡][酷]', 'e4e4e4f15262270c0152622922280001', '0', '20160123171540', '安徽安庆', 'e4e4e426526d74cb01526d8ad4870002', '1');
commit;
prompt 21 records loaded
prompt Loading T_ZL_BLOG_OPERATE...
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e0153166a76da0005', 'e4e4e4f5528784b60152879f44cd0001', '40281d8151a85cd20151a85f2dd80001', '20160225111309', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e01531666b5910001', 'e4e4e4f0529a8dea01529a90fa8f0004', '40281d8151a85cd20151a85f2dd80001', '20160225110903', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e0153166a86850007', 'e4e4e4ed5291ba53015291c9395f0003', '40281d8151a85cd20151a85f2dd80001', '20160225111313', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e0153166a81c40006', 'e4e4e4ed5291ba53015291c81ec40002', '40281d8151a85cd20151a85f2dd80001', '20160225111312', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e0153166a9e390008', 'e4e4e4f0529a6e6a01529a8af81c000c', '40281d8151a85cd20151a85f2dd80001', '20160225111319', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e0153166b18d40009', 'e4e4e4f0529a6e6a01529a879897000a', '40281d8151a85cd20151a85f2dd80001', '20160225111350', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e015316726edd000c', '4028835d52e7ae610152e83fd5790006', 'e4e4e4f15262270c0152622922280001', '20160225112151', '0', '1');
insert into T_ZL_BLOG_OPERATE (objectid, blogid, userid, operate_time, operate_type, delete_staues)
values ('4028835d53165c1e015316727fb0000d', 'e4e4e4f0529a8dea01529a90fa8f0004', 'e4e4e4f15262270c0152622922280001', '20160225112155', '0', '1');
commit;
prompt 8 records loaded
prompt Loading T_ZL_COMMENT...
insert into T_ZL_COMMENT (objectid, blogid, userid, comment_time, comment_content, delete_staues)
values ('e4e4e4f15263329101526398b80b1007', 'e4e4e4f15263c056015263c449f00007', '40281d8151a85cd20151a85f2dd80001', '20160122095138', '嗯，不错', '1');
insert into T_ZL_COMMENT (objectid, blogid, userid, comment_time, comment_content, delete_staues)
values ('e4e4e4f15138329100526398b80b1007', 'e4e4e4f15263c056015263c449f00007', '40281d8151a85cd20151a85f2dd80001', '20160122092138', '真棒啊', '1');
commit;
prompt 2 records loaded
prompt Loading T_ZL_IMAGE...
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f55286043301528619b5000002', 'e4e4e4f15262270c0152622922280001', 'e4e4e4f55286043301528619bf040005', 'Koala.jpg', 'group1/M00/00/00/wKgDzVaZvKyAOEVTAAvqH_kipG8620.jpg', '20160128103937', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f5528604330152862498460006', 'e4e4e4f65277ce29015277d96bc00002', 'e4e4e4f552860433015286249dc90008', 'Desert.jpg', 'group1/M00/00/01/wKgDzVaZv3WAODAwAAzodQCbVVc239.jpg', '20160128105131', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f5528604330152862499280007', 'e4e4e4f65277ce29015277d96bc00002', 'e4e4e4f552860433015286249dc90008', 'Tulips.jpg', 'group1/M00/00/01/wKgDzVaZv3aAen_HAAl5WLU-YRY824.jpg', '20160128105131', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f5528647040152868fabe30001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f5528647040152868fd55d0002', 'index_bg.jpg', 'group1/M00/00/01/wKgDzVaZ2t6AEPlZAAXfwv1qhik607.jpg', '20160128124828', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e426526d74cb01526d8ac1b10001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e426526d74cb01526d8ad4870002', 'index_bg.jpg', 'group1/M00/00/00/wKgDzVaTgNGALsMSAAXfwv1qhik316.jpg', '20160123161236', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f0529a6e6a01529a878d630009', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f0529a6e6a01529a879897000a', 'bg.jpg', 'group1/M00/00/01/wKgDzVae92eAdkRzAACwoWujuNU563.jpg', '20160201095200', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f0529a6e6a01529a8ae641000b', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f0529a6e6a01529a8af81c000c', 'df66909ea543201f48824b7f16c98d2a.jpg', 'group1/M00/00/01/wKgDzVae-EKAMaSjAAF8WavSfbw854.jpg', '20160201095540', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f0529a8dea01529a8f0fb30001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f0529a8dea01529a8f1a520002', 'index_bg.jpg', 'group1/M00/00/01/wKgDzVae-VOAPsGPAAXfwv1qhik859.jpg', '20160201100012', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f0529a8dea01529a90f7800003', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f0529a8dea01529a90fa8f0004', 'df66909ea543201f48824b7f16c98d2a.jpg', 'group1/M00/00/01/wKgDzVae-dCAE6B6AAF8WavSfbw745.jpg', '20160201100217', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263bc3a015263be23ec0001', '40281d8151a85cd20151a85f2dd80001', null, 'body_bg_page.jpg', 'group1/M00/00/00/wKgDzVaQ_qGAbMlaAAGKRjUOgW8873.jpg', '20160121183231', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263bc3a015263be46bc0003', '40281d8151a85cd20151a85f2dd80001', null, 'df66909ea543201f48824b7f16c98d2a.jpg', 'group1/M00/00/00/wKgDzVaQ_qqAZYvRAAF8WavSfbw302.jpg', '20160121183240', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263bc3a015263be47110005', '40281d8151a85cd20151a85f2dd80001', null, 'bg.jpg', 'group1/M00/00/00/wKgDzVaQ_qqAFDt7AACwoWujuNU891.jpg', '20160121183240', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3c1940002', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', 'body_bg_page.jpg', 'group1/M00/00/00/wKgDzVaRABGAeIN5AAGKRjUOgW8603.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3ccde0005', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', 'bg.jpg', 'group1/M00/00/00/wKgDzVaRABGAV0s-AACwoWujuNU648.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f5527bf50901527bf6b21f0001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f5527bf50901527bf6bb490003', 'index_bg.jpg', 'group1/M00/00/00/wKgDzVaXMe6AdxHDAAXfwv1qhik863.jpg', '20160126112510', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f5527bf50901527bf6b2730002', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f5527bf50901527bf6bb490003', 'QQ截图20151218193044.jpg', 'group1/M00/00/00/wKgDzVaXMe6AMar1AAAFqyAxR1w597.jpg', '20160126112511', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f55286043301528619b5050003', 'e4e4e4f15262270c0152622922280001', 'e4e4e4f55286043301528619bf040005', 'Lighthouse.jpg', 'group1/M00/00/01/wKgDzVaZvKyANMU2AAiQfKHDaaQ398.jpg', '20160128103937', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4d35307bf4a0153082dd3d20001', '40281d8151a85cd20151a85f2dd80001', null, '12.jpg', 'group1/M00/00/01/wKgDzVa7CM2AP4K3AAGSQk6l_rI533.jpg', '20160222165214', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983a400002', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Chrysanthemum.jpg', 'group1/M00/00/00/wKgDzVaQ9O2AAHflAA1rIuRd3Es187.jpg', '20160121175106', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983b620003', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Lighthouse.jpg', 'group1/M00/00/00/wKgDzVaQ9O2ADIuxAAiQfKHDaaQ521.jpg', '20160121175106', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263bc3a015263be23ec0002', '40281d8151a85cd20151a85f2dd80001', null, 'personal_cover_bg.jpg', 'group1/M00/00/00/wKgDzVaQ_qGASnQiAAG8XeL1uMY595.jpg', '20160121183231', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263bc3a015263be46cf0004', '40281d8151a85cd20151a85f2dd80001', null, '12.jpg', 'group1/M00/00/00/wKgDzVaQ_qqAQkKxAAGSQk6l_rI510.jpg', '20160121183240', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3c1940004', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', 'personal_cover_bg.jpg', 'group1/M00/00/00/wKgDzVaRABGAcKupAAG8XeL1uMY483.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3ccf10006', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', 'df66909ea543201f48824b7f16c98d2a.jpg', 'group1/M00/00/00/wKgDzVaRABGAMqqlAAF8WavSfbw392.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f55286043301528619b5190004', 'e4e4e4f15262270c0152622922280001', 'e4e4e4f55286043301528619bf040005', 'Penguins.jpg', 'group1/M00/00/01/wKgDzVaZvKyAOF22AAvea_OGt2M459.jpg', '20160128103937', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('4028835d52e7ae610152e83fce650005', '40281d8151a85cd20151a85f2dd80001', '4028835d52e7ae610152e83fd5790006', 'Desert.jpg', 'group1/M00/00/01/wKgDzVay3G2ACAB1AAzodQCbVVc298.jpg', '20160216120401', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983a3f0001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Desert.jpg', 'group1/M00/00/00/wKgDzVaQ9O2AO3bqAAzodQCbVVc278.jpg', '20160121175106', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983b660004', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Hydrangeas.jpg', 'group1/M00/00/00/wKgDzVaQ9O2AWzE4AAkVVGMybN8595.jpg', '20160121175106', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3c1940003', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', '12.jpg', 'group1/M00/00/00/wKgDzVaRABGAazEUAAGSQk6l_rI902.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f552871a8101528720fc630001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f552871a810152872101520002', 'personal_cover_bg.jpg', 'group1/M00/00/01/wKgDzVaaABCAFPp7AAG8XeL1uMY180.jpg', '20160128152711', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f552871a810152872921a70003', '40281d8151a85cd20151a85f2dd80001', null, 'df66909ea543201f48824b7f16c98d2a.jpg', 'group1/M00/00/01/wKgDzVaaAiaAeR97AAF8WavSfbw518.jpg', '20160128153605', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983ba10005', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Jellyfish.jpg', 'group1/M00/00/00/wKgDzVaQ9O2AP7eOAAvWFkcZHjA081.jpg', '20160121175107', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f15263c056015263c3c1920001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263c056015263c449f00007', 'Desert.jpg', 'group1/M00/00/00/wKgDzVaRABGAEj5cAAzodQCbVVc283.jpg', '20160121183839', '1');
insert into T_ZL_IMAGE (objectid, userid, blogid, image_name, image_url, upload_time, delete_staues)
values ('e4e4e4f152639791015263983ba50006', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f15263979101526398b80b0007', 'Penguins.jpg', 'group1/M00/00/00/wKgDzVaQ9O2AQiNgAAvea_OGt2M499.jpg', '20160121175107', '1');
commit;
prompt 34 records loaded
prompt Loading T_ZL_SKIN...
prompt Table is empty
prompt Loading T_ZL_SUGGEST...
prompt Table is empty
prompt Loading T_ZL_USER_PERSON...
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f65277ce29015277d96bc00002', 'TEST04', '2497a7d9315fe5cf35214f7054837df0', '测试用户4', '李四', '上海市', '静安区', '1', null, null, null, null, '1129203271@qq.com', '15256273821', '1212121212', null, '20160125161443', '20160125161443', '20160202140050', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f15262270c0152622922280001', 'TEST02', '2497a7d9315fe5cf35214f7054837df0', '测试用户2', '张三', '安徽', '亳州', '1', null, null, null, null, '123456789@qq.com', '13889201021', '932021892', null, '20160121111008', '20160121111008', '20160225112117', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f65277ce29015277db17440003', 'TEST05', '2497a7d9315fe5cf35214f7054837df0', '测试用户5', '娜娜', '杭州市', '西湖区', '0', null, null, null, null, 'xiongwu3721@foxmail.com', '13889201022', '18392839281', null, '20160125161633', '20160125161633', '20160125170649', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4e8528bce0901528bd573b40001', 'hanhan', 'ec4cee7e3c76efb9dc34c604955b67c1', '嘢丫头', '韩超玲', '安徽', '阜阳', '1', null, null, null, null, '393161079@qq.com', '18365386267', '393161079', null, '20160129132247', '20160129132247', '20160129133046', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('40281d8151a85cd20151a85f2dd80001', 'TEST01', '2497a7d9315fe5cf35214f7054837df0', '易先生3729', 'TEST01', '安徽', '亳州', '0', null, null, null, null, '987654321@qq.com', '15256273820', '1129203271', '美好的生活需要自己去努力创造！', '20151216091948', '20160225165600', '20160225175803', '1', null, '1', 'group1/M00/00/01/wKgDzVa-_hqATfjbAAA3BGyDp8g401.jpg');
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f65277ce29015277d662c60001', 'TEST03', '2497a7d9315fe5cf35214f7054837df0', '测试用户3', '王五', '北京市', '大兴区', '0', null, null, null, null, '123456789@foxmail.com', '13889910313', '1129203271', null, '20160125161124', '20160125161124', '20160128152303', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4ed5291ba53015291c731e10001', 'lqp826', '2497a7d9315fe5cf35214f7054837df0', '微蓝', '微蓝', '安徽', '芜湖', '1', null, null, null, null, '1257855441@qq.com', '18356987587', '123456', null, '20160130170456', '20160130170456', '20160130170522', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f5528784b6015287bae5cf0004', 'HX861325502', 'ab16713c97827c0fbeb83ea388bad79b', 'Mango', '杭潇', '安徽省', '合肥市', '1', null, null, null, null, '861325502@qq.com', '15755185886', '861325502', null, '20160128181518', '20160128181518', '20160223170607', '1', null, '1', null);
insert into T_ZL_USER_PERSON (objectid, login_name, password, nick_name, real_name, szd_province, szd_city, gender, xqx, gqzk, birthday, blood_type, email, mobile_phone, qq, gxqm, registered_time, update_time, last_login_time, is_lock, djzd, user_type, head_portrait)
values ('e4e4e4f5528784b6015287b9d0190003', 'jeremy', '96c23fb94211fedb0eb1b58ace3bdd92', '杰瑞明', '盛锦荣', '安徽', '芜湖', '0', null, null, null, null, 'ds2sjr@126.com', '18325350168', '1643186118', null, '20160128181407', '20160128181407', null, '1', null, '1', null);
commit;
prompt 9 records loaded
prompt Loading T_ZL_USER_RELATION...
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ee528af4b801528af95da10003', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f5528784b6015287bae5cf0004', null, '20160129092224');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ee528af4b801528af6beb00001', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f65277ce29015277d96bc00002', null, '20160129091932');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ed5291ba53015291d00a0c000b', 'e4e4e4ed5291ba53015291c731e10001', '40281d8151a85cd20151a85f2dd80001', null, '20160130171436');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ed5291ba53015291d0b5fb000c', 'e4e4e4ed5291ba53015291c731e10001', 'e4e4e4f5528784b6015287b9d0190003', null, '20160130171520');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ed5291ba53015291d0d324000d', 'e4e4e4ed5291ba53015291c731e10001', 'e4e4e4f15262270c0152622922280001', null, '20160130171527');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4ed5291ba53015291d151b4000e', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4ed5291ba53015291c731e10001', null, '20160130171600');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4e8528bce0901528bda62020002', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4e8528bce0901528bd573b40001', null, '20160129132810');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('e4e4e4e8528bce0901528bdd720a0004', 'e4e4e4e8528bce0901528bd573b40001', '40281d8151a85cd20151a85f2dd80001', null, '20160129133131');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('4028835d52e7ae610152e842ff670008', '40281d8151a85cd20151a85f2dd80001', 'e4e4e4f5528784b6015287b9d0190003', null, '20160216120730');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('4028835d53165c1e0153167236bb000a', 'e4e4e4f15262270c0152622922280001', '40281d8151a85cd20151a85f2dd80001', null, '20160225112137');
insert into T_ZL_USER_RELATION (objectid, promoter, recipient, status, attention_time)
values ('4028835d53165c1e01531672417d000b', 'e4e4e4f15262270c0152622922280001', 'e4e4e4ed5291ba53015291c731e10001', null, '20160225112139');
commit;
prompt 11 records loaded
prompt Loading T_ZL_ZD...
insert into T_ZL_ZD (dm, mc, jc, sm, pyjp, lxjp, sourceid, yxx, px, sjdm, imageurl)
values ('0', '男', '男', null, null, 'XB', null, '1', 0, null, null);
insert into T_ZL_ZD (dm, mc, jc, sm, pyjp, lxjp, sourceid, yxx, px, sjdm, imageurl)
values ('1', '女', '女', null, null, 'XB', null, '1', 1, null, null);
commit;
prompt 2 records loaded
prompt Enabling triggers for T_ZL_BLOG...
alter table T_ZL_BLOG enable all triggers;
prompt Enabling triggers for T_ZL_BLOG_OPERATE...
alter table T_ZL_BLOG_OPERATE enable all triggers;
prompt Enabling triggers for T_ZL_COMMENT...
alter table T_ZL_COMMENT enable all triggers;
prompt Enabling triggers for T_ZL_IMAGE...
alter table T_ZL_IMAGE enable all triggers;
prompt Enabling triggers for T_ZL_SKIN...
alter table T_ZL_SKIN enable all triggers;
prompt Enabling triggers for T_ZL_SUGGEST...
alter table T_ZL_SUGGEST enable all triggers;
prompt Enabling triggers for T_ZL_USER_PERSON...
alter table T_ZL_USER_PERSON enable all triggers;
prompt Enabling triggers for T_ZL_USER_RELATION...
alter table T_ZL_USER_RELATION enable all triggers;
prompt Enabling triggers for T_ZL_ZD...
alter table T_ZL_ZD enable all triggers;
set feedback on
set define on
prompt Done.
