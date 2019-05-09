### 环境搭建

```
 1.检查nodejs
  > node -v
 2.安装yarn，其中tyarn用的是阿里的源，yarn可以看作是npm的优化。 -g指全局安装
  > npm i yarn tyarn -g
  > tyarn -v
 3.安装umi
  > tyarn global add umi
  > umi #运行
```

> 运行umi命令时提示，不是内部或者外部命令。解决办法：运行yarn global bin

### 快速入门
```
  1.项目目录下
  2.tyarn init -y # 通过初始化命令将生成package.json文件，它是nodejs约定的用来
   存放项目的信息配置等信息。
  3.创建index.js
   > umi g page index
  4.启动，转码
   > umi dev
  5.(或者初始化1,后直接给项目添加umi的依赖)
   > tyarn add umi --dev # 管理訸编译
```
### react
```
  添加umi的react插件：
  >tyarn add umi-plugin-react --dev
  在项目钟引入plugins:config/config.js
  export default {
     plugins:[
       ['umi-plugin-react',{//开启哪些功能}]
     ]
  }
  ** 浏览器无法支持es6语法，需要插件转化为es5
  构建项目
  >umi build
```

### jsx语法
- 1 只能有一个根节点
- 2 {}中插入js脚本

#####    定义组件
```
class hello extends React.Component{

  render(){
  	return(
      <dev>hello</dev>
  	);
  }

}

export default hello;
```
##### 组件的传值
```
 1.接收父组件的值：
   父组写法<hello name='aaa'>xxx</hello>
   子获取<div name = {this.props.name}>{this.props.children}</div>

 ** this.props.children 获取组件包裹内容
```

##### dva学习
 - model层，用来做数据模板，帮page层显示用
 ```
 export default {
   // 类似package
   namespace:'userList',
   // 数据体，属性列表
   state:{
     list:[]
   },
   //函数部分，用来操作数据体
     reducers:{
       //state 更新之前的state
       queryList(state,result){
         let data = [...result.data];
         //更新之后的数据
         return {
           list:data
         }
       }
     }}
 }
 ```
 - page层，用来做数据的显示，和操作
 ```
 1.引入dva，用来做数据桥接
 import {connect} from 'dva';
 2.指定name，用来区别使用的model
 const namespace = "userList";
 3.在组建上做注解
 @connect((state)=>{
     //state 是全局的，需要根据namespace指向对应的model,便可以使用model的state对象中的数据
     const listData = state[namespace].list;
     //返回一个对象到this.props中，组建就可以使用返回的对象属性做数据的显示
     return {datas:listData}
 },(dispatch)=>{
     //返回一个对象（属性为函数，用来修改model中的数据），绑定到this.props中，根据namespace+/函数名，定位到model中reducers的对应方法。
     return {
         queryList:()=>{
             dispatch({type:namespace+"/queryList"})
         }
     }
 })
 ```