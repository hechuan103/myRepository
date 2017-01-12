layui.use(['tree', 'layer','element'], function(){
  var layer = layui.layer
  ,$ = layui.jquery
  ,element = layui.element(); //Tab的切换功能，切换事件监听等，需要依赖element模块
  //触发事件
  var active = {
    tabAdd: function(name){
      //新增一个Tab项
      element.tabAdd('tab', {
        title: name //用于演示
        ,content: '内容'+ (Math.random()*1000|0)
      })
    }
    ,tabDelete: function(){
      //删除指定Tab项
      element.tabDelete('demo', 2); //删除第3项（注意序号是从0开始计算）
    }
    ,tabChange: function(){
      //切换到指定Tab项
      element.tabChange('demo', 1); //切换到第2项（注意序号是从0开始计算）
    }
  };
  //监听导航点击
  element.on('nav(demo)', function(elem){
	  active.tabAdd(elem.text());
    layer.msg();
  });
  


  
});