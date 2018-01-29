function openblog(blogId){
	console.log(blogId);
    $.ajax({
        type: "POST",
        url: "/tzxblog/openBlog",
        data: {blogId:blogId},
        dataType: "json",
        success: function (data) {
            console.log(data);
			if (data !=null) {
				//博客详情请求成功
				$("#blogTitle").text(data.blogTitle);
				$("#blogType").text(data.blogType);
				$("#blogDate").text(data.blogDate);
				$("#blogReadCount").text(data.blogReadCount);
				$("#blogCommentCount").text(data.blogCommentCount);
				$("#blogUser").text(data.userinfo.userName);
//				console.log($("#blogContent").val());
//				$("#blogContent").val(data.blogContent);	
//				$("#blogContent").innerHTML=data.blogContent;	
//				$("#blogContent").text(data.blogContent);	
				var text = data.blogContent;
                var converter = new showdown.Converter();
				console.log(text);
                var html = converter.makeHtml(text);
                document.getElementById("curcontent").innerHTML = html;
//                var comm = document.createElement("button");//js新建元素
//                mask.onclick = 'javascript:pushcomment('+${data.blogId}+')';//给元素添加点击事件
//                document.body.appendChild(mask);//把元素放进body标签里面
//                
//                $("#bloginfo").
                $("#bloglist").hide();
                $("#bloginfo").show();
//				window.location.href="/tzxblog";	
			}
		}
    });
}
function pushcomment(){
//	console.log(blogId);
	var comment=document.getElementById("pushcomm").value;
	console.log(comment);
    $.ajax({
        type: "POST",
        url: "/tzxblog/pushcomment",
        data: {comment:comment},
        dataType: "json",
        success: function (data) {
            console.log(data);
//			if (data !=null) {
//				//博客详情请求成功
//				$("#blogTitle").text(data.blogTitle);
//				$("#blogType").text(data.blogType);
//				$("#blogDate").text(data.blogDate);
//				$("#blogReadCount").text(data.blogReadCount);
//				$("#blogCommentCount").text(data.blogCommentCount);
//				$("#blogUser").text(data.userinfo.userName);
//				var text = data.blogContent;
//                var converter = new showdown.Converter();
//				console.log(text);
//                var html = converter.makeHtml(text);
//                document.getElementById("curcontent").innerHTML = html;
//                $("#bloglist").hide();
//                $("#bloginfo").show();
//			}
		}
    });
}