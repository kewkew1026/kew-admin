!function () {
    var kew = window.kew || function () {
            return new kew.fn.init();
        };
    kew.fn = kew.prototype = {
        /**
         * 初始化
         */
        init: function () {
            return this;
        }

    };
    window.kew = kew;

    /***
     * 初始化tabpanel
     * @param opt
     * root 父节点select对象
     * defaultPages 默认显示页数
     */
    kew.tabpanel = function (opt) {

        /***
         * 初始化容器
         */
        function init() {
            var _header = ' <div class="tabs-header tabs-header-noborder"  style="">' +
                '<div class="tabs-scroller-left" style="display: none;"></div>' +
                '<div class="tabs-scroller-right" style="display: none;"></div>' +
                '<div class="tabs-wrap" style="margin-left: 0px; margin-right: 0px; width: 1461px;">' +
                '<ul class="tabs" style="height: 33px;">' +
                '</ul> </div> </div>';
            var _body = '<div title=""  class="panel-body panel-body-noheader panel-body-noborder" style=""> </div>';
            $(opt.root).html(_header + _body);

            //初始化事件

            $(opt.root).on("click", "a.tabs-close", function (e) {
                //关闭tab
                var index = $(this).attr("index") * 1;
                $(this).parent().remove();
                if (index == $(opt.root + ">div.tabs-header ul.tabs>li").length) {
                    $(opt.root + ">div.tabs-header ul.tabs>li:last").addClass("tab-last");
                }
                $(opt.root + ">.panel-body>[index=" + (index + 1) + "]").remove();
                $(opt.root + ">div.tabs-header ul.tabs>li:last").trigger("click");
                e.preventDefault();
                return false;
            });

            $(opt.root).on("click", "div.tabs-header ul.tabs>li", function () {
                //显示点击tab
                if (!$(this).has('tabs-closable')) {
                    return false;
                }
                hideAll();
                var index = $(this).attr("index") * 1;
                $(this).addClass('tabs-selected');
                $(opt.root + ">.panel-body>[index=" + (index + 1) + "]").show();
            });


            //检测是否有默认页数

            if (opt.defaultPages) {
                $.each(opt.defaultPages, function (idx, tab) {
                    addTab(tab);
                });
            }

            kew.tabpanel.addTab = addTab;
        }

        function addTab(tabOption) {
            if ($(opt.root + ">div.tabs-header ul.tabs>li[title=" + tabOption.title + "]").length > 0) {
                if ($(opt.root + ">div.tabs-header ul.tabs>li[title=" + tabOption.title + "]").hasClass('tabs-selected')) {
                } else {
                    $(opt.root + ">div.tabs-header ul.tabs>li[title=" + tabOption.title + "]").trigger("click");
                }
                return false;
            }

            switch (tabOption.tabType) {
                case "iframe":
                    addIframeTab(tabOption);
                    break;
                case "div":
                    addDivTab(tabOption);
                    break;
            }
        }

        function makeTitle(text, isClosed) {
            $(opt.root + ">div.tabs-header ul.tabs>li:last").removeClass('tabs-last');
            return '<li title="' + text + '" index="' + $(opt.root + ">div.tabs-header ul.tabs>li").length + '" class="tabs-selected ' + ($(opt.root + ">div.tabs-header ul.tabs").children().length == 0 ? 'tabs-first' : 'tabs-last') + ' "><a href="javascript:void(0)" class="tabs-inner" style="height: 32px; line-height: 32px;">' +
                '<span class="tabs-title ' + (isClosed ? 'tabs-closable' : '') + '  tabs-with-icon">' + text + '</span>' +
                '<span class="tabs-icon icon-default"></span></a>' +
                (isClosed ? '<a href="javascript:void(0)" index="' + $(opt.root + ">div.tabs-header ul.tabs>li").length + '" class="tabs-close"></a>' : '') +
                '</li>';
        }

        function addDivTab(tabOption) {
            var _title = makeTitle(tabOption.title, tabOption.isClosed);

            hideAll();
            $(opt.root + ">div.tabs-header ul.tabs").append(_title);
            $(opt.root + ">div.panel-body").append("<div index=" + $(opt.root + ">div.tabs-header ul.tabs>li").length + ">" + tabOption.inner + "</div>");
            $(opt.root + ">div.tabs-header ul.tabs>li:last").trigger('click');
        }

        function addIframeTab(tabOption) {
            if (!tabOption.src) {
                alert("当前功能暂未实现");
                return false;
            }

            hideAll();
            var _title = makeTitle(tabOption.title, tabOption.isClosed);
            $(opt.root + ">div.tabs-header ul.tabs").append(_title);
            var _iframe = ' <iframe index=' + $(opt.root + ">div.tabs-header ul.tabs>li").length + ' scrolling="yes" frameborder="0" src="' + tabOption.src + '" style="width:100%;height:auto;min-height:923px;background-color:white;"></iframe>';
            $(opt.root + ">div.panel-body").append(_iframe);
        }

        function hideAll() {
            $(opt.root + ">div.tabs-header ul.tabs>li").removeClass("tabs-selected");
            $(opt.root + ">.panel-body").children().hide();
        }

        if (!kew.tabpanel.isInit) {
            init();
            kew.tabpanel.isInit = true;
        }

    };

    kew.ajax = function (url, o) {
        $.ajax({
            url: url,
            data: o.data,
            dataType: "json",
            type: "post",
            error: o.error,
            ajaxSuccess: o.ajaxSuccess,
            success: function (data) {
                if (data && data.success) {
                    if (typeof o.success == "function") {
                        o.success(data);
                    }
                } else {
                    if (typeof o.failure == "function") {
                        o.failure(data);
                    }
                }
            },
            statusCode: {
                404: function () {
                    console.log(arguments);
                },
                602: function () {
                    console.log(arguments);
                    // layer.msg("登录超时");
                    // logout();
                }
            }
        });
    };
}();
