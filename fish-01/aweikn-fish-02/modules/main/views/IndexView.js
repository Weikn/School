define([
    'hbs!modules/main/templates/IndexView.html',
    'i18n!modules/main/i18n/IndexView.i18n'
], function(tpl, i18n) {
    var me = null;
    return fish.View.extend({
        el: 'body',
        template: tpl,
        // i18nData: fish.extend({}, i18n, commonI18n),
        i18nData: fish.extend({}, i18n),
        // 提供模板数据
        serialize: function () {
            return this.i18nData;
        },
        // 视图事件定义
        events: {},
        // 一些初始化设置 (不能进行dom操作)
        initialize: function() {
            me = this;
            console.log(me);
        },
        // 视图渲染完毕处理函数
        afterRender: function() {
        },
        // 视图被删除时候做的事情
        cleanup: function() {
            me = null;
        }
    });
});
