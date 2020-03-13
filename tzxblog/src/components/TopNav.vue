<template>
	<!--首页顶部导航-->
	<div class="topNav">
		<div class="navLeft">
			<van-tabs background="white" title-active-color="green" v-model="active" @click="checkType" swipe-threshold="8">
			  <van-tab title="LOGO" type="0"></van-tab>
			  <van-tab title="首页" type="1">
			  	
			  </van-tab>
			  <van-tab title="下载" type="3">
			  	 <Shigong></Shigong>
			  </van-tab>
			  <van-tab title="论坛" type="4">
			  	<Shigong></Shigong>
			  </van-tab>
			  <van-tab title="指南" type="6">
			  	<Shigong></Shigong>
			  </van-tab>
			  <van-tab title="登录" type="7">
			  	<Shigong></Shigong>
			  </van-tab>
			</van-tabs>
		</div>
		<div calss="navRight">
			<p class="userInfo"><a href="" class="userInfo">tuzongxun</a></p>
		</div>
		
	</div>
</template>
<style type="text/css">
	@import "../../public/css/TopNav.css"
</style>
<script type="text/javascript">
	import Msg from "./msg.js"
	import Shigong from "./Shigong.vue"
	export default{
		data(){
			return{
				active:1
			}
		},
		methods:{
			checkType(type){
				console.log(type);
				Msg.$emit("val",type,type);
			}
		},
		components:{
			Shigong
		}
	}
</script>