(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b3e0b"],{"29f4":function(e,t,n){"use strict";n.r(t);var l=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dialog",{attrs:{title:"选择素材",visible:e.visible,modal:!0,"append-to-body":""},on:{"update:visible":function(t){e.visible=t}}},["news"==e.selectType?n("material-news",{attrs:{selectMode:""},on:{selected:e.onSelect}}):n("material-file",{attrs:{fileType:e.selectType,selectMode:""},on:{selected:e.onSelect}})],1)},i=[],s=(n("d3b7"),{name:"assets-selector",components:{MaterialFile:function(){return n.e("chunk-19f2b324").then(n.bind(null,"ab26"))},MaterialNews:function(){return n.e("chunk-5e9b1f58").then(n.bind(null,"4149"))}},props:{selectType:{type:String,default:"image"},visible:{type:Boolean,default:!1}},methods:{onSelect:function(e){this.$emit("selected",e)}}}),o=s,a=n("2877"),c=Object(a["a"])(o,l,i,!1,null,null,null);t["default"]=c.exports}}]);