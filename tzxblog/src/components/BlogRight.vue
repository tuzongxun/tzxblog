<template>
	<!--首页右侧信息栏-->
	<div class="blog-right">
		<div class="tuijian">
			<h3 class="tuijian-title">热门推荐</h3>
			<van-divider />
			<ul>
				<li v-for="blog in recomList" style="margin-bottom:2px;">
					<div class="blog">
						<van-row class="blogDetail">
							<van-col span="5"><van-image width="40" height="40" :src="blog.userInfo.img"/></van-col>
							<van-col span="19">{{blog.title}}</van-col>
						</van-row>
					</div>
				</li>
			</ul>
		</div>
		<div class="tuijian">
			<h3 class="tuijian-title">最新活动</h3>
			<van-divider />
			<ul>
				<li v-for="blog in hotList" style="margin-bottom:2px;">
					<div class="blog">
						<van-row class="blogDetail">
							<van-col span="5"><van-image width="40" height="40" :src="blog.userInfo.img"/></van-col>
							<van-col span="19">{{blog.title}}</van-col>
						</van-row>
					</div>
				</li>
			</ul>
		</div>
		<div class="tuijian">
			<h3 class="tuijian-title">官网公告</h3>
			<van-divider />
			<ul>
				<li v-for="blog in noticeList" style="margin-bottom:2px;">
					<div class="blog">
						<van-row class="blogDetail">
							<van-col span="5"><van-image width="40" height="40" :src="blog.userInfo.img"/></van-col>
							<van-col span="19">{{blog.title}}</van-col>
						</van-row>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogRight.css"
</style>
<script type="text/javascript">
	export default{
		data(){
			var currentPage=1;
			var pageSize=5;
			var _this=this;
			this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"queryType":"recom","pageIndex":currentPage,"pageSize":pageSize}}).then(function(res){
					_this.recomList=res.data.data.pageData;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
		  	this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"queryType":"hot","pageIndex":currentPage,"pageSize":pageSize}}).then(function(res){
					_this.hotList=res.data.data.pageData;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
		  	this.$http.get("http://localhost:8089/tzxblog/blog/blog-list",{params:{"queryType":"notice","pageIndex":currentPage,"pageSize":pageSize}}).then(function(res){
					_this.noticeList=res.data.data.pageData;
				}).catch(function(error){
		  			window.alert("系统异常,请稍后再试");
		  		});
			return{
				hotList:[],
				noticeList:[],
				recomList:[]
			}
		}
	}
</script>