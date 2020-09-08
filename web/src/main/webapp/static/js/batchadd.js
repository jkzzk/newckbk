"use strict";

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

//  房屋性质 : /common/queryHouseNature
//  房屋用途 :/common/queryHouseUse
//  交存主体 :/depositedSubject/getDepositedSubjectList enabled-1
//  获取银行 :/bankInfo/getBankInfoList enable-1
//  交存模式 :/depositMode/getDepositModeList enable-true
function publicQueryOfData(obj, url, cb) {
    $.ajax({
        async: false,
        url: url,
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(obj),
        success: function success(result) {
            cb(result);
        },
        error: function error(data) {
            alert("错误");
        }
    });
}
function publicQuery(url, cb) {
    $.ajax({
        async: false,
        url: url,
        dataType: "json",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        success: function success(result) {
            cb(result);
        },
        error: function error(data) {
            alert("错误");
        }
    });
}

function queryHouseUse(res) {
    //房屋用途
    res.data.forEach(function (element) {
        var str = "<option value=" + element.id + ">" + element.name + "</option>";
        $(str).appendTo('#queryHouseUse');
    });
}
// function getDepositedSubjectList(res) {//交存主体
//     res.data.forEach(element => {
//         var str = `<option value=${element.id}>${element.name}</option>`
//         $(str).appendTo('#getDepositedSubjectList')
//     });
// }
// function getBankInfoList(res) {//获取银行
//     res.data.forEach(element => {
//         var str = `<option value=${element.id}>${element.bankName}</option>`
//         $(str).appendTo('#getBankInfoList')
//     });
// }
// function getDepositModeList(res) {//交存模式
//     res.data.forEach(element => {
//         var str = `<option value=${element.id}>${element.modeName}</option>`
//         $(str).appendTo('#getDepositModeList')
//     });
// }
publicQuery('/common/queryHouseNature', queryHouseNature); //房屋性质
publicQuery('/common/queryHouseUse', queryHouseUse); //房屋用途
// publicQueryOfData({ enabled: 1 }, '/depositedSubject/getDepositedSubjectList', getDepositedSubjectList) //交存主体
// publicQueryOfData({ enable: 1 }, '/bankInfo/getBankInfoList', getBankInfoList) //获取银行
// publicQueryOfData({ enable: true }, '/depositMode/getDepositModeList', getDepositModeList) //交存模式


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
        showColumns: false, //是否显示 内容列下拉框
        showRefresh: false }, _defineProperty(_$table$bootstrapTabl, "showColumns", false), _defineProperty(_$table$bootstrapTabl, "strictSearch", true), _defineProperty(_$table$bootstrapTabl, "clickToSelect", false), _defineProperty(_$table$bootstrapTabl, "pagination", false), _defineProperty(_$table$bootstrapTabl, "pageNumber", 1), _defineProperty(_$table$bootstrapTabl, "pageSize", 10), _defineProperty(_$table$bootstrapTabl, "pageList", [5, 10, 20, 50, 100]), _defineProperty(_$table$bootstrapTabl, "paginationPreText", "上一页"), _defineProperty(_$table$bootstrapTabl, "paginationNextText", "下一页"), _defineProperty(_$table$bootstrapTabl, "paginationLoop", false), _defineProperty(_$table$bootstrapTabl, "dataField", "list"), _defineProperty(_$table$bootstrapTabl, "exportTypes", ['excel', 'json', 'txt', 'csv', 'xml']), _defineProperty(_$table$bootstrapTabl, "Icons", 'glyphicon-export'), _defineProperty(_$table$bootstrapTabl, "columns", [{
        title: "全选",
        field: "select",
        checkbox: true
    }, {
        field: 'id',
        title: '序号',
        switchable: true,
        visible: true
    }, {
        field: 'houselocation',
        title: '自然幢',
        switchable: true,
        visible: true
    }, {
        field: 'unitOfBuildingId',
        title: '单元',
        switchable: true,
        visible: true,
        formatter: function formatter(value, row, index) {

            return "<select onchange='haha2(this)' class='houseNature'  data-index='" + index + "' data-field='unitOfBuildingId'>" + $('#queryHouseNature').clone().html() + "</select>";
        }
    }, {
        field: 'houseNatureval',
        title: '房屋性质',
        switchable: true,
        visible: false
    }, {
        field: 'usageOfHouse',
        title: '房屋用途',
        switchable: true,
        visible: true,
        formatter: function formatter(value, row, index) {
            return "<select  class='housepurpose' onchange='haha2(this)' data-index='" + index + "' data-field='usageOfHouse'>" + $('#queryHouseUse').clone().html() + "</select>";
        }
    }, {
        field: 'houseNumber',
        title: '房号',
        switchable: true,
        formatter: function formatter(value, row, index) {
            return "<input  class='' onchange='haha2(this)' data-index='" + index + "' data-field='houseNumber'/>";
        }
    }, {
        field: 'housepurposeVal',
        title: '房屋用途val',
        switchable: true,
        visible: false

    },
    // {
    //     field: 'housesubject',
    //     title: '交存主体',
    //     switchable: true,
    //     visible: true,
    //     formatter: function () {

    //         return "<select onclick='haha()' class='housesubject'>" + $('#getDepositedSubjectList').clone().html() + "</select>"

    //     }
    // },
    // {
    //     field: 'housePattern',
    //     title: '交存模式',
    //     switchable: true,
    //     visible: true,
    //     formatter: function () {

    //         return "<select onclick='haha()' class='housePattern'>" + $('#getDepositModeList').clone().html() + "</select>"

    //     }

    // },
    // {
    //     field: 'houseBack',
    //     title: '开户银行',
    //     switchable: true,
    //     visible: true,
    //     formatter: function () {

    //         return "<select onclick='haha()' class='houseBack'>" + $('#getBankInfoList').clone().html() + "</select>"

    //     }
    // },
    {
        field: 'houseLocatedFloors',
        title: '所在楼层',
        switchable: true,
        formatter: function formatter(value, row, index) {
            return "<input  class='' onchange='haha2(this)' data-index='" + index + "' data-field='houseLocatedFloors'/>";
        }
    }, {
        field: 'houseSize',
        title: '面积',
        switchable: true,
        formatter: function formatter(value, row, index) {
            return "<input  class='' onchange='haha2(this)' data-index='" + index + "' data-field='houseSize'/>";
        }
    }, {
        field: 'houseForecastSize',
        title: '预测面积',
        switchable: true,
        formatter: function formatter(value, row, index) {
            return "<input  class='' onchange='haha2(this)' data-index='" + index + "' data-field='houseForecastSize'/>";
        }
        // {
        //     field: 'houseareaVal',
        //     title: '交存面积',
        //     switchable: true,

        // },

    }]), _$table$bootstrapTabl));
};

function haha2(_this) {
    var $this = $(_this);
    console.log($this);
    var index = $this.data("index");
    console.log(index);
    var field = $this.data("field");
    console.log(field);
    var val = $this.val();
    console.log(val);
    list[index][field] = val;
    console.log(list);
}
// function haha(_this) {
//     var $this = $(_this);
//     var cid = $this.data("cid");
//     //var row = $('#natBuilding').bootstrapTable('getRowByUniqueId', cid);
//     var row = {};
//     $this.find("option:selected").attr("selected", true);
//     row.housepurpose = $this[0].outerHTML;
//     row.housepurposeVal = $this.val();

//     $('#natBuilding').bootstrapTable('updateRow', { index: cid - 1, row: row })

//     return $(_this).attr('name', $(_this).val())

// }

// function myFunction(_this) {
//     var $this = $(_this);
//     var cid = $this.data("cid");
//     //var row = $('#natBuilding').bootstrapTable('getRowByUniqueId', cid);
//     var row = {};
//     $this.attr("value", $this.val());
//     row.housearea = $this[0].outerHTML;
//     row.houseareaVal = $this.val();
//     $('#natBuilding').bootstrapTable('updateRow', { index: cid - 1, row: row })
//     return $(_this).attr('name', $(_this).val())

// }

function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}
// var getbuild = getQueryString(buildingId)
// alert(getbuild)
// /naturalBuilding/getNumberRemainingHouseholds

var getbuild = window.parent.Collision;
var getname = window.parent.nametext;
var sname = window.parent.zname;
var unitlist = window.parent.listdata;

console.log(getbuild + '--------------' + getname + '--------------' + sname + '--------------' + unitlist);
queryHouseNature(unitlist);
function queryHouseNature(res) {
    //单元

    if (res.data.list.length == 0) {
        var str = "<option value=''>\u65E0</option>";
        $(str).appendTo('#queryHouseNature');
    } else {
        var str = "<option value=''>\u65E0</option>";
        $(str).appendTo('#queryHouseNature');
        res.data.list.forEach(function (element) {
            var str = "<option value=" + element.id + ">" + element.name + "</option>";
            $(str).appendTo('#queryHouseNature');
        });
    }
}

queryTable('id=' + getbuild, '/naturalBuilding/getNumberRemainingHouseholds', createlist);
function queryTable(str, url, cb) {
    $.ajax({
        url: url,
        dataType: "json",
        type: "post",
        data: str,
        success: function success(result) {
            cb(result);
        },
        error: function error(data) {
            alert("错误");
        }
    });
}
var list = [];

function createlist(num) {

    for (var i = 0; i < num.data; i++) {
        var json = {};
        json.id = i + 1;
        json.houselocation = sname + getname;
        json.naturalBuildingId = getbuild;

        list.push(json);
    }

    $('#natBuilding').bootstrapTable('load', list);
}

$('#queryHouseNature').change(function () {
    var rows = $table.bootstrapTable('getSelections');

    if (rows.length == 0) {
        $('.houseNature').each(function (index) {
            $('.houseNature').eq(index).val($('#queryHouseNature').val());
            var index = $('.houseNature').eq(index).data("index");
            var field = $('.houseNature').eq(index).data("field");

            var val = $('.houseNature').eq(index).val();
            list[index][field] = val;
        });
        console.log(list);
    } else {
        for (var i = 0; i < rows.length; i++) {
            $('.houseNature').eq(rows[i].id - 1).val($('#queryHouseNature').val());
            var index = $('.houseNature').eq(rows[i].id - 1).data("index");
            var field = $('.houseNature').eq(rows[i].id - 1).data("field");

            var val = $('.houseNature').eq(rows[i].id - 1).val();
            list[index][field] = val;
        }
        console.log(list);
    }
});
// function haha2(_this){
//     var $this = $(_this);
//     var index = $this.data("index");
//     var field = $this.data("field");
//     var val =  $this.val();
//     list[index][field] = val;
//     console.log(list);
// }
$('#queryHouseUse').change(function () {
    var rows = $table.bootstrapTable('getSelections');
    console.log(rows);
    if (rows.length == 0) {
        $('.housepurpose').each(function (index) {
            console.log($('.housepurpose').eq(index).val());
            $('.housepurpose').eq(index).find("option:selected").attr("selected", true);
            $('.housepurpose').eq(index).val($('#queryHouseUse').val());
            var index = $('.housepurpose').eq(index).data("index");
            var field = $('.housepurpose').eq(index).data("field");
            var val = $('.housepurpose').eq(index).val();
            console.log(val);

            list[index][field] = val;
        });
        $('.housepurpose').val($('#queryHouseUse').val());
    } else {
        for (var i = 0; i < rows.length; i++) {
            $('.housepurpose').eq(rows[i].id - 1).val($('#queryHouseUse').val());
            var index = $('.housepurpose').eq(rows[i].id - 1).data("index");
            var field = $('.housepurpose').eq(rows[i].id - 1).data("field");

            var val = $('.housepurpose').eq(rows[i].id - 1).val();
            list[index][field] = val;
        }
    }

    console.log(list);
});

// $('#getDepositedSubjectList').change(function(){
//     $('.housesubject').each(function(){
//         $('.housesubject').val($('#getDepositedSubjectList').val())
//     })
// })

// $('#getDepositModeList').change(function(){
//     $('.housePattern').each(function(){
//         $('.housePattern').val($('#getDepositModeList').val())
//     })
// })

// $('#getBankInfoList').change(function(){
//     $('.houseBack').each(function(){
//         $('.houseBack').val($('#getBankInfoList').val())
//     })
// })


$('#allopenhousebtn').click(function () {
    var allTableData = $('#natBuilding').bootstrapTable('getData');

    console.log(list);
    $.ajax({
        async: false,
        type: "POST",
        url: '/householdsOfUnit/batchAddHouseholdsOfUnitInfo',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(list),
        dataType: "json",
        success: function success(re) {},
        error: function error() {
            // alert('请求失败');
        }
    });
});