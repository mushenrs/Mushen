## 将CSS应用到HTML中的三种方式:
1.style属性
为标签指定样式
2.<style>标签
HTML文档中使用<style>标签包裹CSS代码
3.<link>标签
<link>标签引用外部CSS样式表:<link href="style.css" rel="stylesheet" />

## CSS盒子模型
元素(element)有高度(height)和宽度(width),包围内容的是内边距(padding),内边距的边缘是边框(border),边框以外是外边距(margin).

## 浏览器属性前缀
-webkit-:webkit为核心浏览器,Chrome和Safari等
-moz-:火狐浏览器(Firefox)
-ms-:IE浏览器
-o-:Opera浏览器

## 块级元素浮动
使用CSS的float属性
属性值:none(默认值), left, right, inherit(继承父元素)
块级元素的宽度默认是100%,设置了float属性,宽度会随着内容自动调整
设置了浮动之后,元素会在z轴上浮动起来,脱离正常的文档流,父元素的高度会变成0
清除浮动:clear属性,属性值:left, right, both.
清除浮动的万能代码:
html body div.clear, html body span.clear{
    background: none;
    border: 0;
    /* 这句是重点,其他是兼容代码*/
    clear: both;
    display: block;
    float: none;
    font-size: 0;
    margin: 0;
    padding: 0;
    overflow: hidden;
    visibility: hidden;
    width: 0;
    height: 0;
}
/* 在需要清除浮动的元素后面添加<div class="clear"></div>即可*/
对父元素使用伪类:after可以使得父元素的高度不再为0.
