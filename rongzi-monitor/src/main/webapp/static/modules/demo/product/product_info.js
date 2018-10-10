/**
 * 产品详情对话框（可用于添加和修改对话框）
 */
var ProInfoDlg = {
    proInfoData: {},
    validateFields: {
        name: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
        count: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }
            }
        },
        productionDate: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }

            }
        },
        description: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }

            }
        },
        expireDate: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }

            }
        }
    }
};

/**
 * 清除数据
 */
ProInfoDlg.clearData = function () {
    this.proInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProInfoDlg.set = function (key, val) {
    this.proInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProInfoDlg.get = function (key) {

    return $("#" + key).val();

};

/**
 * 关闭此对话框
 */
ProInfoDlg.close = function () {
    parent.layer.close(window.parent.Product.layerIndex);
};

/**
 * 校验时间
 */

ProInfoDlg.validateDate = function () {

     var proDate=Date.parse(this.get("productionDate"));
     var expDate=Date.parse(this.get("expireDate"));

    if (proDate < expDate) {
        return true;
    } else {
        return false;
    }
};

/**
 * 收集数据
 */
ProInfoDlg.collectData = function () {

    this.set('id').set('name').set('count').set('productionDate').set('description')
        .set('expireDate');
};


/**
 * 验证数据是否为空
 */
ProInfoDlg.validate = function () {

    $('#productInfoForm').data("bootstrapValidator").resetForm();
    $('#productInfoForm').bootstrapValidator('validate');
    return $("#productInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 提交添加产品
 */
ProInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if (!this.validateDate()) {
        Feng.error("生产时间不能大于过期时间");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/product/add", function (data) {

        Feng.success("添加成功!");
        window.parent.Product.table.refresh();
        ProInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.proInfoData);
    ajax.start();
};

/**
 * 提交修改
 */
ProInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    if (!this.validateDate()) {
        Feng.error("生产时间不能大于过期时间");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/product/edit", function (data) {
        Feng.success("修改成功!");
        if (window.parent.Product != undefined) {
            window.parent.Product.table.refresh();
            ProInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.proInfoData);
    ajax.start();
};


$(function () {
    Feng.initValidator("productInfoForm", ProInfoDlg.validateFields);
});
