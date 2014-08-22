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
</head>
<body class="easyui-layout">
        <div data-options="region:'north'" style="height:100px"></div>
        <div data-options="region:'west',split:true" title="功能列表" style="width:100px;">
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
                <div title="系统管理" style="padding:10px">
                        <ul id="fcnode" class="easyui-tree">
                            <li>
                               <span>用户管理</span>
                            </li>
                             <li>
                               <span>角色管理</span>
                            </li>
                             <li>
                               <span>权限管理</span>
                            </li>
                             <li>
                               <span>日志管理</span>
                            </li>
                        </ul>                           
                </div>
            </div>
        </div>
        <div data-options="region:'center'">
            <div id="mainwin" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                <div title="概览" data-options="href:'_content.html'" style="padding:10px"></div>
                <div title="DataGrid" style="padding:5px">
                    <table class="easyui-datagrid"
                            data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
                        <thead>
                            <tr>
                                <th data-options="field:'itemid'" width="80">Item ID</th>
                                <th data-options="field:'productid'" width="100">Product ID</th>
                                <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                                <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                                <th data-options="field:'attr1'" width="150">Attribute</th>
                                <th data-options="field:'status',align:'center'" width="50">Status</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        $('#fcnode').tree({
        	onClick: function(node){
        		if($('#mainwin').tabs("getTab",node.text)!=null)
        		{
        			$('#mainwin').tabs("select",node.text);
        		}
        		else{
	        		$('#mainwin').tabs('add',{
	        			 title: node.text,
	        			 content: '<div style="padding:10px">'+ node.text + '</div>',
	        			 closable: true
	        		});
        		}
        	}
        });


        </script>
</body>
</html>