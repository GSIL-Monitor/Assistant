/**
 * 产品管理的单例
 */
var sysException = {
    id: "sysExceptionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
sysException.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'Id', visible: false, align: 'center', valign: 'middle'},
        {title: '系统编号', field: 'SystemCode', align: 'center', valign: 'middle'},
        {title: '系统名称', field: 'SystemName', align: 'center', valign: 'middle', sortable: true},
        {title: '异常数量', field: 'Count', align: 'center', valign: 'middle', sortable: true},
        {title: '记录日期', field: 'OccurDate', align: 'center', valign: 'middle'},
        {title: '产生日期', field: 'CreateTime', align: 'center', valign: 'middle', sortable: true},
        {title: '更新日期', field: 'UpdateTime', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};

sysException.refreshForTime=function () {
    var queryData = {};
    queryData['OccurDate'] = $("#OccurDate").val();
    sysException.table.refresh({query: queryData});
}

sysException.initData=function(){

    var date = new Date();
    var year=date.getFullYear();
    var month=(date.getMonth()+1)>=10?(date.getMonth()+1):(0+''+(date.getMonth()+1))
    var day=(date.getDate())>=10?(date.getDate()):(0+''+(date.getDate()));
    var data=year+"-"+month+"-"+day;
    $("#OccurDate").val(data);
}




sysException.formParams=function () {

    var queryData={};
    queryData['OccurDate'] = $("#OccurDate").val();
    return queryData;

}

$(function () {
    sysException.initData();
    var defaultColunms = sysException.initColumn();
    var table = new BSTable(sysException.id, "/apm/sysException/list", defaultColunms);
    table.setPaginationType("client");
    table.setQueryParams(sysException.formParams())
    table.init();
    sysException.table = table;
});
