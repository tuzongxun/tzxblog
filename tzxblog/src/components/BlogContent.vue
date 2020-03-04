<template>
	<div calss="blog-content">
		<ul>
			<li v-for="blog in blogList" style="margin-bottom:2px;">
				<div class="blog">
<!-- 	private String type;
	private UserInfo userInfo; -->
					<H2>{{blog.title}}</H2>
					<p class="blogDesc">{{blog.desc}}</p>
					<van-row class="blogDetail">
					  <van-col span="10"><van-image round width="1.5rem" height="1.5rem" src="https://avatar.csdnimg.cn/F/6/B/1_tuzongxun_1571283373.jpg"/>{{blog.userInfo.name}}</van-col>
					  <van-col span="2"></van-col>
					 <!--  <van-col span="2"><van-icon name="good-job" />{{blog.blogDetail.fabulousCount}}</van-col>
					  <van-col span="2"><van-icon name="eye" />{{blog.blogDetail.readCount}}</van-col>
					  <van-col span="2"><van-icon name="more" />{{blog.blogDetail.commentCount}}</van-col>
					  <van-col span="2"><van-icon name="share" />{{blog.blogDetail.forwardCount}}</van-col> -->

					   <van-col span="3"><van-icon name="good-job" />213213</van-col>
					  <van-col span="3"><van-icon name="eye" />12332123</van-col>
					  <van-col span="3"><van-icon name="more" />123232133</van-col>
					  <van-col span="3"><van-icon name="share" />213123213</van-col>
					</van-row>
				</div>
				<van-divider />
			</li>
		</ul>
		<van-pagination 
		  v-model="currentPage" 
		  :total-items="125" 
		  :show-page-size="3" 
		  force-ellipses
		/>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogContent.css"
</style>
<script type="text/javascript">
	import Msg from './msg.js';
	export default{
		data(){
			var cateId="1";
			var _this=this;
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"cateId":cateId}}).then(function(res){
					_this.blogList=res.data.data;
				});
			return {
				blogList:[],
				currentPage: 1
			}
		},
		mounted(){
			var _this=this;
			Msg.$on("cateId",function(cateId){
				_this.cateId=cateId;
				this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"cateId":cateId}}).then(function(res){
					_this.blogList=res.data.data;
				});
			});
		}
	}
</script>