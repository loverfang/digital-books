(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e9708"],{"8e16":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:"新增/修改","close-on-click-modal":!1,visible:e.visible},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm,rules:e.dataRule,"label-width":"100px"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.dataFormSubmit()}}},[a("el-form-item",{attrs:{label:"公众号名称",prop:"name"}},[a("el-input",{attrs:{placeholder:"公众号名称"},model:{value:e.dataForm.name,callback:function(t){e.$set(e.dataForm,"name",t)},expression:"dataForm.name"}})],1),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"公众号类型",prop:"type"}},[a("el-select",{attrs:{placeholder:"公众号类型"},model:{value:e.dataForm.type,callback:function(t){e.$set(e.dataForm,"type",t)},expression:"dataForm.type"}},e._l(e.ACCOUNT_TYPES,(function(e,t){return a("el-option",{key:e,attrs:{label:e,value:t}})})),1)],1)],1),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"是否认证",prop:"verified"}},[a("el-switch",{attrs:{placeholder:"是否认证"},model:{value:e.dataForm.verified,callback:function(t){e.$set(e.dataForm,"verified",t)},expression:"dataForm.verified"}})],1)],1)],1),a("el-form-item",{attrs:{label:"appid",prop:"appid"}},[a("el-input",{attrs:{placeholder:"appid"},model:{value:e.dataForm.appid,callback:function(t){e.$set(e.dataForm,"appid",t)},expression:"dataForm.appid"}})],1),a("el-form-item",{attrs:{label:"appsecret",prop:"secret"}},[a("el-input",{attrs:{placeholder:"appsecret"},model:{value:e.dataForm.secret,callback:function(t){e.$set(e.dataForm,"secret",t)},expression:"dataForm.secret"}})],1),a("el-form-item",{attrs:{label:"token",prop:"token"}},[a("el-input",{attrs:{placeholder:"token"},model:{value:e.dataForm.token,callback:function(t){e.$set(e.dataForm,"token",t)},expression:"dataForm.token"}})],1),a("el-form-item",{attrs:{label:"aesKey",prop:"aesKey"}},[a("el-input",{attrs:{placeholder:"aesKey，可为空"},model:{value:e.dataForm.aesKey,callback:function(t){e.$set(e.dataForm,"aesKey",t)},expression:"dataForm.aesKey"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.dataFormSubmit()}}},[e._v("确定")])],1)],1)},o=[],l=a("2f62"),i={data:function(){return{visible:!1,dataForm:{appid:"",name:"",type:"2",verified:!0,secret:"",token:"my_weixin_token_",aesKey:""},dataRule:{name:[{required:!0,message:"公众号名称不能为空",trigger:"blur"}],appid:[{required:!0,message:"appid不能为空",trigger:"blur"}],secret:[{required:!0,message:"appsecret不能为空",trigger:"blur"}]}}},computed:Object(l["b"])({ACCOUNT_TYPES:function(e){return e.wxAccount.ACCOUNT_TYPES}}),methods:{init:function(e){var t=this;this.visible=!0,e&&e.appid?(this.dataForm=e,this.dataForm.type=e.type+""):this.$nextTick((function(){t.$refs["dataForm"].resetFields()}))},dataFormSubmit:function(){var e=this;this.$refs["dataForm"].validate((function(t){t&&e.$http({url:e.$http.adornUrl("/manage/wxAccount/save"),method:"post",data:e.$http.adornData(e.dataForm)}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}}):e.$message.error(a.msg)}))}))}}},s=i,n=a("2877"),d=Object(n["a"])(s,r,o,!1,null,null,null);t["default"]=d.exports}}]);