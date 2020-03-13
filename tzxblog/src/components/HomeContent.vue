<template>
	<!--博客主要内容区域-->
	<div calss="home-content">
		<ul>
			<li v-for="blog in blogList" style="margin-bottom:2px;">
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
		<van-pagination v-if="blogList.length>0"
		  v-model="currentPage" 
		  :total-items="totalItem" 
		  :show-page-size="5" 
		  :items-per-page="pageSize"
		  @change="choosePage"
		  force-ellipses
		/>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/HomeContent.css"
</style>
<script type="text/javascript">
	import Msg from './msg.js';
	export default{
		data(){
			var cateId=2;
			var currentPage=1;
			var totalItem=0;
			var pageSize=3;
			var _this=this;
			_this.pageSize=pageSize;
			this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"cateId":cateId,"pageIndex":currentPage,"pageSize":pageSize}}).then(function(res){
					_this.blogList=res.data.backData.pageData;
					_this.currentPage=res.data.backData.pageIndex;
					_this.pageSize=res.data.backData.pageSize;
					_this.totalItem=res.data.backData.totalCount;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
			return {
				blogList:[],
				currentPage: currentPage,
				totalItem: totalItem,
				perPage: pageSize,
				value: `<blockquote>
						<p>你好</p>
					</blockquote>
					<p><code>java</code></p>`,
            	defaultData: "preview"
			}
		},
		mounted(){
			var _this=this;
			var pageSize=3;
			_this.pageSize=pageSize;
			Msg.$on("cateId",function(cateId,cuPage){
				_this.cateId=cateId;
				_this.currentPage=cuPage;
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"cateId":cateId,"pageIndex":_this.currentPage,"pageSize":pageSize}}).then(function(res){
					_this.blogList=res.data.backData.pageData;
					_this.currentPage=res.data.backData.pageIndex;
					_this.pageSize=res.data.backData.pageSize;
					_this.totalItem=res.data.backData.totalCount;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
			});
		},
		methods:{
			choosePage(){
				var _this=this;
				var pageSize=3;
				_this.pageSize=pageSize;
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"cateId":_this.cateId,"pageIndex":_this.currentPage,"pageSize":pageSize}}).then(function(res){
					_this.blogList=res.data.backData.pageData;
					_this.currentPage=res.data.backData.pageIndex;
					_this.totalItem=res.data.backData.totalCount;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
			},
			toBlog(homeBlogId,userId){
				Msg.$emit("homeBlogId",homeBlogId,1,userId);
			}
		}
	}
</script>