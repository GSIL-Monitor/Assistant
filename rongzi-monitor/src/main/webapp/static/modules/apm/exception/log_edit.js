/**
 * 产品详情对话框（可用于添加和修改对话框）
 */
var logInfoDlg = {
    logInfoDlg: {},
    validateFields: {
        Owner: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                }

            }
        },
        Status: {
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
logInfoDlg.clearData = function () {
    this.logInfoDlg = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
logInfoDlg.set = function (key, val) {
    this.logInfoDlg[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
logInfoDlg.get = function (key) {

    return $("#" + key).val();

};

/**
 * 关闭此对话框
 */
logInfoDlg.close = function () {
    parent.layer.close(window.parent.ExLog.layerIndex);
};


/**
 * 收集数据
 */
logInfoDlg.collectData = function () {
    this.set('params').set('Owner').set('Status');

};


/**
 * 验证数据是否为空
 */
logInfoDlg.validate = function () {

    $('#logInfoForm').data("bootstrapValidator").resetForm();
    $('#logInfoForm').bootstrapValidator('validate');
    return $("#logInfoForm").data('bootstrapValidator').isValid();
};





/**
 * 提交修改
 */
logInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/exception/multiEdit", function (data) {
        Feng.success("修改成功!");
        if (window.parent.ExLog!= undefined) {
            window.parent.ExLog.table.refresh();
            logInfoDlg.close();
        }
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });

    ajax.set(this.logInfoDlg);
    ajax.start();
};


$(function () {
    Feng.initValidator("logInfoForm", logInfoDlg.validateFields);
});
