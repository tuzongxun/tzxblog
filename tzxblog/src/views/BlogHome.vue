<template>
	<!--首页-->
	<div class="main">
		<!--顶部导航-->
		<div class="topNav">
			<TopNav></TopNav>
		</div>
		<!--博客内容区域-->
		<div v-if="type==1 || type==0" class="blogMain">
			<!--博客内容区左侧分类列表-->
			<div class="blogLeft">
				<BlogLeft></BlogLeft>
			</div>
			<!--博客主要内容区域-->
			<div class="blogContent">
				<BlogContent></BlogContent>
			</div>
			<!--首页右侧信息栏-->
			<div class="blogRight">
				<BlogRight></BlogRight>
			</div>
		</div>
		<!--登录区域-->
		<div v-else-if="type==2" class="loginPage">
			<div class="loginLeft">
				<!-- <BlogLeft></BlogLeft> -->
				fdsfdsfsdsf
			</div>
		</div>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogHome.css"
</style>
<script type="text/javascript">
	import Msg from "../components/msg.js"
	import TopNav from "../components/TopNav.vue"
	import BlogLeft from "../components/BlogLeft.vue"
	import BlogContent from "../components/BlogContent.vue"
	import BlogRight from "../components/BlogRight.vue"
	export default{
		data(){
			return{
				type:1
			}
		},
		mounted(){
			var _this=this;
			Msg.$on("val",function(m){
				_this.type=m
			})
		},
		components:{
			TopNav,
			BlogLeft,
			BlogRight,
			BlogContent
		}
	}
</script>