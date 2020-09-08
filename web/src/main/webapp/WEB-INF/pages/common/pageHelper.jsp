<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<DIV
        style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right ;padding-right: 40px ; ">
    共[<B >${pageInfo.total}</B>]条记录,[<B>${pageInfo.pageNum}/${pageInfo.pages}</B>]页
    ,每页显示
    <select id="pageSize_select" name="pageSize"  onchange="submitForm('pageSize',$('#pageSize_select option:selected').val())" >
        <option value="10" ${pageInfo.pageSize==10?'selected':''} >10</option>
        <option value="20" ${pageInfo.pageSize==20?'selected':''} >20</option>
        <option value="30" ${pageInfo.pageSize==30?'selected':''} >30</option>
    </select>
    条
    <c:if test="${!pageInfo.isFirstPage}">
        [<A href="javascript:void(0)" onclick="submitForm('currentPage',${pageInfo.firstPage})" >首页</A>]
        [<A href="javascript:void(0)" onclick="submitForm('currentPage',${pageInfo.prePage})" >前一页</A>]
    </c:if>
    <B>${pageInfo.pageNum}</B>
    <c:if test="${!pageInfo.isLastPage}">
        [<A href="javascript:void(0)" onclick="submitForm('currentPage',${pageInfo.nextPage})" >后一页</A>]
        [<A href="javascript:void(0)" onclick="submitForm('currentPage',${pageInfo.lastPage})" >末页</A>]
    </c:if>
    到
    <input style="width: 10px;height: 15px" type="text" size="3" id="page" name="page" value="${pageInfo.pageNum}" />
    页;

    <input type="button" value="Go" onclick="submitForm('currentPage',$('#page').val())"/>
</DIV>