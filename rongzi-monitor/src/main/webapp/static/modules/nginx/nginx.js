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
        {title: 'controller', field: 'controller', align: 'center', valign: 'middle', sortable: true},
        {title: 'action', field: 'action', align: 'center', valign: 'middle', sortable: true},
        {title: '备注', field: 'memo', align: 'center', valign: 'middle', sortable: true},
        {title: '超时数量', field: 'count', align: 'center', valign: 'middle', sortable: true},
        {title: '总请求数量', field: 'allcount', align: 'center', valign: 'middle', sortable: true},
        {title: '超时率(万分比)', field: 'overtimerate', align: 'center', valign: 'middle', sortable: true},
        {title: '超时平均时长', field: 'avg_iiscosttime', align: 'center', valign: 'middle', sortable: true},
        {title: '总平均时长', field: 'allavgiiscosttime', align: 'center', valign: 'middle', sortable: true},
        {title: '最大时长', field: 'max_iiscosttime', align: 'center', valign: 'middle', sortable: true}
    ]
    return columns;
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

    return queryData;
}




/**
 * 查询
 */
Nginx.search = function () {
    Nginx.table.refresh({query: Nginx.formParams()});
};


//详情展示
Nginx.searchDetailInfo=function(){

    if (this.check()) {

        var paramsData=this.seItem.controller+","+this.seItem.action;

        var index = layer.open({
            type: 2,
            title: 'action超时详情',
            area: ['1200px', '600px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/nginx/nginx_detail/'+ paramsData
        });
        this.layerIndex = index;
    }


}




$(function () {
    var defaultColunms = Nginx.initColumn();

    var table = new BSTable(Nginx.id, "/nginx/list", defaultColunms);
    // table.setPaginationType("server");
    table.setPaginationType("client");
    table.setQueryParams(Nginx.formParams());
    table.init();
    Nginx.table = table;
});
