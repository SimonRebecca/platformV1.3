/**
 * 简单分页
 *
 * Created by zhangxin on 2015-08-05.
 */
(function ($) {
    $.extend({
        "easyPaginate": function (options) {
            options = $.extend({//参数设置
                navigateId: "navigateDiv",//导航按钮所在dom的id
                navigateCount: 7,//导航按钮一次显示多少个
                showDataId: "showData",//显示数据所在dom的id
                totalPage: 0,//总页数
                pageNum: 0,//当前页码
                onChange: function () {
                    return false
                }//显示数据
            }, options);
            //拼接导航按钮
            var navigateHtml = "<div id='pageFirst' class='pageFirst'><a href='javascript:void(0);'>首页</a></div>";
            navigateHtml += "<div id='pagePre' class='pagePre'><a href='javascript:void(0);'>上一页</a></div>";
            for (var i = 1; i <= options.totalPage; i++) {
                navigateHtml += "<div class='pageNavigate'><a href='javascript:void(0);'>" + i + "</a></div>";
            }
            navigateHtml += "<div id='pageNext' class='pageNext'><a href='javascript:void(0);'>下一页</a></div>";
            navigateHtml += "<div id='pageLast' class='pageLast'><a href='javascript:void(0);'>尾页</a></div>";
            navigateHtml += "<div id='pageInfo' class='pageInfo'>共 " + options.totalPage + " 页</div>";
            navigateHtml += "<div id='pageJump' class='pageJump'>至第 <input type='text' id='pageJumpText' style='width: 30px;'> 页</div>";
            //加载导航按钮
            $("#" + options.navigateId).html(navigateHtml);

            //得到所有按钮
            var navigates = $(".pageNavigate");

            //隐藏所有导航按钮
            $.extend({
                "hideAllNavigates": function () {
                    navigates.hide();
                }
            });

            //显示导航按钮
            $.extend({
                "showNavigate": function (pageNum) {
                    $.hideAllNavigates();//隐藏导航
                    if (options.totalPage == 0) {//没有数据
                        $("#" + options.showDataId).html("没有检索到相关数据！");
                        $("#pageJumpText").val(0);//文本框赋值
                    } else if (options.totalPage <= options.navigateCount) {//总页数小于等于显示的页数，则显示全部页码
                        navigates.show();
                    } else if (pageNum < options.navigateCount) {//当前页码小于显示的页数，则从 1→ options.navigateCount
                        for (var i = 0; i < options.navigateCount; i++) {
                            $(navigates[i]).show();
                        }
                    } else if ((pageNum >= options.navigateCount) && (((pageNum - (options.navigateCount / 2)) + options.navigateCount) <= options.totalPage)) {//当前页码大于等于显示的页数且计算的最大页码不超过实际页码数，则将当前页显示在中间偏前的位置
                        var start = pageNum - Math.floor(options.navigateCount / 2);
                        var end = start + options.navigateCount;
                        for (; start < end; start++) {
                            $(navigates[start]).show();
                        }
                    } else {//当前页码已接近最大页码数，则显示最后的 options.navigateCount 数据的页码
                        for (var i = (options.totalPage - options.navigateCount); i <= options.totalPage; i++) {
                            $(navigates[i]).show();
                        }
                    }
                }
            });

            // 高亮显示指定按钮
            $.extend({
                "lightNavigate": function (currentNavigate) {
                    // 移除所有高亮按钮样式
                    $(".pageNavigateOn").removeClass("pageNavigateOn");
                    // 高亮指定按钮
                    currentNavigate.addClass("pageNavigateOn");
                }
            });

            // 点击导航按钮
            $(".pageNavigate").each(function (i) {
                var currentObj = $(this);
                currentObj.click(function () {
                    if (options.pageNum != (i + 1)) {
                        options.pageNum = (i + 1);//当前页码
                        options.onChange(options.pageNum);//显示页面数据
                        $.showNavigate(options.pageNum);//显示导航按钮
                        $.lightNavigate($(navigates[i]));//高亮
                        $("#pageJumpText").val(options.pageNum);//文本框赋值
                    }
                });
            });

            // 点击首页按钮
            $(".pageFirst").click(function () {
                if (options.pageNum != 1) {
                    options.pageNum = 1;//当前页码
                    options.onChange(options.pageNum);//显示页面数据
                    $.showNavigate(options.pageNum);//显示导航按钮
                    $.lightNavigate($(navigates[options.pageNum - 1]));//高亮
                    $("#pageJumpText").val(options.pageNum);//文本框赋值
                }
            });

            // 点击上一页按钮
            $(".pagePre").click(function () {
                if (options.pageNum > 1) {
                    --options.pageNum < 1 ? ++options.pageNum : options.pageNum;//当前页码
                    options.onChange(options.pageNum);//显示页面数据
                    $.showNavigate(options.pageNum);//显示导航按钮
                    $.lightNavigate($(navigates[options.pageNum - 1]));//高亮
                    $("#pageJumpText").val(options.pageNum);//文本框赋值
                }
            });

            // 点击下一页按钮
            $(".pageNext").click(function () {
                if (options.pageNum < options.totalPage) {
                    ++options.pageNum > options.totalPage ? --options.pageNum : options.pageNum;//当前页码
                    options.onChange(options.pageNum);//显示页面数据
                    $.showNavigate(options.pageNum);//显示导航按钮
                    $.lightNavigate($(navigates[options.pageNum - 1]));//高亮
                    $("#pageJumpText").val(options.pageNum);//文本框赋值
                }
            });

            // 点击尾页按钮
            $(".pageLast").click(function () {
                if ((options.pageNum != options.totalPage) && (options.totalPage != 0)) {
                    options.pageNum = options.totalPage;//当前页码
                    options.onChange(options.pageNum);//显示页面数据
                    $.showNavigate(options.pageNum);//显示导航按钮
                    $.lightNavigate($(navigates[options.pageNum - 1]));//高亮
                }
                if (options.totalPage == 0) {
                    $("#pageJumpText").val(options.totalPage);//文本框赋值
                } else {
                    $("#pageJumpText").val(options.pageNum);//文本框赋值
                }
            });

            // 监听跳转页面输入框
            $("#pageJumpText").keyup(function (e) {
                if (e.keyCode == 13) {
                    var currentObj = $(this);
                    var pageJump = currentObj.val();
                    var re = /^[0-9]*[1-9][0-9]*$/;
                    if (re.test(pageJump)) {
                        if (pageJump <= options.totalPage) {
                            $(".pageNavigate").get(pageJump - 1).click();
                        } else {
                            $(".pageLast").click();
                        }
                    } else {
                        if (options.totalPage == 0) {
                            currentObj.val(options.totalPage);
                        } else {
                            currentObj.val(options.pageNum);
                        }
                    }
                }
            });

            // 初始化函数
            function init() {
//                options.onChange(options.pageNum);
                $("#pageJumpText").val(options.pageNum);//文本框赋值
                $.showNavigate(options.pageNum);
                $.lightNavigate($(navigates[options.pageNum - 1]));
            }

            //调用初始化函数
            init();
        }
    });
})(jQuery);
