<template>
	<div class="blogMain">
		<!--博客主要内容区域-->
		<div class="blogContent">
			<!-- <HomeContent></HomeContent> -->
			<div class="blogTitle"><h2>{{blogInfo.title}}</h2></div>
			<!-- <hr/> -->
			<!-- <article v-html="blogInfo.content" ></article> -->
			 <!-- class="md"  -->
			<mavon-editor :value="blogInfo.content":subfield = "prop.subfield" :defaultOpen = "prop.defaultOpen" :toolbarsFlag = "prop.toolbarsFlag" :editable="prop.editable" :scrollStyle="prop.scrollStyle"></mavon-editor>
		</div>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogMain.css"
</style>
<script type="text/javascript">
	import Msg from "./msg.js";
	// import marked from 'marked';
	import {mavonEditor} from "mavon-editor";
	import "mavon-editor/dist/css/index.css";
	export default{
		data(){
			return{
				blogInfo: {
				}
			}
		},
		computed: {
	        prop () {
	          let data = {
	            subfield: false,// 单双栏模式
	            defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域 
	            editable: false,
	            toolbarsFlag: false,
	            scrollStyle: true
	          }
	          return data
	        }
	        
      	},
		methods:{
			getBlog:function(blogId){
				var _this=this;
				console.log("hbbbbb:"+blogId);
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-detail",{params:{"blogId":blogId}}).then(function(res){
					console.log(res.data);
					_this.blogInfo=res.data.backData;
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
		},
		components:{
			mavonEditor
		}
	}
</script>