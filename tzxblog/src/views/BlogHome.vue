<template>
	<div class="main">
		<div class="topNav">
			<TopNav></TopNav>
		</div>
		<div v-if="type==1" class="blogMain">
			<div class="blogLeft">
				<BlogLeft></BlogLeft>
			</div>
			<div class="blogContent">
				<BlogContent></BlogContent>
			</div>
			<div class="blogRight">
				<BlogRight></BlogRight>
			</div>
		</div>
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