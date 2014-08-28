/**
 * 
 */

//初始化用户管理界面
function initequipment(TabPanel,FuncNodeId)
{
	var equipmentlist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载用户列表界面
	var equipmentdialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载用户详细信息对话框
	TabPanel.html(equipmentdialog);
	TabPanel.html(equipmentlist);
	
	equipmentdialog.dialog({
	    title: '设备信息',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_equipment" method="post">' +
		         '<input name="equipment_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>设备名称：</label><input name="equipment_name" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>设备编号：</label><input name="equipment_code" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>设备类型：</label><input name="equipment_type" class="easyui-textbox" required="true"></div>' + 
		         '<div style="text-align:center;padding:5px"><label>生产厂商：</label><input name="equipment_manufacturer" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>设备状态：</label><input name="equipment_state" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_equipment').form('submit',{
					url:'saveEquipment.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_equipment').form('clear');
						equipmentdialog.dialog('close');
                	    equipmentlist.datagrid('reload');   
				    }    
				}
				)
			}
		},{
			text:'清空',
			width:90,
			handler:function(){
				$('#fm_fc_equipment').form('clear');
			}
		}]
	});

	equipmentlist.datagrid({
	     url:'listEquipment.do',
		 loadMsg:'正在加载设备信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'equipment_id',checkbox:true}, 
		      {field:'equipment_name',title:'设备名称',width:100},
		      {field:'equipment_code',title:'设备编号',width:100},
		      {field:'equipment_type',title:'设备类型',width:100},
		      {field:'equipment_manufacturer',title:'生产厂商',width:100},
		      {field:'equipment_state',title:'用户状态',width:100,align:'center'}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    equipmentdialog.dialog('open').dialog('setTitle','新建设备');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = equipmentlist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_equipment').form('load','loadEquipment.do?id=' + rows[0].equipment_id);
					    equipmentdialog.dialog('open').dialog('setTitle','修改设备');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = equipmentlist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].equipment_id);
				       $.post('delEquipment.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    equipmentlist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
   var equipmentpage = equipmentlist.datagrid('getPager');
   $(equipmentpage).pagination({ 
       beforePageText: '第',
       afterPageText: '页    共 {pages} 页', 
       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
   });  
}

function initmaterial(TabPanel,FuncNodeId)
{
	var materiallist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载用户列表界面
	var materialdialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载用户详细信息对话框
	TabPanel.html(materialdialog);
	TabPanel.html(materiallist);
	
	materialdialog.dialog({
	    title: '物料信息',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_material" method="post">' +
		         '<input name="material_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>物料名称：</label><input name="material_name" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>物料编码：</label><input name="material_code" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>物料规格：</label><input name="material_spec" type="password" class="easyui-textbox"></div>' + 
		         '<div style="text-align:center;padding:5px"><label>生产厂商：</label><input name="material_manufacturer" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>物料数量：</label><input name="material_quantity" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_material').form('submit',{
					url:'saveMaterial.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_material').form('clear');
						materialdialog.dialog('close');
                	    materiallist.datagrid('reload');   
				    }    
				}
				)
			}
		},{
			text:'清空',
			width:90,
			handler:function(){}
		}]
	});

	materiallist.datagrid({
	     url:'listMaterial.do',
		 loadMsg:'正在加载用户信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'material_id',checkbox:true}, 
		      {field:'material_name',title:'物料名称',width:100},
		      {field:'material_code',title:'物料编码',width:100},
		      {field:'material_spec',title:'物料规格',width:100},
		      {field:'material_manufacturer',title:'生产厂商',width:100},
		      {field:'material_quantity',title:'物料数量',width:100}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    materialdialog.dialog('open').dialog('setTitle','新建物料');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = materiallist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_material').form('load','loadMaterial.do?id=' + rows[0].material_id);
					    materialdialog.dialog('open').dialog('setTitle','修改物料');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = materiallist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].material_id);
				       $.post('delMaterial.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    materiallist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
   var userpage = materiallist.datagrid('getPager');
   $(userpage).pagination({ 
       beforePageText: '第',//页数文本框前显示的汉字 
       afterPageText: '页    共 {pages} 页', 
       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
   });  
}
