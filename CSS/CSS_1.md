一, CSS(Cascading Style Sheets)样式由一条或多条以分号相隔的样式声明(CSS属性和该属性的值,以冒号相隔)组成,例如:
background-color: grey; color:white;
使用CSS:
1.使用元素的全局属性style, 将样式设置到某个元素上:
`<a href="https://www.google.com" style="background-color: grey; color:white;">Google</a>`
2.使用style元素定义文档内嵌样式,通过CSS选择器指示浏览器应用样式:
<style>
    a {
        background-color: grey;
        color:black;
    }
</style>
3.使用link元素链入外部样式表(以.css结尾的文件):
<link rel="stylesheet" type="text/css" href="style.css"></link>
在样式表中可以使用@import导入其他的样式表:
@import "style-main.css";
在样式表中可以出现在@import语句之前的只有@charset语句,用于声明样式表使用的字符编码:
@charset "UTF-8";

二, 样式的层叠和继承
浏览器显示元素时求索一个CSS属性值的次序:
1.元素内嵌样式(元素全局属性style定义的样式)
2.文档内嵌样式(定义在style元素中的样式)
3.外部样式(用link元素导入的样式)
4.用户样式
5.浏览器样式
改变正常的层叠次序: 使用'!important'将样式属性值标记为重要,可以使不管这种样式属性定义在什么地方,浏览器都会给予优先考虑.
a {
    background-color: grey !important;
}

如果浏览器在直接相关的样式中找不到某个属性的值,就会使用父元素的这个样式属性值.但是并非所有CSS属性均可继承,与元素外观(文字颜色,字体等)相关的样式会被继承;与元素在页面上的布局相关的样式不会被继承.使用inherit这个关键字可以强行实施继承:
p {
    border: medium solid black;
}
span {
    border: inherit;
}

三, CSS中的颜色
设置颜色:
1.使用规定的颜色名称: white, red, black...
2.设置红,绿,蓝三种颜色成分的值(十进制或十六进制): 255,255,255/#FFFFFF    255,0,0/#FF0000     0,0,0/#000000
3.CSS颜色函数:
rgb(r, g, b)用RGB模型表示颜色,如 rgb(112, 128, 144)
rgba(r, g, b, a)用RGB模型表示颜色,a表示透明度(0表示全透明,1表示完全不透明),如rgba(112, 128, 144, 0.4)
hsl(h, s, l)用HSL模型(色相[hue],饱和度[saturation],明度[lightness])表示颜色,如hsl(120, 100%, 22%)
hsla(h, s, l, a)用HSL模型表示颜色,a表示透明度(0表示全透明,1表示完全不透明),如hsl(120, 100%, 22%, 0.4)

四, CSS中的长度
CSS属性设置长度时,应让数字和单位标识符连在一起,两者之间不加空格或其他字符.
1.绝对长度
CSS支持5种绝对单位:
in  英寸
cm  厘米
mm  毫米
pt  磅(1pt = 1/72 in)
pc  pica(1pc = 12pt)

2.相对长度
主流浏览器支持的一些CSS相对单位:
em  与元素字号挂钩
ex  与元素字体的"x高度"挂钩
rem 与根元素的字号挂钩
px  CSS像素(假定显示设备的分辨率为96dpi)
%   另一属性的值的百分比

2.1 em
p {
    font-size: 15pt;
    height: 2em; // p元素显示出来的高度为字号的两倍
}
2.2 rem
html {
    font-size: 0.2in;
}
p {
    font-size: 2rem; // rem单位根据html元素(根元素)的字号而定
    height: 2em; // p元素显示出来的高度为字号的两倍
}
2.3 ex
当前字体的x高度,即字体基线到中线之间的距离,通常1ex约等于0.5em
2.4 px
CSS中的像素本来定义为相对度量单位,但是实际上在浏览器中却被当做绝对单位对待: 1px约等于1/96英寸
2.5 %
可以将一个度量单位表示为其他属性值的百分比.
3. 用算式作值
算式包含在关键字calc之后的括号中,在其中可以混合使用各种单位进行基本的算术运算:
p {
    width: calc(80% - 20px)
}

五, CSS标准化
浏览器厂商的CSS3特性的前缀:
Chrome, Safari      -webkit-
Opera               -o-
Firefox             -moz-
Internet Explorer   -ms-

