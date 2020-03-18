<template>
	<div>
		<div class="userDetail">
			<h3 >用户信息</h3>
			<van-divider />
			<ul>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="5" @click="toUserHome(userInfo.id)"><van-image round radius="50px" width="50px" height="50px" :src="userInfo.img"/></van-col>
							<van-col span="19" @click="toUserHome(userInfo.id)">{{userInfo.name}}</van-col>
						</van-row>
					</div>
				</li>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="12">关注：{{userDetailInfo.mefollowCount}}</van-col>
							<van-col span="12">粉丝：{{userDetailInfo.followmeCount}}</van-col>
						</van-row>
					</div>
				</li>
				<li style="margin-bottom:2px;">
					<div class="home">
						<van-row class="homeDetail">
							<van-col span="12">转载：{{userDetailInfo.rdBlogCount}}</van-col>
							<van-col span="12">原创：{{userDetailInfo.blogCount}}</van-col>
						</van-row>
					</div>
				</li>
			</ul>
		</div>
		<div class="blogCate">
			<h3 >博客分类</h3>
			<van-divider />
			<ul>
				<li v-for="cate in cateList" class="cateListLi">
					<van-row class="cateList">
							<van-col span="19" >{{cate.cateName}}</van-col>
							<van-col span="5" class="cateLeft">{{cate.cateCount}}篇</van-col>
					</van-row>
				</li>
			</ul>
		</div>
		<div class="blogFile">
			<h3 >博客归档</h3>
			<van-divider />
			<ul>
				<li v-for="file in fileList" class="cateListLi">
					<van-row class="cateList">
							<van-col span="19" >{{file.cateName}}</van-col>
							<van-col span="5" class="cateLeft">{{file.cateCount}}篇</van-col>
					</van-row>
				</li>
			</ul>
		</div>
	</div>
</template>
<style type="text/css">
	@import "../../public/css/BlogLeft.css"
</style>
<script type="text/javascript">
	import Msg from './msg.js';
	export default{
		data(){
			return{
				userInfo:{
				},
				userDetailInfo:{

				},
				cateList:[
				],
				fileList:[
				]
			}
		},
	methods:{
			getUserInfo:function(userId){
				var _this=this;
				console.log("user:"+userId);
				this.$http.get("http://localhost:8089/tzxblog/user/userinfo",{params:{"userId":userId}}).then(function(res){
					_this.userInfo=res.data.backData;
					console.log("user:"+_this.userInfo);
					_this.userDetailInfo=_this.userInfo.userDetailInfo;
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			},
			getCateList:function(userId){
				var _this=this;
				console.log("user:"+userId);
				this.$http.get("http://localhost:8089/tzxblog/cate/user-cate-list",{params:{"userId":userId}}).then(function(res){
					_this.cateList=res.data.backData;
					console.log("cateList:"+_this.cateList);
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			},
			getFileList:function(userId){
				var _this=this;
				console.log("user:"+userId);
				this.$http.get("http://localhost:8089/tzxblog/cate/user-file-list",{params:{"userId":userId}}).then(function(res){
					_this.fileList=res.data.backData;
					console.log("fileList:"+_this.fileList);
				}).catch(function(error){
					console.log(error);
		  			console.log("系统异常,请稍后再试");
		  		});
			},
			toUserHome:function(userId){
				Msg.$emit("toUserHome",userId);
			}
		},
	mounted(){
			var _this=this;
			Msg.$on("homeBlogId",function(homeBlogId,a,userId){
				_this.userId=userId;
				_this.getUserInfo(userId);
				_this.getCateList(userId);
				_this.getFileList(userId);
			});
	}
}
</script>