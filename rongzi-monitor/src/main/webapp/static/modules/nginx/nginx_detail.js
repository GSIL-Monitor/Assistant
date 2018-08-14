/**
 * 产品管理的单例
 */
var NginxDetail = {
    id: "nginxDetailTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
NginxDetail.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: false},
        {title: 'id', field: 'nginxlogId', visible: false, align: 'center', valign: 'middle'},
        {title: 'nginx花费时长', field: 'nginxcosttime', align: 'center', valign: 'middle', sortable: true},
        {title: 'iis花费时长', field: 'iiscosttime', align: 'center', valign: 'middle', sortable: true},
        {title: '客户端IP', field: 'clientip', align: 'center', valign: 'middle', sortable: true},
        {title: '产生时间', field: 'createtime', align: 'center', valign: 'middle', sortable: true},
        {title: '状态', field: 'status', align: 'center', valign: 'middle', sortable: true},
        {title: '请求内容大小', field: 'contentsize', align: 'center', valign: 'middle', sortable: true},
        {title: '外网IP', field: 'nginxwanip', align: 'center', valign: 'middle', sortable: true}



        ]
    return columns;
};

// ProInfoDlg.clearData = function () {
//     this.proInfoData = {};
// };
//
// ProInfoDlg.set = function (key, val) {
//     this.proInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
//     return this;
// };

NginxDetail.collectData = function () {

    this.set("paramsData");
};



NginxDetail.formParams = function () {
    var queryData = {};
    queryData['paramsData'] = $("#paramsData").val();
    return queryData;
}





$(function () {
    var defaultColunms = NginxDetail.initColumn();
    var table = new BSTable(NginxDetail.id, "/nginx/nginx_detaillist/", defaultColunms);
    table.setPaginationType("client");
    table.setQueryParams(NginxDetail.formParams());
    table.init();
    NginxDetail.table = table;
});
