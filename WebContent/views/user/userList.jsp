<%@page contentType="text/html; UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="../common/common.jsp"%>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="content-type" charset="text/html; utf-8">
</head>
<body>
<input type="hidden" id="userIdNew"/>
<input type="text" placeholder="输入姓名" id="userNameNew"/>
<input type="text" placeholder="输入年龄" id="userAgeNew"/>
<select id="userSexNew">
    <option value="1">男</option>
    <option value="0">女</option>
</select>
<input type="text" placeholder="输入联系方式" id="userTelNew"/>
<input type="button" id="saveUser" value="新  增">
<hr>
<input type="text" placeholder="输入姓名" id="userNameSearch"/>
<input type="text" placeholder="输入年龄" id="userAgeSearch"/>
<input type="text" placeholder="输入开始时间" value="2015/08/01 5:10:31" id="createTimeStartSearch"/>--
<input type="text" placeholder="输入结束时间" value="2015/08/31 17:10:31" id="createTimeEndSearch"/>
<input type="button" id="searchUser" value="Search">
<hr>
<div id="userListContent" style="min-height: 150px;">
    <jsp:include page="userListContent.jsp"/>
</div>
<br><hr>
文件上传：
<form id="upload" action="${contextPath}/annex/uploadFile" enctype="multipart/form-data" method="post" >
    <input type="file" name="uploadFile"><br>
    <input type="file" name="uploadFile"><br>
    <input type="submit" value="Upload">
</form>
<br><hr>
</body>
</html>
<script type="text/javascript">
    $(function () {
        //查询用户
        $("#searchUser").searchUserClick();

        //保存用户信息
        $("#saveUser").unbind("click").bind("click", function () {
            var userId = $.trim($("#userIdNew").val());
            var userName = $.trim($("#userNameNew").val());
            var userAge = $.trim($("#userAgeNew").val());
            var userSex = $.trim($("#userSexNew").val());
            var userTel = $.trim($("#userTelNew").val());
            //判断是新增or更新操作
            if (userId == "") {//save
                $.ajax({
                    type: "post",
                    url: "saveUser",
                    data: {"userName": userName, "userAge": userAge, "userSex": userSex, "userTel": userTel },
                    dataType: "json",
                    success: function (jsonData) {
                        var state = jsonData.state;
                        if (state) {
                            clearInput();
                            $("#userListContent").load("findUserContent");
                        } else {
                            alert(jsonData.msg);
                        }
                    },
                    error: function () {
                        alert("error");
                    }
                });
            } else {//update
                $.ajax({
                    type: "post",
                    url: "updateUser.do",
                    data: {"userId": userId, "userName": userName, "userAge": userAge, "userSex": userSex, "userTel": userTel },
                    dataType: "json",
                    success: function (jsonData) {
                        var state = jsonData.state;
                        if (state) {
                            clearInput();
                            $("#userListContent").load("findUserContent");
                        } else {
                            alert(jsonData.msg);
                        }
                    },
                    error: function () {
                        alert("error");
                    }
                });
            }
        });

        //恢复默认设置
        function clearInput() {
            $("#userIdNew").val("");
            $("#userNameNew").val("");
            $("#userAgeNew").val("");
            $("#userSexNew").val("1");
            $("#userTelNew").val("");
            $("#saveUser").val("新  增");
        }

        clearInput();

    });
</script>