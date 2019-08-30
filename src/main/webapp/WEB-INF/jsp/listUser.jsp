<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<div align="center">

</div>

<div style="width:800px;margin:20px auto;text-align: center">
    <%@include file="top.jsp"%>
    <form action="/users" method="POST">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>添加用户</td>
                <td><input type="text" name="username" value=""></td>
                <td><input type="submit" value="添加用户"></td>
            </tr>
        </table>
    </form>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr><a href="/users/checktoken">检查token</a></tr>
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>token可用性</td>
            <td>更新时间</td>
            <td>角色操作</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="st">
            <tr>
                <td>${user.user_id}</td>
                <td>${user.username}</td>
                <td>${user.availability}</td>
                <td>${user.updateTime}</td>
                <td><a href="/users/${user.user_id}">编辑角色</a></td>
                <td><a class="delete" href="/users/${user.user_id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <form id="formdelete" action="" method="POST" >
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>