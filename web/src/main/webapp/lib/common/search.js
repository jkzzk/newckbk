/**
 * 选择搜索条件进行查询
 * */
$("#searchType").change(function (e) {
    $("#searchContent").attr("name",$("#searchType").val())
})