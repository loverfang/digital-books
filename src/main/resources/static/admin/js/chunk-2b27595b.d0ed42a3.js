(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2b27595b","chunk-2d21dbeb"],{9819:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"mod-config"},[a("el-form",{attrs:{inline:!0,model:t.dataForm},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.getDataList()}}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"模型名称",clearable:""},model:{value:t.dataForm.modelName,callback:function(e){t.$set(t.dataForm,"modelName",e)},expression:"dataForm.modelName"}})],1),a("el-form-item",[a("el-button",{on:{click:function(e){return t.getDataList()}}},[t._v("查询")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.addOrUpdateHandle()}}},[t._v("新增")]),a("el-button",{attrs:{type:"danger",disabled:t.dataListSelections.length<=0},on:{click:function(e){return t.deleteHandle()}}},[t._v("批量删除")])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.dataListLoading,expression:"dataListLoading"}],staticStyle:{width:"100%"},attrs:{data:t.dataList,border:""},on:{"selection-change":t.selectionChangeHandle}},[a("el-table-column",{attrs:{type:"selection","header-align":"center",align:"center",width:"50"}}),a("el-table-column",{attrs:{prop:"modelName","header-align":"center",align:"center",label:"模型名称"}}),a("el-table-column",{attrs:{prop:"modelPath","header-align":"center",align:"center",label:"模型路径"}}),a("el-table-column",{attrs:{"header-align":"center",align:"center",label:"是否禁用"},scopedSlots:t._u([{key:"default",fn:function(e){return[0===e.row.isDisabled?a("span",[t._v(" 已禁用 ")]):1===e.row.isDisabled?a("span",[t._v(" 未禁用 ")]):t._e()]}}])}),a("el-table-column",{attrs:{fixed:"right","header-align":"center",align:"center",width:"150",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.addOrUpdateHandle(e.row.modelId)}}},[t._v("修改")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.deleteHandle(e.row.modelId)}}},[t._v("删除")])]}}])})],1),a("el-pagination",{attrs:{"current-page":t.pageIndex,"page-sizes":[10,20,50,100],"page-size":t.pageSize,total:t.totalCount,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":t.sizeChangeHandle,"current-change":t.currentChangeHandle}}),t.addOrUpdateVisible?a("add-or-update",{ref:"addOrUpdate",on:{refreshDataList:t.getDataList}}):t._e()],1)},n=[],l=(a("99af"),a("a15b"),a("d81d"),a("d339")),r={data:function(){return{dataForm:{modelName:""},dataList:[],pageIndex:1,pageSize:10,totalCount:0,dataListLoading:!1,dataListSelections:[],addOrUpdateVisible:!1}},components:{AddOrUpdate:l["default"]},created:function(){this.getDataList()},computed:function(){},methods:{getDataList:function(){var t=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/cms/model/list"),method:"get",params:this.$http.adornParams({page:this.pageIndex,limit:this.pageSize,modelName:this.dataForm.modelName})}).then((function(e){var a=e.data;a&&200===a.code?(t.dataList=a.page.list,t.totalCount=a.page.totalCount):(t.dataList=[],t.totalCount=0),t.dataListLoading=!1}))},sizeChangeHandle:function(t){this.pageSize=t,this.pageIndex=1,this.getDataList()},currentChangeHandle:function(t){this.pageIndex=t,this.getDataList()},selectionChangeHandle:function(t){this.dataListSelections=t},addOrUpdateHandle:function(t){var e=this;this.addOrUpdateVisible=!0,this.$nextTick((function(){e.$refs.addOrUpdate.init(t)}))},deleteHandle:function(t){var e=this,a=t?[t]:this.dataListSelections.map((function(t){return t.modelId}));this.$confirm("确定对[id=".concat(a.join(","),"]进行[").concat(t?"删除":"批量删除","]操作?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.$http({url:e.$http.adornUrl("/cms/model/delete"),method:"post",data:e.$http.adornData(a,!1)}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){return e.getDataList()}}):e.$message.error(a.msg)}))})).catch((function(){}))}}},d=r,i=a("2877"),s=Object(i["a"])(d,o,n,!1,null,"653ddab4",null);e["default"]=s.exports},d339:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{attrs:{title:t.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:t.visible,width:"40%"},on:{"update:visible":function(e){t.visible=e}}},[a("el-form",{ref:"dataForm",attrs:{model:t.dataForm,rules:t.dataRule,"label-width":"120px"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.dataFormSubmit()}}},[a("el-form-item",{attrs:{label:"模型名称",prop:"modelName"}},[a("el-input",{attrs:{placeholder:"模型名称"},model:{value:t.dataForm.modelName,callback:function(e){t.$set(t.dataForm,"modelName",e)},expression:"dataForm.modelName"}})],1),a("el-form-item",{attrs:{label:"模型列表路径"}},[a("el-input",{attrs:{placeholder:"模型列表路径"},model:{value:t.dataForm.modelPath,callback:function(e){t.$set(t.dataForm,"modelPath",e)},expression:"dataForm.modelPath"}})],1),a("el-form-item",{attrs:{label:"模型内容路径"}},[a("el-input",{attrs:{placeholder:"模型内容路径"},model:{value:t.dataForm.modelContentPath,callback:function(e){t.$set(t.dataForm,"modelContentPath",e)},expression:"dataForm.modelContentPath"}})],1),a("el-form-item",{attrs:{label:"显示顺序"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:t.handleChange},model:{value:t.dataForm.priority,callback:function(e){t.$set(t.dataForm,"priority",e)},expression:"dataForm.priority"}})],1),a("el-form-item",{attrs:{label:"备注"}},[a("el-input",{attrs:{type:"textarea",placeholder:"备注"},model:{value:t.dataForm.remark,callback:function(e){t.$set(t.dataForm,"remark",e)},expression:"dataForm.remark"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.visible=!1}}},[t._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.dataFormSubmit()}}},[t._v("确定")])],1)],1)},n=[],l={data:function(){return{visible:!1,dataForm:{id:0,modelName:"",modelPath:"",modelContentPath:"",priority:1,remark:""},dataRule:{modelName:[{required:!0,message:"模型名称",trigger:"blur"}]}}},methods:{init:function(t){var e=this;this.dataForm.id=t||0,this.visible=!0,this.$nextTick((function(){e.$refs["dataForm"].resetFields(),e.dataForm.id&&e.$http({url:e.$http.adornUrl("/cms/model/detail/"),method:"get",params:e.$http.adornParams({modelId:e.dataForm.id})}).then((function(t){var a=t.data;a&&200===a.code&&(e.dataForm.id=a.modelInfo.modelId,e.dataForm.modelName=a.modelInfo.modelName,e.dataForm.modelPath=a.modelInfo.modelPath,e.dataForm.modelContentPath=a.modelInfo.modelContentPath,e.dataForm.priority=a.modelInfo.priority)}))}))},dataFormSubmit:function(){var t=this;this.$refs["dataForm"].validate((function(e){e&&t.$http({url:t.$http.adornUrl("/cms/model/".concat(t.dataForm.id?"update":"add")),method:"post",data:t.$http.adornData({modelId:t.dataForm.id||void 0,modelName:t.dataForm.modelName,modelPath:t.dataForm.modelPath,modelContentPath:t.dataForm.modelContentPath,priority:t.dataForm.priority})}).then((function(e){var a=e.data;a&&200===a.code?t.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){t.visible=!1,t.$emit("refreshDataList")}}):t.$message.error(a.msg)}))}))},handleChange:function(t){console.log(t)}}},r=l,d=a("2877"),i=Object(d["a"])(r,o,n,!1,null,null,null);e["default"]=i.exports}}]);