<template>
	<div class="blogMain">
		<!--博客主要内容区域-->
		<div class="blogContent" v-show="showBlogContent">
			<div class="blogTitle"><h2>{{blogInfo.title}}</h2></div>
			<div class="blogTitle">
				<van-row class="cateList">
					<van-col span="2" ><van-tag type="warning" size="large">{{blogInfo.type}}</van-tag></van-col>
					<van-col span="7" >发布于&nbsp;{{blogInfo.createTime}}</van-col>
					<van-col span="3" >转发：{{blogDetailInfo.forwardCount}}</van-col>
					<van-col span="3" >点赞：{{blogDetailInfo.fabulousCount}}</van-col>
					<van-col span="3" >评论：{{blogDetailInfo.commentCount}}</van-col>
					<van-col span="3" >阅读：{{blogDetailInfo.readCount}}</van-col>
					<van-col span="3" ></van-col>
				</van-row>
			</div>
			</h2>
			<!-- <hr/> -->
			<!-- <article v-html="blogInfo.content" ></article> -->
			 <!-- class="md"  -->
			<mavon-editor :value="blogInfo.content":subfield = "prop.subfield" :defaultOpen = "prop.defaultOpen" :toolbarsFlag = "prop.toolbarsFlag" :editable="prop.editable" :scrollStyle="prop.scrollStyle"></mavon-editor>
		</div>
		<div class="blogContent" v-show="showBlogList">
			<ul>
			<li v-for="blog in userBlogList" style="margin-bottom:2px;">
				<div class="home">
					<H2><a href="#" @click="toBlog(blog.id,blog.userInfo.id)">{{blog.title}}</a></H2>
					<p class="homeDesc">{{blog.desc}}</p>
					<van-row class="homeDetail">
					  <van-col span="10"><van-image round width="25" height="25" :src="blog.userInfo.img"/>{{blog.userInfo.name}}</van-col>
					  <van-col span="2"></van-col>
					  <van-col span="12" class="home-detail">
					  	 <van-icon name="good-job" />{{blog.blogDetailInfo.fabulousCount}}
					  	 <van-icon name="eye" />{{blog.blogDetailInfo.readCount}}
					  	 <van-icon name="more" />{{blog.blogDetailInfo.commentCount}}
					  	 <van-icon name="share" />{{blog.blogDetailInfo.forwardCount}}
					  </van-col>
					</van-row>
				</div>
				<van-divider />
			</li>
		</ul>
		<van-pagination v-if="userBlogList.length>0"
		  v-model="currentPage" 
		  :total-items="totalItem" 
		  :show-page-size="5" 
		  :items-per-page="pageSize"
		  @change="choosePage"
		  force-ellipses
		/>
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
				},
				blogDetailInfo:{

				},
				showBlogContent: true,
				showBlogList: false,
				userBlogList:[],
				currentPage: 1,
				totalItem: 0,
				perPage: 1
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
					_this.blogDetailInfo=_this.blogInfo.blogDetailInfo;
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
			Msg.$on("toUserHome",function(userId){
				var _this=this;
				console.log("userHome:"+userId);
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"userId":userId}}).then(function(res){
					_this.userBlogList=res.data.backData.pageData;
					console.log("userBlogList:"+_this.userBlogList);
					_this.showBlogContent=false;
					_this.showBlogList=true;
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			});
		},
		components:{
			mavonEditor
		}
	}
</script>