<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <title>上海海隆复合钢管制造有限公司MES管理系统</title>
    <link rel="stylesheet" type="text/css" href="../js/lib/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/lib/themes/icon.css">
    <script type="text/javascript" src="../js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="../js/lib/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/lib/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/system/basedata.js"></script>
    <script type="text/javascript" src="../js/system/system.js"></script>
    <script type="text/javascript" src="../js/system/process.js"></script>
    <script type="text/javascript" src="../js/system/mesmain.js"></script>
</head>
<body class="easyui-layout">
        <div data-options="region:'north'" style="height:100px"></div>
        <div data-options="region:'west',split:true" title="功能列表" style="width:200px;">
            <div class="easyui-accordion" data-options="fit:true,border:false">
                <div title="基础数据管理" style="padding:5px;">
                    <ul id="t_base" class="easyui-tree"></ul>
                </div>
                <div title="生产计划管理" style="padding:5px;">
                   <ul id="t_orderplan" class="easyui-tree"></ul>
                </div>
                 <div title="工艺管理" style="padding:5px;">
                   <ul id="t_process" class="easyui-tree"></ul>
                </div>
                <div title="生产管理" style="padding:5px;">
                    <ul id="t_product" class="easyui-tree"></ul>
                </div>
                <div title="统计报表" style="padding:5px;">
                   <ul id="t_state" class="easyui-tree"></ul>
                </div>
                <div title="系统管理" style="padding:5px">
                        <ul id="t_system" class="easyui-tree"></ul>                           
                </div>
            </div>
        </div>
        <div data-options="region:'center'">
            <div id="mainwin" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                <div title="概览" style="padding:10px"></div>
            </div>
        </div>
</body>
</html>