(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{400:function(t,e,o){"use strict";o.r(e);var n=o(12),r=o.n(n),c={layout:"blog",name:"aboutMeVue",data:function(){return{aboutMeInfo:{},runTime:""}},methods:{initInfo:function(){var t=this;r.a.get("/blog/blogAboutMe/info/1").then(function(e){200==e.data.code&&(t.aboutMeInfo=e.data.data.object)})}},created:function(){this.initInfo()},mounted:function(){var t=this;this.timer=setInterval(function(){t.runTime=t.comsys.timeFn(t.aboutMeInfo.domainTime)},1e3)},beforeDestroy:function(){this.timer&&clearInterval(this.timer)}},_=o(3),component=Object(_.a)(c,function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("main",[o("div",{staticClass:"address"},[o("el-breadcrumb",{staticStyle:{"font-size":"15px",padding:"5px 0"},attrs:{"separator-class":"el-icon-arrow-right"}},[o("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[t._v("网站首页")]),t._v(" "),o("el-breadcrumb-item",[t._v("关于我")])],1)],1),t._v(" "),o("div",{staticClass:"infosbox"},[o("h1",{staticClass:"infotitle"},[t._v("关于我")]),t._v(" "),o("div",{staticClass:"news_con"},[o("p",[t._v("博主："+t._s(t.aboutMeInfo.myName))]),t._v(" "),o("p",[t._v("简介："+t._s(t.aboutMeInfo.aboutMe))]),t._v(" "),o("p",{staticStyle:{color:"red"}},[t._v("博客运行时间："+t._s(t.runTime))]),t._v(" "),o("h2",[t._v("About my blog")]),t._v(" "),o("p",[t._v("域 名："),o("a",{attrs:{href:t.aboutMeInfo.blogDomainName,target:"_blank"}},[t._v(t._s(t.aboutMeInfo.blogDomainName))])]),t._v(" "),t._m(0),t._v(" "),o("p",[t._v("服务器："+t._s(t.aboutMeInfo.serverName)+"\n            ")]),o("p",[t._v("备案号："+t._s(t.aboutMeInfo.recordNumber))]),t._v(" "),o("p",[t._v("技 术："+t._s(t.aboutMeInfo.programType))])])])])},[function(){var t=this.$createElement,e=this._self._c||t;return e("p",[this._v("GitHub："),e("a",{attrs:{href:"https://github.com/wangfujie",target:"_blank"}},[this._v("https://github.com/wangfujie")])])}],!1,null,null,null);e.default=component.exports}}]);