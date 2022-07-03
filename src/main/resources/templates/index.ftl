<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>健身房后台管理系统主页</title>
    <#include "./common/header.ftl"/>

</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">

            </div>
            <div class="lyear-layout-sidebar-scroll">
                <#include "./common/left-menu.ftl"/>
            </div>

        </aside>
        <!--End 左侧导航-->

        <#include "./common/header-menu.ftl"/>

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-primary">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">备份文件</p>
                                    <p class="h3 text-white m-b-0">${databaseBackupTotal!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-database fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-danger">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">用户总数</p>
                                    <p class="h3 text-white m-b-0">${userTotal!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-account fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-success">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">当前在线用户</p>
                                    <p class="h3 text-white m-b-0">${onlineUserTotal!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-account-multiple fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-purple">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">操作日志</p>
                                    <p class="h3 text-white m-b-0">${operatorLogTotal!"0"}条</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-keyboard-close fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-pink">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">项目总数</p>
                                    <p class="h3 text-white m-b-0">${itemCount!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-adjust fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-brown">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">会员总数</p>
                                    <p class="h3 text-white m-b-0">${peopleCount!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-human-handsdown fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-cyan">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">工作职员总数</p>
                                    <p class="h3 text-white m-b-0">${workerCount!"0"}</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-human-handsup fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-yellow">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">教练总数</p>
                                    <p class="h3 text-white m-b-0">${coachCount!"0"}条</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                                class="mdi mdi-human-pregnant fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div id="main" style="width: 500px;height: 500px"></div>

            <div id="main1" style="width: 900px;height: 450px;position: relative;"></div>

<#if ylrc_auth??>
    <#if ylrc_auth != 1>
        <div class="row" id="show-copyright" hidden>
            <div class="col-sm-12 col-lg-12">
                <div class="card bg-primary">
                    <div class="card-body clearfix">
                        <div class="pull-left">
                            <p class="h6 text-white m-t-0">${showTipsText}</p>
                            <p class="h3 text-white m-b-0">${showTipsUrlText}<a href="${showTipsUtl}"
                                                                                style="color:red;margin-right:20px;">https://www.yuanlrc.com</a><a
                                    href="javascript:void(0)" class="btn btn-danger"
                                    id="order-auth-btn">${showTipsBtnText}</a></p>
                            <p class="h5 text-white m-b-0"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</#if>
        </main>
        <!--End 页面主要内容-->
    </div>
</div>
<#include "./common/footer.ftl"/>
<script type="text/javascript" src="/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/admin/js/main.min.js"></script>
<script  src="/admin/js/echarts.js"></script>
<script  src="./admin/js/jquery-1.12.4.min.js"></script>
<script  src="/admin/js/jquery.min.js"></script>


<script type="text/javascript">
    var chartDoms = document.getElementById('main');
    var myCharts = echarts.init(chartDoms);
    var options;
    $("#dialodIndex").hide();
    $(function() {
        $.ajax({
            type: "GET",
            //当发送json数据时添加：
            /*  contentType: "application/json; charset=utf-8", */
            url: "/home/index/tj",
            dataType: "json",
            error: function (data) {
                alert("出错了！");
            },
            success: function (data) {
                console.log(data)
                // 指定图表的配置项和数据
                options = {
                    title: {
                        text: '今日预约情况',
                        subtext: '实时',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left'
                    },
                    series: [
                        {
                            name: '人数',
                            type: 'pie',
                            radius: '50%',
                            data:data,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                options && myCharts.setOption(options);
            }
        });

    })

</script>

<script type="text/javascript">
    var chartDoms1 = document.getElementById('main1');
    var myCharts1 = echarts.init(chartDoms1);
    var options1;
    $("#dialodIndex").hide();
    $(function() {
        $.ajax({
            type: "GET",
            //当发送json数据时添加：
            /*  contentType: "application/json; charset=utf-8", */
            url: "/home/index/rstj",
            dataType: "json",
            error: function (data) {
                alert("出错了！");
            },
            success: function (data) {
                console.log(data)

                // 指定图表的配置项和数据
                options1 = {
                    title: {
                        text: '项目预约统计'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: data.name
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: data.date
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: data.a
                };

                options1 && myCharts1.setOption(options1);
            }
        });

    })

</script>

</body>
</html>