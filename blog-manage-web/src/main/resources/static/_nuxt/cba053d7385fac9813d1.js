(window.webpackJsonp=window.webpackJsonp||[]).push([[8],{402:function(e,t,r){"use strict";r.r(t);r(174);var n=r(12),l=r.n(n),o={layout:"blog",name:"gbookVue",data:function(){return{search:{total:0,currentPage:1,pageSize:10},messages:[],blogLeaveMessage:{},rules:{fanName:[{required:!0,message:"请输入名称",trigger:"blur"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"blur"}],contactMail:[{required:!0,message:"请输入邮箱",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:["blur","change"]}],messageContent:[{required:!0,message:"请输入留言",trigger:"blur"},{min:1,max:500,message:"长度在 1 到 500 个字符",trigger:"blur"}]}}},methods:{getMessageList:function(e){var t=this;l.a.get("/blog/blogLeaveMessage/list",{params:t.search}).then(function(e){200==e.data.code&&(t.messages=e.data.data.page.records,t.search.total=e.data.data.page.total,t.search.currentPage=e.data.data.page.current)})},submitLeaveMessage:function(e){var t=this,r=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;l.a.post("/blog/blogLeaveMessage/save",t.blogLeaveMessage).then(function(e){200==e.data.code&&(r.blogLeaveMessage={},r.getMessageList(1),r.comsys.backToTop())})})}},created:function(){this.getMessageList(1)},mounted:function(){}},c=r(3),component=Object(c.a)(o,function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("main",[r("div",{staticClass:"address"},[r("el-breadcrumb",{staticStyle:{"font-size":"15px",padding:"5px 0"},attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[e._v("网站首页")]),e._v(" "),r("el-breadcrumb-item",[e._v("留言")])],1)],1),e._v(" "),r("div",{staticClass:"gbinfos",attrs:{id:"leaveMessage"}},[e._l(e.messages,function(t,n){return r("div",{key:n},[r("div",{staticClass:"fb"},[r("ul",{style:"background: url(/images/head/head_"+t.headImgNum+".png) no-repeat top 2px left 5px;"},[r("p",{staticClass:"fbtime"},[r("span",[e._v(e._s(t.createTime))]),e._v(e._s(t.fanName))]),e._v(" "),r("pre",{staticClass:"fbinfo"},[e._v(e._s(t.messageContent))])])]),e._v(" "),null!=t.reply?r("div",{staticClass:"replyDiv"},[r("ul",[r("p",{attrs:{id:"reply"}},[r("span",{staticStyle:{color:"#FF0000"}},[e._v("回复: ")]),e._v(e._s(t.reply))])])]):e._e()])}),e._v(" "),r("el-pagination",{staticStyle:{"margin-top":"15px"},attrs:{background:"",layout:"prev, pager, next","current-page":e.search.currentPage,"page-size":e.search.pageSize,total:e.search.total},on:{"current-change":e.getMessageList,"update:currentPage":function(t){return e.$set(e.search,"currentPage",t)},"update:current-page":function(t){return e.$set(e.search,"currentPage",t)}}})],2),e._v(" "),r("div",[r("el-form",{ref:"blogLeaveMessage",staticClass:"demo-ruleForm",attrs:{model:e.blogLeaveMessage,rules:e.rules}},[r("p",[r("strong",[e._v("来说点儿什么吧...")])]),e._v(" "),r("el-form-item",{attrs:{label:"您的姓名:",prop:"fanName"}},[r("el-input",{model:{value:e.blogLeaveMessage.fanName,callback:function(t){e.$set(e.blogLeaveMessage,"fanName",t)},expression:"blogLeaveMessage.fanName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"联系邮箱:",prop:"contactMail"}},[r("el-input",{model:{value:e.blogLeaveMessage.contactMail,callback:function(t){e.$set(e.blogLeaveMessage,"contactMail",t)},expression:"blogLeaveMessage.contactMail"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"留言内容:",prop:"messageContent"}},[r("el-input",{attrs:{type:"textarea",cols:"60",rows:"12"},model:{value:e.blogLeaveMessage.messageContent,callback:function(t){e.$set(e.blogLeaveMessage,"messageContent",t)},expression:"blogLeaveMessage.messageContent"}})],1),e._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitLeaveMessage("blogLeaveMessage")}}},[e._v("提交")])],1)],1)],1)])},[],!1,null,null,null);t.default=component.exports}}]);