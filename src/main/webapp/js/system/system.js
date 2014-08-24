/**
 * 
 */

$(document).ready(function(){	
	//点击左边功能树节点右边显示界面
	$('#fcnode').tree({
    	onClick: function(node){
    		//如果功能界面没加载过，创建新功能界面并显示，如果已加载过，直接调用已加载的界面
    		if($('#mainwin').tabs("getTab",node.text)!=null)
    		{
    			$('#mainwin').tabs("select",node.text);
    		}
    		else{
        		$('#mainwin').tabs('add',{
        			 title: node.text,        			 
        			 closable: true
        		});
        		//将功能界面绑定当前显示的tab
        		var funcdgId = 'dg_' + node.id;
        		var funcdlId = 'dl_' + node.id;
        		var currentTabPanel = $("#mainwin").tabs('getSelected');
        	    var dynamicTable = $('<table id="'+ funcdgId +'"></table>');
        	    currentTabPanel.html(dynamicTable);
        	    initfunc(dynamicTable,funcdgId);
    		}
    	}
    });
    


});