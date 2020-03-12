<template>
	<div>
		<div class="userDetail">
			<h3 >用户信息</h3>
			<van-divider />
			<ul>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="5"><van-image round radius="200px" width="100px" height="100px" :src="userInfo.img"/></van-col>
							<van-col span="19">{{userInfo.name}}</van-col>
						</van-row>
					</div>
				</li>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="12">关注：{{userInfo.guanzhu}}</van-col>
							<van-col span="12">粉丝：{{userInfo.fensi}}</van-col>
						</van-row>
					</div>
				</li>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="12">转载：{{userInfo.zhuanzai}}</van-col>
							<van-col span="12">原创：{{userInfo.yuanchuang}}</van-col>
						</van-row>
					</div>
				</li>
			</ul>
		</div>
		<div class="blogCate">
			<h3 >博客分类</h3>
			<van-divider />
			<ul>
				<li v-for="cate in cateList" style="margin-bottom:2px;">
					{{cate.name}}&nbsp;&nbsp;({{cate.count}})
					<!-- <div class="home">
						<van-row class="homeDetail">
							<van-col span="5"><van-image width="40" height="40" :src="blog.userInfo.img"/></van-col>
							<van-col span="19">{{blog.title}}</van-col>
						</van-row>
					</div> -->
				</li>
			</ul>
		</div>
		<div class="blogFile">
			<h3 >博客归档</h3>
			<van-divider />
			<ul>
				<li v-for="file in fileList" style="margin-bottom:2px;">
					{{file.name}}&nbsp;&nbsp;({{file.count}})
					<!-- <div class="home">
						<van-row class="homeDetail">
							<van-col span="5"><van-image width="40" height="40" :src="blog.userInfo.img"/></van-col>
							<van-col span="19">{{blog.title}}</van-col>
						</van-row>
					</div> -->
				</li>
			</ul>
		</div>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogLeft.css"
</style>
<script type="text/javascript">
	export default{
		data(){
			return{
				userInfo:{
					img:"http://localhost:8089/static/t1.jpg",
					name: "tuzongxun",
					guanzhu: 1000,
					fensi: 9999,
					yuanchuang: 120,
					zhuanzai: 23
				},
				cateList:[
					{
						name: "java",
						count: 5
					},
					{
						name: "数据库",
						count: 51
					},
					{
						name: "前端",
						count: 15
					},
					{
						name: "运维",
						count: 11
					},
					{
						name: "程序人生",
						count: 8
					}
				],
				fileList:[
					{
						name: "3月",
						count: 2
					},
					{
						name: "2月",
						count: 8
					},
					{
						name: "1月",
						count: 24
					},
					{
						name: "12月",
						count: 12
					},
					{
						name: "11月",
						count: 5
					}
				]
			}
		}
	}
</script>