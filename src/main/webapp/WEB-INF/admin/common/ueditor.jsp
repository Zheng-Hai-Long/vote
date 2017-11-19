<script type="text/javascript">
var UEDITOR_HOME_URL='/../../../../ueditor/',ueditor_loader={};
//编辑器同步
function editorSyn(ename){
$.each(ueditor_loader[ename],function(i){
this.sync();
});
}
</script>
<link rel="stylesheet" type="text/css" href="../../../../ueditor/themes/default/css/ueditor.min.css"/>
<!-- 配置文件 -->
<script type="text/javascript" src="../../../../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../../../../ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('content', {
    toolbars: [
        [
        'undo', //撤销
        'bold', //加粗
        'italic', //斜体
        'indent', //首行缩进
        'snapscreen', //截图
        'underline', //下划线
        'time', //时间
        'date', //日期
        'unlink', //取消链接
        'inserttitle', //插入标题
        'fontfamily', //字体
        'fontsize', //字号
        'paragraph', //段落格式
        'simpleupload', //单图上传
        'insertimage', //多图上传
        'link', //超链接
        'emotion', //表情
        'map', //Baidu地图
        'gmap', //Google地图
        'insertvideo', //视频
        'justifyleft', //居左对齐
        'justifyright', //居右对齐
        'justifycenter', //居中对齐
        'justifyjustify', //两端对齐
        'forecolor', //字体颜色
        'backcolor', //背景色
        //'fullscreen', //全屏
        'imagecenter', //居中
        'background', //背景
        'template', //模板
        'inserttable', //插入表格
        'drafts', // 从草稿箱加载
        'charts' // 图表
        ]
    ],
    autoHeightEnabled: true,
    autoFloatEnabled: true,
    initialFrameHeight:300,
    initialFrameWidth:600
});
</script>
