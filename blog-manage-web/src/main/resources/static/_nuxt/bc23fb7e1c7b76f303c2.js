(window.webpackJsonp=window.webpackJsonp||[]).push([[4],{407:function(t,e,r){"use strict";r.r(e);r(174);var n=r(12),o=r.n(n),c={layout:"blog",name:"index",data:function(){return{treatiseList:[],search:{keyWord:"",total:0,currentPage:1,pageSize:10}}},methods:{addRecord:function(){o.a.post("/blog/blogLogRecord/addRecord",{recordType:3}).then(function(t){200==t.data.code&&console.log(t.data.code)})},getTreatiseList:function(t){this.search.currentPage=t;var e=this;o.a.get("/blog/blogTreatise/list",{params:e.search}).then(function(t){200==t.data.code&&(e.treatiseList=t.data.data.page.records,e.search.total=t.data.data.page.total,e.search.currentPage=t.data.data.page.current,e.comsys.backToTop())})}},created:function(){this.addRecord(),this.getTreatiseList(1)},mounted:function(){}},l=r(3),component=Object(l.a)(c,function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("main",[r("div",{staticClass:"bloglist"},[r("ul",{attrs:{id:"treatise-list"}},t._l(t.treatiseList,function(e,n){return r("li",{key:n},[r("el-card",{staticClass:"box-card"},[r("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[r("h2",[r("nuxt-link",{attrs:{to:"/detail/"+e.uuid,title:e.treatiseTitle}},[t._v(t._s(e.treatiseTitle))])],1),t._v(" "),r("div",{staticStyle:{color:"#A8B1BA","margin-bottom":"10px"}},[t._v(t._s(e.createTime))]),t._v(" "),r("div",{staticClass:"blogtext"},[t._v(t._s(e.treatisePreview))])]),t._v(" "),r("p",{staticClass:"bloginfo"},[r("span",[t._v(t._s(1==e.source?"原创":"转载"))]),t._v(" "),r("span",[t._v("["),r("nuxt-link",{attrs:{to:"/knowledge/knowledge?categoryId="+e.fId+"&thisCategory="+e.categoryId}},[t._v(t._s(e.categoryName))]),t._v("]")],1),t._v(" "),r("span",[t._v("阅读("+t._s(e.readNum)+")")]),t._v(" "),r("nuxt-link",{staticClass:"el-button el-button--primary",staticStyle:{float:"right","line-height":"6px"},attrs:{to:"/detail/"+e.uuid}},[t._v("阅读全文")])],1)])],1)}),0)]),t._v(" "),r("el-pagination",{staticStyle:{margin:"10px 0"},attrs:{background:"",layout:"prev, pager, next","current-page":t.search.currentPage,"page-size":t.search.pageSize,total:t.search.total},on:{"current-change":t.getTreatiseList,"update:currentPage":function(e){return t.$set(t.search,"currentPage",e)},"update:current-page":function(e){return t.$set(t.search,"currentPage",e)}}})],1)])},[],!1,null,null,null);e.default=component.exports}}]);