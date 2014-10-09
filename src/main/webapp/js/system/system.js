/**
 * 系统管理界面及操作
 */

//初始化用户管理界面
function inituser(funcWin)
{
	funcWin.tabs('add',{
		 title: '用户管理',        			 
		 closable: true,
		 content:'<div style="padding:1px">' +
			     '<table id="dg_fc_user"></table>'+
		         '<div id="dl_fc_user"></div>' +
			     '</div>'
	});
	
	var userlist = $('#dg_fc_user'); //加载用户列表界面
	var userdialog = $('#dl_fc_user');   //加载用户详细信息对话框
	
	userdialog.dialog({
	    title: '用户信息',
		width: 300,
		height: 250,
		closed: true,
		cache: false,
		content: '<form id="fm_fc_user" method="post">' +
		         '<input name="user_id" type="hidden" value="">' +
		         '<div style="text-align:center;padding:5px"><label>用户账号：</label><input name="user_accont" class="easyui-textbox" required="true"></div>' +		
		         '<div style="text-align:center;padding:5px"><label>用户名称：</label><input name="user_name" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>用户密码：</label><input name="user_password" type="password" class="easyui-textbox" required="true"></div>' + 
		         '<div style="text-align:center;padding:5px"><label>用户角色：</label><input name="user_role" class="easyui-textbox" required="true"></div>' +
		         '<div style="text-align:center;padding:5px"><label>用户状态：</label><input name="user_state" class="easyui-textbox" required="true"></div>' +
		         '</form>',
		modal: true,
		buttons:[{
			text:'保存',
			width:90,
			handler:function(){				
				$('#fm_fc_user').form('submit',{
					url:'saveUser.do',
					success:function(data){
						var result = eval('(' + data + ')');
						$.messager.show({title: '信息', msg: result.message});
						$('#fm_fc_user').form('clear');
						userdialog.dialog('close');
                	    userlist.datagrid('reload');   
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

	userlist.datagrid({
	     url:'listUser.do',
	     height:$(window).height()-130,
		 loadMsg:'正在加载用户信息，请稍后...',
		 pagination:true,
		 columns:[[
              {field:'user_id',checkbox:true}, 
		      {field:'user_accont',title:'用户账号',width:100},
		      {field:'user_name',title:'用户名称',width:100},
		      {field:'user_state',title:'用户状态',width:100,align:'center', formatter:function(value,row){
		    		 if(row.user_state==true)
		    			 return '启用';
		    		 if(row.user_state==false)
		    			 return '禁用';
		    	  }}
		 ]],
	     toolbar:[{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				    userdialog.dialog('open').dialog('setTitle','新建用户');
				    }
			},'-',{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){			    
					    var rows = userlist.datagrid('getChecked');
					    if(rows.length!=1)
					    {
					    	  $.messager.alert('警告','请选择条记录!','警告');
					    	  return;
					    }		
					    $('#fm_fc_user').form('load','loadUser.do?id=' + rows[0].user_id);
					    userdialog.dialog('open').dialog('setTitle','修改用户');
				     }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){				       
				       var rows = userlist.datagrid('getChecked');
				       var ids = [];
				       if(rows.length==0)
				       {
				    	  $.messager.alert('警告','请先选择要删除的记录！','警告');
				    	  return;
				       }				    	   
				       for(var i=0;i<rows.length;i++)
				    	  ids.push(rows[i].user_id);
				       $.post('delUser.do',{"delids":ids.toString()},function(data){
				    	                                var result = eval('(' + data + ')');
				    	                                if (result.success){
				    	                            	    $.messager.show({title: '信息', msg: result.message});
				    	                            	    userlist.datagrid('reload'); 
				    	                            	}
				    	                                else
				    	                                    $.messager.show({title: '错误',msg: result.message});
			           })
			         }
		     }]
   });
}

//初始化角色管理界面
function initrole(funcWin)
{
	funcWin.tabs('add',{
		 title: '角色管理',        			 
		 closable: true,
		 content:'<div style="padding:1px">' +
			     '<table id="dg_fc_role"></table>'+
		         '<div id="dl_fc_role"></div>' +
			     '</div>'
	});
	
	var rolelist = $('#dg_fc_role');

	rolelist.datagrid({
		 pagination:true,
		 columns:[[
              {field:'role_id',checkbox:true}, 
		      {field:'role_name',title:'角色名称',width:100},
		      {field:'role_code',title:'角色编码',width:100},
		      {field:'role_state',title:'角色状态',width:100,align:'center'}
		 ]],
	     toolbar:[{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){alert('add')}
				},{
				text:'修改',
				iconCls:'icon-edit',
				handler:function(){alert('cut')}
				},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){alert('save')}
				}]
	 });
}
//初始化日志管理界面
function initlog(funcWin)
{
	funcWin.tabs('add',{
		 title: '日志管理',        			 
		 closable: true,
		 content:'<div style="padding:1px">' +
			     '<table id="dg_fc_log"></table>'+
		         '<div id="dl_fc_log"></div>' +
			     '</div>'
	});
	
	var loglist = $('#dg_fc_log');

	loglist.datagrid({
		 pagination:true,
		 columns:[[
              {field:'log_id',checkbox:true}, 
		      {field:'log_per',title:'操作人',width:100},
		      {field:'log_date',title:'操作时间',width:100},
		      {field:'log_content',title:'操作内容',width:100,align:'center'}
		 ]],
	     toolbar:[{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){alert('add')}
				},{
				text:'修改',
				iconCls:'icon-edit',
				handler:function(){alert('cut')}
				},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){alert('save')}
				}]
	 });
}