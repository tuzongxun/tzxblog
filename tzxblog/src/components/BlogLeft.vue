<template>
	<div class="blog-left">
		<!-- <van-sidebar v-model="activeKey" @change="onChange">
		  <van-sidebar-item v-for="cate in list" :title="cate.name" ><van-icon name="wap-home" /></van-sidebar-item>
		</van-sidebar> -->
		<ul v-model="activeKey">
			<li v-for="cate in list" :class="{chooseli: i===1}" @click="choose(cate.id)"><span style="margin:10px">{{cate.name}}</span></li>
		</ul>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogHome.css"
</style>
<script type="text/javascript">
	import { Notify } from 'vant';
	export default {
		  data() {
		  	var _this=this;
		  	// this.$http.get("json/homeCate.json").then(function(res){
		  	// 	_this.list=res.data;
		  	// });
		  	this.$http.get("http://localhost:8089/tzxblog/blog/category-list").then(function(res){
		  		console.log(res);
		  		_this.list=res.data.data;
		  	});
		    return {
		      i: 0,
		      activeKey: 0,
		      list: []
		    };
		  },
		  methods: {
		    onChange(index) {
		      // Notify({ type: 'primary', message: index });
		    },
		    choose:function(index){
		    	console.log(index);
		    	this.i=1;
		    }
		  }
	}
</script>