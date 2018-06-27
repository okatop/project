<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--
Template Name: Geodarn
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
<head>
<title>Geodarn</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded overlay" style="background-image:url('${root}/images/demo/backgrounds/01.png');"> 
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <!-- ################################################################################################ -->
      <div id="logo" class="fl_left">
        <h1><a href="main.jsp">Geodarn</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        
			 <li><a href="/Mainpage/recruit.jsp">recruit</a></li>
			 <li><a href="/Mainpage/community.jsp">community</a>
              <li><a href="/Mainpage/community.jsp">stage</a></li>
              <li><a href="pages/sidebar-left.html">funding</a></li>
              <li><a href="pages/sidebar-right.html">Q&A</a></li>
              <li><a href="pages/basic-grid.html">LOGIN</a></li>
           
          
         
      </nav>
      <!-- ################################################################################################ -->
    </header>
  </div>
  <!-- ################################################################################################ -->
  <!-- 여기서부터 배너 -->
  <!-- ################################################################################################ -->
  <div id="pageintro" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider basicslider">
      <ul class="slides">
        <li>
          <article>
            <p>Ullamcorper</p>
            <h3 class="heading">Maecenas nulla tellus</h3>
            <p>Vitae lobortis id ut mi in molestie in</p>
            <footer><a class="btn" href="#">Venenatis curabitur</a></footer>
          </article>
        </li>
        <li>
          <article>
            <p>Scelerisque</p>
            <h3 class="heading">Dolor rhoncus nullam</h3>
            <p>Augue non id quam sit amet urna lobortis</p>
            <footer><a class="btn inverse" href="#">Interdum lectus</a></footer>
          </article>
        </li>
        <li>
          <article>
            <p>Vestibulum</p>
            <h3 class="heading">Justo erat venenatis</h3>
            <p>Tempor sit amet ac nibh nullam mattis</p>
            <footer><a class="btn" href="#">Bibendum magna</a></footer>
          </article>
        </li>
      </ul>
    </div>
    <!-- ################################################################################################ -->
  </div>
  <!-- ################################################################################################ -->
</div>