/**
 * 
 */

//根据不同的功能节点标识初始化不同的功能界面
function initfuncUI(tabPanel,funcNodeId)
{
	if(funcNodeId == 'fc_user')
		inituser(tabPanel,funcNodeId);
	if(funcNodeId == 'fc_role')
		initrole(tabPanel,funcNodeId);
	if(funcNodeId == 'fc_log')
		initlog(tabPanel,funcNodeId);
		
}

//初始化用户管理界面
function inituser(TabPanel,FuncNodeId)
{
	var userlist = $('<table id="dg_"'+ FuncNodeId +'"></table>');
	TabPanel.html(userlist);
	userlist.datagrid({
	     //url:'datagrid_data.json',
		 pagination:true,
		 columns:[[
              {field:'user_id',checkbox:true}, 
		      {field:'user_accont',title:'用户账号',width:100},
		      {field:'user_name',title:'用户名称',width:100},
		      {field:'user_state',title:'用户状态',width:100,align:'center'}
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

//初始化角色管理界面
function initrole(TabPanel,FuncNodeId)
{
	var rolelist = $('<table id="dg_"'+ FuncNodeId +'"></table>');
	TabPanel.html(rolelist);
	rolelist.datagrid({
	     //url:'datagrid_data.json',
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
function initlog(TabPanel,FuncNodeId)
{
	var loglist = $('<table id="dg_"'+ FuncNodeId +'"></table>');
	TabPanel.html(loglist);
	loglist.datagrid({
	     //url:'datagrid_data.json',
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