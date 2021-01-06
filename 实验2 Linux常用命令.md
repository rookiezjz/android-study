# ***\*实验\*******\*2\**** ***\*Linux常用命令\****

***\*【实验目的】\****

**1.** ***\*掌握Linux系统命令\*******\*基本\*******\*格式\**** 

**2.** ***\*掌握Linux系统中常用命令的\*******\*使用\****

**3.** ***\*熟悉Linux操作\*******\*系统\****

 

***\*【实验内容】\****

**1.** ***\*文件、目录操作\*******\*基本\*******\*命令\****

**2.** ***\*文件处理命令\****

**3.** ***\*压缩备份\*******\*基本\*******\*命令\****

**4.** ***\*其他常用命令\****

 

***\*【实验步骤】\****

\1. 启动计算机，利用root用户登录系统，进入字符提示界面

![image-20210106085403036](/home/zjz/.config/Typora/typora-user-images/image-20210106085403036.png)

\2. 用pwd命令查看当前所在的目录

![image-20210106085417770](/home/zjz/.config/Typora/typora-user-images/image-20210106085417770.png)

\3. 用ls命令列出此目录下的文件和目录

![image-20210106085429388](/home/zjz/.config/Typora/typora-user-images/image-20210106085429388.png)

\4. 用-a选项列出此目录下包括隐藏文件在内的所有文件和目录

![image-20210106085443740](/home/zjz/.config/Typora/typora-user-images/image-20210106085443740.png)

\5. 用man命令查看ls命令的使用手册

![image-20210106085456620](/home/zjz/.config/Typora/typora-user-images/image-20210106085456620.png)

\6. 在当前目录下，创建目录lesson

![image-20210106085931191](/home/zjz/.config/Typora/typora-user-images/image-20210106085931191.png) 

\7. 利用ls命令列出文件和目录，确认lesson目录创建成功

![image-20210106085938775](/home/zjz/.config/Typora/typora-user-images/image-20210106085938775.png) 

\8. 进入lesson目录，查看当前目录

![image-20210106085954711](/home/zjz/.config/Typora/typora-user-images/image-20210106085954711.png) 

\9. 利用touch命令，在当前目录创建一个新的空文件abc

![image-20210106090008361](/home/zjz/.config/Typora/typora-user-images/image-20210106090008361.png) 

\10. 利用cp命令复制系统文件/etc/fstab到当前目录下

![image-20210106090301454](/home/zjz/.config/Typora/typora-user-images/image-20210106090301454.png) 

\11. 复制文件fstab到一个新文件fstab.bak，作为备份

![image-20210106090325018](/home/zjz/.config/Typora/typora-user-images/image-20210106090325018.png) 

\12. 列出当前目录下的所有文件的详细信息，注意比较每个文件的长度和创建时间的不同

![image-20210106090446849](/home/zjz/.config/Typora/typora-user-images/image-20210106090446849.png) 

\13. 用less命令分屏查看文件fstab的内容，注意练习该命令的各个子命令，例如b,p,q等并对ext3关键词查找

![image-20210106090627375](/home/zjz/.config/Typora/typora-user-images/image-20210106090627375.png) 

![image-20210106091119462](/home/zjz/.config/Typora/typora-user-images/image-20210106091119462.png) 

\14. 用grep命令在文件中对关键字ext4进行查询，并与上面的结果作比较

![image-20210106091921171](/home/zjz/.config/Typora/typora-user-images/image-20210106091921171.png) 

\15. 用ln命令给文件fstab创建一个软链接fstab.lns和一个硬链接fstab.lnh

![image-20210106092338090](/home/zjz/.config/Typora/typora-user-images/image-20210106092338090.png) 

\16. 用ls -l显示文件fstab及其链接的详细信息

![image-20210106092426527](/home/zjz/.config/Typora/typora-user-images/image-20210106092426527.png) 

\17. 用mv命令删除用户主目录下的fstab，显示文件fstab.lns与fstab.lnh的详细信息，比较文件fstab.lnh的链接数的变化

![image-20210106092734014](/home/zjz/.config/Typora/typora-user-images/image-20210106092734014.png) 

\18. 用cat命令查看文件fstab.lnh的内容，看有什么结果

![image-20210106092757873](/home/zjz/.config/Typora/typora-user-images/image-20210106092757873.png) 

\19. 用cat命令查看文件fstab.lns的内容，看有什么结果

![image-20210106092812555](/home/zjz/.config/Typora/typora-user-images/image-20210106092812555.png) 

\20. 用mv命令删除以f开头且文件名中包含ln的所有文件，显示当前目录下的文件列表，回到上层目录

![image-20210106094215618](/home/zjz/.config/Typora/typora-user-images/image-20210106094215618.png) 

\21. 用tar命令把目录lesson打包

![image-20210106094731194](/home/zjz/.config/Typora/typora-user-images/image-20210106094731194.png) 

\22. 用gzip命令对打好的包进行压缩操作

![image-20210106094804969](/home/zjz/.config/Typora/typora-user-images/image-20210106094804969.png) 

\23. 把文件lesson.tar.gz改名为back.tar.gz

![image-20210106094839930](/home/zjz/.config/Typora/typora-user-images/image-20210106094839930.png) 

\24. 显示当前目录下的文件和目录列表，确认重命名成功

![image-20210106094848565](/home/zjz/.config/Typora/typora-user-images/image-20210106094848565.png) 

\25. 把文件backup.tar.gz移动到lesson目录下

![image-20210106094906191](/home/zjz/.config/Typora/typora-user-images/image-20210106094906191.png) 

\26. 显示当前目录下的文件和目录列表，确认移动成功

![image-20210106094940510](/home/zjz/.config/Typora/typora-user-images/image-20210106094940510.png) 

\27. 进入lesson目录，显示目录中的文件列表

![image-20210106094949757](/home/zjz/.config/Typora/typora-user-images/image-20210106094949757.png) 

\28. 把文件backup.tar.gz解包

![image-20210106100227830](/home/zjz/.config/Typora/typora-user-images/image-20210106100227830.png) 

\29. 显示当前目录下的文件和目录列表，复制lesson目录为lessonbak目录作为备份

![image-20210106100302930](/home/zjz/.config/Typora/typora-user-images/image-20210106100302930.png) 

\30. 查找root用户自己的主目录下的所有名为abc的文件

![image-20210106100334631](/home/zjz/.config/Typora/typora-user-images/image-20210106100334631.png) 

\31. 删除lesson子目录下的所有文件

![image-20210106100440342](/home/zjz/.config/Typora/typora-user-images/image-20210106100440342.png) 

\32. 利用rmdir命令删除空子目录lesson

![image-20210106100453262](/home/zjz/.config/Typora/typora-user-images/image-20210106100453262.png) 

\33. 回到上层目录，利用rm命令删除目录lesson及其下所有文件

 ![image-20210106100507160](/home/zjz/.config/Typora/typora-user-images/image-20210106100507160.png) 

 

 

***\*【实验\*******\*小结\*******\*】\****

 