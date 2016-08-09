## Protocol
Thrift的协议非常简单,它从根本上支持两件事:
1.bidirectional sequenced messaging
2.encoding of base types, containers, and structs

读取结构(struct)的过程是readFieldBegin()开始,直到所有域结束,然后调用方法readStructEnd().

## Structure
支持编码成流式协议(streaming protocol)
STOP
org.apache.thrift.transport.TFramedTransport


## Versioning
### 域标识符(Field Identifiers)

### 检测变量是否设置(Isset)


org.apache.thrift.TProcessor
