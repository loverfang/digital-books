(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6a6b7a90","chunk-2d20fcf8"],{"3f68":function(e,t,a){"use strict";var n=a("a38b"),l=a.n(n);l.a},6399:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:5}},[a("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(t){e.dialogFormVisible=!0}}},[e._v("创建栏目")]),a("el-divider"),a("el-tree",{ref:"channelTree",attrs:{data:e.channelList,props:e.channelListTreeProps,"node-key":"channelId","default-expand-all":!0,"highlight-current":!0,"expand-on-click-node":!1},on:{"node-click":e.handleNodeClick,"current-change":e.menuListTreeCurrentChangeHandle},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.node,l=t.data;return a("span",{staticClass:"custom-tree-node",on:{mouseenter:function(t){return e.mouseenter(l)},mouseleave:function(t){return e.mouseleave(l)}}},[a("span",[e._v(e._s(n.label))]),a("span",{staticClass:"fr"},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:l.show,expression:"data.show"}],attrs:{type:"text",size:"mini"},on:{click:function(t){e.dialogFormVisible=!0}}},[e._v("新增")]),-1!==l.parentId?a("el-button",{directives:[{name:"show",rawName:"v-show",value:l.show,expression:"data.show"}],staticClass:"fontRed",attrs:{type:"text",size:"mini"},on:{click:function(){return e.del(n,l)}}},[e._v("删除")]):e._e()],1)])}}])})],1),a("el-col",{attrs:{span:19}},[[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm}},[a("el-tabs",{on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"基本信息",name:"ChannelBase"}}),a("el-tab-pane",{attrs:{label:"扩展信息",name:"ChannelExt"}}),a("el-tab-pane",{attrs:{label:"Banner管理",name:"ChannelBanner"}})],1),e.hackReset?a(e.currentView,{tag:"component",attrs:{channelId:e.currentTreeNode,optionData:e.optionData}}):e._e()],1)]],2)],1),a("el-dialog",{attrs:{title:"添加栏目",visible:e.dialogFormVisible,"modal-append-to-body":!1,width:"45%"},on:{"update:visible":function(t){e.dialogFormVisible=t},close:e.closeDialogForm}},[a("el-form",{ref:"dialogDataForm",attrs:{model:e.dialogDataForm,rules:e.dataRule}},[a("el-form-item",{attrs:{label:"栏目模型","label-width":e.formLabelWidth,prop:"modelId"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.dialogDataForm.modelId,callback:function(t){e.$set(e.dialogDataForm,"modelId",t)},expression:"dialogDataForm.modelId"}},e._l(e.modelSelectOptions,(function(e){return a("el-option",{key:e.modelId,attrs:{label:e.modelName,value:e.modelId}})})),1)],1),a("el-form-item",{attrs:{label:"栏目名称","label-width":e.formLabelWidth,prop:"channelName"}},[a("el-input",{staticStyle:{width:"90%"},attrs:{autocomplete:"off"},model:{value:e.dialogDataForm.channelName,callback:function(t){e.$set(e.dialogDataForm,"channelName",t)},expression:"dialogDataForm.channelName"}})],1),a("el-form-item",{attrs:{label:"上级栏目","label-width":e.formLabelWidth,prop:"parentId"}},[a("el-tree-select",{attrs:{props:e.props,options:e.optionData,value:e.valueId,clearable:e.isClearable,accordion:e.isAccordion,height:"200"},on:{getValue:function(t){return e.getValue(t)}}}),e._v(" ID为："+e._s(e.dialogDataForm.parentId)+" ")],1),a("el-form-item",{attrs:{label:"访问路劲","label-width":e.formLabelWidth,prop:"channelPath"}},[a("el-input",{staticStyle:{width:"90%"},attrs:{autocomplete:"off"},model:{value:e.dialogDataForm.channelPath,callback:function(t){e.$set(e.dialogDataForm,"channelPath",t)},expression:"dialogDataForm.channelPath"}})],1),a("el-form-item",{attrs:{label:"显示序列","label-width":e.formLabelWidth,prop:"priority"}},[a("el-input-number",{staticStyle:{width:"200px"},attrs:{"controls-position":"right",min:1},model:{value:e.dialogDataForm.priority,callback:function(t){e.$set(e.dialogDataForm,"priority",t)},expression:"dialogDataForm.priority"}})],1),a("el-form-item",{attrs:{label:"是否显示","label-width":e.formLabelWidth}},[a("el-switch",{model:{value:e.dialogDataForm.isDisplay,callback:function(t){e.$set(e.dialogDataForm,"isDisplay",t)},expression:"dialogDataForm.isDisplay"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.closeDialogForm}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitDialogForm()}}},[e._v("确 定")])],1)],1)],1)},l=[],o=(a("4de4"),a("b0c0"),a("d3b7"),a("ed08")),i=(a("b4e5"),{data:function(){var e=function(e,t,a){/\S/.test(t)?a():a(new Error("栏目地址不能为空"))};return{dataListLoading:!1,formLabelWidth:"120px",hackReset:!1,filterText:"",channelList:[],channelListTreeProps:{label:"channelName",children:"children"},currentTreeNode:1,currentView:"ChannelBase",activeName:"ChannelBase",dialogFormVisible:!1,dialogDataForm:{channelId:"",channelName:"",modelId:"",parentId:"0",channelPath:"",priority:0,isDisplay:!0},dataRule:{channelName:[{required:!0,message:"栏目名称不能为空",trigger:"blur"}],modelId:[{required:!0,message:"请选择栏目模型",trigger:"change"}],parentId:[{required:!0,message:"上级栏目不能为空",trigger:"change"}],channelPath:[{validator:e,trigger:"blur"}]},modelSelectOptions:[],isClearable:!0,isAccordion:!0,valueId:1,props:{value:"channelId",label:"channelName",children:"children"}}},components:{ElTreeSelect:function(){return a.e("chunk-687d466c").then(a.bind(null,"dca5"))},ChannelBase:function(){return a.e("chunk-b9bd8102").then(a.bind(null,"e150"))},ChannelExt:function(){return a.e("chunk-01c69827").then(a.bind(null,"786b"))},ChannelTxt:function(){return a.e("chunk-2d0a3584").then(a.bind(null,"027c"))},ChannelBanner:function(){return a.e("chunk-26dd072c").then(a.bind(null,"de4e"))}},created:function(){this.loadModelSelectOptions(),this.loadChannelTree()},mounted:function(){this.setTreeCurrentNode()},computed:{optionData:function(){var e=JSON.parse(JSON.stringify(this.channelList));return e.filter((function(t){var a=e.filter((function(e){t.channelId,e.parentId}));return a.length>0&&(t.children=a),-1==t.parentId}))}},methods:{loadModelSelectOptions:function(){var e=this;this.$http({url:this.$http.adornUrl("/cms/model/list"),method:"get",params:this.$http.adornParams({})}).then((function(t){var a=t.data;e.modelSelectOptions=a.modelList}))},loadChannelTree:function(){var e=this;this.$http({url:this.$http.adornUrl("/cms/channel/treeList"),method:"get",params:this.$http.adornParams()}).then((function(t){var a=t.data;console.log("返回的原始数据"),console.log(a),e.channelList=Object(o["g"])(a.channelList,"channelId"),e.channelList.length>0&&e.$nextTick().then((function(){var e=document.querySelector(".el-tree-node__content");e.click()}))}))},setTreeCurrentNode:function(){this.$nextTick((function(){this.$refs.channelTree.setCurrentKey(this.currentTreeNode),this.dialogDataForm.parentId=this.currentTreeNode}))},handleNodeClick:function(e,t,a){var n=this;this.$nextTick((function(){var a=t.isLeaf;console.log("flag",a);var l=t.key;console.log("node",l);var o=e.channelId;console.log("obj",o),n.currentTreeNode=t.key,n.hackReset=!1,n.$nextTick((function(){n.hackReset=!0,n.currentView="ChannelBase",n.activeName="ChannelBase"}))}))},mouseenter:function(e){this.$set(e,"show",!0)},mouseleave:function(e){this.$set(e,"show",!1)},handleClick:function(e){this.currentView=e.name},submitDialogForm:function(){var e=this;this.dialogFormVisible=!0,this.$refs["dialogDataForm"].validate((function(t){t&&e.$http({url:e.$http.adornUrl("/cms/channel/add"),method:"post",data:e.$http.adornData({modelId:e.dialogDataForm.modelId,channelName:e.dialogDataForm.channelName,parentId:e.dialogDataForm.parentId,channelPath:e.dialogDataForm.channelPath,isDisplay:e.dialogDataForm.isDisplay?1:0,priority:e.dialogDataForm.priority})}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){e.loadChannelTree(),e.$nextTick((function(){e.$refs["dialogDataForm"].resetFields()})),e.dialogFormVisible=!1}}):e.$message.error(a.msg)}))}))},closeDialogForm:function(){var e=this;this.$nextTick((function(){e.$refs["dialogDataForm"].resetFields(),e.dialogFormVisible=!1}))},getValue:function(e){this.valueId=e,this.dialogDataForm.parentId=e}}}),r=i,s=(a("3f68"),a("2877")),c=Object(s["a"])(r,n,l,!1,null,"3a919eb6",null);t["default"]=c.exports},a38b:function(e,t,a){},b4e5:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"mod-log"},[a("el-form",{attrs:{inline:!0,model:e.dataForm},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getDataList()}}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"用户名／用户操作",clearable:""},model:{value:e.dataForm.key,callback:function(t){e.$set(e.dataForm,"key",t)},expression:"dataForm.key"}})],1),a("el-form-item",[a("el-button",{on:{click:function(t){return e.getDataList()}}},[e._v("查询")])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.dataListLoading,expression:"dataListLoading"}],staticStyle:{width:"100%"},attrs:{data:e.dataList,border:""}},[a("el-table-column",{attrs:{prop:"id","header-align":"center",align:"center",width:"80",label:"ID"}}),a("el-table-column",{attrs:{prop:"username","header-align":"center",align:"center",label:"用户名"}}),a("el-table-column",{attrs:{prop:"operation","header-align":"center",align:"center",label:"用户操作"}}),a("el-table-column",{attrs:{prop:"method","header-align":"center",align:"center",width:"150","show-overflow-tooltip":!0,label:"请求方法"}}),a("el-table-column",{attrs:{prop:"params","header-align":"center",align:"center",width:"150","show-overflow-tooltip":!0,label:"请求参数"}}),a("el-table-column",{attrs:{prop:"time","header-align":"center",align:"center",label:"执行时长(毫秒)"}}),a("el-table-column",{attrs:{prop:"ip","header-align":"center",align:"center",width:"150",label:"IP地址"}}),a("el-table-column",{attrs:{prop:"createDate","header-align":"center",align:"center",width:"180",label:"创建时间"}})],1),a("el-pagination",{attrs:{"current-page":e.pageIndex,"page-sizes":[10,20,50,100],"page-size":e.pageSize,total:e.totalCount,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.sizeChangeHandle,"current-change":e.currentChangeHandle}})],1)},l=[],o={data:function(){return{dataForm:{key:""},dataList:[],pageIndex:1,pageSize:10,totalCount:0,dataListLoading:!1,selectionDataList:[]}},created:function(){this.getDataList()},methods:{getDataList:function(){var e=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/sys/log/list"),method:"get",params:this.$http.adornParams({page:this.pageIndex,limit:this.pageSize,key:this.dataForm.key,sidx:"id",order:"desc"})}).then((function(t){var a=t.data;a&&200===a.code?(e.dataList=a.page.list,e.totalCount=a.page.totalCount):(e.dataList=[],e.totalCount=0),e.dataListLoading=!1}))},sizeChangeHandle:function(e){this.pageSize=e,this.pageIndex=1,this.getDataList()},currentChangeHandle:function(e){this.pageIndex=e,this.getDataList()}}},i=o,r=a("2877"),s=Object(r["a"])(i,n,l,!1,null,null,null);t["default"]=s.exports}}]);