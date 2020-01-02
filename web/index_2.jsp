
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.example.demo.*" %>
<%@ page import="com.example.demo.service.Chef" %>
<%@ page import="com.example.demo.service.impl.ChefImpl" %>
<%@ page import="com.example.demo.entity.Food" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    Chef chef = new ChefImpl();
    out.println("服务员接收到食物");
    Food food = chef.cookEggplant(name);
    out.println("后端做好食物");
    out.println(food);
    out.println("服务员将食物传递给客人");
%>

</body>
</html>
