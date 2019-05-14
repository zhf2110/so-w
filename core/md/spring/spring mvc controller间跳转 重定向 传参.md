#### 后台一个controller跳转到另一个controller,不需要传递参数
 - 1 使用ModelAndView
 ```
  return new ModelAndView("redirect:/toList");
 ```
 - 2 返回String
 ```
  return "redirect:/ toList ";
 ```
#### 带参数的了，带参数可以拼接url
 - 1 自己手动拼接url
 ```
 new ModelAndView("redirect:/toList？param1="+value1+"&param2="+value2);
 //这样有个弊端，就是传中文可能会有乱码问题。
 ```
 - 2 用RedirectAttributes，这个是发现的一个比较好用的一个类
                         这里用它的addAttribute方法，这个实际上重定向过去以后你看url，是它自动给你拼了你的url。
 ```
 attr.addAttribute("param", value);
 return "redirect:/namespace/toController";
 ```
#### 带参数不拼接url页面也能拿到值

