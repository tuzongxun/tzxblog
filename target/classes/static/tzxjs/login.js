$(document).ready(function(){
         $("#login").click(function(){
           var formData = $("#logform").serializeArray(); //先进行序列化数组操作
           var userinfo = {};  //创建一个对象
           $.each(formData, function(n,v) {    
              userinfo[formData[n].name]=formData[n].value;  //循环数组，把数组的每一项都添加到对象中
           });
           console.log(userinfo);
            $.ajax({
              type: "POST",
              url: "./login",
              contentType: "application/json; charset=utf-8",
              data: JSON.stringify(userinfo),
              dataType: "json",
              success: function (message) {
              console.log(message);
              //请求成功，跳转到首页
                if (message.resCode == 0) {
                    //登录成功
                    window.location.href="/tzxblog";
                }else if(message == 1){
                    //用户名为空
                    $("#pu1").text("账号信息不能为空");
                    $("#pu1").css({color:"#993333"})
                }else if(message == 2){
                    //用户不存在
                    $("#pu1").text("该用户不存在，请重新输入");
                    $("#pu1").css({color:"#FF9966"})
                }else if(message == 3){
                    //密码错误
                    $("#pp1").text("密码不正确，请重新输入");
                    $("#pp1").css({color:"#FF9966"})
                }
              },
              error: function (message) {
                //请求失败，弹框提示，重新登录
                $("#request-process-patent").html("提交数据失败！");
              }
           });
        });
});