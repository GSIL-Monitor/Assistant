/**
 * 产品管理的单例
 */
var ProductTwo = {
    id: "productTwoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProductTwo.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: false},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '数量', field: 'count', align: 'center', valign: 'middle', sortable: true},
        {title: '描述', field: 'description', align: 'center', valign: 'middle', sortable: true},
        {title: '生产时间', field: 'productionDate', align: 'center', valign: 'middle', sortable: true},
        {title: '过期时间', field: 'expireDate', align: 'center', valign: 'middle', sortable: true}
        ]
    return columns;
};


$(function () {

    var defaultColunms = ProductTwo.initColumn();
    var table = new BSTable(ProductTwo.id, "/product/list", defaultColunms);
    table.setPaginationType("client");
    table.init();
    ProductTwo.table = table;
});
