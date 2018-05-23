function getE(id) {
    return document.getElementById(id);
}

// getE("clear").addEventListener("click",myClear);
// function myClear() {
//     var arr=document.getElementsByClassName("clearAll");
//     for(i in arr){
//         arr[i].value="";
//     }
//     var name = document.getElementsByName("rel");
//    for(i in name){
//        name[i].checked=false;
//    }
// }
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


    // 通过商家id查询数据库并将结果返回到页面上
    $.post("../SelectBnsById",{
        bnsId:$("#bnsId").val()
    },function (data) {
        $("#name1").val(data.bns_name);
        $("#tele").val(data.bns_tel);
        for(var i=0;i<$("input[name='bnsGroup']").length;i++){
            if($("input[name='bnsGroup']").eq(i).val()==data.bns_group){
                $("input[name='bnsGroup']").eq(i).prop("checked",true);
            }
        }
        $("input[name='bnsArea']").val(data.bns_area);
        $("input[name='bnsAddr']").val(data.bns_addr);
        $("input[name='bnsMoney']").val(data.bns_money);
    },"json");

    // 点击修改按钮更新数据库里的数据
    $("#update").click(function () {
        var bnsId = $("#bnsId").val();
        var bnsName = $("#name1").val();
        var bnsTele = $("#tele").val();
        var bnsGroup = $("input[name='bnsGroup']:checked").val();
         var bnsArea = $("input[name='bnsArea']").val();
       var bnsAddr = $("input[name='bnsAddr']").val();
       var bnsMoney = $("input[name='bnsMoney']").val();
        $.post("../UpdateBns",{
            bnsId:bnsId,
            bnsName:bnsName,
            bnsTel:bnsTele,
            bnsGroup:bnsGroup,
            bnsArea:bnsArea,
            bnsAddr:bnsAddr,
            bnsMoney:bnsMoney
        },function (data) {

            if(parseInt(data)!=0){
                window.location.href="../WEB-INF/chaxun.jsp";
            }
            else {
                alert("未修改不能保存");
            }
        },"text");
    });

    // 同过正则限制人均消费的输入要求
    $("#money").keyup(function () {
        var patt =/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
        var patt2 =/[^\d]/g;
        var moneyFrom = $("#money").val();
        var arr = moneyFrom.split("\.");
        if(patt2.test(arr[0])){
            $("#money").val("");
        }
        if(arr[1]!=null&&arr[1]!=""){
            if(!patt.test($("#money").val())){
                $("#money").val("");
            }
        }
    });


  /*  $("#qurey").click(function () {
        $.post("../Qurey",{},function (data) {
            var num = parseInt(data);
            if(num!=1){
                window.location.href="../jsp/chaxun.jsp";
            }else {
                if(confirm("您确定要跳到登录页面吗?")){
                    window.location.href="/crm/jsp/denglu.jsp";
                }
            }

        })
    });

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
    });*/
    
});


