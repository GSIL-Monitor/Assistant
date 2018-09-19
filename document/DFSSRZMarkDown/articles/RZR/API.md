

## 1.1	WebApi接口提供详细 ##

## 1.1.1	统一请求，响应头 ##
请求头参数
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
  <td>
   说明
  </td>
 </tr>
 <tr>
  <td>
   Version
  </td>
  <td>
   版本
  </td>
  <td>
   string
  </td>
  <td>
   1.0.0
  </td>
 </tr>
 <tr>
  <td>
   Token
  </td>
  <td>
   凭证
  </td>
  <td>
   string
  </td>
  <td>
   暂时为任何数字
  </td>
 </tr>
 <tr>
  <td>
   AppType
  </td>
  <td>
   类型
  </td>
  <td>
   int
  </td>
  <td>
  0:PC、1:Android、2:IOS、3:微信、4：M站
  </td>
 </tr>
</table>


响应头参数
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
  Value 类型
  </td>
  <td>
   说明
  </td>
 </tr>
 <tr>
  <td>
   Ret
  </td>
  <td>
   返回值
  </td>
  <td>
   int
  </td>
  <td>
  接口调用结果（0 成功，-1 失败）
  </td>
 </tr>
 <tr>
  <td>
   Code
  </td>
  <td>
   返回code  
  </td>
  <td>
  string  
  </td>
   <td>
   接口返回码
  </td>
 </tr>
 <tr>
  <td>
   Msg
  </td>
  <td>
   返回信息
  </td>
  <td>
   string
  </td>
  <td>
  接口调用成功或失败的描述
  </td>
 </tr>
</table>



## 1.1.2	城市列表接口（GetCityList） ##
- 接口名称：GetCityList
- 功能简述： 获取内网所有城市列表
- 测试地址：http://10.40.3.230:5555/City/GetCityList



### 1、	入参说明： ###

无


### 2、	出参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   城市信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   CityName
  </td>
  <td>
   城市名称
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   城市编号
  </td>
  <td>
   string
  </td>
 </tr>
</table>

接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "CityName": "苏州",
                "CityCode": "SUZHOU"
            },
            {
                "CityName": "无锡",
                "CityCode": "WUXI"
            }
        ]
    }



## 1.1.3	获取指定进程的客户接口（GetCltExeCompanyList） ##
- 接口名称：GetCltExeCompanyList
- 功能简述：获取有意向、已来访、已签约、已成交进程的客户列表
- 测试地址：http://10.40.3.230:5555/Company/GetCltExeCompanyList


### 1、	入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   City
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   BeginDate
  </td>
  <td>
   开始日期
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EndDate
  </td>
  <td>
   结束日期
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求json）如：

    {
    "BeginDate": "2017-12-06 00:00:00",
    "EndDate": "2017-12-07 00:00:00",
    "City": "SUZHOU"
    }


### 2、出参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   客户信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   City
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   LNK_NAME
  </td>
  <td>
   联系人姓名
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   LNK_MOBILE
  </td>
  <td>
   联系人手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CmpName
  </td>
  <td>
   企业名称
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CmpCode
  </td>
  <td>
   企业编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CltGrade
  </td>
  <td>
   客户评级
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   CLT_OWNER
  </td>
  <td>
   对应的销售工号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EMP_NAME
  </td>
  <td>
   对应的销售姓名
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CltExeStatus
  </td>
  <td>
   客户进程描述
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   UpdateTime
  </td>
  <td>
   更新时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   IsSignContract
  </td>
  <td>
   是否签约
  </td>
  <td>
   bool
  </td>
 </tr>
 <tr>
  <td>
   UserStatus
  </td>
  <td>
   用户真实性等级
  </td>
  <td>
   int
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "City": "SUZHOU",
                "LNK_NAME": "合同关联",
                "LNK_MOBILE": "13862114748",
                "CmpName": "合同款单关联作废合同",
                "CmpCode": "AAC14032800307",
                "CltGrade": null,
                "CLT_OWNER": "AA3758",
                "EMP_NAME": "刘志",
                "CltExeStatus": "已签约",
                "UpdateTime": "/Date(1512531481370)/",
                "IsSignContract": false,
                "UserStatus": 2
            },
            {
                "City": "SUZHOU",
                "LNK_NAME": "张三",
                "LNK_MOBILE": "13771915788",
                "CmpName": "AAC14032800453有限公司",
                "CmpCode": "AAC14032800453",
                "CltGrade": null,
                "CLT_OWNER": "AA3758",
                "EMP_NAME": "刘志",
                "CltExeStatus": "已签约",
                "UpdateTime": "/Date(1512531483677)/",
                "IsSignContract": false,
                "UserStatus": 2
            }
        ]
    }


## 1.1.4	获取合同列表接口（GetContractList） ##
- 接口名称：GetContractList
- 功能简述：获取合同列表
- 测试地址：http://10.40.3.230:5555/Contract/GetContractList


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   City
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   BeginDate
  </td>
  <td>
   开始日期
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EndDate
  </td>
  <td>
   结束日期
  </td>
  <td>
   string
  </td>
 </tr>
</table>


（入参请求json）如：

    {
    "BeginDate": "2017-12-06 00:00:00",
    "EndDate": "2017-12-07 00:00:00",
    "City": "SUZHOU"
    }


### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   合同信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   City
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ContractCode
  </td>
  <td>
   合同编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EmpCode
  </td>
  <td>
   合同所属人工号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EmpName
  </td>
  <td>
   合同所属人姓名
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   申请时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   MemberType
  </td>
  <td>
   会员类型描述
  </td>
  <td>
   String
  </td>
 </tr>
 <tr>
  <td>
   MemberStatus
  </td>
  <td>
   会员状态描述
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   BaseContractCode
  </td>
  <td>
   基础合同编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ContractType
  </td>
  <td>
   合同类型描述
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ContractStatus
  </td>
  <td>
   合同状态描述
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ArchiveStatus
  </td>
  <td>
   归档状态描述
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   FinalArchiveTime
  </td>
  <td>
   归档时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   WbMemo
  </td>
  <td>
   外包备注
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   Memo
  </td>
  <td>
   会员备注
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CltName
  </td>
  <td>
   客户名称(公司名)
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   LnkName
  </td>
  <td>
   联系人
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   LnkMobile
  </td>
  <td>
   联系人手机
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ContractEndTime
  </td>
  <td>
   合同结束时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   UpdateTime
  </td>
  <td>
   更新时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
</table>

接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "City": "SUZHOU",
                "ContractCode": "NHY05122017000046",
                "EmpCode": "AA3758",
                "EmpName": "刘志",
                "CreateTime": "/Date(1512463412000)/",
                "MemberType": "5800会员",
                "MemberStatus": "新合同",
                "BaseContractCode": "",
                "ContractType": "新会员",
                "ContractStatus": "已归档",
                "ArchiveStatus": "正常归档",
                "FinalArchiveTime": "/Date(1512463489000)/",
                "WbMemo": "",
                "Memo": "方大化工",
                "CltName": "YYKKK科技",
                "LnkName": "YYKK",
                "LnkMobile": "13812929043",
                "ContractEndTime": "/Date(1543939200000)/",
                "UpdateTime": "/Date(1512542679000)/"
            },
            {
                "City": "SUZHOU",
                "ContractCode": "NHY05122017000037",
                "EmpCode": "AA3758",
                "EmpName": "刘志",
                "CreateTime": "/Date(1512463449000)/",
                "MemberType": "9800会员",
                "MemberStatus": "新合同",
                "BaseContractCode": "",
                "ContractType": "新会员",
                "ContractStatus": "已归档",
                "ArchiveStatus": "正常归档",
                "FinalArchiveTime": "/Date(1512542486000)/",
                "WbMemo": "",
                "Memo": "葛丰化工",
                "CltName": "YYKK2科技",
                "LnkName": "YYKK2",
                "LnkMobile": "13776133701",
                "ContractEndTime": "/Date(1543939200000)/",
                "UpdateTime": "/Date(1512542570000)/"
            }
        ]
    }



## 1.1.5	外网粒子注册来源信息推送至内网接口（ImportUtmSource） ##
- 接口名称：PushMsg
- 功能简述：外网粒子注册来源信息推送至内网接口
- 测试地址：http://10.40.3.230:5555/openapi/PushMsg


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
  <td>
   说明
  </td>
 </tr>
 <tr>
  <td>
   Guid
  </td>
  <td>
   唯一标识码
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Content
  </td>
  <td>
   推送内容
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MsgApi
  </td>
  <td>
   Api类型名字
  </td>
  <td>
   string
  </td>
  <td>
  例：ImportUtmSource
  </td>
 </tr>
 <tr>
  <td>
   MsgData
  </td>
  <td>
   请求数据
  </td>
  <td>
   Object
  </td>
  <td>
  UtmSource集合
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   UtmSourceID
  </td>
  <td>
   注册来源ID
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SourceStatus
  </td>
  <td>
   来源状态
  </td>
  <td>
   int
  </td>
  <td>
  1：有效，2：删除
  </td>
 </tr>
 <tr>
  <td>
   BusinessUnit
  </td>
  <td>
   事业部
  </td>
  <td>
   int
  </td>
  <td>
  1：一产，2：二产，3：三产
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   CallbackUrl
  </td>
  <td>
   回调地址
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CallbackParam
  </td>
  <td>
   回调参数
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
</table>


（入参请求json）如：

    {
    "Guid": "9612b8c0-c0be-4e66-a491-90ac55af5f01",
    "Content": null,
    "MsgApi": "ImportUtmSource",
    "MsgData": {
        "UtmSource": [
            {
                "UtmSourceID": 1,
                "SourceStatus": 1,
                "BusinessUnit": 1
            },
            {
                "UtmSourceID": 2,
                "SourceStatus": 1,
                "BusinessUnit": 2
            }
        ]
    },
    "CallbackUrl": null,
    "CallbackParam": null
    }


### 2、出参说明： ###

接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": true
    }



## 1.1.6	甩线索客户的回访信息接口（GetCustomerCallback） ##
- 接口名称：GetCustomerCallback
- 功能简述：获取甩线索客户的回访信息列表
- 测试地址：http://10.40.3.230:5555/CustomerCallback/GetCustomerCallback


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   StartTime
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EndTime
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/CustomerCallback/GetCustomerCallback?CityCode=SUZHOU&StartTime=2016-11-09&EndTime=2016-11-11



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   客户回访信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   CustomerCallbackId
  </td>
  <td>
   回访记录的唯一标识
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   Memo
  </td>
  <td>
   记录详情
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CltMobile
  </td>
  <td>
   客户手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CallbackEmployeeCode
  </td>
  <td>
   回访人工号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CallbackTime
  </td>
  <td>
   回访时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "CustomerCallbackId": 15465931,
                "Memo": "市场客户，貌似有需要，不透露信息",
                "CltMobile": "11122233356",
                "CallbackEmployeeCode": "AA5126",
                "CallbackTime": "2016-11-10 09:47:40"
            },
            {
                "CustomerCallbackId": 15470456,
                "Memo": "暂无意向",
                "CltMobile": "11122233356",
                "CallbackEmployeeCode": "AA4845",
                "CallbackTime": "2016-11-10 11:17:05"
            }
        ]
        }
    }



## 1.1.7	每次打电话给客户信息接口（TelRecordsForCustomer） ##
- 接口名称：TelRecordsForCustomer
- 功能简述：获取每次打电话给客户信息列表
- 测试地址：http://10.40.3.230:5555/TelRecordProcess/TelRecordsForCustomer


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   cityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   startTime
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   endTime
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/TelRecordProcess/TelRecordsForCustomer?cityCode=SUZHOU&startTime=2017-10-27&endTime=2017-10-28



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   客户电话信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   OrderCode
  </td>
  <td>
   主订单编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   SubOrderId
  </td>
  <td>
   子订单编号
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   TotalCallLength
  </td>
  <td>
   累计通话时长
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   CallLength
  </td>
  <td>
   本次通话时长
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   CallTime
  </td>
  <td>
   通话时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   CustomerPhone
  </td>
  <td>
   客户手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   RZTelRecordProcessId
  </td>
  <td>
   唯一标识ID
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   Process
  </td>
  <td>
   本次通话所属进程
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   Active
  </td>
  <td>
   有效性
  </td>
  <td>
   bool
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "OrderCode": "AAS17072700003",
                "SubOrderId": null,
                "TotalCallLength": 50,
                "CallLength": 50,
                "CallTime": "2016-11-17 20:34:16",
                "CustomerPhone": "18321950423",
                "RZTelRecordProcessId": 100053865,
                "Process": 50,
                "Active": false
            },
            {
                "OrderCode": "AAS17072700003",
                "SubOrderId": null,
                "TotalCallLength": 50,
                "CallLength": 50,
                "CallTime": "2016-11-17 20:34:16",
                "CustomerPhone": "18321950423",
                "RZTelRecordProcessId": 100053866,
                "Process": 60,
                "Active": true
            }
            ]
        }
    }



## 1.1.8	每次打电话给信贷经理信息接口（TelRecordsForcCreditManager） ##
- 接口名称：TelRecordsForcCreditManager
- 功能简述：获取每次打电话给信贷经理信息列表
- 测试地址：http://10.40.3.230:5555/TelRecordProcess/TelRecordsForcCreditManager


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   cityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   startTime
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   endTime
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/TelRecordProcess/TelRecordsForcCreditManager?cityCode=SUZHOU&startTime=2017-06-01&endTime=2017-06-02



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   信贷经理电话信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   OrderCode
  </td>
  <td>
   主订单编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   SubOrderId
  </td>
  <td>
   子订单编号
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   TotalCallLength
  </td>
  <td>
   累计通话时长
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   CallLength
  </td>
  <td>
   本次通话时长
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   CallTime
  </td>
  <td>
   通话时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   CustomerPhone
  </td>
  <td>
   客户手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   RZTelRecordProcessId
  </td>
  <td>
   唯一标识ID
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   Process
  </td>
  <td>
   本次通话所属进程
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   BranchContactID
  </td>
  <td>
   本次通话信贷经理ID
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   ContactBranchContacts
  </td>
  <td>
   已联系信贷经理数
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   Active
  </td>
  <td>
   有效性
  </td>
  <td>
   bool
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "OrderCode": "AAS16111400009",
                "SubOrderId": 100048248,
                "TotalCallLength": 15,
                "CallLength": 15,
                "CallTime": "2017-06-01 10:19:58",
                "CustomerPhone": "15658683531",
                "RZTelRecordProcessId": 100053831,
                "Process": 10,
                "BranchContactID": null,
                "ContactBranchContacts": 1,
                "Active": true
            },
            {
                "OrderCode": "AAS16111400009",
                "SubOrderId": 100048248,
                "TotalCallLength": 30,
                "CallLength": 15,
                "CallTime": "2017-06-01 14:03:59",
                "CustomerPhone": "15658683531",
                "RZTelRecordProcessId": 100053832,
                "Process": 10,
                "BranchContactID": null,
                "ContactBranchContacts": 1,
                "Active": true
            }
            ]
        }
    }



## 1.1.9	主订单进程推送信息接口（MainOrderProcess） ##
- 接口名称：MainOrderProcess
- 功能简述：主订单进程推送
- 测试地址：http://10.40.3.230:5555/TelRecordProcess/MainOrderProcess


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   cityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   startTime
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   endTime
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/TelRecordProcess/MainOrderProcess?cityCode=SUZHOU&startTime=2017-11-30&endTime=2017-12-01



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   主订单进程推送信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   Time
  </td>
  <td>
   各行为对应的时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   OrderCode
  </td>
  <td>
   主订单编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CustomerPhone
  </td>
  <td>
   客户手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   Process
  </td>
  <td>
   进程
  </td>
  <td>
   Int
  </td>
 </tr>
 <tr>
  <td>
   Action
  </td>
  <td>
   行为
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   ServiceCode
  </td>
  <td>
   融服工号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   ServiceName
  </td>
  <td>
   融服姓名
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   Telephone
  </td>
  <td>
   固定电话
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   MobilePhone
  </td>
  <td>
   手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   Remark
  </td>
  <td>
   备注
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   OrderActionId
  </td>
  <td>
   唯一标识ID
  </td>
  <td>
   long
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "Time": "2017-11-30 16:18:32",
                "OrderCode": "AAS17101900002",
                "CustomerPhone": "18510190002",
                "Process": 100,
                "Action": 3,
                "ServiceCode": "AA1128",
                "ServiceName": "邱顺",
                "Telephone": "13962556636",
                "MobilePhone": "13962556636",
                "Remark": "1111111",
                "OrderActionId": 100113877
            },
            {
                "Time": "2017-11-30 16:18:57",
                "OrderCode": "AAS17101900006",
                "CustomerPhone": "11000000041",
                "Process": 100,
                "Action": 3,
                "ServiceCode": "AA1128",
                "ServiceName": "邱顺",
                "Telephone": "13962556636",
                "MobilePhone": "13962556636",
                "Remark": "11111111111",
                "OrderActionId": 100113878
            }
            ]
        }
    }



## 1.1.10	子订单进程推送信息接口（SubOrderProcess） ##
- 接口名称：SubOrderProcess
- 功能简述：子订单进程推送
- 测试地址：http://10.40.3.230:5555/TelRecordProcess/SubOrderProcess


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   cityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   startTime
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   endTime
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/TelRecordProcess/SubOrderProcess?cityCode=SUZHOU&startTime=2017-11-30&endTime=2017-12-01



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   子订单进程推送信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   Time
  </td>
  <td>
   各行为对应的时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
 <tr>
  <td>
   OrderCode
  </td>
  <td>
   主订单编号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   SubOrderId
  </td>
  <td>
   子订单编号
  </td>
  <td>
   long
  </td>
 </tr>
 <tr>
  <td>
   CustomerPhone
  </td>
  <td>
   客户手机号
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   Process
  </td>
  <td>
   进程
  </td>
  <td>
   Int
  </td>
 </tr>
 <tr>
  <td>
   Action
  </td>
  <td>
   行为
  </td>
  <td>
   int
  </td>
 </tr>
 <tr>
  <td>
   LendingTotal
  </td>
  <td>
   本次放款金额
  </td>
  <td>
   double
  </td>
 </tr>
 <tr>
  <td>
   TotalLendingTotal
  </td>
  <td>
   累计放款金额
  </td>
  <td>
   double
  </td>
 </tr>
 <tr>
  <td>
   Remark
  </td>
  <td>
   备注
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   SubOrderActionId
  </td>
  <td>
   唯一标识ID
  </td>
  <td>
   long
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "Time": "2017-12-01 17:28:21",
                "OrderCode": "AAS17092700001",
                "SubOrderId": 100048328,
                "CustomerPhone": "17621215246",
                "Process": 0,
                "Action": null,
                "LendingTotal": 0,
                "TotalLendingTotal": 0,
                "Remark": "11111【作废审批提交】",
                "SubOrderActionId": 100118233
            },
            {
                "Time": "2017-12-01 17:30:19",
                "OrderCode": "AAS17072700003",
                "SubOrderId": 100048311,
                "CustomerPhone": "18321950423",
                "Process": 0,
                "Action": null,
                "LendingTotal": 0,
                "TotalLendingTotal": 0,
                "Remark": "1111111111【作废审批提交】",
                "SubOrderActionId": 100118234
            }
            ]
        }
    }



## 1.1.11	获取客户需求书的手机号码接口（GetContactPhoneList） ##
- 接口名称：GetContactPhoneList
- 功能简述：获取客户需求书的手机号码列表
- 测试地址：http://10.40.3.230:5555/Company/GetContactPhoneList


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   BeginDate
  </td>
  <td>
   开始时间
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   EndDate
  </td>
  <td>
   结束时间
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/Company/GetContactPhoneList?CityCode=SUZHOU&BeginDate=2016-11-10&EndDate=2016-11-11



### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   客户需求书的手机号码信息集合
  </td>
  <td>
   List
  </td>
 </tr>
 <tr>
  <td colspan="3">
  </td>
 </tr>
 <tr>
  <td>
   CellPhone
  </td>
  <td>
   手机号码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   UpdateTime
  </td>
  <td>
   更新时间
  </td>
  <td>
   DateTime
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "CellPhone": "15162414200",
                "UpdateTime": "/Date(1478737733783)/"
            },
            {
                "CellPhone": "13301665015",
                "UpdateTime": "/Date(1478748757870)/"
            }
            ]
        }
    }



## 1.1.12	根据手机号获取指定城市的融资申请书详情接口（GetFinancingBookInfo） ##
- 接口名称：GetFinancingBookInfo
- 功能简述：根据手机号获取指定城市的融资申请书详情
- 测试地址：http://10.40.3.230:5555/Company/GetFinancingBookInfo


### 1、入参说明： ###
<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   城市编码
  </td>
  <td>
   string
  </td>
 </tr>
 <tr>
  <td>
   CellPhone
  </td>
  <td>
   手机号
  </td>
  <td>
   string
  </td>
 </tr>
</table>

（入参请求Url）如：

http://10.40.3.230:5555/Company/GetFinancingBookInfo?CityCode=SUZHOU&CellPhone=13584859135


### 2、出参说明： ###

<table>
 <tr>
  <td>
   Key
  </td>
  <td>
   value
  </td>
  <td>
   Value类型
  </td>
  <td>
   说明
  </td>
 </tr>
 <tr>
  <td>
   Items
  </td>
  <td>
   融资需求书内网详情信息
  </td>
  <td>
   FinancingBook
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   LNK_NAME
  </td>
  <td>
   姓名
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LNK_SEX
  </td>
  <td>
   性别
  </td>
  <td>
   int
  </td>
  <td>
  0：女、1：男
  </td>
 </tr>
 <tr>
  <td>
   LnkAge
  </td>
  <td>
   年龄（岁）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LNK_MOBILE
  </td>
  <td>
   手机号码
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LnkProvince
  </td>
  <td>
   户籍地（省）
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LnkCity
  </td>
  <td>
   户籍地（市）
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Education
  </td>
  <td>
   学历
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LocalLivedTime
  </td>
  <td>
   本市居住时长
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LNK_IDCARD
  </td>
  <td>
   身份证
  </td>
  <td>
  string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CLT_TYPE
  </td>
  <td>
   您的身份
  </td>
  <td>
  int
  </td>
  <td>
  1：企业主、2：个体户、3：工薪族、4：其它
  </td>
 </tr>
 <tr>
  <td>
   CompanyPost
  </td>
  <td>
   是否法定代表人
  </td>
  <td>
   string
  </td>
  <td>
  1：是、2：否   
  </td>
 </tr>
 <tr>
  <td>
   CMP_NAME
  </td>
  <td>
   企业名称/就职公司名称
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CompanyLocation
  </td>
  <td>
   企业经营地
  </td>
  <td>
   string
  </td>
  <td>
  1：本地、2：外地
  </td>
 </tr>
 <tr>
  <td>
   EnterpriseNature
  </td>
  <td>
   企业性质
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EnterpriseType
  </td>
  <td>
   企业类型
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_TRADE
  </td>
  <td>
   所属行业
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_ADDR
  </td>
  <td>
   企业详细地址
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_SCALE
  </td>
  <td>
   公司规模
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_SALES_AMOUNT
  </td>
  <td>
   年营业额（万元/年）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_INVOICE_AMOUNT
  </td>
  <td>
   全年开票额
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   AmountToProvate
  </td>
  <td>
   月均对私流水
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   AmountToPublic
  </td>
  <td>
   月均对公流水
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LastYearProfit
  </td>
  <td>
   上年度净利润
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LiabilitiesAmount
  </td>
  <td>
   资产负债率
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   YearsOfOperation
  </td>
  <td>
   经营年限
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_SIGN_AMOUNT
  </td>
  <td>
   注册资金
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MASTER_MARRIED
  </td>
  <td>
   婚姻状况
  </td>
  <td>
  int
  </td>
  <td>
  1：已婚、2：未婚、4：其它
  </td>
 </tr>
 <tr>
  <td>
   MASTER_SPOUSE_SIGN
  </td>
  <td>
   配偶能否签字/担保
  </td>
  <td>
  int
  </td>
  <td>
  1：能、2：不能
  </td>
 </tr>
 <tr>
  <td>
   IssuingType
  </td>
  <td>
   收入发放类型
  </td>
  <td>
   string
  </td>
  <td>
  1：全部打卡、2：全部现金、4：部分打卡
  </td>
 </tr>
 <tr>
  <td>
   MonthSalary
  </td>
  <td>
   月均总收入（元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Salary
  </td>
  <td>
   月打卡工资（元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CanProvideProofOfIncome
  </td>
  <td>
   能否提供收入证明
  </td>
  <td>
  byte
  </td>
  <td>
  1：能、2：不能
  </td>
 </tr>
 <tr>
  <td>
   IsSecuityOrFund
  </td>
  <td>
   社保公积金情况
  </td>
  <td>
  byte
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SecuityMonth
  </td>
  <td>
   社保连续缴纳时间
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SecurityMonthPayAmount
  </td>
  <td>
   社保月缴总额（元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   FundMonth
  </td>
  <td>
   公积金连续缴纳时间
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   FundMonthPayAmount
  </td>
  <td>
   公积金月缴总额（元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   WorkProvince
  </td>
  <td>
   工作地所在省
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   WorkCity
  </td>
  <td>
   工作地所在市
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CMP_STYLE
  </td>
  <td>
   就职公司类型
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CompanyWorkYear
  </td>
  <td>
   现单位工作时间
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ShareholdingRatio
  </td>
  <td>
   持股比例
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CompanyPosition
  </td>
  <td>
   职位
  </td>
  <td>
   string
  </td>
  <td>
  高级管理层；中级管理层；基层员工
  </td>
 </tr>
 <tr>
  <td>
   IsOfficalOrganization
  </td>
  <td>
   是否正式编制
  </td>
  <td>
  byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   MASTER_CREDIT
  </td>
  <td>
   个人信用情况
  </td>
  <td>
  int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MasterOverdueStatus
  </td>
  <td>
   个人逾期情况
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MASTER_SPOUSE_CREDIT
  </td>
  <td>
   配偶信用情况
  </td>
  <td>
  int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOverdueStatus
  </td>
  <td>
   配偶逾期情况
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreditCardsCount
  </td>
  <td>
   信用卡总张数（张）
  </td>
  <td>
  int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreditCardsAmount
  </td>
  <td>
   信用卡总额度
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreditCardsAmountUsed
  </td>
  <td>
   信用卡已用额度
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseType
  </td>
  <td>
   房产类别
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseArea
  </td>
  <td>
   房产位置
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseAddr
  </td>
  <td>
   房产地址
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasSpareHouse
  </td>
  <td>
   备用房
  </td>
  <td>
   int
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   HouseSpare
  </td>
  <td>
   房产面积
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseBuyAmount
  </td>
  <td>
   购买总价（万元）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseAssessmentAmount
  </td>
  <td>
   房产估值
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseMortgageStatus
  </td>
  <td>
   房产抵押/按揭状态
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseLoanBalance
  </td>
  <td>
   贷款余额（万元）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseRepayment
  </td>
  <td>
   抵押/按揭月还款额
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseRepaymentMonth
  </td>
  <td>
   抵押/按揭已还月数
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasSpareHouse
  </td>
  <td>
   名下车产情况
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   CarBuyAmount
  </td>
  <td>
   车辆购买价格（万元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarBrandArea
  </td>
  <td>
   牌照归属地
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarBrandAreaProvince
  </td>
  <td>
   牌照归属地（省）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarBrandAreaCity
  </td>
  <td>
   牌照归属地(市)
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarYears
  </td>
  <td>
   车龄（年）
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarYearsDistance
  </td>
  <td>
   行驶里程
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarLoanStatus
  </td>
  <td>
   车产抵押/按揭状态
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarLoanBalance
  </td>
  <td>
   车贷款余额
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RQR_AMOUNT
  </td>
  <td>
   贷款金额（万元）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RQR_DURATION
  </td>
  <td>
   贷款期限（个月）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanCity
  </td>
  <td>
   贷款城市
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MaxAcceptableMonthRate
  </td>
  <td>
   最高可接受月利率（%）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MaxAcceptableServiceRate
  </td>
  <td>
   最高可接受服务费率（%）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RQR_PURPOSE
  </td>
  <td>
   贷款用途
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RQR_RTRN_SOURCE
  </td>
  <td>
   还款来源
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RqrEmergencyDegree
  </td>
  <td>
   需求紧急度
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PAYMENT_DATE
  </td>
  <td>
   用款时间
  </td>
  <td>
   DateTime
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   YearInCome
  </td>
  <td>
   年营业收入
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Shares
  </td>
  <td>
   股权占比
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   UpdateTime
  </td>
  <td>
   更新时间
  </td>
  <td>
   DateTime
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PersonalOver1MonthsCount
  </td>
  <td>
   逾期1个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PersonalOver2MonthsCount
  </td>
  <td>
   逾期2个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PersonalOver3MonthsCount
  </td>
  <td>
   逾期3个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PersonalOver4MonthsCount
  </td>
  <td>
   逾期4个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PersonalOverCountIn2Years
  </td>
  <td>
   近2年内逾期总次数（次）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EnterpriseCreditSituation
  </td>
  <td>
   企业信用情况
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EnterpriseOverdueCount
  </td>
  <td>
   企业逾期总次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EnterpriseMaxOverMonth
  </td>
  <td>
   企业逾期最长时间（个月）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOver1MonthsCount
  </td>
  <td>
   逾期1个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOver2MonthsCount
  </td>
  <td>
   逾期2个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOver3MonthsCount
  </td>
  <td>
   逾期3个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOver4MonthsCount
  </td>
  <td>
   逾期4个月的次数
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SpouseOverCountIn2Years
  </td>
  <td>
   近2年内逾期总次数（次）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PerCreditMaxAmount
  </td>
  <td>
   单张信用卡最高额度
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasHouse
  </td>
  <td>
   名下房产情况
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   HouseProperty
  </td>
  <td>
   房产性质
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CanProvideHouseCertificates
  </td>
  <td>
   能否提供房产证
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HouseAge
  </td>
  <td>
   房龄(月)
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasHouseSharer
  </td>
  <td>
   是否有共有权人
  </td>
  <td>
   byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   IsHouseSharerContainsChildOrOld
  </td>
  <td>
   共有权人是否包含未成年人、老人
  </td>
  <td>
   byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   CanHouseSharerSign
  </td>
  <td>
   所有权利人能否签字
  </td>
  <td>
   byte
  </td>
  <td>
  1：能、2：不能
  </td>
 </tr>
 <tr>
  <td>
   IsSecondCar
  </td>
  <td>
   是否二手车
  </td>
  <td>
   byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   CarMonthRepay
  </td>
  <td>
   抵押/按揭月还款额
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CarRepaiedMonths
  </td>
  <td>
   抵押/按揭已还月数
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasEquipment
  </td>
  <td>
   名下设备情况
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   EquipmentYearLimit
  </td>
  <td>
   设备年限（月）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EquipmentNowAmount
  </td>
  <td>
   设备目前净值（万元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   EquipmentBuyAmount
  </td>
  <td>
   设备购买价格（万元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasEquipmentBill
  </td>
  <td>
   是否有发票
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   EquipmentMortgageStatus
  </td>
  <td>
   设备抵押状态
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasPolicy
  </td>
  <td>
   名下保单情况
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   PolicyType
  </td>
  <td>
   保单类型
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasStopPolicyPay
  </td>
  <td>
   有无中断过缴费
  </td>
  <td>
   byte
  </td>
  <td>
  1：有、2：无
  </td>
 </tr>
 <tr>
  <td>
   PolicyPayType
  </td>
  <td>
   缴费类型
  </td>
  <td>
   byte
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PolicyEffectedTime
  </td>
  <td>
   保单已生效年限（月）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PolicyPaiedMonths
  </td>
  <td>
   已缴纳期数（月）
  </td>
  <td>
   int
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PolicyAmountPaiedPerMonth
  </td>
  <td>
   保单每月缴纳金额（元）
  </td>
  <td>
   double
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasPolicyPaiedOff
  </td>
  <td>
   是否缴满保费
  </td>
  <td>
   byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   PolicyPerson
  </td>
  <td>
   投保人
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   PolicyCompany
  </td>
  <td>
   保险公司
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   HasUnderwriter
  </td>
  <td>
   是否有担保人
  </td>
  <td>
   byte
  </td>
  <td>
  1：是、2：否
  </td>
 </tr>
 <tr>
  <td>
   CustomerDescription
  </td>
  <td>
   客户情况说明
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CustomerSummary
  </td>
  <td>
   客户总结(资质总结)
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ExpertSuggest
  </td>
  <td>
   专家建议
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
</table>


接口返回json值

    {
    "Head": {
        "Ret": 0,
        "Code": "100",
        "Msg": "操作成功!"
    },
    "Content": {
        "Items": [
            {
                "LNK_NAME": "AAC15080301875",
                "LNK_SEX": 1,
                "LnkAge": 39,
                "LNK_MOBILE": "13584859135",
                "LnkProvince": "10",
                "LnkCity": "66",
                "Education": "2",
                "LocalLivedTime": "8",
                "LNK_IDCARD": "",
                "CLT_TYPE": 1,
                "CompanyPost": "1",
                "CMP_NAME": "AAC15080301875有限公司",
                "CompanyLocation": "1",
                "EnterpriseNature": "1",
                "EnterpriseType": "16",
                "CMP_TRADE": "131072",
                "CMP_ADDR": "687977AAC15080301875",
                "CMP_SCALE": 22,
                "CMP_SALES_AMOUNT": 150,
                "CMP_INVOICE_AMOUNT": 4,
                "AmountToProvate": "1",
                "AmountToPublic": "4",
                "LastYearProfit": "2",
                "LiabilitiesAmount": "1",
                "YearsOfOperation": "4",
                "CMP_SIGN_AMOUNT": 16,
                "MASTER_MARRIED": 4,
                "MASTER_SPOUSE_SIGN": 1,
                "IssuingType": "1",
                "MonthSalary": 333,
                "Salary": 303,
                "CanProvideProofOfIncome": null,
                "IsSecuityOrFund": null,
                "SecuityMonth": "0",
                "SecurityMonthPayAmount": 0,
                "FundMonth": "",
                "FundMonthPayAmount": 0,
                "WorkProvince": "10",
                "WorkCity": "66",
                "CMP_STYLE": 32,
                "CompanyWorkYear": "",
                "ShareholdingRatio": "16",
                "CompanyPosition": "",
                "IsOfficalOrganization": null,
                "MASTER_CREDIT": 4,
                "MasterOverdueStatus": "",
                "MASTER_SPOUSE_CREDIT": 4,
                "SpouseOverdueStatus": "",
                "CreditCardsCount": 5,
                "CreditCardsAmount": "128",
                "CreditCardsAmountUsed": "128",
                "HouseType": "1",
                "HouseArea": "",
                "HouseAddr": "",
                "HasSpareHouse": null,
                "HouseSpare": "",
                "HouseBuyAmount": 0,
                "HouseAssessmentAmount": null,
                "HouseMortgageStatus": "",
                "HouseLoanBalance": null,
                "HouseRepayment": "",
                "HouseRepaymentMonth": "",
                "HasCar": 0,
                "CarBuyAmount": 0,
                "CarBrandArea": null,
                "CarBrandAreaProvince": null,
                "CarBrandAreaCity": null,
                "CarYears": "",
                "CarYearsDistance": "",
                "CarLoanStatus": "",
                "CarLoanBalance": null,
                "RQR_AMOUNT": 35,
                "RQR_DURATION": 24,
                "LoanCity": "66",
                "MaxAcceptableMonthRate": 1,
                "MaxAcceptableServiceRate": null,
                "RQR_PURPOSE": "2",
                "RQR_RTRN_SOURCE": "2",
                "RqrEmergencyDegree": "4",
                "PAYMENT_DATE": "/Date(1478707200000)/",
                "YearInCome": "2",
                "Shares": null,
                "UpdateTime": "/Date(1478747307240)/",
                "PersonalOver1MonthsCount": 0,
                "PersonalOver2MonthsCount": 0,
                "PersonalOver3MonthsCount": 0,
                "PersonalOver4MonthsCount": 0,
                "PersonalOverCountIn2Years": 0,
                "EnterpriseCreditSituation": "4",
                "EnterpriseOverdueCount": null,
                "EnterpriseMaxOverMonth": null,
                "SpouseOver1MonthsCount": 0,
                "SpouseOver2MonthsCount": 0,
                "SpouseOver3MonthsCount": 0,
                "SpouseOver4MonthsCount": 0,
                "SpouseOverCountIn2Years": 0,
                "PerCreditMaxAmount": "64",
                "HasHouse": 2,
                "HouseProperty": "",
                "CanProvideHouseCertificates": "",
                "HouseAge": null,
                "HasHouseSharer": null,
                "IsHouseSharerContainsChildOrOld": null,
                "CanHouseSharerSign": null,
                "IsSecondCar": 1,
                "CarMonthRepay": "",
                "CarRepaiedMonths": "",
                "HasEquipment": 2,
                "EquipmentYearLimit": null,
                "EquipmentNowAmount": null,
                "EquipmentBuyAmount": null,
                "HasEquipmentBill": null,
                "EquipmentMortgageStatus": "",
                "HasPolicy": 2,
                "PolicyType": "",
                "HasStopPolicyPay": null,
                "PolicyPayType": null,
                "PolicyEffectedTime": null,
                "PolicyPaiedMonths": null,
                "PolicyAmountPaiedPerMonth": null,
                "HasPolicyPaiedOff": null,
                "PolicyPerson": "",
                "PolicyCompany": "",
                "HasUnderwriter": 2,
                "CustomerDescription": null,
                "CustomerSummary": null,
                "ExpertSuggest": null
            }
            ]
        }
    }


