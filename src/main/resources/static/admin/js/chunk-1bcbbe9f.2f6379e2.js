(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1bcbbe9f","chunk-9df782ba","chunk-22e9a9e5","chunk-2d226174","chunk-2d20edb7","chunk-2d22ba00"],{2151:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("nav",{staticClass:"site-navbar",class:"site-navbar--"+t.navbarLayoutType},[n("div",{staticClass:"site-navbar__header"},[n("h1",{staticClass:"site-navbar__brand",on:{click:function(e){return t.$router.push({name:"home"})}}},[n("a",{staticClass:"site-navbar__brand-lg",attrs:{href:"javascript:;"}},[t._v("网站管理系统")]),n("a",{staticClass:"site-navbar__brand-mini",attrs:{href:"javascript:;"}},[t._v("W")])])]),n("div",{staticClass:"site-navbar__body clearfix"},[n("el-menu",{staticClass:"site-navbar__menu",attrs:{mode:"horizontal"}},[n("el-menu-item",{staticClass:"site-navbar__switch",attrs:{index:"0"},on:{click:function(e){t.sidebarFold=!t.sidebarFold}}},[n("i",{class:t.sidebarFold?"el-icon-s-unfold":"el-icon-s-fold"})])],1),n("el-menu",{staticClass:"site-navbar__menu site-navbar__menu--right",attrs:{mode:"horizontal"}},[n("el-menu-item",{attrs:{index:"1"},on:{click:function(e){return t.$router.push({name:"theme"})}}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-setting"})])],2),t.isAuth("wx:wxaccount:list")?n("el-menu-item",{attrs:{index:"2"}},[n("template",{slot:"title"},[n("wx-account-selector")],1)],2):t._e(),n("el-menu-item",{staticClass:"site-navbar__avatar",attrs:{index:"3"}},[n("el-dropdown",{attrs:{"show-timeout":0,placement:"bottom"}},[n("span",{staticClass:"el-dropdown-link"},[t._v(" "+t._s(t.userName)+" ")]),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{nativeOn:{click:function(e){return t.updatePasswordHandle()}}},[t._v("修改密码")]),n("el-dropdown-item",{nativeOn:{click:function(e){return t.logoutHandle()}}},[t._v("退出")])],1)],1)],1)],1)],1),t.updatePassowrdVisible?n("update-password",{ref:"updatePassowrd"}):t._e()],1)},s=[],i=(n("b0c0"),n("b0c6")),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-select",{directives:[{name:"loading",rawName:"v-loading",value:t.dataListLoading,expression:"dataListLoading"}],attrs:{size:"small",filterable:""},on:{change:t.selectAccount},model:{value:t.selectedAppid,callback:function(e){t.selectedAppid=e},expression:"selectedAppid"}},t._l(t.accountList,(function(e){return n("el-option",{key:e.appid,attrs:{label:e.name+"（"+t.ACCOUNT_TYPES[e.type]+"）",value:e.appid}})})),1)},r=[],u=n("2f62"),c={data:function(){return{dataListLoading:!1}},computed:Object(u["b"])({accountList:function(t){return t.wxAccount.accountList},ACCOUNT_TYPES:function(t){return t.wxAccount.ACCOUNT_TYPES},selectedAppid:function(t){return t.wxAccount.selectedAppid}}),mounted:function(){this.getDataList()},methods:{getDataList:function(){var t=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/manage/wxAccount/list"),method:"get"}).then((function(e){var n=e.data;n&&200===n.code&&(t.$store.commit("wxAccount/updateAccountList",n.list),n.list.length||t.$message.info("公众号列表为空，请先添加")),t.dataListLoading=!1}))},selectAccount:function(t){this.selectedAppid!=t&&this.$store.commit("wxAccount/selectAccount",t)}}},m=c,l=n("2877"),d=Object(l["a"])(m,o,r,!1,null,null,null),f=d.exports,h=n("ed08"),p={data:function(){return{updatePassowrdVisible:!1}},components:{UpdatePassword:i["default"],WxAccountSelector:f},computed:{navbarLayoutType:{get:function(){return this.$store.state.common.navbarLayoutType}},sidebarFold:{get:function(){return this.$store.state.common.sidebarFold},set:function(t){this.$store.commit("common/updateSidebarFold",t)}},mainTabs:{get:function(){return this.$store.state.common.mainTabs},set:function(t){this.$store.commit("common/updateMainTabs",t)}},userName:{get:function(){return this.$store.state.user.name}}},methods:{updatePasswordHandle:function(){var t=this;this.updatePassowrdVisible=!0,this.$nextTick((function(){t.$refs.updatePassowrd.init()}))},logoutHandle:function(){var t=this;this.$confirm("确定进行[退出]操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.$http({url:t.$http.adornUrl("/sys/logout"),method:"post",data:t.$http.adornData()}).then((function(e){var n=e.data;n&&200===n.code&&(Object(h["b"])(),t.$router.push({name:"login"}))}))})).catch((function(){}))}}},b=p,v=Object(l["a"])(b,a,s,!1,null,null,null);e["default"]=v.exports},"7f94":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:t.loading,expression:"loading",modifiers:{fullscreen:!0,lock:!0}}],staticClass:"site-wrapper",class:{"site-sidebar--fold":t.sidebarFold},attrs:{"element-loading-text":"拼命加载中"}},[t.loading?t._e():[n("main-navbar"),n("main-sidebar"),n("div",{staticClass:"site-content__wrapper",style:{"min-height":t.documentClientHeight+"px"}},[t.$store.state.common.contentIsNeedRefresh?t._e():n("main-content")],1)]],2)},s=[],i=(n("b0c0"),n("2151")),o=n("b8e5"),r=n("e6d1"),u={provide:function(){return{refresh:function(){var t=this;this.$store.commit("common/updateContentIsNeedRefresh",!0),this.$nextTick((function(){t.$store.commit("common/updateContentIsNeedRefresh",!1)}))}}},data:function(){return{loading:!0}},components:{MainNavbar:i["default"],MainSidebar:o["default"],MainContent:r["default"]},computed:{documentClientHeight:{get:function(){return this.$store.state.common.documentClientHeight},set:function(t){this.$store.commit("common/updateDocumentClientHeight",t)}},sidebarFold:{get:function(){return this.$store.state.common.sidebarFold}},userId:{get:function(){return this.$store.state.user.id},set:function(t){this.$store.commit("user/updateId",t)}},userName:{get:function(){return this.$store.state.user.name},set:function(t){this.$store.commit("user/updateName",t)}}},created:function(){this.getUserInfo()},mounted:function(){this.resetDocumentClientHeight()},methods:{resetDocumentClientHeight:function(){var t=this;this.documentClientHeight=document.documentElement["clientHeight"],window.onresize=function(){t.documentClientHeight=document.documentElement["clientHeight"]}},getUserInfo:function(){var t=this;this.$http({url:this.$http.adornUrl("/sys/user/info"),method:"get",params:this.$http.adornParams()}).then((function(e){var n=e.data;n&&200===n.code&&(t.loading=!1,t.userId=n.user.userId,t.userName=n.user.username)}))}}},c=u,m=n("2877"),l=Object(m["a"])(c,a,s,!1,null,null,null);e["default"]=l.exports},b0c6:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-dialog",{attrs:{title:"修改密码",visible:t.visible,"append-to-body":!0},on:{"update:visible":function(e){t.visible=e}}},[n("el-form",{ref:"dataForm",attrs:{model:t.dataForm,rules:t.dataRule,"label-width":"80px"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.dataFormSubmit()}}},[n("el-form-item",{attrs:{label:"账号"}},[n("span",[t._v(t._s(t.userName))])]),n("el-form-item",{attrs:{label:"原密码",prop:"password"}},[n("el-input",{attrs:{type:"password"},model:{value:t.dataForm.password,callback:function(e){t.$set(t.dataForm,"password",e)},expression:"dataForm.password"}})],1),n("el-form-item",{attrs:{label:"新密码",prop:"newPassword"}},[n("el-input",{attrs:{type:"password"},model:{value:t.dataForm.newPassword,callback:function(e){t.$set(t.dataForm,"newPassword",e)},expression:"dataForm.newPassword"}})],1),n("el-form-item",{attrs:{label:"确认密码",prop:"confirmPassword"}},[n("el-input",{attrs:{type:"password"},model:{value:t.dataForm.confirmPassword,callback:function(e){t.$set(t.dataForm,"confirmPassword",e)},expression:"dataForm.confirmPassword"}})],1)],1),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(e){t.visible=!1}}},[t._v("取消")]),n("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.dataFormSubmit()}}},[t._v("确定")])],1)],1)},s=[],i=(n("b0c0"),n("ac1f"),n("5319"),n("ed08")),o={data:function(){var t=this,e=function(e,n,a){t.dataForm.newPassword!==n?a(new Error("确认密码与新密码不一致")):a()};return{visible:!1,dataForm:{password:"",newPassword:"",confirmPassword:""},dataRule:{password:[{required:!0,message:"原密码不能为空",trigger:"blur"}],newPassword:[{required:!0,message:"新密码不能为空",trigger:"blur"}],confirmPassword:[{required:!0,message:"确认密码不能为空",trigger:"blur"},{validator:e,trigger:"blur"}]}}},computed:{userName:{get:function(){return this.$store.state.user.name}},mainTabs:{get:function(){return this.$store.state.common.mainTabs},set:function(t){this.$store.commit("common/updateMainTabs",t)}}},methods:{init:function(){var t=this;this.visible=!0,this.$nextTick((function(){t.$refs["dataForm"].resetFields()}))},dataFormSubmit:function(){var t=this;this.$refs["dataForm"].validate((function(e){e&&t.$http({url:t.$http.adornUrl("/sys/user/password"),method:"post",data:t.$http.adornData({password:t.dataForm.password,newPassword:t.dataForm.newPassword})}).then((function(e){var n=e.data;n&&200===n.code?t.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){t.visible=!1,t.$nextTick((function(){t.mainTabs=[],Object(i["b"])(),t.$router.replace({name:"login"})}))}}):t.$message.error(n.msg)}))}))}}},r=o,u=n("2877"),c=Object(u["a"])(r,a,s,!1,null,null,null);e["default"]=c.exports},b8e5:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("aside",{staticClass:"site-sidebar",class:"site-sidebar--"+t.sidebarLayoutSkin},[n("div",{staticClass:"site-sidebar__inner"},[n("el-menu",{staticClass:"site-sidebar__menu",attrs:{"default-active":t.menuActiveName||"home",collapse:t.sidebarFold,collapseTransition:!1}},[n("el-menu-item",{attrs:{index:"home"},on:{click:function(e){return t.$router.push({name:"home"})}}},[n("i",{staticClass:"site-sidebar__menu-icon el-icon-s-home"}),n("span",{attrs:{slot:"title"},slot:"title"},[t._v("首页")])]),t._l(t.menuList,(function(e){return n("sub-menu",{key:e.menuId,attrs:{menu:e,dynamicMenuRoutes:t.dynamicMenuRoutes}})}))],2)],1)])},s=[],i=(n("99af"),n("4de4"),n("b0c0"),n("f088")),o=n("61f7"),r={data:function(){return{dynamicMenuRoutes:[]}},components:{SubMenu:i["default"]},computed:{sidebarLayoutSkin:{get:function(){return this.$store.state.common.sidebarLayoutSkin}},sidebarFold:{get:function(){return this.$store.state.common.sidebarFold}},menuList:{get:function(){return this.$store.state.common.menuList},set:function(t){this.$store.commit("common/updateMenuList",t)}},menuActiveName:{get:function(){return this.$store.state.common.menuActiveName},set:function(t){this.$store.commit("common/updateMenuActiveName",t)}},mainTabs:{get:function(){return this.$store.state.common.mainTabs},set:function(t){this.$store.commit("common/updateMainTabs",t)}},mainTabsActiveName:{get:function(){return this.$store.state.common.mainTabsActiveName},set:function(t){this.$store.commit("common/updateMainTabsActiveName",t)}}},watch:{$route:"routeHandle"},created:function(){this.menuList=JSON.parse(sessionStorage.getItem("menuList")||"[]"),this.dynamicMenuRoutes=JSON.parse(sessionStorage.getItem("dynamicMenuRoutes")||"[]"),this.routeHandle(this.$route)},methods:{routeHandle:function(t){if(t.meta.isTab){var e=this.mainTabs.filter((function(e){return e.name===t.name}))[0];if(!e){if(t.meta.isDynamic&&(t=this.dynamicMenuRoutes.filter((function(e){return e.name===t.name}))[0],!t))return console.error("未能找到可用标签页!");e={menuId:t.meta.menuId||t.name,name:t.name,title:t.meta.title,type:Object(o["c"])(t.meta.iframeUrl)?"iframe":"module",iframeUrl:t.meta.iframeUrl||"",params:t.params,query:t.query},this.mainTabs=this.mainTabs.concat(e)}this.menuActiveName=e.menuId+"",this.mainTabsActiveName=e.name}}}},u=r,c=n("2877"),m=Object(c["a"])(u,a,s,!1,null,null,null);e["default"]=m.exports},e6d1:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("main",{staticClass:"site-content",class:{"site-content--tabs":t.$route.meta.isTab}},[t.$route.meta.isTab?n("el-tabs",{attrs:{closable:!0},on:{"tab-click":t.selectedTabHandle,"tab-remove":t.removeTabHandle},model:{value:t.mainTabsActiveName,callback:function(e){t.mainTabsActiveName=e},expression:"mainTabsActiveName"}},[n("el-dropdown",{staticClass:"site-tabs__tools",attrs:{"show-timeout":0}},[n("i",{staticClass:"el-icon-arrow-down el-icon--right"}),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{nativeOn:{click:function(e){return t.tabsCloseCurrentHandle(e)}}},[t._v("关闭当前标签页")]),n("el-dropdown-item",{nativeOn:{click:function(e){return t.tabsCloseOtherHandle(e)}}},[t._v("关闭其它标签页")]),n("el-dropdown-item",{nativeOn:{click:function(e){return t.tabsCloseAllHandle(e)}}},[t._v("关闭全部标签页")]),n("el-dropdown-item",{nativeOn:{click:function(e){return t.refresh()}}},[t._v("刷新当前标签页")])],1)],1),t._l(t.mainTabs,(function(e){return n("el-tab-pane",{key:e.name,attrs:{label:e.title,name:e.name}},[n("el-card",{attrs:{"body-style":t.siteContentViewHeight}},["iframe"===e.type?n("iframe",{attrs:{src:e.iframeUrl,width:"100%",height:"100%",frameborder:"0",scrolling:"yes"}}):n("keep-alive",[e.name===t.mainTabsActiveName?n("router-view"):t._e()],1)],1)],1)}))],2):n("el-card",{attrs:{"body-style":t.siteContentViewHeight}},[n("keep-alive",[n("router-view")],1)],1)],1)},s=[],i=(n("4de4"),n("b0c0"),n("61f7")),o={inject:["refresh"],data:function(){return{}},computed:{documentClientHeight:{get:function(){return this.$store.state.common.documentClientHeight}},menuActiveName:{get:function(){return this.$store.state.common.menuActiveName},set:function(t){this.$store.commit("common/updateMenuActiveName",t)}},mainTabs:{get:function(){return this.$store.state.common.mainTabs},set:function(t){this.$store.commit("common/updateMainTabs",t)}},mainTabsActiveName:{get:function(){return this.$store.state.common.mainTabsActiveName},set:function(t){this.$store.commit("common/updateMainTabsActiveName",t)}},siteContentViewHeight:function(){var t=this.documentClientHeight-50-30-2;return this.$route.meta.isTab?(t-=40,Object(i["c"])(this.$route.meta.iframeUrl)?{height:t+"px"}:{minHeight:t+"px"}):{minHeight:t+"px"}}},methods:{selectedTabHandle:function(t){t=this.mainTabs.filter((function(e){return e.name===t.name})),t.length>=1&&this.$router.push({name:t[0].name,query:t[0].query,params:t[0].params})},removeTabHandle:function(t){this.$store.commit("common/removeTab",t)},tabsCloseCurrentHandle:function(){this.removeTabHandle(this.mainTabsActiveName)},tabsCloseOtherHandle:function(){var t=this;this.mainTabs=this.mainTabs.filter((function(e){return e.name===t.mainTabsActiveName}))},tabsCloseAllHandle:function(){this.mainTabs=[],this.menuActiveName="",this.$router.push({name:"home"})},tabsRefreshCurrentHandle:function(){var t=this,e=this.$route;this.removeTabHandle(e.name),this.$nextTick((function(){t.$router.push({name:e.name,query:e.query,params:e.params})}))}}},r=o,u=n("2877"),c=Object(u["a"])(r,a,s,!1,null,null,null);e["default"]=c.exports},f088:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return t.menu.list&&t.menu.list.length>=1?n("el-submenu",{attrs:{index:t.menu.menuId+"","popper-class":"site-sidebar--"+t.sidebarLayoutSkin+"-popper"}},[n("template",{slot:"title"},[n("i",{staticClass:"site-sidebar__menu-icon",class:t.menu.icon}),n("span",[t._v(t._s(t.menu.name))])]),t._l(t.menu.list,(function(e){return n("sub-menu",{key:e.menuId,attrs:{menu:e,dynamicMenuRoutes:t.dynamicMenuRoutes}})}))],2):n("el-menu-item",{attrs:{index:t.menu.menuId+""},on:{click:function(e){return t.gotoRouteHandle(t.menu)}}},[n("i",{staticClass:"site-sidebar__menu-icon fa",class:t.menu.icon}),n("span",[t._v(t._s(t.menu.name))])])},s=[],i=(n("4de4"),n("b0c0"),{name:"sub-menu",props:{menu:{type:Object,required:!0},dynamicMenuRoutes:{type:Array,required:!0}},components:{SubMenu:c},computed:{sidebarLayoutSkin:{get:function(){return this.$store.state.common.sidebarLayoutSkin}}},methods:{gotoRouteHandle:function(t){var e=this.dynamicMenuRoutes.filter((function(e){return e.meta.menuId===t.menuId}));e.length>=1&&this.$router.push({name:e[0].name})}}}),o=i,r=n("2877"),u=Object(r["a"])(o,a,s,!1,null,null,null),c=e["default"]=u.exports}}]);