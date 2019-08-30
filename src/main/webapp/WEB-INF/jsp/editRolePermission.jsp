<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<div style="width:800px;margin:20px auto;text-align: center">
    <%@include file="top.jsp"%>
    <form action="/permissions" method="PUT">
        <table class="table table-striped table-bordered table-hover table-condensed" >
            <tr>
                <td>当前角色</td>
                <td>
                    ${role.role_name}
                </td>
            </tr>
            <tr>
                <td>已拥有权限</td>
                <td>
                    <c:forEach items="${rolePermissions}" var="rolePermission">
                        <span>${rolePermission.permission_name}</span>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>所有权限</td>
                <td>
                    <input type="checkbox" name="permission_id" value="/0"> 清空所有权限
                    <c:forEach items="${permissions}" var="permission">
                        <input type="checkbox" name="permission_id" value="/${permission.permission_id}"> ${permission.permission_name}
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="hidden" name="role_id" value="${role.role_id}">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</div>