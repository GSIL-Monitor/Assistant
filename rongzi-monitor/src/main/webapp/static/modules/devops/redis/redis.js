var Redis = {
    redisInfoData: {},
    validateFields: {
        rediskey: {
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
Redis.clearData = function () {
    this.redisInfoData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Redis.set = function (key, val) {
    this.redisInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Redis.get = function (key) {
    return $("#" + key).val();

};

/**
 * 收集数据
 */
Redis.collectData = function () {

    this.set('rediskey');
};




Redis.validate = function () {
    $('#redisInfoForm').data("bootstrapValidator").resetForm();
     $('#redisInfoForm').bootstrapValidator('validate');
     return $("#redisInfoForm").data('bootstrapValidator').isValid();
};

/**
 * 删除
 */
Redis.delKey = function () {

    this.clearData();
    this.collectData();

    var dataKey=$('#rediskey').val();
    if (!this.validate()) {
        return;
    }
    var operation = function(){
        var ajax = new $ax(Feng.ctxPath + "/redis/delete/"+dataKey, function (data) {
            if (data.code != 200) {
                Feng.error("删除失败!" + data.message + "!");
            } else {
                Feng.success("删除成功!");
            }
        });
        ajax.start();
    };
    Feng.confirm("是否删除key: " + dataKey + "?",operation);

};


$(function () {
    Feng.initValidator("redisInfoForm", Redis.validateFields);

});
