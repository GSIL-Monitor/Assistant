/**
 * 日志管理初始化
 */
var ExLog = {
    id: "ExLogTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ExLog.initColumn = function () {
    return [
        {field: 'selectItem', radio: false},
        {title: 'id', field: 'ExceptionId', visible: true, align: 'center', valign: 'middle'},
        {
            title: '详情展示',
            field: 'operate',
            align: 'center',
            valign: 'middle',
            events: operateEvents,
            formatter: operateFormatter
        },
        {title: '发生时间', field: 'OccurTime', align: 'center', valign: 'middle', sortable: true},
        {title: '异常信息', field: 'Message', align: 'left', valign: 'middle', sortable: false},
        {
            title: '异常栈',
            field: 'StackTrace',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter: toolTipFormatter
        },
        {title: '异常类型', field: 'ErrorType', align: 'left', valign: 'middle', sortable: false},
        {title: '客户端IP', field: 'IP', align: 'left', valign: 'middle', sortable: false},
        {title: '服务端IP', field: 'ServerIP', align: 'left', valign: 'middle', sortable: false},
        {title: '处理者', field: 'Owner', align: 'left', valign: 'middle', sortable: false},
        {title: '处理状态', field: 'Status', align: 'left', valign: 'middle', sortable: false}

    ];
};

/**
 * 检查是否选中
 */
ExLog.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        ExLog.seItem = selected;
        return true;
    }
};

/**
 * 初始化查询表单提交参数
 */
ExLog.initFormParams = function () {
    var date = new Date();
    var today = moment().format("YYYY-MM-DD");
    $("#beginTime").val(today);
    $("#endTime").val(today);
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
ExLog.formParams = function () {
    var queryData = {};
    queryData['beginTime'] = $("#beginTime").val();
    queryData['endTime'] = $("#endTime").val();
    queryData['systemCode'] = $("#systemCode").val();
    queryData['isReadonly'] = $("#isReadonly").val();
    queryData['Owner'] = $("#Owner").val();
    queryData['Status'] = $("#Status").val();

    return queryData;
}

/*
    指派异常给指定的人
 */
ExLog.updateOwner = function () {

    var ids = "";
    if (this.check()) {
        for (var i = 0; i < ExLog.seItem.length; i++) {
            ids += ExLog.seItem[i].ExceptionId + "&" + ExLog.seItem[i].OccurTime + ",";
        }
        var index = layer.open({
            type: 2,
            title: '任务指派',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/exception/exception_multiEdit/' + ids
        });
        this.layerIndex = index;
    }
}

/**
 * 查询日志列表
 */
ExLog.search = function () {
    ExLog.table.refresh({query: ExLog.formParams()});
};


/**
 * 根据查询参数来进行条件导出
 */

ExLog.downloadExcel=function(){

    var excelParamData=ExLog.formParams();
    var ajax = new $ax(Feng.ctxPath + "/exception/downLoadExcelByCondition", function (data) {
        if(data.code==200){

            // Feng.success("下载成功");
            window.location.href =Feng.ctxPath + '/exception/downloadExcelContent';
        }else{
            Feng.error("下载失败!");
        }

    });
    ajax.set("excelParamData",JSON.stringify(excelParamData));
    ajax.start();

}


function operateFormatter(value, row, index) {
    return [
        '<button id="btn_detail" type="button" class="RoleOfA btn-default bt-select">详情</button>',
    ].join('');
}






window.operateEvents = {
    'click .RoleOfA': function (e, value, row, index) {
        Feng.infoDetail("堆栈详情", row.StackTrace);
    }
};

$(function () {
    ExLog.initFormParams();
    var defaultColunms = ExLog.initColumn();
    var table = new BSTable(ExLog.id, "/exception/logs", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(ExLog.formParams());
    ExLog.table = table.init();

    ExLog.table.btInstance.on('load-success.bs.table', function (data) {
        $("[data-toggle='tooltip']").tooltip();
    });
});
