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
                $("#bloglist").hide();
                $("#bloginfo").show();
//				window.location.href="/tzxblog";	
			}
		}
    });
}