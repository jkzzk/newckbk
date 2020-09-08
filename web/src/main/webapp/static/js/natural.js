'use strict';
var userName = window.parent.username
var userId = window.parent.userid
function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var docheight = window.screen.availHeight;

$('#jstreedom').css('height', docheight + 'px');

dataMock('#startWorkDate');
dataMock('#presaleDate');
dataMock('#completedDate');
dataMock('#deliveryDate');
dataMock('#completedAcceptanceDate');


dataMock('#startWorkDatexg');
dataMock('#presaleDatexg');
dataMock('#completedDatexg');
dataMock('#deliveryDatexg');
dataMock('#completedAcceptanceDatexg');
var obj = {
  pageSize: 10,
  pageNumber: 1,
  data: {
    propertyProjectRegistrId: ''
  }
};
var res = {
  pageSize: 999,
  pageNumber: 1,
  data: {
    status: 3
  }
};
var res1 = {
  pageSize: 999,
  pageNumber: 1,
  data: {
    projName: ''
  }
};
var oInputext;
var arr = [];
var querydata = {};
function AddFunctionAlty(){
  return ['<span id="TableEditor" class="glyphicon glyphicon-pencil edit" title="修改" data-toggle="modal" data-target="#editModal"></span>' + '<span id="TableDeletor" class="glyphicon glyphicon-remove del" title="删除"></span>'].join("");
}
window.operateEvents = {
  "click #TableEditor": function clickTableEditor(e, value, row, index) {
    console.log(row);
    $('#editForm input').each(function (index, element) {
      var setval = $(this).attr('name');

      $(this).val(row[setval]);
      $('.applicant').val(userName)
      $('.setUserId').val(userId)
    });
    $('#editForm select').each(function (index, element) {
      var setval = $(this).attr('name');
      $(this).val(row[setval]);
    });

    $('#presetroletextxg').val(oInputext);
  },
  "click #TableDeletor": function clickTableDeletor(e, value, row, index) {
    delajx([row.id], "/naturalBuilding/deleteNaturalBuilding", delDom(row.id));
  }
};

var $table = $("#natBuilding");

var itable = TableInit(); //.初始化Table


function dataMock(id) {
  laydate.render({
    elem: id,
    trigger: 'click',
    ready: function ready(date) {
      //得到初始的日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
    }
  });
}

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
    //singleSelect: true,                  // 单选checkbox，默认为复选
    showFullscreen: true, //全屏按钮
    showColumns: true, //是否显示 内容列下拉框
    showRefresh: true }, _defineProperty(_$table$bootstrapTabl, 'showColumns', true), _defineProperty(_$table$bootstrapTabl, 'strictSearch', true), _defineProperty(_$table$bootstrapTabl, 'clickToSelect', false), _defineProperty(_$table$bootstrapTabl, 'pagination', true), _defineProperty(_$table$bootstrapTabl, 'pageNumber', 1), _defineProperty(_$table$bootstrapTabl, 'pageSize', 10), _defineProperty(_$table$bootstrapTabl, 'pageList', [5, 10, 20, 50, 100]), _defineProperty(_$table$bootstrapTabl, 'paginationPreText', "上一页"), _defineProperty(_$table$bootstrapTabl, 'paginationNextText', "下一页"), _defineProperty(_$table$bootstrapTabl, 'paginationLoop', false), _defineProperty(_$table$bootstrapTabl, 'dataField', "list"), _defineProperty(_$table$bootstrapTabl, 'exportTypes', ['excel', 'json', 'txt', 'csv', 'xml']), _defineProperty(_$table$bootstrapTabl, 'Icons', 'glyphicon-export'), _defineProperty(_$table$bootstrapTabl, 'columns', [{
    title: "全选",
    field: "select",
    checkbox: true
  }, {
    field: 'naturalBuildingName',
    title: '自然幢名称',
    switchable: true,
    visible: true
  }, {
    field: 'naturalBuildingLocation',
    title: '自然幢位置',
    switchable: true
  }, {
    field: 'status',
    title: '状态',
    switchable: true,

    formatter: function formatter(value, row, index) {
      if (value == 1) {
        return "<font color='#F0AD4E'>待审核</font>";
      } else if (value == 2) {
        return "<font color='#D9534F'>审核被拒绝</font>";
      } else if (value == 3) {
        return "<font color='#5CB85C'>正常</font>";
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
    queryByPage(obj, "/naturalBuilding/page", getlist);
  }), _$table$bootstrapTabl));
};

function getlist(reval) {
  var revalnew = reval.data;
  $table.bootstrapTable('load', revalnew);
}

function querytree(obj, cb) {
  $.ajax({
    async: false,
    type: "POST",
    url: "/propertyProjectRegistr/page",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(res),
    dataType: "json",
    success: function success(re) {
      // presetrole(re)
      querydata = re;
      for (var i = 0; i < re.data.list.length; i++) {
        var oj = {};
        oj.id = re.data.list[i].id;
        oj.text = re.data.list[i].projName;
        oj.parent = '#';
        oj.state = { "disabled": false, "opened": true, "selected": false };
        oj.deep = re.data.list[i].deep;
        oj.number = re.data.list[i].number;
        oj.year = re.data.list[i].year;
        oj.belongs = re.data.list[i].belongs;
        oj.type = "default";
        arr.push(oj);
      }

      cb.call(this, arr);
    },
    error: function error() {
      // alert('请求失败');
    }
  });
}
$('#jstree1').jstree({
  "core": {
    "data": querytree,
    "themes": {
      "variant": "large", //加大
      "ellipsis": true //文字多时省略
    },
    "check_callback": true
  },

  // "contextmenu":{
  // 	select_node:false,
  //    	show_at_node:true,
  //    	items:{
  //    		"新建设备":{  
  //                    "label":"新建菜单",  
  //                    "icon" : "glyphicon glyphicon-plus",
  //                    "action":function(data){
  //                    	var inst = $.jstree.reference(data.reference),
  // 						obj = inst.get_node(data.reference);
  // 						inst.create_node(obj, {}, "last", function (new_node) {
  // 								try {
  // 									new_node.text="新建设备";
  // 									inst.edit(new_node);
  // 								} catch (ex) {
  // 									setTimeout(function () { inst.edit(new_node); },0);
  // 								}

  // 						})

  //                   	}
  //            }, 
  //        },

  // },
  "contextmenu": {
    select_node: false,
    show_at_node: true,
    items: {
      "新建设备": {
        "label": "新建菜单",
        "icon": "glyphicon glyphicon-plus",
        "action": create
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
  loadConfig(inst, selectedNode);
}).bind("activate_node.jstree", function (obj, e) {
  // 处理代码
  // 获取当前节点
  console.log(obj);
  console.log(e);
  var currentNode = e.node;
}).on('select_node.jstree', function (event, data) {
  $('#presetroleid').val(data.node.id);
  $('#presetroletext').val(data.node.text);

  $('#presetroleidxg').val(data.node.id);
  oInputext = data.node.text;

  obj.data.propertyProjectRegistrId = data.node.id;
  $.ajax({
    url: "/naturalBuilding/page",
    dataType: "json",
    type: "post",
    contentType: 'application/json;charset=UTF-8',
    data: JSON.stringify(obj),
    success: function success(result) {
      $table.bootstrapTable('load', result.data);
    },
    error: function error(data) {
      alert("错误");
    }
  });

  console.log(data.node.id);
  console.log("选择一个节点");
}).on('changed.jstree', function (event, data) {
  // console.log(data)
  // console.log("-----------changed.jstree");
  // console.log("action:" + data.action);
  // console.log(data.node);
});

function loadConfig(inst, selectedNode) {
  var parent = selectedNode.parent;
  var temp = selectedNode.text;
  var aId = selectedNode.id;
  //  $.ajax({
  //   async: false,
  //     type: "POST",
  //     url: "/propertyProjectRegistr/page",
  //     contentType: "application/json; charset=utf-8",
  //     data: JSON.stringify(res),
  //     dataType: "json",
  //       success : function(data) {


  //               inst.open_node(selectedNode);
  //       }
  //   });
}

function create(obj) {
  var s1 = $.jstree.reference(obj.reference),
      s2 = s1.get_node(obj.reference);
  console.log(s1);
  console.log(s2);
  // var inst = $.jstree.reference(data.reference),
  // 			obj = inst.get_node(data.reference);
  // 		inst.create_node(obj, {}, "last", function (new_node) {
  // 			try {
  // 				new_node.text="新建设备";
  // 				inst.edit(new_node);
  // 			} catch (ex) {
  // 				setTimeout(function () { inst.edit(new_node); },0);
  // 			}
  // 		});
  s1.create_node(s2, {}, "last", function (new_node) {
    new_node.text = "新建设备";
    s1.edit(new_node);
    console.log(new_node);
  });
}

function rename() {
  var ref = $('#jstree1').jstree(true);
  var currNode = _getCurrNode();
  var s = $.jstree.reference(ref.reference);

  ref.rename_node(currNode);
}

function del() {
  var ref = $('#jstree1').jstree(true);
  var currNode = _getCurrNode();
  ref.delete_node(currNode);
}

function moveup() {
  var ref = $('#jstree1').jstree(true);
  var currNode = _getCurrNode();
  var prevNode = ref.get_prev_dom(currNode, true);
  ref.move_node(currNode, prevNode, 'before');
}

function movedown() {
  var ref = $('#jstree1').jstree(true);
  var currNode = _getCurrNode();
  var nextNode = ref.get_next_dom(currNode, true); //返回兄弟节点的下一个节点
  ref.move_node(currNode, nextNode, 'after');
}

/**
*    获取当前所选中的结点
*/
function _getCurrNode() {
  var ref = $('#jstree1').jstree(true),
      sel = ref.get_selected();

  if (!sel.length) {

    return false;
  }
  sel = sel[0];
  return sel;
}

$('#searchbtn').click(function () {
  if ($('#username').val() == '') {
      $('#jstree1').jstree("destroy");
      searchFn();
  }
  res.data.projName = $('#username').val();
  $('#jstree1').jstree("destroy");
  searchFn();
});

//搜索
function searchFn() {
  $('#jstree1').empty().jstree({
    "core": {
      "data": function data(obj, cb) {
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
      },
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
          "icon": "glyphicon glyphicon-plus",

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

          }
     }
  }).bind("select_node.jstree", function (event, data) {

    var inst = data.instance;
    var selectedNode = inst.get_node(data.selected);
    var level = $("#" + selectedNode.id).attr("aria-level");
    loadConfig(inst, selectedNode);
  }).bind("activate_node.jstree", function (obj, e) {
    var currentNode = e.node;
  }).on('select_node.jstree', function (event, data) {
    obj.data.propertyProjectRegistrId = data.node.id;
    $.ajax({
      url: "/naturalBuilding/page",
      dataType: "json",
      type: "post",
      contentType: 'application/json;charset=UTF-8',
      data: JSON.stringify(obj),
      success: function success(result) {

        $table.bootstrapTable('load', result.data);
      },
      error: function error(data) {
        alert("错误");
      }
    });
    console.log("选择一个节点");
  }).on('changed.jstree', function (event, data) {});
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
  $table.bootstrapTable('removeByUniqueId', delid);
}

//批量删除
function BtchDeleteBook() {
  var rows = $table.bootstrapTable('getSelections');
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
    console.log(idArr);
    delajx(idArr, "/naturalBuilding/deleteNaturalBuilding", function (data) {
      if (data.code == 1) {
        alert("已删除");
        $table.bootstrapTable('remove', { field: "id", values: idArr });
        window.location.reload();
      } else {
        alert("失败");
      }
    });
  });
  // $.ajax({
  //        url:"/propertyProjectRegistr/deleteProject",
  //        type:"post",
  //        data:JSON.stringify(idArr),
  //        contentType: 'application/json;charset=UTF-8',
  //        success:function(data){
  //            layer.alert("已删除");

  //            $('#myTable').bootstrapTable('remove',{field:"id",values:idArr} );
  //        },
  //        error:function(data){
  //                alert("错误");
  //        }
  // });
  // console.log(idArr);
  // if(rows.length==0){
  //         alert("请选择删除的数据");
  //         return;
  // }
  // var ids='';
  // for(var i=0;i<rows.length;i++){
  //         ids+=rows[i]['goodsId']+",";
  // };
  // ids=ids.substring(0,ids.length-1);

  // var msg="你确定要删除选中数据吗";

  // if(confirm(msg)==true){
  //     // $.ajax({
  //     //     url:"/propertyProjectRegistr/deleteProject",
  //     //     type:"post",
  //     //     data:{ids:ids},
  //     //     success:function(data){
  //     //         alert("已删除");
  //     //         $("#myTable").bootstrapTable('refresh');
  //     //     },
  //     //     error:function(data){
  //     //             alert("错误");
  //     //     }
  //     // });
  // }
}
// 查询
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

// 添加
// $("#addRecord").click(function () {
//   var adddata = $("#addForm").serializeObject();
//
//   $.ajax({
//     url: "/naturalBuilding/addNaturalBuilding",
//     dataType: "json",
//     type: "post",
//     contentType: 'application/json;charset=UTF-8',
//     data: JSON.stringify(adddata),
//     success: function success(data) {
//       layer.msg("添加成功");
//       var timer = setTimeout(function () {
//         clearTimeout(timer);
//         window.location.reload();
//       }, 1000);
//     },
//     error: function error(data) {
//       alert("错误");
//     }
//   });
// });

//修改数据
// $('#editRecord').click(function () {
//   var editdata = $("#editForm").serializeObject();
//   $.ajax({
//     url: "/naturalBuilding/updateNaturalBuilding",
//     dataType: "json",
//     type: "post",
//     contentType: 'application/json;charset=UTF-8',
//     data: JSON.stringify(editdata),
//     success: function success(data) {
//       layer.msg('操作成功');
//       var timer = setTimeout(function () {
//         clearTimeout(timer);
//         window.location.reload();
//       }, 1000);
//     },
//     error: function error(data) {
//       alert("错误");
//     }
//   });
// });

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
function queryselectdata(obj, url, callback) {
  $.ajax({
    url: url,
    dataType: "json",
    type: "post",
    data: JSON.stringify(obj),
    contentType: 'application/json;charset=UTF-8',
    success: function success(data) {
      callback(data);
    },
    error: function error(data) {
      alert("错误");
    }
  });
}
function setHouseNature(obj) {
  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.name + '</option>';

    $(str).appendTo('#housenature');
    $(str).appendTo('#housenaturexg');
  });
}
function setHouseUse(obj) {
  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.name + '</option>';
    $(str).appendTo('#houseuse');
    $(str).appendTo('#houseusexg');
  });
}
function setBankInfo(obj) {
  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.bankName + '</option>';
    $(str).appendTo('#backopt');
    $(str).appendTo('#backoptxg');
  });
}
// function presetrole(obj) {
//   obj.data.list.forEach(element => {
//     var str = `<option value=${element.id}>${element.projName}</option>`
//     $(str).appendTo('#presetrole')
//     $(str).appendTo('#presetrolexg')
//   });
// }
function queryRegionBase(obj) {

  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.name + '</option>';
    $(str).appendTo('#Region');
    $(str).appendTo('#Regionxg');
  });
}
// 自然幢类型
function naturalBuildingType(obj) {
  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.typeName + '</option>';
    $(str).appendTo('#naturalBuildingType');
    $(str).appendTo('#naturalBuildingTypexg');
  });
}

// 自然幢结构属性
function structuralAttribute(obj) {
  obj.data.forEach(function (element) {
    var str = '<option value=' + element.id + '>' + element.name + '</option>';
    $(str).appendTo('#structuralAttribute');
    $(str).appendTo('#structuralAttributexg');
  });
}
// /naturalBuildingType/queryNaturalBuildingTypeList   enabled 
// /structuralAttribute/queryStructuralAttributeList    enabled 
queryselect('/common/queryRegionBase', queryRegionBase); //行政区
queryselect('/common/queryHouseNature', setHouseNature); //房屋
queryselect('/common/queryHouseUse', setHouseUse); //房屋
queryselect('/common/queryBankInfo', setBankInfo); //银行
queryselectdata({ enabled: 1 }, '/naturalBuildingType/queryNaturalBuildingTypeList', naturalBuildingType); // 自然幢类型
queryselectdata({ enabled: 1 }, '/structuralAttribute/queryStructuralAttributeList', structuralAttribute); // 自然幢结构属性
// /common/queryHouseNature 查询房屋性质
// /common/queryHouseUse  查询房屋用途
// /common/queryBankInfo 查询开户银行



// 表单验证
$('.close').click(function(){
    $(".new-phone label.error").remove();//清除验证标签
    $("#addForm").validate().resetForm(); //清除验证
})
$('.rest').click(function(){
    $(".new-phone label.error").remove();//清除验证标签
    $("#addForm").validate().resetForm(); //清除验证
})
$.validator.setDefaults({
    submitHandler: function() {
        var adddata = $("#addForm").serializeObject();
        $.ajax({
            url: "/naturalBuilding/addNaturalBuilding",
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
            },
            error: function error(data) {
                alert("错误");
            }
        });
    }
});
$("#addForm").validate({
    errorElement: 'em' ,
    rules: {
        naturalBuildingName: "required",
        naturalBuildingLocation: "required",
        regionBaseId:{
            required:true
        },
        // number:true 验证数字
        underFloorNumber:'number',
        aboveFloorNumber:'number',
        unitsNumber:'number',
        totalHouses:'number',
        averagePrice:'number',
        depositStandard:'number',
        totalAreaPredicted:'number',
        totalAreaMeasured:'number',
        forecastTotalDepositAmount: {
            number: true,

        },
        agree: "required"
    },
    messages: {
        firstname: "请输入您的名字",
        lastname: "请输入您的姓氏",
        username: {
            required: "请输入用户名",
            minlength: "用户名必需由两个字母组成"
        },
        password: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母"
        },
        confirm_password: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母",
            equalTo: "两次密码输入不一致"
        },
        email: "请输入一个正确的邮箱",
        agree: "请接受我们的声明",
        topic: "请选择两个主题"
    },

});


// 修改
$.validator.setDefaults({
    submitHandler: function() {
        var editdata = $("#editForm").serializeObject();
        $.ajax({
            url: "/naturalBuilding/updateNaturalBuilding",
            dataType: "json",
            type: "post",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(editdata),
            success: function success(data) {
                layer.msg('操作成功');
                var timer = setTimeout(function () {
                    clearTimeout(timer);
                    window.location.reload();
                }, 1000);
            },
            error: function error(data) {
                alert("错误");
            }
        });
    }
});
$("#editForm").validate({
    errorElement: 'em' ,
    rules: {
        naturalBuildingName: "required",
        naturalBuildingLocation: "required",
        changeReason:"required",
        regionBaseId:{
            required:true
        },
        // number:true 验证数字
        underFloorNumber:'number',
        aboveFloorNumber:'number',
        unitsNumber:'number',
        totalHouses:'number',
        averagePrice:'number',
        depositStandard:'number',
        totalAreaPredicted:'number',
        totalAreaMeasured:'number',
        forecastTotalDepositAmount: {
            number: true,

        },
        agree: "required"
    },
    messages: {
        firstname: "请输入您的名字",
        lastname: "请输入您的姓氏",
        username: {
            required: "请输入用户名",
            minlength: "用户名必需由两个字母组成"
        },
        password: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母"
        },
        confirm_password: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母",
            equalTo: "两次密码输入不一致"
        },
        email: "请输入一个正确的邮箱",
        agree: "请接受我们的声明",
        topic: "请选择两个主题"
    },

});

