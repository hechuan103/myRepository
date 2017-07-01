layui.use(['tree', 'layer','element'], function(){
  var layer = layui.layer
  ,$ = layui.jquery
  ,element = layui.element(); //Tab的切换功能，切换事件监听等，需要依赖element模块
  globalTabIdIndex = 0;
  //触发事件
  var active = {
    tabAdd: function(){
      //新增一个Tab项
    	element.tabAdd('tab', {
        title:  "<i class='"+$(this).attr('type')+"'></i>"+$(this).text() + "<i class='layui-icon layui-unselect layui-tab-close'>ဆ</i>",  
        content: "<iframe name='iframe' data-id='"+globalTabIdIndex+"' class='larry-iframe' src='" + $(this).attr('title') + "' frameborder='0' style='width: 100%;'></iframe>"
      });
      //增加点击关闭事件  
      var r = $("#tabTitle").find("li");  
      //每次新打开tab都是最后一个，所以只对最后一个tab添加点击关闭事件  
      r.eq(r.length - 1).children("i.layui-tab-close").on("click", function() {  
          element.tabDelete("tab", $(this).parent("li").index());  
      });
      element.tabChange("tab", r.length - 1);  
      element.init();
    }
    ,tabDelete: function(index){
      //删除指定Tab项
      element.tabDelete('tab', index); //删除第3项（注意序号是从0开始计算）
    }
    ,tabChange: function(index){
      //切换到指定Tab项
      element.tabChange('tab', index); //切换到第2项（注意序号是从0开始计算）
    }
  };
  //监听导航点击
  $("a[name='a']").on("click", function() {  
      var title = $(this).text();  
      var tabs = $(".layui-tab-title").children();  
      for(var i = 0; i < tabs.length; i++) { 
    	  //截取title
    	  var h = $(tabs[i]).html().substr($(tabs[i]).html().indexOf("/")-1);
    	  var m = h.substr(h.indexOf(">"),h.indexOf("c"));
    	  var t = m.substr(m.indexOf(" "),m.indexOf("<")-1);
          if(t == title) {  
              element.tabChange('tab', i);  
              return;  
          }  
      }
      globalTabIdIndex++;
      active["tabAdd"].call(this);  
      active.tabChange($(".layui-tab-title").children().length - 1);  
  }); 


  
});