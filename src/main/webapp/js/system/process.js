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
	var itemlist = new Array();
	var dg2 = $('#dg2_fc_procedure');
	
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
		         '<input name="procedure_itemlist" type="hidden" value="">' +
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
				if (!dg2.datagrid('validateRow', editIndex))
					 return;
				 dg2.datagrid('endEdit',editIndex);	 
				 editIndex = undefined;
				$('#fm_fc_procedure').form('submit',{
					url:'saveProcedure.do',
					onSubmit:function(param){
						param.procedure_itemlist = JSON.stringify(dg2.datagrid('getRows'));
						alert(param.procedure_itemlist);},
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
			handler:function(){
				$("#fm_fc_procedure").form('clear');
			}
		}]
	});
	var editIndex = undefined; 
	var dg2 = $('#dg2_fc_procedure');
	dg2.datagrid({
		    title:"工序信息明细",
		    singleSelect:true,
		    toolbar:
		    	[{text:'添加',
				iconCls:'icon-add',
				handler:function(){
					 if(editIndex !=undefined)
				     {
						 if (!dg2.datagrid('validateRow', editIndex))
							 return;
						 dg2.datagrid('endEdit',editIndex);	 
						 editIndex = undefined;
					 }
					 if(editIndex ==undefined){
						 dg2.datagrid('appendRow',{});
						 editIndex = dg2.datagrid('getRows').length-1;
						 dg2.datagrid('beginEdit', editIndex);
					 }
				}}
		    	],
			columns:[[
		              {field:'procedure_id',checkbox:true}, 
				      {field:'procedure_name',title:'工序明细名称',width:100,editor:{type:'validatebox',options:{required:true}}},
				      {field:'procedure_code',title:'工序明细编码',width:100,editor:{type:'validatebox',options:{required:true}}},
				      {field:'procedure_valuetype',title:'工序明细值类型',width:100,
				    	  formatter:function(value,row){
				    		 if(row.procedure_valuetype==1)
				    			 return '字符型';
				    		 if(row.procedure_valuetype==2)
				    			 return '整数型';
				    		 if(row.procedure_valuetype==3)
				    			 return '实数型';
				    	  },
						  editor:{
							      type:'combobox',
								      options:{
									      valueField:'valuetype',
									      editable:false,
									      textField: 'valuetypename',
									      data:[{valuetype:'1',valuetypename:'字符型'},
									            {valuetype:'2',valuetypename:'整数型'},
									            {valuetype:'3',valuetypename:'实数型'}],
									      required:true
						              }
				    		     }
				    	  },
				 ]],
	       onClickRow:function(index)
	       {
	    	   if (!dg2.datagrid('validateRow', editIndex)||index==editIndex)
	    	   {
	    		   dg2.datagrid('selectRow', editIndex);
	    		   return;
	    	   }	 
	    	   else{
	    		   dg2.datagrid('endEdit',editIndex);
	    		   dg2.datagrid('selectRow', index).datagrid('beginEdit', index);
	    		   editIndex = index;
	    	   }	 
	       },
	       onEndEdit:function(rowIndex,rowData,changes)
	       {
	          var rows = dg2.datagrid('getRows');
	          for(var i=0;i<rows.length;i++)
	          {
	        	  if(i==editIndex)
	        		  continue;
	        	  if(rowData.procedure_name==rows[i].procedure_name ||
	        			  rowData.proceduce_code==rows[i].proceduce_code)
	        	  {
	        		  $.messager.alert('错误','工序明细编码和工序明细标识不能重复，请修改！','错误');
	        	      dg2.datagrid('selectRow', index).datagrid('beginEdit',rowIndex);
	        	  }
	          }
	       }
	});

	procedurelist.datagrid({
	     //url:'listProcedure.do',
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