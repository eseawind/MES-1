/**
 * 
 */

//初始化设备管理界面
function initcheckbasepipe(TabPanel,FuncNodeId)
{
	var basepipelist = $('<table id="dg_"'+ FuncNodeId +'"></table>'); //加载设备列表界面
	var basepipedialog = $('<div id="dl_"'+ FuncNodeId +'"></div>');   //加载设备详细信息对话框
	TabPanel.html(basepipedialog);
	TabPanel.html(basepipelist);
	
	basepipedialog.dialog({
	    title: '添加基管记录',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_basepipe" method="post">' +
		         '<input name="basepipe_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>基管数量：</label><input name="basepipe_nume" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>基管类型：</label><input name="basepipe_type" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>订单编号：</label><input name="basepipe_order" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>基管状态：</label><input name="basepipe_type" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_basepipe').form('submit',{
					url:'saveBasepipe.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_basepipe').form('clear');
						basepipedialog.dialog('close');
                	    basepipelist.datagrid('reload');   
				    }    
				}
				)
			}
		},{
			text:'清空',
			width:90,
			handler:function(){
				$('#fm_fc_basepipe').form('clear');
			}
		}]
	});

	basepipelist.datagrid({
	     url:'listEquipment.do',
		 loadMsg:'正在加载基管信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'pipe_id',checkbox:true}, 
		      {field:'pipe_num',title:'基管编号',width:100},
		      {field:'pipetype_name',title:'基管类型',width:100},
		      {field:'pipetype_spec',title:'执行标准',width:100},
		      {field:'pipetype_steelgrade',title:'基管钢级',width:100},
		      {field:'pipe_forpro',title:'所属订单',width:100},
		      {field:'pipe_state',title:'基管状态',width:100,align:'center'}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    basepipedialog.dialog('open').dialog('setTitle','新增基管记录');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = basepipelist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_basepipe').form('load','loadEquipment.do?id=' + rows[0].basepipe_id);
					    basepipedialog.dialog('open').dialog('setTitle','修改设备');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = basepipelist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].basepipe_id);
				       $.post('delbasepipe.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    basepipelist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
}