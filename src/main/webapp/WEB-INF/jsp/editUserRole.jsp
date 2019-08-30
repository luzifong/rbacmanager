<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<div style="width:800px;margin:20px auto;text-align: center">
    <%@include file="top.jsp"%>
    <form action="/roles" method="PUT">
        <table class="table table-striped table-bordered table-hover table-condensed" >
            <tr>
                <td>当前用户</td>
                <td>
                    ${user.username}
                </td>
            </tr>
            <tr>
                <td>已拥有角色</td>
                <td>
                    <c:forEach items="${userRoles}" var="userRole">
                        <span>${userRole.role_name}</span>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>所有角色</td>
                <td>
                    <input type="checkbox" name="role_id" value="/0"> 清空所有角色
                    <c:forEach items="${roles}" var="role">
                        <input type="checkbox" name="role_id" value="/${role.role_id}"> ${role.role_name}
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    设置有效期
                </td>
                <td>
                    <input type="text" name="expires" value="">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="hidden" name="user_id" value="${user.user_id}">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
    <form id="formEditUserRole" action="" method="POST" >
        <input type="hidden" name="_method" value="PUT">
    </form>
</div>