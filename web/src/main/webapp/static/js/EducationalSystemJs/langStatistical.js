// 子节点数据
var childredNode = [];

// 树查询参数
var queryTreeParam = {
    grade : '',
    academy : '',
    major : ''
}

// 统计参数
var statisticParam = {
    dataSource : '0',
    langType : '',
    examDate : '',
    statisticType : '',
    grade : '',
    academy : '',
    major : '',
    classes : ''
}

var treeOriginArr = [];

// 查询树数据
function querytreeData(obj,cb){
    $.ajax({
        async : false,
        type : "POST",
        url : "/langExam/getGradeInSchool",
        contentType: 'application/json;charset=UTF-8',
        dataType:"json",
        success:function (res) {
            let items = res.data;
            let assignTmpNodeObj = Object.assign([], items);
            treeOriginArr = concatNoRepeat(treeOriginArr,assignTmpNodeObj);
            cb.call(this, items);
        },error:function (error) {
        }
    })
}
// 获取所有考试时间
function getAllExamDate() {
    $.request({
        url : '/langExam/getAllExamDate',
        type : "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data) && res_data.length != 0) {
                $('#examDate').empty();
                var options = "";
                for(var i = 0; i < res_data.length; i++) {
                    options += '<div class="formControls col-xs-1 col-sm-1 mt-10">\n' +
                        '<input type="checkbox" class="check-box" value="\'' + res_data[i] + '\'" name="examDate">\n' +
                        '<label>' + res_data[i] + '</label>\n' +
                        '</div>';
                }
                $('#examDate').append(options);
            }
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}
// 加载其他node节点
function loadOhterNode(active_node,instance) {

    let level = active_node.node.original.level;

    let url = "";

    if(level == "0") { // 年级
        queryTreeParam.grade = active_node.node.original.text;
        url = '/langExam/getAcademy';
        loadChilrenNode(url);
    }else if(level == "1") { // 学院
        let parentNode = instance.get_node(active_node.node.parent);
        queryTreeParam.grade = parentNode.text;
        queryTreeParam.academy = active_node.node.text;
        url = '/langExam/getMajor';
        loadChilrenNode(url);
    }else if(level == "2") { // 专业
        let parentNode = instance.get_node(active_node.node.parent);
        let grandParentNode = instance.get_node(parentNode.parent);
        queryTreeParam.grade = grandParentNode.text;
        queryTreeParam.academy = parentNode.text;
        queryTreeParam.major = active_node.node.text;
        url = '/langExam/getClasses';
        loadChilrenNode(url);
    }else if(level == "3") { // 班级

    }else {
        errMsg("树形数据错误！！");
    }
}
// 查询子节点
function loadChilrenNode(url) {
    $.request({
        async : false,
        url : url,
        data : JSON.stringify(queryTreeParam),
        contentType : 'application/json;charset=UTF-8',
        type : "POST",
        dataType: 'json',
        success : function(result) {
            var res_data = result.data;
            if(Array.isArray(res_data) && res_data.length != 0 && result.code == 1) {
                childredNode = res_data;
            }else {
                childredNode = [];
            }
            let assignTmpNodeObj = Object.assign([], childredNode);
            treeOriginArr = concatNoRepeat(treeOriginArr,assignTmpNodeObj);
        },
        error:function (message) {
            console.log(message);
            errMsg("网络异常");
        }
    });
}
// 整理参数
function cleanUpParam() {
    let initParam = $('#form-member-add').serializeObject();
    let checkNodes = $('#infoTree').jstree(true).get_checked(true);
    let undeterminedNodes = $('#infoTree').jstree(true).get_undetermined(true);
    let assignOrigin = Object.assign([],treeOriginArr);
    let uncheckNodes = get_unCheckNodes(checkNodes.concat(undeterminedNodes),assignOrigin);
    let grade = [];
    let academy = [];
    let major = [];
    let classes = [];
    console.log("undeterminedNodes",undeterminedNodes);
    console.log("checkNodes",checkNodes);
    for(let i = 0; i < checkNodes.length; i++) {
        if(checkNodes[i].original.level == "0") {
            grade.push("'" + checkNodes[i].text + "'");
        }
    }
    for(let i = 0; i < undeterminedNodes.length; i++) {
        if(undeterminedNodes[i].original.level == "0") {
            grade.push("'" + undeterminedNodes[i].text + "'");
        }
    }
    for(let i = 0; i < uncheckNodes.length; i++) {
        if(uncheckNodes[i].level == "1") {
            academy.push("'" + uncheckNodes[i].text + "'");
        }else if(uncheckNodes[i].level == "2") {
            major.push("'" + uncheckNodes[i].text + "'");
        }else if(uncheckNodes[i].level == "3") {
            classes.push("'" + uncheckNodes[i].text + "'");
        }
    }

    if(ifIsNull(initParam.dataSource) != '') {
        if(Array.isArray(initParam.dataSource)) {
            statisticParam.dataSource = initParam.dataSource.join(",");
        }else {
            statisticParam.dataSource = initParam.dataSource;
        }
    }else {
        errMsg("请选择数据基数！");
        return false;
    }
    if(ifIsNull(initParam.langType) != '') {
        if(Array.isArray(initParam.langType)) {
            statisticParam.langType = initParam.langType.join(",");
        }else {
            statisticParam.langType = initParam.langType;
        }
    }else {
        errMsg("请选择语种类别！");
        return false;
    }
    if(ifIsNull(initParam.examDate) != '') {
        if(Array.isArray(initParam.examDate)) {
            statisticParam.examDate = initParam.examDate.join(",");
        }else {
            statisticParam.examDate = initParam.examDate;
        }
    }else {
        errMsg("请选择考试时间！");
        return false;
    }
    if(ifIsNull(initParam.statisticType) != '') {
        if(Array.isArray(initParam.statisticType)) {
            statisticParam.statisticType = initParam.statisticType.join(",");
        }else {
            statisticParam.statisticType = initParam.statisticType;
        }
    }else {
        errMsg("请选择统计类型！");
        return false;
    }
    statisticParam.grade = grade.join(",");
    statisticParam.academy = academy.join(",");
    statisticParam.major = major.join(",");
    statisticParam.classes = classes.join(",");

    return true;
}

$(function () {
    // 获取所有考试时间
    getAllExamDate();

    // 折叠控件渲染
    $('dl#my-foldpanel').foldpanel({
        init:false,     	 //是否开启初始化功能,默认关闭
        init_index: 0, // 传的数字代表初始化展开的索引，0就是第一个
        time: 400, // panel展开动画时间, 默认为 100ms
        dbclose: true // 在此点击关闭, 默认为 true
    });

    // 树形控件
    $('#infoTree').jstree({
        "core":{
            "data":querytreeData,
            "themes": {
                "ellipsis": true //文字多时省略
            },
            "check_callback": true
        },
        "contextmenu": {
            select_node: false,
            show_at_node: true,
        },
        "plugins": ["themes", "state", "types","checkbox"]
    }).bind("activate_node.jstree",function (event,node) {
        let active_node = node;
        let instance = node.instance;
        loadOhterNode(active_node,instance);
        let childrenDom = instance.get_children_dom(active_node.node);
        let childrenNodes = [];
        $.each(childrenDom, function(index, ele) {
            childrenNodes.push(instance.get_node(ele))
        });
        instance.delete_node(childrenNodes);
        for(let i = 0; i < childredNode.length; i++) {
            instance.create_node(active_node.node, childredNode[i], "last");
        }
        instance.open_node(active_node.node);
        childredNode = [];
    });

    // 统计并导出
    $('#statisticAndExport').click(function () {
        // window.open("/langExam/exportStatistic");
        $('#loadingToast').show();
        setTimeout(function () {
            if(cleanUpParam()) {
                // console.log("statisticParam",statisticParam);
                /*            $('#loadingToast').show();
                            setTimeout(function () {
                                window.open("/langExam/exportStatistic");
                                $('#loadingToast').hide();
                            },1000);*/
                $.request({
                    async : false,
                    url : '/langExam/statisticReport',
                    data : JSON.stringify(statisticParam),
                    contentType : 'application/json;charset=UTF-8',
                    type : "POST",
                    dataType: 'json',
                    success : function(result) {
                        if(result.code == 1) {
                            // 导出excel
                            window.open("/langExam/exportStatistic");
                        }else {
                            // 导出失败
                            if(ifIsNull(result.msg) == '') {
                                errMsg("统计失败！")
                            }else {
                                errMsg(result.msg);
                            }
                        }
                        setTimeout(function () {
                            $('#loadingToast').hide();
                        },500)
                    },
                    error:function (message) {
                        $('#loadingToast').hide();
                        console.log(message);
                        errMsg("网络异常");
                    }
                });
            }else {
                $('#loadingToast').hide();
            }
        },50);
    });
});