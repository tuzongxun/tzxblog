<template>
	<div>
		<van-tabs swipe-threshold="6" background="black" title-active-color="green" v-model="active">
			<van-tab title="LOGO" disabled="true" border="false">
	  			<BlogLeft></BlogLeft>
	  		</van-tab>
	  		<van-tab title="首页">
	  			<BlogLeft></BlogLeft>
	  		</van-tab>
	  		<van-tab title="博客">
	  			<div width="500px" height="500px" background="red"></div>
	  		</van-tab>
	  		<van-tab title="论坛">
	  			
	  		</van-tab>
	  		<van-tab title="下载">
	  			
	  		</van-tab>
	  		<van-tab title="登录">
	  			
	  		</van-tab>
		</van-tabs>
	</div>
</template>
<script type="text/javascript">
	import BlogLeft from "../components/BlogLeft.vue"
	export default {
  		data() {
    		return {
      			active: 1
    		};
  		},
  		components:{
			BlogLeft
		}
	}
</script>