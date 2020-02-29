<template>
	<div class="blog-left">
		<van-sidebar v-model="activeKey">
			  <van-sidebar-item title="编程语言" />
			  <van-sidebar-item title="数据库" />
			  <van-sidebar-item title="程序人生" />
			  <van-sidebar-item title="大数据" />
			  <van-sidebar-item title="人工智能" />
		</van-sidebar>
	</div>
</template>
<script type="text/javascript">
	export default {
  		data() {
    		return {
      			activeKey: 0
    		};
  		}
	};
</script>