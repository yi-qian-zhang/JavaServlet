<%--
  Created by IntelliJ IDEA.
  User: 15065170282
  Date: 2022/4/2
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>师资信息表</title>
</head>
<body>
<center>
    <form action="find?method=findUserByPage" method="post">
        <p>
            姓名:<input type="text" name="name1">
            <input type="submit" value="查询">
        </p>
    </form>
</center>
<table border="1px" width="800px" cellpadding="7px" cellspacing="0px"
       align="center">
    <tr>
        <th>教师编号</th>
        <th>教师姓名</th>
        <th>薪水</th>
        <th>学科</th>
        <th>风格</th>
    </tr>
    <c:forEach items="${requestScope.pageBean.list}" var="user" varStatus="index">
        <tr>
            <td>${user.tid}</td>
            <td>${user.tname}</td>
            <td>${user.salary}</td>
            <td>${user.subject}</td>
            <td>${user.style}</td>
        </tr>
    </c:forEach>
</table>
<p align="center">
    <a href="find?method=findUserByPage">
        首页</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <c:if test="${requestScope.pageBean.currentPage == 1}">
        <a href="#">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${requestScope.pageBean.currentPage > 1}">
        <a href="find?method=findUserByPage&currentPage=${requestScope.pageBean.currentPage}&rows=${requestScope.pageBean.rows}}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${requestScope.pageBean.currentPage ==requestScope.pageBean.totalPage}">
        <a href="#">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${requestScope.pageBean.currentPage <requestScope.pageBean.totalPage}">
        <a href="find?method=findUserByPage&currentPage=${requestScope.pageBean.currentPage+1}&rows=${requestScope.pageBean.rows}">下一页
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <a href="find?method=findUserByPage&currentPage=${requestScope.pageBean.totalPage}&rows=${requestScope.pageBean.rows}}">尾页
    </a>&nbsp;&nbsp;&nbsp;&nbsp;
    当前 ${requestScope.pageBean.currentPage} 页 &nbsp;&nbsp;
    总条数 ${requestScope.pageBean.totalCount} &nbsp;&nbsp;
    每页显示${requestScope.pageBean.rows} &nbsp;&nbsp;
    共 ${requestScope.pageBean.totalPage} 页
</p>
</body>
</html>