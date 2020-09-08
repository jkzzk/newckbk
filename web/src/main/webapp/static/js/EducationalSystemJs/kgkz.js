'use strict'

var bkkg = 0;
var fxkg = 0;
var zzykg = 0;
var cetkg = 0;

$(function(){

    init();

    $("#submit").click(function(){
        $.ajax({
            type: 'post',
            url: '/jwkzxxjl/set',
            data: {
                bkkg : bkkg,
                fxkg : fxkg,
                zzykg : zzykg,
                cetkg : cetkg
            },
            success:function (data) {
                succMsg(data.msg);
                setTimeout(function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.$('#btn-refresh').click();
                    parent.layer.close(index);
                },1000)
            },
            error:function (data) {
                errMsg("网络异常");
            }
        });
    });

    $("#bkkg").on('switch-change',function (event,data) {
        //data.value  开关值
        // console.log(data.value);
        if(data.value) {
            bkkg = 1;
        }else {
            bkkg = 0;
        }
    });

    $("#fxkg").on('switch-change',function (event,data) {
        if(data.value) {
            fxkg = 1;
        }else {
            fxkg = 0;
        }
    });

    $("#zzykg").on('switch-change',function (event,data) {
        if(data.value) {
            zzykg = 1;
        }else {
            zzykg = 0;
        }
    });

    $("#cetkg").on('switch-change',function (event,data) {
        if(data.value) {
            cetkg = 1;
        }else {
            cetkg = 0;
        }
    });


});

function init() {
    bkkg = $("#old_bkkg").val();
    // console.log(bkkg);
    fxkg = $("#old_fxkg").val();
    // console.log(fxkg);
    zzykg = $("#old_zzykg").val();
    // console.log(zzykg);
    cetkg = $("#old_cetkg").val();
    // console.log(cetkg);

    //初始化开关状态
    if(bkkg == 1) {
        $('#bkkg').bootstrapSwitch('setState', true);
    }else {
        $('#bkkg').bootstrapSwitch('setState', false);
    }

    if(fxkg == 1) {
        $('#fxkg').bootstrapSwitch('setState', true);
    }else {
        $('#fxkg').bootstrapSwitch('setState', false);
    }


    if(zzykg == 1) {
        $('#zzykg').bootstrapSwitch('setState', true);
    }else {
        $('#zzykg').bootstrapSwitch('setState', false);
    }

    if(cetkg == 1) {
        $('#cetkg').bootstrapSwitch('setState', true);
    }else {
        $('#cetkg').bootstrapSwitch('setState', false);
    }
}