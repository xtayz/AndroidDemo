# Android学习过程中碰到的问题

## 怎样快速输入switch ... case ...
Preference -> Live Templates 自己添加模版。别忘记了Define中勾选Java。

```java
switch ($value$) {
    case $name$:
        break;
    case $name$:
        break;
    case $name$:
        break;
    default:
        break;
}
```

## 让用户选择浏览器打开网页

```Java
// 让用户选择浏览器打开网页
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.addCategory(Intent.CATEGORY_DEFAULT);
intent.setData(Uri.parse("http://www.baidu.com"));
startActivity(intent);
``` 
```Java
<intent-filter>
    <action android:name="android.intent.action.VIEW" />
    <category android:name="android.intent.category.DEFAULT" />
    <data android:scheme="http" />
</intent-filter>
```
以上代码是《第一行代码》中的**2.3.3**节中的例子，但是我在红米Note上运行的时候并没有出现预期中的选择打开方式的列表，而是直接调用系统的浏览器打开网页了。后来通过实验，在`data`标签中指定具体的host就可以了：

```Java
<data android:scheme="http" />
修改为
<data android:scheme="http"
	android:host="www.baidu.com" />
```

## Run的时候不弹出选择运行设备的提示框怎么办
在 Run -> Edit Configurations 中的 Deployment Target Options 栏目下，取消选中`Use same devices for future launches`后重新运行即可

## android.support.constraint.ConstraintLayout是什么
类似iOS的Storyboard，通过设置约束来实现复杂的页面布局

## android.widget.LinearLayout 与android.support.v7.widget.LinearLayoutCompat 区别 
The class LinearLayout exists since API level 1, but some APIs were added after that, for example, setShowDividers introduced on API level 11.

So in this case setShowDividers (and it's parameters) should be invoked using LinearLayoutCompat instead LinearLayout if you are targeting a platform with API level below 11.