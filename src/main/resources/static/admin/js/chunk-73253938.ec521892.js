(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-73253938","chunk-2d0e1dac"],{"7be0":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{attrs:{title:t.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:t.visible,width:"40%"},on:{"update:visible":function(e){t.visible=e}}},[a("el-form",{ref:"dataForm",attrs:{model:t.dataForm,rules:t.dataRule,"label-width":"120px"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.dataFormSubmit()}}},[a("el-form-item",{attrs:{label:"连接名词",prop:"name"}},[a("el-input",{attrs:{placeholder:"连接名词"},model:{value:t.dataForm.name,callback:function(e){t.$set(t.dataForm,"name",e)},expression:"dataForm.name"}})],1),a("el-form-item",{attrs:{label:"连接路径"}},[a("el-input",{attrs:{placeholder:"连接路径"},model:{value:t.dataForm.url,callback:function(e){t.$set(t.dataForm,"url",e)},expression:"dataForm.url"}})],1),a("el-form-item",{attrs:{label:"显示顺序"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:t.handleChange},model:{value:t.dataForm.priority,callback:function(e){t.$set(t.dataForm,"priority",e)},expression:"dataForm.priority"}})],1),a("el-form-item",{attrs:{label:"备注",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",placeholder:"备注"},model:{value:t.dataForm.remark,callback:function(e){t.$set(t.dataForm,"remark",e)},expression:"dataForm.remark"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.visible=!1}}},[t._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.dataFormSubmit()}}},[t._v("确定")])],1)],1)},r=[],i=(a("b0c0"),{data:function(){return{visible:!1,dataForm:{id:0,name:void 0,url:void 0,priority:1,remark:void 0},dataRule:{name:[{required:!0,message:"连接名称不能为空",trigger:"blur"}],url:[{required:!0,message:"连接地址不能为空",trigger:"blur"}]}}},methods:{init:function(t){var e=this;this.dataForm.id=t||0,this.reset(),this.visible=!0,this.resetForm("dataForm"),this.$nextTick((function(){e.dataForm.id&&e.$http({url:e.$http.adornUrl("/cms/link/detail/"),method:"get",params:e.$http.adornParams({id:e.dataForm.id})}).then((function(t){var a=t.data;a&&200===a.code&&(e.dataForm.id=a.linkInfo.linkId,e.dataForm.name=a.linkInfo.name,e.dataForm.url=a.linkInfo.rul,e.dataForm.priority=a.linkInfo.priority,e.dataForm.remark=a.linkInfo.remark)}))}))},dataFormSubmit:function(){var t=this;this.$refs["dataForm"].validate((function(e){e&&t.$http({url:t.$http.adornUrl("/cms/link/".concat(t.dataForm.id?"update":"add")),method:"post",data:t.$http.adornData({linkId:t.dataForm.id||void 0,name:t.dataForm.name,url:t.dataForm.url,priority:t.dataForm.priority,remark:t.dataForm.remark})}).then((function(e){var a=e.data;a&&200===a.code?t.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){t.visible=!1,t.$emit("refreshDataList")}}):t.$message.error(a.msg)}))}))},reset:function(){this.form={id:void 0,name:void 0,url:void 0,priority:1,remark:void 0},this.resetForm("form")},handleChange:function(t){console.log(t)}}}),o=i,l=a("2877"),d=Object(l["a"])(o,n,r,!1,null,null,null);e["default"]=d.exports},a7b1:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"mod-config"},[a("el-form",{attrs:{inline:!0,model:t.dataForm},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.getDataList()}}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"连接名称",clearable:""},model:{value:t.dataForm.modelName,callback:function(e){t.$set(t.dataForm,"modelName",e)},expression:"dataForm.modelName"}})],1),a("el-form-item",[a("el-button",{on:{click:function(e){return t.getDataList()}}},[t._v("查询")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.addOrUpdateHandle()}}},[t._v("新增")]),a("el-button",{attrs:{type:"danger",disabled:t.dataListSelections.length<=0},on:{click:function(e){return t.deleteHandle()}}},[t._v("批量删除")])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.dataListLoading,expression:"dataListLoading"}],staticStyle:{width:"100%"},attrs:{data:t.dataList,border:""},on:{"selection-change":t.selectionChangeHandle}},[a("el-table-column",{attrs:{type:"selection","header-align":"center",align:"center",width:"50"}}),a("el-table-column",{attrs:{prop:"name","header-align":"center",align:"center",label:"连接名称"}}),a("el-table-column",{attrs:{prop:"url","header-align":"center",align:"center",label:"连接路径"}}),a("el-table-column",{attrs:{prop:"remark","header-align":"center",align:"center",label:"备注信息"}}),a("el-table-column",{attrs:{fixed:"right","header-align":"center",align:"center",width:"150",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.addOrUpdateHandle(e.row.linkId)}}},[t._v("修改")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.deleteHandle(e.row.linkId)}}},[t._v("删除")])]}}])})],1),a("el-pagination",{attrs:{"current-page":t.pageIndex,"page-sizes":[10,20,50,100],"page-size":t.pageSize,total:t.totalCount,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":t.sizeChangeHandle,"current-change":t.currentChangeHandle}}),t.addOrUpdateVisible?a("add-or-update",{ref:"addOrUpdate",on:{refreshDataList:t.getDataList}}):t._e()],1)},r=[],i=(a("99af"),a("a15b"),a("d81d"),a("b0c0"),a("7be0")),o={data:function(){return{dataForm:{name:""},dataList:[],pageIndex:1,pageSize:10,totalCount:0,dataListLoading:!1,dataListSelections:[],addOrUpdateVisible:!1}},components:{AddOrUpdate:i["default"]},created:function(){this.getDataList()},computed:function(){},methods:{getDataList:function(){var t=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/cms/link/list"),method:"get",params:this.$http.adornParams({page:this.pageIndex,limit:this.pageSize,name:this.dataForm.name})}).then((function(e){var a=e.data;a&&200===a.code?(t.dataList=a.page.list,t.totalCount=a.page.totalCount):(t.dataList=[],t.totalCount=0),t.dataListLoading=!1}))},sizeChangeHandle:function(t){this.pageSize=t,this.pageIndex=1,this.getDataList()},currentChangeHandle:function(t){this.pageIndex=t,this.getDataList()},selectionChangeHandle:function(t){this.dataListSelections=t},addOrUpdateHandle:function(t){var e=this;this.addOrUpdateVisible=!0,this.$nextTick((function(){e.$refs.addOrUpdate.init(t)}))},deleteHandle:function(t){var e=this,a=t?[t]:this.dataListSelections.map((function(t){return t.linkId}));this.$confirm("确定对[id=".concat(a.join(","),"]进行[").concat(t?"删除":"批量删除","]操作?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.$http({url:e.$http.adornUrl("/cms/link/delete"),method:"post",data:e.$http.adornData(a,!1)}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){return e.getDataList()}}):e.$message.error(a.msg)}))})).catch((function(){}))}}},l=o,d=a("2877"),s=Object(d["a"])(l,n,r,!1,null,"040e2a58",null);e["default"]=s.exports}}]);