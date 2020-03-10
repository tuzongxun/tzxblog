<template>
	<!--首页-->
	<div class="main">
		<!--顶部导航-->
		<div class="topNav">
			<TopNav></TopNav>
		</div>
		<!--博客内容区域-->
		<div v-if="type==1 || type==0" class="homeMain">
			<!--博客内容区左侧分类列表-->
			<div class="homeLeft">
				<HomeLeft></HomeLeft>
			</div>
			<!--博客主要内容区域-->
			<div class="homeContent">
				<HomeContent></HomeContent>
			</div>
			<!--首页右侧信息栏-->
			<div class="homeRight">
				<HomeRight></HomeRight>
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
	@import "../../public/css/Home.css"
</style>
<script type="text/javascript">
	import Msg from "../components/msg.js"
	import TopNav from "../components/TopNav.vue"
	import HomeLeft from "../components/HomeLeft.vue"
	import HomeContent from "../components/HomeContent.vue"
	import HomeRight from "../components/HomeRight.vue"
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
			HomeLeft,
			HomeRight,
			HomeContent
		}
	}
</script>