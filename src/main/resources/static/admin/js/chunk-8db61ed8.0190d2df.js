(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8db61ed8","chunk-2d0aeb2a"],{"0abe":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:e.visible},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm,rules:e.dataRule,"label-width":"80px",size:"small"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.dataFormSubmit()}}},[a("el-form-item",{attrs:{label:"角色名称",prop:"roleName"}},[a("el-input",{attrs:{placeholder:"角色名称"},model:{value:e.dataForm.roleName,callback:function(t){e.$set(e.dataForm,"roleName",t)},expression:"dataForm.roleName"}})],1),a("el-form-item",{attrs:{label:"备注",prop:"remark"}},[a("el-input",{attrs:{placeholder:"备注"},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1),a("el-form-item",{attrs:{size:"mini",label:"授权"}},[a("el-tree",{ref:"menuListTree",attrs:{data:e.menuList,props:e.menuListTreeProps,"node-key":"menuId","default-expand-all":!0,"show-checkbox":""}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{size:"small"},on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(t){return e.dataFormSubmit()}}},[e._v("确定")])],1)],1)},n=[],i=(a("99af"),a("4160"),a("159b"),a("ed08")),o={data:function(){return{visible:!1,menuList:[],menuListTreeProps:{label:"name",children:"children"},dataForm:{id:0,roleName:"",remark:""},dataRule:{roleName:[{required:!0,message:"角色名称不能为空",trigger:"blur"}]}}},methods:{init:function(e){var t=this;this.dataForm.id=e||0,this.$http({url:this.$http.adornUrl("/sys/menu/list"),method:"get",params:this.$http.adornParams()}).then((function(e){var a=e.data;t.menuList=Object(i["g"])(a,"menuId")})).then((function(){t.visible=!0,t.$nextTick((function(){t.$refs["dataForm"].resetFields(),t.$refs.menuListTree.setCheckedKeys([])}))})).then((function(){t.dataForm.id&&t.$http({url:t.$http.adornUrl("/sys/role/info/".concat(t.dataForm.id)),method:"get",params:t.$http.adornParams()}).then((function(e){var a=e.data;a&&200===a.code&&(t.dataForm.roleName=a.role.roleName,t.dataForm.remark=a.role.remark,a.role.menuIdList.forEach((function(e){t.$refs.menuListTree.setChecked(e,!0)})))}))}))},dataFormSubmit:function(){var e=this;this.$refs["dataForm"].validate((function(t){t&&e.$http({url:e.$http.adornUrl("/sys/role/".concat(e.dataForm.id?"update":"save")),method:"post",data:e.$http.adornData({roleId:e.dataForm.id||void 0,roleName:e.dataForm.roleName,remark:e.dataForm.remark,menuIdList:[].concat(e.$refs.menuListTree.getCheckedKeys(),e.$refs.menuListTree.getHalfCheckedKeys())})}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}}):e.$message.error(a.msg)}))}))}}},l=o,s=a("2877"),d=Object(s["a"])(l,r,n,!1,null,null,null);t["default"]=d.exports},e4a1:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"mod-role"},[a("el-form",{attrs:{inline:!0,model:e.dataForm,size:"small"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getDataList()}}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"角色名称",clearable:""},model:{value:e.dataForm.roleName,callback:function(t){e.$set(e.dataForm,"roleName",t)},expression:"dataForm.roleName"}})],1),a("el-form-item",[a("el-button",{on:{click:function(t){return e.getDataList()}}},[e._v("查询")]),e.isAuth("sys:role:save")?a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addOrUpdateHandle()}}},[e._v("新增")]):e._e(),e.isAuth("sys:role:delete")?a("el-button",{attrs:{type:"danger",disabled:e.dataListSelections.length<=0},on:{click:function(t){return e.deleteHandle()}}},[e._v("批量删除")]):e._e()],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.dataListLoading,expression:"dataListLoading"}],staticStyle:{width:"100%"},attrs:{data:e.dataList,border:""},on:{"selection-change":e.selectionChangeHandle}},[a("el-table-column",{attrs:{type:"selection","header-align":"center",align:"center",width:"50"}}),a("el-table-column",{attrs:{prop:"roleId","header-align":"center",align:"center",width:"80",label:"ID"}}),a("el-table-column",{attrs:{prop:"roleName","header-align":"center",align:"center",label:"角色名称"}}),a("el-table-column",{attrs:{prop:"remark","header-align":"center",align:"center",label:"备注"}}),a("el-table-column",{attrs:{fixed:"right","header-align":"center",align:"center",width:"150",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[e.isAuth("sys:role:update")?a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return e.addOrUpdateHandle(t.row.roleId)}}},[e._v("修改")]):e._e(),e.isAuth("sys:role:delete")?a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return e.deleteHandle(t.row.roleId)}}},[e._v("删除")]):e._e()]}}])})],1),a("el-pagination",{attrs:{"current-page":e.pageIndex,"page-sizes":[10,20,50,100],"page-size":e.pageSize,total:e.totalCount,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.sizeChangeHandle,"current-change":e.currentChangeHandle}}),e.addOrUpdateVisible?a("add-or-update",{ref:"addOrUpdate",on:{refreshDataList:e.getDataList}}):e._e()],1)},n=[],i=(a("99af"),a("a15b"),a("d81d"),a("0abe")),o={data:function(){return{dataForm:{roleName:""},dataList:[],pageIndex:1,pageSize:10,totalCount:0,dataListLoading:!1,dataListSelections:[],addOrUpdateVisible:!1}},components:{AddOrUpdate:i["default"]},activated:function(){this.getDataList()},methods:{getDataList:function(){var e=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/sys/role/list"),method:"get",params:this.$http.adornParams({page:this.pageIndex,limit:this.pageSize,roleName:this.dataForm.roleName})}).then((function(t){var a=t.data;a&&200===a.code?(e.dataList=a.page.list,e.totalCount=a.page.totalCount):(e.dataList=[],e.totalCount=0),e.dataListLoading=!1}))},sizeChangeHandle:function(e){this.pageSize=e,this.pageIndex=1,this.getDataList()},currentChangeHandle:function(e){this.pageIndex=e,this.getDataList()},selectionChangeHandle:function(e){this.dataListSelections=e},addOrUpdateHandle:function(e){var t=this;this.addOrUpdateVisible=!0,this.$nextTick((function(){t.$refs.addOrUpdate.init(e)}))},deleteHandle:function(e){var t=this,a=e?[e]:this.dataListSelections.map((function(e){return e.roleId}));this.$confirm("确定对[id=".concat(a.join(","),"]进行[").concat(e?"删除":"批量删除","]操作?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.$http({url:t.$http.adornUrl("/sys/role/delete"),method:"post",data:t.$http.adornData(a,!1)}).then((function(e){var a=e.data;a&&200===a.code?t.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){return t.getDataList()}}):t.$message.error(a.msg)}))})).catch((function(){}))}}},l=o,s=a("2877"),d=Object(s["a"])(l,r,n,!1,null,null,null);t["default"]=d.exports}}]);