(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-591507ee"],{"466d":function(a,t,e){"use strict";var r=e("d784"),o=e("825a"),l=e("50c4"),i=e("1d80"),n=e("8aa5"),s=e("14c3");r("match",1,(function(a,t,e){return[function(t){var e=i(this),r=void 0==t?void 0:t[a];return void 0!==r?r.call(t,e):new RegExp(t)[a](String(e))},function(a){var r=e(t,a,this);if(r.done)return r.value;var i=o(a),m=String(this);if(!i.global)return s(i,m);var d=i.unicode;i.lastIndex=0;var c,p=[],u=0;while(null!==(c=s(i,m))){var f=String(c[0]);p[u]=f,""===f&&(i.lastIndex=n(m,l(i.lastIndex),d)),u++}return 0===u?null:p}]}))},8034:function(a,t,e){},"8c63":function(a,t,e){"use strict";e.r(t);var r=function(){var a=this,t=a.$createElement,e=a._self._c||t;return e("el-dialog",{attrs:{title:"模板配置","close-on-click-modal":!1,visible:a.visible},on:{"update:visible":function(t){a.visible=t}}},[e("el-form",{ref:"dataForm",attrs:{model:a.dataForm,rules:a.dataRule,"label-width":"100px",size:"mini"}},[e("el-form-item",{attrs:{label:"标题",prop:"title"}},[e("el-input",{attrs:{placeholder:"标题"},model:{value:a.dataForm.title,callback:function(t){a.$set(a.dataForm,"title",t)},expression:"dataForm.title"}})],1),e("el-form-item",{attrs:{label:"链接",prop:"url"}},[e("el-input",{attrs:{placeholder:"跳转链接"},model:{value:a.dataForm.url,callback:function(t){a.$set(a.dataForm,"url",t)},expression:"dataForm.url"}})],1),e("div",[e("el-form-item",{attrs:{label:"小程序appid",prop:"miniprogram.appid"}},[e("el-input",{attrs:{placeholder:"小程序appid"},model:{value:a.dataForm.miniprogram.appid,callback:function(t){a.$set(a.dataForm.miniprogram,"appid",t)},expression:"dataForm.miniprogram.appid"}})],1),e("el-form-item",{attrs:{label:"小程序路径",prop:"miniprogram.pagePath"}},[e("el-input",{attrs:{placeholder:"小程序pagePath"},model:{value:a.dataForm.miniprogram.pagePath,callback:function(t){a.$set(a.dataForm.miniprogram,"pagePath",t)},expression:"dataForm.miniprogram.pagePath"}})],1)],1),e("el-row",[e("el-col",{attrs:{span:16}},[e("el-form-item",{attrs:{label:"模版名称",prop:"name"}},[e("el-input",{attrs:{placeholder:"模版名称"},model:{value:a.dataForm.name,callback:function(t){a.$set(a.dataForm,"name",t)},expression:"dataForm.name"}})],1)],1),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"有效",prop:"status"}},[e("el-switch",{attrs:{placeholder:"是否有效","active-value":!0,"inactive-value":!1},model:{value:a.dataForm.status,callback:function(t){a.$set(a.dataForm,"status",t)},expression:"dataForm.status"}})],1)],1)],1),e("div",{staticClass:"form-group-area"},[e("el-form-item",{staticClass:"form-group-title"},[a._v("消息填充数据，请对照模板内容填写")]),e("el-form-item",[e("el-input",{attrs:{type:"textarea",disabled:"",autosize:"",placeholder:"模版"},model:{value:a.dataForm.content,callback:function(t){a.$set(a.dataForm,"content",t)},expression:"dataForm.content"}})],1),a._l(a.dataForm.data,(function(t,r){return e("el-row",{key:t.name},[e("el-col",{attrs:{span:16}},[e("el-form-item",{attrs:{label:t.name,prop:"data."+r+".value",rules:[{required:!0,message:"填充内容不得为空",trigger:"blur"}]}},[e("el-input",{attrs:{type:"textarea",autosize:"",rows:"1",placeholder:"填充内容"},model:{value:t.value,callback:function(e){a.$set(t,"value",e)},expression:"item.value"}})],1)],1),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"颜色"}},[e("el-input",{attrs:{type:"color",placeholder:"颜色"},model:{value:t.color,callback:function(e){a.$set(t,"color",e)},expression:"item.color"}})],1)],1)],1)}))],2)],1),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(t){a.visible=!1}}},[a._v("取消")]),e("el-button",{attrs:{type:"primary"},on:{click:function(t){return a.dataFormSubmit()}}},[a._v("确定")])],1)],1)},o=[],l=(e("d81d"),e("ac1f"),e("466d"),e("5319"),{data:function(){return{visible:!1,dataForm:{id:0,templateId:"",title:"",data:[],url:"",miniprogram:{appid:"",pagePath:""},content:"",status:!0,name:""},dataRule:{title:[{required:!0,message:"标题不能为空",trigger:"blur"}],data:[{required:!0,message:"内容不能为空",trigger:"blur"}],name:[{required:!0,message:"模版名称不能为空",trigger:"blur"}]}}},methods:{init:function(a){var t=this;console.log("init",a),this.dataForm.id=a||0,this.visible=!0,this.$nextTick((function(){t.$refs["dataForm"].resetFields(),t.dataForm.id&&t.$http({url:t.$http.adornUrl("/manage/msgTemplate/info/".concat(t.dataForm.id)),method:"get",params:t.$http.adornParams()}).then((function(a){var e=a.data;e&&200===e.code?t.transformTemplate(e.msgTemplate):t.$message.error(e.msg)}))}))},transformTemplate:function(a){if(a.miniprogram||(a.miniprogram={appid:"",pagePath:""}),a.data instanceof Array)this.dataForm=a;else{a.data=[];var t=a.content.match(/\{\{(\w*)\.DATA\}\}/g)||[];t.map((function(t){name=t.replace("{{","").replace(".DATA}}",""),a.data.push({name:name,value:"",color:"#000000"})})),this.dataForm=a}},dataFormSubmit:function(){var a=this;this.$refs["dataForm"].validate((function(t){t&&a.$http({url:a.$http.adornUrl("/manage/msgTemplate/".concat(a.dataForm.id?"update":"save")),method:"post",data:a.$http.adornData(a.dataForm)}).then((function(t){var e=t.data;e&&200===e.code?a.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){a.visible=!1,a.$emit("refreshDataList")}}):a.$message.error(e.msg)}))}))}}}),i=l,n=(e("d6e1"),e("2877")),s=Object(n["a"])(i,r,o,!1,null,"14548673",null);t["default"]=s.exports},d6e1:function(a,t,e){"use strict";var r=e("8034"),o=e.n(r);o.a}}]);