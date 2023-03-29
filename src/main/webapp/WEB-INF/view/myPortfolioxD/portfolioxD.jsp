<%--
  Created by IntelliJ IDEA.
  User: 38099
  Date: 29.03.2023
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <title>Portfolio</title>

    <%--  підлючимо шрифт--%>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap"
          rel="stylesheet">
    <%--  підключаємо іконки--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <%--  підключимо файл зі стилями--%>
    <link href="<c:url value="/resources/css/portfolio.css"/>" rel="stylesheet"/>
</head>

<body>
<header class="header">
    <a class="header__logo logo" href="#">Web Site Romaniuk Vlad</a>
</header>

<div class="hero">
    <div class="container hero__container">
        <div class="hero__about">
            <h1 class="hero__title">
                Java Developer
            </h1>
            <h2 class="hero__subtitle">
                Romaniuk Vlad
            </h2>
            <p class="hero__description">I`m study java</p>
                <div class="hero__links">
                    <a href="#" class="hero__link">
                        <i class='bx bxl-facebook-square'></i>
                    </a>
                    <a href="#" class="hero__link">
                        <i class='bx bxl-twitter'></i>
                    </a>
                    <a href="#" class="hero__link">
                        <i class='bx bxl-instagram'></i>
                    </a>
                </div>
        </div>
        <div class="hero__box">
            <img class="hero__box-img" src="mypn.png" alt="valorant pro  player">
        </div>
    </div>
</div>

</body>

</html>
