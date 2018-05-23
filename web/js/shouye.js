function getE(id) {
    return document.getElementById(id);
};

$(document).ready(function () {
    $(".move").mouseenter(function () {
        $(".show2").fadeIn(1000);
        $("#up1").show();
        $("#dowm1").hide();
    });
    $("nav").mouseleave(function () {
        $(".show2").fadeOut(1000);
        $("#up1").hide();
        $("#dowm1").show();
    });

    $("#qurey").click(function () {
        $.post("../Qurey",{},function (data) {
            var num = parseInt(data);
            if(num!=1){
                window.location.href="../WEB-INF/chaxun.jsp";
            }else {
                if(confirm("您确定要跳到登录页面吗?")){
                    window.location.href="/crm/jsp/denglu.jsp";
                }
            }

        })
    })

    $("#add").click(function () {
        $.post("../Add",{},function (data) {
            var num = parseInt(data);
            if(num!=1){
                window.location.href="/crm/jsp/tianjia.jsp";
            }else {
                if(confirm("您确定要跳到登录页面吗?")){
                    window.location.href="/crm/jsp/denglu.jsp";
                }
            }

        })
    })
});
