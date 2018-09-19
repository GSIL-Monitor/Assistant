## 2.1	WebApi接口提供详细 ##

## 2.1.1	统一请求，响应头 ##
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


## 2.1.2	融资超市产品映射关系接口（ImportProductMarketMapping） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市产品映射关系接口
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
  传ImportProductMarketMapping
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
  产品映射Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   ProductId
  </td>
  <td>
   产品Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市编号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   IsActive
  </td>
  <td>
   状态说明
  </td>
  <td>
   int
  </td>
  <td>
  0：默认，1：上架，2：下架
  </td>
 </tr>
 <tr>
  <td>
   RebatePoint
  </td>
  <td>
   返佣比例
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ProviderRebatePoint
  </td>
  <td>
   信贷经理标准返佣率
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SMMTRebatePoint
  </td>
  <td>
   商协会标准返佣率
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ThreePartyRebatePoint
  </td>
  <td>
   三方中介标准返佣率
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   创建时间或者更新时间
  </td>
  <td>
   DateTime
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
    "MsgApi": "ImportProductMarketMapping",
    "MsgData": {
        "ProductId": 1000,
        "SupermarketId": "1000",
        "IsActive": 1,
        "RebatePoint": 1,
        "ProviderRebatePoint":1,
        "SMMTRebatePoint":1,
        "ThreePartyRebatePoint":1,
        "CreateTime": "/Date(1501009577895+0800)/"
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



## 2.1.3	融资超市机构映射关系接口（UpperFirstOrgMarketMapping） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市机构映射关系接口
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
  传UpperFirstOrgMarketMapping
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
  机构映射Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   OrgId
  </td>
  <td>
   机构Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市编号
  </td>
  <td>
   string
  </td>
  <td>
  </td> 
 </tr>
 <tr>
  <td>
   IsActive
  </td>
  <td>
   状态说明
  </td>
  <td>
   int
  </td>
  <td>
  0：默认，1：上架，2：下架
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   创建时间或者更新时间
  </td>
  <td>
   DateTime
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
    "MsgApi": "UpperFirstOrgMarketMapping",
    "MsgData": {
        "OrgId": 1000,
        "SupermarketId": "1000",
        "IsActive": 1,
        "CreateTime": "/Date(1501009577895+0800)/"
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



## 2.1.4	融资超市信息接口（ImportMarketInfo） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市信息接口
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
  传ImportMarketInfo
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
  融资超市信息Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   Id
  </td>
  <td>
   超市Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Name
  </td>
  <td>
   超市名称
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Status
  </td>
  <td>
   超市状态
  </td>
  <td>
   int
  </td>
  <td>
  0:默认，1:运营中，2:待运营，3:已关闭
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   所在城市
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Address
  </td>
  <td>
   地址
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Telephone
  </td>
  <td>
   电话
  </td>
  <td>
   string
  </td>
  <td>
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
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   创建时间或者更新时间
  </td>
  <td>
   DateTime
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
    "MsgApi": "ImportMarketInfo",
    "MsgData": {
        "Id": 1000,
        "Name": "苏州超市",
        "Status": 2,
        "CityCode": ”SUZHOU”,
        "Address": “苏州市工业园区”,
        "Telephone": "051266888888",
        "Remark": "备注",
        "CreateTime": "/Date(1501009577895+0800)/"
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




## 2.1.5	信贷经理和超市映射关系接口（BranchContactMarketMapping） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送信贷经理和超市映射关系接口
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
  传BranchContactMarketMapping
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
  信贷经理映射Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   ProviderId
  </td>
  <td>
   信贷经理Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市编号
  </td>
  <td>
   string
  </td>
  <td>
  </td> 
 </tr>
 <tr>
  <td>
   IsAcceptOrder
  </td>
  <td>
   是否接单
  </td>
  <td>
   int
  </td>
  <td>
  0：否，1：是
  </td>
 </tr>
 <tr>
  <td>
   IsActive
  </td>
  <td>
   状态说明
  </td>
  <td>
   int
  </td>
  <td>
  0：默认，1：有效，2：无效
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   创建时间或者更新时间
  </td>
  <td>
   DateTime
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
    "MsgApi": "BranchContactMarketMapping",
    "MsgData": {
        "ProviderId": 1000,
        "SupermarketId": "1000",
        "IsAcceptOrder":1,
        "IsActive": 1,
        "CreateTime": "/Date(1501009577895+0800)/"
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




## 2.1.6	子订单进度反馈接口（SubOrderProcessFeedback） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市子订单进度反馈接口
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
  传SubOrderProcessFeedback
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
  子订单进程反馈Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   MainOrderId
  </td>
  <td>
   主订单Id
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SubOrderId
  </td>
  <td>
   子订单Id
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   OrderStatus
  </td>
  <td>
   订单状态
  </td>
  <td>
   int
  </td>
  <td>
  1：等待接单；2：过期失效；3：拒绝接单；4 已接单；5：已进件；8：审批通过；10：已经放款；14：待结算；15：已结算；17：已闭单
  </td>
 </tr>
 <tr>
  <td>
   CloseReason
  </td>
  <td>
   闭单原因
  </td>
  <td>
   int
  </td>
  <td>
  （可空，订单状态是17时必填，其他可空）：1：无效电话，2：资料虚假，4：审批拒绝，5：客户取消
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
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ProviderId
  </td>
  <td>
   信贷经理外网ID
  </td>
  <td>
   long
  </td>
  <td>
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
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoadTime
  </td>
  <td>
   放款时间
  </td>
  <td>
   DateTime
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanAmount
  </td>
  <td>
   放款额度
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanPeriod
  </td>
  <td>
   放款期限
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanRate
  </td>
  <td>
   放款利率%
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CreateTime
  </td>
  <td>
   创建时间或者更新时间
  </td>
  <td>
   DateTime
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
    "MsgApi": "SubOrderProcessFeedback",
    "MsgData": {
        "SupermarketId": 1,
        "MainOrderId": "1000",
        "SubOrderId": "1000",
        "OrderStatus": 1,
        "CloseReason": 1,
        "Remark": "备注",
        "ProviderId": 1000,
        "LoadTime": "/Date(1501009577895+0800)/",
        "LoanAmount": 200,
        "LoanPeriod": 2,
        "LoanRate": 1,
        "CreateTime": "/Date(1501009577895+0800)/"
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




## 2.1.7	渠道客户认证信息接口（ChannelCustomerAuthenticationInfo） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市渠道客户注册信息/认证/银行卡接口
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
  传ChannelCustomerAuthenticationInfo
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
  渠道客户认证信息Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   InvitedCode
  </td>
  <td>
   邀请码
  </td>
  <td>
   string
  </td>
  <td>
  可为空
  </td>
 </tr>
  <tr>
  <td>
   InvitedPhone
  </td>
  <td>
   邀请人手机号
  </td>
  <td>
   string
  </td>
  <td>
  可为空
  </td>
 </tr>
 <tr>
  <td>
   PhoneNumber
  </td>
  <td>
   手机号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市Id
  </td>
  <td>
   long
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   所在城市
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Name
  </td>
  <td>
   联系人
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Sex
  </td>
  <td>
   性别
  </td>
  <td>
   int
  </td>
  <td>
  0：女；1：男
  </td>
 </tr>
 <tr>
  <td>
   IdentityCard
  </td>
  <td>
   证件号码
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   Industry
  </td>
  <td>
   所属行业
  </td>
  <td>
   int
  </td>
  <td>
  1：金融，2：房地产，3：汽车，4：其它
  </td>
 </tr>
 <tr>
  <td>
   Banks
  </td>
  <td>
   开户行集合
  </td>
  <td>
   object
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
   AccountName
  </td>
  <td>
   开户名
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   BankName
  </td>
  <td>
   开户银行
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   BankAccount
  </td>
  <td>
   银行账号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   BankBranch
  </td>
  <td>
   开户支行
  </td>
  <td>
   string
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
    "MsgApi": "ChannelCustomerAuthenticationInfo",
    "MsgData": {
        "InvitedCode": "1234567",
        "InvitedCode": "13777427777",
        "PhoneNumber": "13777777777",
        "SupermarketId": 1000,
        "CityCode": "SUZHOU",
        "Name": "张三",
        "Sex": 1,
        "IdentityCard": 320521485748596300000,
        "Industry": 1,
        "Banks": [
            {
                "AccountName": "李四",
                "BankName": "中国银行",
                "BankAccount": "6225521463258574",
                "BankBranch": "普陀支行"
            },
            {
                "AccountName": "李四",
                "BankName": "建设银行",
                "BankAccount": "6225521463258554",
                "BankBranch": "普陀支行"
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




## 2.1.8	甩呗发送提现状态给内网接口（ShuaibeiSendWithdrawalsState） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市甩呗发送提现状态给内网接口
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
  传ShuaibeiSendWithdrawalsState
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
  甩呗发送提现状态信息Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   ApplyBatchNumber
  </td>
  <td>
   申请批次号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ChannelCustomerPhone
  </td>
  <td>
   渠道客户手机号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ChannelCustomerName
  </td>
  <td>
   渠道客户名称
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ApplySettlementSubOrderDetail
  </td>
  <td>
   申请结算订单明细（集合）
  </td>
  <td>
   Object
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
   SubOrderCode
  </td>
  <td>
   子订单号
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ProductName
  </td>
  <td>
   产品名称
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanTime
  </td>
  <td>
   放款时间
  </td>
  <td>
   DateTime
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LoanAmount
  </td>
  <td>
   放款金额(元)
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   RebateRate
  </td>
  <td>
   产品对外返佣(原：返佣比例)
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
  <tr>
  <td>
   RebateRate_Prd
  </td>
  <td>
   产品返佣
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
  <tr>
  <td>
   RebateRate_TraIntroduce
  </td>
  <td>
   转介绍返佣比例
  </td>
  <td>
   decimal
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ApplySubOrderRebateAmount
  </td>
  <td>
   申请订单返佣金额(元)
  </td>
  <td>
   decimal
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
   ApplyDateTime
  </td>
  <td>
   申请日期
  </td>
  <td>
   DateTime
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   ApplyTotalAmount
  </td>
  <td>
   申请总金额(元)
  </td>
  <td>
   decimal
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
    "MsgApi": "ShuaibeiSendWithdrawalsState",
    "MsgData": {
        "ApplyBatchNumber": "123456",
        "ChannelCustomerPhone": "13777424999",
        "ChannelCustomerName": "张三",
        "ApplySettlementSubOrderDetail": [
            {
                "SubOrderCode": "ASD123456",
                "ProductName": "中国银行",
                "LoanTime": "2017-10-31 11:20:12",
                "LoanAmount": "2000.00",
                "RebateRate": "1.22",
                "RebateRate_Prd": "5.00",
                "RebateRate_TraIntroduce": "3.50",
                "ApplySubOrderRebateAmount": "24.40"
            },
            {
                "SubOrderCode": "ASD123456",
                "ProductName": "中国银行",
                "LoanTime": "2017-10-31 11:20:12",
                "LoanAmount": "2000.00",
                "RebateRate": "1.22",
                "RebateRate_Prd": "5.00",
                "RebateRate_TraIntroduce": "3.50",
                "ApplySubOrderRebateAmount": "24.40"
            }
        ],
		"ApplyDateTime": "2017-10-31 11:20:12",
        "ApplyTotalAmount": "4000.00",
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




## 2.1.9	推送甩单客户信息至内网接口（ImportMarketCltBase） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送融资超市甩单客户信息对接
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
  传ImportMarketCltBase
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
  甩单客户信息Model
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   ChannelMobile
  </td>
  <td>
   渠道客户手机号
  </td>
  <td>
   string
  </td>
  <td>
  可为空
  </td>
 </tr>
 <tr>
  <td>
   CityCode
  </td>
  <td>
   贷款城市
  </td>
  <td>
   string
  </td>
  <td>
  城市全拼大写
  </td> 
 </tr>
 <tr>
  <td>
   LnkName
  </td>
  <td>
   甩单客户称呼
  </td>
  <td>
   string
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td>
   LnkMobile
  </td>
  <td>
   甩单客户手机号
  </td>
  <td>
   string
  </td>
  <td>
  </td> 
 </tr>
 <tr>
  <td>
   LnkSex
  </td>
  <td>
   性别
  </td>
  <td>
   int
  </td>
  <td>
  1：男，0：女
  </td> 
 </tr>
 <tr>
  <td>
   RqrAmount
  </td>
  <td>
   需求贷款额度（万元）
  </td>
  <td>
   decimal
  </td>
  <td>
  </td> 
 </tr>
 <tr>
  <td>
   SupermarketId
  </td>
  <td>
   超市ID
  </td>
  <td>
   long
  </td>
  <td>
  </td> 
 </tr>
 <tr>
  <td>
   ShuaiCltType
  </td>
  <td>
   客户甩单类型
  </td>
  <td>
   int
  </td>
  <td>
  1：一健委托，2：自主跟进
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
    "MsgApi": "ImportMarketCltBase",
    "MsgData": {
        "ChannelMobile": "13777777777",
		"CityCode": "SHANGHAI",
        "LnkName": "张三",
        "LnkMobile": "13777777777",
        "LnkSex": 1,
        "RqrAmount": 137.90,
        "SupermarketId": 1000,
        "ShuaiCltType": 1
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




## 2.1.10	校验甩单客户在内网超市是否存在接口（CheckCustomerIsExist） ##
- 接口名称：PushMsg
- 功能简述：外网向内网推送校验甩单客户在内网超市是否存在
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
  传CheckCustomerIsExist
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
  </td>
 </tr>
 <tr>
  <td colspan="4">
  </td>
 </tr>
 <tr>
  <td>
   PhoneNumber
  </td>
  <td>
   甩单客户手机号
  </td>
  <td>
   string
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
    "MsgApi": "CheckCustomerIsExist",
    "MsgData": {
        "PhoneNumber": "13777777777"
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

