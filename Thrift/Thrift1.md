## Type System
Thrift类型系统目的是使程序员能够使用编程语言本身定义的类型进行开发.
Thrift类型系统不引入任何动态类型或包装对象,也不要求程序员处理对象的序列化或传输.
Thrift的接口定义语言(IDL)文件帮助程序员定义能够跨语言安全传输对象所需最少的必要信息.

### 基本类型
Thrift类型系统中的基本类型包括:
• bool A boolean value, true or false • byte A signed byte
• i16 A 16-bit signed integer
• i32 A 32-bit signed integer
• i64 A 64-bit signed integer
• double A 64-bit floating point number
• string An encoding-agnostic text or binary string
基本类型是所有语言中都支持的类型,而一些特殊类型不包括在其中.
