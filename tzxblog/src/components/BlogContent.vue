<template>
	<div>
		<article v-html="value" ></article>
	</div>
</template>
<script type="text/javascript">
	import Msg from "../components/msg.js"
	export default {
    data() {
        return {//value的值是经过markdown解析后的文本，可使用`@change="changeData"`在控制台打印显示
            value: `<blockquote>
						<p>你好</p>
					</blockquote>
					<p><code>java</code></p>`,
            defaultData: "preview"
        };
    },
    methods:{
			getBlog:function(blogId){
				var _this=this;
				console.log("hbbbbb:"+blogId);
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-detail",{params:{"blogId":blogId}}).then(function(res){
					console.log(res.data);
					_this.blogInfo=res.data.backData;
					_this.value=_this.blogInfo.content;
					console.log("a-bb:"+_this.blogInfo);
					
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			}
			/*compiledMarkdown:function (blogInfo) {
        		//this.articleDetail.context数据
        		return marked(blogInfo.content, { sanitize: true })
       		}*/
		},
		mounted(){
			var _this=this;
			Msg.$on("homeBlogId",function(homeBlogId,a){
				_this.homeBlogId=homeBlogId;
				console.log("博客详情");
				_this.getBlog(homeBlogId);
			});
		}
};
</script>