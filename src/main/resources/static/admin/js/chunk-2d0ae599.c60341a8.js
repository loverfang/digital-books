(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0ae599"],{"0a4f":function(a,t,e){"use strict";e.r(t);var r=function(){var a=this,t=a.$createElement,e=a._self._c||t;return a.visible?e("el-dialog",{attrs:{title:a.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:a.visible,width:"40%"},on:{"update:visible":function(t){a.visible=t},close:function(t){return a.closeDialogForm()}}},[e("el-form",{ref:"dialogDataForm",attrs:{model:a.dataForm,rules:a.dataRule,"label-width":"120px",size:"small"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&a._k(t.keyCode,"enter",13,t.key,"Enter")?null:a.dataFormSubmit()}}},[e("el-form-item",{attrs:{label:"类别名称",prop:"categoryName"}},[e("el-input",{attrs:{placeholder:"类别名称"},model:{value:a.dataForm.categoryName,callback:function(t){a.$set(a.dataForm,"categoryName",t)},expression:"dataForm.categoryName"}})],1),e("el-form-item",{attrs:{label:"父类别",prop:"parentId"}},[e("treeselect",{attrs:{options:a.optionData,normalizer:a.normalizer,placeholder:"请选择父类别"},model:{value:a.dataForm.parentId,callback:function(t){a.$set(a.dataForm,"parentId",t)},expression:"dataForm.parentId"}})],1),e("el-form-item",{attrs:{label:"跳转地址",prop:"categoryUrl"}},[e("el-input",{attrs:{placeholder:"如(http://192.168.0.1:8000)"},model:{value:a.dataForm.categoryUrl,callback:function(t){a.$set(a.dataForm,"categoryUrl",t)},expression:"dataForm.categoryUrl"}})],1),e("el-form-item",{attrs:{label:"导航是否展示",prop:"categoryUrl"}},[e("el-switch",{attrs:{"active-color":"#13ce66"},model:{value:a.dataForm.isNavigater,callback:function(t){a.$set(a.dataForm,"isNavigater",t)},expression:"dataForm.isNavigater"}}),a._v(" "),e("label",[a._v("绿色:展示，灰色:不展示")])],1),e("el-form-item",{attrs:{label:"显示顺序",prop:"priority"}},[e("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:a.handleChange},model:{value:a.dataForm.priority,callback:function(t){a.$set(a.dataForm,"priority",t)},expression:"dataForm.priority"}})],1),e("el-form-item",{attrs:{label:"备注",prop:"remark"}},[e("el-input",{attrs:{type:"textarea",placeholder:"备注"},model:{value:a.dataForm.remark,callback:function(t){a.$set(a.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{size:"small"},on:{click:function(t){a.visible=!1}}},[a._v("取消")]),e("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(t){return a.dataFormSubmit()}}},[a._v("确定")])],1)],1):a._e()},o=[],i=e("ca17"),l=e.n(i),n=(e("542c"),{name:"category-add-or-update",components:{Treeselect:l.a},props:{categoryTreeList:{type:Array,default:[]}},data:function(){return{visible:!1,dataForm:{id:0,categoryName:"",categoryUrl:"",parentId:0,priority:1,isNavigater:!0,remark:""},dataRule:{categoryName:[{required:!0,message:"类别名称不能为空",trigger:"blur"}],priority:[{required:!0,message:"显示顺序不能为空",trigger:"blur"}]},optionData:[],viewTreeSelect:!1,isClearable:!0,isAccordion:!0,valueId:0,props:{value:"categoryId",label:"categoryName",children:"children"}}},created:function(){console.log("父组件传过来的值",this.categoryTreeList),this.optionData=this.categoryTreeList},watch:{categoryTreeList:function(a,t){console.log("监听到他还是变化了的",a,t),this.optionData=a}},methods:{init:function(a){var t=this;this.dataForm.id=a||0,this.reset(),this.visible=!0,this.resetForm("dataForm"),this.visible=!0,this.$nextTick((function(){t.dataForm.id&&t.$http({url:t.$http.adornUrl("/cms/category/detail"),method:"get",params:t.$http.adornParams({categoryId:t.dataForm.id})}).then((function(a){var e=a.data;e&&200===e.code&&(console.log("data",e.category),t.dataForm.id=e.category.categoryId,t.dataForm.categoryName=e.category.categoryName,t.dataForm.parentId=e.category.parentId,t.dataForm.categoryUrl=e.category.categoryUrl,t.dataForm.priority=e.category.priority,t.dataForm.isNavigater=1==e.category.isNavigater,t.dataForm.remark=e.category.remark,t.valueId=e.category.parentId)})),t.viewTreeSelect=!0}))},watch:{categoryTreeList:function(a){this.optionData=a}},reset:function(){this.form={id:void 0,categoryName:void 0,parentId:void 0,priority:1,isNavigater:!1,remark:void 0},this.valueId=void 0,this.resetForm("dialogDataForm")},dataFormSubmit:function(){var a=this;this.$refs["dialogDataForm"].validate((function(t){t&&(console.log("/cms/category/".concat(a.dataForm.id?"update":"add")),a.$http({url:a.$http.adornUrl("/cms/category/".concat(a.dataForm.id?"update":"add")),method:"post",data:a.$http.adornData({categoryId:a.dataForm.id||void 0,categoryName:a.dataForm.categoryName,parentId:a.dataForm.parentId,categoryUrl:a.dataForm.categoryUrl,isNavigater:a.dataForm.isNavigater?1:0,priority:a.dataForm.priority,remark:a.dataForm.remark})}).then((function(t){var e=t.data;e&&200===e.code?a.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){a.visible=!1,0!=a.dataForm.parentId&&a.$emit("refreshRowData",a.dataForm.parentId),a.$emit("refreshDataList")}}):a.$message.error(e.msg)})))}))},closeDialogForm:function(){this.visible=!1,this.$refs["dialogDataForm"].resetFields()},handleChange:function(a){console.log(a)},normalizer:function(a){return a.children&&!a.children.length&&delete a.children,{id:a.categoryId,label:a.categoryName,children:a.children}}}}),d=n,s=e("2877"),c=Object(s["a"])(d,r,o,!1,null,null,null);t["default"]=c.exports}}]);