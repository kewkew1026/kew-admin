<!DOCTYPE html >
<html>
<head>
<#include "/common/resources.ftl"/>
    <link rel="stylesheet" href="${res}/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${res}/assets/css/amazeui.tree.min.css"/>
    <script src="${res}/assets/js/jquery.min.js"></script>
    <script src="${res}/assets/js/amazeui.tree.js"></script>
    <script src="${js}/kew-0.1.js"></script>
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            color:#666;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
    <script type="text/javascript">


        //新建菜单对话框弹出
        function newMenue(){

            var node = $('#myTree').tree('getSelected');
            //非根节点或一级节点下添加菜单 不允许

            //不是一级节点下添加菜单 不允许
            if(node){
                var parent = $('#myTree').tree('getParent', node.target);

                if(parent==null){
                    //是一级节点 允许
                }else{
                    //非根节点也非一级节点  不允许
                    $.messager.show({
                        title: '友情提示',
                        msg: '叶子节点下不能添加节点'
                    });
                    return;
                }
            }

            $('#ccfunid').combobox({
                url:'${ctx}/menue/getFunIds',
                valueField:'id',
                textField:'text'
            });

            $('#dlg_newmenu').dialog('open').dialog('setTitle','新建菜单');
            $('#fm_newmenu').form('clear');

            $('#myMenueStatus_new').combobox('setValue',1);

            //一级节点下添加菜单
            if(node){
                $('#parMenueId_new').val(node.id);
            }
        }

        //修改菜单对话框弹出
        function editMenue(){

            var node = $('#myTree').tree('selectedItems')[0];
            if(node){
                var myid = node.id;

                $('#ccfunid_edit').combobox({
                    url:'${ctx}/menue/getFunIds',
                    valueField:'id',
                    textField:'text',
                    onLoadSuccess:function(){
                        //$('#dlg_editmenu').dialog('open').dialog('setTitle','修改菜单');
                        //$('#fm_editmenu').form('clear');
                        //$('#fm_editmenu').form('load',
                        //		'${ctx}/menue/updtMenueInit?menueId='+myid
                        //	);
                        var url = '${ctx}/menue/updtMenueInit?menueId='+myid;
                        $.post(url, function(result) {
                            if(result.success) {

                                $('#dlg_editmenu').dialog('open').dialog('setTitle','修改菜单');
                                $('#fm_editmenu').form('clear');

                                $('#fm_editmenu').form('load', result.object);
                            } else {
                                $.messager.show({
                                    title: '友情提示',
                                    msg: result.msg
                                });
                            }
                        }, 'json');
                    }
                });

            }else{
                $.messager.show({
                    title: '友情提示',
                    msg: '请选择节点'
                });
            }

        }

        //执行添加菜单事件
        function saveMenue(){

            var parMenueId = $('#parMenueId_new').val();
            //在根节点下添加节点
            if(parMenueId==''){
                if($('#ccfunid').combo('getValue')!=-1){
                    $.messager.show({
                        title: '友情提示',
                        msg: '请在功能操作上选择不设置'
                    });
                    return;
                }
                parMenueId=0;
            }else{
                //在非根节点下添加的节点 不允许不关联资源
                if($('#ccfunid').combo('getValue')==-1){
                    $.messager.show({
                        title: '友情提示',
                        msg: '请选择一个功能操作'
                    });
                    return;
                }
            }

            //如果点击按钮前未选中节点 parMenueId默认为1 (后台进行处理)
            //否则 默认parMenueId为所选中节点
            url = '${ctx}/menue/saveMenue?parMenueId='+parMenueId;

            $('#fm_newmenu').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                        $('#dlg_newmenu').dialog('close');
                        $.messager.show({
                            title: '友情提示',
                            msg: '操作成功'
                        });
                        $('#myTree').tree('reload');

                    } else {
                        $.messager.show({
                            title: '友情提示',
                            msg: result.msg
                        });
                    }
                }
            });
        }

        //执行修改菜单事件
        function saveEditMenue(){

            var parMenueId = $('#parMenueId_edit').val();
            //修改一级节点
            if(parMenueId==1){
                if($('#ccfunid_edit').combo('getValue')!=-1){
                    $.messager.show({
                        title: '友情提示',
                        msg: '请在功能操作上选择不设置'
                    });
                    return;
                }
                parMenueId=0;
            }else{
                //在非根节点下添加的节点 不允许不关联资源
                if($('#ccfunid_edit').combo('getValue')==-1){
                    $.messager.show({
                        title: '友情提示',
                        msg: '请选择一个功能操作'
                    });
                    return;
                }
            }

            var url = '${ctx}/menue/updtMenue';
            $('#fm_editmenu').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                        $('#dlg_editmenu').dialog('close');
                        $.messager.show({
                            title: '友情提示',
                            msg: '操作成功'
                        });
                        $('#myTree').tree('reload');
                    } else {
                        $.messager.show({
                            title: 'Error',
                            msg: result.msg
                        });
                    }
                }
            });
        }

        //删除菜单
        function deleteMenue(){
            var node = $('#myTree').tree('getSelected');

            if(node){

                //var parent = $('#myTree').tree('getParent', node.target);
                var children = '';
                try{
                    children = $('#myTree').tree('getChildren', node.target);
                }catch(e){
                }

                //如果还有孩子节点
                if(children!=''){
                    $.messager.show({
                        title: '友情提示',
                        msg: '请先删除子节点'
                    });
                    return;
                }

                $.messager.confirm('确认!','你确定要删除该用节点吗?',function(r){
                    if(r){
                        $.post("${ctx}/menue/delMenue",{'menueId':node.id}, function(result){
                            if (result.success){
                                $.messager.show({
                                    title: '友情提示',
                                    msg: '操作成功'
                                });
                                $('#myTree').tree('reload');
                            } else {
                                $.messager.show({
                                    title: 'Error',
                                    msg: result.msg
                                });
                            }
                        },'json');
                    }
                });
            }else{
                $.messager.show({
                    title: '友情提示',
                    msg: '请选择节点'
                });
            }
        }
        
        function eachData(data) {
            $.each(data,function (idx,item) {
                data[idx].title=item.menueNm;
                data[idx].type=item.childrenMenueList?"folder":"item";
                data[idx].attr={
                    classNames:"",
                    icon:"",
                    id:item.menueId
                };
                if(item.childrenMenueList){
                    eachData(item.childrenMenueList);
                }
            });
        }
        $(function(){

            var value=0;
            $('#mytree').tree({
                dataSource: function(options, callback) {
                    if(value>0){
                        callback({data:options.childrenMenueList});
                        return false;
                    }
                    value++;
                    kew.ajax("${ctx}/menue/getMenue",{
                        data:{

                        },
                        success:function (data) {
                            eachData(data.content);
                            callback({data:data.content});
                        }
                    });
                    //  editMenue();
                },
                multiSelect: false,
                cacheItems: true,
                folderSelect: false
            });

            $('#myTree').on('selected.tree.amui', function (event, data) {
            });

        });
    </script>
</head>
<body>
<!-- 菜单页面加载 -->
<div id="tb_menue" style="padding:5px;height:auto">
	<span style="float: right">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMenue()">新建</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMenue()">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteMenue()">删除</a>
	</span>
    <div style="margin-bottom:5px">
        <ul class="am-tree am-tree-folder-select" role="tree" id="mytree">
            <li class="am-tree-branch am-hide" data-template="treebranch" role="treeitem" aria-expanded="false">
                <div class="am-tree-branch-header">
                    <button class="am-tree-icon am-tree-icon-caret am-icon-caret-right"><span class="am-sr-only">Open</span></button>
                    <button class="am-tree-branch-name">
                        <span class="am-tree-icon am-tree-icon-folder"></span>
                        <span class="am-tree-label"></span>
                    </button>
                </div>
                <ul class="am-tree-branch-children" role="group"></ul>
                <div class="am-tree-loader" role="alert">Loading...</div>
            </li>
            <li class="am-tree-item am-hide" data-template="treeitem" role="treeitem">
                <button class="am-tree-item-name">
                    <span class="am-tree-icon am-tree-icon-item"></span>
                    <span class="am-tree-label"></span>
                </button>
            </li>
        </ul>
    </div>
</div>
<div style="display:none">
    <!-- 新建窗口 -->
    <div id="dlg_newmenu" class="easyui-window" title="新建节点"  iconCls="icon-save" style="width:400px;height:320px;padding:10px 20px" closed="true" modal="true"  minimizable="false" maximizable="false">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false">
                <div class="ftitle">节点信息</div>
                <form id="fm_newmenu" method="post">
                    <div class="fitem">
                        <input name="parMenueId" type="hidden" id="parMenueId_new">
                    </div>
                    <div class="fitem">
                        <label>菜单名称:</label>
                        <input name="menueNm" class="easyui-validatebox" required="true"/>
                    </div>
                    <div class="fitem">
                        <label>功能操作ID:</label>
                        <!-- <input type="funOptId" name="funOptId" class="easyui-validatebox" required="true"/> -->
                        <input id="ccfunid" name="funOptId" required="true" style="width:153px;"/>
                    </div>
                    <div class="fitem">
                        <label>备注:</label>
                        <input name="remarks" class="easyui-validatebox" required="true"/>
                    </div>
                    <!--
                    <div class="fitem">
                        <label>状态:</label>
                        <input name="state" class="easyui-numberbox" min="0" max="9" precision="0" required="true" missingMessage="请填写一位整数"/>
                    </div>
                    -->
                    <div class="fitem">
                        <label>状态：</label>
                        <select id="myMenueStatus_new" name="state" editable="false" class="easyui-combobox" style="width:153px;" required="true">
                            <option value="1">有效</option>
                            <option value="0">无效</option>
                        </select>
                    </div>

                    <div class="fitem">
                        <label>菜单顺序:</label>
                        <input name="menueOrder" class="easyui-numberbox" style="width:153px;" required="true" min="0" max="99" precision="0" missingMessage="请填写2位以下整数"/>
                    </div>
                </form>
            </div>
            <div region="south" border="false" style="text-align:right;height:30px;line-height:30px;">
                <a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="saveMenue()">保存</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="javascript:$('#dlg_newmenu').window('close')">取消</a>
            </div>
        </div>
    </div>

    <!-- 修改窗口 -->
    <div id="dlg_editmenu" class="easyui-window" title="修改节点"  iconCls="icon-save" style="width:400px;height:320px;padding:10px 20px" closed="true" modal="true"  minimizable="false" maximizable="false">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false">
                <div class="ftitle">节点信息</div>
                <form id="fm_editmenu" method="post">
                    <div class="fitem">
                        <input name="menueId" type="hidden" id="menueId_edit">
                        <input name="parMenueId" type="hidden" id="parMenueId_edit">
                    </div>
                    <div class="fitem">
                        <label>菜单名称:</label>
                        <input name="menueNm" class="easyui-validatebox" required="true"/>
                    </div>
                    <div class="fitem">
                        <label>功能操作ID:</label>
                        <!-- <input type="funOptId" name="funOptId" class="easyui-validatebox" required="true"/> -->
                        <input id="ccfunid_edit" name="funOptId" required="true" style="width:153px;"/>
                    </div>
                    <div class="fitem">
                        <label>备注:</label>
                        <input name="remarks" class="easyui-validatebox" required="true"/>
                    </div>
                    <div class="fitem">
                        <label>状态:</label>
                        <select id="myMenueStatus" name="state" editable="false" class="easyui-combobox" style="width:153px;" required="true">
                            <option value="1">有效</option>
                            <option value="0">无效</option>
                        </select>
                    </div>
                    <div class="fitem">
                        <label>菜单顺序:</label>
                        <input name="menueOrder" class="easyui-validatebox" required="true"/>
                    </div>
                </form>
            </div>
            <div region="south" border="false" style="text-align:right;height:30px;line-height:30px;">
                <a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="saveEditMenue()">保存</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="javascript:$('#dlg_editmenu').window('close')">取消</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>





