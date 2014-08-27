<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <title>上海海隆复合钢管制造有限公司MES管理系统</title>
    <link rel="stylesheet" type="text/css" href="../js/lib/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/lib/themes/icon.css">
    <script type="text/javascript" src="../js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="../js/lib/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/system/basedata.js"></script>
    <script type="text/javascript" src="../js/system/system.js"></script>
    <script type="text/javascript" src="../js/system/mesmain.js"></script>
</head>
<body class="easyui-layout">
        <div data-options="region:'north'" style="height:100px"></div>
        <div data-options="region:'west',split:true" title="功能列表" style="width:200px;">
            <div class="easyui-accordion" data-options="fit:true,border:false">
                <div title="基础数据管理" style="padding:10px;">
                    content1
                </div>
                <div title="生产计划管理" style="padding:10px;">
                    content1
                </div>
                 <div title="工艺管理" style="padding:10px;">
                    content1
                </div>
                <div title="生产管理" style="padding:10px;">
                    content2
                </div>
                <div title="统计报表" style="padding:10px;">
                    content2
                </div>
                <div title="系统管理" style="padding:5px">
                        <ul id="fcnode" class="easyui-tree">
                     
                        </ul>                           
                </div>
            </div>
        </div>
        <div data-options="region:'center'">
            <div id="mainwin" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                <div title="概览" style="padding:10px"></div>
            </div>
        </div>
        <script type="text/javascript">
        $('#fcnode').tree({
		       data: [{
     	                id:'fc_base',
     			        text: '基础数据管理',
     			        state: 'closed',
     			        children: [{
     	                              id:'fc_equipment',
     				                  text: '设备信息管理'
     			                   },{
     				                  id: 'fc_material',
     	                              text: '物料信息管理'
     			                   },{
     	                              id: 'fc_product',
     	                              text: '产品信息管理'
     	                           },{
     	                              id: 'fc_pipe',
     	                              text: '钢管信息管理'
     	                           }]
		                },{
	                         id:'fc_orderplan',
			                 text: '订单及计划管理',
			                 state: 'closed',
			                 children: [{
	                                      id:'fc_order',
				                          text: '用户订单管理'
			                            },{
				                          id: 'fc_plan',
	                                      text: '生产计划管理'
			                            }]
		                },{
	                         id:'fc_promag',
			                 text: '工艺管理',
			                 state: 'closed',
			                 children: [{
	                                      id:'fc_procedure',
				                          text: '工序信息管理'
			                            },{
				                          id: 'fc_process',
	                                      text: '工艺信息管理'
			                            },{
	                                      id: 'fc_checkpro',
	                                      text: '工艺信息审批'
	                                   }]
		                },{
	                         id:'fc_production',
			                 text: '生产管理',
			                 state: 'closed',
			                 children: [{
	                                      id:'fc_task',
				                          text: '生产任务管理'
			                            },{
				                          id: 'fc_taskchenge',
	                                      text: '生产任务变更'
			                            },{
	                                      id: 'fc_taskgo',
	                                      text: '生产任务执行'
	                                    },{
	                                      id: 'fc_taskquery',
	                                      text: '生产任务跟踪'
	                                   }]
		                },{
	                         id:'fc_system',
			                 text: '系统管理',
			                 state: 'closed',
			                 children: [{
	                                      id:'fc_user',
				                          text: '用户管理'
			                            },{
				                          id: 'fc_role',
	                                      text: '角色管理'
			                            },{
	                                      id: 'fc_department',
	                                      text: '部门管理'
	                                    },{
	                                      id: 'fc_log',
	                                      text: '日志管理'
	                                    }]
		                 }]
	});
        </script>
</body>
</html>