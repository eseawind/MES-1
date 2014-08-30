/**
 * 
 */

//初始化工序管理界面
function initprocedure(TabPanel,FuncNodeId)
{
	var procedurelist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载用户列表界面
	var proceduredialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载用户详细信息对话框
	TabPanel.html(proceduredialog);
	TabPanel.html(procedurelist);
	
	proceduredialog.dialog({
	    title: '工序信息',
		width: 500,
		top:100,
		height: 500,
		closed: true,
		cache: false,
		content: '<div class="easyui-panel" width="100%">'+
			     '<form id="fm_fc_procedure" method="post">' +
		         '<input name="procedure_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>工序名称：</label><input name="procedure_accont" class="easyui-textbox" required="true">' +		
		         '<label>　工序编码：</label><input name="procedure_name" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>工序类型：</label><input name="procedure_password" type="password" class="easyui-textbox">' + 
		         '<label>　工序设备：</label><input name="procedure_role" class="easyui-textbox" required="true"></div>' +
		         '</form><div class="easyui-panel" width=100%>' + 
		         '<div><table id="dg2_fc_procedure" width="100%"></table></div>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_procedure').form('submit',{
					url:'saveProcedure.do',
					onSubmit:function(){$('#dg2_fc_procedure').treegrid('endEdit');
						alert(JSON.stringify($('#dg2_fc_procedure').treegrid('getRoots')));},
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_procedure').form('clear');
						proceduredialog.dialog('close');
                	    procedurelist.datagrid('reload');   
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
	
	$('#dg2_fc_procedure').datagrid({
		    title:"工序信息明细",
		    toolbar:
		    	[{text:'添加',
				iconCls:'icon-add',
				handler:function(){
					 alert($('#dg2_fc_proceduce').datagrid('getSelected'));
					 $('#dg2_fc_procedure').datagrid('appendRow',{});
					 var editIndex = $('#dg2_fc_procedure').datagrid('getRows').length-1;
					 //alert(editIndex);
					 $('#dg2_fc_procedure').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
				}}],
			columns:[[
		              {field:'procedure_id',checkbox:true}, 
				      {field:'procedure_name',title:'工序明细名称',editor:'text',width:80},
				      {field:'procedure_code',title:'工序明细编码',editor:'text',width:80},
				      {field:'procedure_valuetype',title:'工序明细值类型',width:80,
				    	  formatter:function(value,row){return row.typename;},
						  editor:{
							      type:'combobox',
							      options:{
							      valueField:'typeid',
							      textField:'typename',
							      data:[{typeid:'1',typename:'字符型'},{typeid:'2',typename:'整型'},{typeid:'3',typename:'实数型'}],
							      required:true
						      }}
				    	  },
				 ]]			
	});

	procedurelist.datagrid({
	     url:'listProcedure.do',
		 loadMsg:'正在加载用户信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'procedure_id',checkbox:true}, 
		      {field:'procedure_accont',title:'用户账号',width:100},
		      {field:'procedure_name',title:'用户名称',width:100},
		      {field:'procedure_state',title:'用户状态',width:100,align:'center'}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    proceduredialog.dialog('open').dialog('setTitle','新建工序');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = procedurelist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_procedure').form('load','loadProcedure.do?id=' + rows[0].procedure_id);
					    proceduredialog.dialog('open').dialog('setTitle','修改用户');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = procedurelist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].procedure_id);
				       $.post('delProcedure.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    procedurelist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
}