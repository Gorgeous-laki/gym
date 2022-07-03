function itemReserve(itemId){
    var login = $('#yysj')
    layer.open({
        type: 1,
        title: '预约时间',
        area: ['420px', 'auto'],
        content: login,
        btn: ['确认', '取消'],
        btn1: function (index, layero) {
            var tid = $('#tid').val()
            var date = $('#date').val()

            $.ajax({
                url: '/home/itemReserve/add',
                type: 'POST',
                data: {
                    'item.id':itemId,
                    'app':date,
                    'appTime.id':tid
                },
                dataType: 'json',
                success: function (data) {
                    if (data.code == 0) {
                        successMsg("健身项目预定成功!重新登陆后即可查看记录哦!",{icon:1});
                        layer.close(index)
                    } else {
                        errorMsg(data.msg)
                    }
                },
                error: function (data) {
                    alert('网络错误!');
                }
            });
        },
        btn2: function (index, layero) {
            layer.close(index)
        }
    });



}

layui.use(['carousel', 'form'], function () {
    var carousel = layui.carousel
        , form = layui.form;

    carousel.render({
        elem: '#test2'
        , interval: 1800
        , anim: 'fade'
        , height: '700px'
        , width: '1920px'
    });

});
