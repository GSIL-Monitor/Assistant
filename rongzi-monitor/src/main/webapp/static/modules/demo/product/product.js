/**
 * 产品管理的单例
 */
var Product = {
    id: "productTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Product.initColumn = function () {
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



/**
 * 检查是否选中
 */
Product.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Product.seItem = selected[0];
        return true;
    }
};
/*
    多选按钮检查
 */
Product.doublecheck = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Product.seItem = selected;
        return true;
    }
};


Product.searchInfo=function () {

    var index = layer.open({
        type: 2,
        title: '查询详情',
        area: ['900px', '500px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/product/product_search'
    });
    this.layerIndex = index;
}

/**
 * 点击添加产品
 */
Product.openAddProduct = function () {
    var index = layer.open({
        type: 2,
        title: '添加产品',
        area: ['800px', '450px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/product/product_add'
    });
    this.layerIndex = index;
};

/**
 * 点击修改按钮时
 */
Product.openChangeProduct = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改产品',
            area: ['800px', '450px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/product/product_edit/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除产品
 */
Product.delProduct = function () {


    //单选删除
  /*  if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/product/delete", function () {
                Feng.success("删除成功!");
                Product.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", Product.seItem.Id);
            ajax.start();
        };

        Feng.confirm("是否删除产品 " + Product.seItem.Name + "?",operation);
    }*/

  //多选删除
    if (this.doublecheck()) {
        var ids=new Array();
        for(var i=0;i<Product.seItem.length ;i++){
            ids.push(Product.seItem[i].id);
        }
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/product/delete", function () {
                Feng.success("删除成功!");
                Product.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("ids", ids);
            ajax.start();
        };
        Feng.confirm("是否删除产品 " + ids + "?",operation);
    }
};


//上传excel
function uploadExcel(){
    var loading;
    layui.use('upload', function(){
        var upload = layui.upload;

        var uploadInst =upload.render({
            elem: '#layuiFile'
            ,url: Feng.ctxPath + '/product/uploadExcel_easypoi'
            ,accept: 'file'
            ,size: 50
            ,exts: 'xls|xlsx'
            ,auto:false
            ,bindAction: '#uploadExcel'
            ,size: 10000
            ,number:0
            ,before:function(){
                loading=layui.layer.load();
            }
            ,done:function(res){
                if(res.code>0){
                    Feng.error("添加失败! !");
                }
                console.log(res)
                layer.close(loading);
                Feng.info(res.msg);
                Product.table.refresh();
            }
            ,error:function(index, upload){
                layer.close(loading);
            }
        });
    })
}


//导出表格内容
Product.downloadExcel=function(){

    window.location.href=Feng.ctxPath + '/product/downloadExcelContent';
}


//下载表格模版
Product.downloadModel=function(){

    window.location.href=Feng.ctxPath + '/product/downloadExcelModel';
}




$(function () {
    var defaultColunms = Product.initColumn();
    var table = new BSTable(Product.id, "/product/list", defaultColunms);

    table.setPaginationType("client");
    table.init();
    Product.table = table;

    uploadExcel();



});
