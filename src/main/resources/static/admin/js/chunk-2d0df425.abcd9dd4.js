(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0df425"],{"88c2":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:e.visible},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm,rules:e.dataRule,"label-width":"100px"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.dataFormSubmit()}}},[a("el-form-item",{attrs:{label:"二维码类型",prop:"isTemp"}},[a("el-radio",{attrs:{label:!0},model:{value:e.dataForm.isTemp,callback:function(t){e.$set(e.dataForm,"isTemp",t)},expression:"dataForm.isTemp"}},[e._v("临时")]),a("el-radio",{attrs:{label:!1},model:{value:e.dataForm.isTemp,callback:function(t){e.$set(e.dataForm,"isTemp",t)},expression:"dataForm.isTemp"}},[e._v("永久")]),a("div",[a("a",{directives:[{name:"show",rawName:"v-show",value:!e.dataForm.isTemp,expression:"!dataForm.isTemp"}],staticClass:"text-warning",attrs:{target:"_blank",href:"https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html"}},[e._v("注意永久二维码上限10万个，且暂时无法删除旧的二维码")])])],1),a("el-form-item",{attrs:{label:"场景值",prop:"sceneStr"}},[a("el-input",{attrs:{placeholder:"任意字符串",maxlength:"64"},model:{value:e.dataForm.sceneStr,callback:function(t){e.$set(e.dataForm,"sceneStr",t)},expression:"dataForm.sceneStr"}})],1),e.dataForm.isTemp?a("el-form-item",{attrs:{label:"失效时间/秒",prop:"expireSeconds"}},[a("el-input",{attrs:{placeholder:"单位：秒，最大2592000（30天）"},model:{value:e.dataForm.expireSeconds,callback:function(t){e.$set(e.dataForm,"expireSeconds",t)},expression:"dataForm.expireSeconds"}}),a("div",[e._v("最大30天，当前设置："),a("span",{staticClass:"text-warning"},[e._v(e._s(e.dataForm.expireSeconds/86400)+"天")])])],1):e._e()],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.dataFormSubmit()}}},[e._v("确定")])],1)],1)},s=[],i={data:function(){return{visible:!1,dataForm:{isTemp:!0,sceneStr:"",expireSeconds:2592e3},dataRule:{isTemp:[{required:!0,message:"二维码类型不能为空",trigger:"blur"}],sceneStr:[{required:!0,message:"场景值ID不能为空",trigger:"blur"}],expireSeconds:[{required:!0,message:"该二维码失效时间不能为空",trigger:"blur"}]}}},methods:{init:function(e){var t=this;this.dataForm.id=e||0,this.visible=!0,this.$nextTick((function(){t.$refs["dataForm"].resetFields()}))},dataFormSubmit:function(){var e=this;this.$refs["dataForm"].validate((function(t){t&&e.$http({url:e.$http.adornUrl("/manage/wxQrCode/createTicket"),method:"post",data:e.$http.adornData(e.dataForm)}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}}):e.$message.error(a.msg)}))}))}}},o=i,n=a("2877"),l=Object(n["a"])(o,r,s,!1,null,null,null);t["default"]=l.exports}}]);