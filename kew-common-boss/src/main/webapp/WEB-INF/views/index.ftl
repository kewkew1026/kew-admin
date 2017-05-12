<!doctype html>
<html>
<head>
<title>运营系统风控管理平台</title>
<#include "/common/resources.ftl"/>
    <script src="${res}/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${res}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${res}/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${res}/assets/css/app.css">
    <script src="${res}/assets/js/jquery.min.js"></script>
<style>
    .tabs-header {
        border-width: 1px;
        border-style: solid;
        border-bottom-width: 0;
        position: relative;
        padding: 0;
        padding-top: 2px;
        overflow: hidden;
    }
    .tabs-scroller-left,
    .tabs-scroller-right {
        position: absolute;
        top: auto;
        bottom: 0;
        width: 18px;
        font-size: 1px;
        display: none;
        cursor: pointer;
        border-width: 1px;
        border-style: solid;
    }
    .tabs-scroller-left {
        left: 0;
    }
    .tabs-scroller-right {
        right: 0;
    }
    .tabs-tool {
        position: absolute;
        bottom: 0;
        padding: 1px;
        overflow: hidden;
        border-width: 1px;
        border-style: solid;
    }
    .tabs-header-plain .tabs-tool {
        padding: 0 1px;
    }
    .tabs-wrap {
        position: relative;
        left: 0;
        overflow: hidden;
        width: 100%;
        margin: 0;
        padding: 0;
    }
    .tabs-scrolling {
        margin-left: 18px;
        margin-right: 18px;
    }
    .tabs-disabled {
        opacity: 0.3;
        filter: alpha(opacity=30);
    }
    .tabs {
        list-style-type: none;
        height: 26px;
        margin: 0px;
        padding: 0px;
        padding-left: 4px;
        width: 50000px;
        border-style: solid;
        border-width: 0 0 1px 0;
    }
    .tabs li {
        float: left;
        display: inline-block;
        margin: 0 4px -1px 0;
        padding: 0;
        position: relative;
        border: 0;
    }
    .tabs li a.tabs-inner {
        display: inline-block;
        text-decoration: none;
        margin: 0;
        padding: 0 10px;
        height: 25px;
        line-height: 25px;
        text-align: center;
        white-space: nowrap;
        border-width: 1px;
        border-style: solid;
        -moz-border-radius: 5px 5px 0 0;
        -webkit-border-radius: 5px 5px 0 0;
        border-radius: 5px 5px 0 0;
    }
    .tabs li.tabs-selected a.tabs-inner {
        font-weight: bold;
        outline: none;
    }
    .tabs li.tabs-selected a:hover.tabs-inner {
        cursor: default;
        pointer: default;
    }
    .tabs li a.tabs-close,
    .tabs-p-tool {
        position: absolute;
        font-size: 1px;
        display: block;
        height: 12px;
        padding: 0;
        top: 50%;
        margin-top: -6px;
        overflow: hidden;
    }
    .tabs li a.tabs-close {
        width: 12px;
        right: 5px;
        opacity: 0.6;
        filter: alpha(opacity=60);
    }
    .tabs-p-tool {
        right: 16px;
    }
    .tabs-p-tool a {
        display: inline-block;
        font-size: 1px;
        width: 12px;
        height: 12px;
        margin: 0;
        opacity: 0.6;
        filter: alpha(opacity=60);
    }
    .tabs li a:hover.tabs-close,
    .tabs-p-tool a:hover {
        opacity: 1;
        filter: alpha(opacity=100);
        cursor: hand;
        cursor: pointer;
    }
    .tabs-with-icon {
        padding-left: 18px;
    }
    .tabs-icon {
        position: absolute;
        width: 16px;
        height: 16px;
        left: 10px;
        top: 50%;
        margin-top: -8px;
    }
    .tabs-title {
        font-size: 12px;
    }
    .tabs-closable {
        padding-right: 8px;
    }
    .tabs-panels {
        margin: 0px;
        padding: 0px;
        border-width: 1px;
        border-style: solid;
        border-top-width: 0;
        overflow: hidden;
    }
    .tabs-header-bottom {
        border-width: 0 1px 1px 1px;
        padding: 0 0 2px 0;
    }
    .tabs-header-bottom .tabs {
        border-width: 1px 0 0 0;
    }
    .tabs-header-bottom .tabs li {
        margin: -1px 4px 0 0;
    }
    .tabs-header-bottom .tabs li a.tabs-inner {
        -moz-border-radius: 0 0 5px 5px;
        -webkit-border-radius: 0 0 5px 5px;
        border-radius: 0 0 5px 5px;
    }
    .tabs-header-bottom .tabs-tool {
        top: 0;
    }
    .tabs-header-bottom .tabs-scroller-left,
    .tabs-header-bottom .tabs-scroller-right {
        top: 0;
        bottom: auto;
    }
    .tabs-panels-top {
        border-width: 1px 1px 0 1px;
    }
    .tabs-header-left {
        float: left;
        border-width: 1px 0 1px 1px;
        padding: 0;
    }
    .tabs-header-right {
        float: right;
        border-width: 1px 1px 1px 0;
        padding: 0;
    }
    .tabs-header-left .tabs-wrap,
    .tabs-header-right .tabs-wrap {
        height: 100%;
    }
    .tabs-header-left .tabs {
        height: 100%;
        padding: 4px 0 0 2px;
        border-width: 0 1px 0 0;
    }
    .tabs-header-right .tabs {
        height: 100%;
        padding: 4px 2px 0 0;
        border-width: 0 0 0 1px;
    }
    .tabs-header-left .tabs li,
    .tabs-header-right .tabs li {
        display: block;
        width: 100%;
        position: relative;
    }
    .tabs-header-left .tabs li {
        left: auto;
        right: 0;
        margin: 0 -1px 4px 0;
        float: right;
    }
    .tabs-header-right .tabs li {
        left: 0;
        right: auto;
        margin: 0 0 4px -1px;
        float: left;
    }
    .tabs-justified li a.tabs-inner {
        padding-left: 0;
        padding-right: 0;
    }
    .tabs-header-left .tabs li a.tabs-inner {
        display: block;
        text-align: left;
        padding-left: 10px;
        padding-right: 10px;
        -moz-border-radius: 5px 0 0 5px;
        -webkit-border-radius: 5px 0 0 5px;
        border-radius: 5px 0 0 5px;
    }
    .tabs-header-right .tabs li a.tabs-inner {
        display: block;
        text-align: left;
        padding-left: 10px;
        padding-right: 10px;
        -moz-border-radius: 0 5px 5px 0;
        -webkit-border-radius: 0 5px 5px 0;
        border-radius: 0 5px 5px 0;
    }
    .tabs-panels-right {
        float: right;
        border-width: 1px 1px 1px 0;
    }
    .tabs-panels-left {
        float: left;
        border-width: 1px 0 1px 1px;
    }
    .tabs-header-noborder,
    .tabs-panels-noborder {
        border: 0px;
    }
    .tabs-header-plain {
        border: 0px;
        background: transparent;
    }
    .tabs-pill {
        padding-bottom: 3px;
    }
    .tabs-header-bottom .tabs-pill {
        padding-top: 3px;
        padding-bottom: 0;
    }
    .tabs-header-left .tabs-pill {
        padding-right: 3px;
    }
    .tabs-header-right .tabs-pill {
        padding-left: 3px;
    }
    .tabs-header .tabs-pill li a.tabs-inner {
        -moz-border-radius: 5px 5px 5px 5px;
        -webkit-border-radius: 5px 5px 5px 5px;
        border-radius: 5px 5px 5px 5px;
    }
    .tabs-header-narrow,
    .tabs-header-narrow .tabs-narrow {
        padding: 0;
    }
    .tabs-narrow li,
    .tabs-header-bottom .tabs-narrow li {
        margin-left: 0;
        margin-right: -1px;
    }
    .tabs-narrow li.tabs-last,
    .tabs-header-bottom .tabs-narrow li.tabs-last {
        margin-right: 0;
    }
    .tabs-header-left .tabs-narrow,
    .tabs-header-right .tabs-narrow {
        padding-top: 0;
    }
    .tabs-header-left .tabs-narrow li {
        margin-bottom: -1px;
        margin-right: -1px;
    }
    .tabs-header-left .tabs-narrow li.tabs-last,
    .tabs-header-right .tabs-narrow li.tabs-last {
        margin-bottom: 0;
    }
    .tabs-header-right .tabs-narrow li {
        margin-bottom: -1px;
        margin-left: -1px;
    }
    .tabs-scroller-left {
        background: #F2F2F2 url('images/tabs_icons.png') no-repeat 1px center;
    }
    .tabs-scroller-right {
        background: #F2F2F2 url('images/tabs_icons.png') no-repeat -15px center;
    }
    .tabs li a.tabs-close {
        background: url('images/tabs_icons.png') no-repeat -34px center;
    }
    .tabs li a.tabs-inner:hover {
        background: #e6e6e6;
        color: #00438a;
        filter: none;
    }
    .tabs li.tabs-selected a.tabs-inner {
        background-color: #ffffff;
        color: #777;
        background: -webkit-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: -moz-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: -o-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: linear-gradient(to bottom,#ffffff 0,#ffffff 100%);
        background-repeat: repeat-x;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#ffffff,GradientType=0);
    }
    .tabs-header-bottom .tabs li.tabs-selected a.tabs-inner {
        background: -webkit-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: -moz-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: -o-linear-gradient(top,#ffffff 0,#ffffff 100%);
        background: linear-gradient(to bottom,#ffffff 0,#ffffff 100%);
        background-repeat: repeat-x;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#ffffff,GradientType=0);
    }
    .tabs-header-left .tabs li.tabs-selected a.tabs-inner {
        background: -webkit-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: -moz-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: -o-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: linear-gradient(to right,#ffffff 0,#ffffff 100%);
        background-repeat: repeat-y;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#ffffff,GradientType=1);
    }
    .tabs-header-right .tabs li.tabs-selected a.tabs-inner {
        background: -webkit-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: -moz-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: -o-linear-gradient(left,#ffffff 0,#ffffff 100%);
        background: linear-gradient(to right,#ffffff 0,#ffffff 100%);
        background-repeat: repeat-y;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#ffffff,GradientType=1);
    }
    .tabs li a.tabs-inner {
        color: #777;
        background-color: #F2F2F2;
        background: -webkit-linear-gradient(top,#ffffff 0,#F2F2F2 100%);
        background: -moz-linear-gradient(top,#ffffff 0,#F2F2F2 100%);
        background: -o-linear-gradient(top,#ffffff 0,#F2F2F2 100%);
        background: linear-gradient(to bottom,#ffffff 0,#F2F2F2 100%);
        background-repeat: repeat-x;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff,endColorstr=#F2F2F2,GradientType=0);
    }
    .tabs-header,
    .tabs-tool {
        background-color: #F2F2F2;
    }
    .tabs-header-plain {
        background: transparent;
    }
    .tabs-header,
    .tabs-scroller-left,
    .tabs-scroller-right,
    .tabs-tool,
    .tabs,
    .tabs-panels,
    .tabs li a.tabs-inner,
    .tabs li.tabs-selected a.tabs-inner,
    .tabs-header-bottom .tabs li.tabs-selected a.tabs-inner,
    .tabs-header-left .tabs li.tabs-selected a.tabs-inner,
    .tabs-header-right .tabs li.tabs-selected a.tabs-inner {
        border-color: #D4D4D4;
    }
    .tabs-p-tool a:hover,
    .tabs li a:hover.tabs-close,
    .tabs-scroller-over {
        background-color: #e6e6e6;
    }
    .tabs li.tabs-selected a.tabs-inner {
        border-bottom: 1px solid #ffffff;
    }
    .tabs-header-bottom .tabs li.tabs-selected a.tabs-inner {
        border-top: 1px solid #ffffff;
    }
    .tabs-header-left .tabs li.tabs-selected a.tabs-inner {
        border-right: 1px solid #ffffff;
    }
    .tabs-header-right .tabs li.tabs-selected a.tabs-inner {
        border-left: 1px solid #ffffff;
    }
    .tabs-header .tabs-pill li.tabs-selected a.tabs-inner {
        background: #0081c2;
        color: #fff;
        filter: none;
        border-color: #D4D4D4;
    }
</style>
</head>
<body data-type="index">
<script src="${res}/assets/js/theme.js"></script>

<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="${img}/logo_title.png" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 侧边切换 -->
            <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
            </div>
            <!-- 搜索 -->
            <div class="am-fl tpl-header-search">
                <form class="tpl-header-search-form" action="javascript:;">
                    <button class="tpl-header-search-btn am-icon-search"></button>
                    <input class="tpl-header-search-box" type="text" placeholder="搜索内容...">
                </form>
            </div>
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span>${userName}</span> </a>
                    </li>

                    <!-- 新邮件 -->
                    <li class="am-dropdown tpl-dropdown" data-am-dropdown>
                        <a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>
                            <i class="am-icon-envelope"></i>
                            <span class="am-badge am-badge-success am-round item-feed-badge">4</span>
                        </a>
                        <!-- 弹出列表 -->
                        <ul class="am-dropdown-content tpl-dropdown-content">
                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <div class="menu-messages-ico">
                                        <img src="${res}/assets/img/user04.png" alt="">
                                    </div>
                                    <div class="menu-messages-time">
                                        lastTime
                                    </div>
                                    <div class="menu-messages-content">
                                        <div class="menu-messages-content-title">
                                            <i class="am-icon-circle-o am-text-success"></i>
                                            <span>sender</span>
                                        </div>
                                        <div class="am-text-truncate"> content </div>
                                        <div class="menu-messages-content-time">time</div>
                                    </div>
                                </a>
                            </li>

                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <div class="menu-messages-ico">
                                        <img src="${res}/assets/img/user02.png" alt="">
                                    </div>
                                    <div class="menu-messages-time">
                                        lastTime
                                    </div>
                                    <div class="menu-messages-content">
                                        <div class="menu-messages-content-title">
                                            <i class="am-icon-circle-o am-text-warning"></i>
                                            <span>sender</span>
                                        </div>
                                        <div class="am-text-truncate"> content </div>
                                        <div class="menu-messages-content-time">time</div>
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-messages">
                                <a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">
                                    <i class="am-icon-circle-o"></i> 进入列表…
                                </a>
                            </li>
                        </ul>
                    </li>

                    <!-- 新提示 -->
                    <li class="am-dropdown" data-am-dropdown>
                        <a href="javascript:;" class="am-dropdown-toggle" data-am-dropdown-toggle>
                            <i class="am-icon-bell"></i>
                            <span class="am-badge am-badge-warning am-round item-feed-badge">5</span>
                        </a>

                        <!-- 弹出列表 -->
                        <ul class="am-dropdown-content tpl-dropdown-content">
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-line-chart"></i>
                                        <span> notify</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        seconds
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-star"></i>
                                        <span> notify</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        seconds
                                    </div>
                                </a>
                            </li>
                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <div class="tpl-dropdown-menu-notifications-title">
                                        <i class="am-icon-folder-o"></i>
                                        <span> notify</span>
                                    </div>
                                    <div class="tpl-dropdown-menu-notifications-time">
                                        seconds
                                    </div>
                                </a>
                            </li>


                            <li class="tpl-dropdown-menu-notifications">
                                <a href="javascript:;" class="tpl-dropdown-menu-notifications-item am-cf">
                                    <i class="am-icon-bell"></i> 进入列表…
                                </a>
                            </li>
                        </ul>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="${ctx}/user/logoff">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 风格切换 -->
    <#--<div class="tpl-skiner">-->
        <#--<div class="tpl-skiner-toggle am-icon-cog">-->
        <#--</div>-->
        <#--<div class="tpl-skiner-content">-->
            <#--<div class="tpl-skiner-content-title">-->
                <#--选择主题-->
            <#--</div>-->
            <#--<div class="tpl-skiner-content-bar">-->
                <#--<span class="skiner-color skiner-white" data-color="theme-white"></span>-->
                <#--<span class="skiner-color skiner-black" data-color="theme-black"></span>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
    <!-- 侧边导航栏 -->
    <div class="left-sidebar" style="    border-right: 1px solid #eee;">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="${res}/assets/img/user03.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              ${userName}
          </span>
                <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
            </div>
        </div>
        <!-- 菜单 -->
        <ul class="sidebar-nav">
            <#list menues as menue>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> ${menue.menueNm}
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <#list menue.childrenMenueList as sub>
                            <li class="sidebar-nav-link">
                                <a href="#" onclick="openTab('${ctx}/${sub.menueUrl}', '${sub.menueNm}')" class="">
                                    <i class="am-icon-home sidebar-nav-link-logo"></i> ${sub.menueNm}
                                </a>
                            </li>
                        </#list>
                    </ul>
                </li>
            </#list>


        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">

        <div class="tabs-header tabs-header-noborder" style="">
            <div class="tabs-scroller-left" style="display: none;"></div>
            <div class="tabs-scroller-right" style="display: none;"></div>
            <div class="tabs-wrap" style="margin-left: 0px; margin-right: 0px; width: 1461px;">
                <ul class="tabs" style="height: 33px;">
                    <li class="tabs-first">
                        <a href="javascript:void(0)" class="tabs-inner" style="height: 32px; line-height: 32px;">
                            <span class="tabs-title">欢迎页</span>
                            <span class="tabs-icon"></span>
                        </a></li>
                    <li class="tabs-last tabs-selected">
                        <a href="javascript:void(0)" class="tabs-inner" style="height: 32px; line-height: 32px;">
                            <span class="tabs-title tabs-closable tabs-with-icon">商品管理</span>
                            <span class="tabs-icon icon-default"></span>
                        </a>
                        <a href="javascript:void(0)" class="tabs-close">

                        </a>
                    </li>
                </ul>
            </div>
        </div>

        
        <div title="" class="panel-body panel-body-noheader panel-body-noborder" style="">
            <iframe scrolling="yes" frameborder="0" src="/shop-boss/shop/product/manage" style="width:100%;height:auto;min-height:923px;background-color:white;"></iframe>
        </div>


    </div>
</div>
</div>
<script src="${res}/assets/js/amazeui.min.js"></script>
<script src="${res}/assets/js/app.js"></script>
<script type="text/javascript" >
    var windows=[];

    function openTab(url, title){
        $("#titleList").children("ul>li").removeClass("am-active");
        $("#tabList").children("div").removeClass("am-active");

        var tt = $('a[title='+title+']');


        if (tt.length>0){//如果tab已经存在,则选中并刷新该tab
            tt.parent().addClass("am-active");
            $(window.frames[url]).parent().addClass("am-active");
            window.frames[url].contentWindow.location.reload();
        } else {
            var content;

            if (url){
                content = $(' <div data-tab-panel-'+(windows.length+1)+' class="am-tab-panel am-active"><iframe scrolling="yes" id="'+url+'" frameborder="0"  src="'+url+'" style="width:100%;height:auto;min-height:1800px;background-color:white;"></iframe></div>');
            } else {
                content = '未实现';
            }

            windows.push(content);
            $("#tabList").append(content);
            content.addClass("am-active");
            $("#titleList").append(  '<li class="am-active"><a title='+title+' href="[data-tab-panel-'+windows.length+']">'+title+'</a><a class="tabs-close" href="javascript:void(0)">x</a></li>');
        }

    }

</script>
</body>
</html>