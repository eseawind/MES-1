/**
 * 
 */

//初始化工序管理界面
function initprocedure(TabPanel,FuncNodeId)
{
	var procedurelist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载工序列表界面
	var proceduredialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载工序详细信息对话框
	var editIndex = undefined; 
	var ifrepeat = false;
	TabPanel.html(proceduredialog);
	TabPanel.html(procedurelist);
	var itemlist = new Array();	
	proceduredialog.dialog({
	    title: '工序信息',
		width: 500,
		top:100,
		height: 500,
		closed: true,
		cache: false,
		content: '<div class="easyui-panel" width="100%">'+
			     '<form id="fm_fc_procedure" method="post">' +
		         '<input id="procedure_identify" name="procedure_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>工序名称：</label><input name="procedure_name" class="easyui-textbox" required="true">' +		
		         '<label>　工序编码：</label><input name="procedure_code" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>工序类型：</label><input name="procedure_type" class="easyui-textbox" required="true">' + 
		         '<label>　工序设备：</label><input name="procedure_equipment" class="easyui-textbox" required="true"></div>' +
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
	    		if(ifrepeat)
	    		{
	    			 dg2.datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
	    			 return;
	    		}	   
				editIndex = undefined;
				$('#fm_fc_procedure').form('submit',{
					url:'saveProcedure.do',
					onSubmit:function(param){
						param.procedure_itemlist = JSON.stringify(dg2.datagrid('getRows'));
						},
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						proceduredialog.dialog('close');
						$('#fm_fc_procedure').form('clear');
						dg2.datagrid('loadData',{total:0,rows:[]});					
                	    procedurelist.datagrid('reload');   
				    }    
				})
			}
		    },{
			text:'清空',
			width:90,
			handler:function(){
				$("#fm_fc_procedure").form('clear');
				dg2.datagrid('loadData',{total:0,rows:[]});
			}
		}],
	onClose:function()
	{
		dg2.datagrid('loadData',{total:0,rows:[]});					
		$('#fm_fc_procedure').form('clear'); 
	}
	});
	
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
						 if(ifrepeat)
					     {
							    dg2.datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex); 
							    return;
						 }
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
		              {field:'procedureitem_id',checkbox:true}, 
				      {field:'procedureitem_name',title:'工序明细名称',width:100,editor:{type:'validatebox',options:{required:true}}},
				      {field:'procedureitem_code',title:'工序明细编码',width:100,editor:{type:'validatebox',options:{required:true}}},
				      {field:'procedureitem_valuetype',title:'工序明细值类型',width:100,
				    	  formatter:function(value,row){
				    		 if(row.procedureitem_valuetype==1)
				    			 return '字符型';
				    		 if(row.procedureitem_valuetype==2)
				    			 return '整数型';
				    		 if(row.procedureitem_valuetype==3)
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
	    		   if(ifrepeat)
	    		   {
	    			   dg2.datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
	    			   return;
	    		   }	    			   
	    		   dg2.datagrid('selectRow', index).datagrid('beginEdit', index);
	    		   editIndex = index;
	    	   }	 
	       },
	       onEndEdit:function(rowIndex,rowData,changes)
	       {
	          var rows = dg2.datagrid('getRows');
	          for(var i=0;i<rows.length;i++)
	          {
	        	  if(i==rowIndex)
	        		  continue;
	        	  if(rowData.procedureitem_name==rows[i].procedureitem_name||
	        			  rowData.procedureitem_code==rows[i].procedureitem_code)
	        	  {
	        		  $.messager.alert('错误','工序明细编码和工序明细标识不能重复，请修改！','错误');
	        	  	  ifrepeat = true;
	        	  	  return;
	        	  } 
	          }
	          ifrepeat = false;
	       }
	});

	procedurelist.datagrid({
	     url:'listProcedure.do',
	     height:$(window).height()-130,
		 loadMsg:'正在加载工序信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'procedure_id',checkbox:true}, 
		      {field:'procedure_name',title:'工序名称',width:100},
		      {field:'procedure_code',title:'工序编码',width:100},
		      {field:'procedure_type',title:'工序类型',width:100},
		      {field:'procedure_equipment',title:'工序设备',width:100},
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
					    	  $.messager.alert('警告','请选择一条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_procedure').form('load','loadProcedure.do?id=' + rows[0].procedure_id);
					    dg2.datagrid({ url:'loadProcedureItem.do',queryParams:{id:rows[0].procedure_id},method:"post"});
					    proceduredialog.dialog('open').dialog('setTitle','修改工序');
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