function openblog(blogId) {
    console.log(blogId);
    $.ajax({
        type: "POST",
        url: "/tzxblog/openBlog",
        data: {blogId: blogId},
        dataType: "json",
        success: function (data) {
            // console.log(data);
            if (data != null) {
                // console.log(data);
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
                var html = converter.makeHtml(text);
                document.getElementById("curcontent").innerHTML = html;
                //动态加载评论列表
                for (var i = 0; i < data.comList.length; i++) {
                    var elem_li = document.createElement('li');
                    elem_li.innerHTML = data.comList[i].user.userName + ": " + data.comList[i].commentContent;
                    document.getElementById('commInfo').appendChild(elem_li);
                }
                $("#bloglist").hide();
                $("#bloginfo").show();
//				window.location.href="/tzxblog";	
            }
        }
    });
}

function pushcomment() {
//	console.log(blogId);
    var comment = document.getElementById("pushcomm").value;
    console.log(comment);
    $.ajax({
        type: "POST",
        url: "/tzxblog/pushcomment",
        data: {comment: comment},
        dataType: "json",
        success: function (data) {
            console.log(data);
            // window.location.reload(true);
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