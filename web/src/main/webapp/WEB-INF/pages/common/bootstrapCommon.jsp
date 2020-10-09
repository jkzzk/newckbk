<%--
    使用bootstrap的公共样式
    作者：闫慧彬
    时间：2019.06.27
--%>
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

<!--[if lt IE 9]>
<script type="text/javascript" src="${ctx}/lib/html5shiv.js"></script>
<script type="text/javascript" src="${ctx}/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap3.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/style.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap-table.min.css">

<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/weUI.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/dist/themes/default/style.min.css">



<!--[if IE 6]>
<script type="text/javascript" src="${ctx}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${ctx}/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jstree.js"></script>
<script type="text/javascript" src="${ctx}/static/h-ui/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${ctx}/static/h-ui/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/bootstrap3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript" src="${ctx}/lib/common/common.js?v=1.2"></script>