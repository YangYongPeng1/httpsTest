<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form>
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>${items.name }</td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td>${items.price }</td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>${items.createtime}</td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td>${items.detail}</td>
        </tr>
    </table>
</form>
</body>

</html>