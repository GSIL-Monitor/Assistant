/**
 * 产品管理的单例
 */
var Nginx = {
    id: "nginxTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Nginx.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '请求总数', field: 'nginxtotalcount', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx1s数量', field: 'nginxover1seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx1s万分率', field: 'nginxover1seccountRate_10000', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx3s数量', field: 'nginxover3seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx3s十万分率', field: 'nginxover3seccountRate_10000', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx10s数量', field: 'nginxover10seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'nx10s百万分率', field: 'nginxover10seccountRate_10000', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis1s数量', field: 'iisover1seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis1s万分率', field: 'iisover1seccountRate_10000', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis3s数量', field: 'iisover3seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis3s十万分率', field: 'iisover3seccountRate_10000', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis10s数量', field: 'iisover10seccount', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis10s百万分率', field: 'iisover10seccountRate_10000', align: 'center', valign: 'middle', sortable: true}
    ]
    return columns;
};
/**
 * 初始化查询表单提交参数
 */
Nginx.initFormParams = function () {
    //var date = new Date();
    //var today = moment().format("YYYY-MM-DD")
    // var preDate = new Date(date.getTime() - 24*60*60*1000);
    // preDate("YYYY-MM-DD");
    var today= moment(new Date().setDate(new Date().getDate()-2)).format("YYYY-MM-DD");

  /*  var now = new Date();
    now=(now.setDate(now.getDate()-2));
    var time=now.format("YYYY-MM-DD");*/
    $("#beginTime").val(today);
};




/**
 * 检查是否选中
 */
Nginx.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Nginx.seItem = selected[0];
        return true;
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
Nginx.formParams = function () {
    var queryData = {};
    queryData['overtimelength'] = $("#overtimelength").val();
    queryData['isignore'] = $("#isignore").val();
    queryData['isiis'] = $("#isiis").val();
    queryData['begintime'] = $("#beginTime").val();
    //queryData['begintime']="nginxlog_20180628";

    return queryData;
}



/**
 * 查询
 */
Nginx.search = function () {
    Nginx.table.refresh({query: Nginx.formParams()});
};

// /**
//  * 初始化查询表单提交参数
//  */
// Nginx.initFormParams = function () {
//
// };





$(function () {
    Nginx.initFormParams();
    var defaultColunms = Nginx.initColumn();
    var table = new BSTable(Nginx.id, "/nginx/totallist", defaultColunms);
    // table.setPaginationType("server");
    table.setPaginationType("client");
    table.setQueryParams(Nginx.formParams());
    table.init();
    Nginx.table = table;
});
