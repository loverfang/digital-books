(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-51a92432"],{"1f38":function(n,e,t){"use strict";(function(n){t.d(e,"a",(function(){return i}));var o=function(){return"undefined"!==typeof window?window:n},i=function(){var n=o();return n&&n.tinymce?n.tinymce:null}}).call(this,t("c8ba"))},"26dc":function(n,e,t){"use strict";t.r(e);var o=function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{staticClass:"tinymce-editor"},[t("editor",{attrs:{init:n.init},on:{onExecCommand:n.onExecCommand},model:{value:n.myValue,callback:function(e){n.myValue=e},expression:"myValue"}})],1)},i=[],r=(t("b0c0"),t("d3b7"),["onActivate","onAddUndo","onBeforeAddUndo","onBeforeExecCommand","onBeforeGetContent","onBeforeRenderUI","onBeforeSetContent","onBeforePaste","onBlur","onChange","onClearUndos","onClick","onContextMenu","onCopy","onCut","onDblclick","onDeactivate","onDirty","onDrag","onDragDrop","onDragEnd","onDragGesture","onDragOver","onDrop","onExecCommand","onFocus","onFocusIn","onFocusOut","onGetContent","onHide","onInit","onKeyDown","onKeyPress","onKeyUp","onLoadContent","onMouseDown","onMouseEnter","onMouseLeave","onMouseMove","onMouseOut","onMouseOver","onMouseUp","onNodeChange","onObjectResizeStart","onObjectResized","onObjectSelected","onPaste","onPostProcess","onPostRender","onPreProcess","onProgressState","onRedo","onRemove","onReset","onSaveContent","onSelectionChange","onSetAttrib","onSetContent","onShow","onSubmit","onUndo","onVisualAid"]),a=function(n){return-1!==r.indexOf(n)},s=function(n,e,t){Object.keys(e).filter(a).forEach((function(o){var i=e[o];"function"===typeof i&&("onInit"===o?i(n,t):t.on(o.substring(2),(function(n){return i(n,t)})))}))},l=function(n,e){var t,o=n.$props.modelEvents?n.$props.modelEvents:null,i=Array.isArray(o)?o.join(" "):o;n.$watch("value",(function(n,o){e&&"string"===typeof n&&n!==t&&n!==o&&(e.setContent(n),t=n)})),e.on(i||"change keyup undo redo",(function(){t=e.getContent(),n.$emit("input",t)}))},u=function(n,e,t){var o=e.$props.value?e.$props.value:"",i=e.$props.initialValue?e.$props.initialValue:"";t.setContent(o||i),e.$listeners.input&&l(e,t),s(n,e.$listeners,t)},c=0,p=function(n){var e=Date.now(),t=Math.floor(1e9*Math.random());return c++,n+"_"+t+c+String(e)},d=function(n){return null!==n&&"textarea"===n.tagName.toLowerCase()},f=function(n){return"undefined"===typeof n||""===n?[]:Array.isArray(n)?n:n.split(" ")},m=function(n,e){return f(n).concat(f(e))},h=function(n,e,t,o){var i=e.createElement("script");i.type="application/javascript",i.id=n,i.addEventListener("load",o),i.src=t,e.head&&e.head.appendChild(i)},g=function(){return{listeners:[],scriptId:p("tiny-script"),scriptLoaded:!1}},y=function(n,e,t,o){n.scriptLoaded?o():(n.listeners.push(o),e.getElementById(n.scriptId)||h(n.scriptId,e,t,(function(){n.listeners.forEach((function(n){return n()})),n.scriptLoaded=!0})))},v=t("1f38"),b={apiKey:String,cloudChannel:String,id:String,init:Object,initialValue:String,inline:Boolean,modelEvents:[String,Array],plugins:[String,Array],tagName:String,toolbar:[String,Array],value:String,disabled:Boolean},$=function(){return $=Object.assign||function(n){for(var e,t=1,o=arguments.length;t<o;t++)for(var i in e=arguments[t],e)Object.prototype.hasOwnProperty.call(e,i)&&(n[i]=e[i]);return n},$.apply(this,arguments)},C=g(),w=function(n,e,t){return n(t||"div",{attrs:{id:e}})},S=function(n,e){return n("textarea",{attrs:{id:e},style:{visibility:"hidden"}})},O=function(n){return function(){var e=$({},n.$props.init,{readonly:n.$props.disabled,selector:"#"+n.elementId,plugins:m(n.$props.init&&n.$props.init.plugins,n.$props.plugins),toolbar:n.$props.toolbar||n.$props.init&&n.$props.init.toolbar,inline:n.inlineEditor,setup:function(e){n.editor=e,e.on("init",(function(t){return u(t,n,e)})),n.$props.init&&"function"===typeof n.$props.init.setup&&n.$props.init.setup(e)}});d(n.element)&&(n.element.style.visibility=""),Object(v["a"])().init(e)}},E={props:b,created:function(){this.elementId=this.$props.id||p("tiny-vue"),this.inlineEditor=this.$props.init&&this.$props.init.inline||this.$props.inline},watch:{disabled:function(){this.editor.setMode(this.disabled?"readonly":"design")}},mounted:function(){if(this.element=this.$el,null!==Object(v["a"])())O(this)();else if(this.element&&this.element.ownerDocument){var n=this.element.ownerDocument,e=this.$props.cloudChannel?this.$props.cloudChannel:"5",t=this.$props.apiKey?this.$props.apiKey:"no-api-key";y(C,n,"https://cdn.tiny.cloud/1/"+t+"/tinymce/"+e+"/tinymce.min.js",O(this))}},beforeDestroy:function(){null!==Object(v["a"])()&&Object(v["a"])().remove(this.editor)},render:function(n){return this.inlineEditor?w(n,this.elementId,this.$props.tagName):S(n,this.elementId)}},x=E,D={name:"tinymce-editor",components:{Editor:x},props:{value:{type:String,default:""}},data:function(){return{init:{language_url:"/res/admin/lib/tinymce@4.8.2/langs/zh_CN.js",language:"zh_CN",height:200,menubar:!1,plugins:"lists image table paste link searchreplace code pagebreak importcss",toolbar:"undo redo | bold italic forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists link anchor image table | removeformat code",toolbar_drawer:!1,image_advtab:!0,object_resizing:!1,paste_data_images:!0,convert_urls:!1,default_link_target:"_blank",images_upload_handler:function(n,e,t){var o,i,r="/api/sys/oss/uploadFile";o=new XMLHttpRequest,o.withCredentials=!1,o.open("POST",r),o.upload.onprogress=function(n){progress(n.loaded/n.total*100)},o.onload=function(){var n;o.status<200||o.status>=300?t("HTTP Error: "+o.status):(n=JSON.parse(o.responseText),n?!n.files[0]||n.files[0].length<=0?t("未获取到文件回写地址"):e(n.files[0].filePath):t("Invalid JSON: "+o.responseText))},o.onerror=function(){t("Image upload failed due to a XHR Transport error. Code: "+o.status)},i=new FormData,i.append("file",n.blob(),n.filename()),o.send(i)},file_picker_callback:function(n,e,t){var o=".pdf, .txt, .zip, .rar, .7z, .doc, .docx, .xls, .xlsx, .ppt, .pptx, .mp3, .mp4",i="/api/sys/oss/uploadFile",r=document.createElement("input");r.setAttribute("type","file"),r.setAttribute("accept",o),r.click(),r.onchange=function(){var e,t,o=this.files[0];console.log(o.name),e=new XMLHttpRequest,e.withCredentials=!1,e.open("POST",i),e.onload=function(){var t;200==e.status?(t=JSON.parse(e.responseText),t?!t.files[0]||t.files[0].length<=0?failure("未获取到文件回写地址"):n(t.files[0].filePath):failure("Invalid JSON: "+e.responseText)):failure("HTTP Error: "+e.status)},t=new FormData,t.append("file",o,o.name),e.send(t)}}},myValue:this.value,uploading:!1,cosConfig:[]}},mounted:function(){tinymce.init({})},methods:{onExecCommand:function(n){},uploadFile:function(n){var e=this;return this.uploading=!0,new Promise((function(t,o){var i=new FormData;i.append("file",n),e.$http({url:e.$http.adornUrl("/sys/oss/uploadFile"),method:"post",data:i}).then((function(n){var i=n.data;console.log(i),i&&200===i.code?(e.$emit("uploaded",i.files[0].filePath),t(i.files[0].filePath)):(e.$message.error("文件上传失败："+i.msg),o(i.msg)),e.uploading=!1})).catch((function(n){return o(n)}))}))}},watch:{value:function(n){this.myValue=n},myValue:function(n){this.$emit("input",n)}}},P=D,_=t("2877"),j=Object(_["a"])(P,o,i,!1,null,null,null);e["default"]=j.exports}}]);