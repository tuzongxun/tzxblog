<template>
	<div class="blogMain">
		<!--博客主要内容区域-->
		<div class="blogContent">
			<!-- <HomeContent></HomeContent> -->
			<div class="blogTitle"><h2>{{blogInfo.title}}</h2></div>
			<div class="blogTitle">
				<van-row class="cateList">
					<van-col span="2" ><van-tag type="warning" size="large">{{blogInfo.type}}</van-tag></van-col>
					<van-col span="7" >发布于&nbsp;{{blogInfo.createTime}}</van-col>
					<van-col span="3" >阅读：{{blogInfo.blogDetailInfo.readCount}}</van-col>
					<van-col span="3" >评论：{{blogInfo.blogDetailInfo.commentCount}}</van-col>
					<van-col span="3" >转发：{{blogInfo.blogDetailInfo.forwardCount}}</van-col>
					<van-col span="3" >点赞：{{blogInfo.blogDetailInfo.fabulousCount}}</van-col>
					<van-col span="3" ></van-col>
				</van-row>
			</div>
			</h2>
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
					console.log("a-bb:"+JSON.stringify(_this.blogInfo));
					
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			}
		},
		mounted(){
			var _this=this;
			Msg.$on("homeBlogId",function(homeBlogId,a,userId){
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