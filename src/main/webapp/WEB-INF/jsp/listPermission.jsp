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
    <form action="" method="POST">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>添加权限</td>
                <td><input type="text" name="username" value=""></td>
                <td><input type="submit" value="添加权限"></td>
            </tr>
        </table>
    </form>
    <table class="table table-striped table-bordered table-hover table-condensed" >
        <tr>
            <td>id</td>
            <td>权限名</td>
            <td>权限信息</td>
            <td>角色操作</td>
        </tr>
        <c:forEach items="${permissions}" var="permission" varStatus="st">
            <tr>
                <td>${permission.permission_id}</td>
                <td>${permission.permission_name}</td>
                <td>${permission.permission_info}</td>
                <td><a class="delete" href="/permissions/${permission.permission_id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>

    <form id="formdelete" action="" method="POST" >
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>