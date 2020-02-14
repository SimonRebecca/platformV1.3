<%@page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../common/common.jsp" %>
<html>
<head>
    <title>用户信息</title>
    <meta http-equiv="content-type" charset="text/html; UTF-8">
</head>
<body>
<div id="userInfo" style="min-height: 150px;">
    <c:forEach items="${pagination.result}" var="user" varStatus="status">
        <div id="${user.userId}">
            <span id="" style="margin-right: 40px;">${status.count}</span>
            <span id="userName">${user.userName}</span>
            <span id="userAge" style="margin-left: 60px;">${user.userAge}</span>岁
        <span id="userSex" userSexText="${user.userSex}" style="margin-left: 70px;">
            <c:choose>
                <c:when test="${user.userSex eq 1}">
                    男
                </c:when>
                <c:when test="${user.userSex eq 0}">
                    女
                </c:when>
            </c:choose>
        </span>
            <span id="userTel" style="margin-left: 50px;">${user.userTel}</span>
        <span style="margin-left: 50px;">
        <c:choose>
            <c:when test="${user.userState eq 1}">
                正常
            </c:when>
            <c:when test="${user.userState eq 0}">
                锁定
            </c:when>
        </c:choose></span>
        <span style="margin-left: 50px;"><fmt:formatDate value="${user.createTime}"
                                                         pattern="yyyy-MM-dd HH:mm:ss"/> </span>
            <span style="margin-left: 50px;"><input type="button" class="deleteUser" value="删除"></span>
            <span style="margin-left: 50px;"><input type="button" class="updateUser" value="更新"></span>
        </div>
    </c:forEach>
</div>
<div id="navigateDiv"></div>
</body>
</html>
<link rel="stylesheet" type="text/css" href="${contextPath}/js/paginate/easyPaginate/easyPaginate.css"/>
<script src="${contextPath}/js/paginate/easyPaginate/easyPaginate.js"></script>
<script type="text/javascript">
    $(function () {
        $.fn.extend({
            //查询用户（分页）
            searchUserClick: function (pageNum) {
                $(this).click(function () {
                    var userName = $.trim($("#userNameSearch").val());
                    var userAge = $.trim($("#userAgeSearch").val());
                    var createTimeStart = $.trim($("#createTimeStartSearch").val());
                    var createTimeEnd = $.trim($("#createTimeEndSearch").val());
                    var param = {
                        "userName": userName,
                        "userAge": userAge,
                        "pageNum": $.trim(pageNum) == "" ? 1 : pageNum
                    };
                    if(createTimeStart != ""){
                        param.createTimeStartSearch = createTimeStart;
                    }
                    if(createTimeEnd != ""){
                        param.createTimeEndSearch = createTimeEnd;
                    }

                    $("#userListContent").html("加载中...").load("${contextPath}/user/findUserContent", param);
                })
            }
        });

        //分页
        $.easyPaginate({
            navigateId: "navigateDiv",//导航按钮所在dom的id
            showDataId: "userInfo",//显示数据所在dom的id
            totalPage: ${pagination.totalPage},//总页数
            pageNum: ${pagination.pageNum},//当前页码
            onChange: function (pageNum) {
                $("#navigateDiv").searchUserClick(pageNum);
            }
        });

        //删除用户信息
        $(".deleteUser").unbind("click").bind("click", function () {
            var currentObj = $(this);
            var useId = $.trim(currentObj.parents("div").attr("id"));
            if (confirm("是否确定删除？")) {
                $.ajax({
                    type: "post",
                    url: "deleteUser.do",
                    data: {"userId": useId},
                    dataType: "json",
                    success: function (jsonData) {
                        var state = jsonData.state;
                        if (state) {
                            $("#userListContent").load("findUserContent");
                        } else {
                            alert(jsonData.msg);
                        }
                    }
                });
            }
        });

        //更新用户信息
        $(".updateUser").unbind("click").bind("click", function () {
            var divObj = $(this).parents("div");
            $("#userIdNew").val(divObj.attr("id"));
            $("#userNameNew").val(divObj.children("#userName").text());
            $("#userAgeNew").val(divObj.children("#userAge").text());
            $("#userSexNew").val(divObj.children("#userSex").attr("userSexText"));
            $("#userTelNew").val(divObj.children("#userTel").text());
            $("#saveUser").val("更  新");
        });
    });
</script>