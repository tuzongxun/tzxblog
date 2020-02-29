<template>
	<div class="main">
		<div class="topNav">
			<TopNav></TopNav>
		</div>
		<!-- <div class="leftNav">
			<Left></Left>
		</div> -->
	</div>
</template>
<script type="text/javascript">
	import TopNav from "../components/TopNav.vue"
	import BlogLeft from "../components/BlogLeft.vue"
	export default{
		components:{
			TopNav,
			BlogLeft
		}
	}
</script>