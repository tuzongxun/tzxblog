$(document).ready(function(){
         $("#regist").click(function(){
           var formData = $("#regform").serializeArray(); //先进行序列化数组操作
           var p1=$("#password").val();
           var p2=$("#password1").val();
           if(p1 == p2){
           var userinfo = {};  //创建一个对象
           $.each(formData, function(n,v) { 
              if(formData[n].name != "userPassword1"){
                 userinfo[formData[n].name]=formData[n].value;  //循环数组，把数组的每一项都添加到对象中
              }
           });
            $.ajax({
              type: "POST",
              url: "./regist",
              contentType: "application/json; charset=utf-8",
              data: JSON.stringify(userinfo),
              dataType: "json",
              success: function (data) {
              if(data.resultCode == 0){
                 //注册成功，跳转到首页
                 window.location.href="/tzxblog";
              }else if(data.resultCode == 1){
                 //注册失败，账号为空
                 $("#pu1").text("账号信息不能为空");
                 $("#pu1").css({color:"#993333"})
              }else if(data.resultCode == 2){
                 //注册失败，密码为空
                 $("#pp1").text("密码不能为空");
                 $("#pp1").css({color:"#993333"})
              }else if(data.resultCode == 3){
                 //注册失败，邮箱为空
                 $("#em1").text("邮箱不能为空");
                 $("#em1").css({color:"#993333"})
              }else if(data.resultCode == 4){
                 //注册失败，用户已存在
                 $("#pu1").text("用户已存在");
                 $("#pu1").css({color:"#993333"})
              }
              },
              error: function (data) {
                //请求失败，弹框提示，重新登录
                $("#request-process-patent").html("提交数据失败！");
              }
           });
         }else{
             // 两次输入密码不一致
        	 $("#pp2").text("密码不一致");
             $("#pp2").css({color:"#993333"})
         }
        });
});