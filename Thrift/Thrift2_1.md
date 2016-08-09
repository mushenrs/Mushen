1.异常(Exception)
异常在结构和功能上与结构相同, 不同的是声明异常使用关键字exception.
生成的对象都继承自目标语言的一个基础异常类型
2.服务(Service)
service <name> {
    <returntype> <name>(<arguments>)[throws (<exceptions>)]
    ...
}

void是方法返回值的一个有效类型
async关键字可以添加到void方法中,表示异步,不用等待服务器响应
即使一个纯空的方法,如果不是异步的,也会等待服务器端的响应,以便保证请求在服务器端被完成了.

3.传输层(transport layer)
将传输层从代码生成层解耦
字节流套接字(stream socket)
源IP地址和目的IP地址以及源端口号和目的端口号的组合称为套接字
org.apache.thrift.transport.TTransport
• open Opens the tranpsort
• close Closes the tranport
• isOpen Indicates whether the transport is open • read Reads from the transport
• write Writes to the transport
• flush Forces any pending writes
org.apache.thrift.transport.TServerTransport
• open Opens the transport
• listen Begins listening for connections
• accept Returns a new client transport
• close Closes the transport

org.apache.thrift.transport.TFileTransport extends TTransport

