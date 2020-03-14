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
			<div class="navRight-left">
				<van-notice-bar text="通知内容水电费来将SD卡费加快速度缴费流水防静电收费单据送京东方快结束了肯德基弗兰卡时代峻峰" left-icon="volume-o" />
			</div>
			<div class="navRight-right">
				<p class="userInfo"><a href="" class="userInfo">tuzongxun</a></p>
			</div>		
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