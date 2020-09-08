<%@ page language="java" pageEncoding="utf-8" %>
<c:if test="${not empty page}">
    <div class="mt-20">
        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
            <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">共 <font color="red">${page.total}</font> 条记录&nbsp;
                , 每页显示
                <select name="pageSize" class="input-text" style="width: 80px;border-radius: 4px;" onchange="pageSize(this)">
                    <option value="10"<c:if test="${page.pageSize == '10'}">selected</c:if>>10</option>
                    <option value="20"<c:if test="${page.pageSize == '20'}">selected</c:if>>20</option>
                    <option value="50"<c:if test="${page.pageSize == '50'}">selected</c:if>>50</option>
                    <option value="100"<c:if test="${page.pageSize == '100'}">selected</c:if>>100</option>
                </select> 条记录  &nbsp;当前第
                <input id="pns" onchange="pn(this)" type="text" class="input-text" style="width: 80px;border-radius: 4px;" value="${page.pageNum}" name="pn"> 页，共${page.pages}页   &nbsp;&nbsp;&nbsp;<a
                        href="javascript:;" class="btn btn-primary radius" onclick="goPage($('#pns').val())">跳转</a>
            </div>
            <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
                <c:choose>
                    <c:when test="${page.pageNum <= 1}">
                        <span class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" id="DataTables_Table_0_previous">上一页</span>
                    </c:when>
                    <c:otherwise>
                        <a href="javascript:;" class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" id="DataTables_Table_0_previous" onclick="goPage(${page.pageNum - 1});">上一页</a>
                    </c:otherwise>
                </c:choose>
                <c:set var="pre" value="3"/>
                <c:set var="next" value="5"/>
                <c:if test="${(page.pages >= pre + next) && (page.pageNum > pre + 1)}">
                    <a href="javascript:;" class="paginate_button current" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0" onclick="goPage(1);">1</a>
                    <c:if test="${(page.pageNum > pre + 2)}">
                        <span>...</span>
                    </c:if>
                </c:if>
                <c:forEach begin="1" end="${page.pages}" var="i">
                    <c:if test="${(page.pages < pre + next) || ((i >= page.pageNum - pre) && (i <= page.pageNum + next))}">
                        <c:choose>
                            <c:when test="${(i == page.pageNum)}">
                                <span class="paginate_button current" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">${i}</span>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:;" onclick="goPage(${i});">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:forEach>
                <c:if test="${(page.pages >= pre + next) && (page.pageNum < page.pages - next)}">
                    <c:if test="${(page.pageNum < page.pages - next - 1)}">
                        <span>...</span>
                    </c:if>
                    <a href="javascript:;" class="paginate_button current" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0" onclick="goPage(${page.pages});">${page.pages}</a>
                </c:if>
                <c:choose>
                    <c:when test="${(page.pageNum >= page.pages)}">
                        <span class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" id="DataTables_Table_0_next">下一页</span>
                    </c:when>
                    <c:otherwise>
                        <a href="javascript:;" class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" id="DataTables_Table_0_next" onclick="goPage(${page.pageNum + 1});">下一页</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <script>
        function goPage(pn) {
            document.getElementById("pn").value = pn;
            document.forms[0].submit();
        }
        function pageSize(self) {
            document.getElementById("pageSize").value = self.value;
        }
        function pn(self){
            document.getElementById("pn").value = self.value;
        }
    </script>
</c:if>  