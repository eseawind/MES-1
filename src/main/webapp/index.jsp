<%@ page contentType = "text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>上海海隆复合钢管制造有限公司MES系统</title>
   <link rel="stylesheet" type="text/css" href="js/lib/themes/default/easyui.css">
   <link rel="stylesheet" type="text/css" href="js/lib/themes/icon.css">
   <script type="text/javascript" src="js/lib/jquery.min.js"></script>
   <script type="text/javascript" src="js/lib/jquery.easyui.min.js"></script>
   <script type="text/javascript" src="js/lib/easyui-lang-zh_CN.js"></script>
</head>
<body>
         <div id="loginpanel" class="easyui-panel" title="系统登录" style="width:400px;height:200px;padding:10px;"
                data-options="collapsible:true">           
           <form id="loginform" method="post" action="loginUser.do">   
             <div style="text-align:center;padding:5px">   
                   <label>用户名:</label>   
                   <input class="easyui-validatebox" type="text" name="user_accont" data-options="required:true" />   
            </div>   
            <div style="text-align:center;padding:5px">   
                   <label>密　码:</label>   
                   <input class="easyui-validatebox" type="password" name="user_password" data-options="required:true" />   
            </div>                 
           <div style="text-align:center;padding:5px">
                   <input type="submit" value="登录">
                   <input type="reset" value="重置">
           </div> 
           </form>       
        </div>
        
        <script type="text/javascript">
         $(function(){
               $('#loginform').form({
            	   success:function(data){    
                   	 var rs = eval('(' + data + ')');
                     if (rs.success)   
                        window.location = rs.message;             	 
                     else
                    	$.messager.alert('Info', rs.message, 'info');
                   }
               });
         });
         </script>
</body>
</html>
