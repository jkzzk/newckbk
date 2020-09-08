<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/fn.tld" prefix="fn" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="ctx" value="<%=basePath %>"/>

<script>
    var CTX = "<%=basePath %>";
</script>

<link rel="stylesheet" type="text/css" href="${ctx}/static/mobile/css/hui.css" />

<script type="text/javascript" src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/mobile/js/common.js"></script>
<script type="text/javascript" src="${ctx}/static/mobile/js/hui.js"></script>
<script type="text/javascript" src="${ctx}/static/mobile/js/hui-accordion.js"></script>
<script type="text/javascript" src="${ctx}/static/mobile/js/hui-form.js"></script>
