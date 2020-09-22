(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-390518d2","chunk-2d213391"],{ac81:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{directives:[{name:"show",rawName:"v-show",value:t.visible,expression:"visible"}]},[a("el-form",{ref:"dataForm",attrs:{model:t.dataForm,rules:t.dataRule,size:"mini","label-width":"80px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"文章标题",prop:"title",required:""}},[a("el-input",{attrs:{maxlength:1024,placeholder:"标题"},model:{value:t.dataForm.title,callback:function(e){t.$set(t.dataForm,"title",e)},expression:"dataForm.title"}})],1)],1),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"文章类型",prop:"type",required:""}},[a("el-select",{attrs:{placeholder:"选择文章类型"},model:{value:t.dataForm.type,callback:function(e){t.$set(t.dataForm,"type",e)},expression:"dataForm.type"}},t._l(t.ARTICLE_TYPES,(function(t,e){return a("el-option",{key:t,attrs:{label:t,value:e,"allow-create":""}})})),1)],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"一级目录",prop:"category"}},[a("el-input",{attrs:{maxlength:50,placeholder:"一级目录"},model:{value:t.dataForm.category,callback:function(e){t.$set(t.dataForm,"category",e)},expression:"dataForm.category"}})],1)],1),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"二级分类",prop:"subCategory"}},[a("el-input",{attrs:{maxlength:50,placeholder:"二级目录"},model:{value:t.dataForm.subCategory,callback:function(e){t.$set(t.dataForm,"subCategory",e)},expression:"dataForm.subCategory"}})],1)],1)],1),a("el-form-item",{attrs:{label:"指向外链",prop:"targetLink"}},[a("el-input",{attrs:{placeholder:"指向外链"},model:{value:t.dataForm.targetLink,callback:function(e){t.$set(t.dataForm,"targetLink",e)},expression:"dataForm.targetLink"}})],1),a("el-form-item",{attrs:{label:"摘要",prop:"summary"}},[a("el-input",{attrs:{placeholder:"摘要",type:"textarea",rows:"3",maxlength:"512","show-word-limit":""},model:{value:t.dataForm.summary,callback:function(e){t.$set(t.dataForm,"summary",e)},expression:"dataForm.summary"}})],1),a("el-form-item",{attrs:{label:"标签",prop:"tags"}},[a("tags-editor",{model:{value:t.dataForm.tags,callback:function(e){t.$set(t.dataForm,"tags",e)},expression:"dataForm.tags"}})],1),a("el-form-item",{attrs:{label:"封面图",prop:"image"}},[a("el-input",{attrs:{placeholder:"图片链接"},model:{value:t.dataForm.image,callback:function(e){t.$set(t.dataForm,"image",e)},expression:"dataForm.image"}},[a("OssUploader",{attrs:{slot:"append"},on:{uploaded:function(e){t.dataForm.image=e}},slot:"append"})],1)],1),a("tinymce-editor",{ref:"editor",model:{value:t.dataForm.content,callback:function(e){t.$set(t.dataForm,"content",e)},expression:"dataForm.content"}})],1),a("div",{staticClass:"margin-top text-right"},[a("el-button",{on:{click:function(e){return t.$emit("hide")}}},[t._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.dataFormSubmit()}}},[t._v("确定")])],1)],1)},n=[],i=(a("d3b7"),a("2f62")),l={name:"article-add-or-update",components:{TinymceEditor:function(){return a.e("chunk-ffc0e5ba").then(a.bind(null,"26dc"))},tagsEditor:function(){return a.e("chunk-6edba45b").then(a.bind(null,"a55c"))},OssUploader:function(){return a.e("chunk-2d0e97b1").then(a.bind(null,"8e5c"))}},props:{visible:{type:Boolean,default:!1}},data:function(){return{dataForm:{id:"",type:"1",title:"",content:"",category:"",subCategory:"",summary:"",tags:"",openCount:0,targetLink:location.origin+"/client/#/article/${articleId}",image:""},dataRule:{type:[{required:!0,message:"文章类型不能为空",trigger:"blur"}],title:[{required:!0,message:"标题不能为空",trigger:"blur"}],category:[{required:!0,message:"分类不能为空",trigger:"blur"}]}}},computed:Object(i["b"])({ARTICLE_TYPES:function(t){return t.article.ARTICLE_TYPES}}),methods:{init:function(t){var e=this;this.dataForm.id=t||"",this.$nextTick((function(){e.$refs["dataForm"].resetFields(),t>0&&e.$http({url:e.$http.adornUrl("/manage/article/info/".concat(e.dataForm.id)),method:"get",params:e.$http.adornParams()}).then((function(t){var a=t.data;a&&200===a.code&&(e.dataForm=a.article,e.dataForm.type=a.article.type+"")}))}))},dataFormSubmit:function(){var t=this;this.$refs["dataForm"].validate((function(e){e&&t.$http({url:t.$http.adornUrl("/manage/article/save"),method:"post",data:t.$http.adornData(t.dataForm)}).then((function(e){var a=e.data;a&&200===a.code?t.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){t.$emit("refreshDataList"),t.$emit("hide")}}):t.$message.error(a.msg)}))}))},imgUploadSuccess:function(t,e,a){console.log(t),200==t.code?(this.dataForm.image=t.data,console.log("this.article",this.article)):this.$message.warning(t.msg)}}},o=l,s=a("2877"),d=Object(s["a"])(o,r,n,!1,null,null,null);e["default"]=d.exports},b4b9:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:!t.addOrUpdateVisible,expression:"!addOrUpdateVisible"}]},[a("el-form",{attrs:{inline:!0,model:t.dataForm},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.getDataList()}}},[a("el-form-item",[a("el-select",{attrs:{placeholder:"选择文章类型"},model:{value:t.dataForm.type,callback:function(e){t.$set(t.dataForm,"type",e)},expression:"dataForm.type"}},t._l(t.ARTICLE_TYPES,(function(t,e){return a("el-option",{key:e,attrs:{label:t,value:e,"allow-create":""}})})),1)],1),a("el-form-item",[a("el-input",{attrs:{placeholder:"标题",clearable:""},model:{value:t.dataForm.title,callback:function(e){t.$set(t.dataForm,"title",e)},expression:"dataForm.title"}})],1),a("el-form-item",[a("el-button",{on:{click:function(e){t.pageIndex=1,t.getDataList()}}},[t._v("查询")]),t.isAuth("wx:article:save")?a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.addOrUpdateHandle()}}},[t._v("新增")]):t._e(),t.isAuth("wx:article:delete")?a("el-button",{attrs:{type:"danger",disabled:t.dataListSelections.length<=0},on:{click:function(e){return t.deleteHandle()}}},[t._v("批量删除")]):t._e()],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.dataListLoading,expression:"dataListLoading"}],staticStyle:{width:"100%"},attrs:{data:t.dataList,border:""},on:{"selection-change":t.selectionChangeHandle}},[a("el-table-column",{attrs:{type:"selection","header-align":"center",align:"center",width:"50"}}),a("el-table-column",{attrs:{prop:"id","header-align":"center",align:"center",label:"ID"}}),a("el-table-column",{attrs:{prop:"type","header-align":"center",align:"center",formatter:t.articleTypeFormat,label:"文章类型"}}),a("el-table-column",{attrs:{prop:"title","header-align":"center",align:"center","show-overflow-tooltip":"",label:"标题"},scopedSlots:t._u([{key:"default",fn:function(e){return a("a",{attrs:{href:e.row.targetLink}},[t._v(t._s(e.row.title))])}}])}),a("el-table-column",{attrs:{prop:"category","header-align":"center",align:"center",label:"一级分类"}}),a("el-table-column",{attrs:{prop:"subCategory","header-align":"center",align:"center",label:"二级分类"}}),a("el-table-column",{attrs:{prop:"openCount","header-align":"center",align:"center",label:"打开次数"}}),a("el-table-column",{attrs:{fixed:"right","header-align":"center",align:"center",width:"150",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.addOrUpdateHandle(e.row.id)}}},[t._v("修改")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.deleteHandle(e.row.id)}}},[t._v("删除")])]}}])})],1),a("el-pagination",{attrs:{"current-page":t.pageIndex,"page-sizes":[10,20,50,100],"page-size":t.pageSize,total:t.totalCount,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":t.sizeChangeHandle,"current-change":t.currentChangeHandle}})],1),a("add-or-update",{ref:"addOrUpdate",attrs:{visible:t.addOrUpdateVisible},on:{refreshDataList:t.getDataList,hide:function(e){t.addOrUpdateVisible=!1}}})],1)},n=[],i=(a("99af"),a("a15b"),a("d81d"),a("ac81")),l=a("2f62"),o={components:{AddOrUpdate:i["default"]},data:function(){return{dataForm:{title:"",type:""},dataList:[],pageIndex:1,pageSize:10,totalCount:0,dataListLoading:!1,dataListSelections:[],addOrUpdateVisible:!1}},computed:Object(l["b"])({ARTICLE_TYPES:function(t){return t.article.ARTICLE_TYPES}}),mounted:function(){this.getDataList()},methods:{getDataList:function(){var t=this;this.dataListLoading=!0,this.$http({url:this.$http.adornUrl("/manage/article/list"),method:"get",params:this.$http.adornParams({page:this.pageIndex,limit:this.pageSize,title:this.dataForm.title,type:this.dataForm.type,sidx:"id",order:"desc"})}).then((function(e){var a=e.data;a&&200===a.code?(t.dataList=a.page.list,t.totalCount=a.page.totalCount):(t.dataList=[],t.totalCount=0),t.dataListLoading=!1}))},sizeChangeHandle:function(t){this.pageSize=t,this.pageIndex=1,this.getDataList()},currentChangeHandle:function(t){this.pageIndex=t,this.getDataList()},selectionChangeHandle:function(t){this.dataListSelections=t},addOrUpdateHandle:function(t){var e=this;this.addOrUpdateVisible=!0,this.$nextTick((function(){e.$refs.addOrUpdate.init(t)}))},deleteHandle:function(t){var e=this,a=t?[t]:this.dataListSelections.map((function(t){return t.id}));this.$confirm("确定对[id=".concat(a.join(","),"]进行[").concat(t?"删除":"批量删除","]操作?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.$http({url:e.$http.adornUrl("/manage/article/delete"),method:"post",data:e.$http.adornData(a,!1)}).then((function(t){var a=t.data;a&&200===a.code?e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){return e.getDataList()}}):e.$message.error(a.msg)}))}))},articleTypeFormat:function(t,e,a){return this.ARTICLE_TYPES[a]}}},s=o,d=a("2877"),c=Object(d["a"])(s,r,n,!1,null,null,null);e["default"]=c.exports}}]);