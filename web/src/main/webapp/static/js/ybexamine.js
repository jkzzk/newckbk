'use strict';

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

window.operateEvents = {
  "click #TableEditor": function clickTableEditor(e, value, row, index) {
    if (row.presaleHousehold == 1) {
      row.presaleHousehold = '预售';
    } else {
      row.presaleHousehold = '分户';
    }
    if (row.unitInfoCollection == 1) {
      row.unitInfoCollection = '代收';
    } else {
      row.unitInfoCollection = '代用';
    }
    $('.createdtable').empty();
    var str = '<tbody>' + '<tr id=oseid style=display:none; typeid = ' + row.id + '></tr>' + '<tr><td> 物业开发名称 </td><td>' + row.projName + '</td></tr>' + '<tr><td> 办理预售分户 </td><td>' + row.presaleHousehold + '</td></tr>' + '<tr><td> 行政区 </td><td>' + row.regionName + '</td></tr>' + '<tr><td> 物业项目位置 </td><td>' + row.projPosition + '</td></tr>' + '<tr><td> 幢数 </td><td>' + row.buildingNumber + '</td></tr>' + '<tr><td> 总户数 </td><td>' + row.totalHouseNumber + '</td></tr>' + '<tr><td> 占地面积(平米） </td><td>' + row.floorArea + '</td></tr>' + '<tr><td> 预测面积（平米） </td><td>' + row.forecastArea + '</td></tr>' + '<tr><td> 预测面积详细信息 </td><td>' + row.forecastAreaDetailsInfo + '</td></tr>' + '<tr><td> 实测面积 </td><td>' + row.measuredArea + '</td></tr>' + '<tr><td> 办结通知书总建筑面积 </td><td>' + row.noticeTotalArea + '</td></tr>' + '<tr><td> 公司单独所有面积, </td><td>' + row.companyAllSeparateArea + '</td></tr>' + '<tr><td> 地下公共设备面积 </td><td>' + row.undergroundPublicEquipmentArea + '</td></tr>' + '<tr><td> 开发公司 </td><td>' + row.unitInfoId + '</td></tr>' + '<tr><td> 开发公司代收取 </td><td>' + row.unitInfoCollection + '</td></tr>' + '<tr><td> 开工日期 </td><td>' + row.startWorkDate + '</td></tr>' + '<tr><td> 竣工日期 </td><td>' + row.completioDate + '</td></tr>' + '<tr><td> 交房日期 </td><td>' + row.deliveryDate + '</td></tr>' + '<tr><td> 承办银行 </td><td>' + row.bankInfoName + '</td></tr></tbody>';
    $(str).appendTo('.createdtable');
  },

  "click #TableDeletor": function clickTableDeletor(e, value, row, index) {
    layer.confirm('确定要删除吗？', {
      btn: ['确定', '取消'] //按钮
    }, function () {

      var idArr = [];
      idArr.push(row.id);
      $.ajax({
        async: true,
        url: '/propertyProjectRegistr/deleteProject',
        type: "post",
        data: JSON.stringify(idArr),
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        success: function success(reval) {
          layer.msg('操作成功');
          var timer = setTimeout(function () {
            clearTimeout(timer);
            window.location.reload();
          }, 1000);
        },
        error: function error(data) {
          layer.msg('请求超时');
        }
      });
    }, function () {
      layer.msg('下次小心点', {
        time: 800 //20s后自动关闭
        // btn: [ '知道了']
      });
    });
  }
};
function AddFunctionAlty() {
  return ['<span id="TableEditor" class="glyphicon glyphicon-file files" title="备案" data-toggle="modal" data-target="#recordModal"></span>' + '<span id="TableDeletor" class="glyphicon glyphicon-remove del" title="删除"></span>'].join("");
}

var $table = $("#examine");
var itable = TableInit(); //.初始化Table
function TableInit() {
  var _$table$bootstrapTabl;

  $table.bootstrapTable((_$table$bootstrapTabl = {

    //  columns:res.data,
    //  url: 'http://jsonplaceholder.typicode.com/posts',
    //  method: 'get',

    toolbar: '#toolbar', //工具列
    uniqueId: 'id', // 绑定ID，不显示
    striped: true, //是否显示行间隔色
    cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    sortable: true, //是否启用排序
    sortOrder: "asc", //排序方式
    sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
    undefinedText: '--',
    //singleSelect: true,                  // 单选checkbox，默认为复选
    showFullscreen: true, //全屏按钮
    showColumns: true, //是否显示 内容列下拉框
    showRefresh: true }, _defineProperty(_$table$bootstrapTabl, 'showColumns', true), _defineProperty(_$table$bootstrapTabl, 'strictSearch', true), _defineProperty(_$table$bootstrapTabl, 'clickToSelect', false), _defineProperty(_$table$bootstrapTabl, 'pagination', true), _defineProperty(_$table$bootstrapTabl, 'pageNumber', 1), _defineProperty(_$table$bootstrapTabl, 'pageSize', 10), _defineProperty(_$table$bootstrapTabl, 'pageList', [5, 10, 20, 50, 100]), _defineProperty(_$table$bootstrapTabl, 'paginationPreText', "上一页"), _defineProperty(_$table$bootstrapTabl, 'paginationNextText', "下一页"), _defineProperty(_$table$bootstrapTabl, 'paginationLoop', false), _defineProperty(_$table$bootstrapTabl, 'dataField', "list"), _defineProperty(_$table$bootstrapTabl, 'exportTypes', ['excel', 'json', 'txt', 'csv', 'xml']), _defineProperty(_$table$bootstrapTabl, 'Icons', 'glyphicon-export'), _defineProperty(_$table$bootstrapTabl, 'columns', [{
    title: "全选",
    field: "select",
    checkbox: true
  }, {

    field: 'projName',
    title: '物业项目开发名称',
    switchable: true,
    visible: true
  }, {
    field: 'projPosition',
    title: '物业项目地址',
    switchable: true
  }, {
    field: 'regionName',
    title: '行政区',
    switchable: true
  }, {
    field: 'buildingNumber',
    title: '幢数',
    switchable: true,
    visible: true
  }, {
    field: 'totalHouseNumber',
    title: '总户数',
    switchable: true,
    visible: true
  }, {
    field: 'floorArea',
    title: '占地面积(平米）',
    switchable: true,
    visible: true
  }, {
    field: 'forecastArea',
    title: '预测面积（平米）',
    switchable: true,
    visible: false
  }, {
    field: 'forecastAreaDetailsInfo',
    title: '预测面积详细信息',
    switchable: true,
    visible: false
  }, {
    field: 'measuredArea',
    title: '实测面积',
    switchable: true,
    visible: false
  }, {
    field: 'noticeTotalArea',
    title: '办结通知书总建筑面积',
    switchable: true,
    visible: false
  }, {
    field: 'companyAllSeparateArea',
    title: '公司单独所有面积',
    switchable: true,
    visible: false
  }, {
    field: 'undergroundPublicEquipmentArea',
    title: '地下公共设备面积',
    switchable: true,
    visible: false
  }, {
    field: 'startWorkDate',
    title: '开工日期',
    switchable: true,
    visible: false
  }, {
    field: 'completioDate',
    title: '竣工日期',
    switchable: true,
    visible: false
  }, {
    field: 'deliveryDate',
    title: '交房日期',
    switchable: true,
    visible: false
  }, {
    field: 'bankInfoId',
    title: '承办银行',
    switchable: true,
    visible: false

  }, {
    field: 'status',
    title: '状态',
    switchable: true,
    cellStyle: function cellStyle(value, row, index) {
      if (value == 1) {

        return {
          css: {
            color: '#F0AD4E'
          }
        };
      } else if (value == 2) {
        return {
          css: {
            color: '#D9534F'
          }
        };
      } else if (value == 3) {
        return {
          css: {
            color: '#5CB85C'
          }
        };
      }
    },
    formatter: function formatter(value, row, index) {
      if (value == 1) {
        return "待审核";
      } else if (value == 2) {
        return "审核被拒绝";
      } else if (value == 3) {
        return "正常";
      }
    }
  }, {
    field: 'statusId',
    title: '操作',
    switchable: true,
    events: operateEvents, // 给按钮注册时间
    formatter: AddFunctionAlty // 表格中增加按钮
  }]), _defineProperty(_$table$bootstrapTabl, 'onPageChange', function onPageChange(num, size) {
    obj.pageNumber = num;
    obj.pageSize = size;
    queryByPage(obj, "/propertyProjectRegistr/page", getlist);
  }), _$table$bootstrapTabl));
};

// 全局变量
var obj = {
  pageSize: 10,
  pageNumber: 1,
  data: {
    status: 1
  }

  //审核
};var res = {
  ids: [],
  status: 3,
  reviewFailedReason: ''
  // 拒绝
};var self = {
  ids: [],
  status: 2,
  reviewFailedReason: ''

  // 创建Dom
};function getlist(reval) {
  var revalnew = reval.data;
  $('#examine').bootstrapTable('load', revalnew);
}
// 列表查询
function queryByPage(parameter, url, callback) {
  $.ajax({
    async: true,
    url: url,
    type: "post",
    data: JSON.stringify(parameter),
    dataType: 'json',
    contentType: 'application/json;charset=UTF-8',
    success: function success(reval) {
      callback(reval);
    },
    error: function error(data) {
      alert("错误");
    }
  });
}
queryByPage(obj, "/propertyProjectRegistr/page", getlist);

// $('#refuse').click(function () {
//   $('.openarea').show();
//   $('#toexamine').attr('disabled', true)

// })
$('#refuse').hide();
$('.areaclose').click(function () {
  $('.openarea').hide();
  $('#toexamine').attr('disabled', false);
});

$('#toexamine').click(function () {
  res.ids.length = 0;
  res.ids.push($('#oseid').attr('typeid'));

  layer.confirm('确定要通过审核？', {
    btn: ['确定', '我再想想'] //按钮
  }, function () {
    $.ajax({
      async: true,
      url: '/propertyProjectRegistr/verifyProject ',
      type: "post",
      data: JSON.stringify(res),
      dataType: 'json',
      contentType: 'application/json;charset=UTF-8',
      success: function success(reval) {
        console.log(reval);
      },
      error: function error(data) {}
    });
    layer.msg('审核通过', { icon: 1 });
  }, function () {});
});

function examineBook(res, url) {
  $.ajax({
    async: true,
    url: url,
    type: "post",
    data: JSON.stringify(res),
    dataType: 'json',
    contentType: 'application/json;charset=UTF-8',
    success: function success(reval) {
      console.log(reval);
      layer.msg('操作成功');
      $('#recordModal').modal('hide');
      var timer = setTimeout(function () {
        clearTimeout(timer);
        window.location.reload();
      }, 1000);
    },
    error: function error(data) {}
  });
}

function BtchDeleteBook() {
  var rows = $("#examine").bootstrapTable('getSelections');
  console.log(rows);
  if (rows.length == 0) {
    layer.alert('请选择将要删除的内容');
    return;
  }

  layer.confirm('确定要删除吗？', {
    btn: ['确定', '取消'] //按钮
  }, function () {

    var rows = $("#examine").bootstrapTable('getSelections');
    var idArr = rows.map(function (it) {
      return it.id;
    });
    $.ajax({
      async: true,
      url: '/propertyProjectRegistr/deleteProject',
      type: "post",
      data: JSON.stringify(idArr),
      dataType: 'json',
      contentType: 'application/json;charset=UTF-8',
      success: function success(reval) {
        layer.msg('操作成功');
        var timer = setTimeout(function () {
          clearTimeout(timer);
          window.location.reload();
        }, 1000);
      },
      error: function error(data) {
        layer.msg('请求超时');
      }
    });
  }, function () {
    layer.msg('下次小心点', {
      time: 800 //20s后自动关闭
      // btn: [ '知道了']
    });
  });
}

function BtchexamineBook() {
  res.ids.length = 0;
  var rows = $("#examine").bootstrapTable('getSelections');
  var idArr = rows.map(function (it) {
    return it.id;
  });
  res.ids = idArr;
  examineBook(res, '/propertyProjectRegistr/verifyProject');
}

$('.areasub').click(function () {

  self.ids.length = 0;
  self.ids.push($('#oseid').attr('typeid'));
  var refuseReasonmsg = $('#refuseReason').val();
  self.reviewFailedReason = refuseReasonmsg;
  if (refuseReasonmsg == '') {
    layer.msg('多少也给个理由吧！');
    retrue;
  }
  examineBook(self, '/propertyProjectRegistr/verifyProject');
});


$('.search1').click(function(){
    if($('#search-input').val() == ''){
        obj.data.projName = ''
        queryByPage(obj, "/propertyProjectRegistr/page", getlist)

    }else{
        obj.data.projName = $('#search-input').val()
        queryByPage(obj, "/propertyProjectRegistr/page", getlist)

    }

})