<template>
	<!--首页-->
	<div class="main">
		<!--顶部导航-->
		<div class="topNav">
			<TopNav></TopNav>
		</div>
		<!--博客内容区域-->
		<div v-if="type==1 || type==0" class="homeMain">
			<div v-if="homeCotentType ==1 || homeCotentType ==0">
				<!--博客内容区左侧分类列表-->
				<div >
					<HomeLeft class="homeLeft" v-show="homeLeftShow"></HomeLeft>
					<BlogLeft class="blogLeft" v-show="blogLeftShow"></BlogLeft>
				</div>
				<!--博客主要内容区域-->
				<div >
					<HomeContent class="homeContent" v-show="contentShow"></HomeContent>
					<BlogMain class="blogMain" v-show="blogShow"></BlogMain>
					<!-- <BlogContent v-show="blogShow"></BlogContent> -->
				</div>
				<!--首页右侧信息栏-->
				<div class="homeRight" v-if="rightShow">
					<HomeRight ></HomeRight>
				</div>
			</div>
			<!-- <div v-else-if="homeCotentType == 2">
				
			</div> -->
			
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
	import BlogMain from "../components/BlogMain.vue"
	import BlogLeft from "../components/BlogLeft.vue"
	import BlogContent from "../components/BlogContent.vue"
	export default{
		data(){
			return{
				type:1,
				homeCotentType: 1,
				contentShow: true,
				blogShow: false,
				rightShow: true,
				blogLeftShow: false,
				homeLeftShow: true
			}
		},
		mounted(){
			var _this=this;
			Msg.$on("val",function(m,homeCotentType){
				_this.type=m;
				_this.homeCotentType=homeCotentType;
				_this.contentShow=true;
				_this.blogShow=false;
				_this.rightShow=true;
				_this.blogLeftShow=false;
				_this.homeLeftShow=true;
			});
			Msg.$on("homeBlogId",function(homeBlogId,homeCotentType){
				_this.homeCotentType=homeCotentType;
				_this.contentShow=false;
				_this.blogShow=true;
				_this.rightShow=false;
				_this.blogLeftShow=true;
				_this.homeLeftShow=false;
			})
		},
		components:{
			TopNav,
			HomeLeft,
			HomeRight,
			HomeContent,
			BlogMain,
			BlogLeft,
			BlogContent
		}
	}
</script>