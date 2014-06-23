#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  Date now = new Date();
  response.setDateHeader("Date", now.getTime());
  // one day old
  response.setDateHeader("Expires", now.getTime() - 86400000L);
  response.setHeader( "Pragma", "no-cache" );
  response.setHeader( "Cache-Control", "no-cache, no-store, must-revalidate" );
%>
<!doctype html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=8">
    <title>Sample GWT</title>
    <script type="text/javascript" src="${parentArtifactId}/${parentArtifactId}.nocache.js"></script>
  </head>

  <body>
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>

  </body>
</html>
