'use strict';

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var res = {
    pageSize: 999,
    pageNumber: 1,
    data: {
        status: 3
    }
};
var obj = {
    pageSize: 999,
    pageNumber: 1,
    data: {}
};
var obj1 = {
    pageSize: 999,
    pageNumber: 1,
    data: {}
};
var obj2 = {
    pageSize: 10,
    pageNumber: 1,
    data: {}
};
var obj3 = {
    pageSize: 10,
    pageNumber: 1,
    data: {}
};
var objs = {
    pageSize: 10,
    pageNumber: 1,
    data: {}
};

var Collision = ''; //撞
var unit = '';
var nametext = '';
var zname = '';
var tablegetid;
var docheight = window.screen.availHeight;

$('#btn_add').hide();
$('.ables').attr('disabled', true);
$('.unitables').attr('disabled', true);
queryselect('/common/queryHouseUse', setHouseUse);
function queryselect(url, callback) {
    $.ajax({
        url: url,
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        success: function success(data) {
            callback(data);
        },
        error: function error(data) {
            alert("错误");
        }
    });
}
function setHouseUse(obj) {
    obj.data.forEach(function (element) {
        var str = '<option value=' + element.id + '>' + element.name + '</option>';
        $(str).appendTo('.organizationCodeValidityPeriod');
        // $(str).appendTo('#houseusexg')
    });
}
function queryselect(url, callback) {
    $.ajax({
        url: url,
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        success: function success(data) {
            callback(data);
        },
        error: function error(data) {
            alert("错误");
        }
    });
}
$('#jstreedom').css('height', docheight + 'px');

$('#jstreeadd').jstree({
    "core": {
        "data": querytree,
        "themes": {
            "variant": "large", //加大
            "ellipsis": true //文字多时省略
        },
        "check_callback": true
    },
    "contextmenu": {
        select_node: false,
        show_at_node: true,
        items: {
            "新建设备": {
                "label": "新建菜单",
                "icon": "glyphicon glyphicon-plus"
                //   "action": create
            }
        }
    },
    "plugins": ["wholerow", "themes", "contextmenu", "dnd", "state", "types"],
    types: {
        "default": {
            // clickable: true,
            // draggable: false,    //设置节点不可拖拽  
            icon: "../static/img/project.png"

        },
        "treeitem": {
            // valid_children: "folder", //设置下级节点类型，可是数组  
            icon: "../static/img/Block.png" //设置当前节点icon图片,路径自己决定  

        },
        "unit": {
            // valid_children: "folder", //设置下级节点类型，可是数组  
            icon: "../static/img/unit.png" //设置当前节点icon图片,路径自己决定  

        }

    }
}).bind("select_node.jstree", function (event, data) {

    var inst = data.instance;
    var selectedNode = inst.get_node(data.selected);
    var level = $("#" + selectedNode.id).attr("aria-level");
    console.log(selectedNode);
    console.log(level);
    if (level == 1) {
        loadConfig(inst, selectedNode);
        $('.ables').attr('disabled', true);
        $('.unitables').attr('disabled', true);
        zname = selectedNode.text;
    } else if (level == 2) {
        loadConfig2(inst, selectedNode);
        Collision = selectedNode.id;
        if (selectedNode.children.length == 0) {
            unit = '';
        }
        $('.ables').attr('disabled', false);
        $('.unitables').attr('disabled', true);
    } else {
        gethouselist(inst, selectedNode);
        $('#naturalBuildingId').val(selectedNode.id);
        unit = selectedNode.id;
        $('#allopenhousebtn').attr('disabled', true);
        $('.unitables').attr('disabled', false);
    }
    nametext = selectedNode.text;
    console.log(nametext);
    $('#Collision').val(Collision);
    $('#unit').val(unit);

    tablegetid = selectedNode.original.text;
}).bind("activate_node.jstree", function (obj, e) {
    // 处理代码
    // 获取当前节点

    var currentNode = e.node;
}).on('changed.jstree', function (event, data) {});

function querytree(obj, cb) {
    $.ajax({
        async: false,
        type: "POST",
        url: "/propertyProjectRegistr/page",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(res),
        dataType: "json",
        success: function success(re) {
            var items = [];
            for (var i = 0; i < re.data.list.length; i++) {
                var oj = {};
                oj.id = re.data.list[i].id;
                oj.text = re.data.list[i].projName;
                items.push(oj);
            }
            cb.call(this, items);
        },
        error: function error() {
            // alert('请求失败');
        }
    });
}

function loadConfig(inst, selectedNode) {
    obj1.data.propertyProjectRegistrId = selectedNode.id;
    $.ajax({
        url: "/naturalBuilding/page",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(obj1),
        dataType: "json",
        type: "post",
        success: function success(data) {
            selectedNode.children = [];
            $.each(data.data.list, function (i, item) {
                var oj = {};
                oj.id = item.id;
                oj.text = item.naturalBuildingName;
                oj.parent = item.id;
                oj.state = { "disabled": false, "opened": true, "selected": false };
                oj.deep = item.deep;
                oj.number = item.number;
                oj.year = item.year;
                oj.belongs = item.belongs;
                oj.dutyUnitName = item.dutyUnitName;
                oj.type = "treeitem";
                //$('#jstree_div').jstree('create_node', selectedNode, obj, 'last');

                inst.create_node(selectedNode, oj, "last");
            });
            inst.open_node(selectedNode);
            $table.bootstrapTable('load', []);
        }
    });
}

function loadConfig2(inst, selectedNode) {
    console.log(selectedNode);
    obj2.data.naturalBuildingId = selectedNode.id;
    obj3.data.naturalBuildingId = selectedNode.id;
    $.ajax({
        url: "/unitOfBuilding/page",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(obj3),
        dataType: "json",
        type: "post",
        success: function success(data) {
            console.log(111111111111111111 + data);
            listdata = data;
            if (data.data.list.length == 0) {
                $.ajax({
                    url: "/householdsOfUnit/page",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(obj3),
                    dataType: "json",
                    type: "post",
                    success: function success(data) {
                        $table.bootstrapTable('load', data.data);
                    }
                });
            } else {
                selectedNode.children = [];
                $.each(data.data.list, function (i, item) {
                    var oj = {};
                    oj.id = item.id;
                    oj.text = item.name;
                    oj.parent = item.id;
                    oj.state = { "disabled": false, "opened": true, "selected": false };
                    oj.deep = item.deep;
                    oj.number = item.number;
                    oj.year = item.year;
                    oj.belongs = item.belongs;
                    oj.dutyUnitName = item.dutyUnitName;
                    oj.type = "unit";
                    //$('#jstree_div').jstree('create_node', selectedNode, obj, 'last');

                    inst.create_node(selectedNode, oj, "last");
                });
                inst.open_node(selectedNode);

                $table.bootstrapTable('load', []);
            }
        }
    });
}
var listdata;
var naturaid;
function gethouselist(inst, selectedNode) {
    naturaid = selectedNode;
    console.log($table.bootstrapTable("getOptions"));
    obj2 = {
        pageNumber: 1,
        pageSize: $table.bootstrapTable("getOptions").pageSize,
        data: {
            unitOfBuildingId: selectedNode.id,
            naturalBuildingId: selectedNode.parent
        }
    };

    $.ajax({
        url: "/householdsOfUnit/page",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(obj2),
        dataType: "json",
        type: "post",
        success: function success(data) {

            $table.bootstrapTable('load', data.data);
        }
    });
}

//添加户
$("#addRecord").click(function () {

    var adddata = $("#addForm").serializeObject();
    $.ajax({
        url: "/householdsOfUnit/addHouseholdsOfUnitInfo",
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(adddata),
        success: function success(data) {
            layer.msg("添加成功");
            var timer = setTimeout(function () {
                clearTimeout(timer);
                window.location.reload();
            }, 1000);
            // $table.bootstrapTable('load', data.data)
        },
        error: function error(data) {
            alert("错误");
        }
    });
});
//公共查询
function queryByPage(obj, url, callback) {
    $.ajax({
        async: false,
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(obj),
        dataType: "json",
        success: function success(re) {
            callback(re);
        },
        error: function error() {
            // alert('请求失败');
        }
    });
}
//查询回调
function getlist(reval) {
    var revalnew = reval.data;
    $table.bootstrapTable('load', revalnew);
}
//创建按钮
function AddFunctionAlty() {
    return ['<span id="TableEditor" class="glyphicon glyphicon-pencil edit" title="修改" data-toggle="modal" data-target="#editModal"></span>' + '<span id="TableDeletor" class="glyphicon glyphicon-remove del" title="删除"></span>'].join("");
}
//按钮事件
window.operateEvents = {
    "click #TableEditor": function clickTableEditor(e, value, row, index) {

        $('#editForm input').each(function (index, element) {
            var setval = $(this).attr('name');
            $(this).val(row[setval]);
        });
        $('#editForm select').each(function (index, element) {
            var setval = $(this).attr('name');
            $(this).val(row[setval]);
        });

        // $('#presetroletextxg').val(oInputext)

    },
    "click #TableDeletor": function clickTableDeletor(e, value, row, index) {
        delajx([row.id], "/householdsOfUnit/dummyRemoveHouseholdsOfUnitByIdArr", delDom(row.id));
    }
};

var $table = $("#natBuilding");
var itable = TableInit(); //.初始化Table
//初始化table
function TableInit() {
    var _$table$bootstrapTabl;

    $table.bootstrapTable((_$table$bootstrapTabl = {
        toolbar: '#toolbar', //工具列
        uniqueId: 'id', // 绑定ID，不显示
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        sortable: true, //是否启用排序
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        undefinedText: '--',
        showFullscreen: false, //全屏按钮
        showColumns: true, //是否显示 内容列下拉框
        showRefresh: true }, _defineProperty(_$table$bootstrapTabl, 'showColumns', true), _defineProperty(_$table$bootstrapTabl, 'strictSearch', true), _defineProperty(_$table$bootstrapTabl, 'clickToSelect', false), _defineProperty(_$table$bootstrapTabl, 'pagination', true), _defineProperty(_$table$bootstrapTabl, 'pageNumber', 1), _defineProperty(_$table$bootstrapTabl, 'pageSize', 10), _defineProperty(_$table$bootstrapTabl, 'pageList', [5, 10, 20, 50, 100]), _defineProperty(_$table$bootstrapTabl, 'paginationPreText', "上一页"), _defineProperty(_$table$bootstrapTabl, 'paginationNextText', "下一页"), _defineProperty(_$table$bootstrapTabl, 'paginationLoop', false), _defineProperty(_$table$bootstrapTabl, 'dataField', "list"), _defineProperty(_$table$bootstrapTabl, 'exportTypes', ['excel', 'json', 'txt', 'csv', 'xml']), _defineProperty(_$table$bootstrapTabl, 'Icons', 'glyphicon-export'), _defineProperty(_$table$bootstrapTabl, 'columns', [{
        title: "全选",
        field: "select",
        checkbox: true
    }, {
        field: 'naturalBuildingName',
        title: '幢',
        switchable: true,
        visible: true
    }, {
        field: 'unitOfBuildingName',
        title: '单元',
        switchable: true,
        visible: true
    }, {
        field: 'houseNumber',
        title: '房号',
        switchable: true,
        visible: true
    }, {
        field: 'houseLocatedFloors',
        title: '该户所在楼层',
        switchable: true,
        visible: true
    }, {
        field: 'houseSize',
        title: '面积',
        switchable: true,
        visible: true
    }, {
        field: 'houseForecastSize',
        title: '预测面积',
        switchable: true,
        visible: true
    }, {
        field: 'usageNameOfHouse',
        title: '用途',
        switchable: true
    }, {
        field: 'statusId',
        title: '操作',
        switchable: true,
        events: operateEvents, // 给按钮注册时间
        formatter: AddFunctionAlty // 表格中增加按钮
    }]), _defineProperty(_$table$bootstrapTabl, 'onPageChange', function onPageChange(num, size) {

        // console.log(num+','+size)
        obj2.data.naturalBuildingId = naturaid.parents[0];
        obj2.data.unitOfBuildingId = unit;
        obj2.pageNumber = num;
        obj2.pageSize = size;

        // queryByPage(obj2, "/unitOfBuilding/page", getlist)
        $.ajax({
            url: "/householdsOfUnit/page",
            dataType: "json",
            type: "post",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(obj2),
            success: function success(data) {
                getlist(data);
            },
            error: function error(data) {
                alert("错误");
            }
        });
    }), _$table$bootstrapTabl));
};

//批量删除
function BtchDeleteBook() {
    var rows = $table.bootstrapTable('getSelections');
    console.log(rows);
    if (rows.length == 0) {
        layer.alert('请选择将要删除的内容');
        return;
    }
    layer.confirm('确定要删除吗？', {
        btn: ['确定', '取消'] //按钮
    }, function () {

        var idArr = rows.map(function (it) {
            return it.id;
        });

        delajx(idArr, "/householdsOfUnit/dummyRemoveHouseholdsOfUnitByIdArr", function (data) {
            if (data.code == 1) {
                alert("已删除");
                $table.bootstrapTable('remove', { field: "id", values: idArr });
                window.location.reload();
            } else {
                alert("失败");
            }
        });
    });
}
//删除请求
function delajx(arr, url, cb) {
    $.ajax({
        async: false,
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(arr),
        dataType: "json",
        success: function success(re) {
            cb(re);
        },
        error: function error() {
            // alert('请求失败');
        }
    });
}
//删除
function delDom(delid) {
    layer.msg('操作成功');
    $table.bootstrapTable('removeByUniqueId', delid);
}
//修改
$('#editRecord').click(function () {
    // $('.close').click()
    var editdata = $("#editForm").serializeObject();
    $.ajax({
        url: "/householdsOfUnit/editHouseholdsOfUnitById",
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(editdata),
        success: function success(data) {
            layer.msg('操作成功');
            $('.close').click();
            // var timer = setTimeout(function () {
            //     clearTimeout(timer)
            //     window.location.reload()
            // }, 1000)
        },
        error: function error(data) {
            alert("错误");
        }
    });
});

function jump_quota() {
    console.log(Collision);
    var index = layer.load(0, { shade: false, time: 1000 });
    var timer = setTimeout(function () {
        clearTimeout(timer);
        layer.open({
            type: 2,
            title: '业主开户',
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '70%'],
            content: "/householdsOfUnit/batchAddHouseholdsOfUnitView?buildingId=" + Collision + unit
        });
    }, 500);
}

function jump_quota2() {
    console.log(Collision);
    var index = layer.load(0, { shade: false, time: 1000 });
    var timer = setTimeout(function () {
        clearTimeout(timer);
        layer.open({
            type: 2,
            title: '业主开户',
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '70%'],
            content: "/householdsOfUnit/batchAddHouseholdsOfUnitView2?buildingId=" + Collision + unit
        });
    }, 500);
}