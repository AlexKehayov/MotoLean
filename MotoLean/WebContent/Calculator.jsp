<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MotoLean</title>
</head>
<body>

<%
double proportion = (Double)request.getAttribute("proportion");
double fi_real = (Double)request.getAttribute("fi_real");
double finew = (Double)request.getAttribute("finew");
double speed = (Double)request.getAttribute("speed");
double radius = (Double)request.getAttribute("radius");
String str = (String)request.getAttribute("str");

out.println("Скорост: " + String.format("%.2f", speed) + " m/s<br/>");
out.println("Радиус на завоя: " + String.format("%.2f", radius) + " m<br/>");

out.println("Фи максимално: " + String.format("%.2f", fi_real) +" deg<br/>");
out.println("Фи конкретно: " + String.format("%.2f", finew) + " deg<br/>");

out.print("Пропорция: " + String.format("%.2f", proportion) + " <br/>");
out.println(str);
%>

<a href='MotoLean1.html'>->Начало</a><br/>

</body>
</html>