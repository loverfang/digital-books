(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1f1af545"],{"1ebb":function(e,o,t){"use strict";t.r(o);var i=function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{staticClass:"login-container"},[t("div",{staticClass:"login-weaper animated bounceInDown"},[t("div",{staticClass:"login-logo"}),t("p",{staticClass:"login-tip"},[e._v("易创网站管理平台-中电科版")]),t("div",{staticClass:"login-border"},[t("div",{staticClass:"login-main"},[t("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,rules:e.loginRules}},[t("el-form-item",{attrs:{prop:"username"}},[t("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"账号"},model:{value:e.loginForm.username,callback:function(o){e.$set(e.loginForm,"username",o)},expression:"loginForm.username"}},[t("svg-icon",{staticClass:"el-input__icon input-icon",attrs:{slot:"prefix","icon-class":"user"},slot:"prefix"})],1)],1),t("el-form-item",{attrs:{prop:"password"}},[t("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},nativeOn:{keyup:function(o){return!o.type.indexOf("key")&&e._k(o.keyCode,"enter",13,o.key,"Enter")?null:e.handleLogin(o)}},model:{value:e.loginForm.password,callback:function(o){e.$set(e.loginForm,"password",o)},expression:"loginForm.password"}},[t("svg-icon",{staticClass:"el-input__icon input-icon",attrs:{slot:"prefix","icon-class":"password"},slot:"prefix"})],1)],1),t("el-form-item",{attrs:{prop:"code"}},[t("el-input",{staticStyle:{width:"56%"},attrs:{"auto-complete":"off",placeholder:"验证码"},nativeOn:{keyup:function(o){return!o.type.indexOf("key")&&e._k(o.keyCode,"enter",13,o.key,"Enter")?null:e.handleLogin(o)}},model:{value:e.loginForm.captcha,callback:function(o){e.$set(e.loginForm,"captcha",o)},expression:"loginForm.captcha"}},[t("svg-icon",{staticClass:"el-input__icon input-icon",attrs:{slot:"prefix","icon-class":"validCode"},slot:"prefix"})],1),t("div",{staticClass:"login-code"},[t("img",{staticClass:"login-code-img",attrs:{src:e.codeUrl},on:{click:function(o){return e.getCaptcha()}}})])],1),t("el-checkbox",{staticStyle:{margin:"0px 0px 25px 0px"},model:{value:e.loginForm.rememberMe,callback:function(o){e.$set(e.loginForm,"rememberMe",o)},expression:"loginForm.rememberMe"}},[e._v("记住密码")]),t("el-form-item",{staticStyle:{width:"100%"}},[t("el-button",{staticStyle:{width:"100%"},attrs:{loading:e.loading,size:"medium",type:"primary"},nativeOn:{click:function(o){return o.preventDefault(),e.handleLogin(o)}}},[e.loading?t("span",[e._v("登 录 中...")]):t("span",[e._v("登 录")])])],1)],1)],1)])]),e._m(0)])},n=[function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{staticClass:"el-login-footer"},[t("span",[e._v("Copyright © 2017-2020 e-chuang.vip All Rights Reserved.")])])}],r=t("ed08"),a={name:"Login",data:function(){return{codeUrl:"",loginForm:{username:"admin",password:"admin123",rememberMe:!1,uuid:""},loginRules:{username:[{required:!0,trigger:"blur",message:"用户名不能为空"}],password:[{required:!0,trigger:"blur",message:"密码不能为空"}],captchaPath:[{required:!0,trigger:"change",message:"验证码不能为空"}]},loading:!1,redirect:void 0}},watch:{$route:{handler:function(e){this.redirect=e.query&&e.query.redirect},immediate:!0}},created:function(){this.getCookie(),this.getCaptcha()},methods:{getCaptcha:function(){this.loginForm.uuid=Object(r["c"])(),this.codeUrl=this.$http.adornUrl("/captcha.jpg?uuid=".concat(this.loginForm.uuid))},getCookie:function(){var e=this.$cookie.get("username"),o=this.$cookie.get("password"),t=this.$cookie.get("rememberMe");this.loginForm={username:void 0===e?this.loginForm.username:e,password:void 0===o?this.loginForm.password:o,rememberMe:void 0!==t&&Boolean(t)}},handleLogin:function(){var e=this;this.$refs.loginForm.validate((function(o){o&&(e.loading=!0,e.loginForm.rememberMe?(e.$cookie.set("username",e.loginForm.username,{expires:30}),e.$cookie.set("password",e.loginForm.password,{expires:30}),e.$cookie.set("rememberMe",e.loginForm.rememberMe,{expires:30})):(e.$cookie.delete("username"),e.$cookie.delete("password"),e.$cookie.delete("rememberMe")),e.$http({url:e.$http.adornUrl("/sys/login"),method:"post",data:e.$http.adornData({username:e.loginForm.username,password:e.loginForm.password,uuid:e.loginForm.uuid,captcha:e.loginForm.captcha})}).then((function(o){var t=o.data;t&&200===t.code?(e.$cookie.set("token",t.token),console.log("0k"),e.$router.push({name:"home"})):(e.getCaptcha(),e.$message.error(t.msg),e.loading=!1)})).catch((function(){e.loading=!1,e.getCaptcha()})))}))}}},s=a,l=(t("5c87"),t("2877")),c=Object(l["a"])(s,i,n,!1,null,null,null);o["default"]=c.exports},"52aa":function(e,o,t){},"5c87":function(e,o,t){"use strict";var i=t("52aa"),n=t.n(i);n.a}}]);