/**
 * 产品管理的单例
 */
var typeException = {
    id: "typeExceptionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
typeException.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'Id', visible: false, align: 'center', valign: 'middle'},
        {title: '异常类别', field: 'ErrorType', align: 'center', valign: 'middle', sortable: true},
        {title: '异常总数', field: 'Count', align: 'center', valign: 'middle', sortable: true},
        {title: '记录日期', field: 'OccurDate', align: 'center', valign: 'middle'},
        {title: '产生日期', field: 'CreateTime', align: 'center', valign: 'middle'},
        {title: '更新日期', field: 'UpdateTime', align: 'center', valign: 'middle'},
        //使用服务端分页，需要注释掉下面这行
        //{title: '系统编号', field: 'SystemCode', align: 'center', valign: 'middle'},
        {title: '系统详情', field: 'systemDetail', align: 'center', valign: 'middle'}
        ]
    return columns;
};




typeException.query=function () {
    $("#sysName").empty();
    var ajax = new $ax(Feng.ctxPath + "/apm/dicSystem/query", function (data) {

        var data=data;
        for(var i=0; i<data.length;i++){
            var text=data[i];
            $("#sysName").append("<option>"+text+"</option>");
        }
        console.log($("#sysName"))
    });
    ajax.start();

}

typeException.refresh=function(){
    var queryData = {};
    queryData['sysName'] = $("#sysName").val();
    typeException.table.refresh({query: queryData});

}

typeException.refreshForTime=function(){

    var timeData = {};
    timeData['OccurDate'] = $("#OccurDate").val();

    typeException.table.refresh({query: timeData});
}

typeException.initData=function(){
    var date = new Date();
    var year=date.getFullYear();
    var month=(date.getMonth()+1)>=10?(date.getMonth()+1):(0+''+(date.getMonth()+1))
    var day=(date.getDate())>=10?(date.getDate()):(0+''+(date.getDate()));
    var data=year+"-"+month+"-"+day;
    $("#OccurDate").val(data);
}


typeException.formParams=function () {
    var queryData={};
    queryData['OccurDate'] = $("#OccurDate").val();
    queryData['sysName'] = $("#sysName").val();
    return queryData;

}

$(function () {

    typeException.query();
    typeException.initData();
    var defaultColunms = typeException.initColumn();

    //客户端分页
    //var table = new BSTable(typeException.id, "/apm/typeException/list", defaultColunms);
    // table.setPaginationType("client");


    //修改为服务端分页
    var table = new BSTable(typeException.id, "/apm/typeException/listServer", defaultColunms);
    table.setPaginationType("server");


    table.setQueryParams(typeException.formParams());
    table.init();
    typeException.table = table;
});
