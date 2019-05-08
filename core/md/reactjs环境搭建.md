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