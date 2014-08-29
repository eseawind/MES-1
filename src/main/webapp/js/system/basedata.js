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
}

//初始化钢管类型
function initpipetype(TabPanel,FuncNodeId)
{
	var pipetypelist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载钢管类型界面
	var pipetypedialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载钢管信息对话框
	TabPanel.html(pipetypedialog);
	TabPanel.html(pipetypelist);
	
	pipetypedialog.dialog({
	    title: '钢管类型信息',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_pipetype" method="post">' +
		         '<input name="pipetype_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>钢管名称：</label><input name="pipetype_name" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>执行标准：</label><input name="pipetype_spec" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>钢管钢级：</label><input name="pipetype_steelgrade" class="easyui-textbox" required="true"></div>' + 
		         '<div style="text-align:center;padding:5px"><label>钢管类型：</label><input name="pipetype_type" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>供货厂商：</label><input name="pipetype_supplier" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_pipetype').form('submit',{
					url:'savePipeType.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_pipetype').form('clear');
						pipetypedialog.dialog('close');
                	    pipetypelist.datagrid('reload');   
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

	pipetypelist.datagrid({
	     url:'listPipeType.do',
		 loadMsg:'正在加载钢管类型信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'pipetype_id',checkbox:true}, 
		      {field:'pipetype_name',title:'钢管名称',width:100},
		      {field:'pipetype_spec',title:'执行标准',width:100},
		      {field:'pipetype_steelgrade',title:'钢管钢级',width:100},
		      {field:'pipetype_type',title:'钢管类型',width:100},
		      {field:'pipetype_supplier',title:'供货厂商',width:100}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    pipetypedialog.dialog('open').dialog('setTitle','新建钢管类型');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = pipetypelist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_pipetype').form('load','loadPipeType.do?id=' + rows[0].pipetype_id);
					    pipetypedialog.dialog('open').dialog('setTitle','修改钢管类型');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = pipetypelist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].pipetype_id);
				       $.post('delPipeType.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    pipetypelist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
	

	}
//初始化产品管理界面
function initproduct(TabPanel,FuncNodeId)
{
	var productlist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载用户列表界面
	var productdialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载用户详细信息对话框
	TabPanel.html(productdialog);
	TabPanel.html(productlist);
	
	productdialog.dialog({
	    title: '产品信息',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_product" method="post">' +
		         '<input name="product_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>产品名称：</label><input name="product_name" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>产品编码：</label><input name="product_code" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>执行标准：</label><input name="product_spec" type="password" class="easyui-textbox"></div>' + 
		         '<div style="text-align:center;padding:5px"><label>产品钢级：</label><input name="product_steelgrade" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_product').form('submit',{
					url:'saveProduct.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_product').form('clear');
						productdialog.dialog('close');
                	    productlist.datagrid('reload');   
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

	productlist.datagrid({
	     url:'listProduct.do',
		 loadMsg:'正在加载产品类型信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'product_id',checkbox:true}, 
		      {field:'product_name',title:'产品类型名称',width:100},
		      {field:'product_code',title:'产品类型编码',width:100},
		      {field:'product_spec',title:'执行标准',width:100},
		      {field:'product_steelgrade',title:'产品钢级',width:100}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    productdialog.dialog('open').dialog('setTitle','新建产品类型');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = productlist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_product').form('load','loadProduct.do?id=' + rows[0].product_id);
					    productdialog.dialog('open').dialog('setTitle','修改产品类型');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = productlist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].product_id);
				       $.post('delProduct.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    productlist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
}
