/**
 * 
 */

//根据不同的功能节点标识初始化不同的功能界面
function initfunc(dynamicTable,datagrid)
{
	if(datagrid == 'dg_fc_user')
		inituser(dynamicTable);
	if(datagrid == 'dg_fc_role')
		initrole(dynamicTable);
		
}

//初始化用户管理界面
function inituser(dynamicTable)
{
	dynamicTable.datagrid({
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
function initrole(dynamicTable)
{
	dynamicTable.datagrid({
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
