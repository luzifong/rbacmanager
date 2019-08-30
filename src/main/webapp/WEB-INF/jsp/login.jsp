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
    <form action="/login" method="POST">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value=""></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" value=""></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>

</div>